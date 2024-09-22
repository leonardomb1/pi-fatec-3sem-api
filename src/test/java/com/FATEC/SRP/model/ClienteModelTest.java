package com.FATEC.SRP.model;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ClienteModelTest {

    @Test
    public void testClienteModel() {
        ClienteModel cliente = new ClienteModel(1, true, "Banco do Brasil", "1234");
        assertEquals(1, cliente.getIdPessoa());
        assertTrue(cliente.getBoolECandidato());
        assertEquals("Banco do Brasil", cliente.getBanco());
        assertEquals("1234", cliente.getAgencia());
    }
}