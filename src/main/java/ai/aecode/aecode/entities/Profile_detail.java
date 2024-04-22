package ai.aecode.aecode.entities;

import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="profile_detail")
public class Profile_detail {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_ProfileDetail;
    @OneToOne
    @JoinColumn(name = "id_profile")
    private Profile profile;
    @Column(name="detail_Name", length=15, nullable = false)
    private String detail_Name;
    @Column(name="detail_Lastname", length=15, nullable = false)
    private String detail_Lastname;
    @Column(name="detail_Country", length=15, nullable = false)
    private String detail_Country;
    @Column(name="detail_City", length=15, nullable = false)
    private String detail_City;
    @Column(name="detail_Phone", length=15, nullable = false)
    private String detail_Phone;
    @Column(name="detail_Birthdate", nullable = false)
    private LocalDate detail_Birthdate;
    @Column(name="detail_Gender", length=1, nullable = false)
    private String detail_Gender;
    @Column(name="detail_ProfilePicture", length=50, nullable = false)
    private String detail_ProfilePicture;
    @Column(name="detail_Biography", length=100, nullable = false)
    private String detail_Biography;

    public Profile_detail() {
    }

    public Profile_detail(int id_ProfileDetail, Profile profile, String detail_Name, String detail_Lastname, String detail_Country, String detail_City, String detail_Phone, LocalDate detail_Birthdate, String detail_Gender, String detail_ProfilePicture, String detail_Biography) {
        this.id_ProfileDetail = id_ProfileDetail;
        this.profile = profile;
        this.detail_Name = detail_Name;
        this.detail_Lastname = detail_Lastname;
        this.detail_Country = detail_Country;
        this.detail_City = detail_City;
        this.detail_Phone = detail_Phone;
        this.detail_Birthdate = detail_Birthdate;
        this.detail_Gender = detail_Gender;
        this.detail_ProfilePicture = detail_ProfilePicture;
        this.detail_Biography = detail_Biography;
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

    public String getDetail_Name() {
        return detail_Name;
    }

    public void setDetail_Name(String detail_Name) {
        this.detail_Name = detail_Name;
    }

    public String getDetail_Lastname() {
        return detail_Lastname;
    }

    public void setDetail_Lastname(String detail_Lastname) {
        this.detail_Lastname = detail_Lastname;
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

    public LocalDate getDetail_Birthdate() {
        return detail_Birthdate;
    }

    public void setDetail_Birthdate(LocalDate detail_Birthdate) {
        this.detail_Birthdate = detail_Birthdate;
    }

    public String getDetail_Gender() {
        return detail_Gender;
    }

    public void setDetail_Gender(String detail_Gender) {
        this.detail_Gender = detail_Gender;
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
}
