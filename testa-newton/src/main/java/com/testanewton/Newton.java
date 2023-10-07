package com.testanewton;

import java.util.function.Function;

public class Newton implements Function<Double,Double>{
    static double calculaRaiz(double num){
        double erro = 1e-6;
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

    @Override
    public Double apply(Double arg0) {
        return calculaRaiz(arg0);
    }
}