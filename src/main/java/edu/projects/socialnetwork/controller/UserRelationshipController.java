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

    private final UserRelationshipService userRelationshipService;

    @Autowired
    public UserRelationshipController(UserRelationshipService userRelationshipService) {
        this.userRelationshipService = userRelationshipService;
    }

    @GetMapping("/{username}/followers")
    public List<UserRelationship> getFollowersByUsername(@PathVariable String username) {
        return userRelationshipService.getFollowersByUsername(username);
        // TODO: make this method be accesses by /username/followers and return a thymeleaf template
    }

    @GetMapping("/{username}/following")
    public List<UserRelationship> getFollowingByUsername(@PathVariable String username) {
        return userRelationshipService.getFollowingByUsername(username);
    }

    @PostMapping("/{username}/follow")
    public void followUser(@PathVariable String username, @RequestBody RequestFollow requestFollow, UserRelationship userRelationship) {
        userRelationshipService.followUser(username, requestFollow.follower_id(), userRelationship);
    }

    @DeleteMapping("/{username}/unfollow")
    public void unfollowUser(@PathVariable String username, @RequestBody RequestFollow requestFollow, UserRelationship userRelationship) {
        userRelationshipService.unfollowUser(username, requestFollow.follower_id(), userRelationship);
    }

}
