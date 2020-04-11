package cn.cai.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employee")
public class Employee
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "emp_id")
	private Integer id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_email")
	private String email;
	@Column(name = "emp_gender")
	private Integer gender;
	@Column(name = "emp_birth")
	private Date birth;
	@ManyToOne(targetEntity = Department.class)
	@JoinColumn(name = "dep_id", referencedColumnName = "dep_id")
	private Department department;

	public Employee(Integer id, String name, String email, Integer gender, Department department)
	{
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.gender = gender;
		this.department = department;
	}

}
