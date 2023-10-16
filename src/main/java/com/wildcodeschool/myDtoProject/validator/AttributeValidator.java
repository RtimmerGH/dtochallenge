package com.wildcodeschool.myDtoProject.validator;

import com.wildcodeschool.myDtoProject.pokeEnum.PokeEnum;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import static com.wildcodeschool.myDtoProject.service.PokemonMapper.contains;

public class AttributeValidator implements ConstraintValidator<Attribute, String> {
    @Override
    public void initialize(Attribute paramA) {
    }

    @Override
    public boolean isValid(String attribute, ConstraintValidatorContext ctx) {
        if(attribute == null){
            return false;
        }
        if (contains(PokeEnum.class, attribute.toUpperCase())) {
            return true;
        }
        else return false;
    }
}
