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

import repo.PosRepo;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JComboBox;
import java.awt.ComponentOrientation;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class FinancialList extends JPanel {
	String selectYear;

	public FinancialList() {
		PosRepo pr = new PosRepo();
		setLocation(-259, -115);
		setSize(new Dimension(650, 900));
		setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(50, 162, 549, 590);
		add(panel);

		// 스크롤 가능한 패널 생성
		JPanel scrollablePanel = new JPanel();
		scrollablePanel.setBackground(Color.WHITE);
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));

		// 패널 내부의 패널 생성
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 3, 100, 50)); // 가로로 3개의 컴포넌트 배치
		innerPanel.setBorder(new EmptyBorder(10, 10, 100, 50)); // 패널 간격 설정

		// 라벨 추가
		JLabel label1 = new JLabel("날 짜");
		label1.setOpaque(true);
		label1.setFont(new Font("굴림", Font.PLAIN, 15));
		JLabel label2 = new JLabel("매 출");
		label2.setOpaque(true);
		label2.setFont(new Font("굴림", Font.PLAIN, 15));
		JLabel label3 = new JLabel("매 입 ");
		label3.setOpaque(true);
		label3.setFont(new Font("굴림", Font.PLAIN, 15));

		// 라벨을 패널에 추가
		innerPanel.add(label1);
		innerPanel.add(label2);
		innerPanel.add(label3);

		// 패널을 스크롤 가능한 패널에 추가
		scrollablePanel.add(innerPanel);

		// JScrollPane 생성 및 스크롤 가능한 패널 설정
		JScrollPane scrollPane = new JScrollPane(scrollablePanel);
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel.add(scrollPane);

		JComboBox comboBox = new JComboBox();

		comboBox.setBounds(50, 118, 79, 34);

		for (int i : pr.year()) {
			comboBox.addItem(i);
		}
		add(comboBox);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(141, 118, 58, 34);

		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectYear = comboBox.getSelectedItem().toString();

				comboBox_1.removeAllItems();

				for (Integer i : pr.month(Integer.valueOf(selectYear))) {
					comboBox_1.addItem(i);
				}
			}
		});

		add(comboBox_1);

		JLabel lblNewLabel = new JLabel("년도");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(50, 79, 79, 34);
		add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("월");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(141, 79, 58, 34);
		add(lblNewLabel_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.PINK);
		panel_1.setBounds(259, 112, 339, 45);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("매 출");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 10, 141, 27);
		panel_1.add(lblNewLabel_2);

		JLabel lblNewLabel_2_1 = new JLabel("매 입");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setBounds(165, 10, 162, 27);
		panel_1.add(lblNewLabel_2_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(50, 762, 549, 79);
		add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("금액( 00000000000000000 )");
		lblNewLabel_3.setBounds(216, 10, 221, 59);
		panel_2.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("총 액 :");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(83, 10, 121, 59);
		panel_2.add(lblNewLabel_4);

	}
}
