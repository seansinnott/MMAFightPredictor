import static org.junit.Assert.*;

import org.junit.Test;

public class IndividualTest {
	
	@Test
	public void testCreateIndividual() {
		
		// create two individual objects
		Individual i1 = new Individual();
		Individual i2 = new Individual();
		
		// before calling the createIndividual method, the genes should all be 0
		// so i1 and i2 should be equal to each other right now.. check that this is true
		assertArrayEquals(i1.getGenotype(), i2.getGenotype());
		
		// give the i1 individual some genes by calling the createIndividual method
		i1.createIndividual();
		
		// now check that i1 and i2 have different genes
		assertFalse(i1.getGenotype() == i2.getGenotype());
	}
	
	@Test
	public void testGetGenotype() {
		
		// create array of genes
		int [] genes = {1,2,3,4,5,6,7,8,9,10,11,12,13};
		
		// now give an individual the same genes as above
		Individual i1 = new Individual();
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
		
		// now the getGenotype method on i1 should return the same value as the genes array
		assertArrayEquals(genes, i1.getGenotype());
	}
	
	@Test
	public void testGetGeneAndSetGene() {
		
		// give an individual a value of 1 at the first gene using setGene
		Individual i1 = new Individual();
		i1.setGene(0, 1);
		
		// now test that the gene has been set to 1 using getGene
		assertEquals(1, i1.getGene(0));
	}
	
	@Test
	public void testGetMyFitness() {
				
		// now give an individual the genes that we know produce a fitness of 29
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
		
		// ensure that the genotype produced above gives fitness of 29 when getMyFitness is called
		assertEquals(29, i1.getMyFitness());
	}
	
	@Test
	public void testGetChromosomeLength() {
		
		// give an individual a random number of genes, should have 13 genes as GeneticAlgorithm19 has a genotype of length 13
		Individual i1 = new Individual();
		i1.createIndividual();
		
		// now test that the length of the chromosome is in fact 13, as it should be
		assertEquals(13, i1.getChromosomeLength());
	}

}
