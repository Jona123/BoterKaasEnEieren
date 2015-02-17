package nl.datdenkikniet.BKE;

public class AI {
	/**
	 * This will check the {@link nl.datdenkikniet.BKE.BKELayout}'s stats to either: make a move, check if someone won, or check if it's a tie
	 */
	public static boolean check(){
		Boolean[] isSet = BKELayout.getCellsAffected();
		Executor[] hasSet = BKELayout.getWhoSet();
		//check if it's a tie
		if (isSet[0] && isSet[1] && isSet[2] && isSet[3] && isSet[4] && isSet[5] && isSet[6] && isSet[7] && isSet[8]){
			BKELayout.init();
			Main.notificationPopUp("It's a tie! Restarting the game...");
			Main.logAction(LogType.TIE, Executor.NONE, 0);
			Main.logAction(LogType.RESTART, Executor.NONE, 0);
			return true;
		}
		for (int i = 0; i < 3; i++){
			if (isSet[i] && isSet[i+3] && isSet[i+6]){
				if (hasSet[i] == Executor.PLAYER && hasSet[i+3] == Executor.PLAYER && hasSet[i+6] == Executor.PLAYER){
					Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
					Main.logAction(LogType.RESTART, Executor.NONE, 0);
					Main.notificationPopUp("You won! Restarting game....");
					BKELayout.init();
					return true;
				} else if (hasSet[i] == Executor.AI && hasSet[i+3] == Executor.AI && hasSet[i+6] == Executor.AI){
					Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("The AI won! Restarting game....");
					Main.logAction(LogType.RESTART, Executor.NONE, 0);
					BKELayout.init();
					return true;
				}
			}
		}
		for (int i = 0; i<9; i=i+3){
			if (isSet[i] && isSet[i+1] && isSet[i+2]){
				if (hasSet[i] == Executor.PLAYER && hasSet[i+1] == Executor.PLAYER && hasSet[i+2] == Executor.PLAYER){
					Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("You won! Restarting game....");
					BKELayout.init();
					return true;
				} else if (hasSet[i] == Executor.AI && hasSet[i+1] == Executor.AI && hasSet[i+2] == Executor.AI) {
					Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("The AI won! Restarting game....");
					BKELayout.init();
					return true;
				}
			}
		}
		if (isSet[2] && isSet[4] && isSet[6]){
			if (hasSet[2] == Executor.PLAYER && hasSet[4] == Executor.PLAYER && hasSet[6] == Executor.PLAYER){
				Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("You won! Restarting game....");
				BKELayout.init();
				return true;
			} else if (hasSet[2] == Executor.AI && hasSet[4] == Executor.AI && hasSet[6] == Executor.AI) {
				Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("The AI won! Restarting game....");
				BKELayout.init();
				return true;
			}
		}
		if (isSet[0] && isSet[4] && isSet[8]){
			if (hasSet[0] == Executor.PLAYER && hasSet[4] == Executor.PLAYER && hasSet[8] == Executor.PLAYER){
				Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("You won! Restarting game....");
				BKELayout.init();
				return true;
			} else if (hasSet[0] == Executor.AI && hasSet[4] == Executor.AI && hasSet[8] == Executor.AI){
				Main.logAction(LogType.AIWIN, Executor.PLAYER, 0);
				Main.notificationPopUp("The AI won! Restarting game....");
				BKELayout.init();
				return true;
			}
		}
		return false;
	}
	public static void doAiStuff(Executor ex, Executor enemy, Boolean[] set, Executor[] whoset){
		Boolean[] isSet = set;
		Executor[] hasSet = whoset;
		boolean toTry = true;
		//Check if you can win
			for (int i = 0; i < 3; i++){
				if (isSet[i] && isSet[i+3] && hasSet[i] == ex && hasSet[i+3] == ex){
					if (!(hasSet[i+6] == enemy)){
						BKELayout.set(i+6, ex);
						toTry = false;
						break;
					}
				} else if (isSet[i] && isSet[i+6] && hasSet[i] == ex && hasSet[i+6] == ex){
					if (!(hasSet[i+3] == enemy)){
						BKELayout.set(i+3, ex);
						toTry = false;
						break;
					}
				} else if (isSet[i+3] && isSet[i+6] && hasSet[i+3] == ex && hasSet[i+6] == ex){
					if (!(hasSet[i] == enemy)){
						BKELayout.set(i, ex);
						toTry = false;
						break;
					}
				}
			}
			if (toTry){
				if (isSet[2] && isSet[4] && hasSet[2] == ex && hasSet[4] == ex){
					if (!(hasSet[6] == enemy)){
						BKELayout.set(6, ex);
						toTry = false;
					}
				} else if (isSet[4] && isSet[6] && hasSet[4] == ex && hasSet[6] == ex){
					if (!(hasSet[0] == enemy)){
						BKELayout.set(0, ex);
						toTry = false;
					}
				} else if (isSet[0] && isSet[6] && hasSet[0] == ex && hasSet[6] == ex){
					if (!(hasSet[4] == enemy)){
						BKELayout.set(4, ex);
						toTry = false;
					}
				}

			}
			if (toTry){
				if (isSet[0] && isSet[4] && hasSet[0] == ex && hasSet[4] == ex){
					if (!(hasSet[8] == enemy)){
						BKELayout.set(8, ex);
						toTry = false;
					}
				} else if (isSet[4] && isSet[8] && hasSet[4] == ex && hasSet[8] == ex){
					if (!(hasSet[0] == enemy)){
						BKELayout.set(0, ex);
						toTry = false;
					}
				} else if (isSet[0] && isSet[8] && hasSet[0] == ex && hasSet[8] == ex){
					if (!(hasSet[4] == enemy)){
						BKELayout.set(4, ex);
						toTry = false;
					}
				}
			}
			if (toTry){
				for (int i = 0; i < 3; i=i+3){
					if (isSet[i] && isSet[i+1] && hasSet[i] == ex && hasSet[i+1] == ex){
						if (!(hasSet[i+2] == enemy)){
							BKELayout.set(i+2, ex);
							toTry = false;
							break;
						}
					} else if (isSet[i] && isSet[i+2] && hasSet[i] == ex && hasSet[i+2] == ex){
						if (!(hasSet[i+1] == enemy)){
							BKELayout.set(i+1, ex);
							toTry = false;
							break;
						}
					} else if (isSet[i+2] && isSet[i+3] && hasSet[i+2] == ex && hasSet[i+3] == ex){
						if (!(hasSet[i] == enemy)){
							BKELayout.set(i, ex);
							toTry = false;
							break;
						}
					}

				}
			}
		//You can't win (yet), block the opponent!
		if (toTry){
		for (int i = 0; i < 3; i++){
			if (isSet[i] && isSet[i+3] && hasSet[i] == enemy && hasSet[i+3] == enemy){
				if (!(hasSet[i+6] == ex)){
					BKELayout.set(i+6, ex);
					toTry = false;
					break;
				}
			} else if (isSet[i] && isSet[i+6] && hasSet[i] == enemy && hasSet[i+6] == enemy){
				if (!(hasSet[i+3] == ex)){
					BKELayout.set(i+3, ex);
					toTry = false;
					break;
				}
			} else if (isSet[i+3] && isSet[i+6] && hasSet[i+3] == enemy && hasSet[i+6] == enemy){
				if (!(hasSet[i] == ex)){
					BKELayout.set(i, ex);
					toTry = false;
					break;
				}
			}
		}
		}
		if (toTry){
			if (isSet[2] && isSet[4] && hasSet[2] == enemy && hasSet[4] == enemy){
				if (!(hasSet[6] == ex)){
					BKELayout.set(6, ex);
					toTry = false;
				}
			} else if (isSet[4] && isSet[6] && hasSet[4] == enemy && hasSet[6] == enemy){
				if (!(hasSet[0] == ex)){
					BKELayout.set(0, ex);
					toTry = false;
				}
			} else if (isSet[0] && isSet[6] && hasSet[0] == enemy && hasSet[6] == enemy){
				if (!(hasSet[4] == ex)){
					BKELayout.set(4, ex);
					toTry = false;
				}
			}

		}
		if (toTry){
			if (isSet[0] && isSet[4] && hasSet[0] == enemy && hasSet[4] == enemy){
				if (!(hasSet[8] == ex)){
					BKELayout.set(8, ex);
					toTry = false;
				}
			} else if (isSet[4] && isSet[8] && hasSet[4] == enemy && hasSet[8] == enemy){
				if (!(hasSet[0] == ex)){
					BKELayout.set(0, ex);
					toTry = false;
				}
			} else if (isSet[0] && isSet[8] && hasSet[0] == enemy && hasSet[8] == enemy){
				if (!(hasSet[4] == ex)){
					BKELayout.set(4, ex);
					toTry = false;
				}
			}
		}
		if (toTry){
			for (int i = 0; i < 3; i=i+3){
				if (isSet[i] && isSet[i+1] && hasSet[i] == enemy && hasSet[i+1] == enemy){
					if (!(hasSet[i+2] == ex)){
						BKELayout.set(i+2, ex);
						toTry = false;
						break;
					}
				} else if (isSet[i] && isSet[i+2] && hasSet[i] == enemy && hasSet[i+2] == enemy){
					if (!(hasSet[i+1] == ex)){
						BKELayout.set(i+1, ex);
						toTry = false;
						break;
					}
				} else if (isSet[i+2] && isSet[i+3] && hasSet[i+2] == enemy && hasSet[i+3] == enemy){
					if (!(hasSet[i] == ex)){
						BKELayout.set(i, ex);
						toTry = false;
						break;
					}
				}

			}
		}
		//no real tactical shizzle found, make a random move
		if (toTry){
			if (!isSet[4]){
				BKELayout.set(4, ex);
				toTry = false;
			}
		}
		if (toTry){
			for (int i=0; i<8; i++){
				if (!isSet[i]){
					BKELayout.set(i, ex);
					toTry = false;
					break;
				}
			}
		}
		check();
	}
}
