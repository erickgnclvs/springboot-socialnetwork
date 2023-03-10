package edu.projects.socialnetwork.services;

import edu.projects.socialnetwork.models.User;
import edu.projects.socialnetwork.models.UserDetails;
import edu.projects.socialnetwork.repositories.UserDetailsRepository;
import edu.projects.socialnetwork.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;
    private final UserDetailsRepository userDetailsRepository;

    @Autowired
    public UserService(UserRepository userRepository, UserDetailsRepository userDetailsRepository) {
        this.userRepository = userRepository;
        this.userDetailsRepository = userDetailsRepository;
    }

    public User createUser(User user) {
        return userRepository.save(user);
    }

    public Optional<UserDetails> getUserDetails(User user) {
        return userDetailsRepository.findByUser(user);
    }
}
