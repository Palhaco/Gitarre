/******************************************************************************
 *  Compilation:  javac GuitarPlayer.java
 *  Execution:    java  GuitarPlayer
 *
 ******************************************************************************/

import java.awt.Font;
import gdp.stdlib.*;

public class GuitarPlayerTest {

    public static void main(String[] args) {

	StdDraw.text(.5, .5, "Click this window and type m, k, o, comma, l or p");
		
	// big font for displaying the currently pressed key
	StdDraw.setFont(new Font("SansSerif", Font.BOLD, 120));

	Guitar guitar = new Guitar();

	// keys to pluck a string
	char[] pluckKeys = { 'm', 'k', 'o', ',', 'l', 'p' };

	// keys to press a fret down, only the lower strings can be accessed
	char[][] changeFretKeys = { { '<', 'y', 'x', 'c', 'v', 'b' },
				    { 'a', 's', 'd', 'f', 'g', 'h' }, 
				    { 'q', 'w', 'e', 'r', 't', 'z' },
				    { '2', '3', '4', '5', '6', '7' },
				    //{ '>', 'Y', 'X', 'C', 'V', 'B' }, 
				    //{ 'A', 'S', 'D', 'F', 'G', 'H' },
				    //{ 'Q', 'W', 'E', 'R', 'T', 'Z' }
	};

	int tics = 0;

	double oldX = 0;
	double oldY = 0;
	
	double newX = 0;
	double newY = 0;
	
	// the main input loop
	while (true) {

	    // check if the user has typed a key, and, if so, process it
	    while (StdDraw.hasNextKeyTyped()) {

		// the user types this character
		char key = StdDraw.nextKeyTyped();

		// draw the character to standard draw (for debugging)
		StdDraw.clear();
		StdDraw.text(.5, .5, "" + key);

		// pluck the corresponding string
		for (int i = 0; i < pluckKeys.length; i++) {
		    if (key == pluckKeys[i]) {
			guitar.pluckString(i);
		    }
		}

		// or change the frequency of a string
		for (int i = 0; i < changeFretKeys.length; i++) {
		    for (int j = 0; j < changeFretKeys[i].length; j++) {
			if (key == changeFretKeys[i][j]) {
			    guitar.pressFretDown(i, j);
			}
		    }
		}

	    }

		tics++;
		
		newY = guitar.sample();
		
		if (tics % 1000 == 0)
		{	
			newX++;
			if (tics > 100000)
			{
				StdDraw.clear();
				oldX = 0;
				oldY = 0;
				newX = 1;
				tics = 0;
			}
		
			StdDraw.line(oldX/100., oldY + .5, newX/100., newY + .5);
			
			oldX = newX;
			oldY = newY;
		}
	    
	    // send the result to the sound card
	    StdAudio.play(guitar.sample());
	    //System.out.println(guitar.sample());
	    
	    // advance the simulation of each guitar string by one step
	    guitar.tic();
		}
    }
}
