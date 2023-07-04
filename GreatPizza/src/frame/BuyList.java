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
import java.util.Timer;
import java.util.TimerTask;

import repo.MainOrder;
import repo.OrderRepo;
import repo.PosRepo;

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
	public static final Color mintcolor = Color.decode("#A9DFD8");
	private int size;
	private JLabel background;
	private JLabel dots;
	int lastMainOrder;
	private JPanel issue;

	public BuyList() {
		order = new OrderRepo();
		initialize();
	}

	public void initialize() {
		setLayout(null);
		setBounds(0, 0, 750, 800);
		ImageIcon frame = new ImageIcon(getClass().getResource("/order.png"));
		
		background = new JLabel(frame);
		background.setBounds(0, 0, 750, 800);
		add(background);
		
		issue = new JPanel();
		issue.setBounds(380, 20, 280, 27);
		JLabel lbl = new JLabel("주문이 들어왔습니다.");
		issue.add(lbl);
		issue.setBackground(mintcolor);
		issue.setVisible(false);
		add(issue);
		
		lastMainOrder = order.lastOrder();
		Timer timer = new Timer();
		TimerTask dask = new TimerTask() {
			boolean visible = true;
			int count = 0;
			@Override
			public void run() {
				System.out.println(count);
				if (!(lastMainOrder == order.lastOrder())) {
					if (count == 0) {
						PosRepo.ballSound();
						issue.setVisible(visible);
						visible = !visible;
						count++;
					} else if (count < 5) {
						issue.setVisible(visible);
						visible = !visible;
						count++;
					} else if (count == 5){
						removeAll();
						repaint();
						initialize();
						revalidate();
						timer.cancel();
						this.cancel(); // TimerTask 중지
					} else {
						issue.setVisible(false);
						// 횟수가 완료되면 패널 숨김
						lastMainOrder++; // 전역 변수 값 증가
					}
				}
			}
		};
		timer.schedule(dask, 0, 500);
		
		
		pnls = new JPanel[4];
		nums = new JLabel[4];
		ids = new JLabel[4];
		dates = new JLabel[4];
		times = new JLabel[4];
		prices = new JLabel[4];
		checks = new JButton[4];

		mainOrders = order.getMainOrders("미확인");
		if(mainOrders != null) {
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
		}
		
		dots = new JLabel(new ImageIcon(getClass().getResource("/reset2.png")));
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
				dots = new JLabel(new ImageIcon(getClass().getResource("/reset.png")));
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
