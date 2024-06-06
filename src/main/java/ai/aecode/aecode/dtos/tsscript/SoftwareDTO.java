package ai.aecode.aecode.dtos.tsscript;

import jakarta.persistence.Column;

public class SoftwareDTO {
    private int id_software;
    private String software_name;
    private String software_imagen;

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

    public String getSoftware_imagen() {
        return software_imagen;
    }

    public void setSoftware_imagen(String software_imagen) {
        this.software_imagen = software_imagen;
    }


}
