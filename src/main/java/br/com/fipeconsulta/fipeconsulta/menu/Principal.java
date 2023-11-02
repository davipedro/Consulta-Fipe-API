package br.com.fipeconsulta.fipeconsulta.menu;

import br.com.fipeconsulta.fipeconsulta.models.DadosMarcas;
import br.com.fipeconsulta.fipeconsulta.models.Modelos;
import br.com.fipeconsulta.fipeconsulta.models.Veiculo;
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

        Modelos listaModelos = consumoAPI.listaModelos(opcaoMarcaVeiculo(marcas));
        listaModelos.modelos().stream()
                .sorted(Comparator.comparing(DadosMarcas::nome))
                .forEach(System.out::println);

        String trechoNomeModelo = opcaoSubListaModeloVeiculo(listaModelos);
        listaModelos.modelos().stream()
                .filter(dadosMarcas -> dadosMarcas.nome().toLowerCase().contains(trechoNomeModelo.toLowerCase()))
                .forEach(System.out::println);

        List<Veiculo> listaTrechoModelos = consumoAPI.listaTrechoNomeModelos(opcaoLinhaModeloVeiculo(listaModelos));
        for (Veiculo veiculo : listaTrechoModelos) {
            System.out.println(veiculo);
        }

    }

    private void menuModelo(){
        System.out.print("Informe o código do modelo: ");
    }
    private void menuSubListaModelo(){
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

    private String opcaoTipoVeiculo(){
        menuTipo();
        String opcao = scanner.nextLine();
        return validacao.validaTipo(opcao);
    }
    private String opcaoMarcaVeiculo(List<DadosMarcas> marcas){
        menuMarca();
        String codigoMarca = scanner.nextLine();
        return validacao.validaCodigoMarca(codigoMarca,marcas);
    }
    private String opcaoLinhaModeloVeiculo(Modelos listaModelos){
        menuModelo();
        String codigoModelo = scanner.nextLine();
        return validacao.validaCodigoModelo(codigoModelo, listaModelos);
    }
    private String opcaoSubListaModeloVeiculo(Modelos modelos){
        menuSubListaModelo();
        String trechoNome = scanner.nextLine();
        return validacao.validaNomeModelo(trechoNome, modelos);
    }



}
