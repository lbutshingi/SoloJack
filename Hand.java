//The textbook think java is used for some ideas
import java.util.Random;
public class Hand extends CardCollection
{
	public Hand(String label)
	{
		super(label);
	}

	public void display()
	{
		System.out.println(getLabel() + ": ");
		for(int i = 0; i < size();i++)
		{
			System.out.println(getCard(i));
		}
		System.out.println();
	}
	public void displayOne()
	{
		Random rnd = new Random();
		int num = rnd.nextInt(2);

		System.out.println(getLabel() + ": ");
		System.out.println(getCard(num));
	}
}