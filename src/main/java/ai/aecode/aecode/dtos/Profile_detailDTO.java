package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.Profile;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;

import java.time.LocalDate;

public class Profile_detailDTO {
    private int id_ProfileDetail;
    private Profile profile;
    private String detail_Name;
    private String detail_Lastname;
    private String detail_Country;
    private String detail_City;
    private String detail_Phone;
    private LocalDate detail_Birthdate;
    private String detail_Gender;
    private String detail_ProfilePicture;
    private String detail_Biography;

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
