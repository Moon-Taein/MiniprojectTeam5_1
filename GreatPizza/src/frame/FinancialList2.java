package frame;
import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import repo.PosRepo;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.YearMonth;

public class FinancialList2 extends JFrame {
	private JComboBox<Integer> yearComboBox;
	private JComboBox<Integer> monthComboBox;
	private JTable calendarTable;
	private PosRepo pr;

	public FinancialList2() {
		setTitle("Calendar App");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
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
			private String selectYear;

			public void actionPerformed(ActionEvent arg0) {
				selectYear = yearComboBox.getSelectedItem().toString();
				monthComboBox.removeAllItems();

				for (Integer i : pr.month(Integer.valueOf(selectYear))) {
					monthComboBox.addItem(i);
				}
			}
		});

		// 콤보박스 이벤트 리스너 등록
		ActionListener comboBoxListener = new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				updateCalendar();
			}
		};
		yearComboBox.addActionListener(comboBoxListener);
		monthComboBox.addActionListener(comboBoxListener);

		// 패널에 콤보박스 추가
		JPanel comboBoxPanel = new JPanel();
		comboBoxPanel.add(yearComboBox);
		comboBoxPanel.add(monthComboBox);

		// 달력 테이블 생성
		calendarTable = new JTable();
		calendarTable.setRowHeight(70);
		calendarTable.setEnabled(false);
		JScrollPane tableScrollPane = new JScrollPane(calendarTable);

		// 프레임에 패널과 테이블 추가
		add(comboBoxPanel, BorderLayout.NORTH);
		add(tableScrollPane, BorderLayout.CENTER);

		setSize(750, 800);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	
		// 여기 하는중
	private void updateCalendar() {
		int year = (int) yearComboBox.getSelectedItem();
		int month = (int) monthComboBox.getSelectedItem();

		// 달력 모델 생성
		YearMonth yearMonth = YearMonth.of(year, month);
		int lastDayOfMonth = yearMonth.lengthOfMonth();
		int firstDayOfWeek = yearMonth.atDay(1).getDayOfWeek().getValue();
		String[] columnNames = { "일", "월", "화", "수", "목", "금", "토" };
		Object[][] data = new Object[6][7];

		// 달력 데이터 채우기
		int day = 1;
		for (int row = 0; row < 6; row++) {
			for (int col = 0; col < 7; col++) {
				if (row == 0 && col < firstDayOfWeek - 1) {
					data[row][col] = "";
				} else if (day > lastDayOfMonth) {
					data[row][col] = "";
				} else {
					data[row][col] = day;
					day++;
				}
			}
		}

		// 달력 모델 업데이트
		DefaultTableModel model = new DefaultTableModel(data, columnNames);
		calendarTable.setModel(model);
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			@Override
			public void run() {
				new FinancialList2();
			}
		});
	}
}
