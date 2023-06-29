package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private JPanel cards;
	private CardLayout cardLayout;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HomeFrame frame = new HomeFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public HomeFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 900);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 250, 900);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton salesbtn = new JButton("매 출 확 인");
		salesbtn.setBounds(0, 246, 250, 68);
		panel.add(salesbtn);

		JButton financialbtn = new JButton("재 정 확 인");
		financialbtn.setBounds(0, 312, 250, 68);
		panel.add(financialbtn);

		JButton buybtn = new JButton("주 문 내 역");
		buybtn.setBounds(0, 116, 250, 68);
		panel.add(buybtn);

		JButton menubtn = new JButton("메 뉴 관 리");
		menubtn.setBounds(0, 180, 250, 68);
		panel.add(menubtn);

		JButton inventorybtn = new JButton("재 고 관 리");
		inventorybtn.setBounds(0, 378, 250, 68);
		panel.add(inventorybtn);

		cards = new JPanel(new CardLayout());
		cards.setBounds(245, 0, 639, 861);
		contentPane.add(cards, BorderLayout.CENTER);

		BuyList buyList = new BuyList();
		buyList.setLayout(null);
		buyList.setBackground(Color.WHITE);
		cards.add(buyList, "buyList");

		SalesList salesList = new SalesList();
		salesList.setBackground(Color.WHITE);
		salesList.setLayout(null);
		cards.add(salesList, "salesList");

		FinancialList financialList = new FinancialList();
		financialList.setLayout(null);
		financialList.setBackground(Color.WHITE);
		cards.add(financialList, "financialList");

		MenuList menuList = new MenuList();
		menuList.setLayout(null);
		menuList.setBackground(Color.WHITE);
		cards.add(menuList, "menuList");

		InventoryList inventoryList = new InventoryList();
		inventoryList.setLayout(null);
		inventoryList.setBackground(Color.WHITE);
		cards.add(inventoryList, "inventoryList");
		cardLayout = (CardLayout) cards.getLayout();

		salesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "salesList");
			}
		});

		financialbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "financialList");
			}
		});

		buybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "buyList");
			}
		});

		menubtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayout.show(cards, "menuList");
			}
		});

		inventorybtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InventoryPopup pop = new InventoryPopup();
				pop.setVisible(true);
				cardLayout.show(cards, "inventoryList");
			}
		});
	}
}
