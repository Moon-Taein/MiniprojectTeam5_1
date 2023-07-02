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
import javax.swing.JTextField;

public class MenuList extends JPanel {
	private JPanel scrollablePanel;
	private JLabel background;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");
	private JTextField textField;

	public MenuList() {
		setBackground(Color.BLACK);
		createMenuList();
	}

	public void createMenuList() {
		setSize(new Dimension(750, 800));
		setLayout(null);
		
		ImageIcon frame = new ImageIcon("GreatPizza/img//menu.png");
		background = new JLabel(frame);
		background.setBounds(0, 0, 750, 800);
		add(background);

		JPanel panel = new JPanel(); // 스크롤 패인 담을 패널
		panel.setBackground(graycolor);
		panel.setBounds(80, 160, 589, 500);
		background.add(panel);

		scrollablePanel = new JPanel();
		scrollablePanel.setBackground(graycolor);
		scrollablePanel.setBounds(80, 160, 589, 500);
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));

		// 패널 내부의 패널 생성
		PosRepo pr = new PosRepo();
		List<Menu> list = pr.menuIdPrice();
		for (Menu m : list) {
			JPanel innerPanel = new JPanel();
			innerPanel.setLayout(new GridLayout(1, 3, 0, 50)); // (행, 열, 글자사이 가로 간격, 격자사이 수직 간격)

			innerPanel.setBorder(new EmptyBorder(15, 5, 15, 5)); // (위로 간격, 왼쪽 ,아래, 우측) 레이아웃과의 간격
			innerPanel.setBackground(graycolor);
			innerPanel.setOpaque(true);

			JLabel nameLabel = new JLabel(m.getMenuName());
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nameLabel.setOpaque(false);
			nameLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			nameLabel.setBackground(graycolor);
			nameLabel.setForeground(mintcolor);

			JLabel typeLabel = new JLabel(m.getType());
			typeLabel.setHorizontalAlignment(SwingConstants.CENTER);
			typeLabel.setOpaque(true);
			typeLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			typeLabel.setBackground(graycolor);
			typeLabel.setForeground(mintcolor);

			JLabel priceLabel = new JLabel(String.valueOf(m.getPrice()));
			priceLabel.setHorizontalAlignment(SwingConstants.CENTER);
			priceLabel.setOpaque(true);
			priceLabel.setFont(new Font("굴림", Font.PLAIN, 15));
			priceLabel.setBackground(graycolor);
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
		scrollPane.setPreferredSize(new Dimension(590, 496));
		scrollPane.setBackground(graycolor);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.revalidate();
		scrollPane.repaint();
		panel.add(scrollPane);
		
		RoundButton btnNewButton = new RoundButton("ADD MENU");
		background.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				MenuPopup menuPopup = new MenuPopup(MenuList.this);
			}
		});
		btnNewButton.setBounds(270, 670, 200, 50);
		
		textField = new JTextField();
		textField.setBounds(120, 60, 423, 44);
		textField.setOpaque(false);
		textField.setBorder(null);
		textField.setForeground(Color.WHITE);
		background.add(textField);
		textField.setColumns(10);
	}
}
