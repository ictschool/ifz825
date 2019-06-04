package ch.wiss.swing.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class MyFrame extends JFrame{
	
	public MyFrame() {
		super("Juppi Modul 404");
		
		setEnabled(true);
		
		
		// Code für Elemente im Frame
		JTextField textField = new JTextField();
		//textField.setFont(new Font("Arial", 1, 23));
		add(textField, BorderLayout.NORTH);
		
		
		
		add(new MyPanel(), BorderLayout.CENTER);
		
		
		setVisible(true);
		setTitle("Juppi Modul 404");
		setSize(600, 500);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
	}

}
