package com.microElectronics.interfacesEmp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;



public class Employee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Employee frame = new Employee();
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
	public Employee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDesktopPane desktopPane = new JDesktopPane();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 102));
		panel.setBounds(0, 0, 1200, 29);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(1153, 1, 47, 31);
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setForeground(new Color(0, 0, 0));
		panel.add(btnClose);

		JButton btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinimize.setBackground(new Color(255, 0, 0));
		btnMinimize.setBounds(1105, 0, 47, 29);
		panel.add(btnMinimize);

		JLabel lbWarranty = new JLabel("Employee");
		lbWarranty.setHorizontalAlignment(SwingConstants.CENTER);
		lbWarranty.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbWarranty.setForeground(new Color(102, 0, 102));
		lbWarranty.setBounds(0, 40, 1174, 40);
		contentPane.add(lbWarranty);

		JButton btnAddMain = new JButton("Add Employee");
		btnAddMain.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				AddEmployee emp = new AddEmployee();
				emp.setLocation(0, -30); 
				desktopPane.add(emp).setVisible(true);
				
			}
		});
		btnAddMain.setBackground(new Color(204, 153, 255));
		btnAddMain.setForeground(new Color(102, 0, 102));
		btnAddMain.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAddMain.setBounds(47, 91, 201, 23);
		contentPane.add(btnAddMain);

		JButton btnUpdateWarranty = new JButton("Update Employee Details");
		btnUpdateWarranty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				UpdateEmployee emp = new UpdateEmployee();
				emp.setLocation(0, -30); 
				desktopPane.add(emp).setVisible(true);
			}
		});
		btnUpdateWarranty.setBackground(new Color(204, 153, 255));
		btnUpdateWarranty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateWarranty.setForeground(new Color(102, 0, 102));
		btnUpdateWarranty.setBounds(324, 91, 224, 23);
		contentPane.add(btnUpdateWarranty);

		JButton btnDelete = new JButton("Delete Employee Details");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				DeleteEmployee emp = new DeleteEmployee();
				emp.setLocation(0, -30); 
				desktopPane.add(emp).setVisible(true);
			}
		});
		btnDelete.setBackground(new Color(204, 153, 255));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDelete.setForeground(new Color(102, 0, 102));
		btnDelete.setBounds(921, 91, 219, 23);
		contentPane.add(btnDelete);

		JButton btnViewWarranty = new JButton("View Employee Details");
		btnViewWarranty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				ViewEmpDetails emp = new ViewEmpDetails();
				emp.setLocation(0, -30); 
				desktopPane.add(emp).setVisible(true);
			}
		});
		btnViewWarranty.setBackground(new Color(204, 153, 255));
		btnViewWarranty.setForeground(new Color(102, 0, 102));
		btnViewWarranty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewWarranty.setBounds(617, 91, 243, 23);
		contentPane.add(btnViewWarranty);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EmployeeManagement c = new EmployeeManagement();
				c.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(new Color(204, 153, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(1077, 566, 89, 23);
		contentPane.add(btnBack);

		
		desktopPane.setBackground(new Color(204, 153, 204));
		desktopPane.setBounds(25, 125, 1150, 430);
		contentPane.add(desktopPane);

		setUndecorated(true);
		setLocationRelativeTo(null);
	}

}
