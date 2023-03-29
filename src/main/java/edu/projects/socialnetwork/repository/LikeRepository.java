package edu.projects.socialnetwork.repository;

import edu.projects.socialnetwork.model.Like;
import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findAllByPost(Post post);

    Like findByUserAndPost(User user, Post post);

    List<Like> findByUserId(Long userId);
}
