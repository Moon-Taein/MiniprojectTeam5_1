package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import img.RoundButton;
import repo.Menu;
import repo.PosRepo;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import javax.swing.ImageIcon;

public class MenuList extends JPanel {
	private JPanel scrollablePanel;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");

	public MenuList() {
		setBackground(Color.BLACK);
		createMenuList();
	}

	public void createMenuList() {
		setSize(new Dimension(750, 800));
		setLayout(null);

		RoundButton btnNewButton = new RoundButton("ADD MENU");
		btnNewButton.setOpaque(false);
		btnNewButton.setHorizontalTextPosition(SwingConstants.CENTER);
		btnNewButton.setIcon(new ImageIcon(MenuList.class.getResource("/img/메뉴추가.png")));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPopup menuPopup = new MenuPopup(MenuList.this);
			}
		});
		btnNewButton.setBounds(227, 739, 278, 54);
		add(btnNewButton);

		JPanel panel = new JPanel(); // 스크롤 패인 담을 패널
		panel.setBackground(blackcolor);
		panel.setSize(new Dimension(550, 750));
		panel.setBounds(100, 87, 550, 642);
		add(panel);

		scrollablePanel = new JPanel();
		scrollablePanel.setSize(new Dimension(550, 550));
		scrollablePanel.setBackground(blackcolor);
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));

		// 패널 내부의 패널 생성
		PosRepo pr = new PosRepo();
		List<Menu> list = pr.menuIdPrice();
		for (Menu m : list) {

			JPanel innerPanel = new JPanel();
			innerPanel.setLayout(new GridLayout(1, 3, 0, 50)); // (행, 열, 글자사이 가로 간격, 격자사이 수직 간격)
			innerPanel.setBorder(new EmptyBorder(15, 5, 15, 5)); // (위로 간격, 왼쪽 ,아래, 우측) 레이아웃과의 간격
			innerPanel.setBackground(blackcolor);
			innerPanel.setOpaque(true);

			JLabel nameLabel = new JLabel(m.getMenuName());
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nameLabel.setOpaque(false);
			nameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			nameLabel.setBackground(blackcolor);
			nameLabel.setForeground(mintcolor);

			JLabel typeLabel = new JLabel(m.getType());
			typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			typeLabel.setOpaque(true);
			typeLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			typeLabel.setBackground(blackcolor);
			typeLabel.setForeground(mintcolor);

			JLabel priceLabel = new JLabel(String.valueOf(m.getPrice()));
			priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			priceLabel.setOpaque(true);
			priceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			priceLabel.setBackground(blackcolor);
			priceLabel.setForeground(mintcolor);

			// Add the labels to the inner panel
			innerPanel.add(nameLabel);
			innerPanel.add(typeLabel);
			innerPanel.add(priceLabel);
			
			
			innerPanel.revalidate();
			innerPanel.repaint();
			scrollablePanel.add(innerPanel);
			scrollablePanel.setOpaque(false);
			scrollablePanel.revalidate();
			scrollablePanel.repaint();
		}

		// JScrollPane 생성 및 스크롤 가능한 패널 설정
		JScrollPane scrollPane = new JScrollPane(scrollablePanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(550, 635));
		scrollPane.setBackground(blackcolor);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.revalidate();
		scrollPane.repaint();
		panel.add(scrollPane);

		// JFrame에 JScrollPane 추가
		add(panel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(blackcolor);
		panel_1.setBounds(100, 30, 531, 56);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("이 름");
		lblNewLabel.setBackground(blackcolor);
		lblNewLabel.setForeground(mintcolor);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(27, 10, 134, 36);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("분 류");
		lblNewLabel_1.setBackground(blackcolor);
		lblNewLabel_1.setForeground(mintcolor);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(195, 10, 134, 36);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("금 액");
		lblNewLabel_2.setBackground(blackcolor);
		lblNewLabel_2.setForeground(mintcolor);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(362, 10, 141, 36);
		panel_1.add(lblNewLabel_2);
	}
}
