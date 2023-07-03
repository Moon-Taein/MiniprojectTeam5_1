package frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

import img.BorderButton;
import repo.MainOrder;
import repo.OrderRepo;

public class SalesList extends JPanel {

	private JPanel cards;
	protected CardLayout cl_cards;
	private OrderRepo order;
	public Color blackcolor = Color.decode("#171821");
	public Color graycolor = Color.decode("#21222D");
	public Color mintcolor = Color.decode("#A9DFD8");

	public SalesList() {
		initialize();
	}
	
	public void initialize() {
		order = new OrderRepo();
		LocalDate today = LocalDate.now();
	    String day = today.format(DateTimeFormatter.ofPattern("yyyy-M-d"));
	    order.plusDay(day);
	    
		Map<Integer, List<String>> bestMonth = order.bestMonth(String.valueOf(today.getYear()));
		Map<Integer, List<String>> bests = order.bestMenu();
		
		setSize(750, 800);
		setLayout(null);
		setBackground(blackcolor);
		
		cards = new JPanel();
		cards.setBounds(0, 0, 750, 900);
		add(cards);
		cards.setLayout(new CardLayout(0, 0));

		JPanel datepage = new JPanel();
		datepage.setBackground(blackcolor);
		cards.add(datepage, "ccp1");
		datepage.setLayout(null);

		ImageIcon salesD = new ImageIcon("GreatPizza/img//salesD.png");
		JLabel dateback = new JLabel(salesD);
		dateback.setBounds(0, 0, 750, 845);
		datepage.add(dateback);

		JPanel monthpage = new JPanel();
		monthpage.setBackground(blackcolor);
		cards.add(monthpage, "ccp2");
		monthpage.setLayout(null);
		
		ImageIcon salesM = new ImageIcon("GreatPizza/img//salesM.png");
		JLabel monthback = new JLabel(salesM);
		monthback.setBounds(0, 0, 750, 845);
		monthpage.add(monthback);
		
		for (int i = 1; i <= 4; i++) {
			if (bests.get(i) != null) {
				JLabel first = new JLabel(bests.get(i).get(0));
				first.setFont(new Font("굴림", Font.BOLD, 15));
				first.setForeground(Color.WHITE);
				first.setBounds(140, 186 + 45*(i-1), 300, 27);
				monthback.add(first);
				JLabel num = new JLabel(bests.get(i).get(1) + "개");
				num.setFont(new Font("굴림", Font.BOLD, 12));
				num.setForeground(Color.WHITE);
				num.setBounds(620, 186 + 44*(i-1), 300, 27);
				monthback.add(num);
			}
		}
		
		for (int i = 1; i <= 5; i++) {
			if (bestMonth.get(i) != null) {
				JLabel first = new JLabel(i + "위 " + bestMonth.get(i).get(0) + "월 " + bestMonth.get(i).get(1)+ "원");
				first.setFont(new Font("굴림", Font.BOLD, 15));
				first.setForeground(Color.WHITE);
				first.setBounds(180, 500 + 30*(i-1), 300, 27);
				monthback.add(first);
			}
		}

		BorderButton btndate = new BorderButton("일별");
		btndate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cards.show(cards, "ccp1");
			}
		});
		btndate.setBounds(30, 30, 40, 23);
		monthback.add(btndate);
		
		BorderButton btnmonth = new BorderButton("월별");
		btnmonth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cl_cards.show(cards, "ccp2");
			}
		});
		btnmonth.setBounds(30, 30, 40, 23);
		dateback.add(btnmonth);
		
		JLabel total = new JLabel(order.todaySales(day) + "원");
		total.setForeground(mintcolor);
		total.setBounds(435, 161, 100, 30);
		total.setFont(new Font("굴림", Font.BOLD, 15));
		total.setHorizontalAlignment(SwingConstants.CENTER);
		dateback.add(total);
		
		List<MainOrder> finishs = order.getMainOrders("확인");
		JLabel finish = new JLabel(String.valueOf(finishs.size())+"개의 주문 완료");
		finish.setForeground(Color.WHITE);
		finish.setBounds(112, 109, 150, 30);
		finish.setFont(new Font("굴림", Font.BOLD, 15));
		finish.setHorizontalAlignment(SwingConstants.CENTER);
		dateback.add(finish);
		
		cl_cards = (CardLayout) cards.getLayout();
	}
}
