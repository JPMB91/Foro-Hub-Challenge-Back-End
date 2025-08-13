package com.challenge.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public record DatosCreacionTopico(
        @NotBlank
        @Size(max = 100)
        String titulo,
        @NotBlank
        @Size(min = 1, max = 1000)
        String mensaje,
        @NotNull Long usuarioId,
        @NotBlank
        String curso
) {

    public DatosCreacionTopico(Topico topico) {
        this(
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getUsuario().getId(),
                topico.getCurso()
        );
    }

}
