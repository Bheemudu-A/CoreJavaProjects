package src.practise;

import java.util.Scanner;

public class Email {
	
	private String firstName;
	private String lastName;
	private int defaultPassLength =8;
	private String department;
	private String password;
	private String companyName = "ivyCompech";
	private String email;
	private String alternateEmail;
	private int emailCapacity = 100;
	
	
	
	
	public Email(String firstName, String lastName) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.department = pickDepartment();
		System.out.println("Department is : "+department);
		
		this.password = generatePassWord(defaultPassLength);
		System.out.println("password : "+password);
		this.email = generateEMail();
		System.out.println("Emp EmailId : "+email);
	}
	
	

	private String pickDepartment() {
		
		System.out.println("Departments Available : \n1 BackendDev \n2 tester \n3 FrontendDev \n4 None of Above \nChoose Department");
		
		Scanner sc = new Scanner(System.in);
		int option = sc.nextInt();
		switch(option) {
		case 1: return "BackendDev";
		case 3: return "FrontendDev";
		case 2: return "tester";
		default: return "";
		}
	}
	
	private static String generatePassWord(int length) {
			
			String setPassword = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789!@#$%^&*";
			char[] password = new char[length];
			for(int i=0;i<password.length;i++) {
				int rand = (int) (Math.random()*setPassword.length());
				password[i] =setPassword.charAt(rand);
			}
			
			return new String(password);
		}
	
	private String generateEMail() {
		return firstName.toLowerCase()+"."+lastName.toLowerCase()+"@"+department+"."+companyName+".com";
	}
	
	public void setAlternateEmail(String altEmail) {
		this.alternateEmail = altEmail;
	}
	
	public void changePassword(String password) {
		this.password = password;
	}
	
	public void changeMailCapacity(int capacity) {
		this.emailCapacity = capacity;
	}
	
	public String getAlternateEmail() {
		System.out.println("alternateEMail : "+alternateEmail);
		return alternateEmail;
	}
	
	public String getPassWord() {
		System.out.println("changed password : "+password);
		return password;
	}
	
	public int getMailCapacity() {
		System.out.println("emailCapacity : "+emailCapacity);
		return emailCapacity;
	}
}
