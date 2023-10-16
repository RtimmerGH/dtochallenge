package com.wildcodeschool.myDtoProject.service;

import com.wildcodeschool.myDtoProject.dto.PokemonDto;
import com.wildcodeschool.myDtoProject.entity.Pokemon;
import com.wildcodeschool.myDtoProject.entity.User;
import com.wildcodeschool.myDtoProject.repository.PokemonRepository;
import com.wildcodeschool.myDtoProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.EnumSet;
import java.util.List;

@Service
public class PokemonMapper {

    public final UserRepository userRepository;
    public final PokemonRepository pokemonRepository;

    public PokemonMapper(PokemonRepository pokemonRepository,
                         UserRepository userRepository) {
        this.pokemonRepository = pokemonRepository;
        this.userRepository = userRepository;
    }

    public static <E extends Enum<E>> boolean contains(Class<E> _enumClass,
                                                       String value) {
        try {
            return EnumSet.allOf(_enumClass)
                    .contains(Enum.valueOf(_enumClass, value));
        } catch (Exception e) {
            return false;
        }
    }

    public List<PokemonDto> findAllPokemons() {
        List<Pokemon> pokemons;
        pokemons = this.pokemonRepository.findAll();
        List<PokemonDto> pokemonsDto = new ArrayList<PokemonDto>();
        int i = 0;
        for (Pokemon pokemon : pokemons) {
            PokemonDto pokemonDto = this.TransformPokemonEntityIntoPokemonDto(pokemon);
            pokemonsDto.add(i, pokemonDto);
            i++;
        }
        return pokemonsDto;
    }

    public PokemonDto findOnePokemonById(Long id) {
        return TransformPokemonEntityIntoPokemonDto(this.pokemonRepository.findById(id).get());
    }

    public PokemonDto findOnePokemonByName(String name) {
        return TransformPokemonEntityIntoPokemonDto(this.pokemonRepository.findFirstByName(name));
    }

    public PokemonDto savePokemon(PokemonDto pokemon) {
        return TransformPokemonEntityIntoPokemonDto(this.pokemonRepository.save(TransformPokemonDtoInPokemonEntity(pokemon)));
    }

    private PokemonDto TransformPokemonEntityIntoPokemonDto(Pokemon pokemon) {
        PokemonDto pokemonDto = new PokemonDto();
        pokemonDto.setName(pokemon.getName());
        pokemonDto.setId(pokemon.getId());
        pokemonDto.setPower(pokemon.getPower());
        pokemonDto.setAttribute(pokemon.getAttribute());
        if (pokemon.getUser()!= null) {
            pokemonDto.setUser(pokemon.getUser().getName());
        }
        return pokemonDto;
    }

    private Pokemon TransformPokemonDtoInPokemonEntity(PokemonDto pokemonDto) {
        Pokemon pokemon = new Pokemon();
        pokemon.setName(pokemonDto.getName());
        pokemon.setId(pokemonDto.getId());
        pokemon.setPower(pokemonDto.getPower());
        pokemon.setAttribute(pokemonDto.getAttribute().toLowerCase());
        User user = this.userRepository.findFirstByName(pokemonDto.getUser());
        if (user != null) {
            pokemon.setUser(user);
        }
        return pokemon;
    }
}
