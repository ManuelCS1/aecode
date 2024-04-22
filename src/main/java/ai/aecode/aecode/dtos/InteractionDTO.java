package ai.aecode.aecode.dtos;
import ai.aecode.aecode.entities.Post;
import ai.aecode.aecode.entities.Profile_detail;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class InteractionDTO {
    private int id_interaction;
    private Post post;
    private Profile_detail profile_detail;
    private String interactionType;
    private String interaction_comment_content;
    private LocalDateTime interaction_date;

    public int getId_interaction() {
        return id_interaction;
    }

    public void setId_interaction(int id_interaction) {
        this.id_interaction = id_interaction;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public Profile_detail getProfile_detail() {
        return profile_detail;
    }

    public void setProfile_detail(Profile_detail profile_detail) {
        this.profile_detail = profile_detail;
    }

    public String getInteractionType() {
        return interactionType;
    }

    public void setInteractionType(String interactionType) {
        this.interactionType = interactionType;
    }

    public String getInteraction_comment_content() {
        return interaction_comment_content;
    }

    public void setInteraction_comment_content(String interaction_comment_content) {
        this.interaction_comment_content = interaction_comment_content;
    }

    public LocalDateTime getInteraction_date() {
        return interaction_date;
    }

    public void setInteraction_date(LocalDateTime interaction_date) {
        this.interaction_date = interaction_date;
    }
}
