package mj.skoda.service;

import mj.skoda.model.PersonEducation;

import java.util.List;

public interface EmployeeEducationService {

    PersonEducation getEmployeeEducationById(long id);
    List<PersonEducation> getEmployeeEducationList();
}
