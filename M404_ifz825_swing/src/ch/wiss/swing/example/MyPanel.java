package ch.wiss.swing.example;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class MyPanel extends JPanel{

	public MyPanel() {
		super(new GridLayout(5, 2));
		JLabel label = new JLabel("Beispiel mit Layouts");
		add(label);
		JLabel label2 = new JLabel("Beispiel mit Layouts");
		add(label2);
	}
	
}
