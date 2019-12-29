package view;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

import javax.swing.JLabel;

public class Clock extends Thread{
	private JLabel l;
	public Clock(JLabel l) {
		this.l = l;
		start();
	}
	public void run() {
		DateTimeFormatter timeFormat = DateTimeFormatter.ofPattern("HH:mm:ss");
		while(true) {
			l.setText(LocalTime.now().format(timeFormat));
		}
	}
	
}
