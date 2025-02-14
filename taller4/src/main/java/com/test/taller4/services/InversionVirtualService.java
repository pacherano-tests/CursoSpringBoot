package com.test.taller4.services;

import com.test.taller4.models.InversionVirtual;

public class InversionVirtualService implements IInversionVirtualService {
    @Override
    public com.test.taller4.models.InversionVirtual nuevaInversion(com.test.taller4.models.InversionVirtual inversion) {
        return null;
    }

    @Override
    public Boolean reclamarInversion(Long inversionId) {
        return null;
    }

    @Override
    public Boolean validarInversionMinima(Double valorInversion) {
        return valorInversion >= 50000.0;
    }

    @Override
    public InversionVirtual getInversionById(Long inversionId) {
        return null;
    }
}
