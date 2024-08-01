package br.edu.ifsp.pw3.api.Concerto;

import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoConcerto(
        @NotNull
        Long id,
        String dataSaida,
        String nomeMecanico,
        Integer anosExperiencia
) { }
