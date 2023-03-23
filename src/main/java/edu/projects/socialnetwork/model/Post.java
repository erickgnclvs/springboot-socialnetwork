package edu.projects.socialnetwork.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 280)
    private String content;

    @Column(nullable = false)
    private LocalDateTime createdAt;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    public Post(Long id, String content, LocalDateTime createdAt, User user) {
        this.id = id;
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }

    public Post() {
    }

    public Post(String content, LocalDateTime createdAt, User user) {
        this.content = content;
        this.createdAt = createdAt;
        this.user = user;
    }

//    @OneToMany(mappedBy = "posts")
//    private List<Comment> comments;

//    @OneToMany(mappedBy = "posts")
//    private List<Like> likes;
}