// makes array, does movement and collision detection between walls
public class Control {
	
	
	// this function converts the values from the hunter and player into an array which can then be printed to screen
	public static void drawgrid(int gridy, int gridx, int playloc, int[][] hunter, int[] go, int numhunterz) {
		// instansiated new play object
		Play pl = new Play();
		// calculates grid size
		int gridsize = gridx * gridy;
		// creates new string
		String[] a = new String[gridsize];
		// loops through array for display
		for (int i =0; i<gridsize; i++) {
			//sets values to E = empty space
			a[i] = "E";
		}
		// player location
		a[playloc] = "P";
		// stuff todo with hunter //
		// loops though all the hunters in current action
		for (int i =0; i<numhunterz; i++) {
			// debug code: prints hunter and its location
			//System.out.println("Hunter :"+ i + " Location =" +hunter[i][go[i]]);
			// gives the array a refrence to act off
			a[hunter[i][go[i]]] = "H";
			// collision detection code so if any hunter location == player location then it will assign a value to display this
			if (hunter[i][go[i]] == playloc) {
				// refence for a collison for the display system
				a[hunter[i][go[i]]] = "D";
				// minus the health from the player
				pl.minusHeath(i);
			}
		}
		//instansiated new display class
		Display in = new Display();
		//displays the grid on the screen
		in.print(a,gridx);
	}
	
	public static int movement(int curloc, int gridx, int gridy, String key) {
		//store previous location for later use in checking colisions
		int preloc = curloc;
		// movement code for the player will change the current location of the player
		// the location of the object on the grid is worked out by minusing by 1 or the the whith of the grid to ditermin where it is one the grid
		if (key.equals("j")) {
			//up
			curloc = curloc - gridx;
			curloc = updoColision(preloc, curloc, gridx, gridy);
		}else if (key.equals("k")){
			//down
			curloc = curloc + gridx;
			curloc = updoColision(preloc, curloc, gridx, gridy);
		}else if (key.equals("g")){
			//left
			curloc = curloc - 1;
			curloc = sideColision(preloc, curloc, gridx, gridy);
		}else if (key.equals("h")) {
			//right
			curloc = curloc + 1;
			curloc = sideColision(preloc, curloc, gridx, gridy);
		}
		// returns new location
		return curloc;
	}
	// far to many input preramiters
	public static int sideColision(int preloc, int curloc, int gridx, int gridy) {
	// side detection
		for (int i =0; i<gridx; i++) {
			// move right check collision code see if the location colides with any of the side collision one map
			if (preloc < curloc) {
				if (curloc == i * gridx) 
					curloc = preloc;
			// move left detection left side collision
			} else if (preloc > curloc) {
				if (preloc == i * gridx) 
					curloc = preloc;
			} 
			// makes sure that it does not go greater than maximum value of the grid to stop the 
			if (curloc >= (gridx * gridy)) {
				// restore location back to previous to stop the game from crashing
				curloc = preloc;
			}
		}
		// retrun new location of the item
		return curloc;
	}
	// messy messy stuff
	public static int updoColision(int preloc, int curloc, int gridx, int gridy) {
	// top bottom collision detection
		if (curloc >= (gridx * gridy)||curloc < 0)
			curloc = preloc; 
		// return the new location of the charector
		return curloc;
	}
}
