package model;

import javax.persistence.*;

@Entity
@Table(name = "enterprise")
public class Enterprise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;

    private String category;

    private String phone;

    private String specialization;

    private String services;

    private String ownership;

    private String work_time;

    public Enterprise() {
    }

    public Enterprise(String title, String category, String phone, String specialization, String services, String ownership, String work_time) {
        this.title = title;
        this.category = category;
        this.phone = phone;
        this.specialization = specialization;
        this.services = services;
        this.ownership = ownership;
        this.work_time = work_time;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getSpecialization() {
        return specialization;
    }

    public void setSpecialization(String specialization) {
        this.specialization = specialization;
    }

    public String getServices() {
        return services;
    }

    public void setServices(String services) {
        this.services = services;
    }

    public String getOwnership() {
        return ownership;
    }

    public void setOwnership(String ownership) {
        this.ownership = ownership;
    }

    public String getWork_time() {
        return work_time;
    }

    public void setWork_time(String work_time) {
        this.work_time = work_time;
    }

    @Override
    public String toString() {
        return "Enterprise{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", category='" + category + '\'' +
                ", phone=" + phone +
                ", specialization='" + specialization + '\'' +
                ", services='" + services + '\'' +
                ", ownership='" + ownership + '\'' +
                ", work_time='" + work_time + '\'' +
                '}';
    }
}
