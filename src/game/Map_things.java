package game;

import java.awt.Color;

import javax.swing.BorderFactory;
import javax.swing.JLabel;

public class Map_things extends JLabel {
	String Appearance; // what it looks like
	String Coor ; //the coordinates written as 'x+y'
	
	public Map_things() {
		super();
		this.setVisible(false);
		Appearance = "none"; //initiation is none
		this.setBorder(BorderFactory.createLineBorder(Color.black));
	}
	
	public void setAppearance(String appearance) { //set appearance
		this.Appearance = appearance;
	}
	
	
	public String getAppearance() {//get appearance
		return this.Appearance;
	}
}
