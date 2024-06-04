package ai.aecode.aecode.dtos;
import ai.aecode.aecode.entities.Role;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class ProfileDTO {
    private int id_profile;
    private Role role;
    private String profile_Fullname;
    private String profile_Gender;
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate profile_Birthdate;
    private String profile_email;
    private String profile_password;

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getProfile_Fullname() {
        return profile_Fullname;
    }

    public void setProfile_Fullname(String profile_Fullname) {
        this.profile_Fullname = profile_Fullname;
    }

    public String getProfile_Gender() {
        return profile_Gender;
    }

    public void setProfile_Gender(String profile_Gender) {
        this.profile_Gender = profile_Gender;
    }

    public LocalDate getProfile_Birthdate() {
        return profile_Birthdate;
    }

    public void setProfile_Birthdate(LocalDate profile_Birthdate) {
        this.profile_Birthdate = profile_Birthdate;
    }

    public String getProfile_email() {
        return profile_email;
    }

    public void setProfile_email(String profile_email) {
        this.profile_email = profile_email;
    }

    public String getProfile_password() {
        return profile_password;
    }

    public void setProfile_password(String profile_password) {
        this.profile_password = profile_password;
    }

}
