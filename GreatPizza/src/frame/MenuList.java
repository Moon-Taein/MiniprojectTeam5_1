package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import javax.swing.ScrollPaneConstants;
import java.awt.Font;

public class MenuList extends JPanel {

	/**
	 * Create the panel.
	 */
	public MenuList() {
		setSize(new Dimension(650, 900));
		setLayout(null);

		JPanel panel = new JPanel(); // 스크롤 패인 담을 패널
		panel.setSize(new Dimension(550, 750));
		panel.setBounds(52, 126, 550, 642);
		add(panel);
		
		// 스크롤 가능한 패널 생성
		JPanel scrollablePanel = new JPanel();
		scrollablePanel.setBackground(Color.WHITE);
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));
		
		
		// 패널 내부의 패널 생성
		JPanel innerPanel = new JPanel();
		innerPanel.setLayout(new GridLayout(1, 3, 130, 120)); // (행, 열, 글자사이 가로 간격, 격자사이 수직 간격)
		innerPanel.setBorder(new EmptyBorder(10, 40, 10, 40)); // (위로 간격, 왼쪽 ,아래, 우측) 레이아웃과의 간격
		
		
		
		
		
		// 라벨 추가
		JLabel label1 = new JLabel(" 이 름 ");
		label1.setHorizontalAlignment(SwingConstants.CENTER);
		label1.setOpaque(true);
		label1.setFont(new Font("굴림", Font.PLAIN, 18));
		JLabel label2 = new JLabel(" 분 류 ");
		label2.setHorizontalAlignment(SwingConstants.CENTER);
		label2.setOpaque(true);
		label2.setFont(new Font("굴림", Font.PLAIN, 18));
		JLabel label3 = new JLabel(" 금 액 ");
		label3.setHorizontalAlignment(SwingConstants.CENTER);
		label3.setOpaque(true);
		label3.setFont(new Font("굴림", Font.PLAIN, 18));

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

		// JFrame에 JScrollPane 추가
		add(panel);

		JButton btnNewButton = new JButton("메 뉴 추 가");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				new MenuPopup();
			}
		});
		btnNewButton.setBounds(238, 783, 168, 56);
		add(btnNewButton);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(52, 69, 550, 56);
		add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel = new JLabel("이 름");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setOpaque(true);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 164, 36);
		panel_1.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("분 류");
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setOpaque(true);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(198, 10, 164, 36);
		panel_1.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("금 액");
		lblNewLabel_2.setBackground(Color.WHITE);
		lblNewLabel_2.setOpaque(true);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(374, 10, 164, 36);
		panel_1.add(lblNewLabel_2);

	}
}
