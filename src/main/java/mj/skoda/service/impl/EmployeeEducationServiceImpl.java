package mj.skoda.service.impl;

import mj.skoda.dao.EmployeeEducationDao;
import mj.skoda.model.PersonEducation;
import mj.skoda.service.EmployeeEducationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service("EmployeeEducationService")
@Transactional
public class EmployeeEducationServiceImpl implements EmployeeEducationService {


    @Autowired
    private EmployeeEducationDao employeeEducationDao;

    @Override
    public PersonEducation getEmployeeEducationById(long id) {

        return employeeEducationDao.getEmployeeEducationById(id);
    }

    @Override
    public List<PersonEducation> getEmployeeEducationList() {

        return employeeEducationDao.getEmployeeEducationList();
    }
}
