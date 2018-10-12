package itp.java.bill;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Point;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import itp.java.dbconnection.DBConnector;
import itp.java.item.GenarateAvailableItems;
import itp.java.payment.AddCash;
import itp.java.payment.AddCheque;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

public class AddBill extends JFrame {
	public static final String DateFormat = "dd/MM/yyyy";
	public static final String DateFormat1 = "MM";
	public static final String DateFormat2 = "yyyy";
	public String bill1 ="";
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Point compCoords;
	private JPanel contentPane;
	private JTextField billNumber;
	private JTextField billDate;
	private JTextField name;
	private JTextField address;
	private JTextField itemNumber;
	private JTextField quantity;
	private JTable bill;
	private JTextField noOfItems;
	private JTextField totalAmount;
	private JTextField discount;
	
	private JTextField na;
	private JTextField pr;
	private JTextField av;
	private JTextField de;
	private JTextField st;
	private JTextField am;
	
	public String a;
	public String a1;
	public String a2;
	public String a3;
	public String a4;
	public String a5;
	
	public double lastValue;
	public String billNumber1;
	public double price;
	public double discount1;
	public String row1;
	public String row;
	public String row2;
	public String productName;

	BillTable b1 = new BillTable();
	calAmount c1 = new calAmount();
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddBill frame = new AddBill();
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
	public AddBill() {
		initComponent();
		Show_Bill_In_JTable();
	}
	private void initComponent() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1227, 640);
		setLocationRelativeTo(null);
	 
	    contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 7));
		contentPane.setBackground(SystemColor.scrollbar);

		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		final JPanel topPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		topPanel.setBounds(5, 5, 1217, 33);
		topPanel.setBackground(new Color(128, 0, 128));
        final JButton minimize = new JButton("-");
        minimize.setForeground(Color.WHITE);
        minimize.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
        final JButton exit = new JButton("X");
        exit.setForeground(Color.WHITE);
        exit.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 13));
        minimize.setBackground(new Color(128, 0, 128));
        exit.setBackground(new Color(128, 0, 128));
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
            }
        });
        minimize.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setState(JFrame.ICONIFIED);
            }
        });
        compCoords = null;
        topPanel.addMouseListener(new MouseListener() {
            public void mouseReleased(MouseEvent e) {
                compCoords = null;
            }

            public void mousePressed(MouseEvent e) {
                compCoords = e.getPoint();
            }

            public void mouseExited(MouseEvent e) {
            }

            public void mouseEntered(MouseEvent e) {
            }

            public void mouseClicked(MouseEvent e) {
            }
        });
        topPanel.addMouseMotionListener(new MouseMotionListener() {
            public void mouseMoved(MouseEvent e) {
            }

            public void mouseDragged(MouseEvent e) {
                Point currCoords = e.getLocationOnScreen();
                setLocation(currCoords.x - compCoords.x, currCoords.y - compCoords.y);
            }
        });
        contentPane.setLayout(null);
        topPanel.add(minimize);
        topPanel.add(exit);
        getContentPane().add(topPanel);
        
        JLabel lblBillDetails = new JLabel("Bill Details");
        lblBillDetails.setBounds(34, 58, 72, 27);
        lblBillDetails.setForeground(new Color(128, 0, 128));
        lblBillDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(lblBillDetails);
        
        JLabel lblBillNumber = new JLabel("Bill Number");
        lblBillNumber.setBounds(33, 88, 72, 22);
        lblBillNumber.setForeground(new Color(128, 0, 128));
        lblBillNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblBillNumber);
        
        JLabel lblBillDate = new JLabel("Bill Date");
        lblBillDate.setBounds(34, 113, 46, 22);
        lblBillDate.setForeground(new Color(128, 0, 128));
        lblBillDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblBillDate);
        
        JLabel lblCustomerDetails = new JLabel("Customer Details");
        lblCustomerDetails.setBounds(487, 58, 134, 29);
        lblCustomerDetails.setForeground(new Color(128, 0, 128));
        lblCustomerDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(lblCustomerDetails);
        
        billNumber = new JTextField();
        billNumber.setBackground(new Color(176, 196, 222));
        billNumber.setForeground(new Color(128, 0, 128));
        billNumber.setBounds(148, 89, 134, 20);
        contentPane.add(billNumber);
        billNumber.setColumns(10);
        
        billDate = new JTextField();
        billDate.setBackground(new Color(176, 196, 222));
        billDate.setForeground(new Color(128, 0, 128));
        billDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
        billDate.setEditable(false);
        billDate.setBounds(148, 114, 134, 20);
        contentPane.add(billDate);
        billDate.setBorder(null);
        billDate.setColumns(10);
        billDate.setText(now1());
        
        JLabel lblName = new JLabel("Name");
        lblName.setBounds(487, 94, 46, 14);
        lblName.setForeground(new Color(128, 0, 128));
        lblName.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblName);
        
        JLabel lblAddress = new JLabel("Address");
        lblAddress.setBounds(487, 119, 60, 14);
        lblAddress.setForeground(new Color(128, 0, 128));
        lblAddress.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblAddress);
        
        name = new JTextField();
        name.setBounds(589, 91, 134, 20);
        contentPane.add(name);
        name.setColumns(10);
        
        address = new JTextField();
        address.setBounds(589, 116, 134, 20);
        contentPane.add(address);
        address.setColumns(10);
        
        JLabel lblOrderDetails = new JLabel("Order Details");
        lblOrderDetails.setBounds(905, 70, 108, 14);
        lblOrderDetails.setForeground(new Color(128, 0, 128));
        lblOrderDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
        contentPane.add(lblOrderDetails);
        
        JLabel lblItemNumber = new JLabel("Item Number");
        lblItemNumber.setHorizontalAlignment(SwingConstants.LEFT);
        lblItemNumber.setBounds(905, 98, 86, 14);
        lblItemNumber.setForeground(new Color(128, 0, 128));
        lblItemNumber.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblItemNumber);
        
        JLabel lblQuantity = new JLabel("Quantity");
        lblQuantity.setBounds(905, 123, 60, 14);
        lblQuantity.setForeground(new Color(128, 0, 128));
        lblQuantity.setFont(new Font("Tahoma", Font.PLAIN, 13));
        contentPane.add(lblQuantity);
        
        itemNumber = new JTextField();
        itemNumber.setBounds(1033, 95, 127, 20);
        contentPane.add(itemNumber);
        itemNumber.setColumns(10);
        
        quantity = new JTextField();
        quantity.setBounds(1033, 120, 127, 20);
        contentPane.add(quantity);
        quantity.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				changeKeyReleased(arg0);
			}
		});
        quantity.setColumns(10);
        
        JButton btnAdd = new JButton("Add");
        btnAdd.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jButton_AddActionPerformed(e);
        	}
        });
        btnAdd.setBounds(900, 168, 89, 33);
        btnAdd.setBackground(new Color(128, 0, 128));
        btnAdd.setForeground(new Color(255, 255, 255));
        btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(btnAdd);
        
        JButton btnVoid = new JButton("Void");
        btnVoid.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		jButton_VoidActionPerformed(e);
        	}
        });
        btnVoid.setBounds(1070, 168, 89, 33);
        btnVoid.setForeground(new Color(255, 255, 255));
		btnVoid.setBackground(new Color(204, 0, 102));
        btnVoid.setFont(new Font("Tahoma", Font.BOLD, 13));
        contentPane.add(btnVoid);
        
        JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(128, 0, 128)));
		scrollPane.setBounds(34, 210, 750, 230);
		contentPane.add(scrollPane);
		
		bill = new JTable();
		bill.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTable_Display_ItemMouseClicked(arg0);
			}
		});
		bill.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(bill);
		bill.setColumnSelectionAllowed(true);
		bill.setCellSelectionEnabled(true);
		bill.setSurrendersFocusOnKeystroke(true);
		bill.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		bill.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"No", "Item No", "Item Name", "Rate", "Qty", "Discount", "Amount"
			}
		));
		bill.getColumnModel().getColumn(0).setPreferredWidth(85);
		bill.getColumnModel().getColumn(1).setPreferredWidth(110);
		bill.getColumnModel().getColumn(2).setPreferredWidth(140);
		bill.getColumnModel().getColumn(5).setPreferredWidth(60);
		bill.setForeground(new Color(128, 0, 128));
		bill.setFillsViewportHeight(true);
		bill.setBackground(new Color(216, 191, 216));
		
		JLabel lblPaymentDetails = new JLabel("Payment Details");
		lblPaymentDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPaymentDetails.setForeground(new Color(128, 0, 128));
		lblPaymentDetails.setBounds(34, 475, 134, 27);
		contentPane.add(lblPaymentDetails);
		
		JLabel lblNoOfItems = new JLabel("No of Items");
		lblNoOfItems.setBounds(34, 526, 80, 14);
		lblNoOfItems.setForeground(new Color(128, 0, 128));
		lblNoOfItems.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNoOfItems);
		
		JLabel lblTotalAmount = new JLabel("Total Amount");
		lblTotalAmount.setBounds(34, 563, 108, 14);
		lblTotalAmount.setForeground(new Color(128, 0, 128));
		lblTotalAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblTotalAmount);
		
		JLabel lblDiscounts = new JLabel("Discounts");
		lblDiscounts.setBounds(34, 598, 60, 14);
		lblDiscounts.setForeground(new Color(128, 0, 128));
		lblDiscounts.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblDiscounts);
		
		noOfItems = new JTextField();
		noOfItems.setEditable(false);
		noOfItems.setBackground(new Color(188, 211, 211));
		noOfItems.setForeground(new Color(128, 0, 128));
		noOfItems.setBounds(169, 520, 127, 20);
		contentPane.add(noOfItems);
		noOfItems.setBorder(null);
		noOfItems.setColumns(10);
		
		totalAmount = new JTextField();
		totalAmount.setEditable(false);
		totalAmount.setBackground(new Color(204, 183, 226));
		totalAmount.setBounds(169, 557, 127, 20);
		contentPane.add(totalAmount);
		totalAmount.setForeground(new Color(128, 0, 128));
		totalAmount.setBorder(null);
		totalAmount.setColumns(10);
		
		discount = new JTextField();
		discount.setBounds(169, 592, 127, 20);
		contentPane.add(discount);
		discount.setColumns(10);
		
		JLabel lblPaymentMode = new JLabel("Payment Mode");
		lblPaymentMode.setBounds(358, 526, 90, 14);
		lblPaymentMode.setForeground(new Color(128, 0, 128));
		lblPaymentMode.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblPaymentMode);
		
		JLabel lblNetSalesAmount = new JLabel("Net Sales Amount");
		lblNetSalesAmount.setFont(new Font("Tahoma", Font.BOLD, 13));
		lblNetSalesAmount.setForeground(new Color(204, 0, 102));
		lblNetSalesAmount.setBounds(358, 563, 134, 35);
		contentPane.add(lblNetSalesAmount);
		
		JLabel lblItemDetails = new JLabel("Item Details");
		lblItemDetails.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblItemDetails.setForeground(new Color(128, 0, 128));
		lblItemDetails.setBounds(901, 273, 90, 22);
		contentPane.add(lblItemDetails);
		
		JLabel lblNameItem = new JLabel("Name");
		lblNameItem.setBounds(905, 316, 46, 14);
		lblNameItem.setForeground(new Color(128, 0, 128));
		lblNameItem.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblNameItem);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setBounds(905, 347, 46, 14);
		lblPrice.setForeground(new Color(128, 0, 128));
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblPrice);
		
		JLabel lblAvailability = new JLabel("Availability");
		lblAvailability.setBounds(905, 381, 86, 14);
		lblAvailability.setForeground(new Color(128, 0, 128));
		lblAvailability.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblAvailability);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(905, 409, 108, 14);
		lblDescription.setForeground(new Color(128, 0, 128));
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblDescription);
		
		JLabel lblStocks = new JLabel("Stocks");
		lblStocks.setBounds(905, 443, 46, 14);
		lblStocks.setForeground(new Color(128, 0, 128));
		lblStocks.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblStocks);
		
		JLabel lblAmount = new JLabel("Amount");
		lblAmount.setBounds(905, 480, 46, 14);
		lblAmount.setForeground(new Color(128, 0, 128));
		lblAmount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		contentPane.add(lblAmount);
		
		JButton btnProcess = new JButton("Process");
		btnProcess.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButton_ProcessActionPerformed(arg0);
			}
		});
		btnProcess.setBackground(new Color(128, 0, 128));
		btnProcess.setForeground(new Color(255, 255, 255));
		btnProcess.setEnabled(true);
		btnProcess.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnProcess.setBounds(1033, 538, 114, 47);
		contentPane.add(btnProcess);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 0, 128));
		panel.setBounds(5, 179, 836, 10);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(831, 38, 10, 602);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(5, 464, 836, 10);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 0, 128));
		panel_3.setBounds(387, 38, 10, 151);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(128, 0, 128));
		panel_4.setBounds(831, 239, 396, 10);
		contentPane.add(panel_4);
		
		viewDetails(a,a1,a2,a3,a4,a5);
		
		JButton btnCal = new JButton("Calculate");
		btnCal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_CalActionPerformed(e);
			}
		});
		btnCal.setBackground(new Color(128, 0, 128));
		btnCal.setForeground(new Color(255, 255, 255));
		btnCal.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnCal.setBounds(702, 585, 108, 33);
		contentPane.add(btnCal);
		
		netSales = new JTextField();
		netSales.setHorizontalAlignment(SwingConstants.RIGHT);
		netSales.setEditable(false);
		netSales.setForeground(new Color(204, 0, 102));
		netSales.setBackground(new Color(216, 191, 216));
		netSales.setFont(new Font("Tahoma", Font.BOLD, 14));
		netSales.setBorder(null);
		netSales.setBounds(535, 563, 130, 35);
		contentPane.add(netSales);
		netSales.setColumns(10);
		
		pay = new JTextField();
		pay.setBackground(new Color(204, 204, 255));
		pay.setBounds(535, 524, 130, 20);
		contentPane.add(pay);
		pay.setBorder(null);
		pay.setColumns(10);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\image\\background.png"));
		background.setBounds(5, 38, 1217, 596);
		contentPane.add(background);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

        BillNumber b5 = new BillNumber();
		billNumber1 = b5.genarateBillNumber();
		billNumber.setText(billNumber1);
		billNumber.setBorder(null);
	}
	public void viewDetails(String a,String a1,String a2,String a3,String a4,String a5) {
		na = new JTextField();
		na.setBackground(new Color(153, 230, 255));
		na.setEditable(false);
		na.setBorder(null);
		na.setBounds(1057, 317, 90, 14);
		contentPane.add(na);
		
		pr = new JTextField();
		pr.setBackground(new Color(169, 234, 242));
		pr.setEditable(false);
		pr.setBorder(null);
		pr.setBounds(1057, 348, 90, 14);
		contentPane.add(pr);
		
		av = new JTextField();
		av.setBackground(new Color(175, 238, 238));
		av.setEditable(false);
		av.setBorder(null);
		av.setBounds(1057, 381, 90, 14);
		contentPane.add(av);
		
		de = new JTextField();
		de.setBackground(new Color(170, 237, 237));
		de.setEditable(false);
		de.setBorder(null);
		de.setBounds(1057, 410, 90, 14);
		contentPane.add(de);
		
		st = new JTextField();
		st.setBackground(new Color(176, 224, 230));
		st.setEditable(false);
		st.setBorder(null);
		st.setBounds(1057, 444, 90, 14);
		contentPane.add(st);
		
		am = new JTextField();
		am.setBackground(new Color(182, 216, 219));
		am.setEditable(false);
		am.setBorder(null);
		am.setBounds(1057, 480, 90, 14);
		contentPane.add(am);
	}
	
	public void executeSQLQuery(String query, String message) {
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			if(stm.executeUpdate(query) == 1) {
				DefaultTableModel model = (DefaultTableModel)bill.getModel();
	            model.setRowCount(0);
	            Show_Bill_In_JTable();
				JOptionPane.showMessageDialog(null,"Data " + message + " succesfully.");
			}else {
				JOptionPane.showMessageDialog(null,"Data Not " + message + " succesfully.");
			}
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	GenarateAvailableItems g1 = new GenarateAvailableItems();
	private JTextField netSales;
	private JTextField pay;
	
	public void changeKeyReleased(java.awt.event.KeyEvent arg0) {
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			String query = "select * from stock where (productID = '"+itemNumber.getText()+"')";
			String query1 ="select * from item where (productID = '"+itemNumber.getText()+"')";
			ResultSet rs = stm.executeQuery(query);
            while(rs.next()){
            	productName = rs.getString("productName");
            	String productDescription = rs.getString("productDescription");
            	int stockLevel1 = rs.getInt("stockLevel");
            	String item = itemNumber.getText();
            	int qty = Integer.parseInt(quantity.getText());
            	g1 = new GenarateAvailableItems(itemNumber.getText(),stockLevel1,qty);
            	int stockLevel = g1.getAvailableStock();
            	b1 = new BillTable(item,productName,productDescription,stockLevel,qty);
            	a = b1.getProductName();
            	a1 = b1.getProductDescription();
            	a2 = b1.checkAvailability();
    	        a3 = String.valueOf(b1.getStock());
            }
            Statement stm1 = con.createStatement();
            ResultSet rs1 = stm1.executeQuery(query1);
            while(rs1.next()){
            	price = rs1.getDouble("price");
            	discount1 = rs1.getDouble("discount");
            	c1 = new calAmount(price,discount1);
            	int qty1 = b1.getQty();
            	a4 = String.valueOf(c1.getPrice());
    	        a5 = String.valueOf(c1.calcAmount(qty1));
    	        lastValue = c1.calcLastAmount();
    	        
            }
            if(a2 == "Not Available") {
            	itemNumber.setText("");
            	quantity.setText("");
            	na.setText(" ");
    	        av.setText(" ");
    	        st.setText(" ");
    	        de.setText(" ");
    	        pr.setText(" ");
    	        am.setText(" ");
            	JOptionPane.showMessageDialog(null,"Item not Available. Available stock level " + a3 + ".");
            }else {
	            na.setText(a);
    	        av.setText(a2);
    	        st.setText(a3);
    	        de.setText(a1);
    	        pr.setText(a4);
    	        am.setText(a5);
            }
            viewDetails(a,a1,a2,a3,a4,a5);
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
	}
	
	public ArrayList<cusomerBill> getBillList()
	   {
	       ArrayList<cusomerBill> billList = new ArrayList<cusomerBill>();
	       DBConnector db = new DBConnector();
	       Connection con = db.getCon();
	       
	       String query = "SELECT * FROM  customerbill where billNumber = '"+billNumber.getText()+"'";
	       Statement st;
	       ResultSet rs;
	       
	       try {
	           st = con.createStatement();
	           rs = st.executeQuery(query);
	           cusomerBill bill;
	           while(rs.next())
	           {
	               bill = new cusomerBill(rs.getInt("noOfItem"), rs.getString("itemNo"), rs.getString("itemName"), rs.getDouble("rate"), rs.getInt("qty"), rs.getDouble("discount"), rs.getDouble("amount"));
	               billList.add(bill);
	           }
	       } catch (Exception e) {
	           e.printStackTrace();
	       }
	       return billList;
	   }
	
	public void jButton_AddActionPerformed(java.awt.event.ActionEvent evt) {
		String n = name.getText();
		String a = address.getText();
		String i = itemNumber.getText();
		String q = quantity.getText();
		float num1,num2;
		try {
			num1=Float.parseFloat(itemNumber.getText());
			num2=Float.parseFloat(quantity.getText());
			
		}catch(Exception e1){
			
			JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
		}
		if((i.equals("")) || (q.equals("")) || (n.equals("")) || (a.equals(""))){
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		}else {
			NoOfItem b6 = new NoOfItem(billNumber1);
			String noItem = b6.countNoOfItems();
			g1.setStockLevel();
			noOfItems.setText(noItem);
			String query = "INSERT INTO customerbill (billNumber, billDate, noOfItem, itemNo, itemName, rate, qty, discount, amount, cusName, cusAddress ) VALUES ('"+billNumber1+"','"+billDate.getText()+"','"+noItem+"','"+itemNumber.getText()+"','"+productName+"','"+price+"','"+quantity.getText()+"','"+discount1+"','"+a5+"','"+name.getText()+"','"+address.getText()+"')";
			executeSQLQuery(query, "Inserted");
			cusomerBill c2 = new cusomerBill();
			String tm = c2.calTotalAmount(billNumber1);
			totalAmount.setText(tm);
		}
	}
	
	 public void Show_Bill_In_JTable()
	   {
		 ArrayList<cusomerBill> list = getBillList();
	       DefaultTableModel model = (DefaultTableModel)bill.getModel();
	       Object[] row = new Object[7];
	       for(int i = 0; i < list.size(); i++)
	       {
	    	   row[0] = list.get(i).getNoOfItem();
	           row[1] = list.get(i).getItemNo();
	           row[2] = list.get(i).getItemName();
	           row[3] = list.get(i).getRate();
	           row[4] = list.get(i).getQty();
	           row[5] = list.get(i).getDiscount();
	           row[6] = list.get(i).getAmount();
	           
	           model.addRow(row);
	       }
	    }
	 
	 public void jTable_Display_ItemMouseClicked(java.awt.event.MouseEvent arg0){
		// Get The Index Of The Selected Row 
	        int i = bill.getSelectedRow();

	        TableModel model = bill.getModel();
	        row  = model.getValueAt(i,0).toString();
	        row2 = model.getValueAt(i,1).toString();
	        System.out.println(" Row " + row);
	 }
	 
	 public void showItem(int index)
	    {
	        row1  =  getBillList().get(index).getItemNo();
	    }
	 
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
	public static String date() {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat1);
		return format.format(c1.getTime());
	}
	public static String year() {
		Calendar c1 = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat2);
		return format.format(c1.getTime());
	}
	public void jButton_VoidActionPerformed(java.awt.event.ActionEvent e) {
		DBConnector db = new DBConnector();
	       Connection con = db.getCon();
	       int billNum = 0;
	       String b = billNumber.getText();
	   try {
	       String query = "Select count(billNumber) AS bill from customerbill where billNumber = '"+b+"'";
	       Statement st = con.createStatement();
	       ResultSet rs1 = st.executeQuery(query);
	       while(rs1.next()){ 
	    	   billNum = rs1.getInt("bill");
	       }
	       
	       System.out.println("KN"+b+ "--"+billNum);
	  
	   } catch (Exception e1) {
	        e1.printStackTrace();
	   }
	   if(row == null) {
		   JOptionPane.showMessageDialog(null,"Please select a row.");
	   }
	   else if((billNum > 0)) {
		   System.out.println("KN"+b+ "--"+billNum);
		ConfirmAdmin ca1 = new ConfirmAdmin(b,row,row2);
		ca1.setVisible(true);
		this.setVisible(false);
	   }else {
		   System.out.println("KN"+b+ "--"+billNum);
		   JOptionPane.showMessageDialog(null,"Have not any items in bill table.");
	   }
	}
	
	public void jButton_CalActionPerformed(java.awt.event.ActionEvent arg0) {
		String n = name.getText();
		String a = address.getText();
		String i = itemNumber.getText();
		String q = quantity.getText();
		String d = discount.getText();
		float num1,num2,num3;
		try {
			num1=Float.parseFloat(itemNumber.getText());
			num2=Float.parseFloat(quantity.getText());
			num3=Float.parseFloat(discount.getText());
		}catch(Exception e1){
			
			JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
		}
		if((i.equals("")) || (q.equals("")) || (n.equals("")) || (a.equals("")) || (d.equals(""))){
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		}else {
			double sales = Integer.parseInt(totalAmount.getText()) - (Integer.parseInt(totalAmount.getText()) * Integer.parseInt(d) / 100);
			String s = String.valueOf(sales);
			System.out.println(s);
			netSales.setText(s);
		}
	}
	public void jButton_ProcessActionPerformed(java.awt.event.ActionEvent arg0) {
		String p = pay.getText();
		System.out.println(p);
		if(p.equals(null)) {
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		}else {
			String tot = totalAmount.getText();
			if(p.equals("Cash")) {
				System.out.println(" " + date() + " " +year());
				String query = "INSERT INTO bill (billNumber, billDate, totalAmount, discountAll, netSales, paymentMode, month, year ) VALUES ('"+billNumber1+"','"+billDate.getText()+"','"+totalAmount.getText()+"','"+discount.getText()+"','"+netSales.getText()+"','"+p+"','"+date()+"','"+year()+"')";
				executeSQLQuery(query, "Inserted");
				bill1 = billNumber.getText();
				AddCash c1 = new AddCash(tot,bill1);
				c1.setVisible(true);
				this.setVisible(false);
			}else if(p.equals("Cheque")) {
				System.out.println(" " + date());
				String query = "INSERT INTO bill (billNumber, billDate, totalAmount, discountAll, netSales, paymentMode, month, year ) VALUES ('"+billNumber1+"','"+billDate.getText()+"','"+totalAmount.getText()+"','"+discount.getText()+"','"+netSales.getText()+"','"+p+"','"+date()+"','"+year()+"')";
				executeSQLQuery(query, "Inserted");
				AddCheque c2 = new AddCheque(tot);
				c2.setVisible(true);
				this.setVisible(false);
			}else {
				JOptionPane.showMessageDialog(null,"Hint:    Please enter payment mode Cash, Cheque.");
			}
		}
		
	}
}
