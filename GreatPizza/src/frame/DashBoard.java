package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import repo.Ingredient;
import repo.MainOrder;
import repo.OrderRepo;
import utilty.PieChart;
import java.awt.Font;
import javax.swing.SwingConstants;

public class DashBoard extends JPanel {

	private JLabel background;
	private JTextField text;
	private JLabel total;
	private JLabel buy;
	private JLabel cancel;
	private JLabel fir;
	private JLabel sec;
	private JLabel thr;
	private JLabel fou;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_2;
	private OrderRepo order;
	private String day;

	public DashBoard(HomeFrame home) {
		order = new OrderRepo();
		LocalDate today = LocalDate.now();
		day = today.format(DateTimeFormatter.ofPattern("yyyy-M-d"));

		setLayout(null);
		setSize(750, 800);
		ImageIcon frame = new ImageIcon("GreatPizza/img//dashboard.png");
		background = new JLabel(frame);
		background.setBounds(0, 0, 750, 800);
		add(background);

		PieChart pieChart = new PieChart();
		pieChart.setBounds(468, 108, 200, 200);
		background.add(pieChart);

		text = new JTextField();
		text.setBounds(100, 37, 423, 44);
		text.setOpaque(false);
		text.setBorder(null);
		text.setForeground(Color.WHITE);
		text.registerKeyboardAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String line = text.getText();
				if (line.contains("오늘") || line.contains("매출") || line.contains("일") || line.contains("판매")
						|| line.contains("많이") || line.contains("팔린")) {
					home.salesbtn.doClick();
				} else if (line.contains("주문") || line.contains("미확인")) {
					home.buybtn.doClick();
				} else if (line.contains("재고") || line.contains("재료")) {
					home.inventorybtn.doClick();
				} else if (line.contains("메뉴") || line.contains("피자")) {
					home.menubtn.doClick();
				} else if (line.contains("재정") || line.contains("매입") || line.contains("년") || line.contains("날짜")) {
					home.financialbtn.doClick();
				}
			}
		}, null, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		background.add(text);
		text.setColumns(10);

		total = new JLabel("100만");
		total.setForeground(Color.WHITE);
		total.setBounds(100, 232, 57, 15);
		background.add(total);

		buy = new JLabel("20개");
		buy.setForeground(Color.WHITE);
		buy.setBounds(210, 232, 57, 15);
		background.add(buy);

		cancel = new JLabel("1개");
		cancel.setBounds(334, 232, 57, 15);
		cancel.setForeground(Color.WHITE);
		background.add(cancel);

		fir = new JLabel("불고기");
		fir.setFont(new Font("굴림", Font.BOLD, 15));
		fir.setBounds(159, 429, 300, 15);
		fir.setForeground(Color.WHITE);
		background.add(fir);

		sec = new JLabel("불고기");
		sec.setFont(new Font("굴림", Font.BOLD, 15));
		sec.setBounds(159, 472, 300, 15);
		sec.setForeground(Color.WHITE);
		background.add(sec);

		thr = new JLabel("불고기");
		thr.setFont(new Font("굴림", Font.BOLD, 15));
		thr.setBounds(159, 516, 300, 15);
		thr.setForeground(Color.WHITE);
		background.add(thr);

		fou = new JLabel("불고기");
		fou.setFont(new Font("굴림", Font.BOLD, 15));
		fou.setBounds(159, 560, 300, 15);
		fou.setForeground(Color.WHITE);
		background.add(fou);

		lblNewLabel = new JLabel("2023070501");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		lblNewLabel.setBounds(120, 672, 300, 40);
		lblNewLabel.setForeground(Color.WHITE);
		background.add(lblNewLabel);

		lblNewLabel_2 = new JLabel("No.1");
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setBounds(122, 652, 57, 15);
		lblNewLabel_2.setForeground(Color.WHITE);
		background.add(lblNewLabel_2);

		setting();
	}

	public void setting() {
		Map<Integer, List<String>> bests = order.bestMenu();
		String todaySale = order.todaySales(day);
		if (todaySale.length() > 4) {
			total.setText(todaySale.substring(0, todaySale.length() - 4) + "만");
		} else {
			total.setText(todaySale + "원");
		}
		buy.setText(order.soldtoday(day, "확인") + "개");
		cancel.setText(order.soldtoday(day, "취소") + "개");
		fir.setText(bests.get(1).get(0));
		sec.setText(bests.get(2).get(0));
		thr.setText(bests.get(3).get(0));
		fou.setText(bests.get(4).get(0));

		for (int i = 1; i <= 4; i++) {
			JLabel f = new JLabel(bests.get(i).get(1));
			f.setHorizontalAlignment(SwingConstants.CENTER);
			f.setBounds(605, 429 + ((i - 1) * 43), 54, 15);
			f.setForeground(Color.WHITE);
			background.add(f);
		}

		List<MainOrder> mainOrders = order.getMainOrders("미확인");
		if (mainOrders != null) {
			lblNewLabel.setText(mainOrders.get(0).getDate().replace("-", "") + mainOrders.get(0).getNo());
		}
	}
}
