//The textbook think java is used for some ideas
public class FCard
{
	public static final String[] RANKS = {null,"Ace","2","3","4","5","6","7","8","9","10","Jack","Queen","King"};
	public static final String[] SUITS = {"Clubs","Diamonds","Hearts","Spades"};
	private final int rank;
	private final int suit;

	public FCard(int rank,int suit)
	{
		this.rank = rank;
		this.suit =  suit;
	}

	public String toString()
	{ // for dispaying the name of the card 
		return RANKS[this.rank] + " of " + SUITS[this.suit];
	}

	public boolean equals(FCard that)
	{ //for testing whether two cards are equivalent 
		return ((this.rank == that.rank) && (this.suit == that.suit));
	}

	public int compareTo(FCard that)
	{ // for comparing which card is bigger 
		if (this.suit < that.suit)
		{
			return -1;
		}
		if (this.suit > that.suit)
		{
			return 1;
		}
		if (this.rank < that.rank)
		{
			return -1;
		}
		if (this.rank > that.rank)
		{
			return 1;
		}

		return 0;
	}
	public int getRank()
	{ // for other classes to access instance variables
		if (this.rank > 10)
		{
			return 10;
		}
		return this.rank;
	}
	public int getSuit()
	{
		return this.suit;
	}
}