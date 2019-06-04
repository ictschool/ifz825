package ch.wiss.swing.example;

import javax.swing.SwingUtilities;

public class Starter {

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			
			@Override
			public void run() {
				new MyFrame();
			}
		});
				
		
		
	}

}
