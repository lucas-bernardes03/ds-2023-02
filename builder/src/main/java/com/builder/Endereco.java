package com.builder;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class Endereco {
    private String rua;
    private String setor;
    private String cep;
    private int numero;
    private String cidade;
    private String estado;
    private String bloco;
    private String quadra;
}
