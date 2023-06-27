package frame;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.Dimension;

public class SalesList extends JPanel {

	private JPanel cardsIncards;
	protected CardLayout cardLayouts;

	public SalesList() {
		setSize(new Dimension(650, 900));
		setLayout(null);

		cardsIncards = new JPanel();
		cardsIncards.setBounds(0, 118, 639, 755);
		add(cardsIncards);
		cardsIncards.setLayout(new CardLayout(0, 0));

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		cardsIncards.add(panel_1, "ccp1");
		panel_1.setLayout(null);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.PINK);
		cardsIncards.add(panel_2, "ccp2");
		panel_2.setLayout(null);

		JButton btnNewButton = new JButton("일 별");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayouts.show(cardsIncards, "ccp1");
			}
		});
		btnNewButton.setBounds(0, 95, 97, 23);
		add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("월 별");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cardLayouts.show(cardsIncards, "ccp2");
			}
		});
		btnNewButton_1.setBounds(97, 95, 97, 23);
		add(btnNewButton_1);
		
		cardLayouts = (CardLayout) cardsIncards.getLayout();
	}

}
