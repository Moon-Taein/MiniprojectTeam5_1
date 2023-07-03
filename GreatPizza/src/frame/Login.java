package frame;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import img.RoundButton;

import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.KeyEventDispatcher;
import java.awt.KeyboardFocusManager;
import java.awt.Shape;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.geom.RoundRectangle2D;

import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JPasswordField;
import javax.swing.ImageIcon;

public class Login extends JFrame {

	private JPanel contentPane;
	private HomeFrame frame;
	private JTextField id;
	private JPasswordField pw;
	public static final Color blackcolor = Color.decode("#171821");

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Login() {
		frame = new HomeFrame();
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 800);
		setLocationRelativeTo(null);

		contentPane = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// JPanel의 배경을 둥근 사각형으로 그리기
				Graphics2D g2 = (Graphics2D) g;
				int arc = 30; // 둥근 모서리의 반지름
				Shape roundedRect = new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), arc, arc);
				g2.setPaint(blackcolor); // 배경색 설정
				g2.fill(roundedRect);
			}
		};

		setContentPane(contentPane);
		contentPane.setLayout(null);

		id = new JTextField();
		id.setBackground(blackcolor);
		id.setText("아이디");
		id.setForeground(Color.WHITE);
		id.setHorizontalAlignment(SwingConstants.CENTER);
		id.setBounds(300, 318, 300, 45);
		id.addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent e) {
				if (id.getText().equals("아이디")) {
					id.setText("");
				}
			}

			@Override
			public void keyPressed(KeyEvent e) {
			}

			@Override
			public void keyReleased(KeyEvent e) {
			}
		});
		contentPane.add(id);

		JLabel lblpw = new JLabel("비밀번호");
		lblpw.setFont(new Font("돋움", Font.PLAIN, 12));
		lblpw.setHorizontalAlignment(SwingConstants.CENTER);
		lblpw.setForeground(Color.WHITE);
		lblpw.setBounds(416, 382, 71, 36);
		contentPane.add(lblpw);

		pw = new JPasswordField();
		pw.setForeground(Color.WHITE);
		pw.setBackground(blackcolor);
		pw.setHorizontalAlignment(SwingConstants.CENTER);
		pw.setBounds(300, 378, 300, 45);
		pw.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				lblpw.setVisible(false);
			}

			@Override
			public void mousePressed(MouseEvent e) {
			}

			@Override
			public void mouseReleased(MouseEvent e) {
			}

			@Override
			public void mouseEntered(MouseEvent e) {
			}

			@Override
			public void mouseExited(MouseEvent e) {
			}
		});
		contentPane.add(pw);

		RoundButton login = new RoundButton("로그인");
		login.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(true);
				setVisible(false);
			}
		});
		login.setFont(new Font("굴림", Font.BOLD, 20));
		login.setBounds(300, 438, 300, 45);
		contentPane.add(login);

		ImageIcon logo = new ImageIcon("GreatPizza/img//logo.png");
		JLabel lbl = new JLabel(logo);
		lbl.setBounds(336, 165, 225, 142);
		contentPane.add(lbl);

		ImageIcon dot = new ImageIcon("GreatPizza/img//Dots.png");
		JLabel dots = new JLabel(dot);
		dots.setBounds(15, 25, 60, 30);
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
				dots.setBounds(15, 22, 60, 30);
			}

			@Override
			public void mouseExited(MouseEvent e) {
				dots.setBounds(15, 25, 60, 30);
			}
		});
		contentPane.add(dots);

		KeyboardFocusManager.getCurrentKeyboardFocusManager().addKeyEventDispatcher(new KeyEventDispatcher() {
			@Override
			public boolean dispatchKeyEvent(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_ENTER && e.getID() == KeyEvent.KEY_RELEASED) {
					login.doClick();
					return true;
				}
				return false;
			}
		});
	}

}
