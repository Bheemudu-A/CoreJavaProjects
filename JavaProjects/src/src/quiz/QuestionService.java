package src.quiz;


public class QuestionService{

    Question[] question = new Question[4];

    public QuestionService(){
        question[0] = new Question(1, "size of int", "2", "4", "8", "16", "8");
        question[1] = new Question(2, "size of long", "2", "4", "8", "16", "16");
        question[2] = new Question(3, "size of double", "2", "4", "8", "16", "16");
        question[3] = new Question(4, "size of byte", "1", "4", "8", "16", "1");
        checkQuestions();
    }
    
    
    public void checkQuestions(){
    	
    	for(Question q : question) {
    		System.out.println(q.toString());
    	}
    	
    }

}
