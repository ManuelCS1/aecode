package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name="prueba")
public class Prueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_prueba;
    @Column(name="prueba_name", length=15, nullable = false)
    private String prueba_name;
    @Column(name="prueba_description", length=254)
    private String prueba_description;
    @Column(name="prueba_multimedia", length=254)
    private String prueba_multimedia;

    public Prueba() {
    }

    public Prueba(int id_prueba, String prueba_name, String prueba_description, String prueba_multimedia) {
        this.id_prueba = id_prueba;
        this.prueba_name = prueba_name;
        this.prueba_description = prueba_description;
        this.prueba_multimedia = prueba_multimedia;
    }

    public int getId_prueba() {
        return id_prueba;
    }

    public void setId_prueba(int id_prueba) {
        this.id_prueba = id_prueba;
    }

    public String getPrueba_name() {
        return prueba_name;
    }

    public void setPrueba_name(String prueba_name) {
        this.prueba_name = prueba_name;
    }

    public String getPrueba_description() {
        return prueba_description;
    }

    public void setPrueba_description(String prueba_description) {
        this.prueba_description = prueba_description;
    }

    public String getPrueba_multimedia() {
        return prueba_multimedia;
    }

    public void setPrueba_multimedia(String prueba_multimedia) {
        this.prueba_multimedia = prueba_multimedia;
    }
}
