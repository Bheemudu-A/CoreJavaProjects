package src.schoolmoneymanagement;

public class Teacher {
	
	private int id;
	private String name;
	private int salary;
	private int totalSalariesPaidTill;
	
	public Teacher(int id, String name) {
		super();
		this.id = id;
		this.name = name;
	}

	public int getSalary() {
		return salary;
	}
	
	public void setSalary(int salary) {
		this.salary = salary;
		School school = new School();
		school.updateTotalSalariesPaid(salary);
	}

	public int getId() {
		return id;
	}
	
	public String getName() {
		return name;
	}
	
	

}
