package ai.aecode.aecode.dtos.tsscript;

import jakarta.persistence.Column;

public class SoftwareDTO {
    private int id_software;
    private String software_name;

    public int getId_software() {
        return id_software;
    }

    public void setId_software(int id_software) {
        this.id_software = id_software;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }
}
