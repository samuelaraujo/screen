package br.com.filmes.screen.controller;

import br.com.filmes.screen.controller.api.FilmesSeriesApi;
import br.com.filmes.screen.controller.dto.DadosEpisodio;
import br.com.filmes.screen.controller.dto.DadosSerie;
import br.com.filmes.screen.controller.dto.DadosTemporada;
import br.com.filmes.screen.controller.service.ConverteDados;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class MenuPrincipal {

    private  FilmesSeriesApi filmesSeriesApi = new FilmesSeriesApi();
    private final String ENDERECO = "https://www.omdbapi.com/?t=";
    private final String API_KEY = "&apikey=8182dd71";
    private ConverteDados converteDados = new ConverteDados();
    private Collection<DadosTemporada> temporadas = new ArrayList<>();
    private Scanner leitura = new Scanner(System.in);

    public String exibMenu(){
        System.out.println("Digite o nome da série para a busca");
        var nomeSerie = leitura.nextLine();
        System.out.println("Fazendo chamada para: "+ ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        var json = filmesSeriesApi.enderecoApi(ENDERECO + nomeSerie.replace(" ", "+") + API_KEY);
        System.out.println(converteDados.obterDados(json, DadosSerie.class));
        listaTemporadas(converteDados.obterDados(json, DadosSerie.class), nomeSerie);
        //var coffee = filmesSeriesApi.enderecoApi("https://coffee.alexflipnote.dev/random.json");
        //System.out.println(coffee);
        return nomeSerie;
    }

    private void listaTemporadas(DadosSerie dadosSerie, String nomeSerie){
        for (int i = 1; i <= dadosSerie.totalTemporadas() ; i++) {
            var json = filmesSeriesApi.enderecoApi(ENDERECO + nomeSerie.replace(" ","+") +"&season="+ i + API_KEY);
            DadosTemporada dadosTemporada = converteDados.obterDados(json, DadosTemporada.class);
            temporadas.add(dadosTemporada);
        }
        temporadas.forEach(t -> t.episodios().forEach(e -> System.out.println(e.titulo())));
    }
}
