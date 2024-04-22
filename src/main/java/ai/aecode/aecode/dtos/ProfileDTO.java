package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.Role;
import jakarta.persistence.Column;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.time.LocalDateTime;

public class ProfileDTO {
    private int id_profile;
    private Role role;
    private String profile_email;
    private String username;
    private String profile_password;
    private LocalDateTime profile_creation_date;
    private LocalDateTime profile_last_session;

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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_password() {
        return profile_password;
    }

    public void setProfile_password(String profile_password) {
        this.profile_password = profile_password;
    }

    public LocalDateTime getProfile_creation_date() {
        return profile_creation_date;
    }

    public void setProfile_creation_date(LocalDateTime profile_creation_date) {
        this.profile_creation_date = profile_creation_date;
    }

    public LocalDateTime getProfile_last_session() {
        return profile_last_session;
    }

    public void setProfile_last_session(LocalDateTime profile_last_session) {
        this.profile_last_session = profile_last_session;
    }
}
