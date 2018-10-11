package project;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.xml.crypto.Data;


import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Cursor;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.UIManager;
import javax.swing.JPasswordField;

import java.util.Calendar;
import java.util.Properties;

public class addLeave extends JFrame {

	private JPanel contentPane;
	public static final String DateFormat = "dd/MM/yyyy";
	private static JTextField textField;
	private static JTextField textField_1;
	private static JTextField textField_2;
	private static JTextField textField_3;
	private static JTextField textField_4;
	private static JTextField textField_5;
	private static JTextField textField_6;
	private static JTextField textField_7;
	private JTextField textField_8;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addLeave frame = new addLeave();
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
	public addLeave() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1225, 648);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		
		
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(0, 461, 1215, 13);
		contentPane.add(panel_2);
	
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, 0, 1226, 37);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("-");
		label_1.setBounds(1170, 0, 10, 29);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(label_1);
		
		JLabel label = new JLabel("X");
		label.setBounds(1200, 0, 16, 29);
		label.setForeground(Color.WHITE);
 		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(label);
		
		JLabel lblAddLeave = new JLabel("Add Leave");
		lblAddLeave.setForeground(new Color(255, 255, 255));
		lblAddLeave.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblAddLeave.setBounds(21, 11, 124, 14);
		panel.add(lblAddLeave);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(0, 509, 960, -35);
		contentPane.add(panel_1);
		
		JLabel lblAddLeave_1 = new JLabel("Leave Application Form");
		lblAddLeave_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblAddLeave_1.setForeground(new Color(128, 0, 128));
		lblAddLeave_1.setBounds(480, 72, 311, 37);
		contentPane.add(lblAddLeave_1);
		
		JLabel lblEmpNo = new JLabel("Emp No");
		lblEmpNo.setForeground(new Color(128, 0, 128));
		lblEmpNo.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmpNo.setBounds(67, 200, 176, 37);
		contentPane.add(lblEmpNo);
		
		JLabel lblEmpName = new JLabel("Emp Name");
		lblEmpName.setForeground(new Color(128, 0, 128));
		lblEmpName.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblEmpName.setBounds(67, 248, 176, 37);
		contentPane.add(lblEmpName);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(new Color(128, 0, 128));
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblDesignation.setBounds(67, 296, 176, 37);
		contentPane.add(lblDesignation);
		
		JLabel lblLeaveStartDate = new JLabel("Leave Start Date");
		lblLeaveStartDate.setForeground(new Color(128, 0, 128));
		lblLeaveStartDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLeaveStartDate.setBounds(67, 365, 176, 37);
		contentPane.add(lblLeaveStartDate);
		
		JLabel lblLeaveEnddate = new JLabel("Leave EndDate");
		lblLeaveEnddate.setForeground(new Color(128, 0, 128));
		lblLeaveEnddate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblLeaveEnddate.setBounds(441, 371, 176, 37);
		contentPane.add(lblLeaveEnddate);
		
		JLabel lblNextReportingDay = new JLabel("Next Reporting Day For Work");
		lblNextReportingDay.setForeground(new Color(128, 0, 128));
		lblNextReportingDay.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNextReportingDay.setBounds(778, 371, 283, 37);
		contentPane.add(lblNextReportingDay);
		
		JLabel lblReasonForLeave = new JLabel("Reason For Leave");
		lblReasonForLeave.setForeground(new Color(128, 0, 128));
		lblReasonForLeave.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblReasonForLeave.setBounds(67, 413, 176, 37);
		contentPane.add(lblReasonForLeave);
		
		textField = new JTextField();
		textField.setBounds(237, 200, 311, 31);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton button = new JButton("Search");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				 String value = textField.getText();
				    int l = value.length();
				    
				if(l<5) {
					
					
					String driverName = "com.mysql.jdbc.Driver";
					String connectionUrl = "jdbc:mysql://localhost:3306/";
					String dbName = "micro_electronics";
					String userId = "root";
					String password = "";

					try {
					Class.forName(driverName);
					} catch (ClassNotFoundException e) {
					e.printStackTrace();
					}

					Connection connection = null;
					Statement statement = null;
					ResultSet resultSet = null;	
					
					
					String id=textField.getText();
					
					
					
					try{ 
						connection = DriverManager.getConnection(connectionUrl+dbName, userId, password);
						statement=connection.createStatement();
						String sql ="SELECT * FROM employee where EID="+id ;   //need session

						resultSet = statement.executeQuery(sql);
						
						while(resultSet.next()){
					
								textField_1.setText(resultSet.getString("Name"));
								textField_2.setText(resultSet.getString("Designation"));
								
							
								
						}
			
					if(textField_1.getText().equals("")){
						JOptionPane.showMessageDialog(null, "Incorrect ID","WARNING!!",JOptionPane.WARNING_MESSAGE);
					}
					
					
						connection.close();

					}catch (Exception e) {
					e.printStackTrace();
					}
					
				}
				else {
		              JOptionPane.showMessageDialog(null, "Incorrect ID","WARNING!!",JOptionPane.WARNING_MESSAGE);

				}
			
				
				
				
				
				
				
				
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(128, 0, 128));
		button.setBounds(556, 200, 89, 23);
		contentPane.add(button);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(238, 248, 311, 31);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(238, 296, 311, 31);
		contentPane.add(textField_2);
		
		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(237, 371, 176, 31);
		contentPane.add(textField_3);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(581, 371, 176, 31);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.setColumns(10);
		textField_5.setBounds(1021, 371, 176, 31);
		contentPane.add(textField_5);
		
		JLabel lbl1 = new JLabel("Yes");
		lbl1.setFont(new Font("Tahoma", Font.PLAIN, 5));
		lbl1.setForeground(new Color(255, 255, 255));
		lbl1.setBounds(1169, 41, 46, 14);
		contentPane.add(lbl1);
		
		
		textField_6 = new JTextField();
		textField_6.setColumns(10);
		textField_6.setBounds(237, 413, 520, 37);
		contentPane.add(textField_6);
		
		JButton btnConfirmLeave = new JButton("Confirm Leave");
		btnConfirmLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			
			
			
				
				
				
				
				
				try{
					String driver = "com.mysql.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/micro_electronics";
					String username = "root";
					String password = "";
					
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url,username,password);
					Statement stmt = conn.createStatement();
					PreparedStatement pst = conn.prepareStatement("Select id,password from log where id=? and password=? ");

					String id= textField_8.getText();
					String pwd = passwordField.getText();
					
					pst.setString(1, id);
					pst.setString(2,pwd);
					
					ResultSet rs = pst.executeQuery();
					
					
					
					
					if(rs.next()) {          
						

						
						
									String ID=textField.getText();
									String name=textField_1.getText();
									String designation=textField_2.getText();
									String sdate=textField_3.getText();
									String edate=textField_4.getText();
 									String rdate=textField_5.getText();
									String reason=textField_6.getText();
									String tdate=textField_7.getText();
									String recBy=textField_8.getText();
									String retDate=textField_5.getText();
									String arrival=lbl1.getText();



									try {
										
										
											
										
							String sql="Insert Into leaves (ID,name,designation,sdate,edate,rdate,reason,tdate,recBy,retDate,arrival)values('"+ID+"','"+name+"','"+designation+"','"+sdate+"','"+edate+"','"+rdate+"','"+reason+"','"+tdate+"','"+recBy+"','"+retDate+"','"+arrival+"')";
							
							Statement st=conn.createStatement();
							int n=st.executeUpdate(sql);
							
							
							if(n==1) {
								JOptionPane.showMessageDialog(null,"Your Leave Is Recorded.");
								dispose();
							}
							else {
								JOptionPane.showMessageDialog(null,"Your Leave is Unsuccesfull");
							}
							
							conn.close();
									}
									catch(Exception e1){
										System.out.println(e1);
									}


					}
					
					else{
						JOptionPane.showMessageDialog(null,"Your Leave is Unsuccesfull");
					
					}


					}catch(Exception ex){
						ex.printStackTrace();
					}


				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
				
				
				
				
				
				
			}
		});
		btnConfirmLeave.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		btnConfirmLeave.setForeground(Color.WHITE);
		btnConfirmLeave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnConfirmLeave.setBackground(new Color(255, 0, 0));
		btnConfirmLeave.setBounds(1010, 557, 168, 53);
		contentPane.add(btnConfirmLeave);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancel.setForeground(Color.WHITE);
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnCancel.setBackground(new Color(128, 0, 128));
		btnCancel.setBounds(798, 557, 168, 53);
		contentPane.add(btnCancel);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		textField_7 = new JTextField();
		textField_7.setColumns(10);
		textField_7.setBounds(864, 187, 176, 31);
		contentPane.add(textField_7);
		textField_7.setText(now1());
		
		JLabel lblTodayDate = new JLabel("Today Date");
		lblTodayDate.setForeground(new Color(128, 0, 128));
		lblTodayDate.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblTodayDate.setBounds(752, 187, 176, 37);
		contentPane.add(lblTodayDate);
		
		JLabel lblOfficeUsesOnly = new JLabel("Office Uses Only");
		lblOfficeUsesOnly.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblOfficeUsesOnly.setForeground(new Color(255, 0, 0));
		lblOfficeUsesOnly.setBounds(30, 485, 176, 13);
		contentPane.add(lblOfficeUsesOnly);
		
		JLabel lblRecomendedBy = new JLabel("Recomended By");
		lblRecomendedBy.setForeground(new Color(0, 0, 0));
		lblRecomendedBy.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblRecomendedBy.setBounds(67, 521, 176, 13);
		contentPane.add(lblRecomendedBy);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.BLACK);
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblPassword.setBounds(67, 552, 176, 13);
		contentPane.add(lblPassword);
		
		textField_8 = new JTextField();
		textField_8.setBounds(237, 519, 185, 20);
		contentPane.add(textField_8);
		textField_8.setColumns(10);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(237, 128, 46, 14);
		
		contentPane.add(label_3);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(237, 545, 185, 20);
		contentPane.add(passwordField);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(18, 41, 1208, 596);
		
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\panel.jpg"));
		contentPane.add(lblNewLabel);
		
	
	
		
setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
	
	
	
	
	
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
}
	
	

