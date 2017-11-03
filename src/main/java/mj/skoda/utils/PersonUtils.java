package mj.skoda.utils;

import mj.skoda.model.Person;
import mj.skoda.service.EmployeeSkodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Service
public class PersonUtils {

    public void copyPersonInModelAndView(Person person, ModelAndView mv) {

        mv.addObject("id", person.getId());
        mv.addObject("firstName", person.getFirstName());
        mv.addObject("lastName", person.getLastName());
        mv.addObject("isMale", person.getIsMale());
        mv.addObject("birthday", person.getBirthday());
        mv.addObject("education", person.getEducation());
    }
}
