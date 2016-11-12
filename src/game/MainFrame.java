package game;

import java.awt.Font;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame extends JFrame {
	JPanel Gpanel;
	public MainFrame() {
		this.setSize(800, 800);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setTitle("BOOC");
		Gpanel = new MainGamePanel();
		add(Gpanel);
		setVisible(true);
		Gpanel.requestFocus();
	}

	public static void main(String[] args) {
		new MainFrame();
	}
}
