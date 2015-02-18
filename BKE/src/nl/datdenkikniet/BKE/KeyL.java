package nl.datdenkikniet.BKE;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyL implements KeyListener {
	public void keyTyped(KeyEvent e) {
	}
	public void keyPressed(KeyEvent e) {
		try {
			char c = e.getKeyChar();
			String s = String.valueOf(c); 
			int i = Integer.valueOf(s);
			if (BKELayout.getCellsAffected()[i-1]){
				Main.errorPopUp("That slot has already been set!");
			} else {
				BKELayout.set(i-1, Executor.PLAYER);
				boolean won = AI.check();
				if (!won){
				AI.doAiStuff(Executor.AI, Executor.PLAYER);
				}
			}
		} catch (Exception ex){
			if (e.getKeyChar() == 'r'){
				Main.notificationPopUp("Restarted the game");
				BKELayout.init();
				Main.logAction(LogType.RESTART, null, 0);
			} else if (e.getKeyChar() == 'e'){
				Main.notificationPopUp("Exited the game");
				Main.logAction(LogType.END, null, 0);
				Main.end();
			}
		}
	}
	public void keyReleased(KeyEvent e) {

	}

}