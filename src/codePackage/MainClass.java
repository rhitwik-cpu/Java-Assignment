package codePackage;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MainClass {
	
	public static List<Employee> employeeList = new ArrayList<Employee>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("EMPLOYEE REGISTRATION SYSTEM\n");
			System.out.println("1. ADD Employee (type 'ADD')");
			System.out.println("2. UPDATE Employee (type 'UPDATE')");
			System.out.println("3. DELETE Employee (type 'DELETE')");
			System.out.println("4. GET Employee (type 'GET' OR 'GET <ID/INDEX>')");
			System.out.print("Enter your response : ");
			String s = sc.nextLine().toUpperCase().trim();
			String empArgString="";
			if(s.contains("GET ")) {
				try {
					String[] strArr = new String[2];
					strArr = s.split(" ");
					s = strArr[0];
					empArgString = strArr[1];
				}
				catch(ArrayIndexOutOfBoundsException aioobe) {
					aioobe.printStackTrace();
				}
			}
			
			switch(s) {
			case "ADD" :
				AllMethodsClass.addEmployee(employeeList);
				break;
			case "UPDATE" :
				AllMethodsClass.updateEmployee(employeeList);
				break;
			case "DELETE" :
				AllMethodsClass.deleteEmployee(employeeList);
				break;
			case "GET" :
				if (empArgString == "")
					AllMethodsClass.getAllEmployee(employeeList);
				else
					AllMethodsClass.getEmployee(employeeList,Integer.parseInt(empArgString));
				break;
			default :
				System.out.println("INVALID INPUT");
				break;
			}
			System.out.print("Press 'H' to go back to Home Screen or 'E' to EXIT and PRESS ENTER : ");
		}while(sc.nextLine().trim().equalsIgnoreCase("H"));	
		sc.close();
		System.exit(0);
	}
}