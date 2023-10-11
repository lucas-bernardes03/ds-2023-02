package com.planilha;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.junit.Test;


public class CelulaTest {
    @Test
    public void testPlanilha() {
        Celula A1 = new Celula("A1", 10);
        Celula A2 = new Celula("A2", 15);
        Celula A3 = new Celula("A3", 0);

        A1.addObserver(A3);
        A2.addObserver(A3);

        A1.definirValor(20);
        assertEquals(A1.getValor(), A3.getValor());

        A2.definirValor(30);
        assertNotEquals(A2.getValor(), A3.getValor());

        assertEquals((Integer)(A1.getValor() + A2.getValor()), A3.getValor());
    }
}
