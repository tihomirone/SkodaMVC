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
    public void create(Person user) {

        entityManager.persist(user);
    }

    @Override
    public void update(Person user) {

        entityManager.merge(user);
    }

    @Override
    public Person getUserById(long id) {

        return entityManager.find(Person.class, id);
    }

    @Override
    public List<Person> getAllUsers() {

        return getTypedQuery().getResultList();
    }

    @Override
    public void delete(long id) {

        Person person = getUserById(id);
        if (person != null) {
            entityManager.remove(person);
        }
    }

    private TypedQuery<Person> getTypedQuery() {

        return entityManager.createQuery("SELECT p FROM Person p", Person.class);
    }
}
