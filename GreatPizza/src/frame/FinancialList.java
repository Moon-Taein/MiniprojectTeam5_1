package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import repo.Account;
import repo.PosRepo;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class FinancialList extends JPanel {
	private String selectYear;
	private String year;
	private String month;
	private JPanel scrollablePanel;

	public FinancialList() {
		final PosRepo pr = new PosRepo();
		setLocation(-259, -115);
		setSize(new Dimension(750, 800));
		setLayout(null);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(51, 100, 549, 45);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("날 짜");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 10, 168, 25);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("매 입");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(192, 10, 168, 25);
		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_2_2 = new JLabel("매 출");
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(372, 10, 168, 25);
		panel_1.add(lblNewLabel_2_2);

		JPanel panel = new JPanel();
		panel.setBounds(51, 140, 549, 590);
		add(panel);

		scrollablePanel = new JPanel();
		scrollablePanel.setSize(new Dimension(550, 600));
		scrollablePanel.setBackground(Color.WHITE);
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));

		// JScrollPane 생성 및 스크롤 가능한 패널 설정
		JScrollPane scrollPane = new JScrollPane(scrollablePanel);
		scrollPane.setPreferredSize(new Dimension(550, 585));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollablePanel.revalidate();
		scrollablePanel.repaint();
		panel.add(scrollPane);

		defaultCreate();

		final JComboBox comboBox = new JComboBox();
		comboBox.setBounds(52, 63, 79, 34);
		add(comboBox);

		// 콤보박스 디폴트 값 설정해주기
		for (int i : pr.year()) {
			comboBox.addItem(i);
		}

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(143, 63, 58, 34);
		add(comboBox_1);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectYear = comboBox.getSelectedItem().toString();
				comboBox_1.removeAllItems();

				for (Integer i : pr.month(Integer.valueOf(selectYear))) {
					comboBox_1.addItem(i);
				}
			}
		});

		// 콤보박스2 디폴트 값 설정해주기
		for (Integer j : pr.month(Integer.valueOf(comboBox.getSelectedItem().toString()))) {
			comboBox_1.addItem(j);
		}

		JButton btnNewButton = new JButton("\uD655 \uC778");
		btnNewButton.setBounds(213, 63, 66, 34);
		add(btnNewButton);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(51, 740, 549, 79);
		add(panel_2);
		panel_2.setLayout(null);
		
		final JLabel lblNewLabel_3 = new JLabel("금 액");
		lblNewLabel_3.setBounds(216, 10, 221, 59);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("총 액 :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(83, 10, 121, 59);
		panel_2.add(lblNewLabel_4);
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				scrollablePanel.removeAll();
				year = comboBox.getSelectedItem().toString();
				month = comboBox_1.getSelectedItem().toString();

				// 연도 - 월 형식으로 출력
				String yearAndMonth = year + "-" + month;
				System.out.println(yearAndMonth);

				List<Account> list = pr.monthYear매입매출(yearAndMonth);
				System.out.println(list);
				for (Account ac : list) {
					// 패널 내부의 패널 생성
					JPanel innerPanel = new JPanel();
					innerPanel.setLayout(new GridLayout(1, 3, 50, 10)); // 가로로 3개의 컴포넌트 배치
					innerPanel.setBorder(new EmptyBorder(10, 50, 0, 50)); // 패널 간격 설정
					innerPanel.setBackground(Color.WHITE);

					String day = ac.settingDateYearMonth(ac.getDate());
					System.out.println(day);

					// 라벨 추가
					JLabel label1 = new JLabel(month + " / " + day);
					label1.setOpaque(true);
					label1.setBackground(Color.white);
					label1.setFont(new Font("굴림", Font.PLAIN, 15));

					JLabel label2 = new JLabel(String.valueOf(ac.getPurchase()));
					label2.setOpaque(true);
					label2.setBackground(Color.white);
					label2.setFont(new Font("굴림", Font.PLAIN, 15));

					JLabel label3 = new JLabel(String.valueOf(ac.getSales()));
					label3.setOpaque(true);
					label3.setBackground(Color.white);
					label3.setFont(new Font("굴림", Font.PLAIN, 15));

					// 라벨을 패널에 추가
					innerPanel.add(label1);
					innerPanel.add(label2);
					innerPanel.add(label3);

					// 패널을 스크롤 가능한 패널에 추가
					scrollablePanel.add(innerPanel);
					innerPanel.revalidate();
					innerPanel.repaint();
				}
				lblNewLabel_3.setText(pr.cost(month));
				scrollablePanel.revalidate();
				scrollablePanel.repaint();
			}
		});

		JLabel lblNewLabel = new JLabel("년도");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(52, 24, 79, 34);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(143, 24, 58, 34);
		add(lblNewLabel_1);

	}

	public void defaultCreate() {
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 3, 160, 50)); // 가로로 3개의 컴포넌트 배치
		innerPanel.setBorder(new EmptyBorder(10, 10, 10, 10)); // 패널 간격 설정
		innerPanel.setBackground(Color.WHITE);

		// 라벨 추가
		JLabel label1 = new JLabel(" 날 짜 ");
		label1.setOpaque(true);
		label1.setBackground(Color.white);
		label1.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel label2 = new JLabel(" 매 입 ");
		label2.setOpaque(true);
		label2.setBackground(Color.white);
		label2.setFont(new Font("굴림", Font.PLAIN, 15));

		JLabel label3 = new JLabel(" 매 출 ");
		label3.setOpaque(true);
		label3.setBackground(Color.white);
		label3.setFont(new Font("굴림", Font.PLAIN, 15));

		// 라벨을 패널에 추가
		innerPanel.add(label1);
		innerPanel.add(label2);
		innerPanel.add(label3);

		// 패널을 스크롤 가능한 패널에 추가
		scrollablePanel.add(innerPanel);

	}
}