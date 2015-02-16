package nl.datdenkikniet.BKE;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class Main {
	public static boolean logLayout = true;
public static void main(String[] args){
	init();
}
public static void init(){
Screen.createWindow();	
BKELayout.init();
Runnable r = new Runnable(){
	public void run(){
		Screen.updateFrame();
		System.out.println("run");
	}
	};
ScheduledExecutorService service = Executors.newSingleThreadScheduledExecutor();
service.scheduleAtFixedRate(r, 0, 1000, TimeUnit.MILLISECONDS);

}
public static void logAction(LogType action, Executor ex, int changed){
	
}
}
