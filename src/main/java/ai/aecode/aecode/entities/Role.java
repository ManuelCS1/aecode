package ai.aecode.aecode.entities;
import jakarta.persistence.*;

@Entity
@Table(name="role")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_role;
    @Column (name="role_name", length = 30, nullable = false)
    private String role_name;
    @Column (name="role_description", length = 150, nullable = false)
    private String role_description;

    public Role() {
    }

    public Role(int id_role, String role_name, String role_description) {
        this.id_role = id_role;
        this.role_name = role_name;
        this.role_description = role_description;
    }

    public int getId_role() {
        return id_role;
    }

    public void setId_role(int id_role) {
        this.id_role = id_role;
    }

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }

    public String getRole_description() {
        return role_description;
    }

    public void setRole_description(String role_description) {
        this.role_description = role_description;
    }
}
