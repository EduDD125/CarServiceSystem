package br.edu.ifsp.pw3.api.Concerto;

import br.edu.ifsp.pw3.api.Mecanico.Mecanico;
import br.edu.ifsp.pw3.api.Veiculo.Veiculo;

public record DadosDetalhamentoConcerto(
        Long id,
        String dataentrada,
        String dataSaida,
        Mecanico mecanico,
        Veiculo veiculo,
        boolean ativo
) {
    public DadosDetalhamentoConcerto(Concerto concerto) {
        this(concerto.getId(), concerto.getDataentrada(),
                concerto.getDatasaida(), concerto.getMecanico(),
                concerto.getVeiculo(), concerto.isAtivo());
    }
}
