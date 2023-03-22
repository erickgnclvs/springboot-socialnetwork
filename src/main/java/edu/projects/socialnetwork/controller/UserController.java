package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/users")
public class UserController {

    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public List<User> getUsers() { return userService.getUsers(); }

    @PostMapping()
    public void createUser(@RequestBody User user) { userService.createUser(user); }

    @DeleteMapping(path = "/{id}")
    public void deleteUser(@PathVariable("id") Long id) { userService.deleteUser(id); }

    @PutMapping(path = "/{id}/password")
    public void updatePassword(@PathVariable("id") Long id, @RequestBody String password) {
        userService.updatePassword(id, password);
    }
}
