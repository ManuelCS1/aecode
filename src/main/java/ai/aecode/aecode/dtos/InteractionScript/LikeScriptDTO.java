package ai.aecode.aecode.dtos.InteractionScript;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class LikeScriptDTO {
    private int id_likescript;
    private Profile profile;
    private Script script;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate like_date;
    private Boolean like_status;

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
