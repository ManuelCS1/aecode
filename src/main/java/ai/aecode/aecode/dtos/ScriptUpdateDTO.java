package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.Tag;

import java.util.Set;

public class ScriptUpdateDTO {
    private int id_script;
    private Set<Tag> tag;
    private String script_description;

    public int getId_script() {
        return id_script;
    }

    public void setId_script(int id_script) {
        this.id_script = id_script;
    }

    public Set<Tag> getTag() {
        return tag;
    }

    public void setTag(Set<Tag> tag) {
        this.tag = tag;
    }

    public String getScript_description() {
        return script_description;
    }

    public void setScript_description(String script_description) {
        this.script_description = script_description;
    }
}
