package br.edu.ifsp.pw3.api.Veiculo;

import jakarta.persistence.Embeddable;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Veiculo {
    @Enumerated(EnumType.STRING)
    private MarcaCarro marca;
    @Enumerated(EnumType.STRING)
    private ModeloCarro modelo;
    private String ano;
    private String cor;

    public Veiculo(DadosVeiculos dados) {
        this.marca = dados.marca();
        this.modelo = dados.modelo();
        this.ano = dados.ano();
        this.cor = dados.cor();
    }
}
