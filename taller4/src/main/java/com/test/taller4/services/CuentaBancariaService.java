package com.test.taller4.services;

import com.test.taller4.models.CuentaBancaria;

public class CuentaBancariaService implements ICuentaBancariaService{
    @Override
    public CuentaBancaria nuevaCuentaBancaria(CuentaBancaria cuenta) {
        return null;
    }

    @Override
    public CuentaBancaria transaccion(Double monto, Long cuentaId) {
        return null;
    }

    @Override
    public Boolean eliminarCuenta(Long cuentaId) {
        return null;
    }

    @Override
    public Boolean saldoCuenta(Long cuentaId, Double valorInvertir) {
        return null;
    }
}
