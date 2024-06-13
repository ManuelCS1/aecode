package ai.aecode.aecode.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import org.springframework.cglib.core.Local;

import java.time.LocalDate;

@Entity
@Table(name = "commentforo")
public class Commentforo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_comment;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @Column (name="comment_text", length = 30, nullable = false)
    private String comment_text;
    @Column (name="comment_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate comment_date;

    @PrePersist
    public void prePersist() {
        this.comment_date = LocalDate.now();
    }

    public Commentforo() {
    }

    public Commentforo(int id_comment, Profile profile, String comment_text, LocalDate comment_date) {
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

    public LocalDate getComment_date() {
        return comment_date;
    }

    public void setComment_date(LocalDate comment_date) {
        this.comment_date = comment_date;
    }
}
