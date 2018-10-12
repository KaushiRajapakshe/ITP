package com.microElectronics.interfacesCus;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import com.microElectronics.interfacesEmp.AddEmployee;
import com.microElectronics.interfacesEmp.DeleteEmployee;
import com.microElectronics.interfacesEmp.EmployeeManagement;
import com.microElectronics.interfacesEmp.UpdateEmployee;
import com.microElectronics.interfacesEmp.ViewEmpDetails;

import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Customer extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Customer frame = new Customer();
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
	public Customer() {
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

		JLabel lbCustomer = new JLabel("Customer");
		lbCustomer.setHorizontalAlignment(SwingConstants.CENTER);
		lbCustomer.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbCustomer.setForeground(new Color(102, 0, 102));
		lbCustomer.setBounds(0, 40, 1174, 40);
		contentPane.add(lbCustomer);

		JButton btnAdd = new JButton("Add Customer");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				AddCustomer cus = new AddCustomer();
				cus.setLocation(0, -30); 
				desktopPane.add(cus).setVisible(true);
				
			}
		});
		btnAdd.setBackground(new Color(204, 153, 255));
		btnAdd.setForeground(new Color(102, 0, 102));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(47, 91, 201, 23);
		contentPane.add(btnAdd);

		JButton btnUpdateCustomer = new JButton("Update Customer Details");
		btnUpdateCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				UpdateCustomer cus = new UpdateCustomer();
				cus.setLocation(0, -30);
				desktopPane.add(cus).setVisible(true);
			}
		});
		btnUpdateCustomer.setBackground(new Color(204, 153, 255));
		btnUpdateCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateCustomer.setForeground(new Color(102, 0, 102));
		btnUpdateCustomer.setBounds(324, 91, 224, 23);
		contentPane.add(btnUpdateCustomer);

		JButton btnDeleteCustomer = new JButton("Delete Customer Details");
		btnDeleteCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				DeleteCustomer cus = new DeleteCustomer();
				cus.setLocation(0, -30); 
				//setLocationRelativeTo(null);
				desktopPane.add(cus).setVisible(true);
			}
		});
		btnDeleteCustomer.setBackground(new Color(204, 153, 255));
		btnDeleteCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnDeleteCustomer.setForeground(new Color(102, 0, 102));
		btnDeleteCustomer.setBounds(921, 91, 219, 23);
		contentPane.add(btnDeleteCustomer);

		JButton btnViewCustomer = new JButton("View Customer Details");
		btnViewCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				ViewCustomer cus = new ViewCustomer();
				cus.setLocation(0, -30); 
				desktopPane.add(cus).setVisible(true);
			}
		});
		btnViewCustomer.setBackground(new Color(204, 153, 255));
		btnViewCustomer.setForeground(new Color(102, 0, 102));
		btnViewCustomer.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnViewCustomer.setBounds(617, 91, 243, 23);
		contentPane.add(btnViewCustomer);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerManagement c = new CustomerManagement();
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
