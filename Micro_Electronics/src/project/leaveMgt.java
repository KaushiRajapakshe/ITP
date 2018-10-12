
package project;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.BevelBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class leaveMgt extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					leaveMgt frame = new leaveMgt();
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
	public leaveMgt() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 475, 151);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new LineBorder(new Color(128, 0, 128), 3, true));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnAddLeave = new JButton("Add Leave");
		btnAddLeave.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				addLeave add=new addLeave();
				add.setVisible(true);
				dispose();
			}
		});
		btnAddLeave.setForeground(Color.WHITE);
		btnAddLeave.setFont(new Font("Tahoma", Font.BOLD, 17));
		btnAddLeave.setBackground(new Color(128, 0, 128));
		btnAddLeave.setBounds(30, 46, 168, 53);
		contentPane.add(btnAddLeave);
		
		JButton btnViewLeaves = new JButton("View Leaves");
		btnViewLeaves.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				viewLeave view=new viewLeave();
				view.setVisible(true);
				
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

}
