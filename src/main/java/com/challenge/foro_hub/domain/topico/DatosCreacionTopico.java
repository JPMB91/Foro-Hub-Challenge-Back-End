package com.challenge.foro_hub.domain.topico;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record DatosCreacionTopico(
        @NotBlank
        @Size(max = 100)
        String titulo,
        @NotBlank
        @Size(min = 1, max = 1000)
        String mensaje,

        @NotBlank
        String curso
) {


}
