package com.wildcodeschool.myDtoProject.pokeEnum;

public enum PokeEnum {
    FEU("feu"),
    TERRE("terre"),
    AIR("air"),
    EAU("eau"),
    PSY("psy");

    private String fullName;

    PokeEnum(String fullName) {
        this.fullName = fullName;
    }

    public String getFullName() {
        return fullName;
    }
}
