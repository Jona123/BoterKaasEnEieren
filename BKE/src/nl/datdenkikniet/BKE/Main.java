package nl.datdenkikniet.BKE;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Main {
	public static boolean logLayout = false;
	public static void main(String[] args){
		init();
	}
	public static void init(){
		BKELayout.init();	
		Screen.createWindow();
		logAction(LogType.START, null, 0);
		Runnable r = new Runnable(){
			public void run(){
				Screen.updateFrame();
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(r, 0, 1000, TimeUnit.MILLISECONDS);

	}
	public static void logAction(LogType action, Executor ex, int changed){
		if (action == LogType.SET){
			System.out.println(ex.toString() + " has set slot " + changed);
		} else if (action == LogType.START){
			System.out.println("Started game");
		} else if (action == LogType.END){
			System.out.println("Ended game");
		} else if (action == LogType.RESTART){
			System.out.println("Restarted game");
		} else if (action == LogType.PLAYERWIN){
			System.out.println("Player won!");
		} else if (action == LogType.AIWIN){
			System.out.println("AI won!");
		}
	}

	public static void errorPopUp(String text){
		JOptionPane.showMessageDialog(null, text, "Error performing action", JOptionPane.ERROR_MESSAGE);	
	}
	public static void notificationPopUp(String text){
		JOptionPane.showMessageDialog(null, text, "Notification", JOptionPane.INFORMATION_MESSAGE);	
	}
	public static void end() {
		Screen.stop();
	}
}
