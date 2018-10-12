package itp.java.bill;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.LineBorder;

import itp.java.dbconnection.DBConnector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ConfirmAdmin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField userName;
	private JPasswordField password;
	
	private String billNumber;
	private String row;
	private String productId;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConfirmAdmin frame = new ConfirmAdmin();
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
	public ConfirmAdmin() {
		initComponent();
	}
	
	public ConfirmAdmin(String billNumber, String row, String productID) {
		this.billNumber = billNumber;
		this.row = row;
		this.productId = productID;
		initComponent();
	}
	public void initComponent() {
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 7));
		
		final JPanel topPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		topPanel.setBounds(0, 0, 450, 38);
		topPanel.setBackground(new Color(128, 0, 128));
		
		getContentPane().add(topPanel);
		
		JLabel lblUserName = new JLabel("User Name");
		lblUserName.setForeground(new Color(128, 0, 128));
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName.setBounds(73, 115, 77, 23);
		contentPane.add(lblUserName);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(128, 0, 128));
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(73, 149, 77, 26);
		contentPane.add(lblPassword);
		
		userName = new JTextField();
		userName.setBounds(211, 117, 141, 20);
		contentPane.add(userName);
		userName.setColumns(10);
		
		password = new JPasswordField();
		password.setBounds(211, 153, 141, 20);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblAdmin = new JLabel("Admin");
		lblAdmin.setForeground(new Color(128, 0, 128));
		lblAdmin.setFont(new Font("Times New Roman", Font.BOLD, 19));
		lblAdmin.setBounds(184, 67, 65, 26);
		contentPane.add(lblAdmin);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_BackActionPerformed(e);
			}
		});
		btnBack.setBackground(new Color(255, 0, 102));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBack.setBounds(61, 237, 89, 33);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_ResetActionPerformed(e);
			}
		});
		btnReset.setBackground(new Color(204, 0, 153));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnReset.setBounds(184, 237, 89, 33);
		contentPane.add(btnReset);
		
		JButton btnConfirm = new JButton("Confirm");
		btnConfirm.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_ConfirmActionPerformed(e);
			}
		});
		btnConfirm.setBackground(new Color(128, 0, 128));
		btnConfirm.setForeground(new Color(255, 255, 255));
		btnConfirm.setFont(new Font("Times New Roman", Font.BOLD, 16));
		btnConfirm.setBounds(310, 237, 89, 33);
		contentPane.add(btnConfirm);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\image\\k1.png"));
		background.setBounds(7, 37, 436, 256);
		contentPane.add(background);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
	}
	
	public void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {
		userName.setText("");
		password.setText("");
	}
	
	public void jButton_ConfirmActionPerformed(java.awt.event.ActionEvent e){
		String u = userName.getText();
		String p = password.getText();
		if ((u.equals("")) || (p.equals(""))){
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		}else if((u.equals("Kaushi")) || (p.equals("KN2016"))) {
			DBConnector db = new DBConnector();
	        Connection con = db.getCon();
	        try {
				Statement stm = con.createStatement();
				String query1 = "SELECT qty FROM customerbill WHERE ((billNumber = '"+billNumber+"') && (noOfItem = '"+row+"'))";
				ResultSet rs = stm.executeQuery(query1);
				int quantity = 0;
				while(rs.next()) {
					quantity = rs.getInt("qty");
				}
				rs.close();
				String query2 = "SELECT stockLevel FROM stock WHERE (productId = '"+productId+"')";
				ResultSet rs1 = stm.executeQuery(query2);
				int stock = 0;
				while(rs1.next()) {
					stock = rs1.getInt("stockLevel");
				}
				rs1.close();
				int availableStock = quantity + stock;
				String query3 = "Update stock set stockLevel = '"+availableStock+"' where (productID = '"+productId+"')";
				stm.executeUpdate(query3);
				
				String query = "DELETE FROM customerbill WHERE ((billNumber = '"+billNumber+"') && (noOfItem = '"+row+"'))";
				stm.executeUpdate(query);
				JOptionPane.showMessageDialog(null,"Removed item in customer bill table successfully.");
				AddBill ad1 = new AddBill();
				ad1.setVisible(true);
				this.setVisible(false);
	        }catch(SQLException e1) {
				e1.printStackTrace();
	        }
		}else {
			JOptionPane.showMessageDialog(null,"Invalied username or password.");
		}
	}
	
	public void jButton_BackActionPerformed(java.awt.event.ActionEvent e){
		AddBill a1 = new AddBill();
		a1.setVisible(true);
		this.setVisible(false);
	}
}
