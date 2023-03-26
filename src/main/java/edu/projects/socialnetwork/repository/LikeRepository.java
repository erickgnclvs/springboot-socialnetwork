package edu.projects.socialnetwork.repository;

import edu.projects.socialnetwork.model.Like;
import edu.projects.socialnetwork.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LikeRepository extends JpaRepository<Like, Long> {

    List<Like> findAllByPost(Post post);


}
