package ai.aecode.aecode.entities;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.time.LocalDate;

@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_profile;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
    @Column(name = "profile_Fullname", length = 20, nullable = false)
    private String profile_Fullname;
    @Column(name = "profile_Gender", length = 10, nullable = false)
    private String profile_Gender;
    @Column(name = "profile_Birthdate", nullable = false)
    @JsonFormat(pattern = "dd-MM-yyyy")
    private LocalDate profile_Birthdate;
    @Column(name = "profile_email", length = 50, nullable = false)
    private String profile_email;
    @Column(name = "profile_password", length = 15, nullable = false)
    private String profile_password;


    public Profile() {
    }

    public Profile(int id_profile, Role role, String profile_Fullname, String profile_Gender, LocalDate profile_Birthdate, String profile_email, String profile_password) {
        this.id_profile = id_profile;
        this.role = role;
        this.profile_Fullname = profile_Fullname;
        this.profile_Gender = profile_Gender;
        this.profile_Birthdate = profile_Birthdate;
        this.profile_email = profile_email;
        this.profile_password = profile_password;
    }

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
}
