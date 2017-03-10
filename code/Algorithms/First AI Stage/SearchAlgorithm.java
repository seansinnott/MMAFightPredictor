/*
integerArray[0] = reachFighterA
integerArray[1] = reachFighterB
integerArray[2] = weightFighterA
integerArray[3] = weightFighterB
integerArray[4] = heightFighterA
integerArray[5] = heightFighterB
integerArray[6] = ageFighterA
integerArray[7] = ageFighterB
integerArray[8] = knockoutsFighterA
integerArray[9] = knockoutsFighterB
integerArray[10] = knockedOutFighterA
integerArray[11] = knockedOutFighterB
integerArray[12] = submissionsFighterA
integerArray[13] = submissionsFighterB
integerArray[14] = submittedFighterA
integerArray[15] = submittedFighterB

characterArray[0] = betterStrikingFighterA
characterArray[1] = betterStrikingFighterB
characterArray[2] = muchBetterStrikingFighterA
characterArray[3] = muchBetterStrikingFighterB
characterArray[4] = betterJiuJitsuFighterA
characterArray[5] = betterJiuJitsuFighterB
characterArray[6] = muchBetterJiuJitsuFighterA
characterArray[7] = muchBetterJiuJitsuFighterB
characterArray[8] = betterWrestlingFighterA
characterArray[9] = betterWrestlingFighterB
characterArray[10] = muchBetterWrestlingFighterA
characterArray[11] = muchBetterWrestlingFighterB
characterArray[12] = winStreakFighterA
characterArray[13] = winStreakFighterB
characterArray[14] = loseStreakFighterA
characterArray[15] = loseStreakFighterB
characterArray[16] = atHomeFighterA
characterArray[17] = atHomeFighterB
characterArray[18] = actualWinner
*/

import java.util.*;
import java.io.*;
public class SearchAlgorithm {
	public static void main (String [] args) {
		try {
			Scanner in = new Scanner(new FileInputStream(args[0]));		
		
			int [] intArray = new int[16];
			char [] charArray = new char[19];
			
			for (int i = 0; i < 16; i++) {
				intArray[i] = in.nextInt();
			}
			
			for (int j = 0; j < 19; j++) {
				charArray[j] = in.next().charAt(0);
			}
			
			//Reach, Weight, Height
			Algo1 algo1 = new Algo1();
			System.out.println("Algo1 = " + algo1.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5]));
			
