import java.io.*;
import java.util.*;
public class Score {
	public static void displaysc() {
		// instansiate a new diplay class ready to display stuff to the screen
		Display di = new Display();
		// print the head of the score board
		di.scorehead();
		// sort the data out from the array and put it in order
		String info[] = bubbleSort(load());
	//	Arrays.sort(info, Collections.reverseOrder());
		// loop through the array to its end
		for (int i =0; i < info.length; i++) {
			// if the output is not null then
			if (info[i] != null) {
				// split the message into name and score
				String[] temp = info[i].split(" - ");
				// display it onto the screen for the player to see
				di.scoreinv(i + 1,temp[1],Integer.parseInt(temp[0]));
			} 
		}
		// now wait for 4 secounds before exiting thread so that the player has chance to read it
		try{
			// sleep for 4 secounds
			Thread.sleep(4000);
		}catch(InterruptedException e) {
			// catch exception if there is a problem
			System.out.println("FAIL : " + e.getMessage());
		}
	}
	
	
	// function to save all the high scores to the txt
	 public static void save(int score, String name) {
		//based of a source from http://www.abbeyworkshop.com/howto/java/writeText/index.html
		  try {
			// calls load to put the previous content into an array ready for it to be used
			String info[] = load();
			// make new file writter
			PrintWriter out = new PrintWriter(new FileWriter("Score.txt"));
			// for each item in the array loop
			for (int i =0; i < info.length ; i++) {
				// if value not = to null then print to the file
				if (info[i] != null) {
					// print value to the file and do a new line
					out.println(info[i]);
				}
			}
			// print the new value to the files
			 out.println(score + " - " + name);
			 // close the file writer
			 out.close();
         } catch (IOException e){
			// if there is a error then display it
			 e.printStackTrace();
		 }
	 }
	
	
	// loosely based off this http://www.exampledepot.com/egs/java.io/ReadLinesFromFile.html
	// load txt file into array
	public static String[] load() {
		try {
			// instanciates file io file and its name
			File fi = new File("Score.txt");
			// checks if the file exists
			if (!fi.exists()) {
				// if file does not exist then create a new files				
				fi.createNewFile();
			}
			// create a buffer reader for file score.txt
			BufferedReader ri = new BufferedReader(new FileReader("Score.txt"));
			// create string to store line in
			String str = new String();]
			// int = 0 for the count
			int i = 0;
			// declare array to hold the values from the txt
			String rei[] = new String[10];
			// loop through the txt writting the values to an array
			while ((str = ri.readLine()) != null) {
				// if count not == to 10 then keep looping
				if (i < 10) {
					// assigning array a value
					rei[i] = str;
					// ++ 1 to the count
					i++;
				}
			}
			// close file reader
			ri.close();
			fi.close();
			// return the array out for it to be used by things
			return rei;
		} catch (IOException e) {
			// if there is a error return the exception
			e.printStackTrace();
		}
		// return a null value otherwiese just incase if there a problems
		return null;
	}
	
	public static String[] bubbleSort(String[] data) {
		int i,j;
		for(i = 0; i < data.length-1; i++)
			for(j = data.length-1;j > i;j--)
				if((int)(data[j].substring(0,3)).compareTo(data[j-1].substring(0,3))<0) {
					String g = data[j];
					String h = data[j-1];
					data[j] = h;
					data[j-1] = g;
				}
		return data;
	}

}