package br.edu.ifsp.pw3.api.Concerto;

import br.edu.ifsp.pw3.api.Veiculo.MarcaCarro;
import br.edu.ifsp.pw3.api.Veiculo.ModeloCarro;

public record DadosListagemConcerto(
        Long id,
        String dataentrada,
        String datasaida,
        String nome,
        MarcaCarro marca,
        ModeloCarro modelo,
        boolean ativo
) {
    public DadosListagemConcerto (Concerto concerto) {

        this( concerto.getId(), concerto.getDataentrada(), concerto.getDatasaida(), concerto.getMecanico().getNome(), concerto.getVeiculo().getMarca(), concerto.getVeiculo().getModelo(), concerto.isAtivo());
    }

    public boolean ativo() {
        return this.ativo;
    }
}
