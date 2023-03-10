package edu.projects.socialnetwork.repositories;

import edu.projects.socialnetwork.models.User;
import edu.projects.socialnetwork.models.UserDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserDetailsRepository extends JpaRepository<UserDetails, Long> {

    Optional<UserDetails> findByUser(User user);
}
