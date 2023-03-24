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

    @Transactional
    public void updateName(Long id, String name) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new IllegalStateException("user doesnt exist in this id");
        if (user.get().getName().equals(name)) throw new IllegalStateException("the name is the same as before");
        user.get().setName(name);
    }

    @Transactional
    public void updateUsername(Long id, String newUsername) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new IllegalStateException("user doesnt exist in this id");
        if (user.get().getUsername().equals(newUsername)) throw new IllegalStateException("the username is the same as before");
        user.get().setUsername(newUsername);
    }

    @Transactional
    public void updateEmail(Long id, String email) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new IllegalStateException("user doesnt exist in this id");
        if (user.get().getEmail().equals(email)) throw new IllegalStateException("the email is the same as before");
        user.get().setEmail(email);
    }

    @Transactional
    public void updateBiography(Long id, String biography) {
        Optional<User> user = userRepository.findById(id);
        if (user.isEmpty()) throw new IllegalStateException("user doesnt exist in this id");
        if (user.get().getBiography().equals(biography)) throw new IllegalStateException("the biography is the same as before");
        user.get().setBiography(biography);
    }
}
