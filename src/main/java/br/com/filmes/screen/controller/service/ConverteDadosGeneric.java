package br.com.filmes.screen.controller.service;

public interface ConverteDadosGeneric {

    <T> T obterDados(String json, Class<T> tClass);
}
