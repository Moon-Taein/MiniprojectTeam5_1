package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Shape;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import img.RoundButton;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;
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
	private SalesList salesList;
	private IngredientList ingredientList;
	private FinancialList financialList;

	public HomeFrame() {
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		setLocationRelativeTo(null);

		contentPane = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                int arc = 30; 
                Shape roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc);
                g2.setPaint(blackcolor); 
                g2.fill(roundedRect);
            }
        };
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(blackcolor);
		panel.setBounds(12, 0, 141, 900);
		contentPane.add(panel);
		panel.setLayout(null);

		JButton salesbtn = new RoundButton("매 출 확 인");
		salesbtn.setBounds(2, 209, 124, 36);
		panel.add(salesbtn);

		JButton financialbtn = new RoundButton("재 정 확 인");
		financialbtn.setBounds(2, 251, 124, 36);
		panel.add(financialbtn);

		JButton buybtn = new RoundButton("주 문 내 역");
//		buybtn.setIcon(new ImageIcon("\\\\GREEN-424\\Java\\Your code\\_자유주제(DB)\\5조\\0630(6일차)\\기본버튼\\Group 174.png"));
		buybtn.setBounds(2, 82, 124, 36);
		panel.add(buybtn);

		JButton menubtn = new RoundButton("메 뉴 관 리");
		menubtn.setBounds(2, 167, 124, 36);
		panel.add(menubtn);

		JButton inventorybtn = new RoundButton("재 고 관 리");
		inventorybtn.setBounds(2, 124, 124, 36);
		panel.add(inventorybtn);

		cards = new JPanel(new CardLayout());
		cards.setBackground(graycolor);
		cards.setBounds(152, 0, 736, 861);
		contentPane.add(cards, BorderLayout.CENTER);

		BuyList buyList = new BuyList();
		buyList.setLayout(null);
		buyList.setBackground(blackcolor);
		cards.add(buyList, "buyList");

		salesList = new SalesList();
		cards.add(salesList, "salesList");

		financialList = new FinancialList();
		financialList.setLayout(null);
		financialList.setBackground(blackcolor);
		cards.add(financialList, "financialList");

		MenuList menuList = new MenuList();
		menuList.setLayout(null);
		menuList.setBackground(blackcolor);
		cards.add(menuList, "menuList");

		ingredientList = new IngredientList();
		ingredientList.setLayout(null);
		ingredientList.setBackground(blackcolor);
		cards.add(ingredientList, "ingredientList");
		cardLayout = (CardLayout) cards.getLayout();

		salesbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				salesList.removeAll();
				salesList.repaint();
				salesList.initialize();
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
				ingredientList.removeAll();
				ingredientList.repaint();
				ingredientList.setting();
				cardLayout.show(cards, "ingredientList");
			}
		});
		
		ImageIcon dot = new ImageIcon("GreatPizza/img//Dots.png");
		JLabel dots = new JLabel(dot);
		dots.setBounds(2, 25, 60, 30);
		dots.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Login login = new Login();
				login.setVisible(true);
				dispose();
			}
			@Override
			public void mousePressed(MouseEvent e) { }
			@Override
			public void mouseReleased(MouseEvent e) { }
			@Override
			public void mouseEntered(MouseEvent e) {
				dots.setBounds(2, 22, 60, 30);
			}
			@Override
			public void mouseExited(MouseEvent e) {
				dots.setBounds(2, 25, 60, 30);
			}
		});
		panel.add(dots);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(graycolor);
		panel_1.setBounds(138, 0, 3, 800);
		panel.add(panel_1);
	}
}
