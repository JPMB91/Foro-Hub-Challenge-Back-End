package com.challenge.foro_hub.domain.topico;

import java.time.LocalDateTime;

public record DatosListadoTopico(
        Long id,
        String titulo,

        String mensaje,
        String usuario,
        LocalDateTime fechaCreacion,
        Status status,
        Integer numeroRespuestas
) {

    public DatosListadoTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getUsuario().getNombre(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getRespuestas() != null ? topico.getRespuestas().size() : 0
        );
    }
}
