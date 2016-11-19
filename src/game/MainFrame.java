package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainFrame extends JFrame {
	MainGamePanel Gpanel;
	JPanel panel, panel2;
	JButton pause, reset;
	JProgressBar timeBar;
	JLabel timeLabel;
	boolean gameStarted;
	Timer gameTimer;
	TimeChecker task;

	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BOOC");
		this.setLayout(null);
		this.setSize(1500, 1030);
		Gpanel = new MainGamePanel();
		Gpanel.setBounds(0, 0, 50 * 25, 50 * 19);
		add(Gpanel);
		pause = new JButton("게임시작");
		pause.setBounds(1260, 700, 100, 50);
		pause.addActionListener(e -> {
			if (!Gpanel.isGameStarted()) {//게임이 아직 시작되지 않았을때
				gameTimer  = new Timer();
				task = new TimeChecker(timeBar, timeLabel);
				gameTimer.schedule(task, 1000, 1000);
				Gpanel.gameStart();
				pause.setText("일시정지");
			} else if (!Gpanel.isGamePaused()) {//게임이 시작되고 일시정지중이 아닐때
				Gpanel.gamePause();
				task.gamePause = true;
				pause.setText("게임재개");
			} else {//게임이 시작되고 일시정지중일때
				Gpanel.gameResume();
				task.gamePause = false;
				pause.setText("일시정지");
			}
		});
		add(pause);
		reset = new JButton("다시시작");
		reset.setBounds(1370, 700, 100, 50);
		reset.addActionListener(e -> {//다시시작하기 버튼
			if (Gpanel.isGameStarted()) {//게임이 시작되었을때만 작동
				gameTimer.cancel();
				gameTimer = new Timer();
				task = new TimeChecker(timeBar, timeLabel);
				gameTimer.schedule(task, 1000, 1000);
				Gpanel.gameStop();
				Gpanel.gameStart();
			}
		});
		add(reset);
		timeBar = new JProgressBar(0, 60);
		timeBar.setValue(0);
		timeBar.setBounds(0, 50*19, 50*25, 50);
		timeLabel = new JLabel();
		timeLabel.setBounds(50*26, 50*19+15, 200, 30);
		timeLabel.setText("게임을 시작해주세요.");
		add(timeLabel);
		add(timeBar);
		
		setResizable(false);
		setVisible(true);
		Gpanel.requestFocus();
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
