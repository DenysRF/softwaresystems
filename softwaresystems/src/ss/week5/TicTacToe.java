package ss.week5;

/**
 * Executable class for the game Tic Tac Toe. The game can be played against the
 * computer. Lab assignment Module 2
 * 
 * @author Theo Ruys
 * @version $Revision: 1.4 $
 */
public class TicTacToe {
    public static void main(String[] args) {

    	Player s1;
    	if (args[0].equals("-N")){
    		s1 = new ComputerPlayer(Mark.OO, new NaiveStrategy());
    	} else if (args[0].equals("-S")){
    		s1 = new ComputerPlayer(Mark.OO, new SmartStrategy());
    	}
    	else {
    		s1 = new HumanPlayer(args[0], Mark.OO);
    	}
    
    	
    	Player s2;
    	if (args[1].equals("-N")){
    		s2 = new ComputerPlayer(Mark.XX, new NaiveStrategy());
    	} else if (args[1].equals("-S")){ 
    		s2 = new ComputerPlayer(Mark.XX, new SmartStrategy());
    	} else {
    		s2 = new HumanPlayer(args[1], Mark.XX);
    	}
    
    	Game game = new Game (s1, s2);
    	game.start();
    	
    	}	    	
    }
