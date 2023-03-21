package edu.projects.socialnetwork;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {

    @GetMapping(path = "/")
    public static String hello() {
        return "hello world";
    }

    @GetMapping(path = "/users")
    public static User showUsers() {
        User newUserTest = new User("erickusername", "passhash", "erick", "erick@mail.io", "im a bio");
        return newUserTest;
    }


}
