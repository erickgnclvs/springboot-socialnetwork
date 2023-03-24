package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    @Autowired
    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }


    public List<Post> getPosts() {
        return postRepository.findAll();
    }

    public Post getPostById(Long id) {
        Optional<Post> post = postRepository.findById(id);
        if (post.isEmpty()) throw new IllegalArgumentException("post doesn't exist");
        return post.get();
    }

    public List<Post> getPostsByUsername(String username) {
        User user = userService.getUserByUsername(username);
        Optional<List<Post>> list = postRepository.findAllByUser(user);
        if (list.isEmpty()) throw new IllegalStateException("no posts for this user");
        return list.get();
    }

    public void createPost(Post post) {
        postRepository.save(post);
    }
}
