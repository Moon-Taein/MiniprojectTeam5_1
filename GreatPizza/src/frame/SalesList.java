package frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;

public class SalesList extends JPanel {

	private JPanel cards;
	protected CardLayout cl_cards;
	private JLabel todaytotal;

	public SalesList() {
		setSize(new Dimension(650, 900));
		setLayout(null);

		cards = new JPanel();
		cards.setBounds(0, 85, 650, 815);
		add(cards);
		cards.setLayout(new CardLayout(0, 0));

		JPanel datepage = new JPanel();
		datepage.setBackground(Color.GRAY);
		cards.add(datepage, "ccp1");
		datepage.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(69, 71, 510, 262);
		datepage.add(panel);
		panel.setLayout(null);
		
		todaytotal = new JLabel("오늘의 매출");
		todaytotal.setFont(new Font("굴림", Font.BOLD, 25));
		todaytotal.setBounds(183, 28, 134, 37);
		panel.add(todaytotal);
		
		JLabel total = new JLabel("0000000");
		total.setHorizontalAlignment(SwingConstants.CENTER);
		total.setFont(new Font("굴림", Font.BOLD, 20));
		total.setBounds(90, 75, 326, 47);
		panel.add(total);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(69, 356, 510, 394);
		datepage.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel week = new JLabel("요일별 매출");
		week.setHorizontalAlignment(SwingConstants.CENTER);
		week.setBounds(189, 23, 128, 33);
		panel_1.add(week);

		JPanel monthpage = new JPanel();
		monthpage.setBackground(Color.PINK);
		cards.add(monthpage, "ccp2");
		monthpage.setLayout(null);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(76, 82, 485, 289);
		monthpage.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel today = new JLabel("많이팔린메뉴");
		today.setFont(new Font("굴림", Font.PLAIN, 20));
		today.setHorizontalAlignment(SwingConstants.CENTER);
		today.setBounds(179, 5, 128, 47);
		panel_2.add(today);
		
		JLabel first = new JLabel("1.");
		first.setFont(new Font("굴림", Font.PLAIN, 15));
		first.setBounds(179, 62, 128, 27);
		panel_2.add(first);
		
		JLabel second = new JLabel("2.");
		second.setFont(new Font("굴림", Font.PLAIN, 15));
		second.setBounds(179, 99, 128, 27);
		panel_2.add(second);
		
		JLabel third = new JLabel("New label");
		third.setFont(new Font("굴림", Font.PLAIN, 15));
		third.setBounds(179, 136, 128, 27);
		panel_2.add(third);
		
		JLabel four = new JLabel("New label");
		four.setFont(new Font("굴림", Font.PLAIN, 15));
		four.setBounds(179, 173, 128, 27);
		panel_2.add(four);
		
		JLabel five = new JLabel("New label");
		five.setFont(new Font("굴림", Font.PLAIN, 15));
		five.setBounds(179, 210, 128, 27);
		panel_2.add(five);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(76, 400, 485, 370);
		monthpage.add(panel_3);
		panel_3.setLayout(null);

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
