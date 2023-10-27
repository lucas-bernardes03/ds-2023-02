package com.design;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class ObserverTest {

    @Test
    public void checandoAnotacaoTest() {
        Class<?> clazz = ExibicaoCarro.class;
        Observer observerAnnotation = clazz.getAnnotation(Observer.class);

        if (observerAnnotation != null) {
            String observado = observerAnnotation.observado();
            assertEquals("es.design.Carro", observado);
        }
    }
}
