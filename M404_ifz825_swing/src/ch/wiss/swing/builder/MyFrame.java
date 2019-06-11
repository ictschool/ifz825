package ch.wiss.swing.builder;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;
import javax.swing.JTextField;
import javax.swing.JList;
import javax.swing.event.ListSelectionListener;
import javax.swing.event.ListSelectionEvent;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;

public class MyFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MyFrame frame = new MyFrame();
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
	public MyFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 400);
		this.setLocationRelativeTo(null);

		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);

		JMenu mnDatei = new JMenu("Datei");
		menuBar.add(mnDatei);

		JMenuItem mntmSpeichern = new JMenuItem("Speichern");
		mnDatei.add(mntmSpeichern);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("Mein Text");
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);

		guggus = new JLabel("New label");
		guggus.setBounds(0, 1, 440, 41);
		panel_1.add(guggus);

		btnNewButton = new JButton("New button");
		btnNewButton.setBounds(0, 42, 134, 80);
		btnNewButton.addActionListener(actionlistener);
		btnNewButton.addActionListener(myActionLogger);
		btnNewButton.setActionCommand("new");
		btnNewButton.setBackground(Color.YELLOW);
		panel_1.add(btnNewButton);

		btnterButton = new JButton("2ter Button");
		btnterButton.setBounds(146, 42, 117, 25);
		btnterButton.addActionListener(actionlistener);
		btnterButton.setActionCommand("other");
		btnterButton.setBackground(Color.GREEN);
		btnterButton.addActionListener(myActionLogger);
		panel_1.add(btnterButton);

		comboBox = new JComboBox();
		comboBox.addItemListener(itemListener);
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "a", "b", "c", "d", "e" }));
		comboBox.setBounds(146, 87, 117, 24);
		comboBox.setActionCommand("a");
		panel_1.add(comboBox);

		comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "1", "2", "3", "4" }));
		comboBox_1.setBounds(146, 123, 117, 24);
		comboBox_1.addItemListener(itemListener);
		comboBox_1.setActionCommand("b");
		panel_1.add(comboBox_1);

		lblA = new JLabel("nada");
		lblA.setBounds(294, 92, 70, 15);
		panel_1.add(lblA);

		lblB = new JLabel("nada");
		lblB.setBounds(294, 128, 70, 15);
		panel_1.add(lblB);

		textField = new JTextField();
		textField.setBounds(146, 159, 114, 19);
		panel_1.add(textField);
		textField.setColumns(10);

		listContent = new DefaultListModel<>();
		JList<String> list = new JList<String>(listContent);
		list.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				textField.setText(list.getSelectedValue());
			}
		});
		list.setBounds(143, 196, 120, 60);
		panel_1.add(list);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setBounds(10, 134, 114, 161);
		panel_1.add(scrollPane);

		txtrLogger = new JTextArea();
		scrollPane.setViewportView(txtrLogger);
		txtrLogger.setLineWrap(true);
		txtrLogger.setEditable(false);
	}

	private JLabel guggus, lblA, lblB;
	private JButton btnNewButton, btnterButton;
	private JComboBox<String> comboBox, comboBox_1;
	private DefaultListModel<String> listContent;
	private JTextArea txtrLogger;
	private JTextField textField;

	private ActionListener myActionLogger = new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			txtrLogger.append(e.getActionCommand() + "clicked" + System.lineSeparator());
		}
	};

	ItemListener itemListener = new ItemListener() {
		@SuppressWarnings("unchecked")
		public void itemStateChanged(ItemEvent e) {
			if (e.getSource() instanceof JComboBox<?>) {
				JComboBox<String> cb = (JComboBox<String>) e.getSource();
				switch (cb.getActionCommand()) {
				case "a":
					lblA.setText(e.getItem().toString());
					break;
				case "b":
					lblB.setText(e.getItem().toString());
					break;
				}
			}
		}
	};

	ActionListener actionlistener = new ActionListener() {
		public void actionPerformed(ActionEvent e) {
			String a = btnNewButton.getText();
			Color c = btnNewButton.getBackground();
			switch (e.getActionCommand()) {
			case "new":
				guggus.setText("abcd");
				if(textField.getText().length() > 0)
					listContent.addElement(textField.getText());
				textField.setText("");
				break;
			case "other":
				guggus.setText("dcba");
				textField.setText(txtrLogger.getSelectedText());
				break;
			}
			btnNewButton.setText(btnterButton.getText());
			btnterButton.setText(a);
			btnNewButton.setBackground(btnterButton.getBackground());
			btnterButton.setBackground(c);
		}
	};
	
}
