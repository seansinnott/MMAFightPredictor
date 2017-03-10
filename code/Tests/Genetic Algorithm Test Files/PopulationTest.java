import static org.junit.Assert.*;

import org.junit.Test;

public class PopulationTest {

	@Test
	public void testPlaceIndividualIntoPopulationAndGetIndiv() {
		// create an individual
		Individual i1 = new Individual();
		i1.createIndividual();
		
		// then place this individual into the first index of a population
		Population pop = new Population(true);
		pop.placeIndividualIntoPopulation(0, i1);
		
		// now ensure that this individual is at the first index of this population using the getIndiv method
		assertArrayEquals(i1.getGenotype(), pop.getIndiv(0).getGenotype());
	}
	
	
	@Test(expected = Exception.class) 	// calling this constructor with false and then trying to access an individual should throw NullPointerException
	public void testPopulationCreationConstructorWithFalse() {
		
		// create a population but pass in false as an argument so that no individuals are given genes, they are all just set to 0
		Population falsePop = new Population(false);
		
		// by calling this we expect a NullPointerException because there is no genotype for first individual of population
		assertNull(falsePop.getIndiv(0).getGenotype());
	}
	
	@Test
	public void testPopulationCreationConstructorWithTrue() {
		
		// now create a population but pass in true as an argument so that all individuals are given genes
		Population truePop = new Population(true);
		
		// ensure that the first individual in truePop does exist by checking that it isn't null
		assertNotNull(truePop.getIndiv(0).getGenotype());
	}
	
	@Test
	public void testGetFittestInPopulation() {
		
		// create a population of 100 individuals
		Population pop = new Population(true);
		
		// give every individual in the population a genotype of all zeroes, which should have a very poor fitness
		for (int i = 0; i < 100; i++) {
			for (int j = 0; j < 13; j++) {
				pop.getIndiv(i).setGene(j, 0);
			}
			
		}
		
		// now give the last individual in the population the genotype that our Genetic Algorithm found to be the best		
		pop.getIndiv(99).setGene(0, 1);
		pop.getIndiv(99).setGene(1, 3);
		pop.getIndiv(99).setGene(2, 1);
		pop.getIndiv(99).setGene(3, 1);
		pop.getIndiv(99).setGene(4, 5);
		pop.getIndiv(99).setGene(5, 8);
		pop.getIndiv(99).setGene(6, 1);
		pop.getIndiv(99).setGene(7, 8);
		pop.getIndiv(99).setGene(8, 1);
		pop.getIndiv(99).setGene(9, 6);
		pop.getIndiv(99).setGene(10, 2);
		pop.getIndiv(99).setGene(11, 1);
		pop.getIndiv(99).setGene(12, 3);
		
		// now ensure that when we call the getFittestInPopulation method on this population, the individual with the genes that we know to be the best is returned
		assertArrayEquals(pop.getFittestInPopulation().getGenotype(), pop.getIndiv(99).getGenotype());
		
	}

}
