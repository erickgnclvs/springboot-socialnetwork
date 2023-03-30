package edu.projects.socialnetwork.service;

import edu.projects.socialnetwork.model.User;
import edu.projects.socialnetwork.model.UserRelationship;
import edu.projects.socialnetwork.repository.UserRelationshipRepository;
import edu.projects.socialnetwork.repository.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserRelationshipService {

    private final UserRepository userRepository;
    private final UserRelationshipRepository userRelationshipRepository;

    public UserRelationshipService(UserRepository userRepository, UserRelationshipRepository userRelationshipRepository) {
        this.userRepository = userRepository;
        this.userRelationshipRepository = userRelationshipRepository;
    }

    public List<UserRelationship> getFollowersByUsername(String username) {
        User user = userRepository.findUserByUsername(username).orElseThrow();
        return userRelationshipRepository.findAllByFollowee(user);
    }

    @Transactional
    public void followUser(String username, Long followerId, UserRelationship userRelationship) {
        User followee = userRepository.findUserByUsername(username).orElseThrow();
        User follower = userRepository.findById(followerId).orElseThrow();
        userRelationship.setFollowee(followee);
        userRelationship.setFollower(follower);
        userRelationshipRepository.save(userRelationship);
    }
}
