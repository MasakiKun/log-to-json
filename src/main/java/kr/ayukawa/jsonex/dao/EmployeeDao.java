package kr.ayukawa.jsonex.dao;

import kr.ayukawa.jsonex.exception.AlreadyStoreException;
import kr.ayukawa.jsonex.exception.NotFoundException;
import kr.ayukawa.jsonex.model.Employee;

import java.util.HashMap;
import java.util.Map;

public class EmployeeDao {
	private Map<Integer, Employee> employees = new HashMap<>();

	public void add(Employee emp) {
		if(employees.get(emp.getEmployeeId()) != null)
			throw new AlreadyStoreException("this employee is already stored");

		Integer id = emp.getEmployeeId();
		employees.put(id, emp);
	}

	public void remove(int employeeId) {
		if(employees.get(employeeId) == null)
			throw new NotFoundException("this employee is not found");

		employees.remove(employeeId);
	}

	public Employee findEmployee(int employeeId) {
		if(employees.get(employeeId) == null)
			throw new NotFoundException("this employee is not found");

		return employees.get(employeeId);
	}

	public void modify(Employee emp) {
		if(employees.get(emp.getEmployeeId()) == null)
			throw new NotFoundException("this employee is not found");

		Integer id = emp.getEmployeeId();
		employees.put(id, emp);
	}
}
