package ai.aecode.aecode.dtos.tsscript;

import jakarta.persistence.Column;

public class ProgLangDTO {
    private int id_proglang;
    private String proglang_name;

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
