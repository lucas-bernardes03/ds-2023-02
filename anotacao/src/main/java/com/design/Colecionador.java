package com.design;

import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Observer(observado = "com.design.Carro")
public class Colecionador{
    private String nome;
    private String formacao;
    private Date dataNascimento ;
}