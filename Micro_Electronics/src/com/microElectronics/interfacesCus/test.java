package com.microElectronics.interfacesCus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.FlowLayout;

import javax.swing.border.Border;
import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.event.ActionListener;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JPasswordField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Color;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;
import javax.swing.border.MatteBorder;
import javax.swing.JScrollBar;

public class test extends JFrame {

	private JPanel contentPane;
	


	private JTextField textFieldEID;
	private JTextField textFieldEname;
	private JTextField textFieldEage;
	private JTextField textFieldEnic;
	private JTextField textFieldEtpNo;
	private JTextField textFieldEemail;
	private JTextField textFieldEworkExp;
	private JTextField textFieldEDate;
	private JPasswordField pwdE;
	private JTable table;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					test frame = new test();
					frame.setVisible(true);
					frame.setSize(1227, 640);
					frame.setBackground(new Color(128,0,128));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public test() {
		setBackground(new Color(139, 0, 139));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("Micro Elecronics - Employee Form");
		setBounds(75, 75, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(139, 0, 139));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(61, 29, 586, 34);
		panel.setBackground(new Color(204, 153, 255));
		panel.setForeground(new Color(255, 250, 250));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblApplicationForEmployeement = new JLabel("Application for Employeement");
		lblApplicationForEmployeement.setBounds(118, 11, 207, 17);
		lblApplicationForEmployeement.setForeground(new Color(153, 50, 204));
		lblApplicationForEmployeement.setFont(new Font("Tahoma", Font.BOLD, 14));
		panel.add(lblApplicationForEmployeement);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(61, 70, 586, 263);
		panel_3.setBackground(new Color(204, 153, 255));
		contentPane.add(panel_3);
		
		textFieldEID = new JTextField();
		textFieldEID.setBounds(103, 11, 86, 11);
		textFieldEID.setHorizontalAlignment(SwingConstants.LEFT);
		int h=5,w=50;
		panel_3.setLayout(null);
		panel_3.add(textFieldEID);
		textFieldEID.setColumns(10);
		
		textFieldEname = new JTextField();
		textFieldEname.setBounds(103, 33, 169, 11);
		panel_3.add(textFieldEname);
		textFieldEname.setColumns(10);
		
		JComboBox comboBoxEstatus = new JComboBox();
		comboBoxEstatus.setBounds(103, 47, 155, 20);
		comboBoxEstatus.setForeground(new Color(128, 0, 128));
		comboBoxEstatus.setModel(new DefaultComboBoxModel(new String[] {"Choose one", "Mr.", "Mrs.", "Miss.", "Ms."}));
		panel_3.add(comboBoxEstatus);
		
		textFieldEage = new JTextField();
		textFieldEage.setBounds(103, 78, 59, 11);
		panel_3.add(textFieldEage);
		textFieldEage.setColumns(10);
		
		textFieldEnic = new JTextField();
		textFieldEnic.setBounds(103, 97, 290, 11);
		panel_3.add(textFieldEnic);
		textFieldEnic.setColumns(10);
		
		pwdE = new JPasswordField();
		pwdE.setBounds(103, 115, 69, 11);
		panel_3.add(pwdE);
		
		textFieldEtpNo = new JTextField();
		textFieldEtpNo.setBounds(103, 137, 77, 11);
		panel_3.add(textFieldEtpNo);
		textFieldEtpNo.setColumns(10);
		
		textFieldEemail = new JTextField();
		textFieldEemail.setBounds(103, 159, 117, 11);
		panel_3.add(textFieldEemail);
		textFieldEemail.setColumns(10);
		
	
		
		textFieldEworkExp = new JTextField();
		textFieldEworkExp.setBounds(103, 197, 187, 20);
		panel_3.add(textFieldEworkExp);
		textFieldEworkExp.setColumns(10);
		
		textFieldEDate = new JTextField();
		textFieldEDate.setBounds(103, 175, 187, 20);
		panel_3.add(textFieldEDate);
		textFieldEDate.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(103, 221, 86, 11);
		panel_3.add(textField);
		textField.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 117, 271);
		panel_3.add(panel_1);
		panel_1.setBackground(new Color(204, 153, 255));
		panel_1.setLayout(null);
		
