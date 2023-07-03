package frame;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import repo.Ingredient;
import repo.OrderRepo;

import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;

public class IngredientBuy extends JFrame {

	private JPanel contentPane;
	private IngredientList invenFrame;
	private OrderRepo order;
	private JLabel back;

	public IngredientBuy(Ingredient ingredient, IngredientList invenFrame) {
		LocalDate today = LocalDate.now();
	    String day = today.format(DateTimeFormatter.ofPattern("yyyy-M-d"));
		this.invenFrame = invenFrame;
		order = new OrderRepo();
		setBounds(0, 0, 600, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setUndecorated(true);
		setLocation(740, 570);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.decode("#171821"));
		
		ImageIcon background = new ImageIcon("GreatPizza/img//InPlus.png");
		back = new JLabel(background);
		back.setBounds(0, 0, 600, 300);
		contentPane.add(back);
		
		JLabel lblNewLabel = new JLabel("이 름 :");
		back.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel.setBounds(75, 55, 206, 42);
		
		JLabel lblNewLabel_1 = new JLabel("공 급 가 :");
		back.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_1.setBounds(75, 107, 206, 42);
		
		JLabel lblNewLabel_2 = new JLabel("현재 개수 :");
		back.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setBounds(75, 159, 206, 42);
		
		JLabel lblNewLabel_3 = new JLabel("재료 하한선 :");
		back.add(lblNewLabel_3);
		lblNewLabel_3.setForeground(Color.WHITE);
		lblNewLabel_3.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_3.setBounds(75, 211, 206, 42);
		
		JLabel name = new JLabel(ingredient.getName());
		back.add(name);
		name.setForeground(Color.WHITE);
		name.setFont(new Font("굴림", Font.BOLD, 15));
		name.setBounds(136, 55, 162, 42);
		
		JLabel price = new JLabel(String.valueOf(ingredient.getPriceRetail()));
		back.add(price);
		price.setForeground(Color.WHITE);
		price.setFont(new Font("굴림", Font.BOLD, 15));
		price.setBounds(153, 107, 145, 42);
		
		JLabel current = new JLabel(String.valueOf(ingredient.getCurrentCount()));
		back.add(current);
		current.setForeground(Color.WHITE);
		current.setFont(new Font("굴림", Font.BOLD, 15));
		current.setBounds(163, 159, 135, 42);
		
		JLabel little = new JLabel(String.valueOf(ingredient.getLowerLimitCount()));
		back.add(little);
		little.setForeground(Color.WHITE);
		little.setFont(new Font("굴림", Font.BOLD, 15));
		little.setBounds(173, 211, 125, 42);
		
		
		final JComboBox comboBox = new JComboBox();
		back.add(comboBox);
		comboBox.setModel(new DefaultComboBoxModel(new Integer[] {10, 20, 30, 40, 50, 60, 100}));
		comboBox.setBounds(357, 60, 169, 32);
		
		JButton buy = new JButton("구 매");
		back.add(buy);
		buy.addActionListener(new ActionListener() {
		    public void actionPerformed(ActionEvent arg0) {
		        int plus = (Integer) comboBox.getSelectedItem();
		        int money = ingredient.getPriceSupply()*plus;
		        order.minusAccount(money, day);
		        order.plusIngredient(plus, ingredient.getId());
		        invenFrame.removeAll();
		        invenFrame.repaint();
		        invenFrame.initialize();
		        invenFrame.revalidate();
		        setVisible(false);
		    }
		});

		buy.setBounds(357, 211, 169, 32);
		
		JButton delete = new JButton("삭제");
		back.add(delete);
		delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
		        order.deleteIngredient(ingredient.getId());
		        invenFrame.removeAll();
		        invenFrame.repaint();
		        invenFrame.initialize();
		        invenFrame.revalidate();
		        setVisible(false);
		    }
		});
		delete.setBounds(393, 178, 97, 23);
		
		ImageIcon dot = new ImageIcon("GreatPizza/img//back.png");
		JLabel dots = new JLabel(dot);
		dots.setBounds(3, 1, 60, 30);
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
				dots.setBounds(0, 1, 60, 30);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				dots.setBounds(3, 1, 60, 30);
			}
		});
		back.add(dots);
	}
}
