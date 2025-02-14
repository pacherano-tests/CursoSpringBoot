package com.test.taller4.models;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InversionVirtual {
    private Long inversionId;
    private CuentaBancaria cuentaOrigen;
    private CuentaBancaria cuentaDestino;
    private Cliente cliente;
    private Double valor;
    private LocalDate fechaCreacion;
    private Long tiempoDuracion;
}
