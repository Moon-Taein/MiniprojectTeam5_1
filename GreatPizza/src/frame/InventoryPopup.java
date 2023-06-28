package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import repo.Ingredient;
import repo.OrderRepo;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;

public class InventoryPopup extends JFrame {

	private JPanel contentPane;
	private OrderRepo order;

	public InventoryPopup() {
		order = new OrderRepo();
		List<Ingredient> ingredients = order.getIngredients();
		
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
		
		for (int i = 0; i < ingredients.size(); i++) {
		    Ingredient ingredient = ingredients.get(i);
		    if (ingredient.getLowerLimitCount() > ingredient.getCurrentCount()) {
		        JPanel pnl1 = new JPanel();
		        panel1.add(pnl1);

		        JLabel lbl = new JLabel(ingredient.getName());
		        lbl.setFont(new Font("굴림", Font.BOLD, 25));
		        pnl1.add(lbl);

		        JLabel lblN = new JLabel("-");
		        lblN.setFont(new Font("굴림", Font.BOLD, 25));
		        pnl1.add(lblN);

		        String current = String.valueOf(ingredient.getCurrentCount());
		        JLabel cnt = new JLabel(current + "개 있음");
		        cnt.setFont(new Font("굴림", Font.BOLD, 25));
		        pnl1.add(cnt);
		    }
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
