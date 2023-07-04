package frame;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Dimension;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.basic.BasicScrollBarUI;


import frame.MenuList.CustomScrollBarUI;
import img.RoundButton;
import repo.Ingredient;
import repo.Menu;
import repo.PosRepo;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Rectangle;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MenuPopup extends JFrame {
	private JTextField menuName;
	private JTextField hopedPrice;
	private String selectType;
	private String selectSize;
	private JPanel scrollablePanel;
	private JCheckBox cb;
	private JRadioButton rb;
	private PosRepo pr = new PosRepo();
	private int countCb = 0;
	private JLabel topping_5;
	private JLabel topping_4;
	private JLabel topping_3;
	private JLabel topping_2;
	private JLabel topping_1;
	private JLabel edge;
	private JLabel sauce;
	private ImageIcon image;
	private JLabel lblNewLabel_5;
	private byte[] sBytes;
	private RoundButton btnNewButton;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");
	private JLabel pizzaSize;

// 메뉴 추가

	public MenuPopup(MenuList menulist) {
		pr = new PosRepo();
		getContentPane().setBackground(graycolor);
		setSize(new Dimension(671, 622));
		setLocationRelativeTo(null);
		setUndecorated(true);
		getContentPane().setLayout(null);
		setLocation(700, 250);

		final JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);
		ImageIcon tutoImage = new ImageIcon(getClass().getResource("/튜토리얼.png"));
		JLabel tuto = new JLabel(tutoImage);
		tuto.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tuto.setVisible(false);
			}
		});
		tuto.setBounds(0, 0, 671, 622);
		getContentPane().add(tuto);

		JPanel panel = new JPanel();
		panel.setBackground(graycolor);
		panel.setBounds(17, 54, 251, 50);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("분 류");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 60, 30);
		lblNewLabel.setForeground(mintcolor);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(17, 114, 251, 50);
		panel_1.setForeground(blackcolor);
		panel_1.setBackground(graycolor);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("사 이 즈");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(12, 10, 60, 30);
		lblNewLabel_1.setForeground(mintcolor);
		panel_1.add(lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(graycolor);
		panel_5.setBounds(394, 54, 265, 517);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);

		final JComboBox comboBox_1_1 = new JComboBox();

		comboBox_1_1.setBounds(84, 10, 155, 30);
		comboBox_1_1.setEnabled(false);
		panel_1.add(comboBox_1_1);

		RoundButton btnNewButton_1 = new RoundButton("추가");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InputImage ip = new InputImage();
				ip.inputIMAGE(MenuPopup.this);

			}
		});
		btnNewButton_1.setBounds(143, 270, 82, 23);
		btnNewButton_1.setForeground(Color.WHITE);
		panel_5.add(btnNewButton_1);

		RoundButton btnNewButton_3 = new RoundButton("확 정");
		RoundButton btnNewButton_3_1 = new RoundButton("수 정");

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				btnNewButton_3.setEnabled(true);
				String type = (String) comboBox_1.getSelectedItem();

				if (type.equals("피자")) {
					comboBox.setEnabled(true);
					comboBox_1_1.setEnabled(true);
					comboBox_1_1.removeAllItems();
					comboBox_1_1.addItem("M");
					comboBox_1_1.addItem("L");
				} else if (type.equals("음료")) {
					comboBox.setEnabled(false);
					comboBox_1_1.setEnabled(true);
					comboBox_1_1.removeAllItems();
					comboBox_1_1.addItem("500ML");
					comboBox_1_1.addItem("1.25L");
				} else {
					comboBox.setEnabled(false);
					comboBox_1_1.setEnabled(false);
				}
			}
		});
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { " ", "피자", "사이드", "음료" }));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(84, 10, 155, 30);
		panel.add(comboBox_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(graycolor);
		;
		panel_2.setBounds(17, 174, 251, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("메뉴이름");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(mintcolor);
		lblNewLabel_2.setBounds(12, 10, 60, 30);
		panel_2.add(lblNewLabel_2);

		JLabel nameNotion = new JLabel("이름을 입력하세요");
		nameNotion.setForeground(Color.PINK);
		nameNotion.setHorizontalAlignment(SwingConstants.CENTER);
		nameNotion.setBounds(86, 10, 153, 30);
		nameNotion.setVisible(false);

		menuName = new JTextField();
		menuName.setHorizontalAlignment(SwingConstants.RIGHT);
		menuName.setBounds(84, 11, 155, 30);
		menuName.setColumns(10);

		panel_2.add(nameNotion);
		panel_2.add(menuName);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(graycolor);
		panel_3.setBounds(17, 234, 251, 50);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel priceNotion = new JLabel("숫자를 입력하세요");
		priceNotion.setForeground(Color.PINK);
		priceNotion.setHorizontalAlignment(SwingConstants.CENTER);
		priceNotion.setBounds(86, 10, 153, 30);
		priceNotion.setVisible(false);
		panel_3.add(priceNotion);

		JLabel lblNewLabel_3 = new JLabel("희망가격");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setForeground(mintcolor);
		lblNewLabel_3.setBounds(12, 10, 60, 30);
		panel_3.add(lblNewLabel_3);

		hopedPrice = new JTextField();
		hopedPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		hopedPrice.setColumns(10);
		hopedPrice.setBounds(84, 11, 155, 30);
		panel_3.add(hopedPrice);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(graycolor);
		panel_4.setBounds(17, 404, 251, 208);
		getContentPane().add(panel_4);

		final JPanel scrollablePanel = new JPanel();
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));

		comboBox.addActionListener(new ActionListener() {
			private RoundButton btn;

			public void actionPerformed(ActionEvent arg0) {
				selectType = comboBox.getSelectedItem().toString();
				scrollablePanel.removeAll();
				countCb = 0;

				List<Ingredient> list = pr.ingredientID(selectType);
				for (final Ingredient ig : list) {
					JPanel igPanel = new JPanel();
					JLabel igLabel = new JLabel(ig.getId());
					btn = new RoundButton("선택");
					igLabel.setHorizontalAlignment(SwingConstants.LEFT);
					igLabel.setOpaque(true);
					igPanel.add(igLabel);
					igPanel.add(btn);
					igPanel.revalidate();

					btn.addActionListener(new ActionListener() {
						@Override
						public void actionPerformed(ActionEvent e) {
							if (countCb < 5 && selectType.equals("토핑")) {
								if (countCb == 0 && selectType.equals("토핑")) {
									topping_1.setText(ig.getId());
									topping_1.setForeground(Color.WHITE);
									countCb++;
								} else if (countCb == 1 && selectType.equals("토핑")) {
									topping_2.setText(ig.getId());
									topping_2.setForeground(Color.WHITE);
									countCb++;
								} else if (countCb == 2 && selectType.equals("토핑")) {
									topping_3.setText(ig.getId());
									topping_3.setForeground(Color.WHITE);
									countCb++;
								} else if (countCb == 3 && selectType.equals("토핑")) {
									topping_4.setText(ig.getId());
									topping_4.setForeground(Color.WHITE);
									countCb++;
								} else if (countCb == 4 && selectType.equals("토핑")) {
									topping_5.setText(ig.getId());
									topping_5.setForeground(Color.WHITE);
									countCb++;
								}
							} else if (selectType.equals("소스")) {
								sauce.setText(ig.getId());
								sauce.setForeground(Color.WHITE);
							} else if (selectType.equals("엣지")) {
								edge.setText(ig.getId());
								edge.setForeground(Color.WHITE);
							}
						}
					});
					scrollablePanel.add(igPanel);
				}
				scrollablePanel.revalidate();
				scrollablePanel.repaint();
			}
		});
		comboBox.setToolTipText("분 류\r\n");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "엣지", "소스", "토핑" }));
		comboBox.setBounds(154, 372, 113, 28);
		getContentPane().add(comboBox);

		JScrollPane jsp = new JScrollPane(scrollablePanel);
		jsp.setPreferredSize(new Dimension(250, 198));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		jsp.getVerticalScrollBar().setBackground(Color.WHITE); // 스크롤 바 배경
		jsp.getVerticalScrollBar().setUnitIncrement(15); // 스크롤 바 속도
		jsp.getVerticalScrollBar().setPreferredSize(new Dimension(5, 200));
		jsp.getVerticalScrollBar().setUI(new CustomScrollBarUI()); // 뭔지 모르는데 UI 설정
		panel_4.add(jsp);

		JLabel lblNewLabel_4 = new JLabel("사 이 즈");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setForeground(mintcolor);
		lblNewLabel_4.setBounds(12, 11, 60, 25);
		panel_5.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("엣지");
		lblNewLabel_4_1.setSize(new Dimension(60, 20));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setForeground(mintcolor);
		lblNewLabel_4_1.setBounds(12, 41, 60, 25);
		panel_5.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("소 스");
		lblNewLabel_4_2.setSize(new Dimension(60, 20));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setForeground(mintcolor);
		lblNewLabel_4_2.setBounds(12, 71, 60, 25);
		panel_5.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("토 핑");
		lblNewLabel_4_3.setSize(new Dimension(60, 20));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setBounds(12, 102, 60, 25);
		lblNewLabel_4_3.setForeground(mintcolor);
		panel_5.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_4 = new JLabel("토 핑");
		lblNewLabel_4_4.setSize(new Dimension(60, 20));
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setBounds(12, 132, 60, 25);
		lblNewLabel_4_4.setForeground(mintcolor);
		panel_5.add(lblNewLabel_4_4);

		JLabel lblNewLabel_4_5 = new JLabel("토 핑");
		lblNewLabel_4_5.setSize(new Dimension(60, 20));
		lblNewLabel_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_5.setBounds(12, 162, 60, 25);
		lblNewLabel_4_5.setForeground(mintcolor);
		panel_5.add(lblNewLabel_4_5);

		JLabel lblNewLabel_4_6 = new JLabel("토 핑");
		lblNewLabel_4_6.setSize(new Dimension(60, 20));
		lblNewLabel_4_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_6.setBounds(12, 193, 60, 25);
		lblNewLabel_4_6.setForeground(mintcolor);
		panel_5.add(lblNewLabel_4_6);

		JLabel lblNewLabel_4_7 = new JLabel("토 핑");
		lblNewLabel_4_7.setSize(new Dimension(60, 20));
		lblNewLabel_4_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_7.setBounds(12, 224, 60, 25);
		lblNewLabel_4_7.setForeground(mintcolor);
		panel_5.add(lblNewLabel_4_7);

		JLabel lblNewLabel_4_8 = new JLabel("이 미 지");
		lblNewLabel_4_8.setSize(new Dimension(60, 20));
		lblNewLabel_4_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_8.setForeground(mintcolor);
		lblNewLabel_4_8.setBounds(54, 271, 60, 20);
		panel_5.add(lblNewLabel_4_8);

		edge = new JLabel("없 음");
		edge.setSize(new Dimension(0, 20));
		edge.setHorizontalAlignment(SwingConstants.CENTER);
		edge.setBounds(81, 41, 109, 25);
		panel_5.add(edge);

		sauce = new JLabel("없 음");
		sauce.setSize(new Dimension(0, 20));
		sauce.setHorizontalAlignment(SwingConstants.CENTER);
		sauce.setBounds(81, 71, 109, 25);
		panel_5.add(sauce);

		topping_1 = new JLabel("없 음");
		topping_1.setSize(new Dimension(0, 20));
		topping_1.setHorizontalAlignment(SwingConstants.CENTER);
		topping_1.setBounds(81, 102, 109, 25);
		panel_5.add(topping_1);

		topping_2 = new JLabel("없 음");
		topping_2.setSize(new Dimension(0, 20));
		topping_2.setHorizontalAlignment(SwingConstants.CENTER);
		topping_2.setBounds(81, 132, 109, 25);
		panel_5.add(topping_2);

		topping_3 = new JLabel("없 음");
		topping_3.setSize(new Dimension(0, 20));
		topping_3.setHorizontalAlignment(SwingConstants.CENTER);
		topping_3.setBounds(81, 162, 109, 25);
		panel_5.add(topping_3);

		topping_4 = new JLabel("없 음");
		topping_4.setSize(new Dimension(0, 20));
		topping_4.setHorizontalAlignment(SwingConstants.CENTER);
		topping_4.setBounds(81, 193, 109, 25);
		panel_5.add(topping_4);

		topping_5 = new JLabel("없 음");
		topping_5.setSize(new Dimension(0, 20));
		topping_5.setHorizontalAlignment(SwingConstants.CENTER);
		topping_5.setBounds(81, 224, 109, 25);
		panel_5.add(topping_5);

		lblNewLabel_5 = new JLabel("이 미 지 출 력");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setBounds(27, 295, 215, 215);
		lblNewLabel_5.setForeground(mintcolor);
		panel_5.add(lblNewLabel_5);

		pizzaSize = new JLabel("없 음");
		pizzaSize.setSize(new Dimension(0, 20));
		pizzaSize.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaSize.setBounds(81, 11, 109, 25);
		panel_5.add(pizzaSize);

		RoundButton btnNewButton_2_1 = new RoundButton("취 소");
		btnNewButton_2_1.setForeground(Color.WHITE);
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edge.setText("없 음");
				edge.setForeground(blackcolor);
			}
		});
		btnNewButton_2_1.setBounds(188, 40, 65, 25);
		panel_5.add(btnNewButton_2_1);

		RoundButton btnNewButton_2_2 = new RoundButton("취 소");
		btnNewButton_2_2.setForeground(Color.WHITE);
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sauce.setText("없 음");
				sauce.setForeground(blackcolor);
			}
		});
		btnNewButton_2_2.setBounds(188, 71, 65, 25);
		panel_5.add(btnNewButton_2_2);

		RoundButton btnNewButton_2_3 = new RoundButton("취 소");
		btnNewButton_2_3.setForeground(Color.WHITE);
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_1.setText("없 음");
				topping_1.setForeground(blackcolor);
			}
		});
		btnNewButton_2_3.setBounds(188, 101, 65, 25);
		panel_5.add(btnNewButton_2_3);

		RoundButton btnNewButton_2_4 = new RoundButton("취 소");
		btnNewButton_2_4.setForeground(Color.WHITE);
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_2.setText("없 음");
				topping_2.setForeground(blackcolor);
			}
		});
		btnNewButton_2_4.setBounds(188, 131, 65, 25);
		panel_5.add(btnNewButton_2_4);

		RoundButton btnNewButton_2_4_1 = new RoundButton("취 소");
		btnNewButton_2_4_1.setForeground(Color.WHITE);
		btnNewButton_2_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_3.setText("없 음");
				topping_3.setForeground(blackcolor);
			}
		});
		btnNewButton_2_4_1.setBounds(188, 161, 65, 25);
		panel_5.add(btnNewButton_2_4_1);

		RoundButton btnNewButton_2_4_2 = new RoundButton("취 소");
		btnNewButton_2_4_2.setForeground(Color.WHITE);
		btnNewButton_2_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_4.setText("없 음");
				topping_4.setForeground(blackcolor);
			}
		});
		btnNewButton_2_4_2.setBounds(188, 192, 65, 25);
		panel_5.add(btnNewButton_2_4_2);

		RoundButton btnNewButton_2_4_3 = new RoundButton("취 소");
		btnNewButton_2_4_3.setForeground(Color.WHITE);
		btnNewButton_2_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_5.setText("없 음");
				topping_5.setForeground(blackcolor);

			}
		});
		btnNewButton_2_4_3.setBounds(188, 221, 65, 25);
		panel_5.add(btnNewButton_2_4_3);

		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = (String) comboBox_1_1.getSelectedItem();
				pizzaSize.setText(item);
				pizzaSize.setForeground(Color.white);
			}
		});

		RoundButton btnNewButton = new RoundButton("메 뉴 추 가");
		btnNewButton.setBackground(mintcolor);
		btnNewButton.setForeground(Color.white);
		btnNewButton.addActionListener(new ActionListener() {
			private List<String> list;

			public void actionPerformed(ActionEvent e) {
				selectType = comboBox_1.getSelectedItem().toString();
				if (selectType.equals("피자") || selectType.equals("음료")) {
					selectSize = comboBox_1_1.getSelectedItem().toString();
				}
				// 가격
				String price = String.valueOf(hopedPrice.getText());
				// 작성한 이름
				String name = String.valueOf(menuName.getText());
				// 입력된 소스
				String selectSauce = sauce.getText();
				String selectEdge = edge.getText();

				list = new ArrayList<>();

				if (!selectSauce.equals("없 음")) {
					list.add(selectSauce);
				}
				if (!selectEdge.equals("없 음")) {
					list.add(selectEdge);
				}
				if (!topping_1.getText().equals("없 음")) {
					list.add(topping_1.getText());
				}
				if (!topping_2.getText().equals("없 음")) {
					list.add(topping_2.getText());
				}
				if (!topping_3.getText().equals("없 음")) {
					list.add(topping_3.getText());
				}
				if (!topping_4.getText().equals("없 음")) {
					list.add(topping_4.getText());
				}
				if (!topping_5.getText().equals("없 음")) {
					list.add(topping_5.getText());
				}

				if (name != null || price != null) {
					if (selectType.equals("피자")) {
						pr.InsertPizzaMenu(selectType, name, selectSize, price, sBytes);
						pr.InsertPizzaRecipe(selectType, name, selectSize, price, list);
						addMenuReset();
						menuName.setText(" ");
						hopedPrice.setText(" ");
					} else if (selectType.equals("음료")) {
						pr.InsertDrink(selectType, name, selectSize, price, sBytes);
						addMenuReset();
						menuName.setText(" ");
						hopedPrice.setText(" ");
					} else if (selectType.equals("사이드")) {
						pr.InsertSide(selectType, name, price, sBytes);
						addMenuReset();
						menuName.setText(" ");
						hopedPrice.setText(" ");
					}
				} else {
					System.out.println(" 입력은 하고 하는거냐! ");
				}
				menulist.removeAll();
				menulist.repaint();
				menulist.revalidate();
				menulist.createMenuList();
				setVisible(false);
			}
		});

		// 메뉴를 추가하는 행위를 제한하기 위한 불가능상태조정
		btnNewButton.setEnabled(false);

		btnNewButton.setBounds(438, 574, 186, 38);
		getContentPane().add(btnNewButton);

		btnNewButton_3.setEnabled(false);
		btnNewButton_3_1.setEnabled(false);
		btnNewButton_3.setForeground(Color.WHITE);

		// 확정버튼 액션리스너
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Pattern pattern = Pattern.compile("[0-9]{1,}");
				Matcher matcher = pattern.matcher(hopedPrice.getText());
				priceNotion.setVisible(false);

				if (menuName.getText().equals("")) {
					nameNotion.setVisible(true);
				} else {
					nameNotion.setVisible(false);
				}

				if (matcher.matches()) {
					if (!menuName.getText().equals("") && !hopedPrice.getText().equals("") && selectType != "") {
						btnNewButton.setEnabled(true);
						menuName.setEnabled(false);
						hopedPrice.setEnabled(false);
						btnNewButton_3.setEnabled(false);
						btnNewButton_3_1.setEnabled(true);
					}
				} else {
					priceNotion.setVisible(true);
				}
			}
		});
		btnNewButton_3.setBounds(201, 294, 67, 28);
		getContentPane().add(btnNewButton_3);

		btnNewButton_3_1.setForeground(Color.WHITE);
		btnNewButton_3_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnNewButton.setEnabled(false);
				menuName.setEnabled(true);
				hopedPrice.setEnabled(true);
				btnNewButton_3.setEnabled(true);
				btnNewButton_3_1.setEnabled(false);

			}
		});
		btnNewButton_3_1.setBounds(123, 294, 67, 28);
		getContentPane().add(btnNewButton_3_1);

		ImageIcon icon = new ImageIcon(getClass().getResource("/Frame 94.png"));
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(blackcolor);
		panel_6.setBounds(0, 0, 671, 622);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);

		JPanel panel_7 = new JPanel();
		panel_7.setBackground(blackcolor);
		panel_7.setBounds(12, 47, 262, 282);
		panel_6.add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBackground(blackcolor);
		panel_8.setBounds(12, 360, 262, 262);
		panel_6.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBackground(blackcolor);
		panel_9.setBounds(386, 47, 280, 570);
		panel_6.add(panel_9);

		JLabel background = new JLabel(icon);
		background.setBounds(0, 0, 671, 622);
		panel_6.add(background);

		ImageIcon dot = new ImageIcon(getClass().getResource("/back.png"));
		JLabel dots = new JLabel(dot);
		dots.setBounds(5, 7, 60, 30);
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
				dots.setBounds(1, 7, 60, 30);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				dots.setBounds(5, 7, 60, 30);
			}
		});
		background.add(dots);

		setVisible(true);

	}

	public void addMenuReset() {
		topping_1.setText("없 음");
		topping_1.setForeground(blackcolor);
		topping_2.setText("없 음");
		topping_2.setForeground(blackcolor);
		topping_3.setText("없 음");
		topping_3.setForeground(blackcolor);
		topping_4.setText("없 음");
		topping_4.setForeground(blackcolor);
		topping_5.setText("없 음");
		topping_5.setForeground(blackcolor);
		edge.setText("없 음");
		edge.setForeground(blackcolor);
		sauce.setText("없 음");
		sauce.setForeground(blackcolor);
		pizzaSize.setForeground(blackcolor);
	}

	public void addImage(byte[] bytes) {
		sBytes = bytes;
		image = new ImageIcon(bytes);
		lblNewLabel_5.setIcon(null);
		lblNewLabel_5.setIcon(image);
		lblNewLabel_5.setText("");
	}

	static class CustomScrollBarUI extends BasicScrollBarUI {

		@Override
		protected void configureScrollBarColors() {
			// ScrollBar의 색상 설정
			thumbColor = mintcolor;
			thumbDarkShadowColor = Color.BLUE;
			thumbHighlightColor = Color.GREEN;
			thumbLightShadowColor = Color.YELLOW;
		}

		@Override
		protected void paintThumb(Graphics g, JComponent c, Rectangle thumbBounds) {
			// Thumb의 디자인을 그림
			// 예시로 단색의 Thumb을 그리는 코드를 작성하겠습니다.
			g.setColor(thumbColor);
			g.fillRect(thumbBounds.x, thumbBounds.y, thumbBounds.width, thumbBounds.height);
		}

		@Override
		protected JButton createDecreaseButton(int orientation) {
			return createZeroButton();
		}

		@Override
		protected JButton createIncreaseButton(int orientation) {
			return createZeroButton();
		}

		private JButton createZeroButton() {
			JButton button = new JButton();
			Dimension zeroDim = new Dimension(0, 0);
			button.setPreferredSize(zeroDim);
			button.setMinimumSize(zeroDim);
			button.setMaximumSize(zeroDim);
			return button;
		}
	}
}
