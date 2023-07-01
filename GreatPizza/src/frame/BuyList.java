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
	private int size;

	public BuyList() {
		order = new OrderRepo();
		initialize();
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
						BuyListPopup popUp = new BuyListPopup(currentOrder, BuyList.this);
						popUp.setVisible(true);
					}
				});
			}
		}
	}
}
