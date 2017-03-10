import java.util.*;
import java.io.*;

// Base Algorithm that contains the methods used in this prediction algorithm.
// These methods are used in a different class which actually performs the prediction
class BaseAlgo21GA {
	// Totals array contains fighter totals (50 and 50 at the start) and each method takes these values and adds and subtracts
	// from these totals appropriately based on the data taken in from parameters which are received from text files.
	// The amount to be added or subtracted is in the values array which is produced by the genetic algorithm
	
	public int [] calcReach(int reachFighterA, int reachFighterB, int [] totals, int [] values) {	
		if (reachFighterA > reachFighterB) {
			if ( (reachFighterA - reachFighterB) >= 2) {
				totals[0] += values[0];
				totals[1] -= values[0];
			}
		}
		if (reachFighterB > reachFighterA) {
			if ( (reachFighterB - reachFighterA) >= 2) {
				totals[0] -= values[0];
				totals[1] += values[0];
			}
		}
		return totals;
	}
	
	public int [] calcWeight(int weightFighterA, int weightFighterB, int [] totals, int [] values) {
		if (weightFighterA > weightFighterB) {
			if ( (weightFighterA - weightFighterB) >= 5) {
				totals[0] += values[1];
				totals[1] -= values[1];
			}
		}		
		if (weightFighterB > weightFighterA) {
			if ( (weightFighterB - weightFighterA) >= 5) {
				totals[0] -= values[1];
				totals[1] += values[1];
			}
		}
		return totals;
	}
	
	public int [] calcHeight(int heightFighterA, int heightFighterB, int [] totals, int [] values) {		
		if (heightFighterA > heightFighterB) {
			if ( (heightFighterA - heightFighterB) >= 5) {
				totals[0] += values[2];
				totals[1] -= values[2];
			}
		}		
		if (heightFighterB > heightFighterA) {
			if ( (heightFighterB - heightFighterA) >= 5) {
				totals[0] -= values[2];
				totals[1] += values[2];
			}
		}
		return totals;
	}
	
	public int [] calcAge(int ageFighterA, int ageFighterB, int [] totals, int [] values) {
		boolean badAgeFighterA = false;
		boolean badAgeFighterB = false;		
		if (ageFighterA >= 35 || ageFighterA <= 23) {
			badAgeFighterA = true;
			totals[0] -= values[3];
			totals[1] += values[3];
		}
		
		if (ageFighterB >= 35 || ageFighterB <= 23) {
			badAgeFighterB = true;
			totals[0] += values[3];
			totals[1] -= values[3];
		}		
		if (badAgeFighterA && !badAgeFighterB) {
			totals[0] -= values[3];
			totals[1] += values[3];
		}
		if (badAgeFighterB && !badAgeFighterA) {
			totals[0] += values[3];
			totals[1] -= values[3];
		}
		return totals;
	}	

	public int [] calcKOs(int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB, int [] totals, int [] values) {	
		if (knockedOutFighterA >= 4) {
			totals[0] -= values[4];
			totals[1] += values[4];
		}
		if (knockedOutFighterB >= 4) {
			totals[0] += values[4];
			totals[1] -= values[4];
		}		
		if (knockoutsFighterA >= 3 && knockedOutFighterB >= 3) {
			totals[0] += values[4];
			totals[1] -= values[4];
		}		
		if (knockoutsFighterB >= 3 && knockedOutFighterA >= 3) {
			totals[0] -= values[4];
			totals[1] += values[4];
		}
		return totals;
	}
	
	public int [] calcSubs(int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB, int [] totals, int [] values) {		
		if (submissionsFighterA >= 3 && submittedFighterB >= 3) {
			totals[0] += values[5];
			totals[1] -= values[5];
		}		
		if (submissionsFighterB >= 3 && submittedFighterA >= 3) {
			totals[0] -= values[5];
			totals[1] += values[5];
		}
		return totals;
	}
	
	public int [] calcWinOrLoseStreak(char winStreakFighterA, char winStreakFighterB, char loseStreakFighterA, char loseStreakFighterB, int [] totals, int [] values) {
		if (winStreakFighterA == 'y') {
			totals[0] += values[6];
			totals[1] -= values[6];
		}		
		if (winStreakFighterB == 'y') {
			totals[1] += values[6];
			totals[0] -= values[6];
		}
		if (loseStreakFighterA == 'y') {
			totals[1] += values[7];
			totals[0] -= values[7];
		}
		if (loseStreakFighterB == 'y') {
			totals[0] += values[7];
			totals[1] -= values[7];
		}
		return totals;
	}
}

