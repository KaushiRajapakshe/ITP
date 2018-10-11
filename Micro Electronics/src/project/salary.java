package project;
import javax.naming.Context;
import java.util.*;
import java.util.Date;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.sql.*;


import java.text.SimpleDateFormat;
import java.awt.event.*;
import javax.swing.*;
import com.toedter.calendar.JYearChooser;
public class salary extends JFrame {
	public static final String DateFormat = "dd/MM/yyyy";
	public static final String DateFormat1 = "MM";
	
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_9;
	private JTextField lblDate;

	/**
	 * Launch the application.
	 * @return 
	 */
	

	 
	public interface totalSal{
		
		public double cal(double gross, double deduct);
		
	}
	
	public  class Sal implements totalSal{

		private double gross;
		private double deduct;
		private double total;
		
		
	
		
		
		@Override
		public double cal(double gross,double deduct) {
			total=gross-deduct;
			return total ;
			// TODO Auto-generated method stub
			
		}
		
	}
	
	
	public class Context {
		   private totalSal strategy;

		   public Context(totalSal strategy){
		      this.strategy = strategy;
		   }

		   public double executeStrategy(double gross,double deduct){
		      return strategy.cal(gross,deduct);
		   }
		}
	
	
	

	public static void main(String[] args) {
	
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salary frame = new salary();
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
	
	
	
	
	
	public salary() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1228, 640);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
	
		



		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1226, 37);
		panel.setBackground(new Color(128, 0, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 setState(ICONIFIED);	
				
			}
		});
		
		
		
		
		label_1.setBounds(1170, 0, 10, 29);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(label_1);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		label.setBounds(1200, 0, 16, 29);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		panel.add(label);
		
		JLabel lblSalaryForm = new JLabel("Salary Form");
		lblSalaryForm.setBounds(10, 5, 108, 25);
		panel.add(lblSalaryForm);
		lblSalaryForm.setForeground(new Color(255, 255, 255));
		lblSalaryForm.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JPanel panel_5 = new JPanel();
		panel_5.setLayout(null);
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(941, 33, 277, 394);
		contentPane.add(panel_5);
		
		JLabel label_7 = new JLabel("***************************");
		label_7.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_7.setBounds(27, 11, 257, 14);
		panel_5.add(label_7);
		
		JLabel label_8 = new JLabel("*******************");
		label_8.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_8.setBounds(62, 381, 240, 14);
		panel_5.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(52, 118, 46, 14);
		panel_5.add(label_9);
		
		JLabel label_10 = new JLabel("Micro Electronics");
		label_10.setFont(new Font("SriLankan", Font.BOLD, 16));
		label_10.setBounds(70, 21, 186, 22);
		panel_5.add(label_10);
		
		JLabel label_11 = new JLabel("Monthly Salary Report");
		label_11.setBounds(80, 41, 176, 14);
		panel_5.add(label_11);
		
		JLabel label_12 = new JLabel("Name:");
		label_12.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_12.setBounds(10, 61, 46, 14);
		panel_5.add(label_12);
		
		JLabel label_13 = new JLabel("EID:");
		label_13.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_13.setBounds(10, 86, 46, 14);
		panel_5.add(label_13);
		
		JLabel label_14 = new JLabel("Designation:");
		label_14.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_14.setBounds(10, 136, 88, 14);
		panel_5.add(label_14);
		
		JLabel label_15 = new JLabel("Basic Salary:");
		label_15.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_15.setBounds(10, 111, 76, 14);
		panel_5.add(label_15);
		
		JLabel label_16 = new JLabel("No of Leaves");
		label_16.setBounds(10, 164, 76, 14);
		panel_5.add(label_16);
		
		JLabel label_17 = new JLabel("Normal OT");
		label_17.setBounds(10, 189, 71, 14);
		panel_5.add(label_17);
		
		JLabel label_18 = new JLabel("Performance Incensive");
		label_18.setBounds(10, 214, 115, 14);
		panel_5.add(label_18);
		
		JLabel label_19 = new JLabel("Advance");
		label_19.setBounds(10, 248, 46, 14);
		panel_5.add(label_19);
		
		JLabel label_20 = new JLabel("EPF(8%)");
		label_20.setBounds(10, 273, 46, 14);
		panel_5.add(label_20);
		
		JLabel label_21 = new JLabel("Net Salary");
		label_21.setFont(new Font("Tahoma", Font.BOLD, 11));
		label_21.setBounds(10, 318, 71, 14);
		panel_5.add(label_21);
		
		JLabel txtLeave = new JLabel("");
		txtLeave.setBounds(134, 164, 69, 14);
		panel_5.add(txtLeave);
		
		JLabel txtOT = new JLabel("");
		txtOT.setBounds(134, 189, 69, 14);
		panel_5.add(txtOT);
		
		JLabel txtPer = new JLabel("");
		txtPer.setBounds(135, 214, 68, 14);
		panel_5.add(txtPer);
		
		JLabel txtGross = new JLabel("");
		txtGross.setBounds(205, 214, 62, 14);
		panel_5.add(txtGross);
		
		JLabel txtAdvance = new JLabel("");
		txtAdvance.setBounds(134, 248, 69, 14);
		panel_5.add(txtAdvance);
		
		JLabel txtEPF = new JLabel("");
		txtEPF.setBounds(134, 273, 69, 14);
		panel_5.add(txtEPF);
		
		JLabel txtDeduct = new JLabel("");
		txtDeduct.setBounds(205, 273, 62, 14);
		panel_5.add(txtDeduct);
		
		JLabel txtNet = new JLabel("");
		txtNet.setFont(new Font("Tahoma", Font.BOLD, 11));
		txtNet.setBounds(205, 318, 62, 14);
		panel_5.add(txtNet);
		
		JLabel txtName = new JLabel("");
		txtName.setBounds(107, 61, 149, 14);
		panel_5.add(txtName);
		
		JLabel txtBsal = new JLabel("");
		txtBsal.setBounds(108, 111, 176, 14);
		panel_5.add(txtBsal);
		
		JLabel txtID = new JLabel("");
		txtID.setBounds(107, 86, 62, 14);
		panel_5.add(txtID);
		
		JLabel txtDesi = new JLabel("");
		txtDesi.setBounds(108, 136, 176, 14);
		panel_5.add(txtDesi);
		
		JLabel label_34 = new JLabel("THANK YOU");
		label_34.setFont(new Font("Tahoma", Font.BOLD, 12));
		label_34.setBounds(101, 356, 91, 14);
		panel_5.add(label_34);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(0, 97, 1226, 10);
		contentPane.add(panel_1);
		
		JLabel lblEmployee = new JLabel("Employee ID");
		lblEmployee.setForeground(new Color(128, 0, 128));
		lblEmployee.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployee.setBounds(40, 54, 136, 20);
		contentPane.add(lblEmployee);
		
		textField = new JTextField();
		textField.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				
				char c=arg0.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
					arg0.consume();
				}
				
			}
		});
		
		
		
		textField.setBounds(142, 56, 207, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("Search");
		btnNewButton.addActionListener(new ActionListener() {
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
								textField_4.setText(resultSet.getString("Salary"));
								
								txtID.setText(id);

								txtName.setText(textField_1.getText());
								txtDesi.setText(textField_2.getText());
								txtBsal.setText(textField_4.getText());
								
							
								
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
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnNewButton.setBounds(359, 53, 89, 23);
		contentPane.add(btnNewButton);
		
		JLabel lblEmployeeName = new JLabel("Employee Name");
		lblEmployeeName.setForeground(new Color(128, 0, 128));
		lblEmployeeName.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEmployeeName.setBounds(22, 132, 136, 20);
		contentPane.add(lblEmployeeName);
		
		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setForeground(new Color(128, 0, 128));
		lblDesignation.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblDesignation.setBounds(371, 132, 136, 20);
		contentPane.add(lblDesignation);
		
		JLabel lblRegistrationDate = new JLabel("Date");
		lblRegistrationDate.setForeground(new Color(128, 0, 128));
		lblRegistrationDate.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblRegistrationDate.setBounds(489, 48, 136, 20);
		contentPane.add(lblRegistrationDate);
		
		textField_1 = new JTextField();
		textField_1.setBounds(142, 132, 207, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(458, 134, 189, 20);
		contentPane.add(textField_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(0, 176, 1226, 10);
		contentPane.add(panel_2);
		
		JLabel lblBasicSalary = new JLabel("Basic Salary");
		lblBasicSalary.setForeground(new Color(128, 0, 128));
		lblBasicSalary.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblBasicSalary.setBounds(22, 217, 136, 20);
		contentPane.add(lblBasicSalary);
		
		textField_4 = new JTextField();
		textField_4.setColumns(10);
		textField_4.setBounds(142, 219, 207, 20);
		contentPane.add(textField_4);
		
		textField_5 = new JTextField();
		textField_5.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c=arg0.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
					arg0.consume();
				}
				
			}
		});
		textField_5.setColumns(10);
		textField_5.setBounds(468, 219, 189, 20);
		contentPane.add(textField_5);
		
		JLabel lblNoOfLeaves = new JLabel("No of leaves");
		lblNoOfLeaves.setForeground(new Color(128, 0, 128));
		lblNoOfLeaves.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNoOfLeaves.setBounds(371, 217, 136, 20);
		contentPane.add(lblNoOfLeaves);
		
		JLabel lblPerformanceVariableIncentive = new JLabel("Performance Variable Incentive");
		lblPerformanceVariableIncentive.setForeground(new Color(128, 0, 128));
		lblPerformanceVariableIncentive.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblPerformanceVariableIncentive.setBounds(22, 263, 236, 20);
		contentPane.add(lblPerformanceVariableIncentive);
		
		textField_6 = new JTextField();
		textField_6.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField_6.setColumns(10);
		textField_6.setBounds(242, 265, 106, 20);
		contentPane.add(textField_6);
		
		textField_7 = new JTextField();
		textField_7.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
				
			}
		});
		textField_7.setColumns(10);
		textField_7.setBounds(468, 262, 189, 20);
		contentPane.add(textField_7);
		
		JLabel lblNormalOt = new JLabel("Normal OT");
		lblNormalOt.setForeground(new Color(128, 0, 128));
		lblNormalOt.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblNormalOt.setBounds(371, 263, 136, 20);
		contentPane.add(lblNormalOt);

		
		JLabel lblGrossSalary = new JLabel("Gross Salary :");
		lblGrossSalary.setForeground(new Color(0, 0, 0));
		lblGrossSalary.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblGrossSalary.setBounds(478, 301, 136, 20);
		contentPane.add(lblGrossSalary);
		
		JLabel label_2 = new JLabel("");
		label_2.setForeground(new Color(0, 0, 0));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(637, 301, 136, 20);
		contentPane.add(label_2);
		
		JLabel label_6 = new JLabel("2");
		label_6.setForeground(new Color(128, 0, 128));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 10));
		label_6.setBounds(605, 197, 136, 20);
		contentPane.add(label_6);
		
		
		JButton btnGrossSalary = new JButton("Gross Salary");
		btnGrossSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				double result;
				
				int leave=Integer.parseInt(textField_5.getText());
				int max=2;
				 
				
				int leaves =  Integer.parseInt(textField_5.getText());
				   String z1= Integer.toString(leaves);   
				txtLeave.setText(z1);			
				
				double ot =  Double.valueOf(textField_7.getText());
				   String z2= Double.toString(ot);   
				txtOT.setText(z2);	
				
				double per =  Double.valueOf(textField_6.getText());
				   String z3= Double.toString(per);   
				txtPer.setText(z3);	
				
				
			
				if(leave>2) {
					int due = Integer.parseInt(textField_5.getText())-Integer.parseInt(label_6.getText());
					int ret=due*98;
					
					
			
					    result =  Double.valueOf(textField_4.getText()) +  Double.valueOf(textField_6.getText())+ Double.valueOf(textField_7.getText())-ret;    
					   String z= Double.toString(result);   
						label_2.setText(z);
						txtGross.setText(z);

				}
				else {
					
					 result = Double.valueOf(textField_4.getText()) +  Double.valueOf(textField_6.getText())+ Double.valueOf(textField_7.getText());    
					   String z= Double.toString(result);   
						label_2.setText(z);
						txtGross.setText(z);

					
					
				}
	
			}
		});
		
		
		
		btnGrossSalary.setForeground(new Color(255, 255, 255));
		btnGrossSalary.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnGrossSalary.setBackground(new Color(128, 0, 128));
		btnGrossSalary.setBounds(716, 237, 161, 33);
		contentPane.add(btnGrossSalary);
		
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 128));
		panel_3.setBounds(0, 349, 1226, 10);
		contentPane.add(panel_3);
		
		JLabel lblEpfEmployeeCont = new JLabel("EPF Employee Cont.(8%)");
		lblEpfEmployeeCont.setForeground(new Color(128, 0, 128));
		lblEpfEmployeeCont.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblEpfEmployeeCont.setBounds(40, 406, 236, 20);
		contentPane.add(lblEpfEmployeeCont);
		
		JLabel lblAdvanceIi = new JLabel("Advance II");
		lblAdvanceIi.setForeground(new Color(128, 0, 128));
		lblAdvanceIi.setFont(new Font("Tahoma", Font.PLAIN, 16));
		lblAdvanceIi.setBounds(40, 375, 236, 20);
		contentPane.add(lblAdvanceIi);
		
		textField_9 = new JTextField();
		textField_9.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				char c=e.getKeyChar();
				if(!(Character.isDigit(c) || (c==KeyEvent.VK_BACK_SPACE) || c==KeyEvent.VK_DELETE)) {
					e.consume();
				}
			}
		});
		textField_9.setColumns(10);
		textField_9.setBounds(270, 375, 207, 20);
		contentPane.add(textField_9);
		
		
		
		JLabel label_5 = new JLabel("");
		label_5.setForeground(new Color(128, 0, 128));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 16));
		label_5.setBounds(241, 406, 236, 20);
		contentPane.add(label_5);
		
		JLabel label_4 = new JLabel("");
		label_4.setForeground(new Color(0, 0, 0));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_4.setBounds(637, 424, 136, 20);
		contentPane.add(label_4);
		
		
		JButton btnCalculateDeduction = new JButton("Calculate Deduction");
		btnCalculateDeduction.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
	
				double epf;
				
				epf=Double.valueOf(label_2.getText())*0.08;
				
				
				double adv =  Double.valueOf(textField_9.getText());
				   String z3= Double.toString(adv);   
				txtAdvance.setText(z3);	
				
				
				 String y= Double.toString(epf);   
					label_5.setText(y);
					txtEPF.setText(y);

				
				
				
				 String y1= Double.toString(epf);   
					label_5.setText(y1);
	
					double result2;
				    result2 =   Double.valueOf(label_5.getText())+ Double.valueOf(textField_9.getText());    
				   String z= Double.toString(result2);   
					label_4.setText(z);
					txtDeduct.setText(z);


		
				
				
			}
		});
		btnCalculateDeduction.setForeground(Color.WHITE);
		btnCalculateDeduction.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnCalculateDeduction.setBackground(new Color(128, 0, 128));
		btnCalculateDeduction.setBounds(700, 370, 184, 33);
		contentPane.add(btnCalculateDeduction);
		
		JLabel lblTotalDeduction = new JLabel("Total Deduction :");
		lblTotalDeduction.setForeground(new Color(0, 0, 0));
		lblTotalDeduction.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTotalDeduction.setBounds(472, 424, 207, 20);
		contentPane.add(lblTotalDeduction);
		
		
		JLabel lblNetSalary = new JLabel("");
		lblNetSalary.setForeground(Color.RED);
		lblNetSalary.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNetSalary.setBounds(958, 557, 334, 40);
		contentPane.add(lblNetSalary);
		
		
		lblDate = new JTextField();
		lblDate.setForeground(Color.BLUE);
		lblDate.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblDate.setBounds(535, 48, 138, 26);
		lblDate.setText(now1());
		lblDate.setEditable(false);
		contentPane.add(lblDate);
		
		

		JButton btnCalculateNetSalary = new JButton("Calculate Net Salary");
		btnCalculateNetSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				double total;
			    total =   Double.valueOf(label_2.getText())- Double.valueOf(label_4.getText());    
			   String z= Double.toString(total);   
			   lblNetSalary.setText(""+z);
			   txtNet.setText(z);
			   
			   
			   
			   
				String ID=textField.getText();
				String Name=textField_1.getText();
				String Designation=textField_2.getText();
				String Today=lblDate.getText();
				String Bsal=textField_4.getText();
				String leaves=textField_5.getText();
				String OT=textField_7.getText();
				String Performance=textField_6.getText();
				String Advance=textField_9.getText();
				String EPF=label_5.getText();
				String Gross=label_2.getText();
				String Deduction=label_4.getText();
				String NetSal=lblNetSalary.getText();

				
				
				
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
		   			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
					
					if(con!=null) {
						System.out.println("Success");
						
					}
					else {
						System.out.println("failed");
					}
					
					
						
					
		String sql="Insert Into salary values("+ID+",'"+Name+"','"+Designation+"','"+Today+"','"+Bsal+"','"+leaves+"','"+OT+"','"+Performance+"','"+Advance+"','"+EPF+"','"+Gross+"','"+Deduction+"','"+NetSal+"','"+date()+"')";
		
		Statement st=con.createStatement();
		int n=st.executeUpdate(sql);
		
		
		if(n==1) {
			JOptionPane.showMessageDialog(null,"Monthly Salary:Rs."+lblNetSalary.getText());
			
			
		}
		else {
			JOptionPane.showMessageDialog(null,"Failed");
		}
		
		con.close();
				}
				catch(Exception e1){
					System.out.println(e1);
				}
	
	

			}
		});
		btnCalculateNetSalary.setForeground(Color.WHITE);
		btnCalculateNetSalary.setFont(new Font("Tahoma", Font.BOLD, 19));
		btnCalculateNetSalary.setBackground(new Color(255, 0, 0));
		btnCalculateNetSalary.setBounds(519, 557, 236, 49);
		contentPane.add(btnCalculateNetSalary);
		
	
		
		JButton btnPrint = new JButton("Cancel");
		btnPrint.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnPrint.setForeground(Color.WHITE);
		btnPrint.setFont(new Font("Tahoma", Font.BOLD, 15));
		btnPrint.setBackground(new Color(128, 0, 128));
		btnPrint.setBounds(40, 567, 106, 33);
		contentPane.add(btnPrint);
		
		JButton button = new JButton("Print ");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
			PrinterJob job=PrinterJob.getPrinterJob();
			job.setJobName("Print Data");
			
			job.setPrintable(new Printable(){
				public int print(Graphics pg,PageFormat pf,int pageNum) {
					
					
					if (pageNum>0) {
						return Printable.NO_SUCH_PAGE;
					}
					
					
					Graphics2D g2=(Graphics2D)pg;
					g2.translate(pf.getImageableX(), pf.getImageableY());
					g2.scale(0.24, 0.24);
					
					panel_5.paint(g2);
					
					return Printable.PAGE_EXISTS;
						
				}

						}
		);
			
		boolean ok=job.printDialog();
		if(ok) {
			try {
				job.print();
				JOptionPane.showMessageDialog(null,"Printing Successfully");
			}catch(PrinterException ex) {}
			
		}
			}});
			
		
		button.setForeground(Color.WHITE);
		button.setFont(new Font("Tahoma", Font.BOLD, 15));
		button.setBackground(new Color(128, 0, 128));
		button.setBounds(1044, 442, 81, 33);
		contentPane.add(button);
		
		
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 0, 128));
		panel_4.setBounds(0, 623, 1226, 16);
		contentPane.add(panel_4);
		
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(10, 30, 1205, 599);
		
		JLabel lblNetSalary_1 = new JLabel("Net Salary: Rs.");
		lblNetSalary_1.setForeground(Color.RED);
		lblNetSalary_1.setFont(new Font("Tahoma", Font.BOLD, 23));
		lblNetSalary_1.setBounds(773, 557, 334, 40);
		contentPane.add(lblNetSalary_1);
	
		

		
		JLabel lblMaxLeavesPer = new JLabel("Max Leaves Per month");
		lblMaxLeavesPer.setForeground(new Color(128, 0, 128));
		lblMaxLeavesPer.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMaxLeavesPer.setBounds(489, 197, 136, 20);
		contentPane.add(lblMaxLeavesPer);
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 33, 1208, 596);
		
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\panel.jpg"));
		contentPane.add(lblNewLabel);
		
	
	
		
		
		setUndecorated(true);
		

		

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			
		
	}
	public static String date() {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat1);
		return format.format(c1.getTime());
	}
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
}