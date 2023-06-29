package frame;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import repo.DetailOrder;
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
	}

	public void setTexts() {
		for (int i = 0; i < size; i++) {
			final MainOrder currentOrder = mainOrders.get(i);
			if (currentOrder != null) {
				ids[i].setText(currentOrder.getDate() + "0" + currentOrder.getNo());
				dates[i].setText(currentOrder.getDate());
				times[i].setText(currentOrder.getTime());
				prices[i].setText(String.valueOf(currentOrder.getTotalprice()));
				checks[i].setText(currentOrder.getState());
				checks[i].addActionListener(new ActionListener() {
					@Override
					public void actionPerformed(ActionEvent e) {
						BuyListPopup popUp = new BuyListPopup(currentOrder.getNo());
						popUp.setVisible(true);
					}
				});
			}
		}
	}

	public void initialize() {
		setLayout(null);
		setBounds(0, 0, 650, 900);
		pnls = new JPanel[4];
		ids = new JLabel[4];
		dates = new JLabel[4];
		times = new JLabel[4];
		prices = new JLabel[4];
		checks = new JButton[4];

		mainOrders = order.getMainOrders("미확인");
		size = Math.min(mainOrders.size(), 4);

		for (int i = 0; i < size; i++) {
			pnls[i] = new JPanel();
			pnls[i].setBounds(74, 111 + (170 * i), 500, 150);
			add(pnls[i]);
			pnls[i].setLayout(null);

			checks[i] = new JButton();
			checks[i].setBounds(413, 65, 75, 23);
			pnls[i].add(checks[i]);

			ids[i] = new JLabel();
			ids[i].setFont(new Font("굴림", Font.BOLD, 30));
			ids[i].setBounds(40, 65, 190, 50);
			pnls[i].add(ids[i]);

			dates[i] = new JLabel();
			dates[i].setFont(new Font("굴림", Font.PLAIN, 25));
			dates[i].setBounds(40, 16, 118, 29);
			pnls[i].add(dates[i]);

			times[i] = new JLabel();
			times[i].setFont(new Font("굴림", Font.PLAIN, 25));
			times[i].setBounds(162, 16, 118, 29);
			pnls[i].add(times[i]);

			prices[i] = new JLabel();
			prices[i].setFont(new Font("굴림", Font.BOLD, 25));
			prices[i].setBounds(260, 65, 146, 50);
			pnls[i].add(prices[i]);
		}
		setTexts();

		allCheck = new JButton("새로고침");
		allCheck.setBounds(477, 45, 97, 23);
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
