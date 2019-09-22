import java.util.Scanner;

public class Problem03 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scnr = new Scanner(System.in);
		String topics[] = new String[]{"Politics", "Economy", "Family", "Technology", "Health"};
		String headers[] = new String[] {"Topics", "Tallied Votes", "Average Vote"};
		int responses[][] = new int[5][10];
		int totalScores[] = new int[5];
		int userNum = 1;
		char choice;
		String spacer = "";
		int lowestScore = 0;
		int highestScore = 0;
		String lowList[] = new String [5]; //People suggest using List on forums if you don't know the array size
		String highList[] = new String[5];
		int storeNum = 0;
		int lowCounter = 0;
		int highCounter = 0;
		
		System.out.println("User: " + userNum);
		System.out.println("Rate how important each issue is to you");
		System.out.println("1 (least important) to 10 (most important):");
		
		//try storing info first, then drawing out the results, while loops?
		//initialize
		for(int i = 0; i < 5; i++)
		{
			for (int j = 0; j < 10; j++)
			{
				responses [i][j] = 0;
			}
		}		
		
		do
		{		//repeat loop after this
			for(int i = 0; i < 5; i++)
			{
				System.out.print(topics[i] + ": ");
				int userAnsr = scnr.nextInt();
			
				while (userAnsr <= 0 || userAnsr >= 11)
					userAnsr = scnr.nextInt();
				
				//refactored from else if list to this	
				for (int j = 0; j <= 10; j++)
					if (userAnsr == j)
					{
						responses[i][j-1] = responses[i][j-1]+1; //just use += like below?
						//sum points to find average
						totalScores[i] += userAnsr;
					}
			}

			System.out.print("Another user? y/n: ");
			choice = scnr.next().charAt(0);
			
			while ((choice != 'y') && (choice != 'n'))
			{
				System.out.print("Please input only y/n: ");
				choice = scnr.next().charAt(0);
			}
			//swapped order to add user number
			if (choice == 'y') 
			{
				System.out.println("\nUser: " + ++userNum + "\n");
			} 
			else if (choice == 'n')
			{
				System.out.println("Thanks for voting! Total results below:\n");
				break; //I think I need this break? I saw from an example online
			}
		
		} while (choice == 'y');
		
		//Chart print out results
		//Header - Topics, Tallied, Average
		System.out.printf( "%-10s %21s %26s %n", headers[0], headers[1], headers[2]);
		System.out.printf("%-11s", spacer);
		for(int i = 0; i < 10; i++)
		{
			System.out.printf(" %d ", i+1);
		}
		System.out.println("");
			
			
		//rows & column
		for(int i = 0; i < 5; i++)
		{
			//print subject
			//System.out.print(topics[i] + ": ");
			System.out.printf("%-10s", topics[i]);
			System.out.printf("%2s", spacer);
			//prints out columns
			for (int j = 0; j < 10; j++)
			{
				if(responses[i][j] == 0)
					System.out.print("   ");
				else
					System.out.printf("%d  ", responses[i][j]);
			}
			
			//get average at end of line
			System.out.printf("%13.2f", totalScores[i] / (double) userNum);
			System.out.println(" ");
			
		}
		
		//highest and lowest point totals sorting thing? - probably overly complicated and redundant ask how to refactor
		for(int i = 0; i < 5; i++) 
		{
			//low
			if (lowestScore == 0)
				{
					lowestScore = totalScores[i];
					lowList[lowCounter] = topics[i];
				}
			
			if (totalScores[i] < lowestScore)
				{
					lowestScore = totalScores[i];
					for (int j = 0; j < lowCounter; j++)
						lowList[j] = null;
					lowList[lowCounter] = topics[i];
				}
			if(totalScores[i] == lowestScore)
			{
				lowList[lowCounter] = topics[i];
				lowCounter++;
			}
	
			//high
			if (highestScore == 0)
			{
				highestScore = totalScores[i];
				highList[highCounter] = topics[i];
			}
			if (totalScores[i] > highestScore)
				{
					highestScore = totalScores[i];
					for (int j = 0; j < highCounter; j++)
						highList[j] = null;
					highList[highCounter] = topics[i];
				}
			if(totalScores[i] == highestScore)
			{
				highList[highCounter] = topics[i];
				highCounter++;
			}
		}
		
		//printing the lowest
		System.out.println("");
		System.out.print("The issue(s) with the lowest rating score is/are: ");
		for (int i = 0; i < lowList.length; i++)
		{
			if (lowList[i] != null)
			System.out.printf(lowList[i] + ", ");
		}
		System.out.printf("at %d points.\n", lowestScore);
		
		//printing the highest
		System.out.println("");
		System.out.print("The issue(s) with the highest rating score is/are: ");
		for (int i = 0; i < highList.length; i++)
		{
			if (highList[i] != null)
			System.out.printf(highList[i] + ", ");
		}
		System.out.printf("at %d points.\n", highestScore);
	}

}
