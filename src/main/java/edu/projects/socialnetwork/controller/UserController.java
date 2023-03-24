package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.RequestName;
import edu.projects.socialnetwork.model.RequestPassword;
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

    /* TODO:
     *  write methods that
     *  update name
     *  update usarname
     *  update email
     *  update biography
     *  improve methods
     *  write some checkings before taking the actions
     *  write proper error handler with message
     */
}
