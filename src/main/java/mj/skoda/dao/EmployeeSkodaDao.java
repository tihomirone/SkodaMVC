package mj.skoda.dao;

import mj.skoda.model.Person;

import java.util.List;

public interface EmployeeSkodaDao {

    void create(Person person);

    void update(Person person);

    Person getUserById(long id);

    List<Person> getAllUsers();

    void delete(long id);
}
