package com.design;

public class Divide implements Expressao{
    private Expressao ex1;
    private Expressao ex2;

    public Divide (Expressao ex1, Expressao ex2){
        this.ex1 = ex1;
        this.ex2 = ex2;
    }

    @Override
    public float valor(){
        if(this.ex2.valor() == 0) throw new ArithmeticException("Nao e possivel realizar a divisao quando o denominador possui o valor de 0");
        return this.ex1.valor() / this.ex2.valor();
    }
}
