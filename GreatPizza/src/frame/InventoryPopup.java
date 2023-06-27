package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;

public class InventoryPopup extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryPopup frame = new InventoryPopup();
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
	public InventoryPopup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 800);
		setLocationRelativeTo(null);
		setUndecorated(true);
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(0, 0, 600, 77);
		contentPane.add(panel);
		
		JLabel lblNewLabel = new JLabel("현재 부족 재고");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 35));
		lblNewLabel.setBounds(167, 76, 250, 77);
		contentPane.add(lblNewLabel);
		
		JPanel pnl = new JPanel();
		pnl.setBounds(99, 163, 396, 451);
		contentPane.add(pnl);
		
		JPanel panel_1 = new JPanel();
		pnl.add(panel_1);
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.setBounds(175, 664, 217, 48);
		contentPane.add(btnNewButton);
	}

}
