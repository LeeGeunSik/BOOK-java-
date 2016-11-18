package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainFrame extends JFrame {
	MainGamePanel Gpanel;
	JPanel panel, panel2;
	JButton pause, reset;
	JProgressBar timeBar;
	boolean gameStarted;

	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BOOC");
		this.setLayout(null);
		this.setSize(1500, 1000);
		Gpanel = new MainGamePanel();
		Gpanel.setBounds(0, 0, 50 * 25, 50 * 19);
		add(Gpanel);
		pause = new JButton("���ӽ���");
		pause.setBounds(1260, 700, 100, 50);
		pause.addActionListener(e -> {
			if (!Gpanel.isGameStarted()) {//������ ���� ���۵��� �ʾ�����
				Gpanel.gameStart();
				pause.setText("�Ͻ�����");
			} else if (!Gpanel.isGamePaused()) {//������ ���۵ǰ� �Ͻ��������� �ƴҶ�
				Gpanel.gamePause();
				pause.setText("�����簳");
			} else {//������ ���۵ǰ� �Ͻ��������϶�
				Gpanel.gameResume();
				pause.setText("�Ͻ�����");
			}
		});
		pause.setFocusable(false);
		add(pause);
		reset = new JButton("�ٽý���");
		reset.setBounds(1370, 700, 100, 50);
		reset.addActionListener(e -> {//�ٽý����ϱ� ��ư
			if (Gpanel.isGameStarted()) {//������ ���۵Ǿ������� �۵�
				Gpanel.gameStop();
				Gpanel.gameStart();
			}
		});
		reset.setFocusable(false);
		add(reset);
		setResizable(false);
		setVisible(true);
		this.setFocusable(false);
		Gpanel.requestFocus();
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
