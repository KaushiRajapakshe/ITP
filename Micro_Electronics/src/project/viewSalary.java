package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.border.LineBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;
import javax.swing.*;
import net.proteanit.sql.DbUtils;
import java.awt.Panel;



public class viewSalary extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JPasswordField passwordField;
	private JTextField textField_1;



	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewSalary frame = new viewSalary();
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
	public viewSalary() {		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1226, 642);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, 0, 1226, 35);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				dispose();
				
				
			}
		});
		label.setBounds(1200, 0, 16, 29);
		panel.add(label);
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				 setState(ICONIFIED);	

				
			}
		});
		label_1.setBounds(1169, 0, 10, 29);
		panel.add(label_1);
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(37, 46, 429, 150);
		contentPane.add(panel_1);
		
		JLabel label_2 = new JLabel("Confirm Identity");
		label_2.setForeground(Color.WHITE);
		label_2.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		label_2.setBounds(28, 0, 189, 30);
		panel_1.add(label_2);
		
		JLabel label_3 = new JLabel("Username");
		label_3.setForeground(Color.WHITE);
		label_3.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		label_3.setBounds(60, 35, 189, 30);
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("Password");
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		label_4.setBounds(60, 70, 189, 30);
		panel_1.add(label_4);
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(149, 41, 179, 20);
		panel_1.add(textField);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(149, 76, 179, 20);
		panel_1.add(passwordField);
		
		JButton btnView = new JButton("View");
		btnView.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				
				
				
				try{
					String driver = "com.mysql.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/micro_electronics?autoReconnect=true&useSSL=false";
					String username = "root";
					String password = "";
					
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url,username,password);
					Statement stmt = conn.createStatement();
					PreparedStatement pst = conn.prepareStatement("Select id,password from log where id=? and password=?");

					String id = textField.getText();
					String pwd = passwordField.getText();
					
					pst.setString(1, id);
					pst.setString(2,pwd);
					
					ResultSet res = pst.executeQuery();
					
					
					
					
					if(res.next()) {          
						try {
							 Class.forName("com.mysql.jdbc.Driver");
				   			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
				   			 String query="select * from salary";
				   			 PreparedStatement pst1=con.prepareStatement(query);
				   			 ResultSet rs=pst1.executeQuery();
				   			table.setModel(DbUtils.resultSetToTableModel(rs));
				   			 
				   			 
						}catch(Exception ex) {
							ex.printStackTrace();
						}
						
					}
					else{
						JOptionPane.showMessageDialog(null,"Unauthorized Access");
					}
						
					


					}catch(Exception e){
						e.printStackTrace();
					}


				
				
				
				
				
				
				
				
				
				
				
				
			
				
				
			
			
				
				
				
				
			}
		});
		btnView.setForeground(Color.RED);
		btnView.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnView.setBackground(Color.WHITE);
		btnView.setBounds(295, 107, 123, 23);
		panel_1.add(btnView);
		
		JButton button_1 = new JButton("Cancel");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setForeground(new Color(128, 0, 128));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(38, 107, 123, 23);
		panel_1.add(button_1);
		
		JLabel label_5 = new JLabel("!");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		label_5.setBounds(10, 0, 64, 30);
		panel_1.add(label_5);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(37, 222, 1152, 253);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(896, 60, 293, 115);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblId = new JLabel("ID");
		lblId.setBounds(29, 40, 15, 17);
		lblId.setForeground(new Color(128, 0, 128));
		lblId.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		panel_2.add(lblId);
		
		JLabel lblDeleteSalary = new JLabel("Delete Salary");
		lblDeleteSalary.setBounds(112, 5, 88, 17);
		panel_2.add(lblDeleteSalary);
		lblDeleteSalary.setForeground(new Color(128, 0, 128));
		lblDeleteSalary.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		
		textField_1 = new JTextField();
		textField_1.setBounds(78, 39, 169, 20);
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnDeleteSalary = new JButton("Delete Salary");
		btnDeleteSalary.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				
				
				try{
					String id=textField_1.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
					Statement stmt = conn.createStatement();
					String sql = "delete from salary where ID = "+id;
					PreparedStatement ps = conn.prepareStatement(sql);
					
					int execute = ps.executeUpdate();
					
		conn.close();
					
					}catch(Exception ex){
						ex.printStackTrace();
					}
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
		   			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
		   			 String query="select * from salary";
		   			 PreparedStatement pst=con.prepareStatement(query);
		   			 ResultSet rs=pst.executeQuery();
		   			table.setModel(DbUtils.resultSetToTableModel(rs));
		   			 
		   			 
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
			}
		});
		btnDeleteSalary.setBackground(new Color(128, 0, 128));
		btnDeleteSalary.setForeground(new Color(255, 255, 255));
		btnDeleteSalary.setBounds(96, 81, 115, 23);
		panel_2.add(btnDeleteSalary);
		
		
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 0, 1206, 631);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\panel.jpg"));
		contentPane.add(lblNewLabel);
		
		
		
		
		setUndecorated(true);
		

		

		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
			
		
		
	}
	
	
	
	
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

