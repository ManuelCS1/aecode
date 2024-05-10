package ai.aecode.aecode.dtos;

import ai.aecode.aecode.entities.Profile;

import java.time.LocalDate;
import java.util.List;

public class CourseDTO {
    private int id_course;
    private Profile profile;
    private String course_name;
    private String course_description;
    private String course_price;
    private LocalDate course_data_creation;
    private boolean course_access;
    private List<String> course_hashtags;

    public int getId_course() {
        return id_course;
    }

    public void setId_course(int id_course) {
        this.id_course = id_course;
    }

    public Profile getProfile() {
        return profile;
    }

    public void setProfile(Profile profile) {
        this.profile = profile;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_price() {
        return course_price;
    }

    public void setCourse_price(String course_price) {
        this.course_price = course_price;
    }

    public LocalDate getCourse_data_creation() {
        return course_data_creation;
    }

    public void setCourse_data_creation(LocalDate course_data_creation) {
        this.course_data_creation = course_data_creation;
    }

    public boolean isCourse_access() {
        return course_access;
    }

    public void setCourse_access(boolean course_access) {
        this.course_access = course_access;
    }

    public List<String> getCourse_hashtags() {
        return course_hashtags;
    }

    public void setCourse_hashtags(List<String> course_hashtags) {
        this.course_hashtags = course_hashtags;
    }
}