// This class uses methods from the Base Algorithm to perform the prediction and compare it to the actual known outcome (checks if it was correct)
class Algo21GA extends BaseAlgo21GA {	
	// Pass the 'totals' and 'values' arrays to the base algorithm class which will adjust fighter totals appropriately.
	private int [] totals = {50, 50};
	private char estimatedWinner;
	private int [] values;
	
	// values is the genotype that is produced by the genetic algorithm (100 in each generation, because 100 individuals in each generation)
	public Algo21GA (int [] values) {
		this.values = values;
	}
	
	// parameters are received from text file in the Genetic Algorithm class.
	// parameters used to adjust fighter totals appropriately
	public int calculateWinner(char actualWinner, int reachFighterA, int reachFighterB, int weightFighterA, int weightFighterB,
									int heightFighterA, int heightFighterB, int ageFighterA, int ageFighterB,
									int knockoutsFighterA, int knockoutsFighterB, int knockedOutFighterA, int knockedOutFighterB,
									int submissionsFighterA, int submissionsFighterB, int submittedFighterA, int submittedFighterB,
									char winStreakFighterA, char winStreakFighterB, char loseStreakFighterA, char loseStreakFighterB) {
		totals = calcReach(reachFighterA, reachFighterB, totals, values);
		totals = calcWeight(weightFighterA, weightFighterB, totals, values);
		totals = calcHeight(heightFighterA, heightFighterB, totals, values);
		totals = calcAge(ageFighterA, ageFighterB, totals, values);
		totals = calcKOs(knockoutsFighterA, knockoutsFighterB, knockedOutFighterA, knockedOutFighterB, totals, values);
		totals = calcSubs(submissionsFighterA, submissionsFighterB, submittedFighterA, submittedFighterB, totals, values);
		totals = calcWinOrLoseStreak(winStreakFighterA, winStreakFighterB, loseStreakFighterA, loseStreakFighterB, totals, values);

		// use totals to predict a winner and then check if prediction was correct
		// if correct, return integer value 1, which is to be added to that individuals current fitness
		// if incorrect, return 0
		
		if (totals[0] > totals[1]) {
			estimatedWinner = 'a'; // Fighter A wins
		}
		else if (totals[0] == totals[1]) {
			estimatedWinner = 'd'; // It is a draw
		}
		else {
			estimatedWinner = 'b'; // Fighter B wins
		}

		totals[0] = 50;
		totals[1] = 50;
		
		if(actualWinner == estimatedWinner) {
			return 1;			
		}

		return 0;
	}
}

// This class tests the current fittest individual on independent, unseen fights. This gives an idea of how good it is when generalised
class Algo21Test {
	public int testOnUnseenFights(int [] values) {
		File folder = new File("C:\\College\\3rdYear\\3rd Year Project\\Unseen Fights");
		File [] listOfFiles = folder.listFiles();
		Algo21GA algo = new Algo21GA(values);
		int myFitness = 0;
		// test the fittest genotype of the generation ('values' array) on unseen fights
		// and return the number it predicted correctly (its fitness)
		try {
			for (int i = 0; i < listOfFiles.length; i++) {
				File file = listOfFiles[i];
				Scanner in = new Scanner(new FileInputStream(file));
				int [] intArray = new int[16];
				char [] charArray = new char[19];
				
				for (int k = 0; k < 16; k++) {
					intArray[k] = in.nextInt();
				}
			
				for (int l = 0; l < 19; l++) {
					charArray[l] = in.next().charAt(0);
				}
				
				myFitness += algo.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	intArray[8],intArray[9],intArray[10],intArray[11],intArray[12],intArray[13],intArray[14],intArray[15],
																	charArray[12],charArray[13],charArray[14],charArray[15]);

				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return myFitness;
	}
}


// This class contains the methods to manipulate the genes of individuals in the population
class Chromosome {	
	private static double probabilityOfCrossover = 0.8;
	static double probabilityOfMutation = 0.005;
	
