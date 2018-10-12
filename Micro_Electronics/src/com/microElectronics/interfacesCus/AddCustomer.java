package com.microElectronics.interfacesCus;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.microElectronics.controller.CustomerM;
import com.microElectronics.controller.GenId;
import com.microElectronics.dataBase.dbConnection;
import com.microElectronics.controller.Validation;

import net.proteanit.sql.DbUtils;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class AddCustomer extends JInternalFrame {
	public static final String DateFormat = "dd/MM/yyyy";
	private JTextField textFieldCID;
	private JTextField textFieldCusName;
	private JTextField textFieldCusTelNo;
	private JTextField textFieldCusAdrs;
	private JTextField textFieldCusDate;

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	private JTable tableCus;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCustomer frame = new AddCustomer();
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
	public AddCustomer() {
		getContentPane().setBackground(new Color(204, 153, 255));
		setBounds(100, 100, 1150, 460);
		getContentPane().setLayout(null);

		con = dbConnection.connection();

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1158, 6);
		panel_1.setBackground(new Color(102, 153, 204));
		getContentPane().add(panel_1);

		JLabel lblCustomerForm = new JLabel("Customer form");
		lblCustomerForm.setBounds(430, 25, 167, 25);
		lblCustomerForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblCustomerForm.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblCustomerForm);

		JLabel lblCustomerId = new JLabel("Customer ID");
		lblCustomerId.setBounds(59, 79, 76, 14);
		lblCustomerId.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerId.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblCustomerId);

		JLabel lblCustomerName = new JLabel(" Name");
		lblCustomerName.setBounds(59, 120, 76, 14);
		lblCustomerName.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerName.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblCustomerName);

		JLabel lblCustomerTelNo = new JLabel("Telephone Number");
		lblCustomerTelNo.setBounds(40, 165, 112, 14);
		lblCustomerTelNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblCustomerTelNo.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblCustomerTelNo);

		JLabel lblDate = new JLabel(" Date");
		lblDate.setBounds(61, 271, 63, 14);
		lblDate.setHorizontalAlignment(SwingConstants.CENTER);
		lblDate.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblDate);

		JLabel lblCustomerAddress = new JLabel(" Address");
		lblCustomerAddress.setBounds(71, 212, 64, 14);
		lblCustomerAddress.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblCustomerAddress);

		GenId gid = new GenId();
		String nextid = gid.setId("CID", "customer", "C");
		textFieldCID = new JTextField();
		textFieldCID.setEditable(false);
		textFieldCID.setBounds(152, 76, 86, 20);
		getContentPane().add(textFieldCID);
		textFieldCID.setColumns(10);
		textFieldCID.setText(nextid);

		textFieldCusName = new JTextField();
		textFieldCusName.setBounds(152, 117, 144, 20);
		getContentPane().add(textFieldCusName);
		textFieldCusName.setColumns(10);

		textFieldCusTelNo = new JTextField();
		textFieldCusTelNo.setBounds(162, 162, 86, 20);
		getContentPane().add(textFieldCusTelNo);
		textFieldCusTelNo.setColumns(10);

		textFieldCusAdrs = new JTextField();
		textFieldCusAdrs.setBounds(152, 209, 121, 48);
		getContentPane().add(textFieldCusAdrs);
		textFieldCusAdrs.setColumns(10);

		textFieldCusDate = new JTextField();
		textFieldCusDate.setBounds(152, 268, 86, 20);
		getContentPane().add(textFieldCusDate);
		textFieldCusDate.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.addMouseListener(new MouseAdapter() {
		});
		scrollPane.setBounds(342, 61, 782, 307);
		getContentPane().add(scrollPane);

		tableCus = new JTable();
		tableCus.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tableCus.getSelectedRow();
				String CID = tableCus.getValueAt(r, 0).toString();
				String CName = tableCus.getValueAt(r, 1).toString();
				String CusTelNo = tableCus.getValueAt(r, 2).toString();
				String CusAdrs = tableCus.getValueAt(r, 3).toString();
				String CusDate = tableCus.getValueAt(r, 4).toString();

				textFieldCID.setText(CID);
				textFieldCusName.setText(CName);
				textFieldCusTelNo.setText(CusTelNo);
				textFieldCusAdrs.setText(CusAdrs);
				textFieldCusDate.setText(CusDate);

			}
		});
		scrollPane.setViewportView(tableCus);
		tableCus.setForeground(new Color(102, 0, 102));
		tableCus.setBackground(new Color(255, 204, 255));

		tableLoad();

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(121, 326, 76, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String CID = textFieldCID.getText();
				String CName = textFieldCusName.getText();
				String CTelNo = textFieldCusTelNo.getText();
				String CAdrs = textFieldCusAdrs.getText();
				String CDate = textFieldCusDate.getText();

				Validation val = new Validation();
				int count = 0;
				if(val.isEmpty(CName)== false) {
					JOptionPane.showMessageDialog(null, "Enter the Name.");
					count++;						
				}
				if (val.isEmpty(CTelNo)==false ||val.numeric(CTelNo)==false||val.ValidateTelNo(CTelNo)==false ) {
					JOptionPane.showMessageDialog(null, "Enter the valid Telephone Number.");
					count++;				
				}
				if (count == 0) {
				CustomerM cus = new CustomerM();
				cus.addCustomer(CID,CName, CTelNo, CAdrs, CDate);
				tableLoad();
				reset();
				textFieldCID.setText(gid.setId("CID", "customer", "C"));
				}
				
					
				
			}
		});
		btnAdd.setBackground(new Color(255, 204, 255));
		btnAdd.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.setBounds(207, 326, 89, 23);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCID.setText(gid.setId("CID", "customer", "C"));
				textFieldCusName.setText("");
				textFieldCusTelNo.setText("");
				textFieldCusAdrs.setText("");
				textFieldCusDate.setText("");

			}
		});
		btnReset.setBackground(new Color(255, 204, 255));
		btnReset.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnReset);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(987, 379, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBackground(new Color(255, 204, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnBack);
		
		JButton btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldCusName.setText("Sithmi");
				textFieldCusTelNo.setText("0718916485");
				textFieldCusAdrs.setText("45,Kamburugamuwa");
				textFieldCusDate.setText("2018/10/9");
			}
		});
		btnDemo.setBounds(22, 326, 89, 23);
		btnReset.setBackground(new Color(255, 204, 255));
		btnReset.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnDemo);

		JLabel label = new JLabel("");
		label.setBounds(10, 50, 299, 323);
		label.setIcon(new ImageIcon(
				AddUpdateDeleteWarranty.class.getResource("/com/microElectronics/images/Background.jpg")));
		getContentPane().add(label);

	}

	public void reset() {

		textFieldCusName.setText("");
		textFieldCusTelNo.setText("");
		textFieldCusAdrs.setText("");
		textFieldCusDate.setText("");
	}

	public void tableLoad() {
		textFieldCusDate.setText(now1());
		try {
			st = con.prepareStatement("select * from customer");
			rs = st.executeQuery();
			tableCus.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ed) {
			System.out.print("Error table load." + ed);
		}
	}
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
}
