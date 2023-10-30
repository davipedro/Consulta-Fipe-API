package br.com.fipeconsulta.fipeconsulta.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosMarcas(String codigo,
                          String nome) {
    @Override
    public String toString() {
        return String.format("Código: %3s Nome: %s", codigo(), nome());
    }
}
