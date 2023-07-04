package frame;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.ListCellRenderer;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicComboBoxUI;

import img.RoundButton;
import repo.Ingredient;
import repo.MainOrder;
import repo.OrderRepo;

import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JButton;
import javax.imageio.ImageIO;
import javax.swing.BorderFactory;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.SwingConstants;
import java.awt.Color;
import java.awt.Component;

public class SalesListCheck extends JFrame {

	private JPanel contentPane;

	private OrderRepo order;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");

	public SalesListCheck() {
		LocalDate today = LocalDate.now();
		String day = today.format(DateTimeFormatter.ofPattern("yyyy-M-d"));
		order = new OrderRepo();
		setBounds(0, 0, 450, 200);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		setLocation(740, 380);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#171821"));
		
		OrderRepo or = new OrderRepo();
		List<MainOrder> check = or.getMainOrders();

		ImageIcon background = new ImageIcon("GreatPizza/img//InPlus.png");


		ImageIcon dot = new ImageIcon("GreatPizza/img//back.png");
		
				RoundButton buy = new RoundButton("확 인");
				contentPane.add(buy);
				buy.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {

						HomeFrame hf = new HomeFrame();
						setVisible(false);
						hf.salasList();
		
					}
				});
				
						buy.setBounds(134, 110, 169, 32);
						
								JLabel lblNewLabel = new JLabel("확인되지 않은 주문내역이 있습니다.");
								contentPane.add(lblNewLabel);
								lblNewLabel.setForeground(Color.WHITE);
								lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
								lblNewLabel.setBounds(97, 61, 261, 42);
								

	}

	class CustomComboBoxUI extends BasicComboBoxUI {
		private BufferedImage backgroundImg;

		@Override
		protected ListCellRenderer<Object> createRenderer() {
			// 셀 렌더러 생성 및 디자인 설정
			return new DefaultListCellRenderer() {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
					label.setForeground(mintcolor);
					label.setBackground(graycolor);
					label.setHorizontalAlignment(SwingConstants.CENTER); // 텍스트 중앙 정렬

					return label;
				}
			};
		}

		@Override
		public void paint(Graphics g, JComponent c) {
			super.paint(g, c);
			Graphics2D g2 = (Graphics2D) g;
			g2.drawImage(backgroundImg, 0, 0, c.getWidth(), c.getHeight(), null);
		}
	}


}
