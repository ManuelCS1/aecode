package ai.aecode.aecode.dtos.InteractionScript;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ShareScriptDTO {
    private int id_sharescript;
    private Profile profile;
    private Script script;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate share_date;

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
