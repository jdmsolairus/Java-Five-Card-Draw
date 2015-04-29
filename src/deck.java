import java.util.ArrayList;
import java.util.Iterator;
import java.util.Vector;
import java.util.PrimitiveIterator.OfDouble;

import javax.swing.ImageIcon;

import org.omg.CORBA.portable.ValueBase;


public class deck{
	
		private int numberofdecks;
		Vector<card> theDeck = new Vector<card>();
		int counter = 0;
		
		public Vector<card> generateDeck(){
			numberofdecks +=1 ;
			for (int i = 0; i < 52; i++)
			{
				counter = counter+1;
				card number = new card();
				theDeck.add(number);
				if(i%13==0)
				{
					counter = 0;
				}
				if (counter<9) 
				{
					theDeck.get(i).setName(String.valueOf(counter+2));
					theDeck.get(i).setValue(counter);
				}
				if (counter == 9) 
				{
					theDeck.get(i).setName("Jack");
					theDeck.get(i).setValue(9);
				}
				if (counter == 10) 
				{
					theDeck.get(i).setName("Queen");
					theDeck.get(i).setValue(10);
				}
				if (counter == 11) 
				{
					theDeck.get(i).setName("King");
					theDeck.get(i).setValue(11);
				}
				if (counter == 12) 
				{
					theDeck.get(i).setName("Ace");
					theDeck.get(i).setValue(12);
				}
				if(i<13)
				{
					theDeck.get(i).setSuit("Diamonds");
				}
				if(i<26&& i>12)
				{
					theDeck.get(i).setSuit("Hearts");
				}
				if(i<39 && i>25)
				{
					theDeck.get(i).setSuit("Clubs");
				}
				if (i<53 && i> 38)
				{
					theDeck.get(i).setSuit("Spades");
				}
			}
			for (int i= 0; i < 52; i++) 
			{
				if(theDeck.get(i).getName().equals("2 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/2_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("2 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/2_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("2 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/2_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("2 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/2_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("3 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/3_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("3 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/3_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("3 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/3_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("3 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/3_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("4 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/4_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("4 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/4_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("4 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/4_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("4 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/4_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("5 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/5_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("5 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/5_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("5 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/5_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("5 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/5_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("6 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/6_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("6 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/6_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("6 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/6_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("6 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/6_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("7 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/7_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("7 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/7_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("7 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/7_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("7 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/7_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("8 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/8_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("8 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/8_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("8 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/8_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("8 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/8_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("9 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/9_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("9 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/9_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("9 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/9_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("9 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/9_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("10 of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/10_of_spades.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("10 of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/10_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("10 of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/10_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("10 of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/10_of_diamonds.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Jack of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Jack_of_spades2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Jack of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Jack_of_clubs2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Jack of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Jack_of_hearts2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Jack of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Jack_of_diamonds2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Queen of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Queen_of_spades2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Queen of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Queen_of_clubs2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Queen of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Queen_of_hearts2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Queen of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Queen_of_diamonds2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("King of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/King_of_spades2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("King of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/King_of_clubs2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("King of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/King_of_hearts2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("King of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/King_of_diamonds2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Ace of Spades"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Ace_of_spades2.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Ace of Clubs"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Ace_of_clubs.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Ace of Hearts"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Ace_of_hearts.png")).getImage());
				}
				else if(theDeck.get(i).getName().equals("Ace of Diamonds"))
				{
				theDeck.get(i).setImg(new ImageIcon(this.getClass().getResource("/Ace_of_diamonds.png")).getImage());
				}
			}
			return theDeck;
		}
}
