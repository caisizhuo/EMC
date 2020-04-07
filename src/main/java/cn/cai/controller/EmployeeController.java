package cn.cai.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import cn.cai.entity.Employee;
import cn.cai.repository.EmployeeDao;

@Controller
public class EmployeeController
{
	@Autowired
	EmployeeDao employeeDao;

	@GetMapping("/emps")
	public String getAllEmployee(Model model)
	{
		  Collection<Employee> employees = employeeDao.getAllEmployees();
		  model.addAttribute("emps",employees);
		  return "emps/list";
	}
}
