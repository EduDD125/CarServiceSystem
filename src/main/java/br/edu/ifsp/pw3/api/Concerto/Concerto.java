package br.edu.ifsp.pw3.api.Concerto;

import br.edu.ifsp.pw3.api.Mecanico.DadosMecanico;
import br.edu.ifsp.pw3.api.Mecanico.Mecanico;
import br.edu.ifsp.pw3.api.Veiculo.Veiculo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name="concertos")
@Entity(name="Concertos")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Concerto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String dataentrada;
    private String datasaida;
    @Embedded
    private Mecanico mecanico;
    @Embedded
    private Veiculo veiculo;
    private boolean ativo;

    public Concerto(DadosCadastroConcerto dados) {
        this.dataentrada = dados.dataentrada();
        this.datasaida = dados.datasaida();
        this.mecanico = new Mecanico(dados.mecanico());
        this.veiculo = new Veiculo(dados.veiculo());
        this.ativo = true;
    }

    public void atualizarInformacoes(DadosAtualizacaoConcerto dados) {
        if(dados.dataSaida() != null) {
            this.datasaida = dados.dataSaida();
        }
        if(dados.nomeMecanico() != null) {
            this.mecanico.setNome(dados.nomeMecanico());
        }
        if (dados.anosExperiencia() != null) {
            this.mecanico.setExperiencia(dados.anosExperiencia());
        }
    }

    public void excluir() {
        this.ativo = false;
    }
}
