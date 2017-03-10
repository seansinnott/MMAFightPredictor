// Reach, Weight, Height, Age, Striking, BJJ, Wrestling, KOs, Subs, At Home

public class Algo20 extends Algorithm {
	private String pickedWinner = "Wrong";
	private int [] totals = {50, 50};
	private char estimatedWinner;

	public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
									int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
									char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
									char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB,
									char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB,
									int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB,
									int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB,
									char atHomeFighterA, char atHomeFighterB) {
		totals = calcReach(reachFighterA, reachFighterB, totals);
		totals = calcWeight(weightFighterA, weightFighterB, totals);
		totals = calcHeight(heightFighterA, heightFighterB, totals);
		totals = calcAge(ageFighterA, ageFighterB, totals);
		totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
		totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
		totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);
		totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);
		totals = calcSubs(submissionsFighterA, submissionsFighterB, submittedFighterA, submittedFighterB, totals);
		totals = calcFightingAtHome(atHomeFighterA, atHomeFighterB, totals);

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