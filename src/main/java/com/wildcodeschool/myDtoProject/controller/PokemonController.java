package com.wildcodeschool.myDtoProject.controller;

import com.wildcodeschool.myDtoProject.dto.PokemonDto;
import com.wildcodeschool.myDtoProject.service.PokemonMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {

    public final PokemonMapper pokemonMapper;

    public PokemonController(
            PokemonMapper pokemonMapper
    ) {
        this.pokemonMapper = pokemonMapper;
    }

    @GetMapping("")
    public ResponseEntity<?> index(@RequestParam(defaultValue = "", required = false) String pokemon) {
        if (pokemon != null && !pokemon.isEmpty() ) {
            PokemonDto pokemonDto = this.pokemonMapper.findOnePokemonByName(pokemon);
            return new ResponseEntity<>(pokemonDto, HttpStatus.OK);
        }
        List<PokemonDto> pokemonsDto = this.pokemonMapper.findAllPokemons();
        return new ResponseEntity<>(pokemonsDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        PokemonDto pokemonDto = this.pokemonMapper.findOnePokemonById(id);
        return new ResponseEntity<>(pokemonDto, HttpStatus.OK);
    }


    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody  PokemonDto pokemonDto){
        PokemonDto pokemon = this.pokemonMapper.savePokemon(pokemonDto);
        return new ResponseEntity<>(pokemon, HttpStatus.OK);
    }
}
