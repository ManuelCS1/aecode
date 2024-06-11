package ai.aecode.aecode.entities.InteractionScript;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="commentscript")
public class CommentScript {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_commentscript;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "id_script")
    private Script script;

    @Lob
    @Column(name = "comment_text", nullable = false)
    private String comment_text;

    @Column(name = "comment_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate comment_date;

    public CommentScript() {
    }
    @PrePersist
    public void prePersist() {
        this.comment_date = LocalDate.now();
    }

    public CommentScript(int id_commentscript, Profile profile, Script script, String comment_text, LocalDate comment_date) {
        this.id_commentscript = id_commentscript;
        this.profile = profile;
        this.script = script;
        this.comment_text = comment_text;
        this.comment_date = comment_date;
    }

    public int getId_commentscript() {
        return id_commentscript;
    }

    public void setId_commentscript(int id_commentscript) {
        this.id_commentscript = id_commentscript;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public Script getScript() {
        return script;
    }

    public void setScript(Script script) {
        this.script = script;
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
