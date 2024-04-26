package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.Profile_detail;
import java.time.LocalDateTime;

public class PostDTO {
    private int id_post;
    private Profile_detail profile_detail;
    private LocalDateTime post_date;
    private String post_content;
    private String post_description;

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
