package ch.wiss.swing.calculator;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

public class MyCalculator extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JComboBox<CalcType> comboBox;
	private JLabel result;
	private JTextArea textArea;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyCalculator frame = new MyCalculator();
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
	public MyCalculator() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 300, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setTitle("Calculator");

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		panel.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_4 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_4.getLayout();
		flowLayout.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_4);

		textField = new JTextField();
		panel_4.add(textField);
		textField.setColumns(10);

		textField_1 = new JTextField();
		panel_4.add(textField_1);
		textField_1.setColumns(10);

		JPanel panel_5 = new JPanel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_5.getLayout();
		flowLayout_1.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_5);

		JLabel lblNewLabel = new JLabel("Resultat");
		panel_5.add(lblNewLabel);

		result = new JLabel("...");
		panel_5.add(result);
		result.setPreferredSize(new Dimension(100, 20));

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.RIGHT, 5, 5));

		comboBox = new JComboBox<CalcType>();
		comboBox.setModel(new DefaultComboBoxModel<CalcType>(CalcType.values()));
		panel_1.add(comboBox);

		JButton btnNewButton = new JButton("Berechnen");
		panel_1.add(btnNewButton);
		btnNewButton.addActionListener(actionListener);

		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.EAST);

		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);

		JScrollPane scrollPane = new JScrollPane();
		panel_3.add(scrollPane);

		textArea = new JTextArea();
		textArea.setRows(5);
		textArea.setColumns(25);
		scrollPane.setViewportView(textArea);

		setLocationRelativeTo(null);
	}

	private ActionListener actionListener = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			double res = 0;
			try {
				switch ((CalcType) comboBox.getSelectedItem()) {
				case ADD:
					res = Double.parseDouble(textField.getText()) + Double.parseDouble(textField_1.getText());
					break;
				case SUB:
					res = Double.parseDouble(textField.getText()) - Double.parseDouble(textField_1.getText());
					break;
				case MUL:
					res = Double.parseDouble(textField.getText()) * Double.parseDouble(textField_1.getText());
					break;
				case DIV:
					res = Double.parseDouble(textField.getText()) / Double.parseDouble(textField_1.getText());
					break;
				default: throw new Exception("is noting selected")
					; 
				}
				result.setText(String.format("%.2f", res));
				addLogEntry(textField.getText(), textField_1.getText(),
						((CalcType) comboBox.getSelectedItem()).getValue(), String.format("%.2f", res));
			} catch (Exception ex) {

			}
		}
	};

	private void addLogEntry(String val1, String val2, String op, String res) {
		textArea.setText(textArea.getText() + val1 + op + val2 + "=" + res + "\n");
	}

}
