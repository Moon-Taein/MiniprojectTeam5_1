package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import repo.Ingredient;
import repo.OrderRepo;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;

public class IngredientBuy extends JFrame {

	private JPanel contentPane;
	private IngredientList invenFrame;
	private OrderRepo order;

	public IngredientBuy(Ingredient ingredient, IngredientList invenFrame) {
		LocalDate today = LocalDate.now();
	    String day = today.format(DateTimeFormatter.ofPattern("yyyy-M-d"));
		this.invenFrame = invenFrame;
		order = new OrderRepo();
		setBounds(100, 100, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("이 름 :");
		lblNewLabel.setBounds(105, 31, 63, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("공 급 가 :");
		lblNewLabel_1.setBounds(105, 83, 63, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("현재 개수 :");
		lblNewLabel_2.setBounds(105, 135, 63, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("재료 하한선 :");
		lblNewLabel_3.setBounds(105, 187, 94, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel name = new JLabel(ingredient.getName());
		name.setBounds(149, 31, 63, 42);
		contentPane.add(name);
		
		JLabel price = new JLabel(String.valueOf(ingredient.getPriceRetail()));
		price.setBounds(166, 83, 63, 42);
		contentPane.add(price);
		
		JLabel current = new JLabel(String.valueOf(ingredient.getCurrentCount()));
		current.setBounds(176, 135, 63, 42);
		contentPane.add(current);
		
		JLabel little = new JLabel(String.valueOf(ingredient.getLowerLimitCount()));
		little.setBounds(186, 187, 63, 42);
		contentPane.add(little);
		
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new Integer[] {10, 20, 30, 40, 50, 60, 100}));
		comboBox.setBounds(346, 31, 169, 55);
		contentPane.add(comboBox);
		
		JButton buy = new JButton("구 매");
		buy.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        int plus = (Integer) comboBox.getSelectedItem();
		        int money = ingredient.getPriceSupply()*plus;
		        order.minusAccount(money, day);
		        order.plusIngredient(plus, ingredient.getId());
		        invenFrame.removeAll();
		        invenFrame.repaint();
		        invenFrame.initialize();
		        invenFrame.revalidate();
		        setVisible(false);
		    }
		});

		buy.setBounds(346, 187, 169, 32);
		contentPane.add(buy);
		
		JButton delete = new JButton("삭제");
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        order.deleteIngredient(ingredient.getId());
		        invenFrame.removeAll();
		        invenFrame.repaint();
		        invenFrame.initialize();
		        invenFrame.revalidate();
		        setVisible(false);
		    }
		});
		delete.setBounds(12, 10, 97, 23);
		contentPane.add(delete);
	}
}
