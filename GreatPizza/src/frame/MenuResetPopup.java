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

import repo.Ingredient;
import repo.Menu;
import repo.OrderRepo;
import repo.PosRepo;

import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.ScrollPaneConstants;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.awt.event.ActionEvent;

public class MenuResetPopup extends JFrame {
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
	private JButton btnNewButton;
	public static final Color blackcolor = Color.decode("#171821");
	public static final Color graycolor = Color.decode("#21222D");
	public static final Color mintcolor = Color.decode("#A9DFD8");

	private String origin = "";
	private String originType;
	private String originSize;
	private String originName;
	private String originPrice;
	private List<String> originList;

	public MenuResetPopup(MenuList menulist, Menu menu) {
		OrderRepo or = new OrderRepo();
		PosRepo pr = new PosRepo();
		setUndecorated(true);
		getContentPane().setLayout(null);
		getContentPane().setBackground(Color.LIGHT_GRAY);
		setLocation(0,0);
		
		or.getIngredients(menu.getMenuId());
		setSize(new Dimension(668, 626));

		JPanel panel = new JPanel();
		panel.setBackground(graycolor);
		panel.setBounds(17, 63, 251, 50);
		getContentPane().add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("분 류");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(mintcolor);
		lblNewLabel.setBounds(12, 10, 60, 30);
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(graycolor);
		panel_1.setBounds(17, 123, 251, 50);
		getContentPane().add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("사 이 즈");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(mintcolor);
		lblNewLabel_1.setBounds(12, 10, 60, 30);
		panel_1.add(lblNewLabel_1);

		JPanel panel_5 = new JPanel();
		panel_5.setBackground(graycolor);
		panel_5.setBounds(391, 66, 265, 508);
		getContentPane().add(panel_5);
		panel_5.setLayout(null);

		final JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setEnabled(false);

		comboBox_1_1.setBounds(84, 10, 155, 30);
		panel_1.add(comboBox_1_1);

		JButton btnNewButton_1 = new JButton("추가");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				lblNewLabel_5.setIcon(null);
				InputImage ip = new InputImage();
				InputImage.reInputIMAGE(MenuResetPopup.this);

			}
		});
		btnNewButton_1.setBounds(153, 254, 82, 23);
		panel_5.add(btnNewButton_1);
		final JComboBox comboBox = new JComboBox();
		comboBox.setEnabled(false);

		final JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
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
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] { "피자", "사이드", "음료" }));
		comboBox_1.setBackground(Color.WHITE);
		comboBox_1.setBounds(84, 10, 155, 30);
		panel.add(comboBox_1);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(graycolor);
		panel_2.setBounds(17, 183, 251, 50);
		getContentPane().add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("메뉴이름");
		lblNewLabel_2.setForeground(mintcolor);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(12, 10, 60, 30);
		panel_2.add(lblNewLabel_2);

		menuName = new JTextField();
		menuName.setHorizontalAlignment(SwingConstants.RIGHT);
		menuName.setBounds(84, 11, 155, 30);
		panel_2.add(menuName);
		menuName.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(graycolor);
		panel_3.setBounds(17, 243, 251, 50);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_3 = new JLabel("희망가격");
		lblNewLabel_3.setForeground(mintcolor);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBounds(12, 10, 60, 30);
		panel_3.add(lblNewLabel_3);

		hopedPrice = new JTextField();
		hopedPrice.setHorizontalAlignment(SwingConstants.RIGHT);
		hopedPrice.setColumns(10);
		hopedPrice.setBounds(84, 11, 155, 30);
		panel_3.add(hopedPrice);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(graycolor);
		panel_4.setBounds(17, 349, 251, 225);
		getContentPane().add(panel_4);

		final JPanel scrollablePanel = new JPanel();
		scrollablePanel.setLayout(new BoxLayout(scrollablePanel, BoxLayout.Y_AXIS));

		JScrollPane jsp = new JScrollPane(scrollablePanel);
		jsp.setPreferredSize(new Dimension(250, 198));
		jsp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		panel_4.add(jsp);

		JLabel lblNewLabel_4 = new JLabel("사 이 즈");
		lblNewLabel_4.setForeground(mintcolor);
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(12, 11, 60, 25);
		panel_5.add(lblNewLabel_4);

		JLabel lblNewLabel_4_1 = new JLabel("엣지");
		lblNewLabel_4_1.setForeground(mintcolor);
		lblNewLabel_4_1.setSize(new Dimension(60, 20));
		lblNewLabel_4_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_1.setBounds(12, 41, 60, 25);
		panel_5.add(lblNewLabel_4_1);

		JLabel lblNewLabel_4_2 = new JLabel("소 스");
		lblNewLabel_4_2.setForeground(mintcolor);
		lblNewLabel_4_2.setSize(new Dimension(60, 20));
		lblNewLabel_4_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_2.setBounds(12, 71, 60, 25);
		panel_5.add(lblNewLabel_4_2);

		JLabel lblNewLabel_4_3 = new JLabel("토 핑");
		lblNewLabel_4_3.setForeground(mintcolor);
		lblNewLabel_4_3.setSize(new Dimension(60, 20));
		lblNewLabel_4_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_3.setBounds(12, 102, 60, 25);
		panel_5.add(lblNewLabel_4_3);

		JLabel lblNewLabel_4_4 = new JLabel("토 핑");
		lblNewLabel_4_4.setForeground(mintcolor);
		lblNewLabel_4_4.setSize(new Dimension(60, 20));
		lblNewLabel_4_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_4.setBounds(12, 132, 60, 25);
		panel_5.add(lblNewLabel_4_4);

		JLabel lblNewLabel_4_5 = new JLabel("토 핑");
		lblNewLabel_4_5.setForeground(mintcolor);
		lblNewLabel_4_5.setSize(new Dimension(60, 20));
		lblNewLabel_4_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_5.setBounds(12, 162, 60, 25);
		panel_5.add(lblNewLabel_4_5);

		JLabel lblNewLabel_4_6 = new JLabel("토 핑");
		lblNewLabel_4_6.setForeground(mintcolor);
		lblNewLabel_4_6.setSize(new Dimension(60, 20));
		lblNewLabel_4_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_6.setBounds(12, 193, 60, 25);
		panel_5.add(lblNewLabel_4_6);

		JLabel lblNewLabel_4_7 = new JLabel("토 핑");
		lblNewLabel_4_7.setForeground(mintcolor);
		lblNewLabel_4_7.setSize(new Dimension(60, 20));
		lblNewLabel_4_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_7.setBounds(12, 224, 60, 25);
		panel_5.add(lblNewLabel_4_7);

		JLabel lblNewLabel_4_8 = new JLabel("이 미 지");
		lblNewLabel_4_8.setForeground(mintcolor);
		lblNewLabel_4_8.setSize(new Dimension(60, 20));
		lblNewLabel_4_8.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4_8.setBounds(55, 255, 60, 20);
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
		lblNewLabel_5.setForeground(mintcolor);
		lblNewLabel_5.setBounds(26, 283, 215, 215);
		panel_5.add(lblNewLabel_5);

		final JLabel pizzaSize = new JLabel("없 음");
		pizzaSize.setSize(new Dimension(0, 20));
		pizzaSize.setHorizontalAlignment(SwingConstants.CENTER);
		pizzaSize.setBounds(81, 11, 109, 25);
		panel_5.add(pizzaSize);

		JButton btnNewButton_2 = new JButton("취 소");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pizzaSize.setText("없 음");

			}
		});
		btnNewButton_2.setBounds(188, 10, 65, 25);
		panel_5.add(btnNewButton_2);

		JButton btnNewButton_2_1 = new JButton("취 소");
		btnNewButton_2_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				edge.setText("없 음");
			}
		});
		btnNewButton_2_1.setBounds(188, 40, 65, 25);
		panel_5.add(btnNewButton_2_1);

		JButton btnNewButton_2_2 = new JButton("취 소");
		btnNewButton_2_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				sauce.setText("없 음");
			}
		});
		btnNewButton_2_2.setBounds(188, 71, 65, 25);
		panel_5.add(btnNewButton_2_2);

		JButton btnNewButton_2_3 = new JButton("취 소");
		btnNewButton_2_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_1.setText("없 음");
				countCb--;

			}
		});
		btnNewButton_2_3.setBounds(188, 101, 65, 25);
		panel_5.add(btnNewButton_2_3);

		JButton btnNewButton_2_4 = new JButton("취 소");
		btnNewButton_2_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_2.setText("없 음");
				countCb--;

			}
		});
		btnNewButton_2_4.setBounds(188, 131, 65, 25);
		panel_5.add(btnNewButton_2_4);

		JButton btnNewButton_2_4_1 = new JButton("취 소");
		btnNewButton_2_4_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_3.setText("없 음");
				countCb--;

			}
		});
		btnNewButton_2_4_1.setBounds(188, 161, 65, 25);
		panel_5.add(btnNewButton_2_4_1);

		JButton btnNewButton_2_4_2 = new JButton("취 소");
		btnNewButton_2_4_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				topping_4.setText("없 음");
				countCb--;

			}
		});
		btnNewButton_2_4_2.setBounds(188, 192, 65, 25);
		panel_5.add(btnNewButton_2_4_2);

		JButton btnNewButton_2_4_3 = new JButton("취 소");
		btnNewButton_2_4_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				topping_5.setText("없 음");
				countCb--;

			}
		});
		btnNewButton_2_4_3.setBounds(188, 221, 65, 25);
		panel_5.add(btnNewButton_2_4_3);

		comboBox_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String item = (String) comboBox_1_1.getSelectedItem();
				pizzaSize.setText(item);
			}
		});

		comboBox.addActionListener(new ActionListener() {
			private JButton btn;

			public void actionPerformed(ActionEvent arg0) {
				selectType = comboBox.getSelectedItem().toString();
				scrollablePanel.removeAll();

				List<Ingredient> list = pr.ingredientID(selectType);
				for (final Ingredient ig : list) {
					JPanel igPanel = new JPanel();
					JLabel igLabel = new JLabel(ig.getId());
					btn = new JButton("선 택");
					igLabel.setHorizontalAlignment(SwingConstants.LEFT);
					igLabel.setOpaque(true);
					igPanel.add(igLabel);
					igPanel.add(btn);
					igPanel.revalidate();

					btn.addActionListener(new ActionListener() {

						@Override
						public void actionPerformed(ActionEvent e) {

							if (countCb < 5 && selectType.equals("토핑")) {
								if (selectType.equals("토핑") && topping_1.getText().equals("없 음")) {
									topping_1.setText(ig.getId());
									countCb++;

								} else if (selectType.equals("토핑") && topping_2.getText().equals("없 음")) {
									topping_2.setText(ig.getId());
									countCb++;

								} else if (selectType.equals("토핑") && topping_3.getText().equals("없 음")) {
									topping_3.setText(ig.getId());
									countCb++;

								} else if (selectType.equals("토핑") && topping_4.getText().equals("없 음")) {
									topping_4.setText(ig.getId());
									countCb++;

								} else if (selectType.equals("토핑") && topping_5.getText().equals("없 음")) {
									topping_5.setText(ig.getId());
									countCb++;

								}
							} else if (selectType.equals("소스")) {
								sauce.setText(ig.getId());
							} else if (selectType.equals("엣지")) {
								edge.setText(ig.getId());
							}
						}
					});
					scrollablePanel.add(igPanel);
				}
				scrollablePanel.revalidate();
				scrollablePanel.repaint();
			}
		});

		// 메뉴 추가
		JButton btnNewButton = new JButton("메 뉴 수 정");
		btnNewButton.addActionListener(new ActionListener() {
			private List<String> setRecipe;

			public void actionPerformed(ActionEvent e) {

				selectType = comboBox_1.getSelectedItem().toString();
				if (selectType.equals("피자") || selectType.equals("음료")) {
					selectSize = comboBox_1_1.getSelectedItem().toString();
				}
				// 가격
				String setPrice = String.valueOf(hopedPrice.getText());
				// 작성한 이름
				String name = String.valueOf(menuName.getText());

				// 입력된 소스

				setRecipe = new ArrayList<>();
				setRecipe.add(topping_1.getText());
				setRecipe.add(topping_2.getText());
				setRecipe.add(topping_3.getText());
				setRecipe.add(topping_4.getText());
				setRecipe.add(topping_5.getText());
				setRecipe.add(sauce.getText());
				setRecipe.add(edge.getText());

				setRecipe.removeAll(Collections.singleton("없 음"));

				if (name != null || setPrice != null) {
					if (selectType.equals("피자")) {
						pr.dropPizzaRecipe(origin);
						pr.dropPizzaMenu(origin);
						System.out.println("삭제완료");
						pr.InsertPizzaMenu(selectType, name, selectSize, setPrice, sBytes);
						pr.InsertPizzaRecipe(selectType, name, selectSize, setPrice, setRecipe);
						System.out.println("인서트완료");
						addMenuReset();
						menuName.setText(" ");
						hopedPrice.setText(" ");
					} else if (selectType.equals("음료")) {
						System.out.println(setRecipe);
						addMenuReset();
						menuName.setText(" ");
						hopedPrice.setText(" ");
					} else if (selectType.equals("사이드")) {
						System.out.println(setRecipe);
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

		btnNewButton.setBackground(new Color(255, 222, 173));
		btnNewButton.setBounds(439, 578, 186, 38);
		getContentPane().add(btnNewButton);
		comboBox.setToolTipText("분 류\r\n");
		comboBox.setModel(new DefaultComboBoxModel(new String[] { "엣지", "소스", "토핑" }));
		comboBox.setBounds(155, 303, 113, 43);
		getContentPane().add(comboBox);

		JButton btnNewButton_3 = new JButton("메 뉴 삭 제");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				System.out.println(menu.getMenuId().substring(0, menu.getMenuId().indexOf("_")).equals("피자"));
				if (menu.getMenuId().substring(0, menu.getMenuId().indexOf("_")).equals("피자")) {
					pr.dropPizzaRecipe(origin);
					pr.dropPizzaMenu(origin);

				} else {
					System.out.println(origin);
					pr.drupMenu(origin);

				}

				menulist.removeAll();
				menulist.repaint();
				menulist.revalidate();
				menulist.createMenuList();
				setVisible(false);

			}
		});

		addWindowListener(new WindowAdapter() {

			@Override
			public void windowOpened(WindowEvent e) {

				origin = menu.getMenuId();
				originType = origin.substring(0, origin.indexOf("_"));
				if (originType.equals("피자")) {
					originSize = menu.getMenuId()
							.substring(menu.getMenuId().indexOf(menu.getMenuName()) + menu.getMenuName().length());
				} else {
					originSize = "";

				}
				originName = menu.getMenuName();
				originPrice = String.valueOf(menu.getPrice());
				System.out.println(originType);

				comboBox_1.setSelectedItem(originType);
				comboBox_1.setEnabled(false);
				comboBox_1_1.setSelectedItem(originSize);
				btnNewButton_2.setEnabled(false);

				comboBox_1_1.setEnabled(false);
				menuName.setText(originName);
				menuName.setEnabled(false);
				hopedPrice.setText(originPrice);
				System.out.println(pr.originHash(menu.getMenuId()));

				originList = pr.getToppingList(pr.originHash(menu.getMenuId()), menu.getMenuId());

				for (String str : originList) {
					if (str.startsWith("도우_") && pizzaSize.getText().equals("없 음")) {
						pizzaSize.setText(str);
					} else if (str.startsWith("엣지_") && edge.getText().equals("없 음")) {
						edge.setText(str);
					} else if (str.startsWith("소스_") && sauce.getText().equals("없 음")) {
						sauce.setText(str);
					} else if (str.startsWith("토핑_") && topping_1.getText().equals("없 음")) {
						topping_1.setText(str);
						countCb++;
					} else if (str.startsWith("토핑_") && topping_2.getText().equals("없 음")) {
						topping_2.setText(str);
						countCb++;
					} else if (str.startsWith("토핑_") && topping_3.getText().equals("없 음")) {
						topping_3.setText(str);
						countCb++;
					} else if (str.startsWith("토핑_") && topping_4.getText().equals("없 음")) {
						topping_4.setText(str);
						countCb++;
					} else if (str.startsWith("토핑_") && topping_5.getText().equals("없 음")) {
						topping_5.setText(str);
						countCb++;
					}

				}

			}
		});

		btnNewButton_3.setBackground(new Color(255, 222, 173));
		btnNewButton_3.setBounds(45, 578, 186, 38);
		getContentPane().add(btnNewButton_3);

		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 0, 668, 626);
		panel_6.setBackground(blackcolor);
		getContentPane().add(panel_6);
		panel_6.setLayout(null);
		ImageIcon backIcon = new ImageIcon("GreatPizza/img/Frame 94.png");
		JLabel background = new JLabel(backIcon);
		background.setBounds(0, 0, 668, 626);
		panel_6.add(background);

		JPanel panel_7 = new JPanel();
		panel_7.setBounds(12, 56, 262, 242);
		panel_7.setBackground(new Color(0, 0, 0));
		panel_6.add(panel_7);

		JPanel panel_8 = new JPanel();
		panel_8.setBounds(12, 300, 262, 278);
		panel_8.setBackground(new Color(0, 0, 0));
		panel_6.add(panel_8);

		JPanel panel_9 = new JPanel();
		panel_9.setBounds(383, 56, 285, 570);
		panel_9.setBackground(new Color(0, 0, 0));
		panel_6.add(panel_9);
		
		ImageIcon dot = new ImageIcon("GreatPizza/img//back.png");
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
		topping_2.setText("없 음");
		topping_3.setText("없 음");
		topping_4.setText("없 음");
		topping_5.setText("없 음");
		edge.setText("없 음");
		sauce.setText("없 음");
	}

	public void addImage(byte[] fileBytes) {
		sBytes = fileBytes;
		image = new ImageIcon(fileBytes);
		lblNewLabel_5.setIcon(null);
		lblNewLabel_5.setIcon(image);
		lblNewLabel_5.setText("");

	}
}
