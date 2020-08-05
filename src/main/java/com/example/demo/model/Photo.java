package com.example.demo.model;

import org.springframework.stereotype.Component;
import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Component
@Entity
@Table(schema = "public" , name = "photo")
public class Photo {

    @Id
    @Column(length = 20)
    @GeneratedValue( strategy = GenerationType.IDENTITY /*strategy = GenerationType.SEQUENCE , generator = "sequence" */)
//    @SequenceGenerator( name = "sequence" , initialValue = 1 , allocationSize = 1)
    private int id;

    @Column(length = 120)
    private String Title;

    @Column(length = 255)
    private String description;

    @Column(length = 20 )
    private String privacy;

    @Column
    private Date uploadDate;

    @Column(length = 10 , name = "view_")
    private Integer view;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return Title;
    }

    public void setTitle(String title) {
        Title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPrivacy() {
        return privacy;
    }

    public void setPrivacy(String privacy) {
        this.privacy = privacy;
    }

    public Date getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(Date uploadDate) {
        this.uploadDate = uploadDate;
    }

    public Integer getView() {
        return this.view;
    }

    public void setView(Integer view_) {
        this.view = view_;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Photo photo = (Photo) o;
        return id == photo.id &&
                Objects.equals(Title, photo.Title) &&
                Objects.equals(description, photo.description) &&
                Objects.equals(privacy, photo.privacy) &&
                Objects.equals(uploadDate, photo.uploadDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, Title, description, privacy, uploadDate, view);
    }

    @Override
    public String toString() {
        return "Photo{" +
                "id=" + id +
                ", Title='" + Title + '\'' +
                ", description='" + description + '\'' +
                ", privacy='" + privacy + '\'' +
                ", uploadDate=" + uploadDate +
                '}';
    }
}
