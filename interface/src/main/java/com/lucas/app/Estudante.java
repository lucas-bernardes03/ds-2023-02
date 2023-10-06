package com.lucas.app;

import java.util.ArrayList;
import java.util.List;

public class Estudante {
    private String nome;
    private String sobrenome;
    private int idade;
    private List<Double> notas;
    private Double media;

    public Estudante(String nome, String sobrenome, int idade, List<Double> notas, double media) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.notas = notas;
        this.media = media; 
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public List<Double> getNotas() {
        return notas;
    }

    public void setNotas(List<Double> notas) {
        if(this.notas == null) this.notas = new ArrayList<>();
        else this.notas = notas;
    }

    public double getMedia() {
        if(this.media == null || this.media == 0.0) this.setMedia();
        return media;
    }

    public void setMedia(){
        double sum = 0;
        if(notas != null && notas.size() > 0){
            for(double n : notas){
                sum += n;
            }
            this.media = sum / notas.size();
        }
        else this.media = 0.0;
    }


}
