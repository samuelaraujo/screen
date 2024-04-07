package br.com.filmes.screen;

import br.com.filmes.screen.controller.api.FilmesApi;
import br.com.filmes.screen.controller.dto.DadosSerie;
import br.com.filmes.screen.controller.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Scanner;

@SpringBootApplication
public class ScreenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Api de filmes!");
		var filmesApi = new FilmesApi();
		filmesApi.setKeyApi("8182dd71");
        filmesApi.setNomeFilme("Gilmore Girls");
		ConverteDados converteDados = new ConverteDados();

		var json  = filmesApi.enderecoApi("https://www.omdbapi.com/?t=" +
				                                             filmesApi.getNomeFilme().replace(" ", "+") +
				    										"&apikey=" + filmesApi.getKeyApi() );
		System.out.println(json);
		DadosSerie dadosSerie = converteDados.obterDados(json, DadosSerie.class);
		var coffee = filmesApi.enderecoApi("https://coffee.alexflipnote.dev/random.json");

		System.out.println(dadosSerie);
		System.out.println(coffee);


	}
}
