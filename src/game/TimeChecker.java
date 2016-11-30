package game;

import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;

public class TimeChecker extends TimerTask {

	MainFrame m;
	int time;
	public boolean gamePause;

	public TimeChecker(MainFrame m) {
		// TODO Auto-generated constructor stub
		this.m = m;
		this.time = 60;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!gamePause) {
			time--;
			m.timeBar.setValue(time);
			m.timeLabel.setText("남은 시간 :" + time);
			m.timeLabel.repaint();
		}
		if (time <= 0||!m.Gpanel.isGameStarted()) {
			m.gameStop();
			m.timeLabel.setText("게임종료");
			m.Gpanel.repaint();
			m.timeBar.setValue(0);
		}

	}

}
