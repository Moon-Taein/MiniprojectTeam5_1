package frame;

import javax.swing.JPanel;

import img.RoundButton;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import repo.MainOrder;
import repo.OrderRepo;

public class BuyList extends JPanel {
	OrderRepo order;
	private JPanel[] pnls;
	private JLabel[] ids;
	private JLabel[] nums;
	private JLabel[] dates;
	private JLabel[] times;
	private JLabel[] prices;
	private JButton[] checks;
	private List<MainOrder> mainOrders;
	private int size;
	private JLabel background;
	private JLabel dots;

	public BuyList() {
		order = new OrderRepo();
		initialize();
	}

	public void initialize() {
		setLayout(null);
		setBounds(0, 0, 750, 800);
		ImageIcon frame = new ImageIcon("GreatPizza/img//order.png");
		background = new JLabel(frame);
		background.setBounds(0, 0, 750, 800);
		add(background);
		
		pnls = new JPanel[4];
		nums = new JLabel[4];
		ids = new JLabel[4];
		dates = new JLabel[4];
		times = new JLabel[4];
		prices = new JLabel[4];
		checks = new JButton[4];

		mainOrders = order.getMainOrders("미확인");
		size = Math.min(mainOrders.size(), 4);

		for (int i = 0; i < size; i++) {
			pnls[i] = new JPanel();
			pnls[i].setBounds(50, 75 + (i*165), 630, 150);
			background.add(pnls[i]);
			pnls[i].setLayout(null);
			pnls[i].setOpaque(false);
			
			checks[i] = new RoundButton("미확인");
			checks[i].setBackground(Color.decode("#171821"));
			checks[i].setForeground(Color.decode("#FFFFFF"));
			checks[i].setFont(new Font("굴림", Font.PLAIN, 12));
			checks[i].setBounds(521, 62, 97, 23);
			pnls[i].add(checks[i]);
			
			nums[i] = new JLabel("No.0"+(1+i));
			nums[i].setFont(new Font("굴림", Font.BOLD, 15));
			nums[i].setBounds(45, 31, 84, 21);
			nums[i].setForeground(Color.WHITE);
			pnls[i].add(nums[i]);

			ids[i] = new JLabel();
			ids[i].setFont(new Font("굴림", Font.BOLD, 22));
			ids[i].setBounds(44, 54, 193, 35);
			ids[i].setForeground(Color.WHITE);
			pnls[i].add(ids[i]);

			dates[i] = new JLabel();
			dates[i].setFont(new Font("굴림", Font.BOLD, 15));
			dates[i].setBounds(44, 93, 84, 21);
			dates[i].setForeground(Color.WHITE);
			pnls[i].add(dates[i]);

			times[i] = new JLabel();
			times[i].setFont(new Font("굴림", Font.BOLD, 15));
			times[i].setBounds(140, 93, 84, 21);
			times[i].setForeground(Color.WHITE);
			pnls[i].add(times[i]);

			prices[i] = new JLabel();
			prices[i].setFont(new Font("굴림", Font.BOLD, 15));
			prices[i].setBounds(407, 63, 84, 21);
			prices[i].setForeground(Color.WHITE);
			pnls[i].add(prices[i]);
		}
		setTexts();
		
		dots = new JLabel(new ImageIcon("GreatPizza/img//reset2.png"));
		dots.setBounds(680, 10, 50, 50);
		dots.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				removeAll();
				repaint();
				initialize();
				revalidate();
			}
			@Override
			public void mousePressed(MouseEvent e) {
			}
			@Override
			public void mouseReleased(MouseEvent e) {
			}
			@Override
			public void mouseEntered(MouseEvent e) {
				// 여기서 바꿔주려고 했는데!!
				dots = new JLabel(new ImageIcon("GreatPizza/img//reset.png"));
			}
			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		background.add(dots);
	}

	public void setTexts() {
		for (int i = 0; i < size; i++) {
			final MainOrder currentOrder = mainOrders.get(i);
			if (currentOrder != null) {
				String id = currentOrder.getDate().replace("-", "") + currentOrder.getNo();
				ids[i].setText(id);
				dates[i].setText(currentOrder.getDate());
				times[i].setText(currentOrder.getTime());
				prices[i].setText(String.valueOf(currentOrder.getTotalprice())+"원");
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
