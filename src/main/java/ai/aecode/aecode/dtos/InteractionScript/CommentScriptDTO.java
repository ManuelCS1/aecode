package ai.aecode.aecode.dtos.InteractionScript;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Script;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.time.LocalDate;

public class CommentScriptDTO {

    private int id_commentscript;
    private Profile profile;
    private Script script;
    private String comment_text;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate comment_date;

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
