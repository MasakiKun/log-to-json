package kr.ayukawa.jsonex.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Objects;

@ToString
public class Employee {
	@Getter @Setter
	private int employeeId;

	@Getter @Setter
	private String name = "";

	@Getter
	private int age = 0;

	@Getter
	private double salary = 0.0;

	public void setAge(int age) {
		if(age < 0)
			throw new IllegalArgumentException("age is not correct");

		this.age = age;
	}

	public void setSalary(double salary) {
		if(salary < 0)
			throw new IllegalArgumentException("salary is not correct");

		this.salary = salary;
	}

	public Employee(int employeeId, String name, int age, double salary) {
		this.setEmployeeId(employeeId);
		this.setName(name);
		this.setAge(age);
		this.setSalary(salary);
	}

	public Employee() {}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Employee employee = (Employee) o;
		return age == employee.age &&
				Double.compare(employee.salary, salary) == 0 &&
				Objects.equals(name, employee.name);
	}

	@Override
	public int hashCode() {
		return Objects.hash(name, age, salary);
	}
}
