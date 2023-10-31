package com.design;

public class App {
    public static void main(String[] args) {
        Expressao e = new Soma(new Constante(5),new Multiplica(new Constante(2), new Constante(3)));
        System.out.println("Resultado: " + e.valor());
    }
}
