package nl.datdenkikniet.BKE;

import java.awt.Dimension;

import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class BKELayout {
private static Boolean[] cellsAffected = new Boolean[9];
private static Executor[] whoChanged = new Executor[9];
public static void init(){
	System.out.println(whoChanged.length);
	for (int i = 0; i < whoChanged.length; i++){
		cellsAffected[i] = false;
		whoChanged[i] = Executor.NONE;
	}
	whoChanged[2] = Executor.PLAYER;
}
public static void set(int number, Executor ex){
	cellsAffected[number] = true;
	whoChanged[number] = ex;
	Screen.updateFrame();
	Main.logAction(LogType.MOVE, ex, number);
}
public static void unset(int number, Executor ex){
	cellsAffected[number] = false;
	whoChanged[number] = ex;
	Screen.updateFrame();
	Main.logAction(LogType.MOVE, ex, number);
}
public static JLabel getLayout(){
	String str = "";
	for (int i = 0; i < whoChanged.length; i++){
		if (i%3 == 0){
			str = str + "\n|";
		}
			if (whoChanged[i] == Executor.NONE){
				str = str + " |";
			} else if (whoChanged[i] == Executor.AI){
				str = str + "X|";
			} else if (whoChanged[i] == Executor.PLAYER){
				str = str +  "O|";
			}
		}
	JLabel label = new JLabel(str, SwingConstants.CENTER);
	label.setVisible(true);
	label.setPreferredSize(new Dimension(300,300));
	return label;
}
}
