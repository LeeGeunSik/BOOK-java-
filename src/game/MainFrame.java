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
		pause = new JButton("게임시작");
		pause.setBounds(1260, 700, 100, 50);
		pause.addActionListener(e -> {
			if (!Gpanel.isGameStarted()) {//게임이 아직 시작되지 않았을때
				Gpanel.gameStart();
				pause.setText("일시정지");
			} else if (!Gpanel.isGamePaused()) {//게임이 시작되고 일시정지중이 아닐때
				Gpanel.gamePause();
				pause.setText("게임재개");
			} else {//게임이 시작되고 일시정지중일때
				Gpanel.gameResume();
				pause.setText("일시정지");
			}
		});
		pause.setFocusable(false);
		add(pause);
		reset = new JButton("다시시작");
		reset.setBounds(1370, 700, 100, 50);
		reset.addActionListener(e -> {//다시시작하기 버튼
			if (Gpanel.isGameStarted()) {//게임이 시작되었을때만 작동
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
