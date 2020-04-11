package cn.cai.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cai.entity.Employee;
import cn.cai.repository.EmployeeDao;

@Service
public class EmployeeService
{
	@Autowired
	private EmployeeDao employeeDao;

	public Employee findeById(Integer id)
	{
		return employeeDao.getOne(id);
	}

	public List<Employee> findAll()
	{
		return employeeDao.findAll();
	}

	public void save(Employee employee)
	{
		employeeDao.save(employee);
	}

	public void deleteById(Integer id)
	{
		employeeDao.deleteById(id);
	}
}
