package Magic8BallHistory;

import java.util.ArrayList;
import java.util.Scanner;

public class Magic8BallRemember extends Magic8Ball {
	private ArrayList<String> questions = new ArrayList<String>();
	private ArrayList<String> answers = new ArrayList<String>();
	private Scanner scan  = new Scanner(System.in);
	
	public String askQuestion(){
		System.out.println("Please ask a question?");
		String qus = scan.nextLine();
		
		questions.add(qus);
		
		return qus;
	}
	
	public String shakeIt(){
		String answer = super.shakeIt();
		answers.add(answer);
		
		return answer;
	}
	
	public void displayHistory(){
		int size = answers.size();
		
		System.out.println("\nAll Questions and Answers:");
		for (int i = 0; i < size; i++){
			System.out.println("Question:\t" + questions.get(i) + "\n" + "Answers:\t" + answers.get(i));
		}
	}
}
