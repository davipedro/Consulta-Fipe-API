package br.com.fipeconsulta.fipeconsulta.erros;

public class Errors extends RuntimeException{
    public Errors(String mensagem){
        super(mensagem);
    }
}
