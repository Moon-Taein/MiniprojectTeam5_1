package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Color;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class MenuPopupTutorial extends JFrame {

	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MenuPopupTutorial frame = new MenuPopupTutorial();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public MenuPopupTutorial() {
		setSize(new Dimension(524, 528));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 652, 613);
		contentPane = new JPanel();
		contentPane.setSize(new Dimension(652, 613));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		ImageIcon icon = new ImageIcon("GreatPizza/img//Frame88.png");
		JLabel lblNewLabel = new JLabel(icon);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				dispose();
			}
		});
		lblNewLabel.setBounds(0, 0, 652, 613);
		contentPane.add(lblNewLabel);
		setLocationRelativeTo(null);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 50));

	}
}
