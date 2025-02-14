package com.test.taller4.services;

import com.test.taller4.models.Documento;

public interface IDocumentoService {

    Documento nuevoDocumento(Documento documento);
    Boolean existeDocumento(Long documentoId);
    Documento getDocumento(Long documentoId);
    Boolean eliminarDocumento(Long documentoId);
}
