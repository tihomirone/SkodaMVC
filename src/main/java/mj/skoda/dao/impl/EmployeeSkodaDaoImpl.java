package mj.skoda.dao.impl;

import mj.skoda.dao.EmployeeSkodaDao;
import mj.skoda.model.Person;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeSkodaDaoImpl implements EmployeeSkodaDao {

    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public void create(Person employee) {

        entityManager.persist(employee);
    }

    @Override
    public void update(Person employee) {

        entityManager.merge(employee);
    }

    @Override
    public Person getEmployeeById(long id) {

        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAllEmployees() {

        return getTypedQuery().getResultList();
    }

    @Override
    public void delete(long id) {

        Person person = getEmployeeById(id);
        if (person != null) {
            entityManager.remove(person);
        }
    }

    private TypedQuery<Person> getTypedQuery() {

        return entityManager.createQuery("SELECT p FROM Person p", Person.class);
    }
}
