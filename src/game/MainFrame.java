package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
		Gpanel = new MainGamePanel(this);
		Gpanel.setBounds(0, 0, 50 * 25, 50 * 19);
		add(Gpanel);
		pause = new JButton("���ӽ���");
		pause.setBounds(1260, 700, 100, 50);
		pause.addActionListener(e -> {
			if (!Gpanel.isGameStarted()) {//������ ���� ���۵��� �ʾ�����
				gameStart();
			} else if (!Gpanel.isGamePaused()) {//������ ���۵ǰ� �Ͻ��������� �ƴҶ�
				gamePause();
			} else {//������ ���۵ǰ� �Ͻ��������϶�
				gameResume();
			}
		});
		add(pause);
		reset = new JButton("�ٽý���");
		reset.setBounds(1370, 700, 100, 50);
		reset.addActionListener(e -> {//�ٽý����ϱ� ��ư
			if (Gpanel.isGameStarted()) {//������ ���۵Ǿ������� �۵�
				gameRestart();
			}
		});
		add(reset);
		timeBar = new JProgressBar(0, 60);
		timeBar.setValue(0);
		timeBar.setBounds(0, 50*19, 50*25, 50);
		timeLabel = new JLabel();
		timeLabel.setBounds(50*26, 50*19+15, 200, 30);
		timeLabel.setText("������ �������ּ���.");
		add(timeLabel);
		add(timeBar);		setResizable(false);
		setVisible(true);
		Gpanel.requestFocus();
	}
	public void gameStart(){
		gameTimer  = new Timer();
		task = new TimeChecker(this);
		gameTimer.schedule(task, 2000, 1000);
		Gpanel.gameStart();
		pause.setText("�Ͻ�����");
	}
	public void gameStop(){
		gameTimer.cancel();
		Gpanel.gameStop();
		pause.setText("���ӽ���");
	}
	public void gameRestart(){
		gameTimer.cancel();
		gameTimer = new Timer();
		task = new TimeChecker(this);
		gameTimer.schedule(task, 1000, 1000);
		Gpanel.gameStop();
		Gpanel.gameStart();
	}
	public void gamePause(){
		Gpanel.gamePause();
		task.gamePause = true;
		pause.setText("�����簳");
	}
	public void gameResume(){
		Gpanel.gameResume();
		task.gamePause = false;
		pause.setText("�Ͻ�����");
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
