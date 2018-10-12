package com.microElectronics.interfacesEmp;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import itp.java.dbconnection.DBConnector;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;



public class EmployeeManagement extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeManagement frame = new EmployeeManagement();
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
	public EmployeeManagement() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 200);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 204, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 102));
		panel.setBounds(0, 0, 450, 29);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				  dispose();
			}
		});
		btnClose.setBounds(403, 0, 47, 29);
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
		btnMinimize.setBounds(355, 0, 47, 29);
		panel.add(btnMinimize);
		
		JLabel lblEmployeeManagement = new JLabel("Employee Management");
		lblEmployeeManagement.setForeground(new Color(102, 0, 102));
		lblEmployeeManagement.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblEmployeeManagement.setBounds(77, 55, 302, 29);
		contentPane.add(lblEmployeeManagement);
		
		JButton btnCustomer = new JButton("Employee");
		btnCustomer.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Employee emp = new Employee();
		        emp.setVisible(true);
		        dispose();
				  
			}
		});
		btnCustomer.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnCustomer.setForeground(new Color(102, 0, 102));
		btnCustomer.setBackground(new Color(204, 102, 204));
		btnCustomer.setBounds(77, 123, 126, 23);
		contentPane.add(btnCustomer);
		
		JButton btnWarranty = new JButton("Reports");
		btnWarranty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWarranty.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							DBConnector d = new DBConnector();
							Connection con = d.getCon();
							FileInputStream input = null;
							try {

					            String report = "C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\itp\\java\\report\\payment\\reportEmployee.jrxml";
					            JasperReport japs = JasperCompileManager.compileReport(report);
					            JasperPrint japsPin = JasperFillManager.fillReport(japs, null, con);
					            JasperViewer.viewReport(japsPin);

					        } catch (Exception e1) {

					            System.out.println(" " + e1);

					        }
						
					}
				});
			}
		});
		btnWarranty.setForeground(new Color(102, 0, 102));
		btnWarranty.setBackground(new Color(204, 102, 204));
		btnWarranty.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnWarranty.setBounds(253, 123, 126, 23);
		contentPane.add(btnWarranty);
		
		 setUndecorated(true) ;
		 setLocationRelativeTo(null);
	}

}
