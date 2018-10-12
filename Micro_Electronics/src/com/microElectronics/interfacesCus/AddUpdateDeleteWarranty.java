package com.microElectronics.interfacesCus;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.microElectronics.controller.WarrantyM;
import com.microElectronics.dataBase.dbConnection;

import net.proteanit.sql.DbUtils;

import javax.swing.JComboBox;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddUpdateDeleteWarranty extends JInternalFrame {
	private JTextField textFieldWarrantyID;
	private JTextField textFieldCustomerID;
	private JTextField textFieldWarrantyPeriod;
	private JTextField textFieldStartDate;
	private JTextField textFieldProductID;
	private JComboBox<String> comboBox;
	private JTextField textFieldDescription;
	private JTable tableWarranty;

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	ResultSet rs1 = null;
	ResultSet rs2 = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddUpdateDeleteWarranty frame = new AddUpdateDeleteWarranty();
					frame.setVisible(true);
					frame.setBackground(Color.MAGENTA);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public AddUpdateDeleteWarranty() {
		getContentPane().setForeground(new Color(153, 0, 153));
		
		con = dbConnection.connection();
		
		getContentPane().setBackground(new Color(204, 153, 255));
		setBounds(100, 100, 1150, 460);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1158, 6);
		panel_1.setBackground(new Color(102, 153, 204));
		getContentPane().add(panel_1);

		JLabel lblWarrantyForm = new JLabel("Warranty form");
		lblWarrantyForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWarrantyForm.setForeground(new Color(102, 0, 102));
		lblWarrantyForm.setBounds(430, 25, 167, 25);
		getContentPane().add(lblWarrantyForm);

		JLabel lblWarrantyId = new JLabel("Warranty ID");
		lblWarrantyId.setForeground(new Color(102, 0, 102));
		lblWarrantyId.setBounds(59, 79, 76, 14);
		getContentPane().add(lblWarrantyId);

		textFieldWarrantyID = new JTextField();
		textFieldWarrantyID.setBounds(151, 76, 100, 20);
		getContentPane().add(textFieldWarrantyID);
		textFieldWarrantyID.setColumns(10);

		JLabel lblCustomerNic = new JLabel("Customer ID");
		lblCustomerNic.setForeground(new Color(102, 0, 102));
		lblCustomerNic.setBounds(59, 116, 76, 14);
		getContentPane().add(lblCustomerNic);

		textFieldCustomerID = new JTextField();
		textFieldCustomerID.setBounds(151, 113, 100, 20);
		getContentPane().add(textFieldCustomerID);
		textFieldCustomerID.setColumns(10);

		JLabel lblWarrantyPeriod = new JLabel("Warranty Period");
		lblWarrantyPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		lblWarrantyPeriod.setForeground(new Color(102, 0, 102));
		lblWarrantyPeriod.setBounds(46, 195, 89, 14);
		getContentPane().add(lblWarrantyPeriod);

		textFieldWarrantyPeriod = new JTextField();
		textFieldWarrantyPeriod.setBounds(151, 192, 100, 20);
		getContentPane().add(textFieldWarrantyPeriod);
		textFieldWarrantyPeriod.setColumns(10);

		JLabel lblDate = new JLabel("Start Date");
		lblDate.setForeground(new Color(102, 0, 102));
		lblDate.setBounds(59, 237, 63, 14);
		getContentPane().add(lblDate);

		textFieldStartDate = new JTextField();
		textFieldStartDate.setBounds(151, 234, 100, 20);
		getContentPane().add(textFieldStartDate);
		textFieldStartDate.setColumns(10);

		JLabel lbStatus = new JLabel("Status");
		lbStatus.setForeground(new Color(102, 0, 102));
		lbStatus.setBounds(59, 281, 76, 14);
		getContentPane().add(lbStatus);

		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setForeground(new Color(102, 0, 102));
		lblProductId.setBounds(59, 155, 64, 14);
		getContentPane().add(lblProductId);

		textFieldProductID = new JTextField();
		textFieldProductID.setBounds(151, 152, 100, 20);
		getContentPane().add(textFieldProductID);
		textFieldProductID.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 79, 727, 289);
		getContentPane().add(scrollPane);

		tableWarranty = new JTable();
		tableWarranty.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tableWarranty.getSelectedRow();
				String WarrantyID = tableWarranty.getValueAt(r, 0).toString();
				String CustomerID=tableWarranty.getValueAt(r, 1).toString();
				String ProductID=tableWarranty.getValueAt(r, 4).toString();
				String WarrantyPeriod=tableWarranty.getValueAt(r, 5).toString();
				String Date=tableWarranty.getValueAt(r, 6).toString();
				String Status=tableWarranty.getValueAt(r, 7).toString();
				String Description=tableWarranty.getValueAt(r, 8).toString();

				textFieldWarrantyID.setText(WarrantyID);
				textFieldCustomerID.setText(CustomerID);
				textFieldProductID.setText(ProductID);
				textFieldWarrantyPeriod.setText(WarrantyPeriod);
				textFieldStartDate.setText(Date);
				comboBox.setSelectedItem(Status);
				textFieldDescription.setText(Description);
				System.out.println(Status);
			}
		});
		scrollPane.setViewportView(tableWarranty);
		tableWarranty.setBackground(new Color(255, 204, 255));

		final JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(151, 278, 100, 20);
		comboBox.addItem("Select");
		comboBox.addItem("-");
		comboBox.addItem("Accepted");
		comboBox.addItem("Send company");
		comboBox.addItem("Received");
		comboBox.addItem("Handed over");
		getContentPane().add(comboBox);
		
		tableLoad();

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String CustomerID=textFieldCustomerID.getText();
				String ProductID=textFieldProductID.getText();
				String WarrantyPeriod=textFieldWarrantyPeriod.getText();
				String Date=textFieldStartDate.getText();
				String Status=(String) comboBox.getSelectedItem();
				String Description =textFieldDescription.getText();
				
				try {
					st = con.prepareStatement("select Name from cutomer where CID='"+CustomerID+"'");
					rs1 = st.executeQuery();
					st = con.prepareStatement("select TelephoneNo from cutomer where CID='"+CustomerID+"'");
					rs2 = st.executeQuery();
				} catch (Exception ed) {
					System.out.print("Error table load." + ed);
				}
				
				String CusName=null,CusTelNo = null;
				try {
					CusName = rs1.getString(1);
					 CusTelNo=rs2.getString(3);
				} catch (SQLException e1) {
				
					e1.printStackTrace();
				}
				System.out.println(CusName+CusTelNo);
				WarrantyM war =new WarrantyM();
				war.addWarranty(CustomerID,CusName,CusTelNo, ProductID, WarrantyPeriod, Date, Status,Description);
				
				tableLoad();
				reset();
			}
		});
		btnAdd.setBackground(new Color(255, 204, 255));
		btnAdd.setForeground(new Color(102, 0, 102));
		btnAdd.setBounds(20, 396, 89, 23);
		getContentPane().add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldWarrantyID.setText("");
				textFieldCustomerID.setText("");
				textFieldProductID.setText("");
				textFieldWarrantyPeriod.setText("");
				textFieldStartDate.setText("");
				comboBox.setSelectedItem("Select");
				textFieldDescription.setText("");
			}
		});
		btnReset.setBackground(new Color(255, 204, 255));
		btnReset.setForeground(new Color(102, 0, 102));
		btnReset.setBounds(192, 355, 89, 23);
		getContentPane().add(btnReset);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBackground(new Color(255, 204, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		btnBack.setBounds(987, 379, 89, 23);
		getContentPane().add(btnBack);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String WarrantyID=textFieldWarrantyID.getText();
				String CustomerID=textFieldCustomerID.getText();
				String ProductID=textFieldProductID.getText();
				String WarrantyPeriod=textFieldWarrantyPeriod.getText();
				String Date=textFieldStartDate.getText();
				String Status=(String) comboBox.getSelectedItem();
				String Description= textFieldDescription.getText();
				
				WarrantyM war =new WarrantyM();
				war.updateWarranty(WarrantyID,CustomerID, ProductID, WarrantyPeriod, Date, Status,Description);
				tableLoad();
				reset();
			}
		});
		btnUpdate.setForeground(new Color(102, 0, 102));
		btnUpdate.setBackground(new Color(255, 204, 255));
		btnUpdate.setBounds(122, 396, 89, 23);
		getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String WarrantyID=textFieldWarrantyID.getText();
				
				WarrantyM war =new WarrantyM();
				war.deleteWarranty(WarrantyID);  
				tableLoad();
				reset();
			}
		});
		btnDelete.setForeground(new Color(102, 0, 102));
		btnDelete.setBackground(new Color(255, 204, 255));
		btnDelete.setBounds(223, 396, 89, 23);
		getContentPane().add(btnDelete);
				
				JLabel lblDescription = new JLabel("Description");
				lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
				lblDescription.setForeground(new Color(102, 0, 102));
				lblDescription.setBounds(35, 322, 100, 14);
				getContentPane().add(lblDescription);
						
						textFieldDescription = new JTextField();
						textFieldDescription.setBounds(151, 309, 130, 40);
						getContentPane().add(textFieldDescription);
						textFieldDescription.setColumns(10);
						
								JLabel labelDescription = new JLabel("");
								labelDescription.setHorizontalAlignment(SwingConstants.CENTER);
								labelDescription.setForeground(new Color(102, 0, 102));
								labelDescription.setIcon(new ImageIcon(AddUpdateDeleteWarranty.class.getResource("/com/microElectronics/images/Background.jpg")));
								labelDescription.setBounds(10, 50, 283, 335);
								getContentPane().add(labelDescription);

	}

	public void reset() {
		textFieldWarrantyID.setText("");
		textFieldCustomerID.setText("");
		textFieldProductID.setText("");
		textFieldWarrantyPeriod.setText("");
		textFieldStartDate.setText("");		
		comboBox.setSelectedItem("Select");
		textFieldDescription.setText("");
	}

	public void tableLoad() {
		try {
			st = con.prepareStatement("select * from warranty");
			rs = st.executeQuery();
			tableWarranty.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ed) {
			System.out.print("Error warranty table load." + ed);
		}
	}
}
