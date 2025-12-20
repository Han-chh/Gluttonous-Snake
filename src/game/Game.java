package game;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JLabel;

public class Game {
	static Window Win = new Window(); //create the main window
	static Control controller = new Control();//process controller
	static Snake_head main_snake = new Snake_head();
	static JLabel timer = new JLabel();//time info
	static JLabel len = new JLabel();//length info
	
	public static void main(String[] args) {
		
		
		//add info to the info_board
		
		Win.infoboard_add(len, "LENGTH NOW", String.valueOf(Snake_head.Length), 340, 20, 250, 40);
		len.setFont(new Font("SanSerif",Font.BOLD,18));
		
		
		Win.infoboard_add(timer, "TIME NOW", String.valueOf(Control.Timer), 560, 20, 250, 40);
		timer.setText(timer.getText()+" s");
		timer.setFont(new Font("SanSerif",Font.BOLD,18));
		
		ButtonPerform bp = new ButtonPerform();//object of buttonPerform functions
		
		JButton start = new JButton();//restart button
		Win.infoboard_add(start, "START", 30, 20, 100, 40);
		start.setFont(new Font("SanSerif",Font.PLAIN,13));
		start.addActionListener(new ActionListener() { // add ActionListener
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				bp.start(start);
			}
		});
		
		JButton ins = new JButton();//instruction button
		Win.infoboard_add(ins, "INSTRUCTIONS", 150, 20, 150, 40);
		ins.setFont(new Font("SanSerif",Font.PLAIN,15));
		ins.addActionListener(new ActionListener() {//add ActionListener
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO 自动生成的方法存根
				bp.show_instructions();
			}
		});
	
	}
	
}
