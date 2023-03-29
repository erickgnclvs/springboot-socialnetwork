package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.Like;
import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.record.RequestLike;
import edu.projects.socialnetwork.repository.LikeRepository;
import edu.projects.socialnetwork.repository.PostRepository;
import edu.projects.socialnetwork.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository, UserService userService, PostService postService) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Like> getLikesForPost(Post post) {
        return likeRepository.findAllByPost(post);
    }

    @Transactional
    public void createLike(RequestLike requestLike, Like like) {
        like.setUser(userRepository.getById(requestLike.user_id()));
        like.setPost(postRepository.getById(requestLike.post_id()));
        likeRepository.save(like);
    }

    @Transactional
    public void removeLike(RequestLike requestLike, Like like) {
        like.setUser(userRepository.getById(requestLike.user_id()));
        like.setPost(postRepository.getById(requestLike.post_id()));
        like = likeRepository.findByUserAndPost(like.getUser(), like.getPost());
        likeRepository.delete(like);
    }

    public List<Like> getLikesByUserId(Long userId) {
        return likeRepository.findByUserId(userId);
    }
}
