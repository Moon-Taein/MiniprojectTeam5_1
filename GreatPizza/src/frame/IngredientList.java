package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.plaf.basic.BasicScrollBarUI;

import img.RoundButton;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.SwingConstants;

import repo.Ingredient;
import repo.OrderRepo;

import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import java.awt.Component;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class IngredientList extends JPanel {
	private JLabel lbltype;
	private OrderRepo order;
	private JPanel pnlinven;
	private JLabel background;
	private JTextField textField;
	public Color blackcolor = Color.decode("#171821");
	public Color graycolor = Color.decode("#21222D");
	private JPanel panel;
	private JScrollPane scrollPane;

	public IngredientList() {
		initialize();
	}
	
	public void initialize() {
		order = new OrderRepo();
		setBounds(0, 0, 750, 800);
		setLayout(null);
		
		ImageIcon frame = new ImageIcon("GreatPizza/img//ingredient.png");
		background = new JLabel(frame);
		background.setBounds(0, 0, 750, 800);
		add(background);
		
		pnlinven = new JPanel();
		pnlinven.setBounds(80, 172, 590, 490);
		pnlinven.setOpaque(false);
		background.add(pnlinven);
		pnlinven.setLayout(null);
		
		RoundButton btnNewButton = new RoundButton("재료추가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				IngredientPlus plus = new IngredientPlus(IngredientList.this);
				plus.setVisible(true);
			}
		});
		btnNewButton.setOpaque(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setBounds(270, 670, 200, 50);
		background.add(btnNewButton);
		
		List<Ingredient> ingredients = order.getIngredients();
		setting(ingredients);
		
		textField = new JTextField();
		textField.setBounds(120, 60, 423, 44);
		textField.setOpaque(false);
		textField.setBorder(null);
		textField.setForeground(Color.WHITE);
		textField.registerKeyboardAction(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	List<Ingredient> ingredients = order.findIngredients(textField.getText());
		    	pnlinven.removeAll();
		    	pnlinven.repaint();
		    	pnlinven.revalidate();
		    	setting(ingredients);
		    }
		}, null, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		background.add(textField);
		textField.setColumns(10);
	}
	
	public void setting(List<Ingredient> ingredients) {
		panel = new JPanel();
		panel.setBackground(graycolor);
		panel.setFocusTraversalPolicyProvider(true);
		panel.setLayout(new GridLayout(ingredients.size(), 1)); 
		for(int i = 0; i < ingredients.size(); i++) {
			Ingredient ingredient = ingredients.get(i);
			JPanel pnl1 = new JPanel();
			pnl1.setLayout(null);
			pnl1.setPreferredSize(new Dimension(500, 50));
			pnl1.setOpaque(false);
			
			JLabel lbl1 = new JLabel(ingredient.getName());
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1.setFont(new Font("굴림", Font.PLAIN, 15));
			lbl1.setBounds(15, 0, 151, 30);
			lbl1.setForeground(Color.WHITE);
			pnl1.add(lbl1);
			
			JLabel lbl2 = new JLabel(ingredient.getType());
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setFont(new Font("굴림", Font.PLAIN, 15));
			lbl2.setBounds(175, 0, 97, 30);
			lbl2.setForeground(Color.WHITE);
			pnl1.add(lbl2);
			
			JLabel lbl3 = new JLabel(String.valueOf(ingredient.getCurrentCount()));
			lbl3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3.setFont(new Font("굴림", Font.PLAIN, 15));
			lbl3.setBounds(305, 0, 103, 30);
			lbl3.setForeground(Color.WHITE);
			pnl1.add(lbl3);
			
			RoundButton btnbuy = new RoundButton("확인");
			btnbuy.setBounds(460, 6, 80, 23);
			
			btnbuy.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					IngredientBuy pop = new IngredientBuy(ingredient, IngredientList.this);
					pop.setVisible(true);
				}
			});
			pnl1.add(btnbuy);
			if (ingredient.getLowerLimitCount() > ingredient.getCurrentCount()) {
				btnbuy.setBackground(Color.decode("#F2C8ED"));
			}
			panel.add(pnl1);
		}		
		scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setSize(590, 490);
		scrollPane.setBorder(null);
		pnlinven.add(scrollPane);
	}
}

