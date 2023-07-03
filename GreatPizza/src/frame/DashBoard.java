package frame;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JComponent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.KeyStroke;

import repo.Ingredient;
import utilty.PieChart;

public class DashBoard extends JPanel {

	private JLabel background;
	private JTextField text;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	
	public DashBoard(HomeFrame home) {
		setLayout(null);
		setSize(750, 800);
		ImageIcon frame = new ImageIcon("GreatPizza/img//dashboard.png");
		background = new JLabel(frame);
		background.setBounds(0, 0, 750, 800);
		add(background);
		
		PieChart pieChart = new PieChart();
		pieChart.setBounds(468, 108, 200, 200);
		background.add(pieChart);
		
		text = new JTextField();
		text.setBounds(100, 37, 423, 44);
		text.setOpaque(false);
		text.setBorder(null);
		text.setForeground(Color.WHITE);
		text.registerKeyboardAction(new ActionListener() {
		    @Override
		    public void actionPerformed(ActionEvent e) {
		    	String line = text.getText();
		    	if(line.contains("오늘") || line.contains("매출") || line.contains("일") || line.contains("판매") || line.contains("많이") || line.contains("팔린")) {
		    		home.salesbtn.doClick();
		    	} else if(line.contains("주문") || line.contains("미확인")) {
		    		home.buybtn.doClick();
		    	} else if(line.contains("재고") || line.contains("재료")) {
		    		home.inventorybtn.doClick();
		    	} else if(line.contains("메뉴") || line.contains("피자")) {
		    		home.menubtn.doClick();
		    	} else if(line.contains("재정") || line.contains("매입") || line.contains("년") || line.contains("날짜")) {
		    		home.financialbtn.doClick();
		    	} 
		    }
		}, null, KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), JComponent.WHEN_FOCUSED);
		background.add(text);
		text.setColumns(10);
		
		lblNewLabel = new JLabel("New label");
		lblNewLabel.setBounds(78, 232, 57, 15);
		add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBounds(189, 232, 57, 15);
		add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setBounds(302, 232, 57, 15);
		add(lblNewLabel_2);
	}

}
