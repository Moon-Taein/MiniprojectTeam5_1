package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import img.RoundButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;

public class HomeFrame extends JFrame {

	private JPanel contentPane;
	private JPanel cards;
	private CardLayout cardLayout;
	private JLabel lbl;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");

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
		setLocationRelativeTo(null);
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		setLocationRelativeTo(null);

		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(blackcolor);
		panel.setBounds(0, 0, 150, 900);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton salesbtn = new RoundButton("매 출 확 인");
		salesbtn.setBounds(12, 209, 124, 36);
		panel.add(salesbtn);

		JButton financialbtn = new RoundButton("재 정 확 인");
		financialbtn.setBounds(12, 251, 124, 36);
		panel.add(financialbtn);

		JButton buybtn = new JButton("주 문 내 역");
		buybtn.setText("");
		buybtn.setIcon(new ImageIcon("\\\\GREEN-424\\Java\\Your code\\_자유주제(DB)\\5조\\0630(6일차)\\기본버튼\\Group 174.png"));
		buybtn.setBounds(12, 82, 124, 36);
		panel.add(buybtn);

		JButton menubtn = new RoundButton("메 뉴 관 리");
		menubtn.setBounds(12, 167, 124, 36);
		panel.add(menubtn);

		JButton inventorybtn = new RoundButton("재 고 관 리");
		inventorybtn.setBounds(12, 124, 124, 36);
		panel.add(inventorybtn);

		cards = new JPanel(new CardLayout());
		cards.setBackground(graycolor);
		cards.setBounds(152, 0, 748, 861);
		contentPane.add(cards, BorderLayout.CENTER);

		BuyList buyList = new BuyList();
		buyList.setLayout(null);
		buyList.setBackground(blackcolor);
		cards.add(buyList, "buyList");

		SalesList salesList = new SalesList();
		salesList.setBackground(blackcolor);
		salesList.setLayout(null);
		cards.add(salesList, "salesList");

		FinancialList financialList = new FinancialList();
		financialList.setLayout(null);
		financialList.setBackground(blackcolor);
		cards.add(financialList, "financialList");

		MenuList menuList = new MenuList();
		menuList.setLayout(null);
		menuList.setBackground(blackcolor);
		cards.add(menuList, "menuList");

		InventoryList inventoryList = new InventoryList();
		inventoryList.setLayout(null);
		inventoryList.setBackground(blackcolor);
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
