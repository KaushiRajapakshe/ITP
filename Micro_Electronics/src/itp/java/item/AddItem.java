package itp.java.item;


import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import itp.java.dbconnection.DBConnector;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.LayoutManager;
import java.awt.Point;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.awt.SystemColor;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import javax.swing.SwingConstants;


public class AddItem extends JFrame {

	public static final String DateFormat = "dd/MM/yyyy";
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static Point compCoords;
	private JPanel contentPane;
	private JTextField productName;
	private JTextField productID;
	private JTextField productDescription;
	private JTextField cost;
	private JTextField price;
	private JTable item;
	private JTextField discount;
	private JTextField date;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddItem frame = new AddItem();
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
	public AddItem() {
		initComponent();
		Show_Item_In_JTable();
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
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);

		//setContentPane(new JLabel(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\image\\background.jpg"))); 
		
		JLabel lblAddItem = new JLabel("Product Panel");
		lblAddItem.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddItem.setForeground(new Color(128, 0, 128));
		lblAddItem.setBounds(256, 77, 142, 29);
		contentPane.add(lblAddItem);
		
		JLabel lblProductName = new JLabel("Product Name");
		lblProductName.setForeground(new Color(128, 0, 128));
		lblProductName.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductName.setBounds(40, 202, 105, 29);
		contentPane.add(lblProductName);
		
		productName = new JTextField();
		productName.setBounds(201, 203, 294, 29);
		contentPane.add(productName);
		productName.setColumns(10);
		
		JLabel lblProductId = new JLabel("Product ID");
		lblProductId.setForeground(new Color(128, 0, 128));
		lblProductId.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductId.setBounds(40, 159, 105, 27);
		contentPane.add(lblProductId);
		
		productID = new JTextField();
		productID.setBounds(201, 159, 294, 29);
		contentPane.add(productID);
		productID.setEditable(false);
		productID.setColumns(10);
		
		JLabel lblProductDescription = new JLabel("Product Description");
		lblProductDescription.setForeground(new Color(128, 0, 128));
		lblProductDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblProductDescription.setBounds(35, 255, 142, 68);
		contentPane.add(lblProductDescription);
		
		productDescription = new JTextField();
		productDescription.setHorizontalAlignment(SwingConstants.LEFT);
		productDescription.setBounds(201, 256, 294, 68);
		contentPane.add(productDescription);
		productDescription.setColumns(10);
		
		JLabel lblCost = new JLabel("Cost");
		lblCost.setForeground(new Color(128, 0, 128));
		lblCost.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblCost.setBounds(40, 346, 46, 29);
		contentPane.add(lblCost);
		
		cost = new JTextField();
		cost.setBounds(201, 346, 294, 29);
		contentPane.add(cost);
		cost.setColumns(10);
		
		JLabel lblPrice = new JLabel("Price");
		lblPrice.setForeground(new Color(128, 0, 128));
		lblPrice.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblPrice.setBounds(40, 389, 46, 29);
		contentPane.add(lblPrice);
		
