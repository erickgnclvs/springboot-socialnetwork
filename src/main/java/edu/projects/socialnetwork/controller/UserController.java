package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.*;
import edu.projects.socialnetwork.record.*;
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

    @GetMapping("/profile/{id}")
    public User getUserById(@PathVariable("id") Long id) { return userService.getUserById(id); }

    @GetMapping("/{username}")
    public User getUserByUsername(@PathVariable("username") String username) { return userService.getUserByUsername(username); }

    @PostMapping()
    public void createUser(@RequestBody User user) { userService.createUser(user); }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id) { userService.deleteUser(id); }

    @PutMapping("/{id}/password")
    public void updatePassword(@PathVariable("id") Long id, @RequestBody RequestPassword requestPassword) {
        userService.updatePassword(id, requestPassword.password());
    }

    @PutMapping("/{id}/name")
    public void updateName(@PathVariable Long id, @RequestBody RequestName requestName) {
        userService.updateName(id, requestName.name());
    }

    @PutMapping("/{id}/username")
    public void updateUsername(@PathVariable Long id, @RequestBody RequestUsername requestUsername) {
        userService.updateUsername(id, requestUsername.username());
    }

    @PutMapping("/{id}/email")
    public void updateEmail(@PathVariable Long id, @RequestBody RequestEmail requestEmail) {
        userService.updateEmail(id, requestEmail.email());
    }

    @PutMapping("/{id}/biography")
    public void updateEmail(@PathVariable Long id, @RequestBody RequestBiography requestBiography) {
        userService.updateBiography(id, requestBiography.biography());
    }

    @PutMapping("/{id}/deactivate")
    public void deactivateUser(@PathVariable Long id) {
        userService.deactivateUser(id);
    }

    @PutMapping("/{id}/activate")
    public void activateUser(@PathVariable Long id) {
        userService.activateUser(id);
    }


    /* TODO:
     *  write methods that
     *  improve methods
     *  write some checkings before taking the actions
     *  write proper error handler with message
     */
}
