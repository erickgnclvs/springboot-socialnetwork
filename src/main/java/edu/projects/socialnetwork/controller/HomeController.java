package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.service.LikeService;
import edu.projects.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class HomeController {

    private final PostService postService;

    @Autowired
    public HomeController(PostService postService) {
        this.postService = postService;
    }

    @GetMapping(path = "/")
    public String home(Model model) {
        model.addAttribute("posts", postService.getPosts());
        return "home";
    }

    @GetMapping(path = "/{username}")
    public String profilePage(@PathVariable String username, Model model) {
        List<Post> posts = postService.getPostsByUsername(username);
        model.addAttribute("posts", posts);
        return "profilepage";
    }
}
