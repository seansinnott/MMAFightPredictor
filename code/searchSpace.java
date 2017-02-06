Class searchSpace{
	 // Reach, Weight, Height
	 
	public class Algo1 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;
		
		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB, int heightFighterA, int heightFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			
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
	// Reach, Weight, Height

	public class Algo2 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);

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
	// Reach, Weight, Height, Age, BJJ

	public class Algo4 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB ) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);


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
	// Reach, Weight, Height, Age, Wrestling

	public class Algo5 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB ) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);

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
	// Reach, Weight, Height, Age, Striking, KO

	public class Algo6 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
										int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);

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
	// Reach, Weight, Height, Age, Wrestling

	public class Algo8 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB,
										int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB,
										int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);
			totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);
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
	// Reach, Weight, Height, Age, Striking, BJJ

	public class Algo9 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
										char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB ) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);


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
	// Reach, Weight, Height, Age, Striking, Wrestling

	public class Algo10 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB, 
										char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB ) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);


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
	}// Reach, Weight, Height, Age, BJJ, Wrestling

	public class Algo11 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(	char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB, 
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB ) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);

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
	}// Reach, Weight, Height, Age, Striking, BJJ, Wrestling

	public class Algo12 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(	char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB, 
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
										char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB ) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);

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
	}// Reach, Weight, Height, Age, KOs

	public class Algo13 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);

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
	}// Reach, Weight, Height, Age, Subs

	public class Algo14 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
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
	}// Reach, Weight, Height, Age, KOs, Subs

	public class Algo15 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB,
										int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);
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
	}// Reach, Weight, Height, Age, Striking, BJJ, Wrestling, KOs

	public class Algo16 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
										char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB,
										int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);
			totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);

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
	}// Reach, Weight, Height, Age, Striking, BJJ, Wrestling, Subs

	public class Algo17 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
										char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB,
										int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);
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
	}// Reach, Weight, Height, Age, Striking, BJJ, Wrestling, KOs, Subs

	public class Algo18 extends Algorithm {
		private String pickedWinner = "Wrong";
		private int [] totals = {50, 50};
		private char estimatedWinner;

		public String calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
										int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
										char bStrikingFighterA, char bStrikingFighterB, char mbStrikingFighterA, char mbStrikingFighterB,
										char bJiuJitsuFighterA, char bJiuJitsuFighterB, char mbJiuJitsuFighterA, char mbJiuJitsuFighterB,
										char bWrestlingFighterA, char bWrestlingFighterB, char mbWrestlingFighterA, char mbWrestlingFighterB,
										int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB,
										int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);
			totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);
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
	}// Reach, Weight, Height, Age, Striking, BJJ, Wrestling, KOs, Subs, Win/Lose Streak

	public class Algo19 extends Algorithm {
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
										char winStreakFighterA, char winStreakFighterB, char loseStreakFighterA, char loseStreakFighterB) {
			totals = calcReach(reachFighterA, reachFighterB, totals);
			totals = calcWeight(weightFighterA, weightFighterB, totals);
			totals = calcHeight(heightFighterA, heightFighterB, totals);
			totals = calcAge(ageFighterA, ageFighterB, totals);
			totals = calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals);
			totals = calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals);
			totals = calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals);
			totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals);
			totals = calcSubs(submissionsFighterA, submissionsFighterB, submittedFighterA, submittedFighterB, totals);
			totals = calcWinOrLoseStreak(winStreakFighterA, winStreakFighterB, loseStreakFighterA, loseStreakFighterB, totals);

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
	}// Reach, Weight, Height, Age, Striking, BJJ, Wrestling, KOs, Subs, At Home

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
}