package com.testanewton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;


public class NewtonTest {
    @Test
    public void testCalcularRaizQuadrada() {
        int numero = 16;
        double erro = 0.00001;
        double resultadoEsperado = 4.0; // A raiz quadrada de 16 é 4
        
        double resultadoReal = Newton.calculaRaiz(numero);

        assertEquals(resultadoEsperado, resultadoReal, erro);
    }

    @Test
    public void testCalcularRaizQuadradaComErroAlto() {
        double numero = 25;
        double erro = 1;
        double resultadoEsperado = 5.0; // A raiz quadrada de 25 é 5

        double resultadoReal = Newton.calculaRaiz(numero);

        assertEquals(resultadoEsperado, resultadoReal, erro);
    }

    @Test
    public void testCalcularRaizQuadradaComErroPequeno() {
        double numero = 100;
        double erro = 1e-9;
        double resultadoEsperado = 10.0; // A raiz quadrada de 100 é 10

        double resultadoReal = Newton.calculaRaiz(numero);

        assertEquals(resultadoEsperado, resultadoReal, erro);
    }

    @Test
    public void testCalcularRaizQuadradaNumeroNaoInteiro() {
        double numero = 72.23;
        double erro = 0.00001;
        double resultadoEsperado = 8.49882344798; // A raiz quadrada de 100 é 10

        double resultadoReal = Newton.calculaRaiz(numero);

        assertEquals(resultadoEsperado, resultadoReal, erro);
    }

    
}