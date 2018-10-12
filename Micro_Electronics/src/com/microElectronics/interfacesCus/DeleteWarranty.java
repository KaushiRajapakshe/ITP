package com.microElectronics.interfacesCus;

import java.awt.EventQueue;

import javax.swing.JInternalFrame;

public class DeleteWarranty extends JInternalFrame {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteWarranty frame = new DeleteWarranty();
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
	public DeleteWarranty() {
		setBounds(100, 100, 450, 300);

	}

}
