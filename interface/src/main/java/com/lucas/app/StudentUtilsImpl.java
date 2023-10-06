package com.lucas.app;

import java.util.Comparator;
import java.util.List;

public class StudentUtilsImpl implements StudentUtils{

    @Override
    public void ordenarPorNomeCrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return o1.getNome().compareTo(o2.getNome());
            }
        });
    }

    @Override
    public void ordenarPorNomeDecrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return o2.getNome().compareTo(o1.getNome());
            }
        });
    }

    @Override
    public void ordenarPorSobrenomeCrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return o1.getSobrenome().compareTo(o2.getSobrenome());
            }
        });
    }

    @Override
    public void ordenarPorSobrenomeDecrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return o2.getSobrenome().compareTo(o1.getSobrenome());
            }
        });
    }

    @Override
    public void ordenarPorIdadeCrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return Integer.compare(o1.getIdade(), o2.getIdade());
            }
        });
    }

    @Override
    public void ordenarPorIdadeDecrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return Integer.compare(o2.getIdade(), o1.getIdade());
            }
        });
    }

    @Override
    public void ordenarPorMediaCrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return Double.compare(o1.getMedia(), o2.getMedia());
            }
        });
    }

    @Override
    public void ordenarPorMediaDecrescente(List<Estudante> lista) {
        lista.sort(new Comparator<Estudante>() {
            @Override
            public int compare(Estudante o1, Estudante o2){
                return Double.compare(o2.getMedia(), o1.getMedia());
            }
        });
    }
    
    @Override
    public void imprimirEstudantes(List<Estudante> lista){
        StringBuilder sb = new StringBuilder();
        for(Estudante e : lista){
            sb.append("Nome: " + e.getNome() + "\n");
            sb.append("Sobrenome: " + e.getSobrenome() + "\n");
            sb.append("Idade: " + e.getIdade() + "\n");
            sb.append("Media: " + e.getMedia() + "\n");
            sb.append("\n");
        } 
        System.out.println(sb.toString());
    }
}
