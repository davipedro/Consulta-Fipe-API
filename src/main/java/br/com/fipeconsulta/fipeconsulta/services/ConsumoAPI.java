package br.com.fipeconsulta.fipeconsulta.services;

import br.com.fipeconsulta.fipeconsulta.models.DadosMarcas;
import br.com.fipeconsulta.fipeconsulta.models.Modelos;
import br.com.fipeconsulta.fipeconsulta.models.Veiculo;

import java.util.ArrayList;
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

    public List<Veiculo> listaTrechoNomeModelos(String codigoModelo){
        String endereco = urlRequisicao.linhaModelosVeiculos(codigoModelo);
        String json = requisicaoAPI.obterDados(endereco);
        List<DadosMarcas> listaTrechoModelos = conversorDados.ObterLista(json, DadosMarcas.class);
        List<Veiculo> veiculos = new ArrayList<>();

        for (int i = 0; i < listaTrechoModelos.size(); i++) {
            String enderecoAnos = endereco + "/" + listaTrechoModelos.get(i).codigo();
            json = requisicaoAPI.obterDados(enderecoAnos);
            Veiculo veiculo = conversorDados.converterDados(json, Veiculo.class);
            veiculos.add(veiculo);
        }
        return veiculos;
    }

}
