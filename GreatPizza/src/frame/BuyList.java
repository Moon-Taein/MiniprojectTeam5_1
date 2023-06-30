package frame;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import repo.MainOrder;
import repo.OrderRepo;

public class BuyList extends JPanel {
	OrderRepo order;
	private JPanel[] pnls;
	private JLabel[] ids;
	private JLabel[] dates;
	private JLabel[] times;
	private JLabel[] prices;
	private JButton[] checks;
	private List<MainOrder> mainOrders;
	private JButton allCheck;
	private int size;

	public BuyList() {
		order = new OrderRepo();
		initialize();
		JPanel pnl = new JPanel();
		pnl.setBounds(50, 75, 630, 150);
		add(pnl);
		pnl.setLayout(null);
		
		JButton btnNewButton = new JButton("미확인 주문");
		btnNewButton.setBounds(521, 62, 97, 23);
		pnl.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("15,000원");
		lblNewLabel.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel.setBounds(407, 63, 84, 21);
		pnl.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("2023063001");
		lblNewLabel_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 93, 84, 21);
		pnl.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("불고기 피자 외 2건");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 54, 193, 35);
		pnl.add(lblNewLabel_2);
		
		JLabel lblNo = new JLabel("no.1");
		lblNo.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNo.setBounds(45, 31, 84, 21);
		pnl.add(lblNo);
		
		JLabel lblNewLabel_1_1 = new JLabel("12:30");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(140, 93, 84, 21);
		pnl.add(lblNewLabel_1_1);
	}

	public void setTexts() {
		for (int i = 0; i < size; i++) {
			final MainOrder currentOrder = mainOrders.get(i);
			if (currentOrder != null) {
				String id = currentOrder.getDate().replace("-", "") + currentOrder.getNo();
				ids[i].setText(id);
				dates[i].setText(currentOrder.getDate());
				times[i].setText(currentOrder.getTime());
				prices[i].setText(String.valueOf(currentOrder.getTotalprice()));
				checks[i].setText(currentOrder.getState());
				checks[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BuyListPopup popUp = new BuyListPopup(currentOrder);
						popUp.setVisible(true);
					}
				});
			}
		}
	}

	public void initialize() {
		setLayout(null);
		setBounds(0, 0, 750, 800);
		pnls = new JPanel[4];
		ids = new JLabel[4];
		dates = new JLabel[4];
		times = new JLabel[4];
		prices = new JLabel[4];
		checks = new JButton[4];

		mainOrders = order.getMainOrders("미확인");
		size = Math.min(mainOrders.size(), 4);

		for (int i = 0; i < 4; i++) {
			pnls[i] = new JPanel();
			pnls[i].setBounds(50, 75 + (i*165), 630, 150);
			add(pnls[i]);
			pnls[i].setLayout(null);

			checks[i] = new JButton();
			checks[i].setBounds(521, 62, 97, 23);
			pnls[i].add(checks[i]);

			ids[i] = new JLabel();
			ids[i].setFont(new Font("굴림", Font.BOLD, 20));
			ids[i].setBounds(44, 54, 193, 35);
			pnls[i].add(ids[i]);

			dates[i] = new JLabel();
			dates[i].setFont(new Font("굴림", Font.PLAIN, 15));
			dates[i].setBounds(45, 31, 84, 21);
			pnls[i].add(dates[i]);

			times[i] = new JLabel();
			times[i].setFont(new Font("굴림", Font.PLAIN, 15));
			times[i].setBounds(44, 93, 84, 21);
			pnls[i].add(times[i]);

			prices[i] = new JLabel();
			prices[i].setFont(new Font("굴림", Font.BOLD, 15));
			prices[i].setBounds(407, 63, 84, 21);
			pnls[i].add(prices[i]);
		}
		setTexts();

		allCheck = new JButton("새로고침");
		allCheck.setBounds(641, 10, 97, 23);
		allCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				removeAll();
				repaint();
				initialize();
			}
		});
		add(allCheck);
	}
}
