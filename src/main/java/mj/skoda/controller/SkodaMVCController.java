/*
 * Copyright 2012-2016 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package mj.skoda.controller;

import java.util.Date;
import java.util.Map;

import mj.skoda.model.Person;
import mj.skoda.service.EmployeeEducationService;
import mj.skoda.service.EmployeeSkodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SkodaMVCController {

	final private static String EMPLOYEE_ACTION_EDIT = "edit";
	final private static String EMPLOYEE_ACTION_VIEW = "view";
	final private static String EMPLOYEE_ACTION_ADD = "add";

	final private static String EMPLOYEE_LIST_SEARCH = "search";

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@Autowired
	private EmployeeSkodaService employeeSkodaService;

	@Autowired
	private EmployeeEducationService employeeEducationService;

	/*@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}*/

	@RequestMapping(value = {"/", "/allSkodaEmployees"}, method = RequestMethod.GET)
	public ModelAndView listAllSkodaEmployees() {

		ModelAndView mv = new ModelAndView("listAllSkodaEmployees");
		mv.addObject("searchPerson", new Person());
		mv.addObject("listPersons", employeeSkodaService.findAllEmployees());

		return mv;

	}

	@RequestMapping(value = "/employee/search", method = RequestMethod.POST)
	public ModelAndView searchEmployee(@ModelAttribute("searchPerson") Person person) {

		ModelAndView mv = new ModelAndView("listAllSkodaEmployees");
		mv.addObject("action", this.EMPLOYEE_LIST_SEARCH);
		mv.addObject("searchPerson", new Person());
		mv.addObject("listPersons", employeeSkodaService.findEmployeesByFirstName(person.getFirstName()));

		return mv;
	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("person") Person person) {

		ModelAndView mv = new ModelAndView("employeeView");
		mv.addObject("searchByFirstName", "");
		mv.addObject("employeeEducationList", employeeEducationService.getEmployeeEducationList());
		mv.addObject("action", this.EMPLOYEE_ACTION_ADD);
		return mv;
	}

	@RequestMapping(value = "/employee/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("person") Person person) {

		employeeSkodaService.saveEmployee(person);

		return listAllSkodaEmployees();
	}

	@RequestMapping(value = "/employee/remove/{id}", method = RequestMethod.GET)
	public ModelAndView removeEmployee(@PathVariable("id") long id) {

		employeeSkodaService.deleteEmployeeById(id);

		return listAllSkodaEmployees();
	}

	@RequestMapping(value = "/employee/edit/{id}", method = RequestMethod.GET)
	public ModelAndView editEmployee(@PathVariable("id") long id) {

		ModelAndView mv = new ModelAndView("employeeView");
		mv.addObject("person", employeeSkodaService.findById(id));
		mv.addObject("employeeEducationList", employeeEducationService.getEmployeeEducationList());
		mv.addObject("action", this.EMPLOYEE_ACTION_EDIT);

		return mv;
	}

	@RequestMapping(value = "/employee/update", method = RequestMethod.POST)
	public ModelAndView updateEmployee(@ModelAttribute("person") Person person) {

		employeeSkodaService.updateEmployee(person);

		return listAllSkodaEmployees();
	}

	@RequestMapping(value = "/employee/view/{id}", method = RequestMethod.GET)
	public ModelAndView viewEmployee(@PathVariable("id") long id) {

		ModelAndView mv = new ModelAndView("employeeView");
		mv.addObject("person", employeeSkodaService.findById(id));
		mv.addObject("employeeEducationList", employeeEducationService.getEmployeeEducationList());
		mv.addObject("action", this.EMPLOYEE_ACTION_VIEW);

		return mv;
	}

}
