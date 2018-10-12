package itp.java.payment;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;

import itp.java.bill.AddBill;
import itp.java.payment.AbstractFactory;
import itp.java.payment.Cash;
import itp.java.payment.FactoryProducer;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class AddCash extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private JPanel contentPane;
	private JTextField total;
	private JTextField change;
	private JTextField cash;
	private String bill1;
	private String totValue;
	private String kn;
	
	private static final String PAYMENT = "PAYMENT";
	private static final String CASH = "CASH";

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddCash frame = new AddCash();
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
	public AddCash() {
		initComponent();
	}
	public AddCash(String tot,String bill) {
		this.bill1 = bill;
		this.totValue = tot;
		initComponent();
	}
	public void initComponent() {
		setBounds(100, 100, 450, 335);
		contentPane = new JPanel();
		contentPane.setLayout(null);
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 7));
		
		final JPanel topPanel = new JPanel((LayoutManager) new FlowLayout(FlowLayout.RIGHT));
		topPanel.setBounds(0, 0, 450, 38);
		topPanel.setBackground(new Color(128, 0, 128));
		
		getContentPane().add(topPanel);
		
		JLabel lblPayment = new JLabel("Payment");
		lblPayment.setForeground(new Color(128, 0, 128));
		lblPayment.setFont(new Font("Times New Roman", Font.BOLD, 18));
		lblPayment.setBounds(179, 52, 74, 30);
		contentPane.add(lblPayment);
		
		JLabel tot = new JLabel("Total");
		tot.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		tot.setForeground(new Color(128, 0, 128));
		tot.setBounds(78, 110, 91, 21);
		contentPane.add(tot);
		
		JLabel lblChange = new JLabel("Change");
		lblChange.setForeground(new Color(128, 0, 128));
		lblChange.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblChange.setBounds(78, 155, 91, 21);
		contentPane.add(lblChange);
		
		JLabel lblCash = new JLabel("Cash");
		lblCash.setForeground(new Color(128, 0, 128));
		lblCash.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		lblCash.setBounds(78, 205, 46, 14);
		contentPane.add(lblCash);
		
		total = new JTextField();
		total.setEditable(false);
		total.setBackground(new Color(176, 224, 230));
		total.setBounds(247, 110, 108, 20);
		contentPane.add(total);
		total.setBorder(null);
		total.setText(totValue);
		total.setColumns(10);
		
		change = new JTextField();
		change.setBackground(new Color(175, 238, 238));
		change.setEditable(false);
		change.setBorder(null);
		change.setBounds(247, 155, 108, 20);
		contentPane.add(change);
		change.setColumns(10);
		
		cash = new JTextField();
		cash.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent arg0) {
				changeKeyReleased(arg0);
			}
		});
		cash.setBackground(new Color(255, 250, 250));
		cash.setText("");
		cash.setBounds(247, 202, 108, 20);
		contentPane.add(cash);
		cash.setColumns(10);
		
		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				jButton_BackActionPerformed(arg0);
			}
		});
		btnBack.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnBack.setBackground(new Color(255, 0, 102));
		btnBack.setForeground(new Color(255, 255, 255));
		btnBack.setBounds(37, 280, 89, 30);
		contentPane.add(btnBack);
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_ResetActionPerformed(e);
			}
		});
		btnReset.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnReset.setForeground(new Color(255, 255, 255));
		btnReset.setBackground(new Color(204, 0, 102));
		btnReset.setBounds(179, 280, 89, 30);
		contentPane.add(btnReset);
		
		JButton btnProceed = new JButton("Proceed");
		btnProceed.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jButton_ProceedActionPerformed(e);
			}
		});
		btnProceed.setFont(new Font("Times New Roman", Font.BOLD, 17));
		btnProceed.setBackground(new Color(128, 0, 128));
		btnProceed.setForeground(new Color(255, 255, 255));
		btnProceed.setBounds(312, 280, 108, 30);
		contentPane.add(btnProceed);
		
		JLabel background = new JLabel("");
		background.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\src\\image\\k1.png"));
		background.setBounds(8, 38, 435, 290);
		contentPane.add(background);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setUndecorated(true);
	}
	public void jButton_ProceedActionPerformed(java.awt.event.ActionEvent evt) {
		String t = total.getText();
		String c = change.getText();
		String ch = cash.getText();
		if((t.equals("")) || (c.equals("")) || (ch.equals(""))) {
			JOptionPane.showMessageDialog(null,"Text fileds are empty.");
		} else if(kn.equals("+")){
			System.out.println("My "+ bill1);
			System.out.println(bill1+""+t+""+ch+""+c);
			PrintBill ad1 = new PrintBill(bill1,t,ch,c);
			System.out.println(bill1+""+t+""+ch+""+c);
			ad1.setVisible(true);
			this.setVisible(false);
		}else {
			JOptionPane.showMessageDialog(null,"Enter cash for more than total or equal.");
		}
	}
	public void jButton_ResetActionPerformed(java.awt.event.ActionEvent evt) {
		total.setText("");
		change.setText("");
		cash.setText("");
		
	}
	public void jButton_BackActionPerformed(java.awt.event.ActionEvent evt) {
		JOptionPane.showMessageDialog(null,"Back button desable for this time.");
		//AddBill ad1 = new AddBill();
		///ad1.setVisible(true);
		//this.setVisible(false);
	}
	public void changeKeyReleased(java.awt.event.KeyEvent arg0) {
		String c = cash.getText();
		String t = total.getText();
		int cashInt = Integer.parseInt(c);
		int totalInt = Integer.parseInt(t);
		int changeInt = cashInt - totalInt;
		String cg = String.valueOf(changeInt);
		change.setText(cg);
		if(changeInt >= 0) {			
			kn = "+";
		}
	}
	public void setPath() {
		AbstractFactory PaymentFactory = FactoryProducer.getFactory(PAYMENT);
		Cash cash = (Cash) PaymentFactory.getPay(CASH);
		cash.pay();
	}
}
