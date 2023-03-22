package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

    public void createUser(User user) {
        Optional<User> temp = userRepository.findUserByUsername(user.getUsername());
        if (temp.isPresent()) throw new IllegalStateException("username already exists");
        userRepository.save(user);
    }

    public void deleteUser(Long id) {
        if (!userRepository.existsById(id)) throw new IllegalStateException("user id is not in the database");
        userRepository.deleteById(id);
    }

    @Transactional
    public void updatePassword(Long id, String password) {
        if (!userRepository.existsById(id)) throw new IllegalStateException("user id is not in the database");
        userRepository.getById(id).setPasswordHash(password);
    }

    public User getUserById(Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new IllegalArgumentException("id is not registered");
        return user.get();
    }

    public User getUserByUsername(String username) {
        Optional<User> user = userRepository.findUserByUsername(username);
        if (user.isEmpty()) throw new IllegalArgumentException("username is not registered");
        return user.get();
    }
}
