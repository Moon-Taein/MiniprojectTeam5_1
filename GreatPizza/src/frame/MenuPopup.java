package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import javax.swing.ScrollPaneConstants;

public class MenuPopup extends JFrame {
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	public MenuPopup() {
		getContentPane().setBackground(Color.PINK);
		setBackground(Color.PINK);
		setSize(new Dimension(900, 540));
		getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 228, 225));
		panel.setBounds(59, 25, 300, 50);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("분 류");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 86, 30);
		panel.add(lblNewLabel);

		textField = new JTextField();
		textField.setBounds(110, 10, 178, 30);
		panel.add(textField);
		textField.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 228, 225));
		panel_1.setBounds(59, 126, 300, 50);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("사 이 즈");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 86, 30);
		panel_1.add(lblNewLabel_1);

		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(110, 10, 178, 30);
		panel_1.add(textField_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 228, 225));
		panel_2.setBounds(59, 237, 300, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("메 뉴 이 름");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 10, 86, 30);
		panel_2.add(lblNewLabel_2);

		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(110, 10, 178, 30);
		panel_2.add(textField_2);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(255, 228, 225));
		panel_3.setBounds(59, 342, 300, 50);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("소 비 자 가");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 10, 86, 30);
		panel_3.add(lblNewLabel_3);

		textField_3 = new JTextField();
		textField_3.setColumns(10);
		textField_3.setBounds(110, 10, 178, 30);
		panel_3.add(textField_3);

		JButton btnNewButton = new JButton("메 뉴 추 가");
		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setBounds(93, 423, 225, 50);
		getContentPane().add(btnNewButton);

		JComboBox comboBox = new JComboBox();
		comboBox.setToolTipText("분 류\r\n");
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"토 핑", "소 스", "엣 지", "사 이 드", "음 료"}));
		comboBox.setBounds(686, 28, 129, 43);
		getContentPane().add(comboBox);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.PINK);
		panel_4.setBounds(575, 81, 309, 206);
		getContentPane().add(panel_4);

		// JList 생성
		DefaultListModel<String> listModel = new DefaultListModel<>();
		listModel.addElement("토핑_피망");
		listModel.addElement("사이드_핫윙");
		listModel.addElement("사이드_스파게뤼");
		listModel.addElement("음료_사이다");
		listModel.addElement("음료_환타");
		listModel.addElement("항목 6");
		listModel.addElement("항목 7");
		listModel.addElement("항목 8");
		listModel.addElement("항목 9");
		listModel.addElement("항목 10");

		JList<String> list = new JList<>(listModel);
		list.setBackground(Color.WHITE);
		list.setFont(new Font("굴림", Font.PLAIN, 20));
		list.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);

		// JScrollPane 생성 및 JList 추가
		JScrollPane scrollPane = new JScrollPane(list);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_4.add(scrollPane);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(464, 315, 351, 158);
		getContentPane().add(panel_5);
		
		setVisible(true);
	}
}
