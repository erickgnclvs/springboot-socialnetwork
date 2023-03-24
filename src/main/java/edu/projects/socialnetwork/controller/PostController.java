package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/posts")
public class PostController {

    private final PostService postService;

    @Autowired
    public PostController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping()
    public List<Post> getPosts() {
        return postService.getPosts();
    }

    @GetMapping("/post/{id}")
    public Post getPostById(@PathVariable Long id) {
        return postService.getPostById(id);
    }

    @GetMapping("/{username}")
    public List<Post> getPostsByUsername(@PathVariable String username) {
        return postService.getPostsByUsername(username);
    }

    @PostMapping("/new")
    public void createPost(@RequestBody Post post) {
        postService.createPost(post);
    }

    @PutMapping("post/{id}")
    public void updatePost(@RequestBody Post post, @PathVariable Long id) {
        postService.updatePost(id, post);
    }

    @DeleteMapping("/post/{id}")
    public void deletePost(@PathVariable Long id) {
        postService.deletePost(id);
    }

    /* TODO:
     *  write methods to:
     *  create post
     *  update post
     *  delete post
     */

}
