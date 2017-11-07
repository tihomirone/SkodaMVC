package mj.skoda.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_EDUCATION")
public class PersonEducation {

    @Id
    private long id;

    @Column(name = "GRADE")
    String grade;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }
}

