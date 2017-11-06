package mj.skoda.dao;

import mj.skoda.model.Person;

import java.util.List;

public interface EmployeeSkodaDao {

    void create(Person employee);

    void update(Person employee);

    Person getEmployeeById(long id);

    List<Person> getAllEmployees();

    void delete(long id);
}
