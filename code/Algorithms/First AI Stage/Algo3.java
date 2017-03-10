// Reach, Weight, Height, Age, Striking

public class Algo3 extends Algorithm {
	private String pickedWinner = "Wrong";
	private int [] totals = {50, 50};
	private char estimatedWinner;

	public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
									int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
									char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB ) {
		totals = calcReach(reachFighterA, reachFighterB, totals);
		totals = calcWeight(weightFighterA, weightFighterB, totals);
		totals = calcHeight(heightFighterA, heightFighterB, totals);
		totals = calcAge(ageFighterA, ageFighterB, totals);
		totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);


		if (totals[0] > totals[1]) {
			estimatedWinner = 'a'; // Fighter A wins
		}
		else if (totals[0] == totals[1]) {
			estimatedWinner = 'd'; // It is a draw
		}
		else {
			estimatedWinner = 'b'; // Fighter B wins
		}

		if(actualWinner == estimatedWinner) {
			pickedWinner = "Correct";
		}
	   
		return pickedWinner;
	}
}
