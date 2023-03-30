package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.UserRelationship;
import edu.projects.socialnetwork.record.RequestFollow;
import edu.projects.socialnetwork.service.UserRelationshipService;
import edu.projects.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/follow")
public class UserRelationshipController {

    private final UserService userService;
    private final UserRelationshipService userRelationshipService;

    @Autowired
    public UserRelationshipController(UserService userService, UserRelationshipService userRelationshipService) {
        this.userService = userService;
        this.userRelationshipService = userRelationshipService;
    }

    @GetMapping("/{username}/followers")
    public List<UserRelationship> getFollowersByUsername(@PathVariable String username) {
        return userRelationshipService.getFollowersByUsername(username);
    }

    @PostMapping("/{username}/follow")
    public void followUser(@PathVariable String username, @RequestBody RequestFollow requestFollow, UserRelationship userRelationship) {
        userRelationshipService.followUser(username, requestFollow.follower_id(), userRelationship);
    }

}