		price = new JTextField();
		price.setBounds(201, 390, 294, 29);
		contentPane.add(price);
		price.setColumns(10);
		
		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_InsertActionPerformed(e);				
			}
		});
		btnAdd.setBackground(new Color(128, 0, 128));
		btnAdd.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnAdd.setForeground(new Color(255, 255, 255));
		btnAdd.setBounds(161, 555, 89, 51);
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
		btnReset.setBounds(40, 555, 89, 51);
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
		btnExit.setBounds(502, 555, 89, 51);
		contentPane.add(btnExit);
		
		JButton btnUpdate = new JButton("Update");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_UpdateActionPerformed(e);
			}
		});
		btnUpdate.setForeground(new Color(255, 255, 255));
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnUpdate.setBackground(new Color(128, 0, 128));
		btnUpdate.setBounds(279, 555, 89, 51);
		contentPane.add(btnUpdate);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_DeleteActionPerformed(e);
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 13));
		btnDelete.setForeground(new Color(255, 255, 255));
		btnDelete.setBackground(new Color(128, 0, 128));
		btnDelete.setBounds(392, 556, 89, 50);
		contentPane.add(btnDelete);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new LineBorder(new Color(128, 0, 128)));
		scrollPane.setBounds(673, 92, 528, 478);
		contentPane.add(scrollPane);
		
		item = new JTable();
		item.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				jTable_Display_ItemMouseClicked(arg0);
			}
		});
		item.setFont(new Font("Tahoma", Font.PLAIN, 14));
		scrollPane.setViewportView(item);
		item.setColumnSelectionAllowed(true);
		item.setCellSelectionEnabled(true);
		item.setSurrendersFocusOnKeystroke(true);
		item.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		item.setModel(new DefaultTableModel(
			new Object[][] {
			},
			new String[] {
				"Product ID", "Product Name", "Product Description", "Cost", "Price", "Bonuse", "Date"
			}
		));
		item.getColumnModel().getColumn(0).setPreferredWidth(85);
		item.getColumnModel().getColumn(1).setPreferredWidth(110);
		item.getColumnModel().getColumn(2).setPreferredWidth(140);
		item.getColumnModel().getColumn(5).setPreferredWidth(60);
		item.getColumnModel().getColumn(6).setPreferredWidth(110);
		item.setForeground(new Color(128, 0, 128));
		item.setFillsViewportHeight(true);
		item.setBackground(new Color(216, 191, 216));
		
		JLabel lblDiscount = new JLabel("Discount");
		lblDiscount.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDiscount.setForeground(new Color(128, 0, 128));
		lblDiscount.setBounds(40, 429, 89, 29);
		contentPane.add(lblDiscount);
		
		discount = new JTextField();
		discount.setBounds(201, 430, 294, 29);
		contentPane.add(discount);
		discount.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBounds(642, 38, 10, 602);
		panel.setBackground(new Color(128, 0, 128));
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(5, 510, 647, 10);
		panel_1.setBackground(new Color(128, 0, 128));
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(128, 0, 128));
		panel_2.setBounds(673, 64, 528, 29);
		contentPane.add(panel_2);
		
		JLabel lblStockWindow = new JLabel("Product Window");
		lblStockWindow.setBounds(579, 64, 627, 29);
		//lblStockWindow.setVerticalAlignment(SwingConstants.TOP);
		panel_2.add(lblStockWindow);
		lblStockWindow.setBackground(new Color(128, 0, 128));
		lblStockWindow.setForeground(Color.WHITE);
		lblStockWindow.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		
		date = new JTextField();
		date.setForeground(new Color(128, 0, 128));
		date.setFont(new Font("Tahoma", Font.PLAIN, 13));
		date.setEditable(false);
		date.setBackground(new Color(204, 204, 255));
		date.setBounds(502, 92, 75, 29);
		contentPane.add(date);
		date.setBorder(null);
		date.setColumns(10);
		date.setText(now1());
		
		JLabel lblDate = new JLabel("Date");
		lblDate.setForeground(new Color(128, 0, 128));
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDate.setBounds(518, 64, 46, 22);
		contentPane.add(lblDate);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\image\\background.png"));
		background.setBounds(5, 38, 1227, 596);
		contentPane.add(background);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, lblAddItem, lblProductName, productName, lblProductId, productID, lblProductDescription, productDescription, lblCost, cost, lblPrice, price, btnAdd, btnReset, btnExit, btnUpdate, btnDelete, scrollPane, item}));
	}
	public void executeSQLQuery(String query, String message) {
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			if(stm.executeUpdate(query) == 1) {
				DefaultTableModel model = (DefaultTableModel)item.getModel();
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
	private void jButton_InsertActionPerformed(java.awt.event.ActionEvent evt){  
		String p = productName.getText();
		String pd = productDescription.getText();
		String c = cost.getText();
		String pr = price.getText();
		String d = discount.getText();
		String di = date.getText();
		float num1,num2,num3;
		try {
			num1=Float.parseFloat(cost.getText());
			num2=Float.parseFloat(price.getText());
			num2=Float.parseFloat(discount.getText());
		}catch(Exception e1){
			
			JOptionPane.showMessageDialog(null, "Please Enter a valid number!");
		}
		System.out.println(p+"-"+pd+"-"+c+"-"+p+"-"+pr+"-"+d+"-"+di);
		if((p.equals("")) || (pd.equals("")) || (c.equals("")) || (pr.equals("")) || (d.equals("")) || (di.equals(""))) {
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		}else {
			System.out.println("bn"+p+"-"+pd+"-"+c+"-"+p+"-"+pr+"-"+d+"-"+di);
			String query = "insert into item (productName,productDescription,cost,price,discount,date) values ('"+productName.getText()+"','"+productDescription.getText()+"','"+cost.getText()+"','"+price.getText()+"','"+discount.getText()+"','"+date.getText()+"')";
			executeSQLQuery(query, "Inserted");
		}
	}
	private void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {
		productName.setText("");
		productID.setText("");
		productDescription.setText("");
		cost.setText("");
		price.setText("");
		discount.setText("");
		date.setText(now1());
	}
	private void jButton_UpdateActionPerformed(java.awt.event.ActionEvent evt) {
		String p = productName.getText();
		String pn = productID.getText();
		String pd = productDescription.getText();
		String c = cost.getText();
		String pr = price.getText();
		String d = discount.getText();
		String di = date.getText();
		if((p.equals("")) || (pn.equals("")) || (pd.equals("")) || (c.equals("")) || (pr.equals("")) || (d.equals("")) || (di.equals(""))) {
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		} else {
			String query = "UPDATE item SET cost='"+cost.getText()+"', productName='"+productName.getText()+"', productDescription='"+productDescription.getText()+"' , price='"+price.getText()+"', discount='"+discount.getText()+"' WHERE productID = '"+productID.getText()+"'";
			executeSQLQuery(query, "Updated");
		}
	}
	private void jButton_DeleteActionPerformed(java.awt.event.ActionEvent evt) {
		if(productID.getText() == null) {
			JOptionPane.showMessageDialog(null,"Please enter Product ID.");
		} else {
			String query = "DELETE FROM item WHERE productID = '"+productID.getText()+"'";
			executeSQLQuery(query, "Deleted");
		}
	}
	private void jTable_Display_ItemMouseClicked(java.awt.event.MouseEvent evt) {                                                  
       // Get The Index Of The Selected Row 
        int i = item.getSelectedRow();

        TableModel model = item.getModel();
        
         // Display Selected Row In JTexteFields
        productID.setText(model.getValueAt(i,0).toString());

        productName.setText(model.getValueAt(i,1).toString());

        productDescription.setText(model.getValueAt(i,2).toString());

        cost.setText(model.getValueAt(i,3).toString());
        
        price.setText(model.getValueAt(i,4).toString());
        
        discount.setText(model.getValueAt(i,5).toString());
        
        date.setText(model.getValueAt(i, 6).toString());
    }
	public ArrayList<Item> getItemList(){
		ArrayList<Item> itemList = new ArrayList<Item>();
		DBConnector db = new DBConnector();
        Connection con = db.getCon();
        try {
			Statement stm = con.createStatement();
			String query = "select * from item";
			ResultSet rs = stm.executeQuery(query);
			Item item;
			while(rs.next()) {
				item = new Item(rs.getString("productID"),rs.getString("productName"),rs.getString("productDescription"),rs.getFloat("cost"),rs.getFloat("price"),rs.getFloat("discount"),rs.getString("date"));
				itemList.add(item);
			}
        } catch (SQLException e1) {
			e1.printStackTrace();
		}
        return itemList;
	}
	//Display Data in JFrame
	
	public void Show_Item_In_JTable() {
	       ArrayList<Item> list = getItemList();
	       DefaultTableModel model = (DefaultTableModel) item.getModel();
	       Object[] row = new Object[7];
	       for(int i = 0; i < list.size(); i++)
	       {
	           row[0] = list.get(i).getProductID();
	           row[1] = list.get(i).getProductName();
	           row[2] = list.get(i).getProductDescription();
	           row[3] = list.get(i).getCost();
	           row[4] = list.get(i).getPrice();
	           row[5] = list.get(i).getDiscount();
	           row[6] = list.get(i).getDate();
	           
	           model.addRow(row);
	       }
	 }
	
	public static String now1(){
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat format = new SimpleDateFormat(DateFormat);
		return format.format(cal.getTime());
	}
}
