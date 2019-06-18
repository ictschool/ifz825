package ch.wiss.swing.average;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JList;
import javax.swing.JLabel;

public class AverageCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JList<Double> list;
	private DefaultListModel<Double> model;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AverageCalculator frame = new AverageCalculator();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AverageCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("AVG Calculator");
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		textField = new JTextField();
		panel.add(textField);
		textField.setColumns(10);
		
		JButton btnInsert = new JButton("Insert");
		btnInsert.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				model.addElement(Double.parseDouble(textField.getText()));
				list.ensureIndexIsVisible(model.getSize()-1);
				double avg = 0;
				for(int i = 0 ; i < model.getSize(); i++) {
					avg += model.get(i);
				}
				label.setText(String.format("%.2f", avg/model.getSize()));
			}
		});
		panel.add(btnInsert);
		
		JScrollPane scrollPane = new JScrollPane();
		contentPane.add(scrollPane, BorderLayout.CENTER);
		scrollPane.setAutoscrolls(true);
		
		list = new JList<Double>();
		model = new DefaultListModel<Double>();
		list.setModel(model);
		list.setAutoscrolls(true);
		scrollPane.setViewportView(list);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.SOUTH);
		
		JLabel lblAverage = new JLabel("Average: ");
		panel_1.add(lblAverage);
		
		label = new JLabel("...");
		panel_1.add(label);
	}

}
