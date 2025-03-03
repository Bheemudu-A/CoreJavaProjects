package src.schoolmoneymanagement;

import java.util.List;

public class School {
	
	private List<Student> student;
	private List<Teacher> teacher;
	private static int totalSalariesPaid;
	private static int totalFeeCollected;
	
	public School(List<Student> student, List<Teacher> teacher) {
		super();
		this.student = student;
		this.teacher = teacher;
		totalFeeCollected =0;
		totalSalariesPaid =0;
	}

	public School() {		
	}

	public List<Student> getStudent() {
		return student;
	}

	public void addStudent(Student student) {
		this.student.add(student);
	}

	public List<Teacher> getTeacher() {
		return teacher;
	}

	public void addTeacher(Teacher teacher) {
		this.teacher.add(teacher);
	}

	public int getTotalMoneySpentOnSalaries() {
		return totalSalariesPaid;
	}

	public void updateTotalfeeCollected(int fee) {
		this.totalFeeCollected += fee;
	}

	public static int getTotalFeeCollected() {
		return totalFeeCollected;
	}

	public void updateTotalSalariesPaid(int salary) {
		this.totalSalariesPaid += salary;
	}
	
	
	public static int totalProfitOfSchool() {
		return totalFeeCollected-totalSalariesPaid;
	}

}
