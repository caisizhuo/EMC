package cn.cai.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import cn.cai.entity.Department;
import cn.cai.entity.Employee;
import cn.cai.repository.DepartmentDao;
import cn.cai.repository.EmployeeDao;

@Controller
public class EmployeeController
{
	@Autowired
	EmployeeDao employeeDao;
	@Autowired
	DepartmentDao departmentDao;

	@GetMapping("/emps")
	public String getAllEmployee(Model model)
	{
		Collection<Employee> employees = employeeDao.getAllEmployees();
		model.addAttribute("emps", employees);
		return "emps/list";
	}

	@GetMapping("/tolist")
	public String toAddPage(Model model)
	{
		Collection<Department> department = departmentDao.getAllDepartment();
		model.addAttribute("department", department);
		return "emps/addlist";
	}

	@PostMapping("/add")
	public String addEmployee(Employee employee)
	{
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
	
	@GetMapping("/modify/{id}")
	public String toModifyPage(@PathVariable("id") Integer id,Model model)
	{
		Collection<Department> department = departmentDao.getAllDepartment();
		Employee employee=employeeDao.getEmployeeById(id);
		model.addAttribute("emp", employee);
		model.addAttribute("department", department);
		return "emps/modifylist";
	}
	

	@PostMapping("/modify")
	public String modifyEmployee(Employee employee)
	{
		System.out.println(employee);
		employeeDao.save(employee);
		return "redirect:/emps";
	}
}
