package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;

import repo.Ingredient;
import repo.OrderRepo;

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;

public class InventoryList extends JPanel {
	private JLabel lbltype;
	private JTextField name;
	private JTextField priceRetail;
	private JTextField priceSupply;
	private JTextField lowerCount;
	private OrderRepo order;
	private JPanel pnlinven;

	public InventoryList() {
		order = new OrderRepo();
		setting();
	}
	
	public void setting() {
		setBounds(0, 0, 750, 800);
		setLayout(null);
		
		pnlinven = new JPanel();
		pnlinven.setBounds(68, 42, 600, 450);
		add(pnlinven);
		pnlinven.setLayout(null);
		
		JPanel pnlPlus = new JPanel();
		pnlPlus.setBounds(68, 502, 550, 250);
		add(pnlPlus);
		pnlPlus.setLayout(null);
		
		JLabel l1 = new JLabel("이름");
		l1.setFont(new Font("굴림", Font.BOLD, 20));
		l1.setBounds(50, 44, 80, 24);
		pnlPlus.add(l1);
		
		name = new JTextField();
		name.setBounds(174, 44, 160, 24);
		pnlPlus.add(name);
		name.setColumns(10);
		
		priceRetail = new JTextField();
		priceRetail.setColumns(10);
		priceRetail.setBounds(174, 86, 160, 24);
		pnlPlus.add(priceRetail);
		
		JLabel l1_1 = new JLabel("소비자가");
		l1_1.setFont(new Font("굴림", Font.BOLD, 20));
		l1_1.setBounds(50, 86, 90, 24);
		pnlPlus.add(l1_1);
		
		priceSupply = new JTextField();
		priceSupply.setColumns(10);
		priceSupply.setBounds(174, 130, 160, 24);
		pnlPlus.add(priceSupply);
		
		JLabel l1_2 = new JLabel("공급가");
		l1_2.setFont(new Font("굴림", Font.BOLD, 20));
		l1_2.setBounds(50, 130, 90, 24);
		pnlPlus.add(l1_2);
		
		lowerCount = new JTextField();
		lowerCount.setColumns(10);
		lowerCount.setBounds(174, 173, 160, 24);
		pnlPlus.add(lowerCount);
		
		JLabel l1_3 = new JLabel("재료하한선");
		l1_3.setFont(new Font("굴림", Font.BOLD, 20));
		l1_3.setBounds(50, 173, 112, 24);
		pnlPlus.add(l1_3);
		
		final JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"소스", "토핑", "엣지"}));
		comboBox.setBounds(378, 44, 112, 21);
		pnlPlus.add(comboBox);
		
		JButton btninput = new JButton("재료추가");
		btninput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) comboBox.getSelectedItem();
				order.insertIngredient(
						name.getText(), priceRetail.getText(), priceSupply.getText(),
						lowerCount.getText(), type);
				removeAll();
				repaint();
				setting();
				revalidate();
			}
		});
		btninput.setBounds(393, 173, 97, 23);
		pnlPlus.add(btninput);
		
		JButton btnNewButton = new JButton("새로고침");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				removeAll();
				repaint();
				setting();
				revalidate();
			}
		});
		btnNewButton.setBounds(270, 803, 97, 23);
		add(btnNewButton);
		JPanel pnltitle = new JPanel();
		pnltitle.setBackground(Color.LIGHT_GRAY);
		pnltitle.setBounds(0, 44, 600, 1);
		pnlinven.add(pnltitle);
		pnltitle.setLayout(null);
		
		JLabel lblnow = new JLabel("현재재고");
		lblnow.setBounds(316, 9, 112, 25);
		pnlinven.add(lblnow);
		lblnow.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		JLabel lblprice = new JLabel("구매");
		lblprice.setBounds(494, 9, 54, 25);
		pnlinven.add(lblprice);
		lblprice.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		lbltype = new JLabel("분류");
		lbltype.setBounds(192, 9, 67, 25);
		pnlinven.add(lbltype);
		lbltype.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		JLabel lblname = new JLabel("이름");
		lblname.setBounds(48, 9, 67, 25);
		pnlinven.add(lblname);
		lblname.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		
		List<Ingredient> ingredients = order.getIngredients();
		JPanel panel = new JPanel();
		panel.setFocusTraversalPolicyProvider(true);
		panel.setLayout(new GridLayout(ingredients.size(), 1)); 
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		for(int i = 0; i < ingredients.size(); i++) {
			final Ingredient ingredient = ingredients.get(i);
			JPanel pnl1 = new JPanel();
			panel.add(pnl1);
			pnl1.setLayout(null);
			pnl1.setPreferredSize(new Dimension(500, 50));
			
			JLabel lbl1 = new JLabel(ingredient.getName());
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1.setFont(new Font("굴림", Font.PLAIN, 19));
			lbl1.setBounds(0, 0, 151, 30);
			pnl1.add(lbl1);
			
			JLabel lbl2 = new JLabel(ingredient.getType());
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setFont(new Font("굴림", Font.PLAIN, 19));
			lbl2.setBounds(154, 0, 97, 30);
			pnl1.add(lbl2);
			
			JLabel lbl3 = new JLabel(String.valueOf(ingredient.getCurrentCount()));
			lbl3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3.setFont(new Font("굴림", Font.PLAIN, 19));
			lbl3.setBounds(288, 0, 103, 30);
			pnl1.add(lbl3);
			
			JButton btnbuy = new JButton("확인");
			btnbuy.setBounds(433, 6, 80, 23);
			
			btnbuy.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InventoryPlus pop = new InventoryPlus(ingredient);
					pop.setVisible(true);
				}
			});
			pnl1.add(btnbuy);
			scrollPane.setBounds(0, 45, 600, 405);
			scrollPane.setBorder(null);
			pnlinven.add(scrollPane);
		}		
	}
}

