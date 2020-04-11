package cn.cai;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import cn.cai.entity.Employee;
import cn.cai.service.EmployeeService;

@SpringBootTest
class EmcApplicationTests {

	@Autowired
	EmployeeService employeeService;
	
	@Test
	void contextLoads() {
		Employee employee=new Employee();
		employee.setName("sdfasd");
		employeeService.save(employee);
	}

}
