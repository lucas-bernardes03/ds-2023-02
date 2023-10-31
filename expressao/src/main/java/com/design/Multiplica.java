package com.design;

public class Multiplica implements Expressao{
    private Expressao ex1;
    private Expressao ex2;

    public Multiplica(Expressao e1, Expressao e2){
        this.ex1 = e1;
        this.ex2 = e2;
    }

    @Override
    public float valor() {
        return this.ex1.valor() * this.ex2.valor();
    }
    
}
