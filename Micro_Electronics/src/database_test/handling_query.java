package database_test;


import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.TitledBorder;

import itp.java.bill.BillTable;
import itp.java.bill.calAmount;
import itp.java.dbconnection.DBConnector;
import itp.java.item.GenarateAvailableItems;
import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class handling_query extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField EID;
	private JTextField textFieldName;
	private JTextField textFieldcategory;
	    JTable tblList;
		private JTable table;
		

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					handling_query frame = new handling_query();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
    Connection connection=null;
    private JTextField textFieldEID;
    private JTextField textFieldcontactNumber;
	/**
	 * Create the frame.
	 */
	public handling_query() {
		connection=mysqlConnection.dbConnector();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1227, 28);
		panel.setBackground(new Color(128, 0, 128));
		panel.setForeground(new Color(128, 0, 128));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Inquiry Handling");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel.setBounds(24, 0, 118, 25);
		panel.add(lblNewLabel);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.exit(0);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\img\\Exit.jpg"));
		button_1.setBounds(1191, 2, 26, 25);
		panel.add(button_1);
		
		JButton button_2 = new JButton("");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setState(JFrame.ICONIFIED);
				
			}
			
		});
		button_2.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\img\\Min.jpg"));
		button_2.setBounds(1162, 2, 26, 25);
		panel.add(button_2);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 28, 10, 612);
		panel_1.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 630, 1217, 10);
		panel_2.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1217, 28, 10, 612);
		panel_3.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(47, 65, 396, 111);
		panel_4.setBackground(new Color(186, 85, 211));
		panel_4.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "SEARCH", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_4);
		panel_4.setLayout(null);
		
		EID = new JTextField();
		EID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		EID.setColumns(10);
		EID.setBounds(25, 29, 346, 26);
		panel_4.add(EID);
		
		JButton button = new JButton("Search");
		button.setBackground(new Color(148, 0, 211));
		button.setForeground(new Color(240, 248, 255));
		button.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			      JButtonSearch(arg0);
			}
		});
		button.setBounds(268, 66, 103, 34);
		panel_4.add(button);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(529, 65, 648, 181);
		panel_5.setBackground(new Color(186, 85, 211));
		panel_5.setBorder(new TitledBorder(null, "INFORMATION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel label = new JLabel("Name :");
		label.setForeground(new Color(255, 255, 255));
		label.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		label.setBounds(24, 72, 86, 23);
		panel_5.add(label);
		
		JLabel lblGender = new JLabel("Contact No :");
		lblGender.setForeground(new Color(255, 255, 255));
		lblGender.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblGender.setBounds(24, 106, 86, 23);
		panel_5.add(lblGender);
		
		JLabel lblAddress = new JLabel("State :");
		lblAddress.setForeground(new Color(255, 255, 255));
		lblAddress.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddress.setBounds(24, 140, 86, 23);
		panel_5.add(lblAddress);
		
		textFieldName = new JTextField();
		textFieldName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textFieldName.setColumns(10);
		textFieldName.setBounds(105, 73, 417, 23);
		panel_5.add(textFieldName);
		
		textFieldcategory = new JTextField();
		textFieldcategory.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textFieldcategory.setColumns(10);
		textFieldcategory.setBounds(105, 140, 417, 23);
		panel_5.add(textFieldcategory);
		
		textFieldEID = new JTextField();
		textFieldEID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				changeKeyReleased(arg0);
			}
		});
		textFieldEID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textFieldEID.setColumns(10);
		textFieldEID.setBounds(105, 38, 417, 23);
		panel_5.add(textFieldEID);
		
		JLabel lblEid = new JLabel("EID :");
		lblEid.setForeground(Color.WHITE);
		lblEid.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblEid.setBounds(24, 38, 86, 23);
		panel_5.add(lblEid);
		
		textFieldcontactNumber = new JTextField();
		textFieldcontactNumber.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textFieldcontactNumber.setColumns(10);
		textFieldcontactNumber.setBounds(105, 106, 417, 23);
		panel_5.add(textFieldcontactNumber);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setBounds(812, 257, 103, 34);
		btnUpdate.setBackground(new Color(148, 0, 211));
		btnUpdate.setForeground(Color.WHITE);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = textFieldEID.getText();
				String b = textFieldName.getText();
				String c = textFieldcontactNumber.getText();
				String d = textFieldcategory.getText();
				if((a.equals("")) || (b.equals("")) || (c.equals("")) || (d.equals(""))){
					JOptionPane.showMessageDialog(null, "TextFilds are empty!");
				}else{
				try {
					String query="Update emptable set EID='"+textFieldEID.getText()+"',Name='"+textFieldName.getText()+"',contactNumber='"+textFieldcontactNumber.getText()+"',category='"+textFieldcategory.getText()+"' where EID='"+textFieldEID.getText()+"'  ";
					PreparedStatement pst=connection.prepareStatement(query);
			
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Updated!");
					
					pst.close();
					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				}
				
			}
		});
		btnUpdate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(943, 257, 103, 34);
		btnDelete.setBackground(new Color(148, 0, 211));
		btnDelete.setForeground(Color.WHITE);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String a = textFieldEID.getText();
				if((a.equals(""))){
					JOptionPane.showMessageDialog(null, "TextFilds are empty!");
				}else{
				try {
					String query="delete from emptable where EID='"+textFieldEID.getText()+"' ";
					PreparedStatement pst=connection.prepareStatement(query);
			
					pst.execute();
					
					JOptionPane.showMessageDialog(null, "Data Deleted!");
					
					pst.close();
					
					
				} catch (Exception ex) {
					ex.printStackTrace();
				}
				}
				
			}
		});
		btnDelete.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(btnDelete);
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(1074, 257, 103, 34);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBackground(new Color(148, 0, 211));
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(btnExit);
		
		JButton btnLoadEmpData = new JButton("Load Emp Data");
		btnLoadEmpData.setBounds(106, 257, 228, 34);
		btnLoadEmpData.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				try {
					String query="select * from emptable";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		btnLoadEmpData.setForeground(Color.WHITE);
		btnLoadEmpData.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnLoadEmpData.setBackground(new Color(148, 0, 211));
		contentPane.add(btnLoadEmpData);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(79, 314, 1098, 286);
		panel_6.setBackground(new Color(192, 192, 192));
		contentPane.add(panel_6);
		panel_6.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(169, 11, 763, 264);
		panel_6.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JLabel label_1 = new JLabel("");
		label_1.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Javaee\\database_test\\src\\img\\background.png"));
		label_1.setBounds(10, 28, 1207, 601);
		contentPane.add(label_1);
		
		setUndecorated(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		
	    
	  } 
	public void JButtonSearch(java.awt.event.ActionEvent e) {
		String value = EID.getText();
		System.out.println(value);
			if(value.equals("")){
				JOptionPane.showMessageDialog(null, "TextFilds is empty.");
			}
			else{
			try {
				String query="select * from emptable where (EID = '"+EID.getText()+"')";
				PreparedStatement pst=connection.prepareStatement(query);
				ResultSet rs=pst.executeQuery();
				table.setModel(DbUtils.resultSetToTableModel(rs));
				
				rs.close();
			} catch (SQLException e1) {
					e1.printStackTrace();
			}
			}
		}
	
	public void changeKeyReleased(java.awt.event.KeyEvent arg0) {
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
        	String eid = textFieldEID.getText();
        	int id = Integer.parseInt(eid);
        	System.out.println(eid + " " + id);
			Statement stm = con.createStatement();
			String query = "select * from employee where (EID = '"+id+"')";
			ResultSet rs = stm.executeQuery(query);
			String name = "";
			int no = 0;
            while(rs.next()){
            	name = rs.getString("Name");
            	no = rs.getInt("TelNo");
            }
            String tel = String.valueOf(no);
            textFieldcontactNumber.setText(tel);
            textFieldName.setText(name);
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	}

