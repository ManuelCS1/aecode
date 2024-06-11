package ai.aecode.aecode.entities.InteractionScript;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="savescript")
public class SaveScript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_savescript;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "id_script")
    private Script script;

    @Column(name = "save_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate save_date;

    @Column(name = "save_status")
    private Boolean save_status;

    public SaveScript() {
    }

    @PrePersist
    public void prePersist() {
        this.save_date = LocalDate.now();
    }

    public SaveScript(int id_savescript, Profile profile, Script script, LocalDate save_date, Boolean save_status) {
        this.id_savescript = id_savescript;
        this.profile = profile;
        this.script = script;
        this.save_date = save_date;
        this.save_status = save_status;
    }

    public int getId_savescript() {
        return id_savescript;
    }

    public void setId_savescript(int id_savescript) {
        this.id_savescript = id_savescript;
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

    public LocalDate getSave_date() {
        return save_date;
    }

    public void setSave_date(LocalDate save_date) {
        this.save_date = save_date;
    }

    public Boolean getSave_status() {
        return save_status;
    }

    public void setSave_status(Boolean save_status) {
        this.save_status = save_status;
    }
}
