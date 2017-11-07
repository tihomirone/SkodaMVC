package mj.skoda.dao.impl;

import mj.skoda.dao.EmployeeEducationDao;
import mj.skoda.dao.EmployeeSkodaDao;
import mj.skoda.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.lang.reflect.Type;
import java.util.List;

@Repository
public class EmployeeSkodaDaoImpl implements EmployeeSkodaDao {

    @PersistenceContext
    private EntityManager entityManager;

    @Autowired
    private EmployeeEducationDao employeeEducationDao;


    @Override
    public void create(Person employee) {

        employee.setEducation(employeeEducationDao.getEmployeeEducationById(employee.getEducation().getId()));
        entityManager.persist(employee);
    }

    @Override
    public void update(Person employee) {

        employee.setEducation(employeeEducationDao.getEmployeeEducationById(employee.getEducation().getId()));
        entityManager.merge(employee);
    }

    @Override
    public Person getEmployeeById(long id) {

        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAllEmployees() {

        return getTypedQuery("SELECT p FROM Person p", Person.class).getResultList();
    }

    @Override
    public List<Person> findEmployeesByFirstName(String personFirstName) {

        return getTypedQuery("SELECT p FROM Person p WHERE p.firstName LIKE :firstName", Person.class).setParameter("firstName", personFirstName).getResultList();
    }

    @Override
    public void delete(long id) {

        Person person = getEmployeeById(id);
        if (person != null) {
            entityManager.remove(person);
        }
    }

    private TypedQuery<Person> getTypedQuery(String query, Class entity) {

        return entityManager.createQuery(query, entity);
    }
}
