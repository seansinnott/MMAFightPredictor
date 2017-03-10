import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class ChromosomeTest {			

	// 2 Individual objects
	Individual i1 = new Individual();
	Individual i2 = new Individual();
			
	// before each test make sure we can have 2 Individuals created
	@Before
	public void setUp() {
		i1.createIndividual();
		i2.createIndividual();
	}
	
	@Test
	public void testPerformCrossover() {
		
		// perform crossover of two individuals to give a child Individual a genotype
		Individual child = Chromosome.performCrossover(i1, i2);
		
		// ensure that the child object now has a genotype (is not null)
		assertNotNull(child);
	}
	
	@Test
	public void testPerformMutation() {
		// give Individual i1 some genes
		i1.setGene(0, 1);
		i1.setGene(1, 2);
		i1.setGene(2, 3);
		i1.setGene(3, 4);
		i1.setGene(4, 5);
		i1.setGene(5, 6);
		i1.setGene(6, 7);
		i1.setGene(7, 8);
		i1.setGene(8, 9);
		i1.setGene(9, 10);
		i1.setGene(10, 11);
		i1.setGene(11, 12);
		i1.setGene(12, 13);

		
		// now give a new individual the same genes
		i2.setGene(0, 1);
		i2.setGene(1, 2);
		i2.setGene(2, 3);
		i2.setGene(3, 4);
		i2.setGene(4, 5);
		i2.setGene(5, 6);
		i2.setGene(6, 7);
		i2.setGene(7, 8);
		i2.setGene(8, 9);
		i2.setGene(9, 10);
		i2.setGene(10, 11);
		i2.setGene(11, 12);
		i2.setGene(12, 13);

		assertArrayEquals(i1.getGenotype(), i2.getGenotype());
		
		// now keep looping until Individual toBeMutated has its genotype mutated
		while (i1.getGenotype() == i2.getGenotype()) {
			Chromosome.performMutation(i2);
		}
		
		// ensure that the two individuals now have different genes
		assertFalse(i1.getGenotype() == i2.getGenotype());
	}
	
	
	@Test
	public void testNaturalSelection() {
		
		// create Population object
		Population pop = new Population(true);
		
		// place the best individual from the population into the bestParent Individual object
		Individual bestParent = Chromosome.naturalSelection(pop);
		
		// ensure that the bestParent object contains something (is not null)
		assertNotNull(bestParent);		
	}
	
	@Test
	public void testPerformEvolution() {
		
		// create Population object
		Population pop = new Population(true);
		
		// place best individuals from pop into a new population called betterPop
		Population betterPop = Chromosome.performEvolution(pop);
		
		// ensure that the betterPop object contains a new population (is not null)
		assertNotNull(betterPop);
	}
}
