package cn.cai.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.cai.entity.Department;
import cn.cai.repository.DepartmentDao;

@Service
public class DepartmentService
{
	@Autowired
	private DepartmentDao departmentDao;

	public Department findeById(Integer id)
	{
		return departmentDao.getOne(id);
	}

	public List<Department> findAll()
	{
		return departmentDao.findAll();
	}

	public void save(Department department)
	{
		departmentDao.save(department);
	}

}
