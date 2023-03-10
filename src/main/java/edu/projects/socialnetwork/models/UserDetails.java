package edu.projects.socialnetwork.models;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.Objects;

@Entity
@Table(name = "user_details")
public class UserDetails {

    @Id
    private Long id;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;

    @Column(length = 500)
    private String biography;

    @Column(name = "date_of_birth")
    private LocalDate dateOfBirth;

    @Column
    private String location;

    @Column
    private String profilePictureUrl;

    public UserDetails() {
    }

    public UserDetails(Long id,
                       User user,
                       String biography,
                       LocalDate dateOfBirth,
                       String location,
                       String profilePictureUrl) {
        this.id = id;
        this.user = user;
        this.biography = biography;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.profilePictureUrl = profilePictureUrl;
    }

    public UserDetails(User user,
                       String biography,
                       LocalDate dateOfBirth,
                       String location,
                       String profilePictureUrl) {
        this.user = user;
        this.biography = biography;
        this.dateOfBirth = dateOfBirth;
        this.location = location;
        this.profilePictureUrl = profilePictureUrl;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getBiography() {
        return biography;
    }

    public void setBiography(String biography) {
        this.biography = biography;
    }

    public LocalDate getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(LocalDate dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetails that = (UserDetails) o;
        return Objects.equals(id, that.id) && Objects.equals(user, that.user) && Objects.equals(biography, that.biography) && Objects.equals(dateOfBirth, that.dateOfBirth) && Objects.equals(location, that.location) && Objects.equals(profilePictureUrl, that.profilePictureUrl);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, user, biography, dateOfBirth, location, profilePictureUrl);
    }

    @Override
    public String toString() {
        return "UserDetails{" +
                "id=" + id +
                ", user=" + user +
                ", biography='" + biography + '\'' +
                ", dateOfBirth=" + dateOfBirth +
                ", location='" + location + '\'' +
                ", profilePictureUrl='" + profilePictureUrl + '\'' +
                '}';
    }
}
