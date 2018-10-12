package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import javax.swing.border.LineBorder;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import itp.java.bill.AddBill;
import itp.java.dbconnection.DBConnector;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.awt.event.ActionEvent;

public class InvoiceMgt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InvoiceMgt frame = new InvoiceMgt();
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
	public InvoiceMgt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Invoice");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddBill b1 = new AddBill();
				b1.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(27, 48, 168, 53);
		contentPane.add(btnNewButton);
		
		JButton btnViewInvoice = new JButton("View Invoice");
		btnViewInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					DBConnector d = new DBConnector();
					Connection con = d.getCon();
					FileInputStream input = null;
					try {

			            String report = "C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\itp\\java\\report\\payment\\Full Payment Report.jrxml";
			            JasperReport japs = JasperCompileManager.compileReport(report);
			            JasperPrint japsPin = JasperFillManager.fillReport(japs, null, con);
			            JasperViewer.viewReport(japsPin);

			        } catch (Exception e1) {

			            System.out.println(" " + e1);

			        }
			}
		});
		btnViewInvoice.setForeground(new Color(255, 255, 255));
		btnViewInvoice.setBackground(new Color(128, 0, 128));
		btnViewInvoice.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnViewInvoice.setBounds(270, 48, 168, 53);
		contentPane.add(btnViewInvoice);
		
		
		setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
}
