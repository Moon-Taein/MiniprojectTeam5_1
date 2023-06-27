package frame;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import javax.swing.ScrollPaneConstants;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.DefaultComboBoxModel;

public class InventoryList extends JPanel {
	private JLabel lbltype;
	private JTextField text1;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Create the panel.
	 */
	public InventoryList() {
		setBounds(0, 0, 650, 900);
		setLayout(null);
		
		
		JPanel pnlinven = new JPanel();
		pnlinven.setBounds(49, 55, 550, 450);
		add(pnlinven);
		pnlinven.setLayout(null);
		
		JPanel pnltitle = new JPanel();
		pnltitle.setBackground(Color.LIGHT_GRAY);
		pnltitle.setBounds(0, 0, 550, 45);
		pnlinven.add(pnltitle);
		pnltitle.setLayout(null);
		
		JLabel lblname = new JLabel("이름");
		lblname.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblname.setBounds(54, 10, 67, 25);
		pnltitle.add(lblname);
		
		lbltype = new JLabel("분류");
		lbltype.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lbltype.setBounds(176, 10, 67, 25);
		pnltitle.add(lbltype);
		
		JLabel lblnow = new JLabel("현재재고");
		lblnow.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblnow.setBounds(295, 10, 112, 25);
		pnltitle.add(lblnow);
		
		JLabel lblprice = new JLabel("구매");
		lblprice.setFont(new Font("맑은 고딕", Font.BOLD, 23));
		lblprice.setBounds(450, 10, 67, 25);
		pnltitle.add(lblprice);
		
		JPanel pnlPlus = new JPanel();
		pnlPlus.setBounds(49, 543, 550, 250);
		add(pnlPlus);
		pnlPlus.setLayout(null);
		
		JLabel l1 = new JLabel("이름");
		l1.setFont(new Font("굴림", Font.BOLD, 20));
		l1.setBounds(50, 44, 80, 24);
		pnlPlus.add(l1);
		
		text1 = new JTextField();
		text1.setBounds(174, 44, 160, 24);
		pnlPlus.add(text1);
		text1.setColumns(10);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(174, 86, 160, 24);
		pnlPlus.add(textField);
		
		JLabel l1_1 = new JLabel("소비자가");
		l1_1.setFont(new Font("굴림", Font.BOLD, 20));
		l1_1.setBounds(50, 86, 90, 24);
		pnlPlus.add(l1_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(174, 130, 160, 24);
		pnlPlus.add(textField_1);
		
		JLabel l1_2 = new JLabel("공급가");
		l1_2.setFont(new Font("굴림", Font.BOLD, 20));
		l1_2.setBounds(50, 130, 90, 24);
		pnlPlus.add(l1_2);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(174, 173, 160, 24);
		pnlPlus.add(textField_2);
		
		JLabel l1_3 = new JLabel("재료하한선");
		l1_3.setFont(new Font("굴림", Font.BOLD, 20));
		l1_3.setBounds(50, 173, 112, 24);
		pnlPlus.add(l1_3);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"소스", "토핑", "엣지", "사이드", "음료"}));
		comboBox.setBounds(378, 44, 112, 21);
		pnlPlus.add(comboBox);
		
		JButton btninput = new JButton("재료추가");
		btninput.setBounds(393, 173, 97, 23);
		pnlPlus.add(btninput);
		
		JPanel panel = new JPanel();
		panel.setFocusTraversalPolicyProvider(true);
		panel.setLayout(new GridLayout(20, 1)); 
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		for(int i = 0; i < 20; i++) {
			JPanel pnl1 = new JPanel();
			panel.add(pnl1);
			pnl1.setLayout(null);
			pnl1.setPreferredSize(new Dimension(500, 50));
			
			JLabel lbl1 = new JLabel("불고기 피자");
			lbl1.setHorizontalAlignment(SwingConstants.CENTER);
			lbl1.setFont(new Font("굴림", Font.PLAIN, 19));
			lbl1.setBounds(0, 0, 151, 30);
			pnl1.add(lbl1);
			
			JLabel lbl2 = new JLabel("토핑");
			lbl2.setHorizontalAlignment(SwingConstants.CENTER);
			lbl2.setFont(new Font("굴림", Font.PLAIN, 19));
			lbl2.setBounds(154, 0, 97, 30);
			pnl1.add(lbl2);
			
			JLabel lbl3 = new JLabel("10개");
			lbl3.setHorizontalAlignment(SwingConstants.CENTER);
			lbl3.setFont(new Font("굴림", Font.PLAIN, 19));
			lbl3.setBounds(288, 0, 103, 30);
			pnl1.add(lbl3);
			
			JButton btnbuy = new JButton("확인");
			btnbuy.setBounds(433, 6, 80, 23);
			btnbuy.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					InventoryPlus pop = new InventoryPlus();
					pop.setVisible(true);
				}
			});
			pnl1.add(btnbuy);
			scrollPane.setBounds(0, 45, 550, 405);
			pnlinven.add(scrollPane);
		}		
	}
}
