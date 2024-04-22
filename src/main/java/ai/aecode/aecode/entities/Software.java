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

    public Software() {
    }

    public Software(int id_software, String software_name) {
        this.id_software = id_software;
        this.software_name = software_name;
    }

    public int getId_Software() {
        return id_software;
    }

    public void setId_Software(int id_software) {
        this.id_software = id_software;
    }

    public String getSoftware_name() {
        return software_name;
    }

    public void setSoftware_name(String software_name) {
        this.software_name = software_name;
    }
}
