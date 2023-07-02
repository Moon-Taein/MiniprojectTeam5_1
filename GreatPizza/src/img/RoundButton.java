package img;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;

import javax.swing.Action;
import javax.swing.JButton;
import javax.swing.JPanel;

public class RoundButton extends JButton {

	public RoundButton() {
		super();
		decorate();
	}

	public RoundButton(String text) {
		super(text);
		decorate();
	}

	public RoundButton(Action action) {
		super(action);
		decorate();
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setBackground(Color.decode("#A9DFD8")); // 배경색 설정
		setFont(new Font("맑은 고딕", Font.BOLD, 13));
		setForeground(Color.BLACK);
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		if (getModel().isArmed()) {
			graphics.setColor(getBackground().darker());
		} else if (getModel().isRollover()) {
			graphics.setColor(getBackground().brighter());
		} else {
			graphics.setColor(getBackground());
		}

		graphics.fillRoundRect(0, 0, width, height, 10, 10);

		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();

		super.paintComponent(g);
	}
}

class RoundBorderButton extends JButton {
	
	private Color firstColor = Color.decode("#0bc4e2");
	private Color borderColor = Color.decode("#0bc4e2");
	private Color hoverColor = Color.decode("#d0f7f3");

	public RoundBorderButton() {
		super();
		decorate();
	}

	public RoundBorderButton(String text) {
		super(text);
		decorate();
	}
	
	public void setBorderColor(Color border) {
		firstColor = border;
		borderColor = border;
		setForeground(border);
	}
	public void setHoverColor(Color hover) {
		hoverColor = hover;
	}

	protected void decorate() {
		setBorderPainted(false);
		setOpaque(false);
		setFont(new Font("맑은 고딕", Font.BOLD, 13));
		setForeground(borderColor);
		addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				borderColor = hoverColor;
				setForeground(hoverColor);
				repaint();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				borderColor = firstColor;
				setForeground(firstColor);
				repaint();
			}
		});
	}

	@Override
	protected void paintComponent(Graphics g) {
		int width = getWidth();
		int height = getHeight();

		Graphics2D graphics = (Graphics2D) g;

		graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

		graphics.setColor(borderColor);
		graphics.setStroke(new BasicStroke(2)); // 보더 굵기 설정
		graphics.drawRoundRect(0, 0, width - 1, height - 1, 10, 10); // 보더 그리기

		FontMetrics fontMetrics = graphics.getFontMetrics();
		Rectangle stringBounds = fontMetrics.getStringBounds(this.getText(), graphics).getBounds();

		int textX = (width - stringBounds.width) / 2;
		int textY = (height - stringBounds.height) / 2 + fontMetrics.getAscent();

		graphics.setColor(getForeground());
		graphics.setFont(getFont());
		graphics.drawString(getText(), textX, textY);
		graphics.dispose();

		super.paintComponent(g);
	}
}

