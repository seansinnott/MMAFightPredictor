import static org.junit.Assert.*;

import org.junit.Test;

public class CalculateFitnessTest {

	@Test
	public void testGetFitness() {
		// create an individual with genes which we know produce a fitness score of 29
		Individual i1 = new Individual();
		i1.setGene(0, 1);
		i1.setGene(1, 3);
		i1.setGene(2, 1);
		i1.setGene(3, 1);
		i1.setGene(4, 5);
		i1.setGene(5, 8);
		i1.setGene(6, 1);
		i1.setGene(7, 8);
		i1.setGene(8, 1);
		i1.setGene(9, 6);
		i1.setGene(10, 2);
		i1.setGene(11, 1);
		i1.setGene(12, 3);
		
		
		// now call the getFitness function on Individual i1
		int fitness = CalculateFitness.getFitness(i1);
		
		// now ensure that the fitness returned by getFitness is 29
		assertEquals(29, fitness);		
	}
}
