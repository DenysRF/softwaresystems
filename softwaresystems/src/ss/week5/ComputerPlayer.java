package ss.week5;

public class ComputerPlayer extends Player {
	public Strategy strat;
	
	public ComputerPlayer(Mark mark, Strategy strategy){
		super("computerplayer", mark);
		strat = strategy;
	}
	
	public ComputerPlayer(Mark mark){
		super("computerplayer", mark);
		strat = new NaiveStrategy();
	}

	public void setStrategy(Strategy strategy){
		strat = strategy;
	}
	
	public Strategy getStrategy(){
		return strat;
	}
	
	public int determineMove(Board board){
		int choice = strat.determineMove(board, super.getMark());
		String chose = getStrategy() + " chose " + choice;
		System.out.println(chose);
		return choice;
	}

}