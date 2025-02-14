package com.test.taller4.testUnitarios;

import com.test.taller4.models.Cliente;
import com.test.taller4.models.CuentaBancaria;
import com.test.taller4.models.Documento;
import com.test.taller4.services.CuentaBancariaService;
import com.test.taller4.services.ICuentaBancariaService;
import com.test.taller4.services.IInversionVirtualService;
import com.test.taller4.models.InversionVirtual;
import com.test.taller4.services.InversionVirtualService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.anyDouble;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InversionVirtualTest {

    private IInversionVirtualService inversion;
    private ICuentaBancariaService cuenta;

    private Cliente juan;

    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;

    private Documento documentoJuan;

    private InversionVirtual inversionDeJuan;

    @BeforeEach
    void setUp() {
        inversion = new InversionVirtualService();
        cuenta = mock(CuentaBancariaService.class);



        //Clientes
        juan = Cliente.builder()
                .nombre("Juan Esteban Hernandez")
                .fechaVinculacion(LocalDate.now())
                .build();

        documentoJuan = Documento.builder()
                .documentoId(1L)
                .cliente(juan)
                .numeroDoc("1234567891")
                .tipo("CC")
                .build();

        cuentaOrigen = CuentaBancaria.builder()
                .cuentaId(1L)
                .documento(documentoJuan)
                .numeroCuenta(85632142L)
                .saldo(1000000.0)
                .fechaCreacion(LocalDate.now())
                .build();

        cuentaDestino = CuentaBancaria.builder()
                .cuentaId(2L)
                .documento(documentoJuan)
                .numeroCuenta(77777777L)
                .saldo(0.0)
                .fechaCreacion(LocalDate.now())
                .build();

        inversionDeJuan = InversionVirtual.builder()
                .inversionId(111L)
                .cuentaOrigen(cuentaOrigen)
                .cuentaDestino(cuentaDestino)
                .cliente(juan)
                .valor(500000.0)
                .fechaCreacion(LocalDate.now())
                .tiempoDuracion(90L)
                .build();
    }

    @Test
    void nuevaInversion() {

//        when(cuenta.saldoCuenta(anyLong(), anyDouble())).thenReturn(true);
        when(cuenta.saldoCuenta(anyLong(), anyDouble())).thenAnswer(invoc -> {
            Long cuentaId = invoc.getArgument(0);
            Double valorInvertir = invoc.getArgument(1);
            return cuentaOrigen.getSaldo() >= valorInvertir;
        });

        Boolean saldoSuficiente = cuenta.saldoCuenta(cuentaOrigen.getCuentaId(), inversionDeJuan.getValor());

        assertTrue(saldoSuficiente);

        Boolean inversionMinima = inversion.validarInversionMinima(inversionDeJuan.getValor());

        assertTrue(inversionMinima);

        InversionVirtual invDeJuan = inversion.nuevaInversion(inversionDeJuan);

        InversionVirtual inversionObtenida = inversion.getInversionById(invDeJuan.getInversionId());
        assertEquals(inversionObtenida.getInversionId(), 111L);
        assertEquals(inversionObtenida.getCliente(), juan);
        assertEquals(inversionObtenida.getCuentaOrigen(), cuentaOrigen);

    }
}
