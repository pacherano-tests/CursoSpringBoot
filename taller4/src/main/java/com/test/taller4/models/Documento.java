package com.test.taller4.models;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Documento {
    private Long documentoId;
    private Cliente cliente;
    private String numeroDoc;
    private String tipo;
}