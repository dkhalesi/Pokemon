package com.project.pokemon;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.project.pokemon.pokemon.Pokemon;
import com.project.pokemon.pokemon.PokemonListResponse;

@RestController
public class PokemonController {

    @GetMapping(value = "/pokemons")
    public List<Pokemon> getPokemons() {
        try {
            System.out.println("DINA HERE");

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

}
