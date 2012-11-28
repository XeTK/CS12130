import java.util.*;
public class Hunter {
	// the hunter class is where the beasts are made to kill the player
	
	// this function gives a array full of the location on the grid for each move of the player
	public static int[] calculatePath(int gridx, int gridy) {
		//work out the total of the grid
		int loc = (gridx * gridy) - 1;
		// instansiate a control class
		Control con = new Control();
		//take to get to location 0
		int i = 1;
		//create move array that contains all the moves that it can 
		int[] moves = new int[23];
		// sets location to far right bottom corner
		moves[0] = loc;
		while (loc > 0) {
			// holds previous location so that it can be refrenced later 
			int preloc = loc;
			// does movement rules from control class and assigns it to the 
			// new location
			loc = con.movement(loc, gridx, gridy, randomdire());
			// if the location = last one == a bounce of a wall then 
			//switch and do other movement
			if (preloc == loc) {
			} else if (loc < 0) {
				// if the move is off the grid then bounce it back so that we can 
				// check if the hunter has got to the goal
				loc = 0;
			} else {
				// asigns value to arraylist
				moves[i] = loc;
				i++;
			}
		}
		// returns array full of moves	
		return moves;
	}
		
	// funtion gives a random direction out to move generation class 
	public static String randomdire(){
		// random direction generator
		// generates a random number between 1 and 100
		int rndno = showRandomInterger(1, 100);
		if (rndno > 50) {
			// returns key values for the movement class rather than the direction
			// makes easier to inpliment it with other classes rather than 2 different
			// standards for movements
			// (UP)
			return "j";
		} else {
			// (LEFT)
			return "g";
		}
	}
	
	// this function gives the next move for the hunters on level2
	public int nextMove(int curloc, int playloc, int gridx, int gridy) {
		// instansiate new classes
		// debug code to print the hunters cureent location before next move
		//System.out.println(curloc);
		Control con = new Control();
		String dir = new String();
		// holds previous location for refrence
		int preloc = curloc;
		// gets the difference between the player location and the hunter location then checks if its on the same line
		if ((curloc-playloc) > gridx - 1) {
			dir = randomdire();
		} else if ((curloc-playloc) == gridx + 1) {
			dir = "j";
		}else{
			dir = "g";
		}
		// loops till the location dosnt == previous location so that the hunter dosnt sit still
		while (preloc == curloc) {
			// map rules so that it cant go of the side off the map
			curloc = con.movement(curloc, gridx, gridy, dir);
			// if location == previous one one then change the letter used to the other one
			if (preloc == curloc) {
				// set random direction for the charector so that it maintains a random 
				dir = randomdire();
			} else if (curloc < 0) {
				// if the location is greater than the size of the map set the location to 0 
				curloc =0;
			}
		}
		// return appropiate move for the player
		return curloc;
	}
	
	// this generates a random integer for the random things
	// based off example 2 http://www.javapractices.com/topic/TopicAction.do?Id=62 
	public static int showRandomInterger(int start, int end) {
		// create new random object
		Random ran = new Random();
		// returns new random object between the 2 numbers that are requred and * it by a random
		return (int)(((end - start + 1) * ran.nextDouble()) + 1);
	}
}