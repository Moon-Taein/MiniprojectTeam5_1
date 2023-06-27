package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class InventoryPopup extends JFrame {

	private JPanel contentPane;

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
		
		JLabel lbltitle = new JLabel("현재 부족 재고");
		lbltitle.setFont(new Font("굴림", Font.BOLD, 35));
		lbltitle.setBounds(167, 76, 250, 77);
		contentPane.add(lbltitle);
		
		JPanel panel1 = new JPanel();
		panel1.setBounds(99, 163, 396, 451);
		contentPane.add(panel1);
		
		for (int i = 0; i < 5; i++) {
			JPanel pnl1 = new JPanel();
			panel1.add(pnl1);
			
			JLabel ingredient = new JLabel("치즈");
			ingredient.setFont(new Font("굴림", Font.BOLD, 25));
			pnl1.add(ingredient);
			
			JLabel lblNewLabel = new JLabel("-");
			lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
			pnl1.add(lblNewLabel);
			
			JLabel current_cnt = new JLabel("10개 구매");
			current_cnt.setFont(new Font("굴림", Font.BOLD, 25));
			pnl1.add(current_cnt);
		}
		
		JButton btnNewButton = new JButton("확인");
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(175, 664, 217, 48);
		contentPane.add(btnNewButton);
	}
}
