package ai.aecode.aecode.entities;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Table(name="script")
public class Script {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_script;

    @ManyToMany
    @JoinTable(name = "detail_proglang",
            joinColumns = @JoinColumn(name = "id_script"),
            inverseJoinColumns = @JoinColumn(name = "id_proglang"))
    private Set<ProgLang> proglang;
    @ManyToOne
    @JoinColumn(name = "id_plan")
    private Plan plan;
    @ManyToOne
    @JoinColumn(name = "id_currency")
    private Currency currency;
    @ManyToMany
    @JoinTable(name = "detail_software",
            joinColumns = @JoinColumn(name = "id_script"),
            inverseJoinColumns = @JoinColumn(name = "id_software"))
    private Set<Software> software;
    @ManyToMany
    @JoinTable(name = "detail_tag",
            joinColumns = @JoinColumn(name = "id_script"),
            inverseJoinColumns = @JoinColumn(name = "id_tag"))
    private Set<Tag> tag;
    @ManyToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @Column(name="script_name", length=15, nullable = false)
    private String script_name;
    @Column(name="script_file", length=254)
    private String script_file;

    @ElementCollection
    @CollectionTable(name = "script_multimedias", joinColumns = @JoinColumn(name = "id_script"))
    @Column(name = "script_multimedia", length = 254)
    private List<String> script_multimedia = new ArrayList<>();

    @Column(name="script_description", length=254)
    private String script_description;
    @Column(name="script_price")
    private Double script_price;
    @Column(name="script_date")
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate script_date;

    public Script() {
    }
    @PrePersist
    public void prePersist() {
        this.script_date = LocalDate.now();
    }

    public Script(int id_script, Set<ProgLang> proglang, Plan plan, Currency currency, Set<Software> software, Set<Tag> tag, Profile profile, String script_name, String script_file, List<String> script_multimedia, String script_description, Double script_price, LocalDate script_date) {
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
        this.script_date = script_date;
    }

    public int getId_script() {
        return id_script;
    }

    public void setId_script(int id_script) {
        this.id_script = id_script;
    }

    public Set<ProgLang> getProglang() {
        return proglang;
    }

    public void setProglang(Set<ProgLang> proglang) {
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

    public Set<Software> getSoftware() {
        return software;
    }

    public void setSoftware(Set<Software> software) {
        this.software = software;
    }

    public Set<Tag> getTag() {
        return tag;
    }

    public void setTag(Set<Tag> tag) {
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

    public List<String> getScript_multimedia() {
        return script_multimedia;
    }

    public void setScript_multimedia(List<String> script_multimedia) {
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

    public LocalDate getScript_date() {
        return script_date;
    }

    public void setScript_date(LocalDate script_date) {
        this.script_date = script_date;
    }
}
