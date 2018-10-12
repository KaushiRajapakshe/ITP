package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import java.awt.Panel;

public class viewLeave extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					viewLeave frame = new viewLeave();
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
	public viewLeave() {
		
	
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 642);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1227, 41);
		panel.setBackground(new Color(128, 0, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel label = new JLabel("X");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				dispose();

				
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		label.getBackground();
		label.setBounds(1201, 11, 16, 29);
		panel.add(label);
		
		JLabel label_1 = new JLabel("-");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBounds(1170, 11, 10, 29);
		panel.add(label_1);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(10, 42, 1207, 589);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(39, 315, 1143, 255);
		scrollPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
			
			
			
				
				
			}
		});
		contentPane.add(scrollPane);
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				
				DefaultTableModel model=(DefaultTableModel)table.getModel();
				int selectedRow=table.getSelectedRow();
				textField.setText(model.getValueAt(selectedRow, 0).toString());
				textField_1.setText(model.getValueAt(selectedRow, 5).toString());
				textField_2.setText(model.getValueAt(selectedRow, 7).toString());
				textField_3.setText(model.getValueAt(selectedRow, 0).toString());

				
			}
		});
		scrollPane.setViewportView(table);
		
		JButton btnNewButton = new JButton("View Leaves");
		btnNewButton.setBounds(1019, 266, 163, 33);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
		   			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
		   			 String query="select * from leaves";
		   			 PreparedStatement pst1=con.prepareStatement(query);
		   			 ResultSet rs=pst1.executeQuery();
		   			table.setModel(DbUtils.resultSetToTableModel(rs));
		   			 
		   			 
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
			}
		});
		contentPane.add(btnNewButton);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(39, 66, 431, 215);
		panel_1.setLayout(null);
		panel_1.setBorder(new EmptyBorder(5, 5, 5, 5));
		panel_1.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_1);
		
		JLabel lblConfirmArrival = new JLabel("Confirm Arrival");
		lblConfirmArrival.setForeground(Color.WHITE);
		lblConfirmArrival.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		lblConfirmArrival.setBounds(28, 0, 189, 30);
		panel_1.add(lblConfirmArrival);
		
		JLabel lblEmpId = new JLabel("Emp ID:");
		lblEmpId.setForeground(Color.WHITE);
		lblEmpId.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		lblEmpId.setBounds(60, 35, 189, 30);
		panel_1.add(lblEmpId);
		
		JLabel lblReturnDate = new JLabel("Return Date");
		lblReturnDate.setForeground(Color.WHITE);
		lblReturnDate.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		lblReturnDate.setBounds(60, 70, 189, 30);
		panel_1.add(lblReturnDate);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Yes");
		comboBox.addItem("No");
		
		
		comboBox.setBounds(159, 113, 169, 20);
		panel_1.add(comboBox);
		
		Panel panel_2 = new Panel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(901, 106, 293, 115);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel label_2 = new JLabel("ID");
		label_2.setBounds(29, 40, 15, 17);
		label_2.setForeground(new Color(128, 0, 128));
		label_2.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		panel_2.add(label_2);
		
		JLabel lblDeleteLeave = new JLabel("Delete Leave");
		lblDeleteLeave.setBounds(112, 5, 88, 17);
		lblDeleteLeave.setForeground(new Color(128, 0, 128));
		lblDeleteLeave.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		panel_2.add(lblDeleteLeave);
		
		textField_3 = new JTextField();
		textField_3.setBounds(78, 39, 169, 20);
		textField_3.setColumns(10);
		panel_2.add(textField_3);
		
		JButton button = new JButton("Delete Salary");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				

		
				
				try{
					String ID=textField_3.getText();
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
					Statement stmt = conn.createStatement();
					String sql = "delete from leaves where ID = "+ID;
					PreparedStatement ps = conn.prepareStatement(sql);
					
					int execute = ps.executeUpdate();
					
		conn.close();
					
					}catch(Exception ex){
						ex.printStackTrace();
					}
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
		   			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
		   			 String query="select * from leaves";
		   			 PreparedStatement pst=con.prepareStatement(query);
		   			 ResultSet rs=pst.executeQuery();
		   			table.setModel(DbUtils.resultSetToTableModel(rs));
		   			 
		   			 
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
			}
		});
		button.setBounds(96, 81, 115, 23);
		button.setForeground(Color.WHITE);
		button.setBackground(new Color(128, 0, 128));
		panel_2.add(button);
		
		textField_2 = new JTextField();
		textField_2.setBounds(598, 107, 179, 20);
		textField_2.setColumns(10);
		contentPane.add(textField_2);
		
		JLabel lblToday = new JLabel("Today");
		lblToday.setBounds(509, 101, 189, 30);
		lblToday.setForeground(new Color(128, 0, 128));
		lblToday.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		contentPane.add(lblToday);
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\panel.jpg"));
		contentPane.add(lblNewLabel);
		
		
		
		
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(149, 41, 179, 20);
		panel_1.add(textField);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				


				try {
					String tDate=textField_2.getText();
					String retDate=textField_1.getText();
					String arrival=(String) comboBox.getSelectedItem();
					String driver = "com.mysql.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/micro_electronics";
					String username = "root";
					String password = "";
					
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url,username,password);
					Statement stmt = conn.createStatement();
						
					
				    String sql = "update leaves set retDate='"+retDate+"',arrival='"+arrival+"' where tdate='"+tDate+"' ";		
				    stmt=conn.prepareStatement(sql);
				    stmt.execute(sql);
conn.close();
				    JOptionPane.showMessageDialog(null, "User Leave Updated...");

				}catch(Exception e){
				    JOptionPane.showMessageDialog(null, "Cannot update this momnt");
				}


				
				
				try {
					 Class.forName("com.mysql.jdbc.Driver");
		   			 Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/micro_electronics","root","");
		   			 String query="select * from leaves";
		   			 PreparedStatement pst1=con.prepareStatement(query);
		   			 ResultSet rs=pst1.executeQuery();
		   			table.setModel(DbUtils.resultSetToTableModel(rs));
		   			 
		   			 
				}catch(Exception ex) {
					ex.printStackTrace();
				}
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
}


				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
		
		});
		btnUpdate.setForeground(Color.RED);
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBackground(Color.WHITE);
		btnUpdate.setBounds(298, 170, 123, 23);
		panel_1.add(btnUpdate);
		
		JButton button_1 = new JButton("Cancel");
		button_1.setForeground(new Color(128, 0, 128));
		button_1.setFont(new Font("Tahoma", Font.BOLD, 11));
		button_1.setBackground(Color.WHITE);
		button_1.setBounds(39, 170, 123, 23);
		panel_1.add(button_1);
		
		JLabel label_5 = new JLabel("!");
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		label_5.setBounds(10, 0, 64, 30);
		panel_1.add(label_5);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(149, 76, 179, 20);
		panel_1.add(textField_1);
		
		JLabel lblReturnStatus = new JLabel("Return Status");
		lblReturnStatus.setForeground(Color.WHITE);
		lblReturnStatus.setFont(new Font("FrankGoth BT", Font.PLAIN, 13));
		lblReturnStatus.setBounds(60, 107, 189, 30);
		panel_1.add(lblReturnStatus);
		
	
	setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
