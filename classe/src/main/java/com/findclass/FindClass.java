package com.findclass;

import java.io.File;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.stream.Stream;

public class FindClass {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso: java FindClass <nome da classe> <dir> [-p]");
            return;
        }

        //le os argumentos do terminal e define o nome e diretorio a ser procurado, alem de usar parallel ou nao
        String className = args[0];
        File directory = new File(args[1]);
        boolean useParallelStream = args.length > 2 && args[2].equals("-p");

        //comeca a contagem do tempo
        long startTime = System.nanoTime();

        //comeca a busca dos arquivos
        List<File> classFiles = findClassFiles(directory, className, useParallelStream);

        long endTime = System.nanoTime();
        long elapsedTime = TimeUnit.NANOSECONDS.toMillis(endTime - startTime);

        if (classFiles.isEmpty()) {
            System.out.println("A classe nao foi encontrada em nenhum arquivo .class, .jar ou .war.");
        } else {
            System.out.println("A classe foi encontrada nos seguintes locais:");
            for (File file : classFiles) {
                System.out.println(file.getAbsolutePath());
            }
        }

        System.out.println("Tempo gasto: " + elapsedTime + " ms");
        System.out.println("Numero de arquivos .class consultados: " + classFiles.size());
    }

    private static List<File> findClassFiles(File directory, String className, boolean useParallelStream) {
        List<File> result = new ArrayList<>();

        //chama a funcao de listar todos os arquivos do diretorio e filtra eles
        try (Stream<File> fileStream = listAllFiles(directory, useParallelStream)) {
            fileStream.forEach(file -> {
                if (file.getName().endsWith(".class")) {
                    String classFileName = file.getName().substring(0, file.getName().length() - 6);
                    String classFilePath = file.getPath().replace(File.separator, ".");
                    if (classFilePath.contains(className) || classFileName.contains(className)) {
                        result.add(file);
                    }
                }

                if(file.getName().endsWith(".jar") || file.getName().endsWith(".war")){
                    try{
                        buscarClasseJarWar(file, result, className);
                    }
                    catch (IOException e){
                        e.printStackTrace();
                    }
                }

            });
        } catch (IOException e) {
            e.printStackTrace();
        }

        return result;
    }

    // define qual metodo utilizar
    private static Stream<File> listAllFiles(File directory, boolean useParallelStream) throws IOException {
        if (useParallelStream) {
            return listAllFilesParallel(directory);
        } else {
            return listAllFilesSequential(directory);
        }
    }


    //busca em um diretório todos os seus arquivos, caso o arquivo seja um novo diretório ele entra e recursivamente inicia uma nova busca
    private static Stream<File> listAllFilesParallel(File directory) throws IOException {
        return Stream.of(directory.listFiles())
                .parallel()
                .flatMap(file -> {
                    if (file.isDirectory()) {
                        try {
                            return listAllFilesParallel(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return Stream.empty();
                        }
                    } else {
                        return Stream.of(file);
                    }
                });
    }


    private static Stream<File> listAllFilesSequential(File directory) throws IOException {
        return Stream.of(directory.listFiles())
                .flatMap(file -> {
                    if (file.isDirectory()) {
                        try {
                            return listAllFilesSequential(file);
                        } catch (IOException e) {
                            e.printStackTrace();
                            return Stream.empty();
                        }
                    } else {
                        return Stream.of(file);
                    }
                });
    }


    //busca as classes dentro dos arquivos .jar e .war
    private static void buscarClasseJarWar(File file, List<File> result, String className) throws IOException{
        Set<String> classNames = new HashSet<>();
        try {
            JarFile jarFile = new JarFile(file);
            Enumeration<JarEntry> entries = jarFile.entries();

            while(entries.hasMoreElements()){
                JarEntry jarEntry = entries.nextElement();
                if(jarEntry.getName().endsWith(".class")){
                    String name = jarEntry.getName().replace("/", ".");
                    name = name.substring(0, name.length() - 6);
                    classNames.add(name);
                }
            }

            if(classNames.contains(className)) result.add(file);

            jarFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

