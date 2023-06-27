package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class InventoryPlus extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InventoryPlus frame = new InventoryPlus();
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
	public InventoryPlus() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이 름 :");
		lblNewLabel.setBounds(63, 31, 63, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("공 급 가 :");
		lblNewLabel_1.setBounds(63, 83, 63, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("현재 개수 :");
		lblNewLabel_2.setBounds(63, 135, 63, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("재료 하한선 :");
		lblNewLabel_3.setBounds(63, 187, 94, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_3_1 = new JLabel("숫자(개)");
		lblNewLabel_3_1.setBounds(144, 187, 63, 42);
		contentPane.add(lblNewLabel_3_1);
		
		JLabel lblNewLabel_3_2 = new JLabel("숫자(개)");
		lblNewLabel_3_2.setBounds(134, 135, 63, 42);
		contentPane.add(lblNewLabel_3_2);
		
		JLabel lblNewLabel_3_3 = new JLabel("금 액 (원)");
		lblNewLabel_3_3.setBounds(124, 83, 63, 42);
		contentPane.add(lblNewLabel_3_3);
		
		JLabel lblNewLabel_3_4 = new JLabel("이 름");
		lblNewLabel_3_4.setBounds(107, 31, 63, 42);
		contentPane.add(lblNewLabel_3_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(346, 51, 169, 55);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("구 매");
		btnNewButton.setBounds(418, 171, 97, 32);
		contentPane.add(btnNewButton);
	}
}
