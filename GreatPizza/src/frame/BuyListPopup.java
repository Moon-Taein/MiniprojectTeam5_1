package frame;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.Color;
import javax.swing.BoxLayout;

public class BuyListPopup extends JFrame {

	private JPanel contentPane;
	/**
	 * Create the frame.
	 */
	public BuyListPopup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel menu = new JPanel();
		menu.setBounds(70, 57, 345, 577);
		contentPane.add(menu);
		menu.setLayout(null);
		
		JPanel inventory = new JPanel();
		inventory.setBounds(468, 57, 345, 464);
		contentPane.add(inventory);
		inventory.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(0, 0, 345, 50);
		inventory.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("재료확인");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		panel_1.add(lblNewLabel);
		
		JScrollPane scrollPane_1 = new JScrollPane((Component) null);
		scrollPane_1.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane_1.setBounds(0, 50, 345, 414);
		inventory.add(scrollPane_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(new BoxLayout(panel_2, BoxLayout.Y_AXIS));
		scrollPane_1.setViewportView(panel_2);
		
		for (int i= 0; i < 20; i ++) {
			JLabel lblNewLabel_1 = new JLabel("도우 - 9999개");
			lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 20));
			panel_2.add(lblNewLabel_1);
		}
		
		JButton btncancel = new JButton("주문 취소");
		btncancel.setFont(new Font("굴림", Font.BOLD, 25));
		btncancel.setBounds(468, 560, 345, 50);
		contentPane.add(btncancel);
		
		JButton btn = new JButton("피자 제작 완료");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		btn.setFont(new Font("굴림", Font.BOLD, 25));
		btn.setBounds(468, 631, 345, 50);
		contentPane.add(btn);
		
		JPanel panel = new JPanel();
		panel.setFocusTraversalPolicyProvider(true);
		panel.setLayout(new GridLayout(20, 1)); 
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		JPanel pnl1 = new JPanel();
		panel.add(pnl1);
		pnl1.setLayout(null);
		pnl1.setPreferredSize(new Dimension(300, 50));
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("불고기 피자");
		rdbtnNewRadioButton.setFont(new Font("굴림", Font.BOLD, 20));
		rdbtnNewRadioButton.setBounds(0, 0, 326, 50);
		pnl1.add(rdbtnNewRadioButton);
		scrollPane.setBounds(0, 0, 345, 578);
		menu.add(scrollPane);
	
		
	}
}
