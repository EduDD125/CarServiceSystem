package br.edu.ifsp.pw3.api.Mecanico;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Mecanico {
    private String nome;
    private Integer experiencia;

    public Mecanico(DadosMecanico dados) {
        this.nome = dados.nome();
        this.experiencia = dados.experiencia();
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }
}
