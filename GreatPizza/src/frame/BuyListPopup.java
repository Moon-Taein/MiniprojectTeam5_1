package frame;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import img.BorderButton;
import img.RoundButton;
import repo.DetailOrder;
import repo.Ingredient;
import repo.MainOrder;
import repo.OrderRepo;

public class BuyListPopup extends JFrame {
    private OrderRepo order;
    private JPanel contentPane;
    private JPanel inven;
    private JPanel menulist;
    private List<DetailOrder> menus;
    private ButtonGroup group;
    private JRadioButton[] rdbtns;
    private MainOrder mainOrder;
    private BuyList buyList;
    private int no;
    private boolean isCan;
	private JLabel back;
	public Color graycolor = Color.decode("#21222D");

    public BuyListPopup(MainOrder currentOrder, BuyList buyList) {
    	this.buyList = buyList;
    	this.mainOrder = currentOrder;
    	this.no = currentOrder.getNo();
    	isCan = true;
        order = new OrderRepo();
        menus = order.getDetailOrders(no);
        initialize();
    }

    public void initialize() {
        setBounds(0, 0, 700, 800);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setBackground(Color.decode("#171821"));
        contentPane.setLayout(null);
        setUndecorated(true);
        setLocation(660, 120);
        
        ImageIcon background = new ImageIcon(getClass().getResource("/영수증.png"));
        back = new JLabel(background);
        back.setBounds(0, 0, 750, 800);
        contentPane.add(back);
        
        JPanel pane = new JPanel();
        pane.setBounds(82, 186, 291, 518);
        back.add(pane);
        pane.setLayout(null);

        JPanel inventory = new JPanel();
        inventory.setBounds(388, 186, 270, 393);
        back.add(inventory);
        inventory.setLayout(null);

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(0, 0,  291, 393);
        scrollPane2.setOpaque(false);
        scrollPane2.getVerticalScrollBar().setPreferredSize(new Dimension(0, 200));
        scrollPane2.setBorder(null);
        inventory.add(scrollPane2);

        inven = new JPanel();
        inven.setBackground(graycolor);
        inven.setLayout(new BoxLayout(inven, BoxLayout.Y_AXIS));
        scrollPane2.setViewportView(inven);

        BorderButton btncancel = new BorderButton("주문 취소");
        btncancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
	            order.updateMainOrder("취소", no);
	            buyList.removeAll();
        		buyList.repaint();
        		buyList.initialize();
	            setVisible(false);
            }
        });
        btncancel.setFont(new Font("굴림", Font.BOLD, 25));
        btncancel.setBounds(384, 597, 283, 50);
        back.add(btncancel);

        RoundButton btn = new RoundButton("피자 제작 완료");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	if (isCan) {
            		updateIngredients();
            		order.plusAccount(mainOrder.getTotalprice(), mainOrder.getDate());
            		order.updateAsset(mainOrder.getDate());
            		order.updateMainOrder("확인", no);
            		buyList.removeAll();
            		buyList.repaint();
            		buyList.initialize();
            		setVisible(false);
            	}
            }
        });
        btn.setFont(new Font("굴림", Font.BOLD, 25));
        btn.setBounds(384, 657, 283, 50);
        back.add(btn);

        menulist = new JPanel();
        menulist.setBackground(graycolor);
        menulist.setLayout(new GridLayout(20, 1));
        JScrollPane scrollPane = new JScrollPane(menulist);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 291, 518);
        scrollPane.setOpaque(false);
        scrollPane.getVerticalScrollBar().setPreferredSize(new Dimension(0, 200));
        scrollPane.setBorder(null);
        pane.add(scrollPane);
        pane.setOpaque(false);
        
        settings();
    }

    public void settings() {
        rdbtns = new JRadioButton[menus.size()];
        group = new ButtonGroup();
        for (int i = 0; i < menus.size(); i++) {
            final DetailOrder menu = menus.get(i);

            rdbtns[i] = new JRadioButton(menu.getMenu());
            rdbtns[i].setFont(new Font("굴림", Font.BOLD, 20));
            rdbtns[i].setForeground(Color.WHITE);
            rdbtns[i].setOpaque(false);
            rdbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    inven.removeAll();
                    inven.repaint();
                    setTexts(menu);
                    inven.revalidate();
                }
            });
            group.add(rdbtns[i]);
            menulist.add(rdbtns[i]);
            if(menu.getCount() != 1) {
            	rdbtns[i].setText(menu.getMenu() + " * " + menu.getCount());
            }
        }
        for (JRadioButton rdbtn : rdbtns) {
        	rdbtn.doClick();
        }
        inven.removeAll();
        inven.repaint();
        rdbtns[0].setSelected(true);
        setTexts(menus.get(0));
    }

    public void setTexts(DetailOrder menu) {
        boolean isLackIngredient = false;

        for (Ingredient ingredient : menu.getIngredients()) {
            JLabel lbl = new JLabel(ingredient.getName() + " - " + ingredient.getCurrentCount());
            lbl.setFont(new Font("굴림", Font.BOLD, 20));
            lbl.setForeground(Color.WHITE);
            inven.add(lbl);

            if (isLack(ingredient)) {
                lbl.setForeground(Color.RED);
                isLackIngredient = true;
            }
        }
        for (Ingredient ingredient : menu.getAddIngredients()) {
            JLabel lbl = new JLabel("(추가재료) " + ingredient.getName() + " - " + ingredient.getCurrentCount());
            lbl.setFont(new Font("굴림", Font.BOLD, 20));
            lbl.setForeground(Color.WHITE);
            inven.add(lbl);

            if (isLack(ingredient)) {
                lbl.setForeground(Color.RED);
                isLackIngredient = true;
            }
        } 
        
        if (isLackIngredient) {
            for (JRadioButton rdbtn : rdbtns) {
                if (rdbtn.isSelected()) {
                    rdbtn.setForeground(Color.RED);
                    isCan = false;
                }
            }
        }
    }

    public boolean isLack(Ingredient ingred) {
        return ingred.getLowerLimitCount() > ingred.getCurrentCount();
    }

    public boolean isLack(DetailOrder menu) {
        Ingredient ingredient = order.getIngredient(menu.getMenu());
        if (ingredient != null) {
            return isLack(ingredient);
        }
        return false;
    }
    
    public void updateIngredients() {
    	for (DetailOrder menu : menus) {
    		for (Ingredient ing : menu.getIngredients()) {
    			order.minusIngredient(menu.getCount(), ing.getId());
    		}
    		for (Ingredient ing : menu.getAddIngredients()) {
    			order.minusIngredient(menu.getCount(), ing.getId());
    		}
    	}
    }
}
