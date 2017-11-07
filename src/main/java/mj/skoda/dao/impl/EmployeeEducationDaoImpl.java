package mj.skoda.dao.impl;

import mj.skoda.dao.EmployeeEducationDao;
import mj.skoda.model.Person;
import mj.skoda.model.PersonEducation;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import java.util.List;

@Repository
public class EmployeeEducationDaoImpl implements EmployeeEducationDao{

    @PersistenceContext
    private EntityManager entityManager;

    @Override
    public PersonEducation getEmployeeEducationById(long id) {

        return entityManager.find(PersonEducation.class, id);
    }

    @Override
    public List<PersonEducation> getEmployeeEducationList() {
        return getTypedQuery("SELECT pe FROM PersonEducation pe", PersonEducation.class).getResultList();
    }

    private TypedQuery<PersonEducation> getTypedQuery(String query, Class entity) {

        return entityManager.createQuery(query, entity);
    }
}
