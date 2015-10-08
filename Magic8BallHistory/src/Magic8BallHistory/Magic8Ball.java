package Magic8BallHistory;

import java.util.Random;

public class Magic8Ball {
	private final int LENGTH = 15;
	private Random random;
	private final String[] strings = {"It is certain",
			"It is decidedly so",
			"Without a doubt",
			"Yes - definitely",
			"You may rely on it",
			"As I see it, yes",
			"Most likely",
			"Outlook good",
			"Signs point to yes",
			"Yes",
			"Reply hazy, try again",
			"Ask again later",
			"Better not tell you now",
			"Cannot predict now",
			"Concentrate and ask again"};
	
	public Magic8Ball(){
		random = new Random();
	}
	
	public String shakeIt(){
		int index = 0;
		index = random.nextInt(LENGTH);
		
		return strings[index];
	}

}
