package ch.wiss.swing.lotto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

public class MyLotto extends JFrame {

	private JPanel contentPane;
	private JPanel panel;
	private JLabel label;
	
	private Set<Integer> lottozahlen = new HashSet<Integer>();
	private int mode = 49;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyLotto frame = new MyLotto();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	int resizes = 0;
	/**
	 * Create the frame.
	 */
	public MyLotto() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.addComponentListener(new ComponentAdapter() {
			@Override
			public void componentResized(ComponentEvent e) {
				System.out.println(e.COMPONENT_RESIZED);
				if(resizes++ > 2) {
					contentPane.removeAll();
					placeElements();
				}
			}
		});		
		placeElements();
	}
	
	private void placeElements() {
		panel = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		contentPane.add(panel, BorderLayout.CENTER);	
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.EAST);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				if(lottozahlen.size() == 5) {
					Set<Integer> gewinnzahlen = new HashSet<Integer>();
					while(gewinnzahlen.size() < 5) {
						Random random = new Random();
						gewinnzahlen.add(random.nextInt(mode)+1);
					}
					
					for(int zug : lottozahlen) {
						((JLabel)panel.getComponent(zug-1)).setBorder(BorderFactory.createLineBorder(Color.BLUE,2));
						if(gewinnzahlen.contains(zug))
							((JLabel)panel.getComponent(zug-1)).setBorder(BorderFactory.createLineBorder(Color.GREEN,2));
						else
							((JLabel)panel.getComponent(zug-1)).setBorder(BorderFactory.createLineBorder(Color.YELLOW,2));
					}
					label.setText("Gewinnzahlen: " + gewinnzahlen.toString());
				}else
					JOptionPane.showMessageDialog(null, "Müssen 5 Zahlen sein", "Zuwenig Zahlen", JOptionPane.ERROR_MESSAGE);
			}
		});
		panel_1.add(btnPlay);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		label = new JLabel("");
		oldBackground = label.getBackground();
		panel_2.add(label);
		
		int labelSize = (int) Math.sqrt((this.getSize().width - panel_1.getPreferredSize().width)*(this.getSize().height - 150) / mode);
		
		for(int i = 1; i <= mode; i++) {
			JLabel field = new JLabel(i+"", SwingConstants.CENTER);
			field.addMouseListener(mouseListener);
			field.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
			field.setPreferredSize(new Dimension(labelSize,labelSize));
			panel.add(field);
		}
	}
	
	protected Color oldBackground;

	private MouseListener mouseListener = new MouseListener() {
		
		@Override
		public void mouseReleased(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mousePressed(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseExited(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseEntered(MouseEvent e) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void mouseClicked(MouseEvent e) {
			JLabel label = (JLabel)e.getSource();
			if(lottozahlen.contains(Integer.parseInt(label.getText()))) {
				lottozahlen.remove(Integer.parseInt(label.getText()));
				label.setBorder(BorderFactory.createLineBorder(Color.BLUE, 2));
				label.setBackground(oldBackground);
			}else {
				if(lottozahlen.size() < 5) {
					lottozahlen.add(Integer.parseInt(label.getText()));
					label.setBorder(BorderFactory.createLineBorder(Color.YELLOW, 2));
					label.setBackground(Color.WHITE);
					label.setOpaque(true);
				}else
					JOptionPane.showMessageDialog(null, "Maximal 5 möglich", "Zuviele Zahlen", JOptionPane.ERROR_MESSAGE);
			}
			
		}
	};
	
}
