package edu.projects.socialnetwork.repository;

import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.model.UserRelationship;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRelationshipRepository extends JpaRepository<UserRelationship, Long> {

    List<UserRelationship> findAllByFollowee(User user);

    List<UserRelationship> findAllByFollower(User user);
}
