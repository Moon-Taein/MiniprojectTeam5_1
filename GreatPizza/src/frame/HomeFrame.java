package frame;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class HomeFrame extends JFrame {

    private JPanel contentPane;
    private JPanel cards;
    private CardLayout cardLayout;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HomeFrame frame = new HomeFrame();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public HomeFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 900, 900);
        setLocationRelativeTo(null);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBounds(0, 0, 244, 861);
        contentPane.add(panel);
        panel.setLayout(null);

        JButton btnHome = new JButton("홈");
        btnHome.setBounds(0, 0, 85, 42);
        panel.add(btnHome);

        JButton btnNewButton1 = new JButton("매출");
        btnNewButton1.setBounds(0, 94, 244, 68);
        panel.add(btnNewButton1);

        JButton btnNewButton2 = new JButton("재정");
        btnNewButton2.setBounds(0, 160, 244, 68);
        panel.add(btnNewButton2);

        JButton btnNewButton3 = new JButton("포스");
        btnNewButton3.setBounds(0, 226, 244, 68);
        panel.add(btnNewButton3);

        JButton btnNewButton4 = new JButton("메뉴관리");
        btnNewButton4.setBounds(0, 292, 244, 68);
        panel.add(btnNewButton4);
        
        JButton btnNewButton5 = new JButton("재고관리");
        btnNewButton5.setBounds(0, 358, 244, 68);
        panel.add(btnNewButton5);

        // CardLayout 설정
        cards = new JPanel(new CardLayout());
        cards.setBounds(245, 0, 639, 861);
        contentPane.add(cards, BorderLayout.CENTER);
        
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("매출"));
        panel1.setBackground(Color.WHITE);
        cards.add(panel1, "panel1");

        JPanel panel2 = new JPanel();
        panel2.add(new JLabel("재정"));
        panel2.setBackground(Color.WHITE);
        cards.add(panel2, "panel2");
        
        JPanel panel3 = new JPanel();
        panel3.add(new JLabel("포스"));
        panel3.setBackground(Color.WHITE);
        cards.add(panel3, "panel3");

        JPanel panel4 = new JPanel();
        panel4.add(new JLabel("메뉴관리"));
        panel4.setBackground(Color.WHITE);
        cards.add(panel4, "panel4");
        
        JPanel panel5 = new JPanel();
        panel5.add(new JLabel("재고관리"));
        panel5.setBackground(Color.WHITE);
        cards.add(panel5, "panel4");

        cardLayout = (CardLayout) cards.getLayout();

        btnNewButton1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "panel1");
            }
        });

        btnNewButton2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "panel2");
            }
        });

        btnNewButton3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "panel3");
            }
        });

        btnNewButton4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "panel4");
            }
        });
        
        btnNewButton5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(cards, "panel5");
            }
        });
    }
}
