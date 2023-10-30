package br.com.fipeconsulta.fipeconsulta.services;

import br.com.fipeconsulta.fipeconsulta.models.DadosMarcas;
import br.com.fipeconsulta.fipeconsulta.models.Modelos;

import java.util.List;

public class ConsumoAPI {
    UrlRequisicao urlRequisicao = new UrlRequisicao();
    private RequisicaoAPI requisicaoAPI = new RequisicaoAPI();
    private ConversorDados conversorDados = new ConversorDados();
    public List<DadosMarcas> listaMarcas(String tipoVeiculo){
        String endereco = urlRequisicao.marcaVeiculo(tipoVeiculo);
        String json = requisicaoAPI.obterDados(endereco);
        return conversorDados.ObterLista(json, DadosMarcas.class);
    }

    public Modelos listaModelos(String modeloVeiculo){
        String endereco = urlRequisicao.modelosVeiculo(modeloVeiculo);
        String json = requisicaoAPI.obterDados(endereco);
        return conversorDados.converterDados(json, Modelos.class);
    }

    //fazer método que devolve a lista de modelos

}
