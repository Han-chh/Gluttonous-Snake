package game;

import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.math.*;

import javax.swing.JDialog;
import javax.swing.JLabel;

public class Snake_head extends Thread{
	
	static JDialog dead = new JDialog(Game.Win,"DEAD",true);
	static int Length = 0;//record the score
	static int [][]wholeSnake_location  = new int[1][2];//location of every grid of snake
	//[0][0]and[0][1]is xy of head Contrary tail.
	int direction; //1234 clockwise from up
	
	public Snake_head() {

	}
	
	public void born() { //snake is born
		wholeSnake_location[0][0] = (int)(18*(Math.random())+1);//randomly
		wholeSnake_location[0][1] = (int) (28*(Math.random())+1);
		Control.Map[wholeSnake_location[0][0]][wholeSnake_location[0][1]].setBackground(Color.BLACK);
		direction = (int) (4*(Math.random())+1); //random direction
		
	}
	
	public int getDirection() {
		return this.direction;
	}
	
	public void setDirection(int direction) {
		this.direction = direction;
	}
	
	public void turn(String direction) { //turn the direction
		int new_direction = 0;
		
		if (this.getDirection() == 1 || this.getDirection() ==3) {
			if (direction.equals("left")) {
				new_direction = 4;
			}else if (direction.equals("right")) {
				new_direction = 2;
			}
		}else if(this.getDirection() == 4) {
			if (direction.equals("left")) {
				new_direction = 3;
			}else if (direction.equals("right")) {
				new_direction = 1;
			}
		}else if (this.getDirection() == 2) {
			if (direction.equals("left")) {
				new_direction = 1;
			}else if (direction.equals("right")) {
				new_direction = 3;
			}
		}
		this.direction = new_direction;
	}
	
	public void run() {
		// add key listener
		Game.Win.requestFocus();
		Game.Win.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO 自动生成的方法存根
				
				if (e.getKeyChar() == 'a') {
					Game.main_snake.turn("left");
				}else if(e.getKeyChar() == 'd') {
					Game.main_snake.turn("right");
				}
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO 自动生成的方法存根
				
			}
		}); 
			
		//move
		while (true) {
			// create a sub location array to record the previous location
			int [][]location_sub = new int[wholeSnake_location.length][2];
			for (int i = 0; i<location_sub.length;i++) {// copy process
				for(int j = 0; j<2; j++) {
					location_sub[i][j] = wholeSnake_location[i][j];
				}
			}
			
			
			
			switch( Game.main_snake.direction) { //switch the direction
			case 1://move when direction is up

				wholeSnake_location[0][0]--;
				break;
			case 3://direction is down
				
				wholeSnake_location[0][0]++;
				break;
			case 4://direction is left
				
				wholeSnake_location[0][1]--;
				break;
			case 2://direction is right
				
				wholeSnake_location[0][1]++;
				break;
			}
			
			
			detectDead(wholeSnake_location[0][0],wholeSnake_location[0][1]);
			detectFood(location_sub);
			
			
			refresh(location_sub); // refresh the black grid
		
			
			try {  //wait 500 ms
				sleep(500);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			}
			
		}
			
	
	}
	
	private void detectDead(int x,int y) { //detect dead
		if (x == -1 || x == 20 || y==-1 ||y==30) {
			
			
			dead.setSize(200, 200);
			dead.setLocation(600, 300);
			
			dead.setLayout(null);
			JLabel l = new JLabel("YOU DEAD!");
			Container c = new Container();
			c = dead.getContentPane();
			c.add(l);
			l.setBounds(60, 45, 100, 50);
			l.setVisible(true);
			timer.isDead =true;
			dead.setVisible(true);
			System.exit(0);
		}else if(Control.Map[x][y].getAppearance().equals("snake")) {
			dead.setSize(200, 200);
			dead.setLocation(600, 300);
			
			dead.setLayout(null);
			JLabel l = new JLabel("YOU DEAD!");
			Container c = new Container();
			c = dead.getContentPane();
			c.add(l);
			l.setBounds(60, 45, 100, 50);
			l.setVisible(true);
			timer.isDead =true;
			dead.setVisible(true);
			System.exit(0);
		}
	}

	
	private void detectFood(int[][]sub_location) {//detect food
		if (Control.Map[wholeSnake_location[0][0]][wholeSnake_location[0][1]].getAppearance().equals("fruit")){
			// array addition
			int[][] temp_array = new int[wholeSnake_location.length+1][2];
			temp_array[0] = wholeSnake_location[0];
			temp_array[1] = sub_location[0];
			wholeSnake_location = temp_array;
			for (int i = 0;i<wholeSnake_location.length-2;i++) {
				wholeSnake_location[i+2] = sub_location[i+1];
			}
			Length++;
		}else {
			for (int i = 0;i<wholeSnake_location.length-1;i++) {
				wholeSnake_location[i+1] = sub_location[i];
			}
		}
	}

	
	public void refresh(int [][]location_sub){
		//set the previous grids white
		Game.len.setText("LENGTH NOW" + " " + Length);
		for (int i = 0; i<location_sub.length;i++) {
			Control.Map[location_sub[i][0]][location_sub[i][1]].setBackground(Color.WHITE);
			Control.Map[location_sub[i][0]][location_sub[i][1]].setAppearance("none");
		}
		
		//set the new grids different colors
		for (int i = 0; i<wholeSnake_location.length;i++) {
			if (Snake_head.Length<5) {
				Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setBackground(Color.CYAN);
			}else if (Snake_head.Length>=5 && Snake_head.Length<10) {
				Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setBackground(Color.GREEN);
			}else if (Snake_head.Length>=10 && Snake_head.Length<15) {
				Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setBackground(Color.BLUE);
			}else if (Snake_head.Length>=15 && Snake_head.Length<20) {
				Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setBackground(Color.YELLOW);
			}else if (Snake_head.Length>=20 && Snake_head.Length<25) {
				Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setBackground(Color.PINK);
			}else if (Snake_head.Length>=25 && Snake_head.Length<30) {
				Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setBackground(Color.GRAY);
			}else if (Snake_head.Length>=30) {
				Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setBackground(Color.BLACK);
			}
			
			Control.Map[wholeSnake_location[i][0]][wholeSnake_location[i][1]].setAppearance("snake");
		}
	}
	
	
}

