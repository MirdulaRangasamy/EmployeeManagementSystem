package com.mirdu.EmployeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.mirdu.EmployeeManagementSystem.entity.Department;
import com.mirdu.EmployeeManagementSystem.entity.Employee;

public class EmployeeService {
	private DepartmentService ds = new DepartmentService();
	static List<Employee> empList = new ArrayList<Employee>();

	public String addEmployee(Employee emp) {
		try {
			Department d = ds.getDepartment(emp.getEmpDept());
			d.setNoOfEmployee(d.getNoOfEmployee()+1);
			empList.add(emp);
			
			return "Employee Added";
		} catch (Exception e) {
			return "Something Wrong "+e;
		}
	}

	public Employee viewEmployee(int empId) {
		try {
			for (Employee d : empList) {
				if (d.getEmpId() == empId) {
					return d;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public List<Employee> viewAllEmployee() {
		try {
			return empList;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String updateEmployee(int empId, String key, String value) {
		try {
			for (Employee emp : empList) {
				if (emp.getEmpId() == empId) {
					if(key.equalsIgnoreCase("empName")) {
						emp.setEmpName(value);
					}
					else if(key.equalsIgnoreCase("empDept")) {
						emp.setEmpDept(value);
					}
					else if(key.equalsIgnoreCase("empSalary")) {
						emp.setEmpSalary(Double.parseDouble(value));
					}
					return "Employee Updated";
				}
			}
			return "Invalid Employee ID";
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public String deleteEmployee(int empId) {
		try {
			
			for (Employee emp : empList) {
				if (emp.getEmpId() == empId) {
					Department d = ds.getDepartment(emp.getEmpDept());
					d.setNoOfEmployee(d.getNoOfEmployee()-1);
					empList.remove(emp);
					return "Employee Deleted";
				}
			}
			return "Invalid Employee ID";
		}catch(Exception e) {
			return "Something Wrong";
		}
	}
	
}
