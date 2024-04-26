package ai.aecode.aecode.entities;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
@Table(name="script")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_script;

    @ManyToOne
    @JoinColumn(name = "id_proglang")
    private ProgLang proglang;
    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;
    @ManyToOne
    @JoinColumn(name = "id_currency")
    private Currency currency;
    @ManyToOne
    @JoinColumn(name = "id_software")
    private Software software;
    @ManyToOne
    @JoinColumn(name = "id_tag")
    private Tag tag;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @Column(name="script_name", length=15, nullable = false)
    private String script_name;
    @Column(name="script_file", length=254)
    private String script_file;
    @Column(name="script_multimedia", length=254)
    private String script_multimedia;
    @Column(name="script_description", length=254)
    private String script_description;
    @Column(name="script_price")
    private Double script_price;

    public Script() {
    }


    public Script(int id_script, ProgLang proglang, Plan plan, Currency currency, Software software, Tag tag, Profile profile, String script_name, String script_file, String script_multimedia, String script_description, Double script_price) {
        this.id_script = id_script;
        this.proglang = proglang;
        this.plan = plan;
        this.currency = currency;
        this.software = software;
        this.tag = tag;
        this.profile = profile;
        this.script_name = script_name;
        this.script_file = script_file;
        this.script_multimedia = script_multimedia;
        this.script_description = script_description;
        this.script_price = script_price;
    }

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
