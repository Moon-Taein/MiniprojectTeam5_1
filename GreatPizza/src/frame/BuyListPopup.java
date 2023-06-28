package frame;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;

import repo.DetailOrder;
import repo.Ingredient;
import repo.OrderRepo;

public class BuyListPopup extends JFrame {
    private OrderRepo order;
    private JPanel contentPane;
    private JPanel inven;
    private JPanel menulist;
    private List<DetailOrder> menus;
    private ButtonGroup group;
    private JRadioButton[] rdbtns;
    private int no;

    public BuyListPopup(int no) {
    	this.no = no;
        order = new OrderRepo();
        menus = order.getDetailOrders(no);
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

        JScrollPane scrollPane2 = new JScrollPane();
        scrollPane2.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane2.setBounds(0, 50, 345, 414);
        inventory.add(scrollPane2);

        inven = new JPanel();
        inven.setLayout(new BoxLayout(inven, BoxLayout.Y_AXIS));
        scrollPane2.setViewportView(inven);

        JButton btncancel = new JButton("주문 취소");
        btncancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	order.updateMainOrder("취소", no);
                setVisible(false);
            }
        });
        btncancel.setFont(new Font("굴림", Font.BOLD, 25));
        btncancel.setBounds(468, 560, 345, 50);
        contentPane.add(btncancel);

        JButton btn = new JButton("피자 제작 완료");
        btn.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
            	order.updateMainOrder("확인", no);
                setVisible(false);
            }
        });
        btn.setFont(new Font("굴림", Font.BOLD, 25));
        btn.setBounds(468, 631, 345, 50);
        contentPane.add(btn);

        menulist = new JPanel();
        menulist.setLayout(new GridLayout(20, 1));
        JScrollPane scrollPane = new JScrollPane(menulist);
        scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane.setBounds(0, 0, 345, 578);
        pane.add(scrollPane);

        settings();
    }

    public void settings() {
        rdbtns = new JRadioButton[menus.size()];
        group = new ButtonGroup();
        for (int i = 0; i < menus.size(); i++) {
            DetailOrder menu = menus.get(i);

            rdbtns[i] = new JRadioButton(menu.getMenu());
            rdbtns[i].setFont(new Font("굴림", Font.BOLD, 20));
            rdbtns[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent arg0) {
                    String selectedMenu = ((JRadioButton) arg0.getSource()).getText();
                    inven.removeAll();
                    inven.repaint();
                    setTexts(selectedMenu);
                    inven.revalidate();
                }
            });
            group.add(rdbtns[i]);
            menulist.add(rdbtns[i]);
        }
        
        for(int i = 0; i <menus.size(); i++) {
        	rdbtns[i].setSelected(true);
        	setTexts(rdbtns[i].getText());
        	inven.removeAll();
        	inven.repaint();
        }
        
        rdbtns[0].setSelected(true);
        setTexts(rdbtns[0].getText());
    }

    public void setTexts(String menu) {
        List<Ingredient> ingredients = order.getIngredients(menu);
        Ingredient ingred = order.getIngredient(menu);

        boolean isLackIngredient = false;

        if (ingred != null) {
            JLabel lbl = new JLabel(ingred.getName() + " - " + ingred.getCurrentCount());
            lbl.setFont(new Font("굴림", Font.BOLD, 20));
            inven.add(lbl);

            if (isLack(ingred)) {
                lbl.setForeground(Color.RED);
                isLackIngredient = true;
            }
        }

        for (Ingredient ingredient : ingredients) {
            JLabel lbl = new JLabel(ingredient.getName() + " - " + ingredient.getCurrentCount());
            lbl.setFont(new Font("굴림", Font.BOLD, 20));
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
}
