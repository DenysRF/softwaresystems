package ss.week5;

import java.util.ArrayList;
import java.util.List;

public class NaiveStrategy implements Strategy{
	private String name;
	
	public NaiveStrategy(){
		super();
		name = "naive";
	}
	
	public String getName(){
		return name;
	}

	public int determineMove(Board b, Mark m){
		List<Integer> free = new ArrayList<Integer>();
		for(int i = 0; i < Board.DIM * Board.DIM; i++){
			if(b.isEmptyField(i)){
				free.add(i);
			}
		}
		int random = (int)(Math.random() * free.size());
		return (free.get(random));
	}
}
