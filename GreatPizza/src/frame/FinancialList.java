package frame;

import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.plaf.basic.BasicComboBoxUI;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import javafx.scene.layout.Background;
import repo.PosRepo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.YearMonth;

public class FinancialList extends JPanel {
	private JComboBox<Integer> yearComboBox;
	private JComboBox<Integer> monthComboBox;
	private JTable calendarTable;
	private DefaultTableModel model;
	private PosRepo pr;
	private String selectYear;
	private int month;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");
	ImageIcon comboBox;
	private JLabel lblNewLabel_4;

	public FinancialList() {
		pr = new PosRepo();
		setBackground(blackcolor);
		// 연도 콤보박스 생성
		yearComboBox = new JComboBox<>();
		yearComboBox.setBounds(0, 10, 77, 35);
		yearComboBox.setOpaque(false);

		int currentYear = YearMonth.now().getYear();
		for (int i : pr.year()) {
			yearComboBox.addItem(i);
		}

		// 월 콤보박스 생성
		monthComboBox = new JComboBox<>();
		monthComboBox.setBounds(126, 10, 64, 35);
		monthComboBox.setOpaque(false);

		JLabel lblNewLabel_5 = new JLabel("년도를 선택하면 사라집니다.");

		yearComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				lblNewLabel_5.setVisible(false);
				monthComboBox.removeAllItems();
				selectYear = yearComboBox.getSelectedItem().toString();

				for (Integer i : pr.month(Integer.valueOf(selectYear))) {
					monthComboBox.addItem(i);
				}
				updateCalendar();
			}
		});

		// 콤보박스 이벤트 리스너 등록
		monthComboBox.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (monthComboBox.getSelectedItem() != null) {
					updateCalendar();
				}
			}
		});

		// Look and Feel 변경
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
		} catch (Exception e) {
			e.printStackTrace();
		}

		// 커스텀 Renderer 설정
		yearComboBox.setUI(new CustomComboBoxUI("GreatPizza/img//Rectangle 491.png"));
		yearComboBox.setBackground(blackcolor);
		yearComboBox.setForeground(mintcolor);
		monthComboBox.setUI(new CustomComboBoxUI("GreatPizza/img//Rectangle 491.png"));
		monthComboBox.setBackground(blackcolor);
		monthComboBox.setForeground(mintcolor);

		// 패널에 콤보박스 추가
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setBounds(45, 91, 659, 49);
		comboBoxPanel.setLayout(null);
		comboBoxPanel.add(yearComboBox);
		comboBoxPanel.add(monthComboBox);
		comboBoxPanel.setBackground(blackcolor);

		// 달력 테이블 생성
		calendarTable = new JTable();
		calendarTable.setRowHeight(80);
		calendarTable.setBounds(50, 140, 650, 515);
		calendarTable.setEnabled(false);
		setLayout(null);

		lblNewLabel_5.setOpaque(true);
		lblNewLabel_5.setFont(new Font("굴림", Font.PLAIN, 20));
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBackground(Color.BLACK);
		lblNewLabel_5.setForeground(Color.WHITE);
		lblNewLabel_5.setBounds(45, 140, 659, 530);
		add(lblNewLabel_5);

		// 프레임에 패널과 테이블 추가
		add(comboBoxPanel);

		JLabel lblNewLabel = new JLabel("Year");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(77, 0, 49, 49);
		lblNewLabel.setForeground(Color.WHITE);
		comboBoxPanel.add(lblNewLabel);

		ImageIcon icon = new ImageIcon("GreatPizza/img//colorName.png");

		JLabel lblNewLabel_6 = new JLabel("\u25CF Purchase");
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setForeground(mintcolor);
		lblNewLabel_6.setBounds(495, 10, 86, 35);
		comboBoxPanel.add(lblNewLabel_6);

		JLabel Sales = new JLabel("\u25CF Sales");
		Sales.setHorizontalAlignment(SwingConstants.CENTER);
		Sales.setForeground(Color.PINK);
		Sales.setBounds(561, 10, 98, 35);
		comboBoxPanel.add(Sales);

		JLabel lblNewLabel_1 = new JLabel("Month");
		lblNewLabel_1.setBounds(187, 0, 64, 49);
		comboBoxPanel.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.WHITE);

		JPanel panel = new JPanel();
		panel.setBounds(45, 0, 659, 88);
		panel.setBackground(blackcolor);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("월별 재정 관리");
		lblNewLabel_2.setFont(new Font("굴림", Font.PLAIN, 18));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 37, 127, 41);
		lblNewLabel_2.setForeground(Color.WHITE);
		panel.add(lblNewLabel_2);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 641, 659, 100);
		panel_1.setBackground(blackcolor);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("Total Cost : ");
		lblNewLabel_3.setFont(new Font("굴림", Font.PLAIN, 19));
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(188, 10, 125, 80);
		panel_1.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setFont(new Font("굴림", Font.PLAIN, 19));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(265, 0, 148, 100);
		lblNewLabel_4.setForeground(Color.white);
		panel_1.add(lblNewLabel_4);
		calendarTable.setBackground(graycolor);
		JScrollPane scrollPane = new JScrollPane(calendarTable);
		scrollPane.setBounds(45, 140, 630, 503);
		scrollPane.setBackground(graycolor);

		add(scrollPane);

	}

	private void updateCalendar() {
		int year = (int) yearComboBox.getSelectedItem();
		month = (int) monthComboBox.getSelectedItem();

		YearMonth yearMonth = YearMonth.of(year, month);
		String yearAndMonth = year + "-" + month;

		int lastDayOfMonth = yearMonth.lengthOfMonth();
		int firstDayOfWeek = yearMonth.atDay(1).getDayOfWeek().getValue();

		String[] columnNames = { "일", "월", "화", "수", "목", "금", "토" };
		Object[][] data = new Object[6][7];

		String cost = pr.cost(String.valueOf(month));
		lblNewLabel_4.setText(cost);

		int day = 1;
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				if (row == 0 && col < firstDayOfWeek - 1) {
					data[row][col] = "   [나만의 피자]";
				} else if (day > lastDayOfMonth) {
					data[row][col] = "   [나만의 피자]";
				} else {
					String date = year + "-" + month + "-" + day;

					JPanel panel = new JPanel(new BorderLayout());
					panel.setBackground(graycolor);
					JPanel infoPanel = new JPanel(new GridLayout(2, 1));

					JLabel dateLabel = new JLabel(String.valueOf(day));
					JLabel purchaseLabel = new JLabel("" + pr.getSales(date));
					JLabel salesLabel = new JLabel("" + pr.getPurchase(date));

					dateLabel.setHorizontalAlignment(SwingConstants.RIGHT);
					dateLabel.setForeground(Color.WHITE);
					purchaseLabel.setForeground(mintcolor);
					purchaseLabel.setHorizontalAlignment(SwingConstants.CENTER);
					salesLabel.setForeground(Color.decode("#F2C8ED"));
					salesLabel.setHorizontalAlignment(SwingConstants.CENTER);

					infoPanel.add(purchaseLabel);
					infoPanel.add(salesLabel);

					panel.add(dateLabel, BorderLayout.NORTH);
					panel.add(infoPanel, BorderLayout.CENTER);

					data[row][col] = panel;

					day++;

				}
			}
		}

		model = new DefaultTableModel(data, columnNames);
		yearComboBox.setOpaque(false);
		calendarTable.setModel(model);
		calendarTable.setDefaultRenderer(Object.class, new PanelCellRenderer());
		calendarTable.setSize(640, 640);
		calendarTable.setBackground(graycolor);
	}

	class PanelCellRenderer implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value instanceof JPanel) {
				JPanel panel = (JPanel) value;
				panel.setBackground(table.getBackground());
				panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));
				panel.setBorder(BorderFactory.createLineBorder(graycolor));

				// 패널 내부의 컴포넌트 배경색 설정
				for (Component component : panel.getComponents()) {
					component.setBackground(panel.getBackground());
				}
				return panel;
			} else if (value instanceof JLabel) {
				JLabel label = (JLabel) value;
				label.setBackground(table.getBackground());
				label.setOpaque(true); // 배경색이 나타나도록 설정

				return label;
			} else {
				return new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus,
						row, column);
			}
		}
	}

	class CustomComboBoxUI extends BasicComboBoxUI {
		private BufferedImage backgroundImg;

		public CustomComboBoxUI(String backgroundImgPath) {
			try {
				backgroundImg = ImageIO.read(new File(backgroundImgPath));
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		@Override
		public void installUI(JComponent c) {
			super.installUI(c);
			JComboBox<?> comboBox = (JComboBox<?>) c;
			comboBox.setOpaque(false);
		}

		@Override
		protected JButton createArrowButton() {
			// 화살표 버튼 생성 및 디자인 설정
			JButton button = new JButton();
			button.setIcon(new ImageIcon("GreatPizza/img//Polygon 1.png")); // 화살표 아이콘 설정
			button.setContentAreaFilled(false);
			button.setFocusPainted(false);
			button.setBorder(BorderFactory.createEmptyBorder());
			comboBox.setOpaque(false);

			return button;
		}

		@Override
		protected ListCellRenderer<?> createRenderer() {
			// 셀 렌더러 생성 및 디자인 설정
			return new DefaultListCellRenderer() {
				@Override
				public Component getListCellRendererComponent(JList<?> list, Object value, int index,
						boolean isSelected, boolean cellHasFocus) {
					JLabel label = (JLabel) super.getListCellRendererComponent(list, value, index, isSelected,
							cellHasFocus);
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
