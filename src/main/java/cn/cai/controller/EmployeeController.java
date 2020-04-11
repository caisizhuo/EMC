package cn.cai.controller;

import java.util.Collection;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import cn.cai.entity.Department;
import cn.cai.entity.Employee;
import cn.cai.service.DepartmentService;
import cn.cai.service.EmployeeService;

@Controller
public class EmployeeController
{
	@Autowired
	EmployeeService employeeService;
	@Autowired
	DepartmentService departmentService;

	@GetMapping("/emps")
	public String getAllEmployee(Model model)
	{
		Collection<Employee> employees = employeeService.findAll();
		model.addAttribute("emps", employees);
		return "emps/list";
	}

	@GetMapping("/tolist")
	public String toAddPage(Model model)
	{
		Collection<Department> department = departmentService.findAll();
		model.addAttribute("department", department);
		return "emps/addlist";
	}

	@PostMapping("/add")
	public String addEmployee(Employee employee)
	{
		System.out.println("new employee===>" + employee);
		employeeService.save(employee);
		return "redirect:/emps";
	}

	@GetMapping("/modify/{id}")
	public String toModifyPage(@PathVariable("id") Integer id, Model model)
	{
		Collection<Department> department = departmentService.findAll();
		Employee employee = employeeService.findeById(id);
		model.addAttribute("emp", employee);
		model.addAttribute("department", department);
		return "emps/modifylist";
	}

	@PostMapping("/modify")
	public String modifyEmployee(Employee employee)
	{
		System.out.println("modify employee===>" + employee);
		employeeService.save(employee);
		return "redirect:/emps";
	}

	@GetMapping("/delete/{id}")
	public String deleteEmployee(@PathVariable("id") Integer id)
	{
		System.out.println("delete employee===>" + id);
		employeeService.deleteById(id);
		return "redirect:/emps";
	}

	@GetMapping("/userLogout")
	public String userLogout(HttpSession session)
	{
		session.invalidate();
		return "redirect:/index";

	}
}
