package com.design;

public class Soma implements Expressao{
    private Expressao ex1;
    private Expressao ex2;

    public Soma(Expressao ex1, Expressao ex2){
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    @Override
    public float valor() {
        return this.ex1.valor() + this.ex2.valor();
    }
    
}
