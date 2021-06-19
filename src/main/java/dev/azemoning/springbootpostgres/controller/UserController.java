package dev.azemoning.springbootpostgres.controller;

import dev.azemoning.springbootpostgres.model.User;
import dev.azemoning.springbootpostgres.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class UserController {
    @Autowired
    private UserService userService;

    @PostMapping("register")
    public ResponseEntity<Object> register(@RequestBody User user) {
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @GetMapping("user/{id}")
    public ResponseEntity<Object> getUserById(User user) {
        return new ResponseEntity<>(userService.getUserById(user.getId()), HttpStatus.OK);
    }
}
