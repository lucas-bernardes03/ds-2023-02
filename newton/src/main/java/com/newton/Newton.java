package com.newton;

public class Newton {
    static double calculaRaiz(double num, double erro){
        double x = num;
        double raiz;
     
        while (true){

            // próxima aproximação
            raiz = 0.5 * (x + (num / x));
     
            // checa a proximidade baseado na tolerancia definida
            if (Math.abs(raiz - x) < erro)
                break;
     
            // atualiza a raiz
            x = raiz;
        }
        
        return raiz;
    }
     

    public static void main (String[] args){
        double num = 4;
        double erro = 0.00001;
     
        System.out.println("A raiz de " + num + " e aproximadamente: " + calculaRaiz(num, erro));
    }
}
