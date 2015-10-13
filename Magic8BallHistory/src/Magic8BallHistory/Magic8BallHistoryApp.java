package Magic8BallHistory;

import java.io.File;
import java.util.Scanner;

public class Magic8BallHistoryApp {

	public static void main(String[] args) {
		//file name
		//get a filename
		 String filename = (System.getProperty("user.dir") + File.separatorChar +"Magic8BallHistory.txt");
		
		// TODO Auto-generated method stub
		Magic8BallRemember magicRem = new Magic8BallRemember();
		Scanner scan  = new Scanner(System.in);
		
		
		magicRem.readFromFile(filename);
		
		System.out.print("Would you like to play the game? yes or no: ");
		String inputStr = scan.nextLine();
		while (inputStr.equalsIgnoreCase("yes") || inputStr.equalsIgnoreCase("ask")){
			
			magicRem.askQuestion();
			System.out.println(magicRem.shakeIt());
			
			System.out.print("\nWould you like to ask a question or get history? ask or hist: ");
			inputStr = scan.nextLine();
			
			if (inputStr.equalsIgnoreCase("hist")){
				magicRem.displayHistory();
				magicRem.writeToFile(filename);
				break;
			}
			
		}
		
		//close
		scan.close();
	}

}
