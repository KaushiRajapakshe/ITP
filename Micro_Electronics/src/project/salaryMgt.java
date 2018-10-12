package project;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import itp.java.dbconnection.DBConnector;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class salaryMgt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					salaryMgt frame = new salaryMgt();
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
	public salaryMgt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 151);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddLeave = new JButton("Calc Salary");
		btnAddLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salary add=new salary();
				add.setVisible(true);
				dispose();
			}
		});
		btnAddLeave.setForeground(Color.WHITE);
		btnAddLeave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAddLeave.setBackground(new Color(128, 0, 128));
		btnAddLeave.setBounds(30, 46, 168, 53);
		contentPane.add(btnAddLeave);
		
		JButton btnViewLeaves = new JButton("View Salary");
		btnViewLeaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewSalary view=new viewSalary();
				view.setVisible(true);
				dispose();
				
			}
		});
		btnViewLeaves.setForeground(Color.WHITE);
		btnViewLeaves.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnViewLeaves.setBackground(new Color(128, 0, 128));
		btnViewLeaves.setBounds(273, 46, 168, 53);
		contentPane.add(btnViewLeaves);
		
		JButton btnSalaryReport = new JButton("Salary Report");
		btnSalaryReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnSalaryReport.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
							DBConnector d = new DBConnector();
							Connection con = d.getCon();
							FileInputStream input = null;
							try {

					            String report = "C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\itp\\java\\report\\payment\\Salary.jrxml";
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
		btnSalaryReport.setForeground(Color.WHITE);
		btnSalaryReport.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnSalaryReport.setBackground(new Color(128, 0, 128));
		btnSalaryReport.setBounds(499, 46, 168, 53);
		contentPane.add(btnSalaryReport);
		
		
	setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
	}
}