	// crossover the genes of two fit individuals to form one child
	public static Individual performCrossover (Individual individual1, Individual individual2) {
		
		Individual offspring = new Individual();		
		// randomly choose a point to crossover genes
		for (int i = 0; i < individual1.getChromosomeLength(); i++) {
			if (probabilityOfCrossover >= Math.random()) {		// probability of 0.8 of crossover being performed at that gene located at i
				offspring.setGene(i, individual1.getGene(i));
			}
			else {
				offspring.setGene(i, individual2.getGene(i));
			}
		}		
		return offspring;
	}
	
	// probability of 0.005 of mutation occurring at i
	public static void performMutation (Individual indiv) {
		
		for (int i = 0; i < indiv.getChromosomeLength(); i++) {
			if (probabilityOfMutation >= Math.random()) {
				int mutatedGene = (int) (Math.round (Math.random() * 12));
				indiv.setGene(i, mutatedGene);
			}
		}
	}

	// find fittest individual among 5 random indiviudals in the population and return that individual
	public static Individual naturalSelection(Population population) {
		
		// select the fittest indiviudal from a randomly chosen 5 individuals	
		Individual parent = population.getIndiv((int) Math.round (Math.random() * 99));
		
		for (int i = 0; i < 4; i++) {
			int random = (int) (Math.round (Math.random() * 99));
			if (population.getIndiv(random).getMyFitness() >= parent.getMyFitness()) {
				parent = population.getIndiv(random);
			}			
		}
		return parent;
	}
	
	// create a better population from the old population using natural selection, crossover and mutation
	public static Population performEvolution (Population population) {
		
		Population nextGeneration = new Population(false);
		
		for (int i = 0; i < 100; i+=2) {
			// choose two parents by natural selection
			Individual parent1 = naturalSelection(population);
			Individual parent2 = naturalSelection(population);
			
			// crossover genes of parents to make 2 children
			Individual child1 = performCrossover(parent1, parent2);			
			Individual child2 = performCrossover(parent1, parent2);
			
			// mutate genes of children
			performMutation(child1);
			performMutation(child2);
			
			// add them to the next generation
			nextGeneration.placeIndividualIntoPopulation(i, child1);
			nextGeneration.placeIndividualIntoPopulation(i+1, child2);
		}
		return nextGeneration;		
	}	
}

// This class contains an individual's genes and methods to manipulate and retrieve them
class Individual {
	private int lengthOfChromosome = 8;
	private int [] genotype = new int[lengthOfChromosome];
	private int fitness = 0;
	
	// create individual with all random genes
	public void createIndividual() {		
		for (int i = 0; i < lengthOfChromosome; i++) {
			int gene = (int) (Math.round (Math.random() * 12));
			genotype[i] = gene;
		}
	}
	
	// getters	
	public int [] getGenotype() {
		return genotype;
	}
	
	public int getGene(int index) {
		return genotype[index];
	}
	
	public int getMyFitness() {
		fitness = CalculateFitness.getFitness(this);
		return fitness;
	}
	
	public int getChromosomeLength() {
		return lengthOfChromosome;
	}
	
	// places a gene into a genotype at specific location
	public void setGene(int index, int newValue) {
		genotype[index] = newValue;
	}
}

// This class builds the population of individuals and contains some methods for working with the population
class Population {
	private Individual [] indivArray;
	
	public Population(boolean createRandomPopulation) {
		
		indivArray = new Individual[100];
		if (createRandomPopulation) {	// only do this for first generation, all generations after this will get genes from parents, mutation etc.
			for (int i = 0; i < indivArray.length; i++) {
				Individual newIndiv = new Individual();
				newIndiv.createIndividual();
				placeIndividualIntoPopulation(i, newIndiv);
			}
		}
	}
	
	public Individual getIndiv (int index) {
		return indivArray[index];
	}
	
	// iterates through the population to find fittest individual
	public Individual getFittestInPopulation() {
		Individual currentFittest = indivArray[0];
		for (int i = 0; i < indivArray.length; i++) {
			if (getIndiv(i).getMyFitness() >= currentFittest.getMyFitness()) {
				currentFittest = getIndiv(i);
			}
		}
		return currentFittest;
	}
	
