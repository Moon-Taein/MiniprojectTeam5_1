package frame;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;

import repo.PosRepo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;

public class FinancialList extends JPanel {
	private JComboBox<Integer> yearComboBox;
	private JComboBox<Integer> monthComboBox;
	private JTable calendarTable;
	private DefaultTableModel model;
	private PosRepo pr;
	private String selectYear;
	private int month;

	public FinancialList() {
		pr = new PosRepo();

		// 연도 콤보박스 생성
		yearComboBox = new JComboBox<>();
		int currentYear = YearMonth.now().getYear();
		for (int i : pr.year()) {
			yearComboBox.addItem(i);
		}

		// 월 콤보박스 생성
		monthComboBox = new JComboBox<>();

		yearComboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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

		// 패널에 콤보박스 추가
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.setBounds(0, 100, 750, 40);
		comboBoxPanel.add(yearComboBox);
		comboBoxPanel.add(monthComboBox);

		// 달력 테이블 생성
		calendarTable = new JTable();
		calendarTable.setRowHeight(80);
		calendarTable.setBounds(50, 140, 650, 515);
		calendarTable.setEnabled(false);
		setLayout(null);

		// 프레임에 패널과 테이블 추가
		add(comboBoxPanel);

		JPanel panel = new JPanel();
		panel.setBounds(45, 0, 640, 100);
		add(panel);
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(45, 642, 640, 10);
		add(panel_1);
		JScrollPane scrollPane = new JScrollPane(calendarTable);
		scrollPane.setBounds(45, 140, 650, 515);
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

		int day = 1;
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				if (row == 0 && col < firstDayOfWeek - 1) {
					data[row][col] = "앞에 빈칸";
				} else if (day > lastDayOfMonth) {
					data[row][col] = "뒤에 빈칸";
				} else {
					String date = year + "-" + month + "-" + day;

					JPanel panel = new JPanel(new BorderLayout());
					JPanel infoPanel = new JPanel(new GridLayout(2, 1));

					JLabel dateLabel = new JLabel(String.valueOf(day));
					JLabel purchaseLabel = new JLabel("매출: " + pr.getSales(date));
					JLabel salesLabel = new JLabel("매입: " + pr.getPurchase(date));

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
		calendarTable.setModel(model);
		calendarTable.setDefaultRenderer(Object.class, new PanelCellRenderer());
		calendarTable.setSize(640, 640);
	}

	class PanelCellRenderer implements TableCellRenderer {
		public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
				int row, int column) {
			if (value instanceof JPanel) {
				JPanel panel = (JPanel) value;
				panel.setBackground(table.getBackground());
				panel.setBorder(BorderFactory.createEmptyBorder(2, 2, 2, 2));

				// 패널 내부의 컴포넌트 배경색 설정
				for (Component component : panel.getComponents()) {
					component.setBackground(panel.getBackground());
				}

				return panel;
			} else {
				return new DefaultTableCellRenderer().getTableCellRendererComponent(table, value, isSelected, hasFocus,
						row, column);
			}
		}
	}
}
