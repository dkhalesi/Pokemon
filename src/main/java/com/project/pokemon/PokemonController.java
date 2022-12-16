package com.project.pokemon;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.pokemon.game.Player;
import com.project.pokemon.game.PokemonInGame;
import com.project.pokemon.game.Tournament;
import com.project.pokemon.models.PlayersRequest;
import com.project.pokemon.models.Pokemon;
import com.project.pokemon.models.PokemonListResponse;

@RestController
public class PokemonController {

    @GetMapping(value = "/pokemons")
    public List<Pokemon> getPokemons() {
        try {
            String uri = "https://pokeapi.co/api/v2/pokemon?limit=50";
            RestTemplate restTemplate = new RestTemplate();
            PokemonListResponse pokemonListResponse = restTemplate.getForObject(uri,
                    PokemonListResponse.class);

            return pokemonListResponse.getResults().stream().map(pokemon -> {
                return restTemplate.getForObject(pokemon.getUrl(), Pokemon.class);
            }).collect(Collectors.toList());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    @PostMapping(path = "simulatefight", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public List<String> simulateTournament(@RequestBody PlayersRequest playersRequest) {
        PokemonInGame pokemon1 = new PokemonInGame(playersRequest.getPokemonName1());
        PokemonInGame pokemon2 = new PokemonInGame(playersRequest.getPokemonName2());
        Player player1 = new Player(playersRequest.getName1(), pokemon1);
        Player player2 = new Player(playersRequest.getName2(), pokemon2);

        Tournament tournament = new Tournament(player1, player2);
        return tournament.simulateTournament();
    }

}
