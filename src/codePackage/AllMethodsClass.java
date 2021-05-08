package codePackage;

import java.util.List;
import java.util.Scanner;

public class AllMethodsClass {

	static Scanner sc = new Scanner(System.in);
	
	public void addEmployee(List<Employee> employeeList) {
		do {
			System.out.print("Enter Employee Name : ");
			String empName = sc.nextLine().trim();
			System.out.print("Enter Employee Age : ");
			int empAge = sc.nextInt();
			sc.nextLine();
			System.out.print("Enter Employee Address : ");
			String empAddress = sc.nextLine().trim();
			long empId = 10125 + (employeeList.size()-1) + 1;
			Employee e = new Employee(empId, empName, empAge, empAddress);
			employeeList.add(e);
			System.out.println("EMPLOYEE ADDED SUCCESFULLY !!\n");
			System.out.print("DO YOU WANT TO ADD MORE EMPLOYEE ? (Y/N) : ");
		} while(sc.nextLine().trim().equalsIgnoreCase("Y"));
	}
	
	public void updateEmployee(List<Employee> employeeList) {
		System.out.print("Enter Employee ID / INDEX : ");
		long id = sc.nextLong();
		sc.nextLine();
		Employee emp = null;
		for(Employee e : employeeList) {
			if(e.getEmpId()==id||e.getEmpId()==10125+id) {
				emp = e;
				break;
			}
		}
		if (emp == null) {
			System.out.println("INVALID EMPLOYEE ID");
			return;
		}
		System.out.print("Enter the field you want to UPDATE (NAME/AGE/ADDRESS) : ");
		String str = sc.nextLine();
		if(str.trim().equalsIgnoreCase("NAME")) {
			System.out.print("Enter new NAME : ");
			emp.setEmpName(sc.nextLine());
			System.out.println("EMPLOYEE DETAILS UPDATED SUCCESFULLY !!");
		}
		else if (str.trim().equalsIgnoreCase("AGE")) {
			System.out.print("Enter new AGE : ");
			emp.setEmpAge(sc.nextInt());
			System.out.println("EMPLOYEE DETAILS UPDATED SUCCESFULLY !!");
		}
		else if (str.trim().toUpperCase().contains("ADDR")) {
			System.out.print("Enter new ADDRESS : ");
			emp.setEmpAddress(sc.nextLine());
			System.out.println("EMPLOYEE DETAILS UPDATED SUCCESFULLY !!");
		}
		else {
			System.out.println("INVALID INPUT");
		}
	}
	
	public void getEmployee(List<Employee> employeeList, int id) {
		Employee emp = null;
		for(Employee e : employeeList) {
			if(e.getEmpId()==id||e.getEmpId()==10125+id) {
				emp = e;
				break;
			}
		}
		if (emp == null) {
			System.out.println("INVALID EMPLOYEE ID");
			return;
		}
		System.out.println("empID\tempName\t\tempAge\tempAddress");
		System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpAge()+"\t"+emp.getEmpAddress());
	}

	public void getAllEmployee(List<Employee> employeeList) {
		System.out.println("empID\tempName\t\tempAge\tempAddress");
		for(Employee emp : employeeList) {
			System.out.println(emp.getEmpId()+"\t"+emp.getEmpName()+"\t"+emp.getEmpAge()+"\t"+emp.getEmpAddress());
		}
	}

	public void deleteEmployee(List<Employee> employeeList) {
		System.out.print("Enter Employee ID / INDEX : ");
		long id = sc.nextLong();
		Employee emp = null;
		for(Employee e : employeeList) {
			if(e.getEmpId()==id||e.getEmpId()==10125+id) {
				emp = e;
				break;
			}
		}
		if (emp == null) {
			System.out.println("INVALID EMPLOYEE ID");
			return;
		}
		employeeList.remove(emp);
		for(int i=0;i<employeeList.size();i++) {
			employeeList.get(i).setEmpId(10125+(i-1)+1);
		}
		System.out.println("EMPLOYEE DETAILS DELETED SUCCESFULLY !!");
	}
}