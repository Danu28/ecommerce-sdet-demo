package com.sdet.demo.backend.service;

import com.sdet.demo.backend.model.User;
import com.sdet.demo.backend.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;

    public UserService(UserRepository repo) {
        this.repo = repo;
    }

    public User register(User user) {
        Optional<User> existing = repo.findByUsername(user.getUsername());

        if (existing.isPresent()) {
            return existing.get(); // avoid duplicate crash
        }

        return repo.save(user);
    }

    public boolean login(String username, String password) {
        Optional<User> user = repo.findByUsername(username);
        return user.isPresent() && user.get().getPassword().equals(password);
    }
}