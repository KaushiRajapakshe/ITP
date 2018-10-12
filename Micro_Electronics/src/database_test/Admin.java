
package database_test;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import itp.java.dbconnection.DBConnector;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Font;
import java.awt.TextArea;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.ActionEvent;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Admin extends JFrame {
	public static final String DateFormat = "dd/MM/yyyy";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldEID;
	private JTextField textFielddate;
	private JTextField textFieldcontact;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Admin frame = new Admin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	 Connection connection=null;
	 private JTextField name;
	 private JTextField category;

	/**
	 * Create the frame.
	 */
	public Admin() {
		connection=mysqlConnection.dbConnector();
		setLocationRelativeTo(null); 
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(128, 0, 128));
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, -9, 1227, 38);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblInquiry = new JLabel("Add Inquiry ");
		lblInquiry.setBounds(22, 11, 119, 18);
		lblInquiry.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblInquiry.setForeground(Color.WHITE);
		panel.add(lblInquiry);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\img\\Exit.jpg"));
		button.setBounds(1191, 10, 26, 25);
		panel.add(button);
		
		JButton button_1 = new JButton("");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setState(JFrame.ICONIFIED);
			}
		});
		button_1.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\img\\Min.jpg"));
		button_1.setBounds(1163, 10, 26, 25);
		panel.add(button_1);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setForeground(new Color(128, 0, 128));
		panel_1.setBounds(0, 22, 10, 618);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setForeground(new Color(128, 0, 128));
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(1217, 22, 10, 618);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 128));
		panel_3.setForeground(new Color(128, 0, 128));
		panel_3.setBounds(10, 630, 1252, 10);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 0, 128));
		panel_4.setForeground(new Color(128, 0, 128));
		panel_4.setBounds(10, 492, 1207, 10);
		contentPane.add(panel_4);
		
		JLabel lblCustomerId = new JLabel("EID :");
		lblCustomerId.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblCustomerId.setBounds(311, 127, 143, 14);
		contentPane.add(lblCustomerId);
		
		textFieldEID = new JTextField();
		textFieldEID.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textFieldEID.setBounds(477, 122, 584, 24);
		contentPane.add(textFieldEID);
		textFieldEID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				changeKeyReleased(arg0);
			}
		});
		textFieldEID.setColumns(10);
		
		JLabel lblDate = new JLabel("Date :");
		lblDate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblDate.setBounds(311, 218, 147, 14);
		contentPane.add(lblDate);
		
		textFielddate = new JTextField();
		textFielddate.setEditable(false);
		textFielddate.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textFielddate.setBounds(477, 211, 584, 24);
		contentPane.add(textFielddate);
		textFielddate.setText(now1());
		textFielddate.setColumns(10);
		
		JLabel lblAddress = new JLabel("Description :");
		lblAddress.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblAddress.setBounds(311, 367, 147, 14);
		contentPane.add(lblAddress);
		
		TextArea textAreadesc = new TextArea();
		textAreadesc.setFont(new Font("Dialog", Font.BOLD, 14));
		textAreadesc.setBounds(477, 367, 584, 94);
		contentPane.add(textAreadesc);
		
		JLabel lblContactNo = new JLabel("Contact No :");
		lblContactNo.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblContactNo.setBounds(311, 284, 147, 14);
		contentPane.add(lblContactNo);
		
		JLabel lblCategory = new JLabel("Category :");
		lblCategory.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblCategory.setBounds(311, 330, 89, 14);
		contentPane.add(lblCategory);
		
		JLabel lblName = new JLabel("Name :");
		lblName.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblName.setBounds(311, 168, 46, 14);
		contentPane.add(lblName);
		
		name = new JTextField();
		name.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		name.setBounds(477, 167, 584, 24);
		contentPane.add(name);
		name.setColumns(10);
		
		category = new JTextField();
		category.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		category.setBounds(477, 323, 584, 24);
		contentPane.add(category);
		category.setColumns(10);
		
		textFieldcontact = new JTextField();
		textFieldcontact.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		textFieldcontact.setBounds(477, 277, 584, 24);
		contentPane.add(textFieldcontact);
		textFieldcontact.setColumns(10);
		
		JButton btnAdd = new JButton("ADD");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String a = textFieldEID.getText();
				String b = textFieldcontact.getText();
				String c = name.getText();
				String d = category.getText();
				String e = textAreadesc.getText();
				int bb = 0;
				if(a.equals("") || b.equals("") || c.equals("") || d.equals("") || e.equals("")){
					JOptionPane.showMessageDialog(null, "TextFields are empty.");
				}else{
					try {
						bb=Integer.parseInt(textFieldcontact.getText());
					}catch(Exception e1){
						
						JOptionPane.showMessageDialog(null, "Please Enter a valid format!");
					}if(b.length() != 10){
						JOptionPane.showMessageDialog(null, "Please Enter a valid contact number!");
					}else{
						try {
							String query="insert into emptable (EID,name, category, contactNumber,date, description) values (?,?,?,?,?,?)";
							PreparedStatement pst=connection.prepareStatement(query);
							pst.setString(1, textFieldEID.getText());
							pst.setString(2, name.getText());
							pst.setString(3, category.getText());
							pst.setString(4, textFieldcontact.getText());
							pst.setString(5, textFielddate.getText());
							pst.setString(6, textAreadesc.getText());
							
							System.out.println(textFieldEID.getText() + "" + textFielddate.getText() + "" + textFieldcontact.getText() + "" + textAreadesc.getText());
		                    pst.execute();
							
		                    JOptionPane.showMessageDialog(null, "Record Added!");
							
							pst.close();
							
							
						} catch (Exception e1) {
							JOptionPane.showMessageDialog(null, "Invalid Type!" + e1);
						}
					}
				}
			}
		});
		btnAdd.setIcon(null);
		btnAdd.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnAdd.setForeground(Color.WHITE);
		btnAdd.setBackground(new Color(199, 21, 133));
		btnAdd.setBounds(846, 550, 115, 38);
		contentPane.add(btnAdd);
		
		JButton btnExit = new JButton("EXIT");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnExit.setBackground(new Color(148, 0, 211));
		btnExit.setForeground(Color.WHITE);
		btnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		btnExit.setBounds(1015, 550, 89, 38);
		contentPane.add(btnExit);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\img\\background.png"));
		lblNewLabel.setBounds(10, 26, 1207, 603);
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
			String naame = "";
			int no = 0;
            while(rs.next()){
            	naame = rs.getString("Name");
            	no = rs.getInt("TelNo");
            }
            String tel = String.valueOf(no);
            textFieldcontact.setText(tel);
            name.setText(naame);
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
