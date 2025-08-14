package com.challenge.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record DatosActualizacionTopico(
        @NotBlank
        String titulo,
        @NotBlank
        String mensaje
) {
}
