package br.edu.ifsp.pw3.api.Veiculo;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosVeiculos(
        @NotNull
        MarcaCarro marca,
        @NotNull
        ModeloCarro modelo,
        @Pattern(regexp = "[0-9]{4}")
        String ano,
        @NotBlank
        String cor
) {
}
