package ai.aecode.aecode.entities.InteractionScript;


import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="likescript")
public class LikeScript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_likescript;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "id_script")
    private Script script;

    @Column(name = "like_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate like_date;

    @Column(name = "like_status")
    private Boolean like_status;

    public LikeScript() {
    }
    @PrePersist
    public void prePersist() {
        this.like_date = LocalDate.now();
    }

    public LikeScript(int id_likescript, Profile profile, Script script, LocalDate like_date, Boolean like_status) {
        this.id_likescript = id_likescript;
        this.profile = profile;
        this.script = script;
        this.like_date = like_date;
        this.like_status = like_status;
    }

    public int getId_likescript() {
        return id_likescript;
    }

    public void setId_likescript(int id_likescript) {
        this.id_likescript = id_likescript;
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

    public LocalDate getLike_date() {
        return like_date;
    }

    public void setLike_date(LocalDate like_date) {
        this.like_date = like_date;
    }

    public Boolean getLike_status() {
        return like_status;
    }

    public void setLike_status(Boolean like_status) {
        this.like_status = like_status;
    }
}
