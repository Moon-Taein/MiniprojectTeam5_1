package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import repo.Ingredient;
import repo.Menu;
import repo.PosRepo;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;

public class MenuPopup extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private String selectType;

	public MenuPopup() {
		getContentPane().setBackground(Color.PINK);
		setBackground(Color.PINK);
		setSize(new Dimension(900, 540));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(43, 28, 268, 50);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("분 류");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 86, 30);
		panel.add(lblNewLabel);

		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "피자", "토핑", "엣지", "소스", "사이드", "음료" }));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(110, 10, 150, 30);
		panel.add(comboBox_1);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(43, 129, 268, 50);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("사 이 즈");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 86, 30);
		panel_1.add(lblNewLabel_1);

		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(
				new DefaultComboBoxModel(new String[] { "피자 사이즈 M", "피자 사이즈 L", "음료 사이즈 500ML", "음료 사이즈 1.25L" }));
		comboBox_1_1.setBounds(110, 10, 150, 30);
		panel_1.add(comboBox_1_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(43, 240, 268, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("메 뉴 이 름");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 10, 86, 30);
		panel_2.add(lblNewLabel_2);

		textField = new JTextField();
		textField.setHorizontalAlignment(SwingConstants.RIGHT);
		textField.setBounds(110, 10, 146, 30);
		panel_2.add(textField);
		textField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 225));
		panel_3.setBounds(43, 345, 268, 50);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("소 비 자 가");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 10, 86, 30);
		panel_3.add(lblNewLabel_3);

		textField_1 = new JTextField();
		textField_1.setHorizontalAlignment(SwingConstants.RIGHT);
		textField_1.setColumns(10);
		textField_1.setBounds(110, 10, 146, 30);
		panel_3.add(textField_1);

		JButton btnNewButton = new JButton("메 뉴 추 가");
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setBounds(93, 423, 225, 50);
		getContentPane().add(btnNewButton);

		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				selectType = comboBox.getSelectedItem().toString();
				System.out.println(selectType);

			}
		});
		comboBox.setToolTipText("분 류\r\n");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "토 핑", "소 스", "엣 지" }));
		comboBox.setBounds(686, 28, 129, 43);
		getContentPane().add(comboBox);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.PINK);
		panel_4.setBounds(506, 81, 309, 206);
		add(panel_4);

		JPanel scrollablePanel = new JPanel();
		scrollablePanel.setSize(new Dimension(309, 206));
		scrollablePanel.setBackground(Color.WHITE);
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));

		// 패널 내부의 패널 생성

		PosRepo pr = new PosRepo();
		List<Ingredient> list = pr.ingredientID(selectType);
		System.out.println(list);
		for (Ingredient ig : list) {

			JPanel innerPanel = new JPanel();
//			innerPanel.setLayout(new GridLayout(1, 3, 30, 120)); // (행, 열, 글자사이 가로 간격, 격자사이 수직 간격)
//			innerPanel.setBorder(new EmptyBorder(15, 5, 15, 5)); // (위로 간격, 왼쪽 ,아래, 우측) 레이아웃과의 간격

			JLabel nameLabel = new JLabel(ig.getId());
			nameLabel.setHorizontalAlignment(SwingConstants.CENTER);
			nameLabel.setOpaque(true);
			nameLabel.setFont(new Font("굴림", Font.PLAIN, 18));


			// Add the labels to the inner panel
			innerPanel.add(nameLabel);

			scrollablePanel.add(innerPanel);
		}

		// JScrollPane 생성 및 스크롤 가능한 패널 설정
		JScrollPane scrollPane = new JScrollPane(scrollablePanel);
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setPreferredSize(new Dimension(300, 200));
		scrollPane.setBackground(Color.WHITE);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_4.add(scrollPane);

		// JList 생성

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(Color.WHITE);
		panel_5.setBounds(368, 297, 504, 176);
		getContentPane().add(panel_5);

		setVisible(true);
	}
}
