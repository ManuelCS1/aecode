package ai.aecode.aecode.entities;
import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name="profile")
public class Profile {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_profile;
    @ManyToOne
    @JoinColumn(name = "id_role")
    private Role role;
    @Column(name="profile_email", length=50, nullable = false)
    private String profile_email;
    @Column(name="username", length=15, nullable=false)
    private String username;
    @Column(name="profile_password", length=15, nullable=false)
    private String profile_password;

    public Profile() {
    }

    public Profile(int id_profile, Role role, String profile_email, String username, String profile_password) {
        this.id_profile = id_profile;
        this.role = role;
        this.profile_email = profile_email;
        this.username = username;
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

}
