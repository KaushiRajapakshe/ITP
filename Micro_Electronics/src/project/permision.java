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
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class permision extends JFrame {

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
					permision frame = new permision();
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
	public permision() {
		setAlwaysOnTop(true);
		setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
		setBounds(100, 100, 448, 181);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblOwnersPermis = new JLabel("Confirm Identity");
		lblOwnersPermis.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblOwnersPermis.setForeground(new Color(255, 255, 255));
		lblOwnersPermis.setBounds(40, 17, 189, 30);
		contentPane.add(lblOwnersPermis);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setForeground(Color.WHITE);
		lblUsername.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblUsername.setBounds(72, 65, 189, 30);
		contentPane.add(lblUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(Color.WHITE);
		lblPassword.setFont(new Font("Lucida Fax", Font.PLAIN, 16));
		lblPassword.setBounds(72, 102, 189, 30);
		contentPane.add(lblPassword);
		
		textField = new JTextField();
		textField.setBounds(175, 72, 179, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(175, 106, 179, 20);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("Confirm Leave");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			
			
				
				
			
			}
			
			
			
		});
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnNewButton.setBackground(new Color(255, 255, 255));
		btnNewButton.setBounds(301, 147, 123, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCancelLeave = new JButton("Cancel");
		btnCancelLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnCancelLeave.setForeground(new Color(128, 0, 128));
		btnCancelLeave.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancelLeave.setBackground(Color.WHITE);
		btnCancelLeave.setBounds(22, 147, 123, 23);
		contentPane.add(btnCancelLeave);
		
		JLabel label = new JLabel("!");
		label.setForeground(new Color(255, 0, 0));
		label.setFont(new Font("Tahoma", Font.BOLD, 27));
		label.setBounds(22, 17, 64, 30);
		contentPane.add(label);
		
	setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
