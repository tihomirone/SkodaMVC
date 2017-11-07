package mj.skoda.model;

import javax.persistence.*;

@Entity
@Table(name = "EMPLOYEE_EDUCATION")
public class PersonEducation {

    @Id
    private long id;

    @Column(name = "GRADE")
    String grade;
}

