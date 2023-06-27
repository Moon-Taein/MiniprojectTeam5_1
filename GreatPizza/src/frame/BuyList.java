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
	/**
	 * Create the panel.
	 */
	public BuyList() {
		setLayout(null);
		setBounds(0, 0, 650, 900);
		order = new OrderRepo();
		
		List<MainOrder> mainOrders = order.getList();
		
		for (int i = 0; i < mainOrders.size(); i++) {
			JPanel pnl = new JPanel();
			pnl.setBounds(74, 111 + (170 * i), 500, 150);
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
			
			id.setText(mainOrders.get(i).getDate() + "0" + mainOrders.get(i).getNo());
			date.setText(mainOrders.get(i).getDate());
			time.setText(mainOrders.get(i).getTime());
			price.setText(String.valueOf(mainOrders.get(i).getTotalprice()));
			check.setText(mainOrders.get(i).getState());
		}
		
		JButton allCheck = new JButton("새로고침");
		allCheck.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		allCheck.setBounds(477, 45, 97, 23);
		add(allCheck);
	}
	
}
