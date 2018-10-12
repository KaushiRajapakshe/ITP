package com.microElectronics.interfacesCus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.microElectronics.controller.WarrantyM;
import com.microElectronics.dataBase.dbConnection;

import net.proteanit.sql.DbUtils;

public class ViewSearchWarranty extends JInternalFrame {
	private JTextField textFieldWarrantyID;
	private JTextField textFieldCustomerID;
	private JTextField textFieldWarrantyPeriod;
	private JTextField textFieldStartDate;
	private JTextField textFieldProductID;
	private JComboBox<String> comboBox;
	private JTable tableWarranty;

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewSearchWarranty frame = new ViewSearchWarranty();
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
	public ViewSearchWarranty() {
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
		

		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBackground(new Color(255, 255, 255));
		comboBox.setBounds(151, 278, 100, 20);
		comboBox.addItem("Select");
		comboBox.addItem("-");
		comboBox.addItem("Accepted");
		comboBox.addItem("Send company");
		comboBox.addItem("Received");
		comboBox.addItem("Handed over");
		getContentPane().add(comboBox);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(349, 79, 727, 197);
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

				textFieldWarrantyID.setText(WarrantyID);
				textFieldCustomerID.setText(CustomerID);
				textFieldProductID.setText(ProductID);
				textFieldWarrantyPeriod.setText(WarrantyPeriod);
				textFieldStartDate.setText(Date);
				comboBox.setSelectedItem(Status);
				
			}
		});
		scrollPane.setViewportView(tableWarranty);
		tableWarranty.setBackground(new Color(255, 204, 255));

		
		tableLoad();

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldWarrantyID.setText("");
				textFieldCustomerID.setText("");
				textFieldProductID.setText("");
				textFieldWarrantyPeriod.setText("");
				textFieldStartDate.setText("");
				comboBox.setSelectedItem("Select");

			}
		});
		btnReset.setBackground(new Color(255, 204, 255));
		btnReset.setForeground(new Color(102, 0, 102));
		btnReset.setBounds(865, 379, 89, 23);
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
		
				JLabel label = new JLabel("");
				label.setIcon(new ImageIcon(AddUpdateDeleteWarranty.class.getResource("/com/microElectronics/images/Background.jpg")));
				label.setBounds(10, 50, 283, 354);
				getContentPane().add(label);

	}

	public void reset() {
		textFieldWarrantyID.setText("");
		textFieldCustomerID.setText("");
		
	}

	public void tableLoad() {
		try {
			st = con.prepareStatement("select * from warranty");
			rs = st.executeQuery();
			tableWarranty.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ed) {
			System.out.print("Error table load." + ed);
		}
	}

	

}
