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
import javax.swing.SwingConstants;

import com.microElectronics.controller.EmployeeM;
import com.microElectronics.controller.Validation;
import com.microElectronics.dataBase.dbConnection;

import net.proteanit.sql.DbUtils;
import javax.swing.JScrollPane;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class DeleteEmployee extends JInternalFrame {

	private JTextField textFieldEID;
	private JTextField textFieldEName;
	private JComboBox comboBoxType;

	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	private JTable tableEmpSearch;
	private JTextField textFieldSearch;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteEmployee frame = new DeleteEmployee();
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
	public DeleteEmployee() {
		con = dbConnection.connection();

		setBackground(new Color(153, 0, 153));
		getContentPane().setBackground(new Color(204, 153, 255));
		setBounds(100, 100, 1150, 460);
		getContentPane().setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 1158, 6);
		panel_1.setBackground(new Color(102, 153, 204));
		getContentPane().add(panel_1);

		JLabel lblDeleteEmp = new JLabel("Delete Employee Details");
		lblDeleteEmp.setBounds(377, 25, 312, 25);
		lblDeleteEmp.setFont(new Font("Tahoma", Font.BOLD, 20));
		lblDeleteEmp.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblDeleteEmp);
		
		JComboBox comboBoxType = new JComboBox();
		comboBoxType.setBackground(new Color(255, 204, 255));
		comboBoxType.setForeground(new Color(102, 0, 102));
		comboBoxType.setBounds(1015, 73, 98, 20);
		comboBoxType.addItem("Name");
		comboBoxType.addItem("EID");
		comboBoxType.addItem("NIC");
		comboBoxType.addItem("TelNo");
		comboBoxType.addItem("Designation");
		getContentPane().add(comboBoxType);

		JLabel lblEmployeeId = new JLabel("Employee ID");
		lblEmployeeId.setBounds(195, 79, 75, 14);
		lblEmployeeId.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblEmployeeId);

		JLabel lblName = new JLabel("Name");
		lblName.setBounds(495, 79, 46, 14);
		lblName.setForeground(new Color(102, 0, 102));
		getContentPane().add(lblName);

		textFieldEID = new JTextField();
		textFieldEID.setForeground(new Color(102, 0, 102));
		textFieldEID.setEditable(false);
		textFieldEID.setBounds(305, 76, 86, 20);
		getContentPane().add(textFieldEID);
		textFieldEID.setColumns(10);

		textFieldEName = new JTextField();
		textFieldEName.setEditable(false);
		textFieldEName.setBounds(577, 76, 131, 20);
		textFieldEName.setForeground(new Color(102, 0, 102));
		getContentPane().add(textFieldEName);
		textFieldEName.setColumns(10);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(20, 109, 1093, 189);
		getContentPane().add(scrollPane_1);

		tableEmpSearch = new JTable();
		tableEmpSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int r = tableEmpSearch.getSelectedRow();
				String eid = tableEmpSearch.getValueAt(r, 0).toString();
				String name = tableEmpSearch.getValueAt(r, 2).toString();

				textFieldEID.setText(eid);
				textFieldEName.setText(name);

			}
		});
		scrollPane_1.setViewportView(tableEmpSearch);
		tableEmpSearch.setBackground(new Color(255, 204, 204));

		tableLoad();

		JButton btnAdd = new JButton("Delete");
		btnAdd.setBounds(826, 341, 89, 23);
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String eid = textFieldEID.getText();
				String name = textFieldEName.getText();

				int select = JOptionPane.showConfirmDialog(null, "Do you want to delete this record?",
						"Delete confirmation", JOptionPane.YES_NO_OPTION);

				if (select == 0) {
					EmployeeM emp = new EmployeeM();

					emp.deleteEmp(eid, name);
					reset();
					tableLoad();

				}
			}
		});
		btnAdd.setBackground(new Color(204, 153, 255));
		btnAdd.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnAdd);

		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				textFieldEID.setText("");
				textFieldEName.setText("");
				textFieldSearch.setText("Search ");
				tableLoad();

			}
		});
		btnReset.setBounds(925, 341, 89, 23);
		btnReset.setBackground(new Color(204, 153, 255));
		btnReset.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnReset);

		JButton btnBack = new JButton("Back");
		btnBack.setBounds(1024, 341, 89, 23);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});

		textFieldSearch = new JTextField();
		textFieldSearch.setText("Search ");
		textFieldSearch.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				textFieldSearch.setText("");
			}
		});
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				String sel =(String)comboBoxType.getSelectedItem();
				try {
					String qr="select * from employee where "+sel+"=?";
				st = con.prepareStatement(qr);
				st.setString(1, textFieldSearch.getText());
				rs = st.executeQuery();
				tableEmpSearch.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception el) {
					System.out.println("Search : "+el);
				}

			}
		});
		textFieldSearch.setForeground(new Color(102, 0, 102));
		textFieldSearch.setBounds(846, 76, 161, 20);
		getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		btnBack.setBackground(new Color(204, 153, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		getContentPane().add(btnBack);

		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(DeleteEmployee.class.getResource("/com/microElectronics/images/Background.jpg")));
		label.setBounds(10, 17, 1114, 367);
		getContentPane().add(label);

	}

	public void reset() {
		textFieldEID.setText("");
		textFieldEName.setText("");
		textFieldSearch.setText("Search ");
	}

	public void tableLoad() {
		try {
			st = con.prepareStatement("select EID,Status,Name,Designation,Age,Address,NIC,AccNo,TelNo,Email,Qualification,WorkExperience,Salary,Date from employee");
			rs = st.executeQuery();
			tableEmpSearch.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception ed) {
			System.out.println("Error table load." + ed);
		}
	}
}
