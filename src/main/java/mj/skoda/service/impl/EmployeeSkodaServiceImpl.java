package mj.skoda.service.impl;

import mj.skoda.dao.EmployeeSkodaDao;
import mj.skoda.model.Person;
import mj.skoda.service.EmployeeSkodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("employeeSkodaService")
@Transactional
public class EmployeeSkodaServiceImpl implements EmployeeSkodaService {


    @Autowired
    EmployeeSkodaDao employeeSkodaDao;

    @Override
    public Person findById(long id) {
        return employeeSkodaDao.getEmployeeById(id);
    }

    @Override
    public Person findByName(String name) {
        return null;
    }

    @Override
    public void saveEmployee(Person person) {

        employeeSkodaDao.create(person);
    }

    @Override
    public void updateEmployee(Person person) {

        employeeSkodaDao.update(person);
    }

    @Override
    public void deleteEmployeeById(long id) {

        employeeSkodaDao.delete(id);
    }

    @Override
    public List<Person> findAllEmployees() {
        return employeeSkodaDao.getAllEmployees();
    }

    @Override
    public void deleteAllEmployees() {
    }

    @Override
    public boolean isEmployeeExist(Person user) {

        return false;
    }

    @Override
    public List<Person> findEmployeesByFirstName(String personFirstName) {

        return employeeSkodaDao.findEmployeesByFirstName(personFirstName);
    }
}
