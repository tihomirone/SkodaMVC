package mj.skoda.service.impl;

import mj.skoda.dao.EmployeeSkodaDao;
import mj.skoda.model.Person;
import mj.skoda.service.EmployeeSkodaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

public class EmployeeSkodaServiceImpl implements EmployeeSkodaService {


    @Autowired
    EmployeeSkodaDao employeeSkodaDao;

    @Override
    public Person findById(long id) {
        return employeeSkodaDao.getUserById(id);
    }

    @Override
    public Person findByName(String name) {
        return null;
    }

    @Override
    public void saveUser(Person person) {

        employeeSkodaDao.create(person);
    }

    @Override
    public void updateUser(Person person) {

        employeeSkodaDao.update(person);
    }

    @Override
    public void deleteUserById(long id) {

        employeeSkodaDao.delete(id);
    }

    @Override
    public List<Person> findAllUsers() {
        return employeeSkodaDao.getAllUsers();
    }

    @Override
    public void deleteAllUsers() {
    }

    @Override
    public boolean isUserExist(Person user) {
        return false;
    }
}
