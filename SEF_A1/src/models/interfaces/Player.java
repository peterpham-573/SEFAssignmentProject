package models.interfaces;

/*
 * 				SEF PROJECT - DAVID VO, DANNY LE, PETEY DERASMO, PETER PHAM
 * 
 * 		class will be the players for the chess game, will most likely include 
 * 		
 */

public interface Player {

	   public String toString();
	
	   public abstract String getPlayerName();
	   
	   public abstract void setPlayerName(String playerName);
	   
	   public abstract String getPlayerUserName();
	   
	   public abstract void setPlayerUserName(String userName);
	   
	   public abstract String getPlayerPw();
	   
	   public abstract void setPlayerPw(String pw);
	   
	   public abstract int getPoints();
	   
	   public abstract void setPoints(int points);
	
	   public abstract void setNoOfTurns(int noOfTurns);

       public abstract int getNoOfTurns();
  
}
