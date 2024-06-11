package ai.aecode.aecode.entities.InteractionScript;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="sharescript")
public class ShareScript {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_sharescript;

    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;

    @ManyToOne
    @JoinColumn(name = "id_script")
    private Script script;

    @Column(name = "share_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate share_date;

    public ShareScript() {
    }
    @PrePersist
    public void prePersist() {
        this.share_date = LocalDate.now();
    }

    public ShareScript(int id_sharescript, Profile profile, Script script, LocalDate share_date) {
        this.id_sharescript = id_sharescript;
        this.profile = profile;
        this.script = script;
        this.share_date = share_date;
    }

    public int getId_sharescript() {
        return id_sharescript;
    }

    public void setId_sharescript(int id_sharescript) {
        this.id_sharescript = id_sharescript;
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

    public LocalDate getShare_date() {
        return share_date;
    }

    public void setShare_date(LocalDate share_date) {
        this.share_date = share_date;
    }
}
