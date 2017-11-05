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
import mj.skoda.service.EmployeeSkodaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class SkodaMVCController {

	@Value("${application.message:Hello World}")
	private String message = "Hello World";

	@Autowired
	EmployeeSkodaService employeeSkodaService;

	@GetMapping("/")
	public String welcome(Map<String, Object> model) {
		model.put("time", new Date());
		model.put("message", this.message);
		return "welcome";
	}

	@RequestMapping(value = "/allSkodaEmployees", method = RequestMethod.GET)
	public ModelAndView listAllSkodaEmployees() {

		ModelAndView mv = new ModelAndView("listAllSkodaEmployees");

//		mv.addObject("listPersons", employeeSkodaService.findAllEmployees());

		return mv;

	}

	@RequestMapping(value = "/employee/add", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("person") Person person) {

		ModelAndView mv = new ModelAndView("listAllSkodaEmployees");
		return mv;
	}

	@RequestMapping(value = "/employee/save", method = RequestMethod.POST)
	public ModelAndView saveEmployee(@ModelAttribute("person") Person person) {

		employeeSkodaService.saveEmployee(person);

		ModelAndView mv = new ModelAndView("listAllSkodaEmployees");
		mv.addObject("listPersons", employeeSkodaService.findAllEmployees());
		return mv;
	}


	@GetMapping("/test")
	public String test(Map<String, Object> model) {

		model.put("time", new Date());
		model.put("message", "Person test");
		return "personTest";
	}

	@RequestMapping(value = "/test2", method = RequestMethod.GET)
	public ModelAndView test2(HttpServletRequest request, HttpServletResponse response) {

		ModelAndView modelAndView = new ModelAndView("personTest2");
		modelAndView.addObject("time", new Date());
		modelAndView.addObject("message", "Person Test 2");
		return modelAndView;
	}

	@RequestMapping("/foo")
	public String foo(Map<String, Object> model) {
		throw new RuntimeException("Foo");
	}

}
