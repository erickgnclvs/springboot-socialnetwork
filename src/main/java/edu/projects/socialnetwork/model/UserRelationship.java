package edu.projects.socialnetwork.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "user_relationships", uniqueConstraints = @UniqueConstraint(columnNames = { "follower_id", "followee_id" }))
public class UserRelationship {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "follower_id", referencedColumnName = "id")
    @JsonIgnore
    private User follower;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "followee_id", referencedColumnName = "id")
    @JsonIgnore
    private User followee;

    public UserRelationship(User follower, User followee) {
        this.follower = follower;
        this.followee = followee;
    }

    public UserRelationship() {
    }

    @Override
    public String toString() {
        return "UserRelationship{" +
                "id=" + id +
                ", follower=" + follower +
                ", followee=" + followee +
                '}';
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }


    public User getFollower() {
        return follower;
    }

    public void setFollower(User follower) {
        this.follower = follower;
    }


    public User getFollowee() {
        return followee;
    }

    public void setFollowee(User followee) {
        this.followee = followee;
    }
}