package ai.aecode.aecode.dtos;

public class LoginDTO {
    private int id_profile;
    private String profile_email;
    private String profile_password;


    public LoginDTO() {
    }

    public LoginDTO(String profile_email, String profile_password) {
        this.profile_email = profile_email;
        this.profile_password = profile_password;
    }

    public int getId_profile() {
        return id_profile;
    }

    public void setId_profile(int id_profile) {
        this.id_profile = id_profile;
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
