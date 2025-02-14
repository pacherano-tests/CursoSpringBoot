package com.test.taller4.services;

import com.test.taller4.models.CuentaBancaria;

public interface ICuentaBancariaService {

    CuentaBancaria nuevaCuentaBancaria(CuentaBancaria cuenta);
    CuentaBancaria transaccion(Double monto, Long cuentaId);
    Boolean eliminarCuenta(Long cuentaId);

    Boolean saldoCuenta(Long cuentaId, Double valorInvertir);
}
