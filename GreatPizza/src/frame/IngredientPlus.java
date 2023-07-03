package frame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import repo.OrderRepo;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;

public class IngredientPlus extends JFrame {
	private JTextField name;
	private JTextField priceRetail;
	private JTextField priceSupply;
	private JTextField lowerCount;
	private OrderRepo order;

	public IngredientPlus(IngredientList ingredientList) {
		order = new OrderRepo();
		setLayout(null);
		setSize(750, 350);
		
		JPanel pnlPlus = new JPanel();
		pnlPlus.setSize(750, 300);
		pnlPlus.setLayout(null);
		add(pnlPlus);
		
		JLabel l1 = new JLabel("이름");
		l1.setFont(new Font("굴림", Font.BOLD, 20));
		l1.setBounds(50, 47, 80, 24);
		pnlPlus.add(l1);
		
		name = new JTextField();
		name.setColumns(10);
		name.setBounds(174, 47, 160, 24);
		pnlPlus.add(name);
		
		priceRetail = new JTextField();
		priceRetail.setColumns(10);
		priceRetail.setBounds(174, 99, 160, 24);
		pnlPlus.add(priceRetail);
		
		JLabel l1_1 = new JLabel("소비자가");
		l1_1.setFont(new Font("굴림", Font.BOLD, 20));
		l1_1.setBounds(50, 99, 90, 24);
		pnlPlus.add(l1_1);
		
		priceSupply = new JTextField();
		priceSupply.setColumns(10);
		priceSupply.setBounds(174, 154, 160, 24);
		pnlPlus.add(priceSupply);
		
		JLabel l1_2 = new JLabel("공급가");
		l1_2.setFont(new Font("굴림", Font.BOLD, 20));
		l1_2.setBounds(50, 154, 90, 24);
		pnlPlus.add(l1_2);
		
		lowerCount = new JTextField();
		lowerCount.setColumns(10);
		lowerCount.setBounds(174, 204, 160, 24);
		pnlPlus.add(lowerCount);
		
		JLabel l1_3 = new JLabel("재료하한선");
		l1_3.setFont(new Font("굴림", Font.BOLD, 20));
		l1_3.setBounds(50, 204, 112, 24);
		pnlPlus.add(l1_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"소스", "토핑", "엣지"}));
		comboBox.setBounds(619, 87, 97, 21);
		pnlPlus.add(comboBox);
		
		JButton btninput = new JButton("재료추가");
		btninput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) comboBox.getSelectedItem();
				order.insertIngredient(
						name.getText(), priceRetail.getText(), priceSupply.getText(),
						lowerCount.getText(), type);
				setVisible(false);
				ingredientList.removeAll();
				ingredientList.repaint();
				ingredientList.initialize();
				ingredientList.revalidate();
			}
		});
		btninput.setBounds(386, 231, 200, 39);
		pnlPlus.add(btninput);
		
		JButton image = new JButton("이미지");
		image.setBounds(619, 47, 97, 23);
		pnlPlus.add(image);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(386, 44, 200, 163);
		pnlPlus.add(panel_1);

	}
}
