package com.design;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {

    @Test
    public void validaExpressao() {
        Expressao e = new Soma(new Constante(5),new Multiplica(new Constante(2), new Constante(3)));
        assertTrue(e.valor() == Float.parseFloat("11"));
    }
}
