package frame;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JButton;

public class MenuPopup2 extends JFrame {

	private JPanel contentPane;
	private JTextField textField_1;

	public MenuPopup2() {
		setBounds(100, 100, 247, 185);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("가 격 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 86, 32);
		contentPane.add(lblNewLabel_1);
		
		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.CENTER);
		textField_1.setColumns(10);
		textField_1.setBounds(82, 11, 120, 32);
		contentPane.add(textField_1);
		
		JButton btnNewButton = new JButton("변 경 하 기");
		btnNewButton.setBounds(105, 47, 97, 32);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("메뉴 삭제");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 89, 86, 38);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("삭 제 하 힉");
		btnNewButton_1.setBounds(105, 92, 97, 32);
		contentPane.add(btnNewButton_1);
		
		setVisible(true);
	}
}
