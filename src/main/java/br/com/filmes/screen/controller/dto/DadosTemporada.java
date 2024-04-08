package br.com.filmes.screen.controller.dto;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Collection;
@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosTemporada(@JsonAlias("Season") Integer numero,
                             @JsonAlias("Episodes")Collection<DadosEpisodio> episodios) {
}
