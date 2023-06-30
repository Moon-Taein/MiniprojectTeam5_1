package frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import repo.OrderRepo;

public class SalesList extends JPanel {

	private JPanel cards;
	protected CardLayout cl_cards;
	private JLabel todaytotal;
	private OrderRepo order;

	public SalesList() {
		order = new OrderRepo();
		LocalDate today = LocalDate.now();
	    String day = today.format(DateTimeFormatter.ofPattern("yyyy-M-d"));
	    order.plusDay(day);
	    
		Map<Integer, List<String>> bestMonth = order.bestMonth(String.valueOf(today.getYear()));
		Map<Integer, List<String>> bests = order.bestMenu();
		
		setSize(new Dimension(750, 800));
		setLayout(null);

		cards = new JPanel();
		cards.setBounds(0, 85, 750, 815);
		add(cards);
		cards.setLayout(new CardLayout(0, 0));

		JPanel datepage = new JPanel();
		datepage.setBackground(Color.GRAY);
		cards.add(datepage, "ccp1");
		datepage.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(421, 69, 274, 262);
		datepage.add(panel);
		panel.setLayout(null);
		
		todaytotal = new JLabel("오늘의 매출");
		todaytotal.setFont(new Font("굴림", Font.BOLD, 25));
		todaytotal.setBounds(70, 28, 134, 37);
		panel.add(todaytotal);
		
		JLabel total = new JLabel(order.todaySales(day) + "원");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setFont(new Font("굴림", Font.BOLD, 20));
		total.setBounds(0, 75, 281, 47);
		panel.add(total);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(66, 341, 629, 306);
		datepage.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel week = new JLabel("요일별 매출");
		week.setHorizontalAlignment(SwingConstants.CENTER);
		week.setBounds(252, 22, 128, 33);
		panel_1.add(week);

		JPanel monthpage = new JPanel();
		monthpage.setBackground(Color.PINK);
		cards.add(monthpage, "ccp2");
		monthpage.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(76, 82, 584, 289);
		monthpage.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel bestMenu = new JLabel("많이팔린메뉴");
		bestMenu.setFont(new Font("굴림", Font.PLAIN, 20));
		bestMenu.setHorizontalAlignment(SwingConstants.CENTER);
		bestMenu.setBounds(230, 10, 128, 47);
		panel_2.add(bestMenu);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(76, 381, 584, 274);
		monthpage.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel month = new JLabel("월매출 순위");
		month.setHorizontalAlignment(SwingConstants.CENTER);
		month.setFont(new Font("굴림", Font.PLAIN, 20));
		month.setBounds(227, 10, 128, 47);
		panel_3.add(month);

		for (int i = 1; i <= 5; i++) {
			if (bests.get(i) != null) {
				JLabel first = new JLabel(i + "위 " + bests.get(i).get(0) + " " + bests.get(i).get(1)+ "개");
				first.setFont(new Font("굴림", Font.PLAIN, 15));
				first.setBounds(180, 60 + 30*(i-1), 300, 27);
				panel_2.add(first);
			}
		}
		
		for (int i = 1; i <= 5; i++) {
			if (bestMonth.get(i) != null) {
				JLabel first = new JLabel(i + "위 " + bestMonth.get(i).get(0) + "월 " + bestMonth.get(i).get(1)+ "원");
				first.setFont(new Font("굴림", Font.PLAIN, 15));
				first.setBounds(180, 60 + 30*(i-1), 300, 27);
				panel_3.add(first);
			}
		}

		JButton btndate = new JButton("일 별");
		btndate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cards.show(cards, "ccp1");
			}
		});
		btndate.setBounds(0, 45, 130, 41);
		add(btndate);
		
		JButton btnmonth = new JButton("월 별");
		btnmonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cards.show(cards, "ccp2");
			}
		});
		btnmonth.setBounds(131, 45, 130, 41);
		add(btnmonth);
		
		cl_cards = (CardLayout) cards.getLayout();
	}
}
