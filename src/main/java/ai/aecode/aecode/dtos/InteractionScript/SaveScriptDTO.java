package ai.aecode.aecode.dtos.InteractionScript;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class SaveScriptDTO {
    private int id_savescript;
    private Profile profile;
    private Script script;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate save_date;
    private Boolean save_status;

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
