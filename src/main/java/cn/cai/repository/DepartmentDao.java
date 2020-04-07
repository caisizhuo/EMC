package cn.cai.repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Repository;

import cn.cai.entity.Department;

@Repository
public class DepartmentDao
{
	private static Map<Integer, Department> departments = null;

	static
	{
		departments = new HashMap<Integer, Department>();
		departments.put(1001, new Department(1001, "运营部"));
		departments.put(1002, new Department(1002, "研发部"));
		departments.put(1003, new Department(1003, "人力部"));
		departments.put(1004, new Department(1004, "后勤部"));
		departments.put(1005, new Department(1005, "教学部"));
		departments.put(1006, new Department(1006, "教研部"));
	}

	public Collection<Department> getAllDepartment()
	{
		return departments.values();
	}

	public Department getDepartmentById(Integer id)
	{
		return departments.get(id);
	}
}
