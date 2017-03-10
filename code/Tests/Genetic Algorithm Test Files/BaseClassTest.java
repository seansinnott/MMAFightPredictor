import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.Before;


public class BaseClassTest {
	// will be using BaseAlgo19 for this because it contains all methods
	// that are used in any of the other 21 BaseAlgo classes
	BaseAlgo19GA ba;
	
	// start total of both fighters on 50
	int [] totals = {50, 50};
	
	// use values from best genotype that genetic algorithm found
	int [] values = {1,3,1,1,5,8,1,8,1,6,2,1,3};
	
	// before each test make sure we can use ba, the BaseAlgo object
	@Before
	public void setUp() {
		ba = new BaseAlgo19GA();		
	}
	
	@Test
	public void testCalcReach() {
		int reachFighterA = 70;
		int reachFighterB = 75;
		int [] result = ba.calcReach(reachFighterA, reachFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 49);
		assertEquals(result[1], 51);
	}
	
	
	@Test
	public void testCalcWeight() {
		int weightFighterA = 210;
		int weightFighterB = 230;
		int [] result = ba.calcWeight(weightFighterA, weightFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 47);
		assertEquals(result[1], 53);
	}
	
	
	@Test
	public void testCalcHeight() {
		int heightFighterA = 170;
		int heightFighterB = 160;
		int [] result = ba.calcHeight(heightFighterA, heightFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 51);
		assertEquals(result[1], 49);
	}
	
	
	@Test
	public void testCalcAge() {
		int ageFighterA = 42;
		int ageFighterB = 33;
		int [] result = ba.calcAge(ageFighterA, ageFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 48);
		assertEquals(result[1], 52);
	}
	
	
	@Test
	public void testCalcStriking() {
		char bStrikingFighterA = 'n';
		char bStrikingFighterB = 'n';
		char mbStrikingFighterA = 'y';
		char mbStrikingFighterB = 'n';

		int [] result = ba.calcStriking(bStrikingFighterA, bStrikingFighterB, mbStrikingFighterA, mbStrikingFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 58);
		assertEquals(result[1], 42);
	}
	
	
	@Test
	public void testCalcJiuJitsu() {
		char bJiuJitsuFighterA = 'n';
		char bJiuJitsuFighterB = 'y';
		char mbJiuJitsuFighterA = 'n';
		char mbJiuJitsuFighterB = 'n';

		int [] result = ba.calcJiuJitsu(bJiuJitsuFighterA, bJiuJitsuFighterB, mbJiuJitsuFighterA, mbJiuJitsuFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 49);
		assertEquals(result[1], 51);
	}
	
	
	@Test
	public void testCalcWrestling() {
		char bWrestlingFighterA = 'n';
		char bWrestlingFighterB = 'n';
		char mbWrestlingFighterA = 'n';
		char mbWrestlingFighterB = 'y';

		int [] result = ba.calcWrestling(bWrestlingFighterA, bWrestlingFighterB, mbWrestlingFighterA, mbWrestlingFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 44);
		assertEquals(result[1], 56);
	}
	
	
	@Test
	public void testCalcKOs() {
		int knockoutsFighterA = 10;
		int knockoutsFighterB = 4;
		int knockedOutFighterA = 1;
		int knockedOutFighterB = 5;

		int [] result = ba.calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 54);
		assertEquals(result[1], 46);
	}
	
	
	@Test
	public void testCalcSubs() {
		int submissionsFighterA = 2;
		int submissionsFighterB = 12;
		int submittedFighterA = 5;
		int submittedFighterB = 1;

		int [] result = ba.calcSubs(submissionsFighterA, submissionsFighterB, submittedFighterA, submittedFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 49);
		assertEquals(result[1], 51);
	}
	
	
	@Test
	public void testCalccWinOrLoseStreak() {
		char winStreakFighterA = 'y';
		char winStreakFighterB = 'n';
		char loseStreakFighterA = 'n';
		char loseStreakFighterB = 'y';

		int [] result = ba.calcWinOrLoseStreak(winStreakFighterA, winStreakFighterB, loseStreakFighterA, loseStreakFighterB, totals, values);
		
		// ensure that fighter totals are as they should be after method call
		assertEquals(result[0], 56);
		assertEquals(result[1], 44);
	}
}
