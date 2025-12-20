package game;

import java.awt.Color;

import javax.swing.JDialog;

public class timer implements Runnable{

	static boolean isDead = false;
	@Override
	public void run() {
		// TODO 自动生成的方法存根
		Game.timer.setText("TIME NOW " + 0 +" s");
		while(!isDead) {
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO 自动生成的 catch 块
				e.printStackTrace();
			};
			Control.Timer++;
			Game.timer.setText("TIME NOW " + String.valueOf(Control.Timer) +" s");
			if(Control.Timer%5==0) { //random show apple every 5 seconds
				new Apple();
			}
		}
		Game.timer.setText("TIME NOW " + String.valueOf(Control.Timer-1) +" s");
	}

	

}
