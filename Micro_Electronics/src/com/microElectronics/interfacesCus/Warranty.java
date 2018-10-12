package com.microElectronics.interfacesCus;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;

import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JDesktopPane;
import javax.swing.ImageIcon;
import javax.swing.JInternalFrame;
import javax.swing.border.LineBorder;

public class Warranty extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Warranty frame = new Warranty();
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
	public Warranty() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1200, 600);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JDesktopPane desktopPane = new JDesktopPane();
		JPanel panel = new JPanel();
		panel.setBackground(new Color(102, 0, 102));
		panel.setBounds(0, 0, 1200, 29);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton btnClose = new JButton("X");
		btnClose.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnClose.setBounds(1153, 1, 47, 31);
		btnClose.setBackground(new Color(255, 0, 0));
		btnClose.setForeground(new Color(0, 0, 0));
		panel.add(btnClose);

		JButton btnMinimize = new JButton("-");
		btnMinimize.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				setState(Frame.ICONIFIED);
			}
		});
		btnMinimize.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnMinimize.setBackground(new Color(255, 0, 0));
		btnMinimize.setBounds(1105, 0, 47, 29);
		panel.add(btnMinimize);

		JLabel lbWarranty = new JLabel("Warranty");
		lbWarranty.setHorizontalAlignment(SwingConstants.CENTER);
		lbWarranty.setFont(new Font("Tahoma", Font.BOLD, 30));
		lbWarranty.setForeground(new Color(102, 0, 102));
		lbWarranty.setBounds(0, 40, 1174, 40);
		contentPane.add(lbWarranty);

		JButton btnAdd = new JButton("Add,Update & Delete");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				AddUpdateDeleteWarranty c = new AddUpdateDeleteWarranty();
				c.setLocation(0, -30); 
				//setLocationRelativeTo(null);
				desktopPane.add(c).setVisible(true);
			}
		});
		btnAdd.setBackground(new Color(204, 153, 255));
		btnAdd.setForeground(new Color(102, 0, 102));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnAdd.setBounds(95, 91, 261, 23);
		contentPane.add(btnAdd);

		JButton btnUpdateWarranty = new JButton("View & Search Warranty Details");
		btnUpdateWarranty.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				desktopPane.removeAll();
				ViewSearchWarranty c = new ViewSearchWarranty();
				c.setLocation(0, -30); 
				//setLocationRelativeTo(null);
				desktopPane.add(c).setVisible(true);
			}
		});
		btnUpdateWarranty.setBackground(new Color(204, 153, 255));
		btnUpdateWarranty.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnUpdateWarranty.setForeground(new Color(102, 0, 102));
		btnUpdateWarranty.setBounds(740, 91, 358, 23);
		contentPane.add(btnUpdateWarranty);

		JButton btnBack = new JButton("Back");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CustomerManagement c = new CustomerManagement();
				c.setVisible(true);
				dispose();
			}
		});
		btnBack.setBackground(new Color(204, 153, 255));
		btnBack.setForeground(new Color(102, 0, 102));
		btnBack.setFont(new Font("Tahoma", Font.PLAIN, 16));
		btnBack.setBounds(1077, 566, 89, 23);
		contentPane.add(btnBack);

		
		desktopPane.setBackground(new Color(204, 153, 204));
		desktopPane.setBounds(25, 125, 1150, 430);
		contentPane.add(desktopPane);

		setUndecorated(true);
		setLocationRelativeTo(null);
	}
}
