package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import repo.Ingredient;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;

public class InventoryPlus extends JFrame {

	private JPanel contentPane;

	public InventoryPlus(Ingredient ingredient) {
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
		
		JLabel name = new JLabel(ingredient.getName());
		name.setBounds(107, 31, 63, 42);
		contentPane.add(name);
		
		JLabel price = new JLabel(String.valueOf(ingredient.getPriceRetail()));
		price.setBounds(124, 83, 63, 42);
		contentPane.add(price);
		
		JLabel current = new JLabel(String.valueOf(ingredient.getCurrentCount()));
		current.setBounds(134, 135, 63, 42);
		contentPane.add(current);
		
		JLabel little = new JLabel(String.valueOf(ingredient.getLowerLimitCount()));
		little.setBounds(144, 187, 63, 42);
		contentPane.add(little);
		
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(346, 51, 169, 55);
		contentPane.add(comboBox);
		
		JButton btnNewButton = new JButton("구 매");
		btnNewButton.setBounds(418, 171, 97, 32);
		contentPane.add(btnNewButton);
	}
}
