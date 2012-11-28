// this is the main method for running the game it also includes the menu system 
import java.lang.InterruptedException;
public class RunGame { 
	
	public static void main(String[] args) {
		// main thread just creates menu then every thing else is ran from there
		menu();
	}
	public static void menu() {
		// instansiate objects that will be needed for all the things needed on the main menu
		Display di = new Display();
		Keyboard ke = new Keyboard();
		Score sc = new Score();
		Play pl = new Play();
		// displays start screen
		di.startScreen();
		// loads keyboard input into string for it to be used for evaluating the menu selection
		String inp = ke.readString();
		// if for menu chooses
		if (inp.equals("level1")||inp.equals("Level1")||inp.equals("LEVEL1")) {
			// start level 1 for player to play
			pl.level(0, 0, 0, 1);
		} else if (inp.equals("level2")||inp.equals("Level2")||inp.equals("LEVEL2")) {
			// starts level 1 going then starts level2
			pl.level(0, 1, 0, 1);
		} else if (inp.equals("Score")||inp.equals("score")||inp.equals("SCORE")) {
			// previous score screen is showed
			sc.displaysc();
			// returns to the menu
			menu();
		} else if (inp.equals("Controls")||inp.equals("controls")||inp.equals("CONTROLS")) {
			// prints control sceam for the game
			di.controls();
			// sleep to give chance to read the controls
			try{
				// sleep for 4 secounds
				Thread.sleep(4000);
			}catch(InterruptedException e) {
				// catch exception
				System.out.println("FAIL : " + e.getMessage());
			}
			// go to menu
			menu();
		} else {
			// else program exits
			System.out.println("Exiting");
		}
	}
}