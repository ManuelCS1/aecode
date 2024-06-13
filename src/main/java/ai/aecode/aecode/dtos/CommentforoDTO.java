package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.Profile;

import java.time.LocalDate;

public class CommentforoDTO {
    private int id_comment;
    private Profile profile;
    private String comment_text;
    private LocalDate comment_date;

    public int getId_comment() {
        return id_comment;
    }

    public void setId_comment(int id_comment) {
        this.id_comment = id_comment;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public LocalDate getComment_date() {
        return comment_date;
    }

    public void setComment_date(LocalDate comment_date) {
        this.comment_date = comment_date;
    }
}
