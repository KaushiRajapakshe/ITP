package com.microElectronics.interfacesEmp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import com.microElectronics.controller.EmployeeM;
import com.microElectronics.controller.Validation;
import com.microElectronics.dataBase.dbConnection;
import com.microElectronics.dao.WarrantyDAOImplementation;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class UpdateEmployee extends JInternalFrame {

	private JTextField textFieldEID;
	private JTextField textFieldEName;
	private JTextField textFieldEAge;
	private JTextField textFieldENIC;
	private JTextField textFieldETelNo;
	private JPasswordField passwordFieldEPwd;
	private JTextField textFieldESalary;
	private JTextField textFieldEDesignation;
	private JTextField textFieldEAccNo;
	private JTextField textFieldEEmail;
	private JTextField textFieldEWorkExp;
	private JTextField textFieldEDate;
	private JComboBox comboBoxEStatus;
	private JComboBox comboBoxType;
	private JTextArea textAreaEAdrs;
	private JTextArea textAreaEQuali;

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	private JTextField textFieldSearch;
	private JTable tableEmp;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UpdateEmployee frame = new UpdateEmployee();
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
	public UpdateEmployee() {
		con = dbConnection.connection();

		setBackground(new Color(153, 0, 153));
		getContentPane().setBackground(new Color(204, 153, 255));
		setBounds(100, 100, 1150, 460);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1158, 6);
		panel_1.setBackground(new Color(102, 153, 204));
		getContentPane().add(panel_1);

		JLabel lblWarrantyForm = new JLabel("Employee Details");
		lblWarrantyForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWarrantyForm.setForeground(new Color(102, 0, 102));
		lblWarrantyForm.setBounds(375, 17, 312, 25);
		getContentPane().add(lblWarrantyForm);

		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setForeground(new Color(102, 0, 102));
		lblEmployeeId.setBounds(20, 61, 75, 14);
		getContentPane().add(lblEmployeeId);

		JLabel lblName = new JLabel("Name");
		lblName.setForeground(new Color(102, 0, 102));
		lblName.setBounds(214, 61, 46, 14);
		getContentPane().add(lblName);

		JLabel lblAge = new JLabel("Age");
		lblAge.setForeground(new Color(102, 0, 102));
		lblAge.setBounds(214, 86, 46, 14);
		getContentPane().add(lblAge);

		JLabel lblNic = new JLabel("NIC");
		lblNic.setForeground(new Color(102, 0, 102));
		lblNic.setBounds(214, 111, 46, 14);
		getContentPane().add(lblNic);

		JLabel lblTelephoneNo = new JLabel("Telephone No");
		lblTelephoneNo.setForeground(new Color(102, 0, 102));
		lblTelephoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		lblTelephoneNo.setBounds(181, 136, 108, 14);
		getContentPane().add(lblTelephoneNo);

		JLabel lblQualifications = new JLabel("Qualifications");
		lblQualifications.setForeground(new Color(102, 0, 102));
		lblQualifications.setHorizontalAlignment(SwingConstants.CENTER);
		lblQualifications.setBounds(181, 161, 98, 14);
		getContentPane().add(lblQualifications);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setForeground(new Color(102, 0, 102));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		lblPassword.setBounds(201, 197, 69, 14);
		getContentPane().add(lblPassword);

		JLabel lblBasicsalary = new JLabel("BasicSalary");
		lblBasicsalary.setForeground(new Color(102, 0, 102));
		lblBasicsalary.setHorizontalAlignment(SwingConstants.CENTER);
		lblBasicsalary.setBounds(191, 222, 79, 14);
		getContentPane().add(lblBasicsalary);

		textFieldEID = new JTextField();
		textFieldEID.setEditable(false);
		textFieldEID.setBounds(97, 58, 86, 20);
		getContentPane().add(textFieldEID);
		textFieldEID.setColumns(10);

		textFieldEName = new JTextField();
		textFieldEName.setForeground(new Color(0, 0, 0));
		textFieldEName.setBounds(299, 58, 188, 20);
		getContentPane().add(textFieldEName);
		textFieldEName.setColumns(10);

		textFieldEAge = new JTextField();
		textFieldEAge.setBounds(299, 83, 86, 20);
		getContentPane().add(textFieldEAge);
		textFieldEAge.setColumns(10);

		textFieldENIC = new JTextField();
		textFieldENIC.setBounds(299, 108, 86, 20);
		getContentPane().add(textFieldENIC);
		textFieldENIC.setColumns(10);

		textFieldETelNo = new JTextField();
		textFieldETelNo.setBounds(299, 133, 86, 20);
		getContentPane().add(textFieldETelNo);
		textFieldETelNo.setColumns(10);

		JTextArea textAreaEQuali = new JTextArea();
		textAreaEQuali.setBackground(new Color(255, 255, 255));
		textAreaEQuali.setRows(2);
		textAreaEQuali.setBounds(297, 161, 179, 25);
		getContentPane().add(textAreaEQuali);

		passwordFieldEPwd = new JPasswordField();
		passwordFieldEPwd.setBounds(299, 194, 86, 20);
		getContentPane().add(passwordFieldEPwd);

		textFieldESalary = new JTextField();
		textFieldESalary.setBounds(299, 219, 86, 20);
		getContentPane().add(textFieldESalary);
		textFieldESalary.setColumns(10);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setForeground(new Color(102, 0, 102));
		lblStatus.setBounds(605, 61, 46, 14);
		getContentPane().add(lblStatus);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(828, 61, 89, 14);
		getContentPane().add(lblDesignation);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setForeground(new Color(102, 0, 102));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		lblAddress.setBounds(595, 86, 62, 14);
		getContentPane().add(lblAddress);

		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setForeground(new Color(102, 0, 102));
		lblAccountNo.setBounds(595, 136, 75, 14);
		getContentPane().add(lblAccountNo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setForeground(new Color(102, 0, 102));
		lblEmail.setBounds(605, 161, 46, 14);
		getContentPane().add(lblEmail);

		JLabel lblWorkExperiance = new JLabel("Work Experiance");
		lblWorkExperiance.setForeground(new Color(102, 0, 102));
		lblWorkExperiance.setHorizontalAlignment(SwingConstants.CENTER);
		lblWorkExperiance.setBounds(562, 197, 108, 14);
		getContentPane().add(lblWorkExperiance);

		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(102, 0, 102));
		lblDate.setBounds(605, 222, 46, 14);
		getContentPane().add(lblDate);

		JTextArea textAreaEAdrs = new JTextArea();
		textAreaEAdrs.setBackground(new Color(255, 255, 255));
		textAreaEAdrs.setBounds(678, 91, 168, 34);
		getContentPane().add(textAreaEAdrs);

		JComboBox comboBoxEStatus = new JComboBox();
		comboBoxEStatus.setBounds(678, 58, 89, 20);
		comboBoxEStatus.addItem("Select");
		comboBoxEStatus.addItem("Mr.");
		comboBoxEStatus.addItem("Mrs.");
		comboBoxEStatus.addItem("Miss.");
		getContentPane().add(comboBoxEStatus);
		
		JComboBox comboBoxType = new JComboBox();
		comboBoxType.setBackground(new Color(255, 204, 255));
		comboBoxType.setForeground(new Color(102, 0, 102));
		comboBoxType.setBounds(155, 292, 98, 20);
		comboBoxType.addItem("Name");
		comboBoxType.addItem("EID");
		comboBoxType.addItem("NIC");
		comboBoxType.addItem("TelNo");
		comboBoxType.addItem("Designation");
		getContentPane().add(comboBoxType);

		textFieldEDesignation = new JTextField();
		textFieldEDesignation.setBounds(904, 58, 116, 20);
		getContentPane().add(textFieldEDesignation);
		textFieldEDesignation.setColumns(10);

		textFieldEAccNo = new JTextField();
		textFieldEAccNo.setBounds(680, 133, 86, 20);
		getContentPane().add(textFieldEAccNo);
		textFieldEAccNo.setColumns(10);

		textFieldEEmail = new JTextField();
		textFieldEEmail.setBounds(678, 158, 161, 20);
		getContentPane().add(textFieldEEmail);
		textFieldEEmail.setColumns(10);

		textFieldEWorkExp = new JTextField();
		textFieldEWorkExp.setBounds(680, 194, 130, 20);
		getContentPane().add(textFieldEWorkExp);
		textFieldEWorkExp.setColumns(10);

		textFieldEDate = new JTextField();
		textFieldEDate.setBounds(681, 219, 86, 20);
		getContentPane().add(textFieldEDate);
		textFieldEDate.setColumns(10);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 323, 1114, 96);
		getContentPane().add(scrollPane);

		tableEmp = new JTable();
		tableEmp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tableEmp.getSelectedRow();
				String eid = tableEmp.getValueAt(r, 0).toString();
				String name = tableEmp.getValueAt(r, 1).toString();
				String status = tableEmp.getValueAt(r, 2).toString();
				String designation = tableEmp.getValueAt(r, 3).toString();
				String age = tableEmp.getValueAt(r, 4).toString();
				String adrs = tableEmp.getValueAt(r, 5).toString();
				String nic = tableEmp.getValueAt(r, 6).toString();
				String accno = tableEmp.getValueAt(r, 7).toString();
				String telno = tableEmp.getValueAt(r, 8).toString();
				String email = tableEmp.getValueAt(r, 9).toString();
				String qualifi = tableEmp.getValueAt(r, 10).toString();
				String workexp = tableEmp.getValueAt(r, 11).toString();
				String pwd = tableEmp.getValueAt(r, 12).toString();
				String salary = tableEmp.getValueAt(r, 13).toString();
				String date = tableEmp.getValueAt(r, 14).toString();

				textFieldEID.setText(eid);
				textFieldEName.setText(name);
				comboBoxEStatus.setSelectedItem(status);
				textFieldEDesignation.setText(designation);
				textFieldEAge.setText(age);
				textAreaEAdrs.setText(adrs);
				textFieldENIC.setText(nic);
				textFieldEAccNo.setText(accno);
				textFieldETelNo.setText(telno);
				textFieldEEmail.setText(email);
				textAreaEQuali.setText(qualifi);
				textFieldEWorkExp.setText(workexp);
				passwordFieldEPwd.setText(pwd);
				textFieldESalary.setText(salary);
				textFieldEDate.setText(date);
			}
		});
		scrollPane.setViewportView(tableEmp);
		tableEmp.setBackground(new Color(255, 204, 255));

		tableLoad();

		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eid = textFieldEID.getText();
				String name = textFieldEName.getText();
				String status = comboBoxEStatus.getSelectedItem().toString();
				String designation = textFieldEDesignation.getText();
				String age = textFieldEAge.getText();
				String adrs = textAreaEAdrs.getText();
				String nic = textFieldENIC.getText();
				String accno = textFieldEAccNo.getText();
				String telno = textFieldETelNo.getText();
				String email = textFieldEEmail.getText();
				String qualifi = textAreaEQuali.getText();
				String workexp = textFieldEWorkExp.getText();
				String pwd = passwordFieldEPwd.getText();
				String salary = textFieldESalary.getText();
				String date = textFieldEDate.getText();

				Validation val = new Validation();
				 
				
				int count = 0;
				if (val.ValidateNIC(nic) == false) {
					JOptionPane.showMessageDialog(null, "Invalied NIC.");
					count++;
				} else if (val.ValidateAccNo(accno) == false) {
					JOptionPane.showMessageDialog(null, "Invalied Account Number.");
					count++;
				} else if (val.EmailValidation(email) == false) {
					JOptionPane.showMessageDialog(null, "Invalied Email Address.");
					count++;
				} else if (val.Password(pwd) == false) {
					JOptionPane.showMessageDialog(null,
							"Invalied Password.Enter password in between 5 and 8 characters.");
					count++;
				} else {
					count = 0;
				}

				EmployeeM emp = new EmployeeM();
				
				if (count == 0) {
					int select=JOptionPane.showConfirmDialog(null,  "Do you want to update this record?","Update confirmation",JOptionPane.YES_NO_OPTION);
					
					if(select==0) {
					emp.updateEmp(eid, name, status, designation, age, adrs, nic, accno, telno, email, qualifi, workexp,
							pwd, salary, date);
					tableLoad();
					textFieldEID.setText("");
					textFieldEName.setText("");
					comboBoxEStatus.setSelectedIndex(0);
					textFieldEDesignation.setText("");
					textFieldEAge.setText("");
					textAreaEAdrs.setText("");
					textFieldENIC.setText("");
					textFieldEAccNo.setText("");
					textFieldETelNo.setText("");
					textFieldEEmail.setText("");
					textAreaEQuali.setText("");
					textFieldEWorkExp.setText("");
					passwordFieldEPwd.setText("");
					textFieldESalary.setText("");
					textFieldEDate.setText("");
					}
				}
			}
		});
		btnUpdate.setBackground(new Color(204, 153, 255));
		btnUpdate.setForeground(new Color(102, 0, 102));
		btnUpdate.setBounds(784, 251, 89, 23);
		getContentPane().add(btnUpdate);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEID.setText("");
				textFieldEName.setText("");
				comboBoxEStatus.setSelectedIndex(0);
				textFieldEDesignation.setText("");
				textFieldEAge.setText("");
				textAreaEAdrs.setText("");
				textFieldENIC.setText("");
				textFieldEAccNo.setText("");
				textFieldETelNo.setText("");
				textFieldEEmail.setText("");
				textAreaEQuali.setText("");
				textFieldEWorkExp.setText("");
				passwordFieldEPwd.setText("");
				textFieldESalary.setText("");
				textFieldEDate.setText("");
			}
		});
		btnReset.setBackground(new Color(204, 153, 255));
		btnReset.setForeground(new Color(102, 0, 102));
		btnReset.setBounds(888, 251, 89, 23);
		getContentPane().add(btnReset);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnBack.setBackground(new Color(204, 153, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		btnBack.setBounds(987, 251, 89, 23);
		getContentPane().add(btnBack);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(AddEmployee.class.getResource("/com/microElectronics/images/Background.jpg")));
		label.setBounds(10, 17, 1114, 264);
		getContentPane().add(label);

		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				String sel =(String)comboBoxType.getSelectedItem();
				try {
					String qr="select * from employee where "+sel+"=?";
				st = con.prepareStatement(qr);
				st.setString(1, textFieldSearch.getText());
				rs = st.executeQuery();
				tableEmp.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception el) {
					System.out.println("Search : "+el);
				}
				
			}
		});
		textFieldSearch.addMouseListener(new MouseAdapter() {
			
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldSearch.setText("");
			}
		});
		textFieldSearch.setBackground(new Color(255, 204, 255));
		textFieldSearch.setText("Search");
		textFieldSearch.setBounds(20, 292, 116, 20);
		getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JButton btnSearchBack = new JButton(" All the details");
		btnSearchBack.setHorizontalAlignment(SwingConstants.LEFT);
		btnSearchBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				tableLoad();
				textFieldSearch.setText("Search");
				comboBoxType.setSelectedIndex(0);
				
			}
		});
		btnSearchBack.setForeground(new Color(102, 0, 102));
		btnSearchBack.setBackground(new Color(255, 204, 204));
		btnSearchBack.setBounds(278, 291, 130, 23);
		getContentPane().add(btnSearchBack);
		
		

	}

	public void reset() {
		textFieldEID.setText("");
		textFieldEName.setText("");
		comboBoxEStatus.setSelectedIndex(0);
		textFieldEDesignation.setText("");
		textFieldEAge.setText("");
		textAreaEAdrs.setText("");
		textFieldENIC.setText("");
		textFieldEAccNo.setText("");
		textFieldETelNo.setText("");
		textFieldEEmail.setText("");
		textAreaEQuali.setText("");
		textFieldEWorkExp.setText("");
		passwordFieldEPwd.setText("");
		textFieldESalary.setText("");
		textFieldEDate.setText("");
	}

	public void tableLoad() {
		try {
			st = con.prepareStatement("select * from employee");
			rs = st.executeQuery();
			tableEmp.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ed) {
			System.out.println("Error table load." + ed);
		}
	}
}
