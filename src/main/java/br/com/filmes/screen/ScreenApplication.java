package br.com.filmes.screen;

import br.com.filmes.screen.controller.MenuPrincipal;
import br.com.filmes.screen.controller.api.FilmesSeriesApi;
import br.com.filmes.screen.controller.dto.DadosEpisodio;
import br.com.filmes.screen.controller.dto.DadosSerie;
import br.com.filmes.screen.controller.dto.DadosTemporada;
import br.com.filmes.screen.controller.service.ConverteDados;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Collection;
import java.util.SplittableRandom;

@SpringBootApplication
public class ScreenApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(ScreenApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Api de filmes!");

		String busca = "";
		MenuPrincipal menuPrincipal  = new  MenuPrincipal();
		while (!busca.equalsIgnoreCase("sair")){
			 busca = menuPrincipal.exibMenu();
			if (busca.equalsIgnoreCase("sair")) break;

		}
	}
}
