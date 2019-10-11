//The textbook is used for some ideas
import java.util.*;
public class Deck
{
	private FCard[] nCards;

	public Deck(FCard[] n)
	{
		this.nCards = n;
	}
	public Deck()
	{
		this.nCards = new FCard[52];
		int index = 0;
		for (int suit = 0;suit <= 3;suit++)
		{
			for (int rank = 1;rank <= 13;rank++)
			{
				nCards[index] = new FCard(rank,suit);
				index++;
			}
		}
		//this.cards = new LinkedList(Arrays.asList(nCards));
	}
	public void printArr()
	{
		System.out.println(Arrays.toString(this.nCards));
	}
	
	public FCard[] fYales()
	{ //Shuffling the cards using the Fisher Yales Shuffle
		Random rand = new Random();
		int indx;
		FCard temp;
		FCard[] b = Arrays.copyOf(this.nCards,this.nCards.length);
		for (int i =b.length -1;i > 0;i--)
		{
			indx = rand.nextInt(i+1);
			temp = b[indx];
			b[indx] = b[i];
			b[i] = temp;
		}
		return b;
	}

	public double shannonEntr()
	{

		int a,diff,count;
		FCard[] b = fYales();
		int[] diffArr = new int[51];
		for (a = 0;a <= b.length - 2;a++)
		{
			diff = search(this.nCards,b[a + 1]) - search(this.nCards,b[a]);
			if (diff < 0)
			{
				diff += 52;
			}
			diffArr[a] = diff;
		}
		int target;
		int counter = 0;
		int[] counts = new int[diffArr.length];
		double[] prob = new double[diffArr.length];
		double[] entr = new double[diffArr.length];

		for (int j = 0;j< diffArr.length;j++)
		{
			 target = diffArr[j];
			for (int k = 0; k< diffArr.length;k++)
			{
				if (target == diffArr[k])
				{
					counter++;
				}
			}
		

			counts[j] = counter;
			
			prob[j] = Math.round(((counter*1.0)/diffArr.length)*1000.0)/1000.0;
			entr[j] = prob[j]*(Math.log(prob[j])/Math.log(2));
			counter = 0;
		}
		int len = diffArr.length;
		int z = 0;
		int w = z + 1;
		for (z = 0;z< len -1;z++)
		{
			for(w = z + 1;w<len -1;w++)
			{
				if (diffArr[z]== diffArr[w])
				{
					diffArr[w]=0;
				}
			}
		}
		for(int x = 0;x<counts.length -1;x++)
		{
			if (diffArr[x] == 0)
			{
				counts[x]=0;
			}
		}
		double[] probability = new double[counts.length];
		for (int x = 0; x< counts.length -1;x++)
		{
			probability[x] = Math.round(((counts[x]*1.0)/counts.length)*1000.0)/1000.0;
		}
		double[] entropy = new double[counts.length];
		for (int x = 0;x < counts.length -1;x++)
		{
			if (probability[x]>0.0)
			{
				entropy[x] = probability[x]*(Math.log(probability[x])/Math.log(2));
			}
			else
			{
				continue;
			}
		}
		double sum = 0;
		for (double m : entropy)
		{
			sum += m;
		}
		double shannonEntropy = sum*-1;
		return shannonEntropy;
	}
	
	
	public int search(FCard[] cards,FCard target)
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

	

	

	
	public void print()
	{
		for(int i = 0;i < this.nCards.length;i++)
		{
			System.out.println(this.nCards[i]);
		}
	}

	

}