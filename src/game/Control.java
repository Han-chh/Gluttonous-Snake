package game;

import java.awt.Color;
import java.awt.GridLayout;


public class Control {
	
	static Map_things Map[][] = new Map_things[20][30];//record situation of the map
	static int Hardness; //difficulty
	static int Timer = 0;//record the time
	//static history record
	
	public void initiation() {
		Snake_head.Length = 1;
		Timer = 0;
		Game.main_snake.setDirection(0);
		Snake_head.wholeSnake_location = new int[1][2];
			
		
		// setup map
		for (int i = 0;i<20;i++) {  // initiate Map_panel & map[]
			for (int j = 0 ;j<30;j++) {
				if (Map[i][j] != null) {
					Window.Map_panel.remove(Map[i][j]);
				}
				Map[i][j] = null;
			}
		}
		Window.Map_panel.repaint();
		Window.Map_panel.setLayout(new GridLayout(20,30));//set layout
		for (int i=0;i<20;i++) { //create the grid objects
			for (int j = 0;j<30;j++) {
				Map_things mt = new Map_things();
				Window.Map_panel.add(mt);
				Map[i][j] = mt;
				mt.setVisible(true);
				mt.setOpaque(true); //set 不透明
				mt.setBackground(Color.WHITE);//default white
			}
		}
		
	}
	
}