		JLabel lblEmpID = new JLabel("Employee ID");
		lblEmpID.setBounds(10, 11, 84, 11);
		lblEmpID.setForeground(new Color(128, 0, 128));
		lblEmpID.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEmpID);
		
		JLabel lblEName = new JLabel("Name");
		lblEName.setBounds(10, 30, 84, 11);
		lblEName.setForeground(new Color(128, 0, 128));
		lblEName.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEName);
		
		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(10, 52, 74, 11);
		lblStatus.setForeground(new Color(128, 0, 128));
		lblStatus.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblStatus);
		
		JLabel lblEAge = new JLabel("Age");
		lblEAge.setBounds(10, 74, 73, 11);
		lblEAge.setForeground(new Color(128, 0, 128));
		lblEAge.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEAge);
		
		JLabel lblENIC = new JLabel("NIC");
		lblENIC.setBounds(10, 96, 84, 11);
		lblENIC.setForeground(new Color(128, 0, 128));
		lblENIC.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblENIC);
		
		JLabel lblEPwd = new JLabel("Password");
		lblEPwd.setBounds(10, 114, 84, 11);
		lblEPwd.setForeground(new Color(128, 0, 128));
		lblEPwd.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEPwd);
		
		JLabel lblETpNo = new JLabel("TelephoneNo");
		lblETpNo.setBounds(10, 136, 84, 11);
		lblETpNo.setForeground(new Color(128, 0, 128));
		lblETpNo.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblETpNo);
		
		JLabel lblEemail = new JLabel("Email");
		lblEemail.setBounds(10, 158, 84, 11);
		lblEemail.setForeground(new Color(128, 0, 128));
		lblEemail.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEemail);
		
		JLabel lblEEduQuali = new JLabel("Qualifications");
		lblEEduQuali.setBounds(10, 176, 84, 11);
		lblEEduQuali.setForeground(new Color(128, 0, 128));
		lblEEduQuali.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEEduQuali);
		
		JLabel lblEWorkExp = new JLabel("Work_Experience");
		lblEWorkExp.setBounds(10, 198, 84, 11);
		lblEWorkExp.setForeground(new Color(128, 0, 128));
		lblEWorkExp.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblEWorkExp);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(10, 220, 84, 11);
		lblDate.setForeground(new Color(128, 0, 128));
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDate);
		
		JButton btnReset = new JButton("Reset");
		btnReset.setBackground(new Color(221, 160, 221));
		btnReset.setForeground(new Color(128, 0, 128));
		btnReset.setBounds(412, 234, 77, 23);
		panel_3.add(btnReset);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.setBackground(new Color(221, 160, 221));
		btnAdd.setForeground(new Color(128, 0, 128));
		btnAdd.setBounds(326, 234, 77, 23);
		panel_3.add(btnAdd);
		
		JButton btnBack = new JButton("Back");
		btnBack.setBackground(new Color(221, 160, 221));
		btnBack.setForeground(new Color(128, 0, 128));
		btnBack.setBounds(497, 234, 79, 23);
		panel_3.add(btnBack);
		
	
		String[] columnNames={"EmpID","Name","Age","NIC","TelNo","Email","Qualificatios","Experience","AccountNo","Date"};
		String[][] rowData= {
				{"EmpID","Name","Age","NIC","TelNo","Email","Qualificatios","Experience","AccountNo","Date"},
				{"EID1","Alice","25","947362304","0112255978","alice@gmail.com","A/L","1yr","74583256","12.03.2017"}	
				
		};
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(61, 338, 586, 93);
		contentPane.add(panel_4);
		panel_4.setBackground(new Color(204, 153, 255));
		panel_4.setLayout(null);
		table = new JTable(rowData,columnNames);
		table.setBounds(26, 36, 535, 32);
		panel_4.add(table);
		table.setAlignmentY(CENTER_ALIGNMENT);
		table.setBorder(new MatteBorder(1, 1, 1, 1, (Color) new Color(128, 0, 128)));
		
		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setBounds(236, 11, 106, 14);
		panel_4.add(lblEmployeeDetails);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(569, 0, 17, 79);
		panel_4.add(scrollBar);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(102, 0, 102));
		panel_2.setBounds(0, 0, 889, 21);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton = new JButton("X");
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBackground(new Color(255, 0, 0));
		btnNewButton.setBounds(634, 0, 55, 23);
		panel_2.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("-");
		btnNewButton_1.setBounds(579, -1, 55, 23);
		panel_2.add(btnNewButton_1);
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		
		
		
		 setUndecorated(true) ;
		
	}

}
