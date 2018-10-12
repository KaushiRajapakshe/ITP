 package project;

import java.io.*;
import javax.imageio.*;
import javax.swing.*;

import java.awt.BorderLayout;

import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;
import java.awt.Color;
import java.awt.Font;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.Point;
import java.awt.Frame;
import java.awt.Image;

import javax.swing.border.BevelBorder;
import java.awt.SystemColor;
import javax.swing.border.LineBorder;

public class SplashScreen extends JFrame {

	private JPanel contentPane;
	JProgressBar Load;
	JLabel Loading;
	private JLabel lblNo;
	private JLabel lblTp;
	private JLabel label;

	/**
	 * Launch the application.
	 */
	public static void main(String args[]) throws InterruptedException{
		SplashScreen splash=new SplashScreen();
		
		
		
		
		for (int i = 0;i<=100;i++) {
			Thread.sleep(40);
			splash.setVisible(true);
			splash.Loading.setText("Loading.." +i+"%");
			splash.Load.setValue(i);
				
		
		if(i==100) {
			login log=new login();
			log.setVisible(true);
			splash.dispose();
		}
		}
	}
	
	
	

	private void setContentPane(ImageIcon imageIcon) {
		// TODO Auto-generated method stub
		
	}




	/**
	 * Create the frame.
	 */
	public SplashScreen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 580, 285);
		contentPane = new JPanel();
		contentPane.setAutoscrolls(true);
		contentPane.setForeground(UIManager.getColor("ToolBar.floatingForeground"));
		contentPane.setIgnoreRepaint(true);
		contentPane.setBackground(new Color(128, 0, 128));
		contentPane.setCursor(Cursor.getPredefinedCursor(Cursor.CROSSHAIR_CURSOR));
		contentPane.setBorder(new BevelBorder(BevelBorder.LOWERED, null, null, null, null));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(128, 0, 128)));
		panel.setBounds(0, 213, 580, 66);
		panel.setBackground(new Color(255, 255, 255));
		contentPane.add(panel);
		panel.setLayout(null);
		
		Load = new JProgressBar();
		Load.setBorder(null);
		Load.setBorderPainted(false);
		Load.setEnabled(false);
		Load.setBackground(new Color(255, 255, 255));
		Load.setForeground(new Color(128, 0, 128));
		Load.setBounds(10, 45, 560, 14);
		panel.add(Load);
		
		Loading = new JLabel("Loading..");
		Loading.setForeground(new Color(128, 0, 128));
		Loading.setBackground(new Color(105, 105, 105));
		Loading.setBounds(10, 20, 122, 14);
		panel.add(Loading);
		Loading.setFont(new Font("TomeOfTheUnknown", Font.BOLD, 16));
		Loading.setBackground(new Color(51, 51, 51));
		
		lblNo = new JLabel("No.55,Delkada Road,\r\nMatara");
		lblNo.setForeground(new Color(255, 255, 255));
		lblNo.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblNo.setBounds(10, 113, 483, 104);
		contentPane.add(lblNo);
		
		lblTp = new JLabel("T.P-0717743824");
		lblTp.setForeground(new Color(255, 255, 255));
		lblTp.setFont(new Font("Arial Rounded MT Bold", Font.PLAIN, 14));
		lblTp.setBounds(10, 136, 483, 104);
		contentPane.add(lblTp);
		
		JLabel lblMicroElectronics = new JLabel("Micro Electronics");
		lblMicroElectronics.setFont(new Font("Rockwell", Font.BOLD, 42));
		lblMicroElectronics.setForeground(new Color(255, 255, 255));
		lblMicroElectronics.setBounds(10, 11, 483, 77);
		contentPane.add(lblMicroElectronics);
		
		label = new JLabel("");
		label.setBounds(0, 0, 580, 267);
		label.setIcon(new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\splash.jpg"));
		
		
		contentPane.add(label);
		//Image img=new ImageIcon("C:\\Users\\User\\Desktop\\SLIIT\\Micro Electronics\\img\\log.png");
		
		setUndecorated(true);
		
		Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
		this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
		
		}

	
	
	
	protected JProgressBar getLoad() {
		return Load;
	}
	protected JLabel Loading() {
		return Loading;
	}
}
