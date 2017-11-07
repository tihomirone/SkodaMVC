package mj.skoda.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "EMPLOYEE_SKODA")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "FIRST_NAME")
    private String firstName;

    @Column(name="LAST_NAME")
    private String lastName;

    @Column(name="IS_MALE")
    private boolean isMale;

    @Column(name="BIRTHDAY")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate birthday;

    /*@Column(name="EDUCATION")
    private String education;*/

    @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.REFRESH)
    @JoinColumn(name="EDUCATION_ID")
    private PersonEducation education;

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public boolean getIsMale() {
        return isMale;
    }
    public void setIsMale(boolean male) {
        isMale = male;
    }

    public LocalDate getBirthday() {
        return birthday;
    }
    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public PersonEducation getEducation() {
        return education;
    }
    public void setEducation(PersonEducation education) {
        this.education = education;
    }
}
