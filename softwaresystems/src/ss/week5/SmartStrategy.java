package ss.week5;

import java.util.ArrayList;
import java.util.List;

public class SmartStrategy implements Strategy {
	public Strategy strat;
	public String name;
	public int move;
	
	public SmartStrategy(){
		super();
		name = "smartStrategy";
	}
	
	@Override
	public String getName() {
		return name;
		
	}

	@Override
	public int determineMove(Board b, Mark m) {
		int noFields = Board.DIM * Board.DIM;
		List<Integer> openFields = new ArrayList<>();
		List<Integer> computersFields = new ArrayList<>();
		List<Integer> playersFields = new ArrayList<>();
		List<Integer> usedFields = new ArrayList<>();
		
		for (int i = 0; i < noFields; i++){
			if (b.isEmptyField(i)){
				openFields.add(i);
			} else if (b.getField(i) == m){
				computersFields.add(i);
				}
			else { 
				playersFields.add(i);
				
			}
		
		}
		//check if strat can make winningmove
		int winningMove = checkWinningMove(b, computersFields);
		if (winningMove != -1){
			return winningMove;
		}
	
		//check if opponent can make winningmove
		int oppwinningMove = checkWinningMove(b, playersFields);
		if (oppwinningMove != -1){
			return oppwinningMove;
		}
		
		//check if middle field is empty
		int midfield = (Board.DIM/2);
		if (b.isEmptyField(midfield)){
			return midfield;
		}
	
		//pick random field
		int random = (int) Math.random() * openFields.size();
		return random;
		
	
	}
	
	public int checkWinningMove(Board b, List<Integer> usedFields){
	       for (Integer i : usedFields){
	            for (Integer j : usedFields){
	                if(!j.equals(i)) {
	                    //Checks whether there are 2 of the same marks in the same row
	                    if (i / Board.DIM == j / Board.DIM) {
	                        for (int k = 0; k < Board.DIM; k++) {
	                            int indexOfField = k + (i / Board.DIM) * Board.DIM;
	                            if (b.isEmptyField(indexOfField)) {
	                                return indexOfField;
	                            }
	                        }
	                    }

	                    //Checks whether there are 2 of the same marks in the same column
	                    if (i % Board.DIM == j % Board.DIM) {
	                        for (int k = 0; k < Board.DIM; k++) {
	                            int indexOfField = k * Board.DIM + i % Board.DIM;
	                            if (b.isEmptyField(indexOfField)) {
	                                return indexOfField;
	                            }
	                        }
	                    }

	                    //Checks whether there are 2 of the same marks on a diagonal line from top-left to down-right
	                    if (i / Board.DIM == i % Board.DIM && j / Board.DIM == j % Board.DIM) {
	                        for (int k = 0; k < Board.DIM; k++) {
	                            int indexOfField = k * Board.DIM + k;
	                            if (b.isEmptyField(indexOfField)) {
	                                return indexOfField;
	                            }
	                        }
	                    }

	                    //Checks whether there are 2 of the same marks on a diagonal line from top-right to down-left
	                    if (i / Board.DIM ==  (Board.DIM - 1) - i % Board.DIM && j / Board.DIM == (Board.DIM - 1)- j % Board.DIM ) {
	                        for (int k = 0; k < Board.DIM; k++) {
	                            int indexOfField = k * Board.DIM + Board.DIM - 1 - k;
	                            if (b.isEmptyField(indexOfField)) {
	                                return indexOfField;
	                            }
	                        }
	                    }
	                }
	            }
	        }
	        //If there is no move to win the game it returns -1;
	        return -1;
	    }
	
}
