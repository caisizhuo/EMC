package cn.cai.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;


import cn.cai.entity.Employee;

@Repository
public interface EmployeeDao
		extends JpaRepository<Employee, Integer>, JpaSpecificationExecutor<Employee>
{

}
