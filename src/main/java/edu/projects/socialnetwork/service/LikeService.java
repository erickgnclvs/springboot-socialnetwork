package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.Like;
import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.repository.LikeRepository;
import edu.projects.socialnetwork.repository.PostRepository;
import edu.projects.socialnetwork.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LikeService {

    private final LikeRepository likeRepository;
    private final UserRepository userRepository;
    private final PostRepository postRepository;

    @Autowired
    public LikeService(LikeRepository likeRepository, UserRepository userRepository, PostRepository postRepository) {
        this.likeRepository = likeRepository;
        this.userRepository = userRepository;
        this.postRepository = postRepository;
    }

    public List<Like> getLikesForPost(Post post) {
        return likeRepository.findAllByPost(post);
    }
}
