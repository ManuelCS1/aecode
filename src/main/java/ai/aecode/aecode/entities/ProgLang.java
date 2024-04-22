package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name="progLang")
public class ProgLang {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_proglang;
    @Column (name="proglang_name", length = 30, nullable = false)
    private String proglang_name;

    public ProgLang() {
    }

    public ProgLang(int id_proglang, String proglang_name) {
        this.id_proglang = id_proglang;
        this.proglang_name = proglang_name;
    }

    public int getId_proglang() {
        return id_proglang;
    }

    public void setId_proglang(int id_proglang) {
        this.id_proglang = id_proglang;
    }

    public String getProglang_name() {
        return proglang_name;
    }

    public void setProglang_name(String proglang_name) {
        this.proglang_name = proglang_name;
    }
}
