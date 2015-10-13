package Magic8BallHistory;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class Magic8BallReadWrite {
	PrintWriter writer = null;
	static String fileName;

	
	public void initializeWriter(String fileName){
		this.fileName = fileName;
		
		try {
			writer = new PrintWriter(new File(fileName));
		} catch (IOException  e) {
			System.err.println(e);
		}
	}
	
	public void writeALine(String line){
		writer.println(line);
	}
	
	public void closeWriter(){
		writer.close();
	}
	
	public static ArrayList<String> readFromFile(String fileName){
		
		ArrayList<String> records = new ArrayList<String>();
		String line = null;

        try {
            // FileReader reads text files in the default encoding.
            FileReader fileReader = new FileReader(fileName);

            // Always wrap FileReader in BufferedReader.
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            while((line = bufferedReader.readLine()) != null) {
//                System.out.println(line);
                //
                records.add(line);
            }   

            // Always close files.
            bufferedReader.close();         
        }
        catch(FileNotFoundException ex) {
            System.out.println("Unable to open file '" + fileName + "'");                
        }
        catch(IOException ex) {
            System.out.println("Error reading file '" + fileName + "'");                  
            // Or we could just do this: 
            // ex.printStackTrace();
        }
        
        return records;
	}
	

}
