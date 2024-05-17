package ai.aecode.aecode.entities;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import java.util.Date;

@Entity
@Table(name = "comment")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comment;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @Column (name="comment_text", length = 30, nullable = false)
    private String comment_text;

    @CreationTimestamp
    @Column (name="comment_date")
    private Date comment_date;

    public Comment() {
    }

    public Comment(int id_comment, Profile profile, String comment_text, Date comment_date) {
        this.id_comment = id_comment;
        this.profile = profile;
        this.comment_text = comment_text;
        this.comment_date = comment_date;
    }

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

    public Date getComment_date() {
        return comment_date;
    }

    public void setComment_date(Date comment_date) {
        this.comment_date = comment_date;
    }
}
