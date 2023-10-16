package com.wildcodeschool.myDtoProject.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import java.util.List;

public class UserDto {
    private Long Id;
    private String name;
    private int age;
    @Min(0)
    @Max(100)
    private int level;
    private List<String> pokemons;

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public List<String> getPokemons() {
        return pokemons;
    }

    public void setPokemons(List<String> pokemons) {
        this.pokemons = pokemons;
    }
}
