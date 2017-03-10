// Reach, Weight, Height, Age, BJJ, Subs

public class Algo7 extends Algorithm {
	private String pickedWinner = "Wrong";
	private int [] totals = {50, 50};
	private char estimatedWinner;

	public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
									int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
									char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB,
									int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB) {
		totals = calcReach(reachFighterA, reachFighterB, totals);
		totals = calcWeight(weightFighterA, weightFighterB, totals);
		totals = calcHeight(heightFighterA, heightFighterB, totals);
		totals = calcAge(ageFighterA, ageFighterB, totals);
		totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
		totals = calcSubs(submissionsFighterA, submissionsFighterB, submittedFighterA, submittedFighterB, totals);

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
