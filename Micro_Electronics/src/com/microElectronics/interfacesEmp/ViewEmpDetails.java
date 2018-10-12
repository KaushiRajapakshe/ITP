package com.microElectronics.interfacesEmp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

import com.microElectronics.controller.EmployeeM;
import com.microElectronics.controller.Validation;
import com.microElectronics.dataBase.dbConnection;

import net.proteanit.sql.DbUtils;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.SwingConstants;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ViewEmpDetails extends JInternalFrame {
	private JTable table;
	private JTextField textFieldSearch;
	private JComboBox comboBoxType;

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	private JTable tableEmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmpDetails frame = new ViewEmpDetails();
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
	public ViewEmpDetails() {
		con = dbConnection.connection();
		tableLoad();
		setBackground(new Color(153, 0, 153));
		getContentPane().setBackground(new Color(204, 153, 255));
		setBounds(100, 100, 1150, 460);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1158, 6);
		panel_1.setBackground(new Color(102, 153, 204));
		getContentPane().add(panel_1);

		JLabel lblDeleteEmp = new JLabel(" Employee Details");
		lblDeleteEmp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeleteEmp.setForeground(new Color(102, 0, 102));
		lblDeleteEmp.setBounds(375, 17, 312, 31);
		getContentPane().add(lblDeleteEmp);

		JComboBox comboBoxType = new JComboBox();
		comboBoxType.setBackground(new Color(255, 204, 255));
		comboBoxType.setForeground(new Color(102, 0, 102));
		comboBoxType.setBounds(1009, 53, 98, 20);
		comboBoxType.addItem("Name");
		comboBoxType.addItem("NIC");
		comboBoxType.addItem("Designation");
		getContentPane().add(comboBoxType);

		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				String search = textFieldSearch.getText();
				
				int sel = comboBoxType.getSelectedIndex();
				Validation val = new Validation();
				try {
					if (sel == 0) {
						st = con.prepareStatement("select * from employee where Name LIKE '%" + search + "%'");

					} else if (sel == 1) {
						st = con.prepareStatement("select * from employee where NIC LIKE '%" + search + "%'");
					} else if (sel == 2) {
						st = con.prepareStatement("select * from employee where Designation LIKE '%" + search + "%'");
					} else {
						JOptionPane.showMessageDialog(null, "Enter value to search.");
					}

					rs = st.executeQuery();
					tableEmp.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception ed) {
					System.out.println("Error search table load search." + ed);
				}

			}
		});
		textFieldSearch.setHorizontalAlignment(SwingConstants.CENTER);
		textFieldSearch.setText("Search");
		textFieldSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldSearch.setText("");
			}
		});
		textFieldSearch.setForeground(new Color(102, 0, 102));
		textFieldSearch.setBounds(875, 53, 129, 20);
		getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(21, 89, 1086, 212);
		getContentPane().add(scrollPane);

		tableEmp = new JTable();
		scrollPane.setViewportView(tableEmp);
		tableEmp.setForeground(new Color(102, 0, 102));
		tableEmp.setBackground(new Color(255, 204, 255));

		tableLoad();

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBackground(new Color(204, 153, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		btnBack.setBounds(1000, 396, 89, 23);
		getContentPane().add(btnBack);

		JButton btnReset = new JButton("All the Details");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldSearch.setText("Search");
				tableLoad();

			}
		});
		btnReset.setBackground(new Color(204, 153, 255));
		btnReset.setBounds(958, 343, 149, 23);
		getContentPane().add(btnReset);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddEmployee.class.getResource("/com/microElectronics/images/Background.jpg")));
		label.setBounds(10, 17, 1114, 368);
		getContentPane().add(label);

	}

	public void reset() {
		textFieldSearch.setText("");

	}

	public void tableLoad() {
		try {
			st = con.prepareStatement("select EID,Status,Name,Designation,Age,Address,NIC,AccNo,TelNo,Email,Qualification,WorkExperience,Salary,Date from employee");
			rs = st.executeQuery();
			tableEmp.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ed) {
			System.out.println("Error table load. " + ed);
		}
	}

}
