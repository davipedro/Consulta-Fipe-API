package br.com.fipeconsulta.fipeconsulta.menu;

import br.com.fipeconsulta.fipeconsulta.models.DadosMarcas;
import br.com.fipeconsulta.fipeconsulta.models.Modelos;
import br.com.fipeconsulta.fipeconsulta.services.ConsumoAPI;
import br.com.fipeconsulta.fipeconsulta.validacoes.Validacao;

import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class Principal {
    private Scanner scanner = new Scanner(System.in);
    private Validacao validacao = new Validacao();
    private ConsumoAPI consumoAPI = new ConsumoAPI();

    public void listarSaidas(){
        List<DadosMarcas> marcas = consumoAPI.listaMarcas(opcaoTipoVeiculo());
        marcas.stream().sorted(Comparator
                .comparing((DadosMarcas::nome)))
                .forEach(System.out::println);

        Modelos modelos = consumoAPI.listaModelos(opcaoMarcaVeiculo(marcas));
        modelos.modelos().stream()
                .sorted(Comparator.comparing(DadosMarcas::nome))
                .forEach(System.out::println);

        String trechoNomeModelo = opcaoModeloVeiculo(modelos);
        modelos.modelos().stream()
                .filter(dadosMarcas -> dadosMarcas.nome().toLowerCase().contains(trechoNomeModelo.toLowerCase()))
                .forEach(System.out::println);

    }

    private void menuModelo(){
        System.out.print("Informe um trecho do modelo em específico: ");
    }
    private void menuTipo(){
        String menu = """
                ****** OPCOES ******
                Carros
                Motos
                Caminhoes
                * ESCOLHA UMA OPCAO *
                """;
        System.out.println(menu);
    }
    private void menuMarca(){
        System.out.print("Informe o código da marca que deseja fazer consulta: ");
    }

    private String opcaoModeloVeiculo(Modelos modelos){
        menuModelo();
        String trechoNome = scanner.nextLine();
        validacao.validaNomeModelo(trechoNome, modelos);
        return trechoNome;
    }
    private String opcaoTipoVeiculo(){
        menuTipo();
        String opcao = scanner.nextLine();
        validacao.validaTipo(opcao);
        return opcao;
    }
    private String opcaoMarcaVeiculo(List<DadosMarcas> marcas){
        menuMarca();
        String codigoMarca = scanner.nextLine();
        validacao.validaCodigoModelo(codigoMarca,marcas);
        return codigoMarca;
    }



}
