package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.Like;
import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.service.LikeService;
import edu.projects.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/likes")
public class LikeController {

    private final LikeService likeService;
    private final PostService postService;

    @Autowired
    public LikeController(LikeService likeService, PostService postService) {
        this.likeService = likeService;
        this.postService = postService;
    }

    @GetMapping("/posts/{postId}")
    public List<Like> getLikesForPost(@PathVariable Long postId) {
        Post post = postService.getPostById(postId);
        return likeService.getLikesForPost(post);
    }

    // TODO - manually added 1 like to database, may have to remove later


}
