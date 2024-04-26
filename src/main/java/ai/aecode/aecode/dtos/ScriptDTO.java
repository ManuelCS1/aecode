package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.*;
import jakarta.persistence.*;

import java.time.LocalDateTime;

public class ScriptDTO {
    private int id_script;
    private ProgLang proglang;
    private Plan plan;
    private Currency currency;
    private Software software;
    private Tag tag;
    private Profile profile;
    private String script_name;
    private String script_file;
    private String script_multimedia;
    private String script_description;
    private Double script_price;

    public int getId_script() {
        return id_script;
    }

    public void setId_script(int id_script) {
        this.id_script = id_script;
    }

    public ProgLang getProglang() {
        return proglang;
    }

    public void setProglang(ProgLang proglang) {
        this.proglang = proglang;
    }

    public Plan getPlan() {
        return plan;
    }

    public void setPlan(Plan plan) {
        this.plan = plan;
    }

    public Currency getCurrency() {
        return currency;
    }

    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getScript_name() {
        return script_name;
    }

    public void setScript_name(String script_name) {
        this.script_name = script_name;
    }

    public String getScript_file() {
        return script_file;
    }

    public void setScript_file(String script_file) {
        this.script_file = script_file;
    }

    public String getScript_multimedia() {
        return script_multimedia;
    }

    public void setScript_multimedia(String script_multimedia) {
        this.script_multimedia = script_multimedia;
    }

    public String getScript_description() {
        return script_description;
    }

    public void setScript_description(String script_description) {
        this.script_description = script_description;
    }

    public Double getScript_price() {
        return script_price;
    }

    public void setScript_price(Double script_price) {
        this.script_price = script_price;
    }
}
