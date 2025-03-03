package src.schoolmoneymanagement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {

	public static void main(String[] args) {
		
		/*
		List<Student> students = Arrays.asList(
				new Student(302, "Bheemudu Avula", "X"),
				new Student(303, "Koushika Pulagam", "IX")
				);*/
		
		Student bheem = new Student(302, "Bheemudu Avula", "X");
		Student kushi = new Student(201, "Koushika Pulagam", "IX");
		Student ramesh = new Student(303, "Ramesh Balgari", "X");
		
		List<Student> students = new ArrayList<>();
		students.add(ramesh);
		students.add(kushi);
		students.add(bheem);
		
		Teacher  swamy = new Teacher(01, "Swamy Sir");
		Teacher  prudhvi = new Teacher(02, "Prudhvi Modbi");
		
		List<Teacher> teachers = new ArrayList<>();
		teachers.add(prudhvi);
		teachers.add(swamy);
		
		School school = new School(students, teachers);
		
		bheem.updateFeesPaidTill(6000);
		kushi.updateFeesPaidTill(6500);
		ramesh.updateFeesPaidTill(3000);
		System.out.println("Total Fee collected till $ : "+school.getTotalFeeCollected());
		
		
		System.out.println();
		System.out.println("Employees Block");
		System.out.println();
		
		swamy.setSalary(5000);
		prudhvi.setSalary(6000);
		
		System.out.println("Salaries paid to employees till now $ : "+school.getTotalMoneySpentOnSalaries());
		
		System.out.println();
		
		System.out.println("Total Profit of a School in a month : "+school.totalProfitOfSchool());
	}
}
