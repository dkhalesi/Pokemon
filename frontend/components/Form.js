import React from "react";

import Router from "next/router";
import styles from "../styles/Form.module.css";

export const Form = () => {
  const [player1, setPlayer1] = React.useState("");
  const [pokemon1, setPokemon1] = React.useState("");
  const [player2, setPlayer2] = React.useState("");
  const [pokemon2, setPokemon2] = React.useState("");
  const [pokemons, setPokemons] = React.useState([]);
  const [loading, setLoading] = React.useState(true);

  React.useEffect(() => {
    async function fetchData() {
      const response = await fetch("http://localhost:8080/pokemons");
      const data = await response.json();
      console.log(data[0], data[0].name);
      setPokemons(data);
      setLoading(false);
    }
    fetchData();
  }, []);

  if (loading) {
    return <p>Loading...</p>;
  }

  function handleSubmit(event) {
    event.preventDefault();
    if (
      player1 !== "" &&
      player2 !== "" &&
      pokemon1 !== "" &&
      pokemon2 !== ""
    ) {
      const index1 = pokemons.findIndex((p) => p.name === pokemon1);
      const index2 = pokemons.findIndex((p) => p.name === pokemon2);
      const pokemonObj1 = pokemons[index1];
      const pokemonObj2 = pokemons[index2];
      let requestBody = {
        name1: player1,
        pokemonName1: pokemonObj1.name,
        pokemonNormalAttack1: pokemonObj1.normalAttack,
        pokemonSpecialAttack1: pokemonObj1.specialAttack,
        name2: player2,
        pokemonName2: pokemonObj2.name,
        pokemonNormalAttack2: pokemonObj2.normalAttack,
        pokemonSpecialAttack2: pokemonObj2.specialAttack,
      };

      fetch("http://localhost:8080/simulatefight", {
        method: "POST",
        body: JSON.stringify(requestBody),
        headers: {
          "Content-Type": "application/json",
        },
      })
        .then((response) => response.json())
        .then((data) => {
          Router.push({ pathname: "/result", query: data });
        });
    } else {
      alert("Incomplete Fields!");
    }
  }

  return (
    <form onSubmit={handleSubmit} className={styles.form}>
      <label>
        Player 1 Name:&nbsp;
        <input
          className={styles.box}
          type="text"
          value={player1}
          onChange={(event) => setPlayer1(event.target.value)}
        />
      </label>
      <br />
      <label>
        Player 1 Pokemon:&nbsp;
        <select
          className={styles.box}
          value={pokemon1}
          onChange={(event) => setPokemon1(event.target.value)}
        >
          <option value="">Select a pokemon</option>
          {pokemons.map((pokemon) => (
            <option key={pokemon.name} value={pokemon.name}>
              Name: {pokemon.name}&nbsp;, Height: {pokemon.height}&nbsp;,
              Weight:
              {pokemon.weight}
            </option>
          ))}
        </select>
      </label>
      <br />
      <br />
      <label>
        Player 2 Name:&nbsp;
        <input
          className={styles.box}
          type="text"
          value={player2}
          onChange={(event) => setPlayer2(event.target.value)}
        />
      </label>
      <br />
      <label>
        Player 2 Pokemon:&nbsp;
        <select
          className={styles.box}
          value={pokemon2}
          onChange={(event) => setPokemon2(event.target.value)}
        >
          <option value="">Select a pokemon</option>
          {pokemons.map((pokemon) => (
            <option key={pokemon.name} value={pokemon.name}>
              Name: {pokemon.name}&nbsp;, Height: {pokemon.height}&nbsp;,
              Weight:
              {pokemon.weight}
            </option>
          ))}
        </select>
      </label>
      <br />
      <input type="submit" value="Start Fight" className={styles.input} />
    </form>
  );
};
