package com.wildcodeschool.myDtoProject.repository;

import com.wildcodeschool.myDtoProject.entity.Pokemon;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Long> {
    Pokemon findFirstByName(String name);
}
