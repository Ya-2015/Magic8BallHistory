package Magic8BallHistory;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class Magic8BallRemember extends Magic8Ball {

	private Scanner scan  = new Scanner(System.in);
	private Magic8BallReadWrite readWrite = new Magic8BallReadWrite();
	private LinkedHashMap <String, String> records = new LinkedHashMap <String, String>();
	private String currentQues = "";
	private final int BEGIN_INDEX_10 = 10;
	private final int BEGIN_INDEX_9 = 9;
	
	public String askQuestion(){
		System.out.println("Please ask a question?");
		currentQues = scan.nextLine();
		
		if (!records.containsKey(currentQues)){
			records.put(currentQues, "");
		}
		
		return currentQues;
	}
	
	public String shakeIt(){
		String answer = "";
		
		if(records.containsKey(currentQues) && !records.get(currentQues).equals("")){
			answer = records.get(currentQues);
		}else{
			answer = super.shakeIt();
			records.put(currentQues, answer);
		}
		
		return answer;
	}
	
	public void displayHistory(){
		
		System.out.println("\nAll Questions and Answers:");
		
		for (String key : records.keySet()){
			System.out.println("Question: " + key + "\t" + "Answers: " + records.get(key));
		}
	}
	
	public void writeToFile(String fileName){
		readWrite.initializeWriter(fileName);
		
		for (String key : records.keySet()){
			readWrite.writeALine("Question: " + key + "\t" + "Answers: " + records.get(key));
		}
		
		readWrite.closeWriter();
	}
	
	public void readFromFile(String fileName){
		ArrayList<String> list = Magic8BallReadWrite.readFromFile(fileName);
		String hist;
		String[] parts;
		String question;
		String answer;
		
		for (int i = 0; i < list.size(); i++){
			hist = list.get(i);
			parts = hist.split("\t");
			
			question = parts[0].substring(BEGIN_INDEX_10);
			answer = parts[1].substring(BEGIN_INDEX_9);
			
			if (!records.containsKey(question)){
				records.put(question, answer);
			}
		}
	}
}
