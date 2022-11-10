package com.mirdu.EmployeeManagementSystem.service;

import java.util.ArrayList;
import java.util.List;

import com.mirdu.EmployeeManagementSystem.entity.Department;

public class DepartmentService {
	static List<Department> deptList = new ArrayList<Department>();

	public DepartmentService(){
		deptList.add(new Department(101,"DESIGN",0)); 
		deptList.add(new Department(102,"PRD",0));
		deptList.add(new Department(103,"DEVELOPEMENT",0));
	}
	public String addDepartment(Department d) {
		try {
			deptList.add(d);
			return "Department Added";
		} catch (Exception e) {
			return "Something Wrong";
		}
	}

	public Department getDepartment(String deptName) {
		try {
			for (Department d : deptList) {
				if (d.getDeptName().equals(deptName)) {
					return d;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}
	public Department viewDepartment(int deptId) {
		try {
			for (Department d : deptList) {
				if (d.getDeptId() == deptId) {
					return d;
				}
			}
		} catch (Exception e) {
			return null;
		}
		return null;
	}

	public List<Department> viewAllDepartment() {
		try {
			return deptList;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String updateDepartment(int deptId, String deptName) {
		try {
			for (Department d : deptList) {
				if (d.getDeptId() == deptId) {
					d.setDeptName(deptName);
					return "Department Updated";
				}
			}
			return "Invalid Department ID";
		}
		catch (Exception e) {
			return null;
		}
	}
	
	public String deleteDepartment(int deptId) {
		try {
			for (Department d : deptList) {
				if (d.getDeptId() == deptId) {
					deptList.remove(d);
					return "Department Deleted";
				}
			}
			return "Invalid Department ID";
		}catch(Exception e) {
			return "Something Wrong";
		}
	}
}










