package ch.wiss.swing.chessboard;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ComponentEvent;
import java.awt.event.ComponentListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JMenuItem;

public class Board extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Board frame = new Board();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	int f = 4;

	/**
	 * Create the frame.
	 */
	public Board() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 450);
		setLocationRelativeTo(null);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);
		
		JMenuItem mntmAddField = new JMenuItem("Add Field");
		mntmAddField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paint(++f);
			}
		});
		mnDatei.add(mntmAddField);
		
		JMenuItem mntmSubField = new JMenuItem("Sub Field");
		mntmSubField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				paint(--f);
			}
		});
		mnDatei.add(mntmSubField);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);	
				
		addComponentListener(new ComponentListener() {
			
			@Override
			public void componentShown(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentResized(ComponentEvent e) {
				paint(f);
			}
			
			@Override
			public void componentMoved(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void componentHidden(ComponentEvent e) {
				// TODO Auto-generated method stub
				
			}
		});
			
		paint(f);
		
	}
	
	public void paint(int f) {
		contentPane.removeAll();
		int width = getSize().width;
		int height = getSize().height - 60;
		
		for(int i = 0; i < f; i++) {
			for(int j = 0; j < f; j++) {
				JPanel panel = new JPanel();
				panel.setBounds(width/f*j, height/f*i, width/f, height/f);
				panel.setBackground(Color.WHITE);
				if( (i + j) % 2 == 0)
					panel.setBackground(Color.BLACK);
				
				getContentPane().add(panel);
			}
		}
		contentPane.repaint();
	}

}
