package com.challenge.foro_hub.domain.topico;

import com.challenge.foro_hub.domain.respuesta.DatosRespuesta;

import java.time.LocalDateTime;
import java.util.List;

public record DatosDetalleTopico(
        Long id,
        String titulo,
        String mensaje,
        LocalDateTime fechaCreacion,
        Status status,
        String nombreUsuario,
        String curso,
        List<DatosRespuesta> respuestas
) {
    public DatosDetalleTopico(Topico topico) {
        this(
                topico.getId(),
                topico.getTitulo(),
                topico.getMensaje(),
                topico.getFechaCreacion(),
                topico.getStatus(),
                topico.getUsuario().getNombre(),
                topico.getCurso(),
                topico.getRespuestas() != null ?
                        topico.getRespuestas().stream()
                                .map(DatosRespuesta::new)
                                .toList() : List.of()
        );
    }

}