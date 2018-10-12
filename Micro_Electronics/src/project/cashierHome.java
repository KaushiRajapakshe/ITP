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

import com.microElectronics.interfacesCus.CustomerManagement;

import itp.java.bill.AddBill;

public class cashierHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					cashierHome frame = new cashierHome();
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
	public cashierHome() {
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
		label.setBounds(164, 320, 229, 212);
		label.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\bill.png"));
		contentPane.add(label);
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AddBill bill=new AddBill();
				bill.setVisible(true);
				
			}
		});
		
		JLabel label_2 = new JLabel("Invoice");
		label_2.setForeground(new Color(128, 0, 128));
		label_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_2.setBounds(235, 543, 291, 38);
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(584, 320, 235, 212);
		label_3.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\employee.png"));
		contentPane.add(label_3);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerManagement cs=new CustomerManagement();
				cs.setVisible(true);
				
			}
		});
		
		JLabel label_4 = new JLabel("Customer Management");
		label_4.setForeground(new Color(128, 0, 128));
		label_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_4.setBounds(611, 543, 291, 38);
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("");
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				addLeave add=new addLeave();
				add.setVisible(true);
				
			}
		});
		label_5.setBounds(998, 320, 244, 212);
		label_5.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\leave.png"));
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("Leaves Management");
		label_6.setForeground(new Color(128, 0, 128));
		label_6.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_6.setBounds(1037, 543, 291, 38);
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(25);
			}
		});
		label_7.setBounds(1266, 35, 93, 100);
		label_7.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\logout.png"));
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(0, 11, 1397, 818);
		label_8.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\back.jpg"));
contentPane.add(label_8);
		
		
setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}
