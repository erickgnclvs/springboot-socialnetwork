package edu.projects.socialnetwork.controller;

import edu.projects.socialnetwork.service.LikeService;
import edu.projects.socialnetwork.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

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
}
