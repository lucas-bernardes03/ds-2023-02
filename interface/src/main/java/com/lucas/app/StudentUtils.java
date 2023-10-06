package com.lucas.app;

import java.util.List;

public interface StudentUtils {
    public void ordenarPorNomeCrescente(List<Estudante> lista);
    public void ordenarPorNomeDecrescente(List<Estudante> lista);

    public void ordenarPorSobrenomeCrescente(List<Estudante> lista);
    public void ordenarPorSobrenomeDecrescente(List<Estudante> lista);

    public void ordenarPorIdadeCrescente(List<Estudante> lista);
    public void ordenarPorIdadeDecrescente(List<Estudante> lista);

    public void ordenarPorMediaCrescente(List<Estudante> lista);
    public void ordenarPorMediaDecrescente(List<Estudante> lista);

    public void imprimirEstudantes(List<Estudante> lista);


}
