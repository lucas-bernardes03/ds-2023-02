package com.design;

import java.util.ArrayList;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
public class Carro {
    private String modelo;
    private Double preco;
    private List<Object> observadores = new ArrayList<>();

    public Carro(String modelo, Double preco){
        this.modelo = modelo;
        this.preco = preco;
    }

    public void alterarPreco(Double preco){
        this.preco = preco;
        notifyObservers();
    }

    public void addObserver(Object o){
        if(this.observadores == null) this.observadores = new ArrayList<>();
        this.observadores.add(o);
    }

    private void notifyObservers(){
        observadores.forEach(o -> {
            Class<?> clazz = this.getClass();
            if(o.getClass().isAnnotationPresent(Observer.class)){
                String observer = o.getClass().getAnnotation(Observer.class).observado();
                if(observer.equals(clazz.getName())){
                    System.out.println("Atencao " + o.getClass().getName() + " o preco do carro foi alterado!");
                }
            }
        });
    }

}

