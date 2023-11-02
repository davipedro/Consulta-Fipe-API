package br.com.fipeconsulta.fipeconsulta.services;

import br.com.fipeconsulta.fipeconsulta.erros.Errors;
import br.com.fipeconsulta.fipeconsulta.validacoes.Validacao;

public class UrlRequisicao {

    Validacao validacao = new Validacao();
    private String endereco;
    private final String ENDERECO_BASE = "https://parallelum.com.br/fipe/api/v1/";
    public String marcaVeiculo(String tipoVeiculo){
        if (validacao.verificaTipoVeiculo(tipoVeiculo)){
            endereco = ENDERECO_BASE + tipoVeiculo.toLowerCase() + "/marcas";
            return endereco;
        } else {
            throw  new Errors("Tipo de veículo inválido");
        }
    }

    public String modelosVeiculo(String codigo){
        endereco = endereco + "/" + codigo + "/modelos";
        return endereco;
    }

    public String linhaModelosVeiculos(String codigo){
        endereco = endereco + "/" + codigo + "/anos";
        return endereco;
    }

}
