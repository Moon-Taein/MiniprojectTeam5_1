package frame;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BuyList extends JPanel {

	/**
	 * Create the panel.
	 */
	public BuyList() {
		setLayout(null);
		setBounds(0, 0, 650, 900);
		
		JPanel pnl = new JPanel();
		pnl.setBounds(74, 111, 500, 150);
		add(pnl);
		pnl.setLayout(null);
		
		JButton check = new JButton("미확인");
		check.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				BuyListPopup popUp = new BuyListPopup();
				popUp.setVisible(true);
				
			}
		});
		check.setBounds(413, 65, 75, 23);
		pnl.add(check);
		
		JLabel id = new JLabel("2023062501");
		id.setFont(new Font("굴림", Font.BOLD, 30));
		id.setBounds(40, 65, 190, 50);
		pnl.add(id);
		
		JLabel date = new JLabel("20230625");
		date.setFont(new Font("굴림", Font.PLAIN, 25));
		date.setBounds(40, 16, 118, 29);
		pnl.add(date);
		
		JLabel time = new JLabel("08 : 30");
		time.setFont(new Font("굴림", Font.PLAIN, 25));
		time.setBounds(162, 16, 118, 29);
		pnl.add(time);
		
		JLabel price = new JLabel("34,000원");
		price.setFont(new Font("굴림", Font.BOLD, 25));
		price.setBounds(260, 65, 146, 50);
		pnl.add(price);
		
		JButton allCheck = new JButton("새로고침");
		allCheck.setBounds(477, 45, 97, 23);
		add(allCheck);
		
		JPanel pnl_1 = new JPanel();
		pnl_1.setLayout(null);
		pnl_1.setBounds(74, 294, 500, 150);
		add(pnl_1);
		
		JButton check_1 = new JButton("미확인");
		check_1.setBounds(413, 65, 75, 23);
		pnl_1.add(check_1);
		
		JLabel id_1 = new JLabel("2023062501");
		id_1.setFont(new Font("굴림", Font.BOLD, 30));
		id_1.setBounds(40, 65, 190, 50);
		pnl_1.add(id_1);
		
		JLabel date_1 = new JLabel("20230625");
		date_1.setFont(new Font("굴림", Font.PLAIN, 25));
		date_1.setBounds(40, 16, 118, 29);
		pnl_1.add(date_1);
		
		JLabel time_1 = new JLabel("08 : 30");
		time_1.setFont(new Font("굴림", Font.PLAIN, 25));
		time_1.setBounds(162, 16, 118, 29);
		pnl_1.add(time_1);
		
		JLabel price_1 = new JLabel("34,000원");
		price_1.setFont(new Font("굴림", Font.BOLD, 25));
		price_1.setBounds(260, 65, 146, 50);
		pnl_1.add(price_1);
		
		JPanel pnl_2 = new JPanel();
		pnl_2.setLayout(null);
		pnl_2.setBounds(74, 478, 500, 150);
		add(pnl_2);
		
		JButton check_2 = new JButton("미확인");
		check_2.setBounds(413, 65, 75, 23);
		pnl_2.add(check_2);
		
		JLabel id_2 = new JLabel("2023062501");
		id_2.setFont(new Font("굴림", Font.BOLD, 30));
		id_2.setBounds(40, 65, 190, 50);
		pnl_2.add(id_2);
		
		JLabel date_2 = new JLabel("20230625");
		date_2.setFont(new Font("굴림", Font.PLAIN, 25));
		date_2.setBounds(40, 16, 118, 29);
		pnl_2.add(date_2);
		
		JLabel time_2 = new JLabel("08 : 30");
		time_2.setFont(new Font("굴림", Font.PLAIN, 25));
		time_2.setBounds(162, 16, 118, 29);
		pnl_2.add(time_2);
		
		JLabel price_2 = new JLabel("34,000원");
		price_2.setFont(new Font("굴림", Font.BOLD, 25));
		price_2.setBounds(260, 65, 146, 50);
		pnl_2.add(price_2);
		
		JPanel pnl_3 = new JPanel();
		pnl_3.setLayout(null);
		pnl_3.setBounds(74, 664, 500, 150);
		add(pnl_3);
		
		JButton check_3 = new JButton("미확인");
		check_3.setBounds(413, 65, 75, 23);
		pnl_3.add(check_3);
		
		JLabel id_3 = new JLabel("2023062501");
		id_3.setFont(new Font("굴림", Font.BOLD, 30));
		id_3.setBounds(40, 65, 190, 50);
		pnl_3.add(id_3);
		
		JLabel date_3 = new JLabel("20230625");
		date_3.setFont(new Font("굴림", Font.PLAIN, 25));
		date_3.setBounds(40, 16, 118, 29);
		pnl_3.add(date_3);
		
		JLabel time_3 = new JLabel("08 : 30");
		time_3.setFont(new Font("굴림", Font.PLAIN, 25));
		time_3.setBounds(162, 16, 118, 29);
		pnl_3.add(time_3);
		
		JLabel price_3 = new JLabel("34,000원");
		price_3.setFont(new Font("굴림", Font.BOLD, 25));
		price_3.setBounds(260, 65, 146, 50);
		pnl_3.add(price_3);

	}
}
