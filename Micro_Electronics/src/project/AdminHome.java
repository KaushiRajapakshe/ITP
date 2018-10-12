package project;
import java.awt.*;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.JPopupMenu;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.border.LineBorder;

import com.microElectronics.interfacesCus.CustomerManagement;
import com.microElectronics.interfacesEmp.EmployeeManagement;

import itp.java.bill.AddBill;
import itp.java.item.AddItem;
import itp.java.stock.Stock;

public class AdminHome extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AdminHome frame = new AdminHome();
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
	public AdminHome() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1380, 769);
		contentPane = new JPanel();
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 2, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(255, 255, 255));

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 1380, 39);
		contentPane.add(panel);
		panel.setBackground(new Color(128, 0, 128));
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			System.exit(25);
			
			}
		});
		lblX.setBounds(1349, 0, 21, 38);
		panel.add(lblX);
		lblX.setForeground(Color.WHITE);
		lblX.setFont(new Font("Tahoma", Font.BOLD, 24));
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				 setState(ICONIFIED);
				
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.BOLD, 24));
		label.setBounds(1318, 0, 21, 38);
		panel.add(label);
		
		JLabel lblAddCustomer = new JLabel("Product Management");
		lblAddCustomer.setForeground(new Color(128, 0, 128));
		lblAddCustomer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddCustomer.setBounds(80, 446, 291, 38);
		contentPane.add(lblAddCustomer);
		
		JLabel lblAddEmployee = new JLabel("Stock Management");
		lblAddEmployee.setForeground(new Color(128, 0, 128));
		lblAddEmployee.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddEmployee.setBounds(80, 702, 291, 38);
		contentPane.add(lblAddEmployee);
		
		JLabel lblAddEmployee_1 = new JLabel("Employee Management\r\n");
		lblAddEmployee_1.setForeground(new Color(128, 0, 128));
		lblAddEmployee_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblAddEmployee_1.setBounds(735, 702, 291, 38);
		contentPane.add(lblAddEmployee_1);
		
		JLabel lblViewCustomer = new JLabel("Customer Management");
		lblViewCustomer.setForeground(new Color(128, 0, 128));
		lblViewCustomer.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblViewCustomer.setBounds(385, 446, 291, 38);
		contentPane.add(lblViewCustomer);
		
		JLabel lblViewStock = new JLabel("Admin Management");
		lblViewStock.setForeground(new Color(128, 0, 128));
		lblViewStock.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblViewStock.setBounds(421, 702, 291, 38);
		contentPane.add(lblViewStock);
		
		JLabel lblSalaryMgt = new JLabel("Salary Management");
		lblSalaryMgt.setForeground(new Color(128, 0, 128));
		lblSalaryMgt.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSalaryMgt.setBounds(1119, 446, 291, 38);
		contentPane.add(lblSalaryMgt);
		
		JLabel lblLeaves = new JLabel("Leaves Management");
		lblLeaves.setForeground(new Color(128, 0, 128));
		lblLeaves.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblLeaves.setBounds(1119, 702, 291, 38);
		contentPane.add(lblLeaves);
		
		JLabel lblIssueBill = new JLabel("Invoice");
		lblIssueBill.setForeground(new Color(128, 0, 128));
		lblIssueBill.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblIssueBill.setBounds(818, 446, 291, 38);
		contentPane.add(lblIssueBill);
		
		JLabel label_2 = new JLabel("");
		label_2.setBounds(58, 245, 211, 188);
		label_2.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\product.png"));
		contentPane.add(label_2);
		label_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ProductReport p = new ProductReport();
				p.setVisible(true);
				
			}
		});
		
		JLabel label_3 = new JLabel("");
		label_3.setBounds(43, 509, 229, 212);
		label_3.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\stock.png"));
		contentPane.add(label_3);
		label_3.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				StockReport st = new StockReport();
				st.setVisible(true);
				
			}
		});
		
		JLabel label_4 = new JLabel("");
		label_4.setBounds(368, 245, 211, 212);
		label_4.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\employee.png"));
		contentPane.add(label_4);
		label_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				CustomerManagement cs=new CustomerManagement();
				cs.setVisible(true);
				
			}
		});
		JLabel label_5 = new JLabel("");
		label_5.setBounds(385, 495, 211, 212);
		label_5.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\admin.png"));
		contentPane.add(label_5);
		label_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				AdminMgt bill=new AdminMgt();
				bill.setVisible(true);
				
			}
		});
		
		JLabel label_6 = new JLabel("");
		label_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				salaryMgt mgt=new salaryMgt();
				mgt.setVisible(true);
			}
		});
		label_6.setBounds(1097, 245, 211, 212);
		label_6.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\salary.png"));
		contentPane.add(label_6);
		
		JLabel label_7 = new JLabel("");
		label_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				leaveMgt leave=new leaveMgt();
				leave.setVisible(true);
			}
		});
		label_7.setBounds(1077, 495, 244, 212);
		label_7.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\leave.png"));
		contentPane.add(label_7);
		
		JLabel label_8 = new JLabel("");
		label_8.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
		label_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				InvoiceMgt in=new InvoiceMgt();
				in.setVisible(true);
				
			}
		});
		label_8.setBounds(735, 233, 235, 212);
		label_8.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\bill.png"));
		contentPane.add(label_8);
		
		JLabel label_9 = new JLabel("");
		label_9.setBounds(711, 495, 235, 212);
		label_9.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\cus.png"));
		contentPane.add(label_9);
		label_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				EmployeeManagement em=new EmployeeManagement();
				em.setVisible(true);
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(128, 0, 128));
		panel_1.setBounds(-61, 752, 1468, 39);
		contentPane.add(panel_1);
		
		JLabel label_10 = new JLabel("");
		label_10.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				System.exit(25);
			}
		});
		label_10.setBounds(1277, 34, 93, 100);
		label_10.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\logout.png"));
		contentPane.add(label_10);
		
		JLabel label_11 = new JLabel("");
		label_11.setBounds(0, 34, 1390, 724);
		label_11.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\back.jpg"));
		contentPane.add(label_11);
		

		
	setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
	}
	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
