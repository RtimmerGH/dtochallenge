package com.wildcodeschool.myDtoProject.service;

import com.wildcodeschool.myDtoProject.dto.UserDto;
import com.wildcodeschool.myDtoProject.entity.Pokemon;
import com.wildcodeschool.myDtoProject.entity.User;
import com.wildcodeschool.myDtoProject.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class UserMapper {
    public final UserRepository userRepository;

    public UserMapper(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserDto> findAllUsers() {
        List<User> users;
        users = this.userRepository.findAll();
        List<UserDto> usersDto = new ArrayList<UserDto>();
        int i = 0;
        for (User user : users) {
            UserDto userDto = this.TransformUserEntityIntoUserDto(user);
            usersDto.add(i, userDto);
            i++;
        }
        return usersDto;
    }

    public UserDto saveUser(UserDto user) {
        return TransformUserEntityIntoUserDto(this.userRepository.save(TransformUserDtoInUserEntity(user)));
    }

    public UserDto findOneUserById(Long id) {
        return TransformUserEntityIntoUserDto(this.userRepository.findById(id).get());
    }

    public UserDto findOneUserByName(String name) {
        return TransformUserEntityIntoUserDto(this.userRepository.findFirstByName(name));
    }

    private UserDto TransformUserEntityIntoUserDto(User user) {
        UserDto userDto = new UserDto();
        userDto.setName(user.getName());
        userDto.setId(user.getId());
        userDto.setAge(user.getAge());
        userDto.setLevel(user.getLevel());
        if (user.getPokemons() != null) {
            userDto.setPokemons(user.getPokemons().stream().map(Pokemon::getName).collect(Collectors.toList()));
        }
        return userDto;
    }

    private User TransformUserDtoInUserEntity(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setId(userDto.getId());
        user.setAge(userDto.getAge());
        user.setLevel(userDto.getLevel());
        return user;
    }
}
