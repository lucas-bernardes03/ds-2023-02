package com.design;

import java.util.Date;

public class Main {
    public static void main(String[] args) {
        Carro celtinha = new Carro("Celtinha", 1200.00);

        Colecionador c = new Colecionador("lucas", "bacharel", new Date());
        Carro carro = new Carro("fieste", 92350.00);

        celtinha.addObserver(c);
        celtinha.addObserver(carro);

        celtinha.alterarPreco(26000.00);
    }
}
