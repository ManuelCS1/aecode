package ai.aecode.aecode.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_post;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @Column(name="post_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate post_date;
    @Column(name="post_content", length=254)
    private String post_content;
    @Lob
    @Column(name="post_description" )
    private String post_description;

    @PrePersist
    public void prePersist() {
        this.post_date = LocalDate.now();
    }

    public Post() {
    }

    public Post(int id_post, Profile profile, LocalDate post_date, String post_content, String post_description) {
        this.id_post = id_post;
        this.profile = profile;
        this.post_date = post_date;
        this.post_content = post_content;
        this.post_description = post_description;
    }

    public int getId_post() {
        return id_post;
    }

    public void setId_post(int id_post) {
        this.id_post = id_post;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public LocalDate getPost_date() {
        return post_date;
    }

    public void setPost_date(LocalDate post_date) {
        this.post_date = post_date;
    }

    public String getPost_content() {
        return post_content;
    }

    public void setPost_content(String post_content) {
        this.post_content = post_content;
    }

    public String getPost_description() {
        return post_description;
    }

    public void setPost_description(String post_description) {
        this.post_description = post_description;
    }
}
