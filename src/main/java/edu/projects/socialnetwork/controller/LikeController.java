package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.Like;
import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.record.RequestLike;
import edu.projects.socialnetwork.service.LikeService;
import edu.projects.socialnetwork.service.PostService;
import edu.projects.socialnetwork.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/likes")
public class LikeController {

    private final LikeService likeService;
    private final PostService postService;
    private final UserService userService;

    @Autowired
    public LikeController(LikeService likeService, PostService postService, UserService userService) {
        this.likeService = likeService;
        this.postService = postService;
        this.userService = userService;
    }

    @GetMapping("/posts/{postId}")
    public List<Like> getLikesForPost(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        return likeService.getLikesForPost(post);
    }

    @PostMapping("/posts/{postId}")
    public void likePost(@RequestBody RequestLike requestLike, Like like) {
        likeService.createLike(requestLike, like);
    }
}
