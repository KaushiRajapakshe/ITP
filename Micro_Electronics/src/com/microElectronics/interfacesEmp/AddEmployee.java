
package com.microElectronics.interfacesEmp;

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

import javax.swing.JButton;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JPasswordField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

import com.microElectronics.controller.EmployeeM;
import com.microElectronics.dataBase.dbConnection;
import com.microElectronics.controller.Validation;
import com.microElectronics.controller.GenId;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;;

public class AddEmployee extends JInternalFrame {
	public static final String DateFormat = "dd/MM/yyyy";
	private JTable tableEmp;
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
	private JTextArea textAreaEAdrs;
	private JTextArea textAreaEQuali;

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

					AddEmployee frame = new AddEmployee();
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

	public AddEmployee() {

		con = dbConnection.connection();

		GenId gid = new GenId();
		String nextid = gid.setId("EID", "employee", "");

		setBackground(new Color(153, 0, 153));
		getContentPane().setBackground(new Color(204, 153, 255));
		setBounds(100, 100, 1150, 460);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1158, 6);
		panel_1.setBackground(new Color(102, 153, 204));
		getContentPane().add(panel_1);

		JComboBox comboBoxEStatus = new JComboBox();
		comboBoxEStatus.setBounds(678, 58, 89, 20);
		comboBoxEStatus.addItem("Select");
		comboBoxEStatus.addItem("Mr.");
		comboBoxEStatus.addItem("Mrs.");
		comboBoxEStatus.addItem("Miss.");
		getContentPane().add(comboBoxEStatus);

		JTextArea textAreaEAdrs = new JTextArea();
		textAreaEAdrs.setBounds(678, 91, 154, 34);
		textAreaEAdrs.setBackground(new Color(255, 255, 255));
		getContentPane().add(textAreaEAdrs);

		JTextArea textAreaEQuali = new JTextArea();
		textAreaEQuali.setBounds(297, 161, 200, 25);
		textAreaEQuali.setBackground(new Color(255, 255, 255));
		textAreaEQuali.setRows(2);
		getContentPane().add(textAreaEQuali);

		passwordFieldEPwd = new JPasswordField();
		passwordFieldEPwd.setBounds(299, 194, 86, 20);
		getContentPane().add(passwordFieldEPwd);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBackground(new Color(204, 153, 204));
		scrollPane.setBounds(10, 323, 1114, 96);
		getContentPane().add(scrollPane);

		tableEmp = new JTable();
		scrollPane.setViewportView(tableEmp);
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

		tableEmp.setBorder(new LineBorder(new Color(102, 0, 102)));
		tableEmp.setForeground(new Color(102, 0, 102));
		tableEmp.setBackground(new Color(255, 153, 255));

		tableLoad();

