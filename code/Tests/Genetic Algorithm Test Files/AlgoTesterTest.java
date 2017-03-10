import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class AlgoTesterTest {

	// will be using Algo19Test for this because it contains all methods
	// that are used in any of the other 21 TestAlgo classes
	Algo19Test algo;
	
	// start total of both fighters on 50
	int [] totals = {50, 50};
			
	// use values from best genotype that genetic algorithm found
	int [] values = {1,3,1,1,5,8,1,8,1,6,2,1,3};
			
	// before each test make sure we can use algo, the AlgoTest object
	@Before
	public void setUp() {
		algo = new Algo19Test();		
	}
	
	
	@Test
	public void testForTestOnUnseenFightsMethod() {
		
		// call the method using values as a parameter
		int result = algo.testOnUnseenFights(values);
		
		assertEquals(result, 24);
		
	}

}
