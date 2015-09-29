package nl.datdenkikniet.BKE;

import java.io.File;
import java.io.FileWriter;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.JOptionPane;

public class Main {
	public static boolean logLayout = false;
	public static int logGames = 0;
	public static File file = new File("log.txt");
	public static void main(String[] args){
		init();
	}
	public static void init(){
		logGames = JOptionPane.showConfirmDialog(null,"Do you want the games to be logged to a .txt?", "Log games to file?",  JOptionPane.YES_NO_OPTION);
		BKELayout.init();	
		Screen.createWindow();
		logAction(LogType.START, null, 0);
		Runnable r = new Runnable(){
			public void run(){
				Screen.updateFrame();
			}
		};
		ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
		service.scheduleAtFixedRate(r, 0, 166, TimeUnit.MILLISECONDS);

	}
	public static void logAction(LogType action, Executor ex, int changed){
		if (action == LogType.SET){
			System.out.println(ex.toString() + " has set slot " + (changed+1));
			logAction(LogType.UPDATE, ex.toString() + " has set slot " + (changed+1) + "\n\n");
		} else if (action == LogType.START){
			System.out.println("Started game");
			logAction(LogType.UPDATE, "Started game\n\n");
		} else if (action == LogType.END){
			System.out.println("Ended game");
			logAction(LogType.UPDATE, "Ended game\n\n");
		} else if (action == LogType.RESTART){
			System.out.println("Restarted game");
			logAction(LogType.UPDATE, "Restarted game\n\n");
		} else if (action == LogType.PLAYERWIN){
			System.out.println("Player won!");
			logAction(LogType.UPDATE," Player won\n\n");
		} else if (action == LogType.AIWIN){
			System.out.println("AI won!");
			logAction(LogType.UPDATE, "AI won\n\n");
		} else if (action == LogType.TIE){
			System.out.println("It's a tie!");
			logAction(LogType.UPDATE, "It's a tie!\n\n");
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
	public static void logAction(LogType update, String nrml) {
		try {
			if (!file.exists()){
				file.createNewFile();

			}
			FileWriter fw = new FileWriter(file.getName(), true);
			fw.write(nrml);
			fw.flush();
			fw.close();
		} catch (Exception ex){

		}
	}
}