		JLabel lblWarrantyForm = new JLabel("Application for employement");
		lblWarrantyForm.setBounds(375, 17, 312, 25);
		lblWarrantyForm.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblWarrantyForm.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblWarrantyForm);

		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(20, 61, 75, 14);
		lblEmployeeId.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblEmployeeId);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(214, 61, 46, 14);
		lblName.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblName);

		JLabel lblAge = new JLabel("Age");
		lblAge.setBounds(214, 86, 46, 14);
		lblAge.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblAge);

		JLabel lblNic = new JLabel("NIC");
		lblNic.setBounds(214, 111, 46, 14);
		lblNic.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblNic);

		JLabel lblTelephoneNo = new JLabel("Telephone No");
		lblTelephoneNo.setBounds(181, 136, 108, 14);
		lblTelephoneNo.setForeground(new Color(102, 0, 102));
		lblTelephoneNo.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblTelephoneNo);

		JLabel lblQualifications = new JLabel("Qualifications");
		lblQualifications.setBounds(181, 161, 98, 14);
		lblQualifications.setForeground(new Color(102, 0, 102));
		lblQualifications.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblQualifications);

		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(201, 197, 69, 14);
		lblPassword.setForeground(new Color(102, 0, 102));
		lblPassword.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblPassword);

		JLabel lblBasicsalary = new JLabel("BasicSalary");
		lblBasicsalary.setBounds(191, 222, 79, 14);
		lblBasicsalary.setForeground(new Color(102, 0, 102));
		lblBasicsalary.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblBasicsalary);

		textFieldEID = new JTextField();
		textFieldEID.setEditable(false);
		textFieldEID.setBounds(97, 58, 86, 20);
		getContentPane().add(textFieldEID);
		textFieldEID.setColumns(10);
		textFieldEID.setText(nextid);

		textFieldEName = new JTextField();
		textFieldEName.setBounds(299, 58, 154, 20);
		textFieldEName.setForeground(new Color(0, 0, 0));
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

		textFieldESalary = new JTextField();
		textFieldESalary.setBounds(299, 219, 86, 20);
		getContentPane().add(textFieldESalary);
		textFieldESalary.setColumns(10);

		JLabel lblStatus = new JLabel("Status");
		lblStatus.setBounds(605, 61, 46, 14);
		lblStatus.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblStatus);

		JLabel lblDesignation = new JLabel("Designation");
		lblDesignation.setBounds(828, 61, 89, 14);
		getContentPane().add(lblDesignation);

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(595, 86, 62, 14);
		lblAddress.setForeground(new Color(102, 0, 102));
		lblAddress.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblAddress);

		JLabel lblAccountNo = new JLabel("Account No");
		lblAccountNo.setBounds(595, 136, 75, 14);
		lblAccountNo.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblAccountNo);

		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(605, 161, 46, 14);
		lblEmail.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblEmail);

		JLabel lblWorkExperiance = new JLabel("Work Experiance");
		lblWorkExperiance.setBounds(562, 197, 108, 14);
		lblWorkExperiance.setForeground(new Color(102, 0, 102));
		lblWorkExperiance.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(lblWorkExperiance);

		JLabel lblDate = new JLabel("Date");
		lblDate.setBounds(605, 222, 46, 14);
		lblDate.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblDate);

		textFieldEDesignation = new JTextField();
		textFieldEDesignation.setBounds(904, 58, 116, 20);
		getContentPane().add(textFieldEDesignation);
		textFieldEDesignation.setColumns(10);

		textFieldEAccNo = new JTextField();
		textFieldEAccNo.setBounds(680, 133, 86, 20);
		getContentPane().add(textFieldEAccNo);
		textFieldEAccNo.setColumns(10);

		textFieldEEmail = new JTextField();
		textFieldEEmail.setBounds(678, 158, 175, 20);
		getContentPane().add(textFieldEEmail);
		textFieldEEmail.setColumns(10);

		textFieldEWorkExp = new JTextField();
		textFieldEWorkExp.setBounds(680, 194, 139, 20);
		getContentPane().add(textFieldEWorkExp);
		textFieldEWorkExp.setColumns(10);

		textFieldEDate = new JTextField();
		textFieldEDate.setBounds(681, 219, 86, 20);
		getContentPane().add(textFieldEDate);
		textFieldEDate.setColumns(10);

		JLabel lblEmployeeDetails = new JLabel("Employee Details");
		lblEmployeeDetails.setHorizontalAlignment(SwingConstants.CENTER);
		lblEmployeeDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblEmployeeDetails.setForeground(new Color(102, 0, 102));
		lblEmployeeDetails.setBounds(512, 295, 139, 14);
		getContentPane().add(lblEmployeeDetails);

		JButton btnAdd = new JButton("Add");
		btnAdd.setBounds(784, 251, 89, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("add emp");
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
				if (val.isEmpty(name) == false) {
					JOptionPane.showMessageDialog(null, "Enter the Name.");
					count++;
				}
				if (val.checkNIC(nic) == true) {
					JOptionPane.showMessageDialog(null, "This NIC already exist.");
					count++;
				}
				if (val.ValidateNIC(nic) == false) {
					JOptionPane.showMessageDialog(null, "Enter valied NIC.");
					count++;
				} else if (val.ValidateAccNo(accno) == false) {
					JOptionPane.showMessageDialog(null, "Enter valied Account Number.");
					count++;
				} else if (val.isEmpty(telno) == false || val.numeric(telno) == false
						|| val.ValidateTelNo(telno) == false) {
					JOptionPane.showMessageDialog(null, "Enter the valid Telephone Number.");
					count++;

				} else if (val.EmailValidation(email) == false) {
					JOptionPane.showMessageDialog(null, "Enter valied Email Address.");
					count++;
				} else if (val.Password(pwd) == false) {
					JOptionPane.showMessageDialog(null,
							"Invalied Password.Enter password in between 5 and 8 characters.");
					count++;
				} else {
					// count = 0;
				}

				EmployeeM emp = new EmployeeM();
				if (count == 0) {
					emp.addEmp(eid, name, status, designation, age, adrs, nic, accno, telno, email, qualifi, workexp,
							pwd, salary, date);
					tableLoad();
					textFieldEID.setText(gid.setId("EID", "employee", ""));
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
		});
		btnAdd.setBackground(new Color(204, 153, 255));
		btnAdd.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEID.setText(gid.setId("EID", "employee", ""));
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
		btnReset.setBounds(883, 251, 89, 23);
		btnReset.setBackground(new Color(204, 153, 255));
		btnReset.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnReset);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(987, 251, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		JButton btnDemo = new JButton("Demo");
		btnDemo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textFieldEName.setText("Shane Jackson ");
				comboBoxEStatus.setSelectedItem("Mr.");
				textFieldEDesignation.setText("Manager");
				textFieldEAge.setText("40");
				textAreaEAdrs.setText("40,Malabe");
				textFieldENIC.setText("783841607v");
				textFieldEAccNo.setText("78945628");
				textFieldETelNo.setText("0767539428");
				textFieldEEmail.setText("shane@gmail.com");
				textAreaEQuali.setText("Diploma");
				textFieldEWorkExp.setText("3yrs");
				passwordFieldEPwd.setText("sha123");
				textFieldESalary.setText("35000");
				textFieldEDate.setText("2018/10/9");
			}
		});
		btnDemo.setForeground(new Color(153, 0, 153));
		btnDemo.setBackground(new Color(255, 204, 255));
		btnDemo.setBounds(678, 251, 89, 23);
		getContentPane().add(btnDemo);
		btnBack.setBackground(new Color(204, 153, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnBack);

		JLabel label = new JLabel("");
		label.setEnabled(false);
		label.setBounds(10, 17, 1114, 267);
		label.setIcon(new ImageIcon(AddEmployee.class.getResource("/com/microElectronics/images/Background.jpg")));
		getContentPane().add(label);

	}

	public void reset() {
		GenId gid = new GenId();
		textFieldEID.setText(gid.setId("EID", "employee", "E"));
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
			System.out.print("Error table load." + ed);
		}
	}
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
}
