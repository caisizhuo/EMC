package cn.cai.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import cn.cai.entity.Department;
import cn.cai.entity.Employee;

@Repository
public class EmployeeDao
{
	private static Map<Integer, Employee> employees = null;
	@Autowired
	DepartmentDao departmentDao;
	static
	{
		employees = new HashMap<Integer, Employee>();
		employees.put(101, new Employee(101, "aa", "1234@qq.com", 1, new Department(1001, "运营部")));
		employees.put(102, new Employee(102, "aa", "1234@qq.com", 1, new Department(1002, "研发部")));
		employees.put(103, new Employee(103, "aa", "1234@qq.com", 1, new Department(1003, "人力部")));
		employees.put(104, new Employee(104, "aa", "1234@qq.com", 1, new Department(1004, "教学部")));

	}
	private static Integer id = 105;

	public void save(Employee employee)
	{
		if (null == employee.getId())
		{
			employee.setId(id++);
		}
		employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
		employees.put(employee.getId(), employee);
	}

	public Collection<Employee> getAllEmployees()
	{
		return employees.values();
	}

	public Employee getEmployeeById(Integer id)
	{
		return employees.get(id);
	}

	public void deleteEmployee(Integer id)
	{
		employees.remove(id);
	}
}
