package br.com.fipeconsulta.fipeconsulta.validacoes;

import br.com.fipeconsulta.fipeconsulta.models.DadosMarcas;
import br.com.fipeconsulta.fipeconsulta.models.Modelos;
import br.com.fipeconsulta.fipeconsulta.models.TipoVeiculo;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Validacao {

    Scanner scanner = new Scanner(System.in);

    public boolean verificaNomeModelo(String trechoNome, Modelos modelos){
        return modelos.modelos().stream()
                .anyMatch(dadosMarcas -> dadosMarcas.nome()
                        .toLowerCase().contains(trechoNome.toLowerCase()));
    }

    public boolean verificaCodigoModelo(String codigo, List<DadosMarcas> marcas){
        return marcas.stream().anyMatch(dadosMarcas -> dadosMarcas.codigo().equals(codigo));
    }

    public boolean verificaTipoVeiculo(String tipoVeiculo){
        for(TipoVeiculo tipo : TipoVeiculo.values()){
            if (tipoVeiculo.equalsIgnoreCase(tipo.toString())){
                return true;
            }
        }
        return false;
    }

    public void validaTipo(String opcao){
        boolean verificaEntrada = verificaTipoVeiculo(opcao);
        while (!verificaEntrada){
            System.out.println("Opção inválida, verifique a opção e digite novamente");
            opcao = scanner.nextLine();
            verificaEntrada = verificaTipoVeiculo(opcao);
        }
    }
    public void validaCodigoModelo(String codigoMarca, List<DadosMarcas> marcas){
        boolean codigoValido = verificaCodigoModelo(codigoMarca, marcas);
        while (!(codigoValido)){
            System.out.println("Opção inválida, verifique a opção e digite novamente");
            codigoMarca = scanner.nextLine();
            codigoValido = verificaCodigoModelo(codigoMarca, marcas);
        }
    }

    public void validaNomeModelo(String trechoNome, Modelos modelos){
        boolean codigoValido = verificaNomeModelo(trechoNome, modelos);
        while(!(codigoValido)){
            System.out.print("Não existe modelo com esse nome, digite novamente: ");
            trechoNome = scanner.nextLine();
            codigoValido = verificaNomeModelo(trechoNome, modelos);
        }
    }
}
