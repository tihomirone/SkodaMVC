package mj.skoda.service;

import mj.skoda.model.Person;

import java.util.List;

public interface EmployeeSkodaService {

    Person findById(long id);

    Person findByName(String name);

    void saveEmployee(Person user);

    void updateEmployee(Person user);

    void deleteEmployeeById(long id);

    List<Person> findAllEmployees();

    void deleteAllEmployees();

    public boolean isEmployeeExist(Person user);
}
