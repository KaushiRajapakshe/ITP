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
import com.microElectronics.interfacesEmp.EmployeeManagement;

public class managerHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					managerHome frame = new managerHome();
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
	public managerHome() {
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
		
		JLabel label_2 = new JLabel("");
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				InvoiceMgt mgt=new InvoiceMgt();
				mgt.setVisible(true);
			}
		});
		label_2.setBounds(62, 459, 229, 212);
		label_2.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\bill.png"));
		contentPane.add(label_2);
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(580, 185, 235, 212);
		label_3.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\employee.png"));
		contentPane.add(label_3);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerManagement cs=new CustomerManagement();
				cs.setVisible(true);
				
			}
		});
		
		JLabel label_4 = new JLabel("");
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				salaryMgt sal=new salaryMgt();
				sal.setVisible(true);
				
				
			}
		});
		label_4.setBounds(1094, 185, 211, 212);
		label_4.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\salary.png"));
		contentPane.add(label_4);
		
		JLabel label_5 = new JLabel("Salary Management");
		label_5.setForeground(new Color(128, 0, 128));
		label_5.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_5.setBounds(1116, 386, 291, 38);
		contentPane.add(label_5);
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leaveMgt leave =new leaveMgt();
				leave.setVisible(true);
			}
		});
		
		
		
		
		label_6.setBounds(1074, 435, 244, 212);
		label_6.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\leave.png"));
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("Leaves Management");
		label_7.setForeground(new Color(128, 0, 128));
		label_7.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_7.setBounds(1116, 642, 291, 38);
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setBounds(570, 439, 235, 212);
		label_8.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\cus.png"));
		contentPane.add(label_8);
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EmployeeManagement em=new EmployeeManagement();
				em.setVisible(true);
			}
		});
		
		JLabel label_9 = new JLabel("Employee Management\r\n");
		label_9.setForeground(new Color(128, 0, 128));
		label_9.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_9.setBounds(580, 659, 291, 38);
		contentPane.add(label_9);
		
		JLabel label_12 = new JLabel("");
		label_12.setBounds(44, 193, 229, 212);
		label_12.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\stock.png"));
		contentPane.add(label_12);
		
		JLabel label_13 = new JLabel("Stock Management");
		label_13.setForeground(new Color(128, 0, 128));
		label_13.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_13.setBounds(81, 386, 291, 38);
		contentPane.add(label_13);
		
		JLabel label_14 = new JLabel("Invoice");
		label_14.setForeground(new Color(128, 0, 128));
		label_14.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_14.setBounds(127, 679, 291, 38);
		contentPane.add(label_14);
		
		JLabel label_15 = new JLabel("Customer Management");
		label_15.setForeground(new Color(128, 0, 128));
		label_15.setFont(new Font("Tahoma", Font.BOLD, 18));
		label_15.setBounds(587, 390, 291, 38);
		contentPane.add(label_15);
		
		JLabel label = new JLabel("");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(25);
			}
		});
		label.setBounds(1277, 33, 93, 100);
		label.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\logout.png"));
		contentPane.add(label);
		
		JLabel label_10 = new JLabel("");
		label_10.setBounds(0, 33, 1400, 736);
		label_10.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\back.jpg"));
		contentPane.add(label_10);
		
		
setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}

}
