package edu.projects.socialnetwork.models;

import jakarta.persistence.*;

@Entity
@Table(name = "user_details")
public class UserProfile {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    
}
