package com.test.taller4.services;

import com.test.taller4.models.InversionVirtual;

public interface IInversionVirtualService {
    InversionVirtual nuevaInversion(InversionVirtual inversion);
    Boolean reclamarInversion(Long inversionId);

    Boolean validarInversionMinima(Double valorInversion);

    InversionVirtual getInversionById(Long inversionId);
}
