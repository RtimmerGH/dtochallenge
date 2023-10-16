package com.wildcodeschool.myDtoProject.controller;

import com.wildcodeschool.myDtoProject.dto.UserDto;
import com.wildcodeschool.myDtoProject.service.UserMapper;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    public final UserMapper userMapper;

    public UserController(
                          UserMapper userMapper
    ) {
        this.userMapper = userMapper;
    }

    @GetMapping("")
    public ResponseEntity<?> index(@RequestParam(defaultValue = "", required = false) String user) {
        if (user != null && !user.isEmpty() ) {
            UserDto userDto = this.userMapper.findOneUserByName(user);
            return new ResponseEntity<>(userDto, HttpStatus.OK);
        }
        List<UserDto> usersDto = this.userMapper.findAllUsers();
        return new ResponseEntity<>(usersDto, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> show(@PathVariable Long id) {
        UserDto userDto = this.userMapper.findOneUserById(id);
        return new ResponseEntity<>(userDto, HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<?> create(@Valid @RequestBody UserDto userDto){
        UserDto user = this.userMapper.saveUser(userDto);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }
}
