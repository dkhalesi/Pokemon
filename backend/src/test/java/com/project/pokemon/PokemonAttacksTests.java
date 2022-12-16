package com.project.pokemon;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.pokemon.game.Game;
import com.project.pokemon.game.Player;
import com.project.pokemon.game.PokemonInGame;

@SpringBootTest
class PokemonAttacksTests {

	@Test
	void testAttack() {
		Player player1 = new Player("Ash", new PokemonInGame("Pikachu", 1, 10));
		Player player2 = new Player("Brock", new PokemonInGame("Onix", 5, 8));
		Game game = new Game(player1, player2);
		// we will ignore who's turn it is for the sake of the test
		String attack1 = game.attack(player1, player2);
		assertEquals("Normal Attack", attack1);
		String attack2 = game.attack(player1, player2);
		assertEquals("Special Attack", attack2);
		String attack3 = game.attack(player1, player2);
		assertEquals("Normal Attack", attack3);
	}

}
