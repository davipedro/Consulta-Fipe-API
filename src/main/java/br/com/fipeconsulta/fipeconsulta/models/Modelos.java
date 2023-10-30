package br.com.fipeconsulta.fipeconsulta.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

@JsonIgnoreProperties(ignoreUnknown = true)
public record Modelos(List<DadosMarcas> modelos) {

    @Override
    public String toString() {
        return modelos.stream().map(dadosMarcas -> String
                .format("Código: %7s, Nome: %S", dadosMarcas.codigo(), dadosMarcas.nome()))
                .collect(Collectors.joining());
    }

}
