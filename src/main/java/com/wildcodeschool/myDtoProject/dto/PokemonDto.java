package com.wildcodeschool.myDtoProject.dto;


import com.wildcodeschool.myDtoProject.validator.Attribute;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

public class PokemonDto {
    private Long Id;
    private String name;
    @Min(value = 0)
    @Max(value = 10)
    private int power;
    @Attribute
    private String attribute;
    private String user;

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

    public int getPower() {
        return power;
    }

    public void setPower(int power) {
        this.power = power;
    }

    public String getAttribute() {
        return attribute;
    }

    public void setAttribute(String attribute) {
        this.attribute = attribute;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }
}
