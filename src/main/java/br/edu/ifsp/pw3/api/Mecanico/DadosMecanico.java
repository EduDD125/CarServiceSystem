package br.edu.ifsp.pw3.api.Mecanico;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosMecanico(
        @NotNull
        @Pattern(regexp = "^[a-zA-Z]{1,40}")
        String nome,
        @NotNull
        int experiencia
) {
}
