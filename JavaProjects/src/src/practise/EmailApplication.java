package src.practise;

/*
 * you are an IT Support Administrator specialist and you are charged with the task of creating 
 * email accounts for new hires
 */
public class EmailApplication {

	public static void main(String[] args) {
		
		Email obj = new Email("Bheemudu", "Avula");
		
		obj.changeMailCapacity(10);
		obj.changePassword("Sathya@123");
		obj.setAlternateEmail("bheemuduavula@Backend.intelizign.com");
		
		obj.getAlternateEmail();
		obj.getMailCapacity();
		obj.getPassWord();
	}
	
	
	
}
