// this class displays the information to the screen
public class Display {
	
	// prints the array out to the screen for the end user to see it 
	public static void print(String[] info, int ylen) {
		// load write this out to set grid up
		// find clear function for this section..
		lines(ylen);
		System.out.print("|");
		int c = 0;
		// loops starts for the lengh of the array containing all the info for the charectors
		for (int i =0; i < info.length; i++) {
			// for each new line do this
			if (c == ylen) {
				// resets line counter to 0
				c = 0;
				System.out.println("");
				lines(ylen);
				System.out.print("|");
			}
			// converts array into something that can be sceen on the screen 
			if (info[i] == "E") {
				// Print empty square
				System.out.print("   |");
			} else if (info[i] == "P") {
				// Print Player Icon
				System.out.print("-P-|");
			} else if (info[i] == "H") {
				// Print Hunter Icon
				System.out.print("<H>|");
			} else if (info[i] == "D") {
				// collision graphic
				System.out.print("XXX|");
			} 
			// add to counter
			c++;
		} 
		// finishes grid layout
		System.out.println("");
		lines(ylen);
		System.out.print("");
	}
	//function for building lines that corispound to the size of the grid
	public static void lines(int ylen) {
		// loops to build up the lines
		for (int i =0; i < ylen; i++) {
			System.out.print("----");
		}
		//adds one as it is always 1 to short for some reason or to long if i add 1 to the main function
		System.out.print("-");
		// new line to start again
		System.out.println("");
	}
	
	// ascii art done by http://www.network-science.de/ascii/
	public static void startScreen() {
		// this function prints the menu system for the game
		System.out.println(".-.   .-.      .-.                             \n"+
						": :.-.: :      : :                             \n"+
						": :: :: : .--. : :   .--.  .--. ,-.,-.,-. .--. \n"+
						": `' `' ;' '_.': :_ '  ..'' .; :: ,. ,. :' '_.'\n"+
						" `.,`.,' `.__.'`.__;`.__.'`.__.':_;:_;:_;`.__.'\n"+
						"-----------------------------------------------\n"+
						"-------------- Reyer VS Hunter's --------------\n"+
						"-----------------------------------------------\n"+
						"-----------------------------------------------\n"+
						"--------- Type The Option to Continue ---------\n"+
						"-----------------------------------------------\n"+
						"-----------------------------------------------\n"+
						"------------------- Level1   ------------------\n"+
						"------------------- Level2   ------------------\n"+
						"------------------- Score    ------------------\n"+
						"------------------- Controls ------------------\n"+
						"------------------- Exit     ------------------\n"+
						"-----------------------------------------------\n"+
						"-----------------------------------------------");
	}
	public static void youWin() {
		// you win screen
		System.out.println(".-..-. .--. .-..-.  .-.   .-. .--. .-..-..-..-.\n"+
						": :: :: ,. :: :: :  : :.-.: :: ,. :: `: :: :: :\n"+
						"`.  .': :: :: :: :  : :: :: :: :: :: .` :: :: :\n"+
						" .' ; : :; :: :; :  : `' `' ;: :; :: :. ::_;:_;\n"+
						":_,'  `.__.'`.__.'   `.,`.,' `.__.':_;:_;:_;:_;");
	}
	public static void youLoose() {
		// you loose screen
		System.out.println(".-..-.             .-.    .--.  .--. .-----.\n"+
						": :: :             : :   : ,. :: .--'`-. .-'\n"+
						"`.  .'.--. .-..-.  : :   : :: :`. `.   : :  \n"+
						" .' ;' .; :: :; :  : :__ : :; : _`, :  : :  \n"+
						":_,' `.__.'`.__.'  :___.'`.__.'`.__.'  :_;  ");
	}
	public static void scorebase(int score) {
		// rest of score screen
		System.out.println("-----------------------------------------------\n"+
							"-----------------------------------------------\n"+
							"------------ Your Score Was : " + score + " --------------\n"+
							"-----------------------------------------------\n"+
							"-----------------------------------------------\n"+
							"----------- Please Enter Your Name ------------\n"+
							"-----------------------------------------------\n"+
							"-----------------------------------------------");
	}
	
	public static void scorehea(int score, int health, int level) {
		// prints the health and score to the screen
		System.out.println("--- Level : " + level + " ---- Score : " + score + " ---- Strengh : " + health + " ---");
	}
	public static void scorehead() {
		// score header
		System.out.println(" .--.                        \n"+
							": .--'                       \n"+
							"`. `.  .--.  .--. .--.  .--. \n"+
							" _`, :'  ..'' .; :: ..'' '_.'\n"+
							"`.__.'`.__.'`.__.':_;  `.__.'\n"+
							"-----------------------------");
                             
	}
	public static void scoreinv(int pos, String name, int score) {
		// the score scrreen graphic for each differnt score
		System.out.println(	pos + " - " + name + " - " + score + "\n"+
						   "-----------------------------");
	}
	// change before hand in
	public static void controls() {
		// controls screen to show the players the controls
		System.out.println(" .--.              .-.            .-.        \n"+
							": .--'            .' `.           : :        \n"+
							": :    .--. ,-.,-.`. .'.--.  .--. : :   .--. \n"+
							": :__ ' .; :: ,. : : : : ..'' .; :: :_ `._-.'\n"+
							"`.__.'`.__.':_;:_; :_; :_;  `.__.'`.__;`.__.'\n"+
							"---------------------------------------------\n"+
							"----------------- J == UP    ----------------\n"+
							"----------------- K == DOWN  ----------------\n"+
							"----------------- G == LEFT  ----------------\n"+
							"----------------- H == RIGHT ----------------\n"+
							"----------------- ENTER == CONFIRM ----------\n"+
							"---------------------------------------------");
	}
	public static void level2() {
	// anouncing level 2 screen for the player so they can see the change between
		System.out.println("      :::        :::::::::: :::     ::: :::::::::: :::            :::::::: \n"+
							"     :+:        :+:        :+:     :+: :+:        :+:           :+:    :+: \n"+
							"    +:+        +:+        +:+     +:+ +:+        +:+                 +:+   \n"+
							"   +#+        +#++:++#   +#+     +:+ +#++:++#   +#+               +#+      \n"+
							"  +#+        +#+         +#+   +#+  +#+        +#+             +#+         \n"+
							" #+#        #+#          #+#+#+#   #+#        #+#            #+#           \n"+
							"########## ##########     ###     ########## ##########    ##########  ");
	}
	
}