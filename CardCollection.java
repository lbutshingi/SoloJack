//The textbook (Think java is used for some ideas)ideas
import java.util.*;
public class CardCollection
{
	private String label;
	private ArrayList<FCard> cards;



	public CardCollection(String label)
	{
		this.label = label;
		this.cards = new ArrayList<FCard>();
	}
	public String getLabel()
	{
		return label;
	}
	public void addCard(FCard card)
	{
		cards.add(card);
	}
	public FCard popCard(int i)
	{
		return cards.remove(i);
	}
	public FCard popCard()
	{
		int i = size() - 1;
		return popCard(i);
	}
	public int size()
	{
		return cards.size();
	}
	public boolean empty()
	{
		return cards.size() == 0;
	}
	public void deal(CardCollection that,int n)
	{
		for(int i = 0;i < n;i++)
		{
			FCard card = popCard();
			that.addCard(card);
		}
	}
	public void dealAll(CardCollection that)
	{
		int n = size();
		deal(that,n);
	}

	public FCard getCard(int i)
	{
		return cards.get(i);
	}
	public FCard last()
	{
		int i = size() - 1;
		return cards.get(i);
	}

	public void swapCards(int i,int j)
	{
		FCard temp = cards.get(i);
		cards.set(i,cards.get(j));
		cards.set(j,temp);
	}

	public void shuffle()
	{
		Random r = new Random();
		for (int i = size() - 1;i > 0;i--)
		{
			int j = r.nextInt(i);
			swapCards(i,j);
		}
	}




}