package com.challenge.foro_hub.domain.respuesta;

import java.time.LocalDateTime;

public record DatosRespuesta(

        Long id,
        String mensaje,
        String nombreAutor,
        LocalDateTime fechaCreacion,
        boolean solucion
) {

    public DatosRespuesta(Respuesta respuesta){
        this(
                respuesta.getId(),
                respuesta.getMensaje(),
                respuesta.getUsuario().getNombre(),
                respuesta.getFechaCreacion(),
                respuesta.isSolucion()
        );
    }
}
