package game;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Dimension;
import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

public class MainFrame extends JFrame {
	MainGamePanel Gpanel;
	JPanel gameInfo;
	JButton pause,resume,reset;
	JProgressBar timeBar;
	public MainFrame() {
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BOOC");
		this.setLayout(new BorderLayout());
		Gpanel = new MainGamePanel();
		gameInfo = new JPanel();
		gameInfo.add(new JButton());
		timeBar = new JProgressBar();
		timeBar.setPreferredSize(new Dimension(1500, 50));
		add(Gpanel,BorderLayout.CENTER);
		add(gameInfo,BorderLayout.EAST);
		add(timeBar,BorderLayout.SOUTH);
		pack();
		setResizable(false);
		setVisible(true);
		Gpanel.requestFocus();
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
