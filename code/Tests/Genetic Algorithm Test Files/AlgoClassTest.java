import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlgoClassTest {

	// will be using BaseAlgo19 for this because it contains all methods
	// that are used in any of the other 21 Algo classes
	Algo19GA algo;
	
	// start total of both fighters on 50
	int [] totals = {50, 50};
	
	// use values from best genotype that genetic algorithm found
	int [] values = {1,3,1,1,5,8,1,8,1,6,2,1,3};
	
	// before each test make sure we can use algo, the Algo object
	@Before
	public void setUp() {
		algo = new Algo19GA(values);		
	}
	
	@Test
	public void testCalculateWinner() {
		// make up some data for two fighters to test
		char actualWinner = 'a';
		int reachFighterA = 81;
		int reachFighterB = 72;
		int weightFighterA = 265;
		int weightFighterB = 265;
		int heightFighterA = 190;
		int heightFighterB = 177;
		int ageFighterA = 39;
		int ageFighterB = 42;
		char bStrikingFighterA = 'n';
		char bStrikingFighterB = 'y';
		char mbStrikingFighterA = 'n';
		char mbStrikingFighterB = 'n';
		char bJiuJitsuFighterA = 'n';
		char bJiuJitsuFighterB = 'n';
		char mbJiuJitsuFighterA = 'n';
		char mbJiuJitsuFighterB = 'n';
		char bWrestlingFighterA = 'n';
		char bWrestlingFighterB = 'n';
		char mbWrestlingFighterA = 'y';
		char mbWrestlingFighterB = 'n';
		int knockoutsFighterA = 2;
		int knockoutsFighterB = 9;
		int knockedOutFighterA = 2;
		int knockedOutFighterB = 4;
		int submissionsFighterA = 2;
		int submissionsFighterB = 0;
		int submittedFighterA = 1;
		int submittedFighterB = 6;
		char winStreakFighterA = 'n';
		char winStreakFighterB = 'n';
		char loseStreakFighterA = 'n';
		char loseStreakFighterB = 'n';
		
		// call the calculate method
		int result = algo.calculateWinner(actualWinner, reachFighterA, reachFighterB, weightFighterA, weightFighterB, heightFighterA, heightFighterB, ageFighterA, ageFighterB, bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, submissionsFighterA, submissionsFighterB, submittedFighterA, submittedFighterB, winStreakFighterA, winStreakFighterB, loseStreakFighterA, loseStreakFighterB);
		
		// this genotype should pick the correct winner for this fight (fighter A)
		assertEquals(1, result);
	
	}

}
