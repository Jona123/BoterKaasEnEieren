package nl.datdenkikniet.BKE;

public class AI {
	public static void check(){
		Boolean[] isSet = BKELayout.getCellsAffected();
		Executor[] hasSet = BKELayout.getWhoSet();
		for (int i = 0; i < 3; i++){
			if (isSet[i] && isSet[i+3] && isSet[i+6]){
				if (hasSet[i] == Executor.PLAYER){
					BKELayout.init();
					Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("You won! Restarting game....");
				} else {
					BKELayout.init();
					Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("The AI won! Restarting game....");
				}
			}
		}
		for (int i = 0; i<9; i=i+3){
			if (isSet[i] && isSet[i+1] && isSet[i+2]){
				if (hasSet[i] == Executor.PLAYER){
					BKELayout.init();
					Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("You won! Restarting game....");
				} else {
					BKELayout.init();
					Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("The AI won! Restarting game....");
				}
			}
		}
		if (isSet[2] && isSet[4] && isSet[6]){
			if (hasSet[3] == Executor.PLAYER){
				BKELayout.init();
				Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("You won! Restarting game....");
			} else {
				BKELayout.init();
				Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("The AI won! Restarting game....");
			}
		}
		if (isSet[0] && isSet[4] && isSet[8]){
			if (hasSet[0] == Executor.PLAYER){
				BKELayout.init();
				Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("You won! Restarting game....");
			} else {
				BKELayout.init();
				Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("The AI won! Restarting game....");
			}
		}
	}
}
