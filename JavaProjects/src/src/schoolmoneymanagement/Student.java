package src.schoolmoneymanagement;

public class Student {
	
	private int rollNum;
	private String name;
	private String grade;
	private int totalFee;
	private int feesPaidTillByStudents;
	private int totalFeeCollectedBySchool;
	
	/**
	 * Constructer to initialize all required fields of Student
	 * @param rollNum
	 * @param name
	 * @param grade
	 */
	public Student(int rollNum, String name, String grade) {
		super();
		this.rollNum = rollNum;
		this.name = name;
		this.grade = grade;
		totalFee = 10000;
		feesPaidTillByStudents = 0;
		totalFeeCollectedBySchool =0;
	}
	
	
	public int getTotalFee() {
		return totalFee;
	}
	
	public void updateFeesPaidTill(int fee) {
		feesPaidTillByStudents += fee;
		remainingFeeBalance();
		getFeeCollectedBySchool();
	}
	
	
	public void remainingFeeBalance() {		
		int balFee = totalFee-feesPaidTillByStudents;
		System.out.println("Fee paid till date is $ : "+feesPaidTillByStudents+ " & Balance Fee to be paid by Student "+name+" : "+balFee);
	}
	
	public void getFeeCollectedBySchool() {
		totalFeeCollectedBySchool += feesPaidTillByStudents;
		School school = new School();
		school.updateTotalfeeCollected(totalFeeCollectedBySchool);
	}

}
