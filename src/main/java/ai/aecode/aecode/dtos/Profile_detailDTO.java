package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.Profile;
import ai.aecode.aecode.entities.Speciality;

import java.time.LocalDate;
import java.util.Set;

public class Profile_detailDTO {
    private int id_ProfileDetail;
    private Profile profile;
    private String detail_Country;
    private String detail_City;
    private String detail_Phone;
    private String detail_ProfilePicture;
    private String detail_Biography;
    private Set<Speciality> specialities;

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
