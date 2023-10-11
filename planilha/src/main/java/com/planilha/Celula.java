package com.planilha;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Celula {
    private String nome;
    private Integer valor;
    private List<Celula> observers = new ArrayList<>();

    public Celula(String nome, Integer valor){
        this.nome = nome;
        this.valor = valor;
    }

    public void addObserver(Celula o){
        observers.add(o);
    }

    public void removeObserver(Celula o){
        if(observers.contains(o)) observers.remove(o);
    }

    public void definirValor(int novoValor){
        if(valor != novoValor){
            this.valor = novoValor;
            notificarObservadores();
        }
    }

    private void notificarObservadores(){
        for(Celula c : observers){
            System.out.println("Reavaliar " + c.getNome() + " por mudança ocorrida em " + nome);
            c.reavaliar(this.valor);
        }
    }

    private void reavaliar(int valor){
        if(this.valor == null) this.valor = 0;
        this.valor += valor;
    }
}
