package br.edu.ifsp.pw3.api.Concerto;

import br.edu.ifsp.pw3.api.Mecanico.DadosMecanico;
import br.edu.ifsp.pw3.api.Veiculo.DadosVeiculos;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

public record DadosCadastroConcerto (
        @NotNull
        @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}")
        String dataentrada,
        @NotNull
        @Pattern(regexp = "^(0[1-9]|[1-2][0-9]|3[0-1])/(0[1-9]|1[0-2])/[0-9]{4}")
        String datasaida,
        @NotNull
        @Valid
        DadosMecanico mecanico,
        @NotNull
        @Valid
        DadosVeiculos veiculo,

        @NotNull
        boolean id
) {
}
