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
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.lowagie.text.pdf.codec.Base64.InputStream;

import database_test.ProfitCalculation;
import database_test.handling_query;
import itp.java.dbconnection.DBConnector;
import itp.java.stock.Stock;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class StockReport extends JFrame {

	private JPanel contentPane;
	public static final String DateFormat = "yyyy";
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					StockReport frame = new StockReport();
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
	public StockReport() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 151);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddLeave = new JButton("Add Stock");
		btnAddLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Stock stock=new Stock();
				stock.setVisible(true);
				dispose();
			}
		});
		btnAddLeave.setForeground(Color.WHITE);
		btnAddLeave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAddLeave.setBackground(new Color(128, 0, 128));
		btnAddLeave.setBounds(30, 46, 168, 53);
		contentPane.add(btnAddLeave);
		
		JButton btnViewLeaves = new JButton("Year Report");
		btnViewLeaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
		            DBConnector db = new DBConnector();
		        FileInputStream input = null;

		        try {
		            String path = "C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\itp\\java\\report\\payment\\Payment Report.jrxml";
		            input = new FileInputStream(new File(path));
		            JRDesignQuery jrquery = new JRDesignQuery();
		            jrquery.setText("select * from bill where year = '"+now1()+"'");
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
		btnViewLeaves.setForeground(Color.WHITE);
		btnViewLeaves.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnViewLeaves.setBackground(new Color(128, 0, 128));
		btnViewLeaves.setBounds(273, 46, 168, 53);
		contentPane.add(btnViewLeaves);
		
		
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
