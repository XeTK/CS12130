// this classes main task is to run the hole game and carry out the moves and level changes in the game

import java.util.*;
public class Play { 
	// global variables for doing class like events
	public static int playhea = 5;
	public static int score = 0;
	public static boolean exit = false;
	public static int go[] = new int[6];
	public static int hunter[][] = new int[6][23];
	
	public static void level(int level2, int l2g, int prescore, int curlevel) {
		// make sure the variables are reset just incase there are 2 games in a row
		
		reset();	
		
		// instansiate new objects
			Control co = new Control();
			Keyboard ke = new Keyboard();
			Display di = new Display();
			RunGame ga = new RunGame();
			Score sc = new Score();
			Hunter hu = new Hunter();
	
		//variables
			int gridx = 12;
			int gridy = 12;
			int playloc = 0;
			int maxscore = 42;
			int numhunt = 2;
			int maxhunt = 2;
			// assign values if it is level2
			if (level2 == 1) {
				numhunt = 1;
				// spawn a random numnber of hunter for the start of the game
				maxhunt = hu.showRandomInterger(2,5);
			}
			
			// create hunters for start of game
			// create hunter for the total number that needed to exist
			for (int i=0; i<numhunt; i++) {
				if (level2 == 0) {
					// create a level 1 hunter for the grid 
					createHunter(gridx, gridy);
				} else if (level2 == 1) {
					// create a new hunter for level2
					chl2();
					// set goes to 0 for the leve 2 hunters
					go[i] = 0;
				}
			}
		
		// !--start up--! //
			// draw grid so game dosnt look so bear
			co.drawgrid(gridx,gridy,playloc,hunter,go,numhunt);
			// score dialog drawn to screen after grid
			di.scorehea(score,playhea,curlevel);
			
		// main game loop
			// loop till the game exit = true
			while (exit = true) {
				// loop thought all the hunters and check there vales
				for (int i=0; i<numhunt; i++) {
					// if level 1 do this
					if (level2 == 0) {
						// if hunter value = 0 then create new hunter
						if (hunter[i][go[i]] == 0){
							// create hunter
							createHunter(gridx, gridy);
							// add to the score
							score++;
						}
						// add 1 to the count for each thingz
						go[i]++;
					} else if (level2 == 1) {
						// if no hunter exists then create one
						if (hunter[i][0] > 0){
							// else do another move for the hunters to move on on the couse round the grid
							hunter[i][0] = hu.nextMove(hunter[i][0],playloc,gridx,gridy);
						}else { 
							// call create hunter
							chl2();
							// ++ 2 to the score
							score = score + 2;
						}	
					}
				}
				// checks if end game is needed
				// if player health = nul then start exit game
				if (playhea <= 0) {
					// exit game set to true
					exitgame();
					// print you loose screen
					di.youLoose();
					// print score screen
					di.scorebase(score);
					// save score to txt
					sc.save(score,ke.readString());
					// load scores from txt
					sc.displaysc();
					// go to main menu
					ga.menu();
					// cryteria for level 2 to start...
				} else if ((score >= maxscore) && (level2 == 0) && (l2g == 1)) {
					// display level 2 screen before launching the level 2 mode
					di.level2();
					// sleep the thread before the next level is launched
					try{
						// sleep for 2 secounds
						Thread.sleep(2000);
					}catch(InterruptedException e) {
						// catch exception to stop the programing crashing if there is a problem with the thread.sleep
						System.out.println("FAIL : " + e.getMessage());
					}
					// launch level 2 with the previous score of the level 1
					level(1, 1, maxscore,2);
				} else {
					// else play game
					//playloc = co.movement(playloc, gridx, gridy, "s"); // lazy debug code for when was testing exiting thread correctly
					// movement class work to do movement about in the array and check that the movement isnt out of the grid
					playloc = co.movement(playloc, gridx, gridy, ke.readString());
					// draw grid with all relivent information
					co.drawgrid(gridx,gridy,playloc,hunter,go,numhunt);
					// draw score and health for player to see
					di.scorehea(score,playhea, curlevel);
				}
				// add to the hunters number so that you have a stagard start rather than just all 5 spawning at the same time
				if (numhunt != maxhunt) {
					// ++ to the number of hunters till it == the total size of the hunters
					numhunt++;
				}
			}
			// Prints to proceed
			System.out.println("Press Enter To Continue");
			// goes to menu
			ga.menu();
	}
	
	public static void minusHeath(int kill) {
		Hunter hu = new Hunter();
		// sets hunter location to end of grid
		hunter[kill] = hu.calculatePath(12,12);
		// sets go to 0
		go[kill] = 0;
		// minus players health
		playhea--;
	}
	public static void exitgame() {
		// set game thread to a exitable state
		exit = true;
	}
	// create hunters for level1
	public static void createHunter(int gridx, int gridy) {
		// create new hunter object
		Hunter hu = new Hunter();
		// check which slots in the array are free
		int i = checkfreeslots();
		// new hunter in array = to the list of moves for the hunter
		hunter[i] = hu.calculatePath(gridx,gridy);
		// counter = nothing to start again
		go[i] = 0;
	}
	
	// create hunters for level 2
	public static void chl2() {
		// create a new instance of the hunters in the game
		Hunter hu = new Hunter();
		// assigns hunter to a free slot and gives it a value 1 from the end
		hunter[checkfreeslots()][0] = 143;
	}
	// function to check free slots in an array
	public static int checkfreeslots() {
		// loop through all slots in an array
		for (int i = 0; i<hunter.length; i++) {
			// check if the hunter == 0
			if (hunter[i][go[i]] == 0) {
				// debug code: to say if there are freeslots for hunters
				//System.out.println("Freeslot at : " + i);
				return i;
			}
		}
		// else return 0 so that the program dosnt crash
		return 0;
	}
	
	// resets the variables in global area 
	public static void reset() {
		// player max health
		playhea = 5;
		// score = 0
		score = 0;
		// thread exit = false
		exit = false;
		// create new counters for hunterz
		go = new int[6];
		// create new hunters
		hunter = new int[6][23];
	}
}
