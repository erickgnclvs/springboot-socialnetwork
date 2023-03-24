package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;


    @Autowired
    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }


    public List<Post> getPosts() {
        return postRepository.findAll();
    }
}
