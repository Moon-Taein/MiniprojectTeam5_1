package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Rectangle;
import java.awt.Scrollbar;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JComponent;

import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;

import img.RoundButton;
import repo.Ingredient;
import repo.Menu;
import repo.PosRepo;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;
import java.awt.Graphics;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

public class MenuList extends JPanel {
	private JPanel scrollablePanel;
	private JLabel background;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");
	private JTextField textField;
	private JPanel innerPanel;

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
		setting(list);

		// JScrollPane 생성 및 스크롤 가능한 패널 설정
		JScrollPane scrollPane = new JScrollPane(scrollablePanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(590, 496));
		scrollPane.setBackground(graycolor);

		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.getVerticalScrollBar().setBackground(graycolor); // 스크롤 바 배경
		scrollPane.getVerticalScrollBar().setUnitIncrement(15); // 스크롤 바 속도
		scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(5, 200));
		scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI()); // 뭔지 모르는데 UI 설정
		scrollPane.setBorder(null);
		scrollPane.revalidate();
		scrollPane.repaint();
		panel.add(scrollPane);

		RoundButton btnNewButton = new RoundButton("ADD MENU");
		btnNewButton.setOpaque(false);
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
		textField.registerKeyboardAction(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				List<Menu> menus = pr.findmenus(textField.getText());
				scrollablePanel.removeAll();
				scrollablePanel.repaint();
				scrollablePanel.revalidate();
				setting(menus);
			}
		}, null, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		textField.setForeground(Color.WHITE);
		background.add(textField);
		textField.setColumns(10);
	}

	public void setting(List<Menu> list) {
		for (Menu m : list) {
			innerPanel = new JPanel();
			innerPanel.setLayout(new GridLayout(1, 3, 0, 25)); // (행, 열, 글자사이 가로 간격, 격자사이 수직 간격)

			innerPanel.setBorder(new EmptyBorder(15, 5, 15, 5)); // (위로 간격, 왼쪽 ,아래, 우측) 레이아웃과의 간격
			innerPanel.setBackground(graycolor);
			innerPanel.setOpaque(true);

			JLabel nameLabel = new JLabel(m.getMenuId());
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

			innerPanel.add(nameLabel);
			innerPanel.add(typeLabel);
			innerPanel.add(priceLabel);

			innerPanel.addMouseListener(new MouseAdapter() {

				@Override
				public void mouseClicked(MouseEvent e) {
					int index = 0;
					for (int i = 0; i < list.size(); i++) {
						Menu menu = list.get(i);
						if (menu.getMenuId().equals(nameLabel.getText())) {
							index = i;
							break;
						}
					}
					Menu menu = list.get(index);
					MenuResetPopup menuResetPopup = new MenuResetPopup(MenuList.this, menu);
					menuResetPopup.setAlwaysOnTop(true);

				}
			});

			scrollablePanel.add(innerPanel);
			scrollablePanel.setOpaque(false);
			scrollablePanel.revalidate();
			scrollablePanel.repaint();
		}

	}

	static class CustomScrollBarUI extends BasicScrollBarUI {
		@Override
		protected void configureScrollBarColors() {
			// ScrollBar의 색상 설정
			thumbColor = mintcolor;
			thumbDarkShadowColor = Color.BLUE;
			thumbHighlightColor = Color.GREEN;
			thumbLightShadowColor = Color.YELLOW;
		}

		@Override
		protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
			// Thumb의 디자인을 그림
			// 예시로 단색의 Thumb을 그리는 코드를 작성하겠습니다.
			g.setColor(thumbColor);
			g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
		}

		@Override
		protected JButton createDecreaseButton(int orientation) {
			return createZeroButton();
		}

		@Override
		protected JButton createIncreaseButton(int orientation) {
			return createZeroButton();
		}

		private JButton createZeroButton() {
			JButton button = new JButton();
			Dimension zeroDim = new Dimension(0, 0);
			button.setPreferredSize(zeroDim);
			button.setMinimumSize(zeroDim);
			button.setMaximumSize(zeroDim);
			return button;
		}
	}
}
