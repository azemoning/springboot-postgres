package dev.azemoning.springbootpostgres.service;

import dev.azemoning.springbootpostgres.exception.ResourceNotFoundException;
import dev.azemoning.springbootpostgres.model.User;
import dev.azemoning.springbootpostgres.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User getUserById(String id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
    }

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(String id, User user) {
        User findUser = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("User not found"));
        findUser.setFullName(user.getFullName());
        return userRepository.save(findUser);
    }
}
