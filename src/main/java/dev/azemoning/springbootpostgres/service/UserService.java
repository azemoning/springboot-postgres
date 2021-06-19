package dev.azemoning.springbootpostgres.service;

import dev.azemoning.springbootpostgres.model.User;

public interface UserService {
    User getUserById(String id);
    User addUser(User user);
    User updateUser(String id, User user);
}
