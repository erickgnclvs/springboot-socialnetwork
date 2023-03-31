package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.record.RequestPost;
import edu.projects.socialnetwork.repository.PostRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
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
        return postRepository.findAllByOrderByCreatedAtDesc();
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

    @Transactional
    public void createPost(RequestPost requestPost, Post post) {
        post.setCreatedAt(LocalDateTime.now());
        post.setContent(requestPost.content());
        post.setUser(userService.getUserById(requestPost.userId()));
        postRepository.save(post);
    }

    @Transactional
    public void updatePost(Long id, Post post) {
        Optional<Post> optionalPost = postRepository.findById(id);
        if (optionalPost.isEmpty()) throw new IllegalStateException("post to be update doesnt exist is this id");
        Post postToBeUpdated = optionalPost.get();
        postToBeUpdated.setContent(post.getContent());
        postToBeUpdated.setCreatedAt(post.getCreatedAt());
    }

    public void deletePost(Long id) {
        postRepository.deleteById(id);
    }
}
