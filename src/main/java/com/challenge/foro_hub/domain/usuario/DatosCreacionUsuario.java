package com.challenge.foro_hub.domain.usuario;

import jakarta.validation.constraints.*;

public record DatosCreacionUsuario(
        @NotBlank(message = "El nombre no puede quedar en blanco")
        @Size(min = 3, max = 45, message = "El nombre debe tener entre 3 y 25 caracteres")
        String nombre,

        @NotBlank(message = "El email no puede quedar en blanco")
        @Email
        String email,

        @NotBlank(message = "La contraseña no puede quedar en blanco")
        @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).*$", message = "La contraseña debe tener minimo una " +
                "mayúscula y un número")
        @Size(min = 6, max = 30)
        @NotNull String password) {
}
