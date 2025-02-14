package com.test.taller4.models;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CuentaBancaria {
    private Long cuentaId;
    private Documento documento;
    private Long numeroCuenta;
    private Double saldo;
    private LocalDate fechaCreacion;
}