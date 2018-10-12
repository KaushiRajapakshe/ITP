package itp.java.stock;

import java.awt.Color;
import java.awt.Component;
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

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import org.eclipse.wb.swing.FocusTraversalOnArray;

import itp.java.bill.BillTable;
import itp.java.bill.calAmount;
import itp.java.dbconnection.DBConnector;
import itp.java.item.GenarateAvailableItems;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;

public class Stock extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private static Point compCoords;
	private JTable stock;
	private JTextField productName;
	private JTextField productID;
	private JTextField productDescription;
	private JTextField stockLevel;
	private JTextField recorderLevel;
	private JTextField date;
	
	public static final String DateFormat = "dd/MM/yyyy";
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Stock frame = new Stock();
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
	public Stock() {
		initComponent();
		Show_Item_In_JTable();
	}

	public void initComponent() {
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
        
        JLabel lblStockPanel = new JLabel("Stock Panel");
        lblStockPanel.setFont(new Font("Tahoma", Font.BOLD, 18));
        lblStockPanel.setForeground(new Color(128, 0, 128));
        lblStockPanel.setBounds(250, 64, 142, 29);
		contentPane.add(lblStockPanel);
		
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
        
        JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(new Color(128, 0, 128));
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductName.setBounds(40, 172, 105, 29);
		contentPane.add(lblProductName);
		
		productName = new JTextField();
		productName.setBounds(201, 173, 294, 29);
		contentPane.add(productName);
		productName.setEditable(false);
		productName.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setForeground(new Color(128, 0, 128));
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductId.setBounds(40, 119, 105, 27);
		contentPane.add(lblProductId);
		
		productID = new JTextField();
		productID.setBounds(201, 119, 294, 29);
		contentPane.add(productID);
		productID.setColumns(10);
		productID.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				changeKeyReleased(arg0);
			}
		});
		
		JLabel lblProductDescription = new JLabel("Product Description");
		lblProductDescription.setForeground(new Color(128, 0, 128));
		lblProductDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductDescription.setBounds(40, 223, 142, 68);
		contentPane.add(lblProductDescription);
		
		productDescription = new JTextField();
		productDescription.setBounds(201, 240, 294, 68);
		contentPane.add(productDescription);
		productDescription.setEditable(false);
		productDescription.setColumns(10);
		
		JLabel lblStockLevel = new JLabel("Stock Level");
		lblStockLevel.setForeground(new Color(128, 0, 128));
		lblStockLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblStockLevel.setBounds(40, 355, 89, 29);
		contentPane.add(lblStockLevel);
		
		stockLevel = new JTextField();
		stockLevel.setBounds(201, 356, 294, 29);
		contentPane.add(stockLevel);
		stockLevel.setColumns(10);
		
		JLabel lblRecorderLevel = new JLabel("Recorder Level");
		lblRecorderLevel.setForeground(new Color(128, 0, 128));
		lblRecorderLevel.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblRecorderLevel.setBounds(40, 418, 105, 29);
		contentPane.add(lblRecorderLevel);
		
		recorderLevel = new JTextField();
		recorderLevel.setBounds(201, 419, 294, 29);
		contentPane.add(recorderLevel);
		recorderLevel.setColumns(10);
        JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_InsertActionPerformed(e);				
			}
		});
		btnAdd.setBackground(new Color(128, 0, 128));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBounds(131, 555, 89, 51);
		contentPane.add(btnAdd);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButton_ResetActionPerformed(arg0);				
			}
		});
		btnReset.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnReset.setBackground(new Color(255, 0, 153));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBounds(24, 555, 89, 51);
		contentPane.add(btnReset);
		
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnExit.setBackground(new Color(204, 0, 51));
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnExit.setForeground(new Color(255, 255, 255));
		btnExit.setBounds(450, 555, 89, 51);
		contentPane.add(btnExit);
		
		JButton btnNewButton = new JButton("Update");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_UpdateActionPerformed(e);
			}
		});
		btnNewButton.setForeground(new Color(255, 255, 255));
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton.setBackground(new Color(128, 0, 128));
		btnNewButton.setBounds(237, 555, 89, 51);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Delete");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_DeleteActionPerformed(e);
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnNewButton_1.setForeground(new Color(255, 255, 255));
		btnNewButton_1.setBackground(new Color(128, 0, 128));
		btnNewButton_1.setBounds(342, 555, 89, 50);
		contentPane.add(btnNewButton_1);
		
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(128, 0, 128), 1, true));
		scrollPane.setBounds(579, 93, 627, 477);
		contentPane.add(scrollPane);
		
		stock = new JTable();
		stock.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTable_Display_ItemMouseClicked(arg0);
			}
		});
		stock.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(stock);
		stock.setColumnSelectionAllowed(true);
		stock.setCellSelectionEnabled(true);
		stock.setSurrendersFocusOnKeystroke(true);
		stock.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		stock.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Product Name", "Product Description", "Stock Level", "Recorder Level", "Date"
			}
		));
		stock.getColumnModel().getColumn(0).setPreferredWidth(55);
		stock.getColumnModel().getColumn(1).setPreferredWidth(80);
		stock.getColumnModel().getColumn(2).setPreferredWidth(110);
		stock.getColumnModel().getColumn(5).setPreferredWidth(50);
		stock.setForeground(new Color(128, 0, 128));
		stock.setFillsViewportHeight(true);
		stock.setBorder(new LineBorder(new Color(102, 0, 153), 0, true));
		stock.setBackground(new Color(216, 191, 216));
		
		JPanel panel = new JPanel();
		panel.setBounds(559, 38, 10, 602);
		panel.setBackground(new Color(128, 0, 128));
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 510, 563, 10);
		panel_1.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(579, 64, 627, 29);
		contentPane.add(panel_2);
		
		JLabel lblStockWindow = new JLabel("Stock Window");
		lblStockWindow.setBounds(579, 64, 627, 29);
		//lblStockWindow.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblStockWindow);
		lblStockWindow.setBackground(new Color(128, 0, 128));
		lblStockWindow.setForeground(Color.WHITE);
		lblStockWindow.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(128, 0, 128));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(470, 49, 46, 22);
		contentPane.add(lblDate);
		
		date = new JTextField();
		date.setForeground(new Color(128, 0, 128));
		date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		date.setEditable(false);
		date.setBackground(new Color(204, 204, 255));
		date.setBounds(450, 70, 86, 20);
		contentPane.add(date);
		date.setBorder(null);
		date.setColumns(10);
		date.setText(now1());
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\image\\background.png"));
		background.setBounds(5, 38, 1227, 596);
		contentPane.add(background);
		
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblStockPanel, lblProductName, productName, lblProductId, productID, lblProductDescription, productDescription, lblStockLevel, stockLevel, lblRecorderLevel, recorderLevel, btnAdd, btnReset, btnExit, btnNewButton, btnNewButton_1, scrollPane, stock}));

	}
	
		public void executeSQLQuery(String query, String message) {
			DBConnector db = new DBConnector();
	        Connection con = db.getCon();
	        try {
				Statement stm = con.createStatement();
				if(stm.executeUpdate(query) == 1) {
					DefaultTableModel model = (DefaultTableModel)stock.getModel();
		            model.setRowCount(0);
		            Show_Item_In_JTable();
					JOptionPane.showMessageDialog(null,"Data " + message + " succesfully.");
				}else {
					JOptionPane.showMessageDialog(null,"Data Not " + message + " succesfully.");
				}
	        } catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		public void changeKeyReleased(java.awt.event.KeyEvent arg0) {
			DBConnector db = new DBConnector();
	        Connection con = db.getCon();
	        try {
				Statement stm = con.createStatement();
				String query1 ="select * from item where (productID = '"+productID.getText()+"')";
				ResultSet rs = stm.executeQuery(query1);
				String pName ="";
				String pDescription="";
	            while(rs.next()){
	            	pName = rs.getString("productName");
	            	pDescription = rs.getString("productDescription");
	            }
	            productName.setText(pName);
	            productDescription.setText(pDescription);
	            if(productName.getText().equals("")) {
	            	JOptionPane.showMessageDialog(null,"Item not Available. Please check other item .");
	            }
	        } catch (SQLException e1) {
				e1.printStackTrace();
			}
		}
		private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt){ 
			String s = stockLevel.getText();
			String n = productName.getText();
			String d = productDescription.getText();
			String r = recorderLevel.getText();
			String i = productID.getText();
			int num1,num2;
			try {
				num1=Integer.parseInt(stockLevel.getText());
				num2=Integer.parseInt(recorderLevel.getText());
				
			}catch(Exception e1){
				
				JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
			}
			if((s.equals("")) || (n.equals("")) || (d.equals("")) || (r.equals("")) || (i.equals(""))) {
				JOptionPane.showMessageDialog(null,"Text fileds are empty.");
			} else {
				String query = "insert into stock (productName,productID,productDescription,stockLevel,recorderLevel,date) values ('"+productName.getText()+"','"+productID.getText()+"','"+productDescription.getText()+"','"+stockLevel.getText()+"','"+recorderLevel.getText()+"', '"+date.getText()+"')";
				executeSQLQuery(query, "Inserted");
			}
		}
		private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {
			productName.setText("");
			productID.setText("");
			productDescription.setText("");
			stockLevel.setText("");
			recorderLevel.setText("");
		}
		private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
			String s = stockLevel.getText();
			String n = productName.getText();
			String d = productDescription.getText();
			String r = recorderLevel.getText();
			String i = productID.getText();
			int num1,num2;
			try {
				num1=Integer.parseInt(stockLevel.getText());
				num2=Integer.parseInt(recorderLevel.getText());
				
			}catch(Exception e1){
				
				JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
			}
			if((s.equals("")) || (n.equals("")) || (d.equals("")) || (r.equals("")) || (i.equals(""))) {
				JOptionPane.showMessageDialog(null,"Text fileds are empty.");
			} else {
				String query = "UPDATE stock SET recorderLevel='"+recorderLevel.getText()+"', productName='"+productName.getText()+"', productDescription='"+productDescription.getText()+"' , stockLevel='"+stockLevel.getText()+"' WHERE productID = '"+productID.getText()+"'";
				executeSQLQuery(query, "Updated");
			}
		}
		private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
			if(productID.getText() == null) {
				JOptionPane.showMessageDialog(null,"Please enter Product ID.");
			} else {
				String query = "DELETE FROM stock WHERE productID = '"+productID.getText()+"'";
				executeSQLQuery(query, "Deleted");
			}
		}
		private void jTable_Display_ItemMouseClicked(java.awt.event.MouseEvent evt) {                                                  
	       // Get The Index Of The Selected Row 
	        int i = stock.getSelectedRow();

	        TableModel model = stock.getModel();
	        
	         // Display Selected Row In JTexteFields
	        productID.setText(model.getValueAt(i,0).toString());

	        productName.setText(model.getValueAt(i,1).toString());

	        productDescription.setText(model.getValueAt(i,2).toString());

	        stockLevel.setText(model.getValueAt(i,3).toString());
	        
	        recorderLevel.setText(model.getValueAt(i,4).toString());
	        
	        date.setText(model.getValueAt(i, 5).toString());
	    }
		public ArrayList<AddStock> getItemList(){
			ArrayList<AddStock> itemList = new ArrayList<AddStock>();
			DBConnector db = new DBConnector();
	        Connection con = db.getCon();
	        try {
				Statement stm = con.createStatement();
				String query = "select * from stock";
				ResultSet rs = stm.executeQuery(query);
				AddStock addStock;
				while(rs.next()) {
					addStock = new AddStock(rs.getString("productID"),rs.getString("productName"),rs.getString("productDescription"),rs.getInt("stockLevel"),rs.getInt("recorderLevel"),rs.getString("date"));
					itemList.add(addStock);
				}
	        } catch (SQLException e1) {
				e1.printStackTrace();
			}
	        return itemList;
		}
		//Display Data in JFrame
		
		public void Show_Item_In_JTable() {
		       ArrayList<AddStock> list = getItemList();
		       DefaultTableModel model = (DefaultTableModel) stock.getModel();
		       Object[] row = new Object[6];
		       for(int i = 0; i < list.size(); i++)
		       {
		           row[0] = list.get(i).getProductID();
		           row[1] = list.get(i).getProductName();
		           row[2] = list.get(i).getProductDescription();
		           row[3] = list.get(i).getStockLevel();
		           row[4] = list.get(i).getRecorderLevel();
		           row[5] = list.get(i).getDate();
		           
		           model.addRow(row);
		       }
		 }
		
		public static String now1(){
			Calendar cal = Calendar.getInstance();
			SimpleDateFormat format = new SimpleDateFormat(DateFormat);
			return format.format(cal.getTime());
		}
}
