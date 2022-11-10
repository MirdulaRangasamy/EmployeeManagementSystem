package com.mirdu.EmployeeManagementSystem;

import java.util.Scanner;

import com.mirdu.EmployeeManagementSystem.entity.Employee;
import com.mirdu.EmployeeManagementSystem.service.DepartmentService;
import com.mirdu.EmployeeManagementSystem.service.EmployeeService;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	Scanner ip = new Scanner(System.in);
    	int choice = 0, opt = 0, empId;
    	EmployeeService es = new EmployeeService();
    	DepartmentService ds = new DepartmentService();
    
    	
    	System.out.println("Welcome to Employee Management System");
    	System.out.println("-------------------------------------\n");
    	System.out.println("What are you interested in?\n");
    	System.out.println("1. Employee Management \n2. Department Management");
    	System.out.println("Enter your choice:");
    	choice = ip.nextInt();
    	switch(choice) {
    	case 1:
    		char ch = 'y';
    		while(ch == 'y') {
    			System.out.println("Welcome to Employee Management");
        		
        		do {
        			System.out.println("1. Add Employee 2. View Employee 3.View All Employee 4. Update Employee 5.Delete Employee" );
            		opt = ip.nextInt();
        			
        		switch(opt) {
        		case 1: 
        			System.out.println("ENter the employee details:");
        			System.out.println("Enter employee ID:");
        			empId = ip.nextInt();
        			System.out.println("Enter employee Name:");
        			String empName = ip.next();
        			System.out.println("Enter employee department Name:");
        			String deptName = ip.next();
        			System.out.println("Enter employee salary :");
        			double empSalary = ip.nextDouble();
        			System.out.println(es.addEmployee(new Employee(empId, empName, deptName, empSalary)));
        			break;
        		case 2:
        			System.out.println("ENter the employee details:");
        			System.out.println("Enter employee ID:");
        			empId = ip.nextInt();
        			System.out.println(es.viewEmployee(empId));
        			break;
        		case 3:
        			System.out.println("Vlew All EMployee");
        			System.out.println(es.viewAllEmployee());
        			break;
        		case 4:
        			System.out.println("Enter the employee details:");
        			System.out.println("Enter employee ID:");
        			empId = ip.nextInt();
        			System.out.println("Enter the field to be modified");
        			String key = ip.next();
        			String value = ip.next();
        			System.out.println(es.updateEmployee(empId, key, value));
        			break;
        		case 5:
        			System.out.println("Enter the employee details:");
        			System.out.println("Enter employee ID:");
        			empId = ip.nextInt();
        			es.deleteEmployee(empId);
        			break;
    		}
        		System.out.println("Would you like to continue? y / n");
        		ch = ip.next().charAt(0);
    		}while(ch == 'y');
    		break;
    		
    	}
    	
    }
}}