	public void placeIndividualIntoPopulation(int whereToPlace, Individual ind) {
		indivArray[whereToPlace] = ind;
	}	
}

// This class calculates the fitness of an individual from the population
class CalculateFitness {
	
	// run genotype through all 30 test fights and return the number it predicted correctly (its fitness)
	public static int getFitness(Individual indiv) {		
		Algo21GA algo = new Algo21GA(indiv.getGenotype());
		File folder = new File("C:\\College\\3rdYear\\3rd Year Project\\Past Fights");
		File [] listOfFiles = folder.listFiles();
		int myFitness = 0;
		
		try {
			for (int i = 0; i < listOfFiles.length; i++) {
				File file = listOfFiles[i];
				Scanner in = new Scanner(new FileInputStream(file));
				int [] intArray = new int[16];
				char [] charArray = new char[19];
				
				// read in all ints and chars from text file of fight
				
				for (int j = 0; j < 16; j++) {
					intArray[j] = in.nextInt();
				}
			
				for (int k = 0; k < 19; k++) {
					charArray[k] = in.next().charAt(0);
				}
				
				// the calculateWinner function is different for each algorithm
				// it takes in necessary data from both arrays: reach, age, weight, etc from intArray.. 
				// better bjj, at home, etc from charArray..
				// uses these to predict winner of fight
				myFitness += algo.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	intArray[8],intArray[9],intArray[10],intArray[11],intArray[12],intArray[13],intArray[14],intArray[15],
																	charArray[12],charArray[13],charArray[14],charArray[15]);
												
				in.close();
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return myFitness;
	}
}

// This class contains main method which is the genetic algorithm itself
class GeneticAlgorithm21 {
	public static void main (String [] args) {
		// initialise a random population of 100 individuals to start
		Population population = new Population(true);
		int numberOfGenerations = 0;
		int numOfGenerationsWithNoImprovements = 0;
		int fittestInCurrentGeneration = 0;
		int fittestInPreviousGeneration = 0;
		boolean convergence = false;
		boolean maximumFitnessFound = false;
		
		while (!maximumFitnessFound && !convergence) {
			
			numberOfGenerations++;
			
			// get fitness of fittest individual in current generation
			fittestInCurrentGeneration = population.getFittestInPopulation().getMyFitness();
			
			// if max fitness found
			if (fittestInCurrentGeneration == 30) {
				maximumFitnessFound = true;
			}
			
			// if no improvement from previous generation
			if (fittestInCurrentGeneration == fittestInPreviousGeneration) {
				numOfGenerationsWithNoImprovements++;
			}
			else {
				numOfGenerationsWithNoImprovements = 0;
			}
			
			// after 30 generation unlikely to see any improvement in fitness
			if (numOfGenerationsWithNoImprovements == 30) {
				convergence = true;
			}	
			
			// test the fittest genotype of this generation against fights it has never seen before and return how many it predicted correctly
			Algo21Test tst = new Algo21Test();
			int fitnessOnUnseenFights = tst.testOnUnseenFights( population.getFittestInPopulation().getGenotype() );
			
			// print out all relevant data and loop again by creating a new population from fittest idividuals in old population unless convergence occurs or a solution (predicted every fight perfectly) has been found
			System.out.print("Generation: " + numberOfGenerations + '\t' + "Fittest Individual: " + fittestInCurrentGeneration + '\t' + "Genes: ");
			System.out.print("[" + population.getFittestInPopulation().getGene(0) + "," + population.getFittestInPopulation().getGene(1) + "," + population.getFittestInPopulation().getGene(2) + "," + population.getFittestInPopulation().getGene(3) + "," + population.getFittestInPopulation().getGene(4) + "," + population.getFittestInPopulation().getGene(5) + "," + population.getFittestInPopulation().getGene(6) + "," + population.getFittestInPopulation().getGene(7) + "]");
			System.out.println('\t' + " Fitness on Unseen Fights: " + fitnessOnUnseenFights);
			if (convergence) {
				System.out.println("Convergence Has Occurred..");
			}
			else if (maximumFitnessFound) {
				System.out.println("A Solution Has Been Found!!");
			}
			else {
				population = Chromosome.performEvolution(population);
				fittestInPreviousGeneration = fittestInCurrentGeneration;
			}			
		}		
	}
}