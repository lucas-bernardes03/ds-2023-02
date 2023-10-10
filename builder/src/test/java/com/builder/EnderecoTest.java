package com.builder;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class EnderecoTest {
   
    @Test
    public void testBuilder() {
        Endereco e = Endereco.builder().rua("Rua lima").cep("76234563").build();

        assertEquals(e.getRua(), "Rua lima");
        assertEquals(e.getCep(),"76234563");
        assertEquals(e.getClass(), Endereco.class);
    }

    @Test
    public void testEquals(){
        Endereco e = new Endereco("Rua cala", "bonifacio", "76243243", 123, "anali","Goias",null,null);
        Endereco e2 = Endereco.builder().rua("Rua cala").setor("bonifacio").cep("76243243").numero(123).cidade("anali").estado("Goias").build();

        assertEquals(e, e2);
    }
}
