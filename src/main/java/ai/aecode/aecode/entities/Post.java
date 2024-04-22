package ai.aecode.aecode.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="Post")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_post;
    @ManyToOne
    @JoinColumn(name = "id_ProfileDetail")
    private Profile_detail profile_detail;
    @Column(name="post_date", nullable = false)
    private LocalDateTime post_date;
    @Column(name="post_content", length=254, nullable = false)
    private String post_content;
    @Column(name="post_description", length=254, nullable = false)
    private String post_description;

    public Post() {
    }

    public Post(int id_post, Profile_detail profile_detail, LocalDateTime post_date, String post_content, String post_description) {
        this.id_post = id_post;
        this.profile_detail = profile_detail;
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

    public Profile_detail getProfile_detail() {
        return profile_detail;
    }

    public void setProfile_detail(Profile_detail profile_detail) {
        this.profile_detail = profile_detail;
    }

    public LocalDateTime getPost_date() {
        return post_date;
    }

    public void setPost_date(LocalDateTime post_date) {
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
