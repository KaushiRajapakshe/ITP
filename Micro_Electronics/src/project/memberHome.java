package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import database_test.Admin;

import javax.swing.JButton;

public class memberHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					memberHome frame = new memberHome();
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
	public memberHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 2, true));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1380, 39);
		contentPane.add(panel);
		panel.setBackground(new Color(128, 0, 128));
		
		JLabel lblX = new JLabel("X");
		lblX.setBounds(1349, 0, 21, 38);
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			System.exit(25);
			
			}
		});
		panel.setLayout(null);
		panel.add(lblX);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel label_1 = new JLabel("-");
		label_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 setState(ICONIFIED);
				
			}
		});
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		label_1.setBounds(1318, 0, 21, 38);
		panel.add(label_1);
		
		
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(-61, 752, 1468, 39);
		panel_1.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_1);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				addLeave add=new addLeave();
				add.setVisible(true);
				
				
				
			}
		});
		label.setBounds(329, 299, 244, 212);
		label.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\leave.png"));
		contentPane.add(label);
		
		JLabel label_2 = new JLabel("Leaves Management");
		label_2.setForeground(new Color(128, 0, 128));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(352, 521, 291, 38);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(25);
			}
		});
		label_3.setBounds(1277, 36, 93, 100);
		label_3.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\logout.png"));
		contentPane.add(label_3);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(759, 299, 228, 212);
		contentPane.add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Admin ad=new Admin();
				ad.setVisible(true);
			}
		});
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\stock.png"));
		
		JLabel lblNewLabel_1 = new JLabel("Add Inquiry");
		lblNewLabel_1.setForeground(new Color(128, 0, 128));
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1.setBounds(801, 526, 143, 29);
		contentPane.add(lblNewLabel_1);
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(0, 25, 1380, 792);
		label_4.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\back.jpg"));
		contentPane.add(label_4);
		
		
setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}
