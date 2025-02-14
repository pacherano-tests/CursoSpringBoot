package com.test.taller4.models;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    private Long clienteId;
    private String nombre;
    private List<Documento> documentos;
    private List<CuentaBancaria> cuentas;
    private List<InversionVirtual> inversiones;
    private LocalDate fechaVinculacion;

    public Double getTotalSaldo() {
        return 0.0;//calcular total del saldo de las cuentas bancarias + inversiones
    }
}