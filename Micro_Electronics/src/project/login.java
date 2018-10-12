package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;

import javax.swing.UIManager;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import java.awt.TextArea;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import net.proteanit.sql.DbUtils;
import javax.swing.JPasswordField;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 364, 232);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 3));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(new Color(128, 0, 128));
		lblUsername.setFont(new Font("Calligraph421 BT", Font.PLAIN, 19));
		lblUsername.setBounds(32, 59, 141, 42);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(128, 0, 128));
		lblPassword.setFont(new Font("Calligraph421 BT", Font.PLAIN, 19));
		lblPassword.setBounds(32, 89, 141, 42);
		contentPane.add(lblPassword);
		
		JLabel lblCatogory = new JLabel("Catogory");
		lblCatogory.setForeground(new Color(128, 0, 128));
		lblCatogory.setFont(new Font("Calligraph421 BT", Font.PLAIN, 19));
		lblCatogory.setBounds(32, 123, 141, 42);
		contentPane.add(lblCatogory);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, 0, 365, 42);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblLogin = new JLabel("Login");
		lblLogin.setBounds(31, 0, 88, 43);
		panel.add(lblLogin);
		lblLogin.setFont(new Font("Berlin Sans FB Demi", Font.PLAIN, 25));
		lblLogin.setForeground(new Color(255, 255, 255));
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				System.exit(20);
			}

			
		});
		lblX.setBounds(342, 15, 46, 14);
		panel.add(lblX);
		lblX.setForeground(new Color(255, 255, 255));
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 20));
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				login frame=new login();
				 setState(ICONIFIED);			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 20));
		label.setBounds(309, 15, 46, 14);
		panel.add(label);
		
		textField = new JTextField();
		textField.setBounds(136, 74, 174, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItem("Owner");
		comboBox.addItem("Manager");
		comboBox.addItem("Cashier");
		comboBox.addItem("Crew Member");
		comboBox.addItem("Admin");

		
		
		
		
		
		
		
		
		
		comboBox.setToolTipText("x\r\nx");
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(136, 142, 174, 20);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				try{
					String driver = "com.mysql.jdbc.Driver";
					String url = "jdbc:mysql://localhost:3306/micro_electronics";
					String username = "root";
					String password = "";
					
					Class.forName(driver);
					Connection conn = DriverManager.getConnection(url,username,password);
					Statement stmt = conn.createStatement();
					PreparedStatement pst = conn.prepareStatement("Select id,password,catogory from log where id=? and password=? and catogory=?");

					String id = textField.getText();
					String pwd = passwordField.getText();
					String catogory=(String) comboBox.getSelectedItem();
					
					pst.setString(1, id);
					pst.setString(2,pwd);
					pst.setString(3,catogory);					
					System.out.println("My -"+ catogory +"++");
					ResultSet rs = pst.executeQuery();
					
					
					
					
					if((catogory.equals("Owner")) && rs.next()) {          
						AdminHome admin=new AdminHome();
						admin.setVisible(true);
						dispose();
					}
					else if((catogory.equals("Manager")) && rs.next()) {          
						managerHome manager=new managerHome();
						manager.setVisible(true);
						dispose();
					}
					else if(catogory.equals("Cashier")&&rs.next()) {          
						cashierHome admin=new cashierHome();
						admin.setVisible(true);
						dispose();
					}
					else if(catogory.equals("Crew Member") && rs.next()) {          
						memberHome member=new memberHome();
						member.setVisible(true);
						dispose();
					}
					else{
					JOptionPane.showMessageDialog(null,"Login Failed");
					
					}


					}catch(Exception e){
						e.printStackTrace();
					}


				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
				
			
				
			}
		});
		btnNewButton.setHideActionText(true);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setHorizontalAlignment(SwingConstants.LEADING);
		btnNewButton.setIcon(null);
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setBounds(244, 184, 81, 29);
		contentPane.add(btnNewButton);
		
		JLabel label_1 = new JLabel("");
		label_1.setBounds(0, 38, 365, 194);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(136, 104, 174, 20);
		contentPane.add(passwordField);
		label_1.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\log.jpg"));
		contentPane.add(label_1);
		
		setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}
