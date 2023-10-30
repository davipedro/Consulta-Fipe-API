package br.com.fipeconsulta.fipeconsulta.services;

import java.util.List;

public interface IConveterDados {
    <T> T converterDados(String json, Class<T> classe);
    <T> List<T> ObterLista(String json, Class<T> classe);
}
