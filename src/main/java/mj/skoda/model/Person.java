package mj.skoda.model;

import javax.persistence.*;
import java.time.LocalDate;

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
    private LocalDate birthday;

    @Column(name="EDUCATION")
    private String education;

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

    public String getEducation() {
        return education;
    }
    public void setEducation(String education) {
        this.education = education;
    }
}
