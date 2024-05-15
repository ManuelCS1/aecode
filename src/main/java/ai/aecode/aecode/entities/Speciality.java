package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name="speciality")
public class Speciality {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_speciality;
    @Column (name="speciality_name", length = 100, nullable = false)
    private String speciality_name;

    public Speciality() {
    }

    public Speciality(int id_speciality, String speciality_name) {
        this.id_speciality = id_speciality;
        this.speciality_name = speciality_name;
    }

    public int getId_speciality() {
        return id_speciality;
    }

    public void setId_speciality(int id_speciality) {
        this.id_speciality = id_speciality;
    }

    public String getSpeciality_name() {
        return speciality_name;
    }

    public void setSpeciality_name(String speciality_name) {
        this.speciality_name = speciality_name;
    }
}
