package frame;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import repo.DetailOrder;

import javax.swing.JButton;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.util.List;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;
import java.awt.Component;
import java.awt.Color;
import javax.swing.BoxLayout;

public class BuyListPopup extends JFrame {

	private JPanel contentPane;
	private JPanel inven;
	private JPanel menulist;
	List<DetailOrder> menus;
	
	public BuyListPopup(int no) {
//		menus = getDetailOrders(no);
		initialize();
	}
	
	public void initialize() {
		setBounds(100, 100, 900, 800);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel pane = new JPanel();
		pane.setBounds(70, 57, 345, 577);
		contentPane.add(pane);
		pane.setLayout(null);
		
		JPanel inventory = new JPanel();
		inventory.setBounds(468, 57, 345, 464);
		contentPane.add(inventory);
		inventory.setLayout(null);
		
		JPanel title = new JPanel();
		title.setBackground(Color.LIGHT_GRAY);
		title.setBounds(0, 0, 345, 50);
		inventory.add(title);
		
		JLabel lblNewLabel = new JLabel("재료확인");
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 25));
		title.add(lblNewLabel);
		
		JScrollPane scrollPane2 = new JScrollPane((Component) null);
		scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane2.setBounds(0, 50, 345, 414);
		inventory.add(scrollPane2);
		
		inven = new JPanel();
		inven.setLayout(new BoxLayout(inven, BoxLayout.Y_AXIS));
		scrollPane2.setViewportView(inven);
		
		JButton btncancel = new JButton("주문 취소");
		btncancel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				setVisible(false);
			}
		});
		btncancel.setFont(new Font("굴림", Font.BOLD, 25));
		btncancel.setBounds(468, 560, 345, 50);
		contentPane.add(btncancel);
		
		JButton btn = new JButton("피자 제작 완료");
		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		btn.setFont(new Font("굴림", Font.BOLD, 25));
		btn.setBounds(468, 631, 345, 50);
		contentPane.add(btn);
		
		menulist = new JPanel();
		menulist.setFocusTraversalPolicyProvider(true);
		menulist.setLayout(new GridLayout(20, 1)); 
		JScrollPane scrollPane = new JScrollPane(menulist);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		
		scrollPane.setBounds(0, 0, 345, 578);
		pane.add(scrollPane);
		
		setTexts();
	}
	
	public void setTexts() {
		for (int i= 0; i < 20; i ++) {
			JLabel lbl = new JLabel("도우 - 9999개");
			lbl.setFont(new Font("굴림", Font.BOLD, 20));
			inven.add(lbl);
		}
		for (int i = 0; i < 5; i++) {
			JPanel menu = new JPanel();
			menulist.add(menu);
			menu.setLayout(null);
			menu.setPreferredSize(new Dimension(300, 50));
			
			JRadioButton rdbtn = new JRadioButton("불고기 피자");
			rdbtn.setFont(new Font("굴림", Font.BOLD, 20));
			rdbtn.setBounds(0, 0, 326, 50);
			menu.add(rdbtn);
		}
	}
}
