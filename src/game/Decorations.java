package game;

import java.awt.Color;


public class Decorations {
	int location[] = {0,0};
	public  void randomShow(Color c) { //random appear on the map
		do {
			this.location[0] = (int)(19*(Math.random()));//randomly
			this.location[1] = (int) (29*(Math.random())+1);
			
		}while (!Control.Map[this.location[0]][this.location[1]].getBackground().equals(Color.WHITE));

		Control.Map[this.location[0]][this.location[1]].setAppearance("fruit");
		Control.Map[this.location[0]][this.location[1]].setBackground(c);
	}
	
}
