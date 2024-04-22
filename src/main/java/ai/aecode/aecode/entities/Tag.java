package ai.aecode.aecode.entities;

import jakarta.persistence.*;

@Entity
@Table(name="tag")
public class Tag {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id_tag;
    @Column (name="tag_name", length = 30, nullable = false)
    private String tag_name;

    public Tag() {
    }

    public Tag(int id_tag, String tag_name) {
        this.id_tag = id_tag;
        this.tag_name = tag_name;
    }

    public int getId_tag() {
        return id_tag;
    }

    public void setId_tag(int id_tag) {
        this.id_tag = id_tag;
    }

    public String getTag_name() {
        return tag_name;
    }

    public void setTag_name(String tag_name) {
        this.tag_name = tag_name;
    }
}
