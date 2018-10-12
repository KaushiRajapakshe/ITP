package itp.java.payment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import itp.java.bill.AddBill;
import itp.java.dbconnection.DBConnector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.ImageIcon;

public class AddCheque extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	private static final String PAYMENT = "PAYMENT";
	private static final String CHEQUE = "CHEQUE";
	private JTextField cName;
	private JTextField cNumber;
	private JTextField date;
	private JTextField amount;
	private JTextField bName;
	private JTextField brName;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCheque frame = new AddCheque();
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
	public AddCheque() {
		initComponent();
	}
	public AddCheque(String tot) {
		initComponent();
	}
	public void initComponent() {
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 7));
		
		final JPanel topPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		topPanel.setBounds(0, 0, 450, 38);
		topPanel.setBackground(new Color(128, 0, 128));
		
		getContentPane().add(topPanel);
		
		JLabel lblCheque = new JLabel("Cheque");
		lblCheque.setForeground(new Color(128, 0, 128));
		lblCheque.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblCheque.setBounds(179, 37, 74, 30);
		contentPane.add(lblCheque);
		
		JLabel lblCustomerName = new JLabel("Customer Name");
		lblCustomerName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerName.setForeground(new Color(128, 0, 128));
		lblCustomerName.setBounds(49, 65, 91, 21);
		contentPane.add(lblCustomerName);
		
		JLabel lblChequeNumber = new JLabel("Cheque Number");
		lblChequeNumber.setForeground(new Color(128, 0, 128));
		lblChequeNumber.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblChequeNumber.setBounds(49, 100, 91, 21);
		contentPane.add(lblChequeNumber);
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(128, 0, 128));
		lblDate.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDate.setBounds(49, 139, 46, 14);
		contentPane.add(lblDate);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblAmount.setForeground(new Color(128, 0, 128));
		lblAmount.setBounds(49, 170, 46, 21);
		contentPane.add(lblAmount);
		
		JLabel lblBankName = new JLabel("Bank Name");
		lblBankName.setForeground(new Color(128, 0, 128));
		lblBankName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBankName.setBounds(49, 205, 80, 21);
		contentPane.add(lblBankName);
		
		JLabel lblBranchName = new JLabel("Branch Name");
		lblBranchName.setForeground(new Color(128, 0, 128));
		lblBranchName.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBranchName.setBounds(49, 241, 91, 21);
		contentPane.add(lblBranchName);
		
		cName = new JTextField();
		cName.setBounds(247, 65, 108, 20);
		contentPane.add(cName);
		cName.setColumns(10);
		
		cNumber = new JTextField();
		cNumber.setBounds(247, 100, 108, 20);
		contentPane.add(cNumber);
		cNumber.setColumns(10);
		
		date = new JTextField();
		date.setText("");
		date.setBounds(247, 136, 108, 20);
		contentPane.add(date);
		date.setColumns(10);
		
		amount = new JTextField();
		amount.setBounds(247, 170, 108, 20);
		contentPane.add(amount);
		amount.setColumns(10);
		
		bName = new JTextField();
		bName.setText("");
		bName.setBounds(247, 205, 108, 20);
		contentPane.add(bName);
		bName.setColumns(10);
		
		brName = new JTextField();
		brName.setBounds(247, 241, 108, 20);
		contentPane.add(brName);
		brName.setColumns(10);
		
		JButton btnBack = new JButton("Demo");
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBack.setBackground(new Color(255, 0, 102));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBounds(37, 280, 89, 30);
		contentPane.add(btnBack);
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cName.setText("Kaushi Rajapakshe");
				cNumber.setText("062298");
				date.setText("2018/10/12");
				amount.setText("12500.00");
				bName.setText("Peoples Bank");
				brName.setText("Kollupitiya");
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(204, 0, 102));
		btnReset.setBounds(179, 280, 89, 30);
		contentPane.add(btnReset);
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				cName.setText("");
				cNumber.setText("");
				date.setText("");
				amount.setText("");
				bName.setText("");
				brName.setText("");
			}
		});
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnProceed.setBackground(new Color(128, 0, 128));
		btnProceed.setForeground(new Color(255, 255, 255));
		btnProceed.setBounds(312, 280, 100, 30);
		contentPane.add(btnProceed);
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButton_ProcessActionPerformed(arg0);
			}
		});
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\image\\k1.png"));
		background.setBounds(8, 38, 435, 290);
		contentPane.add(background);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
	}

	public void jButton_ProcessActionPerformed(java.awt.event.ActionEvent arg0) {
		String a = cName.getText();
		String b = cNumber.getText();
		String c = date.getText();
		String d = amount.getText();
		String e = bName.getText();
		String f = brName.getText();
		
		if(a.equals(null) || b.equals(null) || c.equals(null) || d.equals(null) || e.equals(null) || f.equals(null)) {
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		}else { 
			
			if(b.length() != 6){
				JOptionPane.showMessageDialog(null, "Please Enter a valid cheque number!");
			}else{
				int num1 = 0;
				float num2 = 0;
				int v = 0;
				try {
					num1=Integer.parseInt(cNumber.getText());
					num2=Float.parseFloat(amount.getText());
					
				}catch(Exception e1){
					v = 1;
					JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
				}
				if(v != 1){
					String query = "INSERT INTO cheque (cusName, cNumber, date, amount, bankName, branchName ) VALUES ('"+a+"','"+b+"','"+c+"','"+d+"','"+e+"','"+f+"')";
					executeSQLQuery(query, "Inserted");
					AddBill c2 = new AddBill();
					c2.setVisible(true);
					this.setVisible(false);
				}
			}
			
		}
		
	}
	
	public void executeSQLQuery(String query, String message) {
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			if(stm.executeUpdate(query) == 1) {
				JOptionPane.showMessageDialog(null,"Data " + message + " succesfully.");
			}else {
				JOptionPane.showMessageDialog(null,"Data Not " + message + " succesfully.");
			}
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
}
