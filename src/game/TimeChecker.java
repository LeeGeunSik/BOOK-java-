package game;

import java.util.TimerTask;

import javax.swing.JLabel;
import javax.swing.JProgressBar;

public class TimeChecker extends TimerTask {

	JProgressBar timeBar;
	JLabel timeLabel;
	int time;
	public boolean gamePause;

	public TimeChecker(JProgressBar timeBar, JLabel time) {
		// TODO Auto-generated constructor stub
		this.timeLabel = time;
		this.timeBar = timeBar;
		this.time = 60;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		if (!gamePause) {
			time--;
			timeBar.setValue(time);
			timeLabel.setText("남은 시간 :" + time);
			timeLabel.repaint();

		}

	}

}
