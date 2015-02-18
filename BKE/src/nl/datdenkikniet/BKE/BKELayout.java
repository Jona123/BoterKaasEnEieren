package nl.datdenkikniet.BKE;

import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class BKELayout {
	private static Boolean[] cellsAffected = new Boolean[9];
	private static Executor[] whoChanged = new Executor[9];
	public static void init(){
		for (int i = 0; i < whoChanged.length; i++){
			cellsAffected[i] = false;
			whoChanged[i] = Executor.NONE;
		}
	}
	public static void set(int number, Executor ex){
		cellsAffected[number] = true;
		whoChanged[number] = ex;
		Screen.updateFrame();
		Main.logAction(LogType.SET, ex, number);
	}
	public static void unset(int number, Executor ex){
		cellsAffected[number] = false;
		whoChanged[number] = ex;
		Screen.updateFrame();
		Main.logAction(LogType.SET, ex, number);
	}
	public static JLabel getLayout(){
		String str = "<html><style> p {display: block; margin: 0px auto;}</style><p>Description:<br>Numbers = unoccupied slots (press number to fill the slot)<br>O = Slot occupied by the Player<br>X = slot occupied by the AI<br> Press R to restart<br>Press E to end the game<br>";
		String nrml = "";
		for (int i = 0; i < whoChanged.length; i++){
			if (i%3 == 0){
				str = str + "<br>|";
				nrml = nrml + "\n|";
			}
			if (whoChanged[i] == Executor.NONE){
				str = str + (i+1) + "|";
				nrml = nrml + (i+1) + "|";
			} else if (whoChanged[i] == Executor.AI){
				str = str + "X|";
				nrml = nrml + "X|";
			} else if (whoChanged[i] == Executor.PLAYER){
				str = str +  "O|";
				nrml = nrml + "O|";
			}
		}
		str = str + "</p></html>";
		JLabel label = new JLabel(str, SwingConstants.CENTER);
		label.setVisible(true);
		return label;
	}
	public static Boolean[] getCellsAffected(){
		return cellsAffected;
	}
	public static Executor[] getWhoSet(){
		return whoChanged;
	}
}
