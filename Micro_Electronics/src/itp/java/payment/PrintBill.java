package itp.java.payment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.LayoutManager;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import itp.java.bill.AddBill;
import itp.java.bill.cusomerBill;
import itp.java.dbconnection.DBConnector;
import project.AdminMgt;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.UIManager;
import javax.swing.JTextField;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JButton;


public class PrintBill extends JFrame {
	public static final String DateFormat = "dd/MM/yyyy hh:mm";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTable bill;
	private String billNum;
	private  String billNum1;
	private String subTotal;
	private  String subTotal2;
	private String cash;
	private  String cash2;
	private String change2;
	private  String change3;
	private JTextField tbill;
	private JTextField tsubtot;
	private JTextField tcash;
	private JTextField tchange;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrintBill frame = new PrintBill();
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
	public PrintBill() {
		initComponent();
		Show_Bill_In_JTable();
	}
	public PrintBill(String billNumber1,String subTotal1,String cash1,String change1) {
		initComponent();
		billNum = billNumber1;
		subTotal = subTotal1;
		cash = cash1;
		change2 = change1;
		System.out.println(billNumber1);
		System.out.println(billNum);
		Show_Bill_In_JTable();
	}
	public void initComponent() {
		setBounds(100, 100, 373, 587);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(240, 240, 240));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 7));
		
		final JPanel topPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		topPanel.setBounds(0, 0, 373, 30);
		topPanel.setBackground(new Color(128, 0, 128));
		
		getContentPane().add(topPanel);
		
		JLabel lblMicroElectronics = new JLabel("Micro Electronics");
		lblMicroElectronics.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					PrinterJob job=PrinterJob.getPrinterJob();
					job.setJobName("Print Data");
					
					job.setPrintable(new Printable(){
						public int print(Graphics pg,PageFormat pf,int pageNum) {
							if (pageNum>0) {
								return Printable.NO_SUCH_PAGE;
							}
							Graphics2D g2=(Graphics2D)pg;
							g2.translate(pf.getImageableX(), pf.getImageableY());
							g2.scale(0.24, 0.24);
							contentPane.paint(g2);
							return Printable.PAGE_EXISTS;		
						}
			});
		}
		});
			
		lblMicroElectronics.setFont(new Font("Sitka Text", Font.BOLD | Font.ITALIC, 20));
		lblMicroElectronics.setForeground(new Color(128, 0, 128));
		lblMicroElectronics.setBounds(95, 41, 197, 22);
		
		contentPane.add(lblMicroElectronics);
		
		JLabel lblNewLabel = new JLabel("\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF\u25CF");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNewLabel.setForeground(new Color(128, 0, 128));
		lblNewLabel.setBounds(64, 52, 272, 22);
		contentPane.add(lblNewLabel);
		
		JLabel lblTel = new JLabel("Tel : 071-7743824");
		lblTel.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblTel.setForeground(new Color(128, 0, 128));
		lblTel.setBounds(74, 74, 99, 14);
		contentPane.add(lblTel);
		
		JLabel lblMatara = new JLabel("Matara");
		lblMatara.setForeground(new Color(128, 0, 128));
		lblMatara.setFont(new Font("Tahoma", Font.BOLD, 10));
		lblMatara.setBounds(216, 74, 46, 14);
		contentPane.add(lblMatara);
		
		JLabel label = new JLabel("||");
		label.setFont(new Font("Tahoma", Font.BOLD, 12));
		label.setForeground(new Color(255, 0, 102));
		label.setBounds(183, 74, 46, 14);
		contentPane.add(label);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(0, 102, 375, 6);
		contentPane.add(panel);
		
		bill = new JTable();
		bill.setShowHorizontalLines(false);
		bill.setShowGrid(false);
		bill.setRowSelectionAllowed(false);
		bill.setEnabled(false);
		bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		bill.setBounds(35, 198, 305, 214);
		bill.setSurrendersFocusOnKeystroke(true);
		bill.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bill.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"", "", "","",""
			}
		));
		bill.getColumnModel().getColumn(0).setPreferredWidth(85);
		bill.setForeground(new Color(128, 0, 128));
		bill.setFillsViewportHeight(true);
		bill.setBackground(UIManager.getColor("CheckBox.background"));
		contentPane.add(bill);

		JLabel lblThankYou = new JLabel("Thank You !");
		lblThankYou.setForeground(new Color(128, 0, 128));
		lblThankYou.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblThankYou.setBounds(149, 536, 89, 14);
		contentPane.add(lblThankYou);
		
		JLabel lblComeAgain = new JLabel("Come Again..");
		lblComeAgain.setFont(new Font("Times New Roman", Font.BOLD, 15));
		lblComeAgain.setForeground(new Color(128, 0, 128));
		lblComeAgain.setBounds(149, 561, 106, 15);
		contentPane.add(lblComeAgain);
		
		JLabel lblRed = new JLabel("RED");
		lblRed.setForeground(new Color(128, 0, 128));
		lblRed.setBounds(36, 135, 46, 14);
		contentPane.add(lblRed);
		
		JLabel date = new JLabel("");
		date.setForeground(new Color(128, 0, 128));
		date.setBounds(127, 135, 102, 14);
		date.setText(now1());
		contentPane.add(date);
		System.out.println(billNum);
		
		JLabel lblSubTotal = new JLabel("Sub Total");
		lblSubTotal.setForeground(new Color(128, 0, 128));
		lblSubTotal.setBounds(64, 436, 64, 14);
		contentPane.add(lblSubTotal);
		
		JLabel lblCash = new JLabel("Cash");
		lblCash.setForeground(new Color(128, 0, 128));
		lblCash.setBounds(64, 465, 46, 14);
		contentPane.add(lblCash);
		
		JLabel change = new JLabel("Change");
		change.setForeground(new Color(128, 0, 128));
		change.setBounds(64, 490, 46, 14);
		contentPane.add(change);
		
		JLabel lblNewLabel_1 = new JLabel("-----------------------------------");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 24));
		lblNewLabel_1.setForeground(new Color(255, 0, 102));
		lblNewLabel_1.setBounds(10, 519, 365, 14);
		contentPane.add(lblNewLabel_1);
		System.out.println(subTotal);
		
		JLabel lbCash = new JLabel("");
		lbCash.setBounds(246, 465, 46, 14);
		lbCash.setText(cash);
		System.out.println(cash);
		contentPane.add(lblCash);
		
		tbill = new JTextField();
		tbill.setEditable(false);
		tbill.setBackground(SystemColor.menu);
		tbill.setBounds(259, 132, 86, 20);
		contentPane.add(tbill);
		tbill.setForeground(new Color(128, 0, 128));
		tbill.setBorder(null);
		tbill.setColumns(10);
		
		tsubtot = new JTextField();
		tsubtot.setEditable(false);
		tsubtot.setBackground(SystemColor.menu);
		tsubtot.setBounds(228, 433, 86, 20);
		tsubtot.setBorder(null);
		tsubtot.setForeground(new Color(128, 0, 128));
		contentPane.add(tsubtot);
		
		tsubtot.setColumns(10);
		
		tcash = new JTextField();
		tcash.setEditable(false);
		tcash.setBackground(SystemColor.menu);
		tcash.setBounds(228, 462, 86, 20);
		contentPane.add(tcash);
		tcash.setBorder(null);
		tcash.setForeground(new Color(128, 0, 128));
		tcash.setColumns(10);
		
		tchange = new JTextField();
		tchange.setEditable(false);
		tchange.setBackground(SystemColor.menu);
		tchange.setBounds(228, 487, 86, 20);
		contentPane.add(tchange);
		tchange.setBorder(null);
		tchange.setForeground(new Color(128, 0, 128));
		tchange.setColumns(10);
		
		JButton btnNewButton = new JButton("..");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ActionPerformed(e);
				
			}});
		btnNewButton.setBackground(UIManager.getColor("CheckBox.background"));
		btnNewButton.setForeground(new Color(128, 0, 128));
		btnNewButton.setBounds(330, 70, 31, 23);
		contentPane.add(btnNewButton);
		System.out.println(change2);
	
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
	
	}
	
	public void ActionPerformed(java.awt.event.ActionEvent e) {
		PrinterJob job=PrinterJob.getPrinterJob();
		job.setJobName("Print Data");
		job.setPrintable(new Printable(){
			public int print(Graphics pg,PageFormat pf,int pageNum) {
				if (pageNum>0) {
					return Printable.NO_SUCH_PAGE;
				}
				Graphics2D g2=(Graphics2D)pg;
				g2.translate(pf.getImageableX(), pf.getImageableY());
				g2.scale(0.24, 0.24);
				contentPane.paint(g2);
				return Printable.PAGE_EXISTS;
			}

	}
	);
		
	boolean ok=job.printDialog();
	if(ok) {
		try {
			job.print();
			JOptionPane.showMessageDialog(null,"Printing Successfully");
			AddBill bill=new AddBill();
			bill.setVisible(true);
			this.setVisible(false);
		}catch(PrinterException ex) {}
	}
	}
	public ArrayList<cusomerBill> getBillList()
	   {

			tbill.setText(billNum);
			tcash.setText(cash);
			tchange.setText(change2);
			tsubtot.setText(subTotal);
	       ArrayList<cusomerBill> billList1 = new ArrayList<cusomerBill>();
	       DBConnector db = new DBConnector();
	       Connection con = db.getCon();
	       String query = "SELECT * FROM  customerbill where billNumber = '"+billNum+"'";
	       Statement st;
	       ResultSet rs;
	       System.out.println(billNum);
	       try {
	           st = con.createStatement();
	           rs = st.executeQuery(query);
	           cusomerBill bill;
	           while(rs.next())
	           {
	               bill = new cusomerBill(rs.getInt("noOfItem"), rs.getString("itemName"), rs.getDouble("rate"), rs.getInt("qty"), rs.getDouble("amount"));
	               billList1.add(bill);
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return billList1;
	   }
	
	public void Show_Bill_In_JTable()
	   {
		 ArrayList<cusomerBill> list1 = getBillList();
	       DefaultTableModel model1 = (DefaultTableModel)bill.getModel();
	       Object[] row = new Object[5];
	       for(int i = 0; i < list1.size(); i++)
	       {
	    	   row[0] = list1.get(i).getNoOfItem();
	           row[1] = list1.get(i).getItemName();
	           row[2] = list1.get(i).getRate();
	           row[3] = list1.get(i).getQty();
	           row[4] = list1.get(i).getAmount();
	           
	           model1.addRow(row);
	       }
	    }
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
}
