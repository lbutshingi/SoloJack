import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;
public class F
{
	
	public static int search(FCard[] cards,FCard target)
	{
		for(int i = 0; i < cards.length; i++)
		{
			if (cards[i].equals(target))
			{
				return i;
			}
		}
		return -1;
	}
	public static void printDeck(FCard[] cards)
	{
		for (int i = 0; i < cards.length; i++)
		{
			System.out.println(cards[i]);
		}
	}
	public static FCard[] makeDeck()
	{
		FCard[] cards = new FCard[52];
		int index = 0;
		for (int suit = 0;suit <= 3;suit++)
		{
			for (int rank = 1;rank <= 13;rank++)
			{
				cards[index] = new FCard(rank,suit);
				index++;
			}
		}
		return cards;
	}
	public static void play()
	{
		char ans;
		Scanner in = new Scanner(System.in);
		FDeck deck = new FDeck("deck");

		deck.shuffle();
		System.out.println("The dealer slides you 2 cards");
		Hand playerHand = new Hand("Your Hand");
		deck.deal(playerHand,2);
		playerHand.display();
		System.out.println();

		Hand dealerHand = new Hand("Dealer's Faced up Card");
		deck.deal(dealerHand,2);
		dealerHand.displayOne();
		System.out.println();

		System.out.print("Would you like to hit? (y/n): ");
		ans = in.next().charAt(0);
		if (ans == 'y')
		{
			Random rand = new Random();
			int x = rand.nextInt(2);
			deck.deal(dealerHand,x);

			deck.deal(playerHand,1);
			playerHand.display();
			int counter = 0;
			int tot = 0;
			for(int i = 0;i < 3;i++)
			{
				tot = playerHand.getCard(i).getRank();
				counter += tot;
			}
			int yDCounter = 0;
			int yDTot = 0;
			for (int i = 0; i < dealerHand.size(); i++)
			{
				yDTot = dealerHand.getCard(i).getRank();
				yDCounter += yDTot;	
			}
			dealerHand.display();
			System.out.println("The dealer's hand is worth "+yDCounter+" points");
			System.out.println("Your hand is worth "+counter+" points");
			if (counter > 21)
			{
				System.out.println("You lose this");
				System.out.println();
				//play();
			}
			else if (counter == 21)
			{
				System.out.println("You win this");
				System.out.println();
				//play();
			}
			else if ((yDCounter > 21)&&(counter < 21))
			{
				System.out.println("You win this");
				System.out.println();
				//play();
			}
			else if ((counter > yDCounter)&&(counter <= 21))
			{
				System.out.println("You win this");
				System.out.println();
				//play();
			}
			else if ((yDCounter > counter)&&(yDCounter <= 21))
			{
				System.out.println("You lose this ");
				System.out.println();
				//play();
			}
			else if ((yDCounter == counter))
			{
				System.out.println("You niether win nor lose");
				System.out.println();
				//play();
			}
		}
		else if(ans =='n')
		{
			Random rand = new Random();
			int x = rand.nextInt(2);
			deck.deal(dealerHand,x);
			dealerHand.display();
			int dCounter = 0;
			int dTot = 0;
			for(int i = 0; i < dealerHand.size();i++)
			{
				dTot = dealerHand.getCard(i).getRank();
				dCounter += dTot;
			}
			System.out.println("The dealer's hand is worth " + dCounter +" points");
			int nCounter = 0;
			int nTot = 0;
			for(int i = 0;i < playerHand.size();i++)
			{
				nTot = playerHand.getCard(i).getRank();
				nCounter += nTot;

			}

			System.out.println("Your hand is worth "+ nCounter+" points");
			if ((nCounter < dCounter) &&(nCounter <= 21) &&(dCounter <= 21))
			{
				System.out.println("You lose");
				System.out.println();
				//play();
			}
			if ((nCounter < dCounter) &&(nCounter <= 21) &&(dCounter > 21))
			{
				System.out.println("You win");
				System.out.println();
				//play();
			}
			if((nCounter > dCounter) && (nCounter <= 21))
			{
				System.out.println("You win");
				System.out.println();
				//play();
			}

		}



		//Hand drawPile = new Hand("Draw Pile");
		//deck.dealAll(drawPile);
		//System.out.printf("Draw Pile has %d cards.\n",drawPile.size());
	}
	public static void greetings()
	{
		char ans;
		Scanner in = new Scanner(System.in);
		System.out.print("Welcome to BlackJack, would you like to play?(y/n): ");
		ans = in.next().charAt(0);
		System.out.println();
		if (ans == 'y')
		{
			play();
		}
		else if (ans == 'n')
		{
			System.out.println("Okay, Have lovely day.");
		}
		else
		{
			System.out.println("Please enter (y/n)");
			greetings();
		}
	}
	public static void main(String[] args)
	{
		
		//Deck cards = new Deck();
		//cards.print();
		//FCard[] card2 = makeDeck();
		
		//cards.printArr();
		//System.out.println();
		//System.out.println(Arrays.toString(cards.fYales()));

		//FCard[] shuffledCards = cards.fYales();
		//Deck newShuffledCards = new Deck(shuffledCards);
		
		//cards.printArr();
		//System.out.println(Arrays.toString(shuffledCards));
		//System.out.println();
		//int[] diff = cards.diffArr();
		//System.out.println("Shannon Entropy:"+newShuffledCards.shannonEntr());
		//ardCollection cards = new CardCollection("cards");

		//CardCollection crd = new CardCollection("card");
		greetings();
		

		

		//Hand drawPile = new Hand("Draw Pile");
		//deck.dealAll(drawPile);
		//System.out.printf("DrawPile has %d cards.\n",drawPile.size());

	


	



	}
}