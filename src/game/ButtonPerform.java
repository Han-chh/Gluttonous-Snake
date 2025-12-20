package game;



import java.awt.Container;
import java.awt.FlowLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;

public class ButtonPerform{
	
	
	public void show_instructions(){ //show the instructions dialog
		JDialog ins = new JDialog(Game.Win,"Instructions of the game",false);
		ins.setSize(400, 400);
		ins.setLocation(500, 200);
		Container c = new Container();
		ins.setLayout(null);
		c = ins.getContentPane();
		JLabel l1 = (new JLabel("1.This a game of a hugry snake."));
		JLabel l2 = (new JLabel("2.Use A or D to make the snake turn left and right."));
		JLabel l3=(new JLabel("3.Try to eat red apple to make yourself longer!"));
		JLabel l4=(new JLabel("4.Never hits the boundary and your body."));
		c.add(l1);
		c.add(l2);
		c.add(l3);
		c.add(l4);
		l1.setBounds(10,10,300,50);
		l2.setBounds(10,60,300,50);
		l3.setBounds(10,110,300,50);
		l4.setBounds(10,160,300,50);
		ins.setVisible(true);
		
	}
	
	public void start(JButton start)  {
		Game.controller.initiation();
		Game.main_snake.born();
		new Snake_head().start();
		new Thread(new timer()).start();
		start.setVisible(false);
		
	}

}
