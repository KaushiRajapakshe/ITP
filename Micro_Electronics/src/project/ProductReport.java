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
import itp.java.item.AddItem;
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
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.awt.event.ActionEvent;

public class ProductReport extends JFrame {
	public static final String DateFormat = "dd/MM/yyyy";
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProductReport frame = new ProductReport();
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
	public ProductReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 150);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 1, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("Add Product");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				AddItem item=new AddItem();
				item.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnNewButton.setBounds(27, 48, 168, 53);
		contentPane.add(btnNewButton);
		
		JButton btnViewInvoice = new JButton("Daily Report");
		btnViewInvoice.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 DBConnector db = new DBConnector();
			        FileInputStream input = null;

			        try {
			            String path = "C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\itp\\java\\report\\payment\\Daily Payment Report.jrxml";
			            input = new FileInputStream(new File(path));
			            JRDesignQuery jrquery = new JRDesignQuery();
			            jrquery.setText("select * from bill where billDate = '"+now1()+"'");
			            JasperDesign jasperDesign = JRXmlLoader.load(input);
			            jasperDesign.setQuery(jrquery);
			            JasperReport jasperReport = JasperCompileManager.compileReport(jasperDesign);
			            JasperPrint jasperPrint = JasperFillManager.fillReport(jasperReport, null, db.getCon());
			            JasperViewer viewer = new JasperViewer(jasperPrint, false);
			            viewer.setVisible(true);

			        } catch (FileNotFoundException ex) {
			        } catch (JRException ex) {
			        } finally {
			            try {
			                input.close();
			            } catch (IOException ex) {
			            }
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
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
}
