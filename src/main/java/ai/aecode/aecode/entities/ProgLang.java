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
    @Column(name="progLang_imagen", length=254)
    private String progLang_imagen;

    public ProgLang() {
    }

    public ProgLang(int id_proglang, String proglang_name, String progLang_imagen) {
        this.id_proglang = id_proglang;
        this.proglang_name = proglang_name;
        this.progLang_imagen = progLang_imagen;
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

    public String getProgLang_imagen() {
        return progLang_imagen;
    }

    public void setProgLang_imagen(String progLang_imagen) {
        this.progLang_imagen = progLang_imagen;
    }


}
