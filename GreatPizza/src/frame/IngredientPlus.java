package frame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.border.LineBorder;

import img.RoundButton;
import repo.OrderRepo;

import java.awt.Color;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

public class IngredientPlus extends JFrame {
	private JTextField name;
	private JTextField priceRetail;
	private JTextField priceSupply;
	private JTextField lowerCount;
	private OrderRepo order;

	public IngredientPlus(IngredientList ingredientList) {
		order = new OrderRepo();
		setSize(750, 350);
		setUndecorated(true);
		setLocation(660, 570);
		
		JPanel pnlPlus = new JPanel();
		pnlPlus.setSize(750, 350);
		pnlPlus.setBackground(Color.decode("#171821"));
		pnlPlus.setLayout(null);
		add(pnlPlus);
		
		ImageIcon background = new ImageIcon("GreatPizza/img//InBuy.png");
		JLabel back = new JLabel(background);
		back.setBounds(0, 0, 750, 350);
		pnlPlus.add(back);
		
		JLabel l1 = new JLabel("이름");
		back.add(l1);
		l1.setForeground(Color.WHITE);
		l1.setFont(new Font("굴림", Font.BOLD, 20));
		l1.setBounds(50, 71, 80, 24);
		
		JLabel l1_1 = new JLabel("소비자가");
		back.add(l1_1);
		l1_1.setForeground(Color.WHITE);
		l1_1.setFont(new Font("굴림", Font.BOLD, 20));
		l1_1.setBounds(50, 123, 90, 24);
		
		JLabel l1_2 = new JLabel("공급가");
		back.add(l1_2);
		l1_2.setForeground(Color.WHITE);
		l1_2.setFont(new Font("굴림", Font.BOLD, 20));
		l1_2.setBounds(50, 178, 90, 24);
		
		JLabel l1_3 = new JLabel("재료하한선");
		back.add(l1_3);
		l1_3.setForeground(Color.WHITE);
		l1_3.setFont(new Font("굴림", Font.BOLD, 20));
		l1_3.setBounds(50, 228, 112, 24);
		
		name = new JTextField();
		back.add(name);
		name.setColumns(10);
		name.setBounds(174, 71, 160, 24);
		
		priceRetail = new JTextField();
		back.add(priceRetail);
		priceRetail.setColumns(10);
		priceRetail.setBounds(174, 123, 160, 24);
		
		priceSupply = new JTextField();
		back.add(priceSupply);
		priceSupply.setColumns(10);
		priceSupply.setBounds(174, 178, 160, 24);
		
		lowerCount = new JTextField();
		back.add(lowerCount);
		lowerCount.setColumns(10);
		lowerCount.setBounds(174, 228, 160, 24);
		
		JPanel panel_1 = new JPanel();
		back.add(panel_1);
		panel_1.setBorder(new LineBorder(new Color(0, 0, 0), 2));
		panel_1.setBounds(386, 68, 200, 163);
		
		JComboBox comboBox = new JComboBox();
		back.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"소스", "토핑", "엣지"}));
		comboBox.setBounds(619, 111, 97, 21);
		
		RoundButton btninput = new RoundButton("재료추가");
		back.add(btninput);
		btninput.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String type = (String) comboBox.getSelectedItem();
				order.insertIngredient(
						name.getText(), priceRetail.getText(), priceSupply.getText(),
						lowerCount.getText(), type);
				setVisible(false);
				ingredientList.removeAll();
				ingredientList.repaint();
				ingredientList.initialize();
				ingredientList.revalidate();
			}
		});
		btninput.setBounds(386, 255, 200, 39);
		
		JButton image = new JButton("이미지");
		back.add(image);
		image.setBounds(619, 71, 97, 23);
		
		ImageIcon dot = new ImageIcon("GreatPizza/img//back.png");
		JLabel dots = new JLabel(dot);
		dots.setBounds(10, 25, 60, 30);
		dots.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				dots.setBounds(5, 25, 60, 30);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				dots.setBounds(10, 25, 60, 30);
			}
		});
		back.add(dots);
	}
}
