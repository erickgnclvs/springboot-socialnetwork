package edu.projects.socialnetwork.repository;

import edu.projects.socialnetwork.model.Post;
import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.service.UserService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Repository
public interface PostRepository extends JpaRepository<Post, Long> {


    Optional<List<Post>> findAllByUser(User user);

    List<Post> findAllByOrderByCreatedAtDesc();
}