			//Reach, Weight, Height, Age
			Algo2 algo2 = new Algo2();
			System.out.println("Algo2 = " + algo2.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7]));
			
			//Reach, Weight, Height, Age, Striking
			Algo3 algo3 = new Algo3();
			System.out.println("Algo3 = " + algo3.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3]));
			
			//Reach, Weight, Height, Age, Jiu Jitsu
			Algo4 algo4 = new Algo4();
			System.out.println("Algo4 = " + algo4.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[4],charArray[5],charArray[6],charArray[7]));
			
			//Reach, Weight, Height, Age, Wrestling		
			Algo5 algo5 = new Algo5();
			System.out.println("Algo5 = " + algo5.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11]));
																	
			//Reach, Weight, Height, Age, Striking, KOs														
			Algo6 algo6 = new Algo6();
			System.out.println("Algo6 = " + algo6.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],intArray[8],intArray[9],intArray[10],intArray[11]));

			//Reach, Weight, Height, Age, Jiu Jitsu, Subs
			Algo7 algo7 = new Algo7();
			System.out.println("Algo7 = " + algo7.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[4],charArray[5],charArray[6],charArray[7],intArray[12],intArray[13],intArray[14],intArray[15]));																	
																	
			//Reach, Weight, Height, Age, Wrestling, KOs, Subs														
			Algo8 algo8 = new Algo8();
			System.out.println("Algo8 = " + algo8.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11],intArray[8],intArray[9],intArray[10],intArray[11],
																	intArray[12],intArray[13],intArray[14],intArray[15]));														
																	
			//Reach, Weight, Height, Age, Striking, Jiu Jitsu														
			Algo9 algo9 = new Algo9();
			System.out.println("Algo9 = " + algo9.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[4],charArray[5],charArray[6],charArray[7]));														
																	
																	
			//Reach, Weight, Height, Age, Striking, Wrestling														
			Algo10 algo10 = new Algo10();
			System.out.println("Algo10 = " + algo10.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[8],charArray[9],charArray[10],charArray[11]));																	
																	
																	
			//Reach, Weight, Height, Age, Jiu Jitsu, Wrestling														
			Algo11 algo11 = new Algo11();
			System.out.println("Algo11 = " + algo11.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[4],charArray[5],charArray[6],charArray[7],charArray[8],charArray[9],charArray[10],charArray[11]));																	
																	
														
			//Reach, Weight, Height, Age, Striking, Jiu Jitsu, Wrestling														
			Algo12 algo12 = new Algo12();
			System.out.println("Algo12 = " + algo12.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[4],charArray[5],charArray[6],charArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11]));

			//Reach, Weight, Height, Age, KOs														
			Algo13 algo13 = new Algo13();
			System.out.println("Algo13 = " + algo13.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	intArray[8],intArray[9],intArray[10],intArray[11]));

			//Reach, Weight, Height, Age, Subs														
			Algo14 algo14 = new Algo14();
			System.out.println("Algo14 = " + algo14.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	intArray[12],intArray[13],intArray[14],intArray[15]));


			//Reach, Weight, Height, Age, KOs, Subs														
			Algo15 algo15 = new Algo15();
			System.out.println("Algo15 = " + algo15.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	intArray[8],intArray[9],intArray[10],intArray[11],intArray[12],intArray[13],intArray[14],intArray[15]));
														
	
			//Reach, Weight, Height, Age, Striking, Jiu Jitsu, Wrestling, KOs														
			Algo16 algo16 = new Algo16();
			System.out.println("Algo16 = " + algo16.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[4],charArray[5],charArray[6],charArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11],intArray[8],intArray[9],intArray[10],intArray[11]));

			//Reach, Weight, Height, Age, Striking, Jiu Jitsu, Wrestling, Subs														
			Algo17 algo17 = new Algo17();
			System.out.println("Algo17 = " + algo17.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[4],charArray[5],charArray[6],charArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11],intArray[12],intArray[13],intArray[14],intArray[15]));

	
			//Reach, Weight, Height, Age, Striking, Jiu Jitsu, Wrestling, KOs, Subs														
			Algo18 algo18 = new Algo18();
			System.out.println("Algo18 = " + algo18.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[4],charArray[5],charArray[6],charArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11],intArray[8],intArray[9],intArray[10],intArray[11],
																	intArray[12],intArray[13],intArray[14],intArray[15]));

			//Reach, Weight, Height, Age, Striking, Jiu Jitsu, Wrestling, KOs, Subs, Win/Lose Streak													
			Algo19 algo19 = new Algo19();
			System.out.println("Algo19 = " + algo19.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[4],charArray[5],charArray[6],charArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11],intArray[8],intArray[9],intArray[10],intArray[11],
																	intArray[12],intArray[13],intArray[14],intArray[15],charArray[12],charArray[13],charArray[14],charArray[15]));

			//Reach, Weight, Height, Age, Striking, Jiu Jitsu, Wrestling, KOs, Subs, At Home														
			Algo20 algo20 = new Algo20();
			System.out.println("Algo20 = " + algo20.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	charArray[0],charArray[1],charArray[2],charArray[3],charArray[4],charArray[5],charArray[6],charArray[7],
																	charArray[8],charArray[9],charArray[10],charArray[11],intArray[8],intArray[9],intArray[10],intArray[11],
																	intArray[12],intArray[13],intArray[14],intArray[15],charArray[16],charArray[17]));

																	
			//Reach, Weight, Height, Age, KOs, Subs, Win/Lose Streak, At Home													
			Algo21 algo21 = new Algo21();
			System.out.println("Algo21 = " + algo21.calculateWinner(charArray[18],intArray[0],intArray[1],intArray[2],intArray[3],intArray[4],intArray[5],intArray[6],intArray[7],
																	intArray[8],intArray[9],intArray[10],intArray[11],intArray[12],intArray[13],intArray[14],intArray[15],
																	charArray[12],charArray[13],charArray[14],charArray[15],charArray[16],charArray[17]));

																	
			in.close();
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
}


































