package ai.aecode.aecode.entities;

import jakarta.persistence.*;

import java.util.Set;

@Entity
@Table(name="profile_detail")
public class Profile_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ProfileDetail;
    @OneToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @Column(name="detail_Country", length=20)
    private String detail_Country;
    @Column(name="detail_City", length=20)
    private String detail_City;
    @Column(name="detail_Phone", length=15)
    private String detail_Phone;
    @Column(name="detail_ProfilePicture", length=244)
    private String detail_ProfilePicture;
    @Column(name="detail_Biography", length=244)
    private String detail_Biography;
    @ManyToMany
    @JoinTable(name = "detail_specialties",
            joinColumns = @JoinColumn(name = "id_ProfileDetail"),
            inverseJoinColumns = @JoinColumn(name = "id_speciality"))
    private Set<Speciality> specialities;

    public Profile_detail() {
    }

    public Profile_detail(int id_ProfileDetail, Profile profile, String detail_Country, String detail_City, String detail_Phone, String detail_ProfilePicture, String detail_Biography, Set<Speciality> specialities) {
        this.id_ProfileDetail = id_ProfileDetail;
        this.profile = profile;
        this.detail_Country = detail_Country;
        this.detail_City = detail_City;
        this.detail_Phone = detail_Phone;
        this.detail_ProfilePicture = detail_ProfilePicture;
        this.detail_Biography = detail_Biography;
        this.specialities = specialities;
    }

    public int getId_ProfileDetail() {
        return id_ProfileDetail;
    }

    public void setId_ProfileDetail(int id_ProfileDetail) {
        this.id_ProfileDetail = id_ProfileDetail;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getDetail_Country() {
        return detail_Country;
    }

    public void setDetail_Country(String detail_Country) {
        this.detail_Country = detail_Country;
    }

    public String getDetail_City() {
        return detail_City;
    }

    public void setDetail_City(String detail_City) {
        this.detail_City = detail_City;
    }

    public String getDetail_Phone() {
        return detail_Phone;
    }

    public void setDetail_Phone(String detail_Phone) {
        this.detail_Phone = detail_Phone;
    }

    public String getDetail_ProfilePicture() {
        return detail_ProfilePicture;
    }

    public void setDetail_ProfilePicture(String detail_ProfilePicture) {
        this.detail_ProfilePicture = detail_ProfilePicture;
    }

    public String getDetail_Biography() {
        return detail_Biography;
    }

    public void setDetail_Biography(String detail_Biography) {
        this.detail_Biography = detail_Biography;
    }

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
