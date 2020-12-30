package com.zinko.course.demo.course.ds;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.sql.Date;
import java.util.Objects;

@Entity
@AllArgsConstructor
@Getter
@Setter
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String content;
    private String image;
    private Date start_date;
    private String duration;
    private int fees;

    public Course() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Course))
            return false;

        Course course = (Course) o;
        return Objects.equals(this.id, course.id) &&
                Objects.equals(this.name, course.name) &&
                Objects.equals(this.content, course.content) &&
                Objects.equals(this.image, course.image) &&
                Objects.equals(this.start_date, course.start_date) &&
                Objects.equals(this.duration, course.duration) &&
                Objects.equals(this.fees, course.fees);
    }

    public int hashCode() {
        return Objects.hash(this.id, this.name, this.content, this.start_date, this.duration, this.image, this.fees);
    }

    @Override
    public String toString() {
        return "Course{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", content='" + content + '\'' +
                ", image='" + image + '\'' +
                ", start_date=" + start_date +
                ", duration='" + duration + '\'' +
                ", fees=" + fees +
                '}';
    }
}
