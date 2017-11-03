package mj.skoda.service;

import mj.skoda.model.Person;

import java.util.List;

public interface EmployeeSkodaService {

    Person findById(long id);

    Person findByName(String name);

    void saveUser(Person user);

    void updateUser(Person user);

    void deleteUserById(long id);

    List<Person> findAllUsers();

    void deleteAllUsers();

    public boolean isUserExist(Person user);
}
