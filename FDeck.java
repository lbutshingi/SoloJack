//The textbook think java is used for some ideas
public class FDeck extends CardCollection
{
	public FDeck(String label)
	{
		super(label);

		for (int suit = 0; suit <= 3;suit++)
		{
			for(int rank = 1;rank <= 3;rank++)
			{
				addCard(new FCard(rank,suit));
			}
		}

	}


}