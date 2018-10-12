package database_test;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;

import itp.java.bill.NoOfItem;
import itp.java.bill.cusomerBill;
import itp.java.dbconnection.DBConnector;
import itp.java.month.sales.CalSalary;
import itp.java.month.sales.CalSales;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.view.JasperViewer;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.UIManager;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class ProfitCalculation extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField textFieldnum1;
	private JTextField textFieldnum2;
	private JTextField textFieldnum3;
	private JTextField textFieldtotal;
	private JTextField textFieldsales;
	private JTextField textFieldprofit;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfitCalculation frame = new ProfitCalculation();
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
	public ProfitCalculation() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1227, 640);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1227, 28);
		panel.setLayout(null);
		panel.setForeground(new Color(128, 0, 128));
		panel.setBackground(new Color(128, 0, 128));
		contentPane.add(panel);
		
		JLabel lblProfitCalculation = new JLabel("Profit Calculation");
		lblProfitCalculation.setForeground(Color.WHITE);
		lblProfitCalculation.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblProfitCalculation.setBounds(24, 0, 118, 25);
		panel.add(lblProfitCalculation);
		
		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		btnNewButton_1.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\img\\Exit.jpg"));
		btnNewButton_1.setBounds(1191, 0, 26, 25);
		panel.add(btnNewButton_1);
		
		JButton button = new JButton("");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setState(JFrame.ICONIFIED);
			}
		});
		button.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\img\\Min.jpg"));
		button.setBounds(1162, 0, 26, 25);
		panel.add(button);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 28, 10, 612);
		panel_1.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 630, 1217, 10);
		panel_2.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(1217, 28, 10, 612);
		panel_3.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 459, 1217, 10);
		panel_4.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(79, 74, 518, 336);
		panel_5.setForeground(new Color(0, 0, 0));
		panel_5.setBackground(new Color(186, 85, 211));
		panel_5.setBorder(new TitledBorder(null, "DEDUCTION", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JLabel lblPayroll = new JLabel("Payroll Amount :\r\n");
		lblPayroll.setForeground(new Color(255, 255, 255));
		lblPayroll.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblPayroll.setBounds(42, 73, 142, 14);
		panel_5.add(lblPayroll);
		
		JLabel lblUtilityExpenses = new JLabel("Utility Expenses \r\n(Electricity,Water,Phone) :\r\n");
		lblUtilityExpenses.setForeground(new Color(255, 255, 255));
		lblUtilityExpenses.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblUtilityExpenses.setBounds(42, 120, 319, 34);
		panel_5.add(lblUtilityExpenses);
		
		JLabel lblTax = new JLabel("Tax :\r\n\r\n");
		lblTax.setForeground(new Color(255, 255, 255));
		lblTax.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblTax.setBounds(42, 185, 142, 14);
		panel_5.add(lblTax);
		
		textFieldnum1 = new JTextField();
		textFieldnum1.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textFieldnum1.setBounds(330, 63, 152, 28);
		panel_5.add(textFieldnum1);
		textFieldnum1.setColumns(10);
		
		textFieldnum2 = new JTextField();
		textFieldnum2.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textFieldnum2.setColumns(10);
		textFieldnum2.setBounds(330, 120, 152, 28);
		panel_5.add(textFieldnum2);
		
		textFieldnum3 = new JTextField();
		textFieldnum3.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textFieldnum3.setColumns(10);
		textFieldnum3.setBounds(330, 171, 152, 28);
		panel_5.add(textFieldnum3);
		
		textFieldtotal = new JTextField();
		textFieldtotal.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldtotal.setColumns(10);
		textFieldtotal.setBounds(130, 254, 162, 34);
		panel_5.add(textFieldtotal);
		
		JButton btnNewButton = new JButton("TOTAL\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				float num1,total;
				int num2,num3;
				try {
					num1=Float.parseFloat(textFieldnum1.getText());
					num2=Integer.parseInt(textFieldnum2.getText());
					num3=Integer.parseInt(textFieldnum3.getText());
					
					total=num1+num2+num3;
					textFieldtotal.setText(Float.toString(total));
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
				}
				
			}
		});
		btnNewButton.setBackground(new Color(230, 230, 250));
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNewButton.setBounds(31, 254, 89, 34);
		panel_5.add(btnNewButton);
		
		JButton btnNetProfit = new JButton("NET PROFIT\r\n");
		btnNetProfit.setBounds(806, 528, 151, 34);
		btnNetProfit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				float num5,profit,num4;
				try {
					num4=Float.parseFloat(textFieldtotal.getText());
					num5=Float.parseFloat(textFieldsales.getText());
					
					profit=num5-num4;
					textFieldprofit.setText(Float.toString(profit));
					CalSalary b1 = new CalSalary();
					String i = b1.date();
					String year ="2018";
					DBConnector db = new DBConnector();
			        Connection con = db.getCon();
			        try {
						Statement stm = con.createStatement();
						String query = "INSERT INTO salesreport (Sales, Deduction, Profit, Month,Year) VALUES ('"+textFieldsales.getText()+"','"+num4+"','"+profit+"','"+i+"','"+year+"')";
						int n=stm.executeUpdate(query);
			        }catch(SQLException e1){
			        	e1.printStackTrace();
			        }
			        
				}catch(Exception e1){
					
					JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
				}
				
			}
		});
		btnNetProfit.setForeground(Color.BLACK);
		btnNetProfit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnNetProfit.setBackground(new Color(148, 0, 211));
		contentPane.add(btnNetProfit);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(635, 74, 518, 336);
		panel_6.setLayout(null);
		panel_6.setForeground(Color.BLACK);
		panel_6.setBorder(new TitledBorder(UIManager.getBorder("TitledBorder.border"), "EARNINGS", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		panel_6.setBackground(new Color(186, 85, 211));
		contentPane.add(panel_6);
		
		JLabel lblMonthlySales = new JLabel("Monthly Sales :\r\n");
		lblMonthlySales.setForeground(new Color(255, 255, 255));
		lblMonthlySales.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		lblMonthlySales.setBounds(42, 73, 142, 14);
		panel_6.add(lblMonthlySales);
		
		textFieldsales = new JTextField();
		textFieldsales.setFont(new Font("Trebuchet MS", Font.BOLD, 13));
		textFieldsales.setColumns(10);
		textFieldsales.setBounds(305, 66, 180, 28);
		panel_6.add(textFieldsales);
		
		textFieldprofit = new JTextField();
		textFieldprofit.setBounds(967, 528, 186, 34);
		textFieldprofit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		textFieldprofit.setColumns(10);
		contentPane.add(textFieldprofit);
		
		JButton btnExit = new JButton("Report");
		btnExit.setBounds(78, 528, 110, 34);
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
					DBConnector d = new DBConnector();
					Connection con = d.getCon();
					FileInputStream input = null;
					try {

			            String report = "C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\itp\\java\\report\\payment\\testj.jrxml";
			            JasperReport japs = JasperCompileManager.compileReport(report);
			            JasperPrint japsPin = JasperFillManager.fillReport(japs, null, con);
			            JasperViewer.viewReport(japsPin);

			        } catch (Exception e1) {

			            System.out.println(" " + e1);

			        }
				
			}
		});
		btnExit.setForeground(Color.BLACK);
		btnExit.setFont(new Font("Trebuchet MS", Font.BOLD, 15));
		btnExit.setBackground(new Color(199, 21, 133));
		contentPane.add(btnExit);
		
		JLabel lblEarnings = new JLabel("( Earnings - Deduction )");
		lblEarnings.setBounds(806, 585, 171, 14);
		lblEarnings.setFont(new Font("Trebuchet MS", Font.BOLD, 14));
		contentPane.add(lblEarnings);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("C:\\Users\\User\\eclipse-workspace\\Javaee\\database_test\\src\\img\\background.png"));
		label.setBounds(10, 28, 1207, 601);
		contentPane.add(label);
		
		CalSales c1 = new CalSales();
		String k = c1.date();
		float l = c1.calcSales();
		textFieldsales.setText(l+"");
		
		CalSalary b1 = new CalSalary();
		String i = b1.date();
		float j = b1.calcSales();
		textFieldnum1.setText(j+"");
		
		setUndecorated(true);
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}

}
