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
		//check for win
		//check vertical
		for (int i = 0; i < 3; i++){
			if (isSet[i] && isSet[i+3] && isSet[i+6]){
				System.out.println("vertical");
				if (hasSet[i] == Executor.PLAYER && hasSet[i+3] == Executor.PLAYER && hasSet[i+6] == Executor.PLAYER){
					Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
					Main.logAction(LogType.RESTART, Executor.NONE, 0);
					Main.notificationPopUp("You won! Restarting game....");
					BKELayout.init();
					return true;
				} else if (hasSet[i] == Executor.AI && hasSet[i+3] == Executor.AI && hasSet[i+6] == Executor.AI){
					Main.logAction(LogType.AIWIN, Executor.AI, 0);
					Main.notificationPopUp("The AI won! Restarting game....");
					Main.logAction(LogType.RESTART, Executor.NONE, 0);
					BKELayout.init();
					return true;
				}
			}
		}
		//check horizontal
		for (int i = 0; i < 7; i=i+3){
			if (isSet[i] && isSet[i+1] && isSet[i+2]){
				if (hasSet[i] == Executor.PLAYER && hasSet[i+1] == Executor.PLAYER && hasSet[i+2] == Executor.PLAYER){
					Main.logAction(LogType.PLAYERWIN, Executor.PLAYER, 0);
					Main.notificationPopUp("You won! Restarting game....");
					BKELayout.init();
					return true;
				} else if (hasSet[i] == Executor.AI && hasSet[i+1] == Executor.AI && hasSet[i+2] == Executor.AI) {
					Main.logAction(LogType.AIWIN, Executor.AI, 0);
					Main.notificationPopUp("The AI won! Restarting game....");
					BKELayout.init();
					return true;
				}
			}
		}
		//check diagonal
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
	public static void doAiStuff(Executor ex, Executor enemy){
		Boolean[] isSet = BKELayout.getCellsAffected();
		Executor[] hasSet = BKELayout.getWhoSet();
		//Check if you can win
		//check diagnoal
		if (isSet[0] && isSet[4] && hasSet[0] == Executor.AI && hasSet[4] == Executor.AI){
			if (!isSet[8]){
				BKELayout.set(8, Executor.AI);
				return;
			}
		} else if (isSet[4] && isSet[8] && hasSet[4] == Executor.PLAYER && hasSet[8] == Executor.PLAYER){
			if (!isSet[0]){
				BKELayout.set(0, Executor.AI);
				return;
			}
		} else if (isSet[0] && isSet[8] && hasSet[0] == Executor.PLAYER && hasSet[8] == Executor.PLAYER){
			if (!isSet[4]){
				BKELayout.set(4, Executor.AI);
				return;
			}
		}
		//check vertical
		for (int i = 0; i < 3; i++){
			if (isSet[i] && isSet[i+3] && hasSet[i] == Executor.AI && hasSet[i+3] == Executor.AI){
				if (!isSet[i+6]){
					BKELayout.set(i+6, Executor.AI);
					return;
				}
			} else if (isSet[i] && isSet[i+6] && hasSet[i] == Executor.AI && hasSet[i+6] == Executor.AI){
				if (!isSet[i+3]){
					BKELayout.set(i+3, Executor.AI);
					return;
				}
			} else if (isSet[i+3] && isSet[i+6] && hasSet[i+3] == Executor.AI && hasSet[i+6] == Executor.AI){
				if (!isSet[i]){
					BKELayout.set(i, Executor.AI);
					return;
				}
			}
		}
		//check horizontal
		for (int i = 0; i < 2; i++){
			if (isSet[i] && isSet[i+1] && hasSet[i] == Executor.AI && hasSet[i+1] == Executor.AI){
				if (!isSet[i+2]){
					BKELayout.set(i+2, Executor.AI);
					return;
				}
			} else if (isSet[i] && isSet[i+2] && hasSet[i] == Executor.AI && hasSet[i+2] == Executor.AI){
				if (!isSet[i+1]){
					BKELayout.set(i+1, Executor.AI);
					return;
				}
			} else if (isSet[i+2] && isSet[i+3] && hasSet[i+2] == Executor.AI && hasSet[i+3] == Executor.AI){
				if (!isSet[i]){
					BKELayout.set(i, Executor.AI);
					return;
				}
			}

		}
		//You can't win, block the player if possible
		//check vertical
		for (int i = 0; i < 3; i++){
			if (isSet[i] && isSet[i+3] && hasSet[i] == Executor.PLAYER && hasSet[i+3] == Executor.PLAYER){
				if (!isSet[i+6]){
					BKELayout.set(i+6, Executor.AI);
					return;
				}
			} else if (isSet[i] && isSet[i+6] && hasSet[i] == Executor.PLAYER && hasSet[i+6] == Executor.PLAYER){
				if (!isSet[i+3]){
					BKELayout.set(i+3, Executor.AI);
					return;
				}
			} else if (isSet[i+3] && isSet[i+6] && hasSet[i+3] == Executor.PLAYER && hasSet[i+6] == Executor.PLAYER){
				if (!isSet[i]){
					BKELayout.set(i, Executor.AI);
					return;
				}
			}
		}

		//check horizontal
		for (int i = 0; i < 8; i=i+3){
			if (isSet[i] && isSet[i+1] && hasSet[i] == Executor.PLAYER && hasSet[i+1] == Executor.PLAYER){
				if (!isSet[i+2]){
					BKELayout.set(i+2, Executor.AI);
					return;
				}
			} else if (isSet[i] && isSet[i+2] && hasSet[i] == Executor.PLAYER && hasSet[i+2] == Executor.PLAYER){
				if (!isSet[i+1]){
					BKELayout.set(i+1, Executor.AI);
					return;
				}
			} else if (isSet[i+2] && isSet[i+1] && hasSet[i+2] == Executor.PLAYER && hasSet[i+1] == Executor.PLAYER){
				if (!isSet[i]){
					BKELayout.set(i, Executor.AI);
					return;
				}
			}

		}

		//check diagonal
		if (isSetH(0) && isSetH(4)){
			BKELayout.set(8, Executor.AI);
			return;
		} else if (isSetH(4) && isSetH(8)){
			BKELayout.set(0, Executor.AI);
			return;
		} else if (isSetH(6) && isSetH(4)){
			BKELayout.set(2, Executor.AI);
			return;
		} else if (isSetH(2) && isSetH(4)){
			BKELayout.set(6, Executor.AI);
			return;
		} else if (isSetH(0) && isSetH(8)){
			BKELayout.set(4, Executor.AI);
			return;
		} else if (isSetH(2) && isSetH(6)){
			BKELayout.set(4, Executor.AI);
			return;
		}
		//no real tactical shizzle found, make a another move

		//middle
		if (!isSet[4]){
			BKELayout.set(4, Executor.AI);
			return;
		}

		//corners
		for (int i=0;i<2;i=i+6){
			if (!isSet[i]){
				BKELayout.set(i, Executor.AI);
				return;
			} else if (!isSet[i+2]){
				BKELayout.set(i+2, Executor.AI);
				return;
			}
		}

		for (int i = 1; i < 8; i=i+2){
			if (!isSet[i]){
				BKELayout.set(i, Executor.AI);
				return;
			}
		}
		//other leftover slot
		for (int i=0;i<8;i++){
			if (!isSet[i]){
				BKELayout.set(i, Executor.AI);
				return;
			}
		}
	}
	private static boolean isSetH(int i){
		Boolean[] isSet = BKELayout.getCellsAffected();
		Executor[] hasSet = BKELayout.getWhoSet();
		return isSet[i] && hasSet[i] == Executor.PLAYER;
	}
}
