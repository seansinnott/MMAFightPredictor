public class Algorithm {	
	
	public int [] calcReach(int reachFighterA, int reachFighterB, int [] totals) {	
		if (reachFighterA > reachFighterB) {
			if ( (reachFighterA - reachFighterB) >= 2) {
				totals[0] += 2;
				totals[1] -= 2;
			}
		}
		if (reachFighterB > reachFighterA) {
			if ( (reachFighterB - reachFighterA) >= 2) {
				totals[0] -= 2;
				totals[1] += 2;
			}
		}
		return totals;
	}

	
	public int [] calcWeight(int weightFighterA, int weightFighterB, int [] totals) {
		if (weightFighterA > weightFighterB) {
			if ( (weightFighterA - weightFighterB) >= 5) {
				totals[0] += 2;
				totals[1] -= 2;
			}
		}		
		if (weightFighterB > weightFighterA) {
			if ( (weightFighterB - weightFighterA) >= 5) {
				totals[0] -= 2;
				totals[1] += 2;
			}
		}
		return totals;
	}
	
	public int [] calcHeight(int heightFighterA, int heightFighterB, int [] totals) {		
		if (heightFighterA > heightFighterB) {
			if ( (heightFighterA - heightFighterB) >= 5) {
				totals[0] += 2;
				totals[1] -= 2;
			}
		}		
		if (heightFighterB > heightFighterA) {
			if ( (heightFighterB - heightFighterA) >= 5) {
				totals[0] -= 2;
				totals[1] += 2;
			}
		}
		return totals;
	}
	
	public int [] calcAge(int ageFighterA, int ageFighterB, int [] totals) {
		boolean badAgeFighterA = false;
		boolean badAgeFighterB = false;		
		if (ageFighterA >= 35 || ageFighterA <= 23) {
			badAgeFighterA = true;
			totals[0] -= 2;
			totals[1] += 2;
		}
		
		if (ageFighterB >= 35 || ageFighterB <= 23) {
			badAgeFighterB = true;
			totals[0] += 2;
			totals[1] -= 2;
		}		
		if (badAgeFighterA && !badAgeFighterB) {
			totals[0] -= 2;
			totals[1] += 2;
		}
		if (badAgeFighterB && !badAgeFighterA) {
			totals[0] += 2;
			totals[1] -= 2;
		}
		return totals;
	}	

	public int [] calcStriking(char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB, int [] totals) {
		if (bStrikingFighterA == 'y') {
			totals[0] += 4;
			totals[1] -= 4;
		}
		
		if (bStrikingFighterB == 'y') {
			totals[0] -= 4;
			totals[1] += 4;
		}
		
		if (mbStrikingFighterA == 'y') {
			totals[0] += 6;
			totals[1] -= 6;
		}
		
		if (mbStrikingFighterB == 'y') {
			totals[0] -= 6;
			totals[1] += 6;
		}
		return totals;
	}
	
	public int [] calcJiuJitsu(char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB, int [] totals) {
		if (bJiuJitsuFighterA == 'y') {
			totals[0] += 4;
			totals[1] -= 4;
		}
		
		if (bJiuJitsuFighterB == 'y') {
			totals[0] -= 4;
			totals[1] += 4;
		}
		
		if (mbJiuJitsuFighterA == 'y') {
			totals[0] += 6;
			totals[1] -= 6;
		}
		
		if (mbJiuJitsuFighterB == 'y') {
			totals[0] -= 6;
			totals[1] += 6;
		}
		return totals;
	}
	
	public int [] calcWrestling(char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB, int [] totals) {
		if (bWrestlingFighterA == 'y') {
			totals[0] += 4;
			totals[1] -= 4;
		}
		
		if (bWrestlingFighterB == 'y') {
			totals[0] -= 4;
			totals[1] += 4;
		}
		
		if (mbWrestlingFighterA == 'y') {
			totals[0] += 6;
			totals[1] -= 6;
		}
		
		if (mbWrestlingFighterB == 'y') {
			totals[0] -= 6;
			totals[1] += 6;
		}
		return totals;
	}
	
	public int [] calcKOs(int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB, int [] totals) {	
		if (knockedOutFighterA >= 4) {
			totals[0] -= 2;
			totals[1] += 2;
		}
		if (knockedOutFighterB >= 4) {
			totals[0] += 2;
			totals[1] -= 2;
		}		
		if (knockoutsFighterA >= 3 && knockedOutFighterB >= 3) {
			totals[0] += 4;
			totals[1] -= 4;
		}		
		if (knockoutsFighterB >= 3 && knockedOutFighterA >= 3) {
			totals[0] -= 4;
			totals[1] += 4;
		}
		return totals;
	}
	
	public int [] calcSubs(int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB, int [] totals) {		
		if (submissionsFighterA >= 3 && submittedFighterB >= 3) {
			totals[0] += 4;
			totals[1] -= 4;
		}		
		if (submissionsFighterB >= 3 && submittedFighterA >= 3) {
			totals[0] -= 4;
			totals[1] += 4;
		}
		return totals;
	}
	
	public int [] calcWinOrLoseStreak(char winStreakFighterA, char winStreakFighterB, char loseStreakFighterA, char loseStreakFighterB, int [] totals) {		
		if (winStreakFighterA == 'y') {
			totals[0] += 2;
			totals[1] -= 2;
		}		
		if (winStreakFighterB == 'y') {
			totals[1] += 2;
			totals[0] -= 2;
		}
		if (loseStreakFighterA == 'y') {
			totals[1] += 2;
			totals[0] -= 2;
		}
		if (loseStreakFighterB == 'y') {
			totals[0] += 2;
			totals[1] -= 2;
		}
		return totals;
	}
	
	public int [] calcFightingAtHome(char atHomeFighterA, char atHomeFighterB, int [] totals) {
		if (atHomeFighterA == 'y') {
			totals[0] += 1;
			totals[1] -= 1;
		}
		if (atHomeFighterB == 'y') {
			totals[0] -= 1;
			totals[1] += 1;
		}
		return totals;
	}	
}