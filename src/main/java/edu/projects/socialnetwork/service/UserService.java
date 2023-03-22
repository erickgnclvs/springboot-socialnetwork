package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {


    public List<User> getUsers() {
        User user1 = new User("erickusername", "passhash", "erick", "erick@mail.io", "im a bio");
        User user2 = new User("natiusername", "passhash", "nati", "nati@mail.io", "im a bio");

        return List.of(user1, user2);
    }
}
