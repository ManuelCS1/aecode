package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name="software")
public class Software {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_software;
    @Column (name="software_name", length = 30, nullable = false)
    private String software_name;
    @Column(name="software_imagen", length=254)
    private String software_imagen;


    public Software() {
    }

    public Software(int id_software, String software_name, String software_imagen) {
        this.id_software = id_software;
        this.software_name = software_name;
        this.software_imagen = software_imagen;

    }

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
