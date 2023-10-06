package com.lucas;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import com.lucas.app.Estudante;
import com.lucas.app.StudentUtils;
import com.lucas.app.StudentUtilsImpl;


public class AppTest {
    StudentUtils studentUtils = new StudentUtilsImpl();

    Estudante estudante1 = new Estudante("João", "Silva", 20, Arrays.asList(8.5, 7.5, 9.0), 0.0);
    Estudante estudante2 = new Estudante("Maria", "Santos", 22, Arrays.asList(7.8, 8.0, 7.2), 0.0);
    
    @Test
    public void ordenacaoPorNomeCrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorNomeCrescente(lista);

        assertEquals("João", lista.get(0).getNome());
        assertEquals("Maria", lista.get(1).getNome());
    }

    @Test
    public void ordenacaoPorNomeDecrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorNomeDecrescente(lista);

        assertEquals("Maria", lista.get(0).getNome());
        assertEquals("João", lista.get(1).getNome());
    }

    @Test
    public void ordenacaoPorSobrenomeCrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorSobrenomeCrescente(lista);

        assertEquals("Santos", lista.get(0).getSobrenome());
        assertEquals("Silva", lista.get(1).getSobrenome());
    }

    @Test
    public void ordenacaoPorSobrenomeDecrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorSobrenomeDecrescente(lista);

        assertEquals("Silva", lista.get(0).getSobrenome());
        assertEquals("Santos", lista.get(1).getSobrenome());
    }

    @Test
    public void ordenacaoPorIdadeCrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorIdadeCrescente(lista);

        assertEquals(20, lista.get(0).getIdade());
        assertEquals(22, lista.get(1).getIdade());
    }

    @Test
    public void ordenacaoPorIdadeDecrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorIdadeDecrescente(lista);

        assertEquals(22, lista.get(0).getIdade());
        assertEquals(20, lista.get(1).getIdade());
    }

    @Test
    public void ordenacaoPorMediaCrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorMediaCrescente(lista);

        assertEquals(7.66, lista.get(0).getMedia(), 0.01);
        assertEquals(8.33, lista.get(1).getMedia(), 0.01);
    }

    @Test
    public void ordenacaoPorMediaDecrescente() {
        List<Estudante> lista = Arrays.asList(estudante1,estudante2);

        studentUtils.ordenarPorMediaDecrescente(lista);

        assertEquals(8.33, lista.get(0).getMedia(), 0.01);
        assertEquals(7.66, lista.get(1).getMedia(), 0.01);
    }

}
