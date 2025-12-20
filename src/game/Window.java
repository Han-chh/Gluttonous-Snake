package game;

import java.awt.*;
import javax.swing.*;

import game.Window;


public class Window extends JFrame {
	 JPanel infoboard = new JPanel();
	 static JPanel Map_panel = new JPanel();
	
	
	public Window() {
		super("Gluttonous Snake ");
		this.setLocation(300,80);
		this.setVisible(true);
		this.setSize(900, 700);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setResizable(false);//initiation of the main_window
		Container c = new Container();
		c = this.getContentPane();
		c.setLayout(null);
		
		//set info_board
		c.add(infoboard);
		infoboard.setSize(900, 200);
		infoboard.setLocation(0,550);
		infoboard.setBorder(BorderFactory.createTitledBorder("INFOBOARD"));
		infoboard.setLayout(null);
		
		//set map
		c.add(Map_panel);
		Map_panel.setSize(900, 550);
		Map_panel.setLocation(0,5);
		Map_panel.setBorder(BorderFactory.createTitledBorder("MAP"));
		
		
		
	}
	
	//add info_label to the board
	public void infoboard_add(JLabel l, String name, String info, int x, int y , int width , int height) {
		l.setText(name + " : " + info);
		infoboard.add(l);
		l.setLocation(x,y);
		l.setVisible(true);
		l.setSize(width, height);
	}
	
	//add info_button to the board
	public void infoboard_add(JButton b,String name, int x, int y , int width , int height) {//add Label_info to the board
		b.setText(name);
		infoboard.add(b);
		b.setLocation(x,y);
		b.setVisible(true);
		b.setSize(width, height);
	}
	
	
	
	
}
