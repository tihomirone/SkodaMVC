package mj.skoda.dao;

import mj.skoda.model.PersonEducation;

import java.util.List;

public interface EmployeeEducationDao {

    PersonEducation getEmployeeEducationById(long id);

    List<PersonEducation> getEmployeeEducationList();
}
