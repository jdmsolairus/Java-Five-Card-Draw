
import java.awt.Transparency;
import java.awt.geom.Area;
import java.util.Collections;
import java.util.Random;
import java.util.Vector;
import java.util.logging.Handler;

import javax.swing.text.Highlighter.Highlight;

import org.omg.CORBA.PUBLIC_MEMBER;

public class dealHand {
		private int numCards = 5;
		private int handValue;
		private int straightCards;
		private int flushCards;
		private Vector<card> handValueSpecific = new Vector<card>();
		private Vector<card> remainingCards = new Vector<card>();
		private Vector<card> OriginalHand = new Vector<card>();
		private boolean winningHand;
		private String handName;
		private Vector<card> handDealt = new Vector<card>();
		int counter = 0;
		boolean straight = false;
		boolean flush = false;
			public Vector<card> dealPlayers(Vector<card> deck)
			{
				Vector<card> hand = new Vector<card>();
				Random rand = new Random();
				for (int i = 0; i < 5; i++) 
				{
					int  n = rand.nextInt(deck.size()-i) + 0;
					hand.add(deck.get(n));
					deck.remove(deck.get(n));
				}
				handDealt = hand;
				return hand;
			}
			public void handUpdate(dealHand unupdated, Vector<card> updated)
			{
				
				if(updated.size()!=0)
				{
					unupdated.getHandDealt().removeAllElements();
					for (int i = 0; i < updated.size(); i++) 
						{
						unupdated.getHandDealt().add(updated.get(i));
						}
				}
				else if (updated.size()==0) 
				{
					System.out.println("no change");
				}
			}
			public void handValue()
			{
				handValue = 0;
				//remainingCards = handDealt;
				for (int i = 0; i < handDealt.size(); i++) 
				{
					for (int j = i+1; j < handDealt.size(); j++) 
					{
						if(handDealt.get(i).getValue()==handDealt.get(j).getValue())
						{
							handValue = handValue+1;
							getHandValueSpecific().addElement(handDealt.get(i));
							getHandValueSpecific().addElement(handDealt.get(j));
						}	
					}
				}
				int counter1 = 0;
				for (int i = 0; i < getHandValueSpecific().size(); i++) 
				{
					for (int j = i+1; j < getHandValueSpecific().size(); j++) 
					{
						if(getHandValueSpecific().get(i).getName().equals(getHandValueSpecific().get(j).getName()))
						{
							getHandValueSpecific().remove(i);
						}
					}
				}
				
				
				for (int i = 0; i < getHandValueSpecific().size(); i++) 
				{
					if(remainingCards.contains(getHandValueSpecific().get(i)))
					{
						remainingCards.removeElement(getHandValueSpecific().get(i));
					}
				}
				
				if(handValue==4)
				{
					handValue = 6;
				}
				else if (handValue==6) 
				{
					handValue = 7;
				}
				for (int i = 0; i < handDealt.size(); i++) 
				{
					for (int j = i+1; j < handDealt.size(); j++) 
					{
						if(handDealt.get(i).getSuit().equals(handDealt.get(j).getSuit()))
						{
							counter = counter+1;
							if(counter == 10)
							{
							handValue = 5;
							flush = true;
							setHandValueSpecific(handDealt);
							}
							if(counter>4&&counter<10)
							{
							 flushCards = 4;
							}
							if(counter == 3)
							{
								flushCards = 3;
							}
							if(counter == 2)
							{
								flushCards = 2;
							}
							if(counter == 1)
							{
								flushCards = 1;
							}
							if(counter == 0)
							{
								flushCards = 0;
							}
						}	
					}					
				}
				
				int straightMatch = 0;
				Collections.sort(handDealt);
				
			
			
				for (int i = 0; i < handDealt.size()-1; i++) 
				{
					if(straightMatch >1&&(handDealt.get(i).getValue()-(handDealt.get(i+1).getValue())!=1))
					{
						straightMatch = straightMatch-1;
					}
					if(handDealt.get(i).getValue()-(handDealt.get(i+1).getValue())==1)
						{
						straightMatch = straightMatch+1;
						}
				}
				straightCards = straightMatch;
				
				
				
				if(straightMatch == 4)
				{
					handValue = 4;
					straight = true;
					setHandValueSpecific(handDealt);
				}
				if(flush == true && straight == true)
				{
					handValue = 8;
				}
				if(handValue == 0)
				{
					setHandValueSpecific(handDealt);
					handName= "High Card";
				}
				else if(handValue == 1)
				{
					handName = "Pair";
				}
				else if(handValue == 2)
				{
					handName = "Two Pair";
				}
				else if (handValue == 3) 
				{
					handName = "Three Of A Kind";
				}
				else if(handValue == 4)
				{
					handName = "Straight";
				}
				else if(handValue == 5)
				{
					handName = "Flush";
				}
				else if(handValue == 6)
				{
					handName = "Full House";
				}
				else if (handValue == 7) 
				{
					handName = "Four of a kind";
				}
				else if(handValue == 8)
				{
					handName = "Straight Flush";
					setHandValueSpecific(handDealt);
				}
			
			}
			public void compare(dealHand player, dealHand cpu)
			{
				if(player.handValue>cpu.handValue)
				{
					System.out.println("player has higher hand");
					cpu.winningHand = false;
					player.winningHand = true;
				}
				else if(player.handValue<cpu.handValue)
				{
					System.out.println("cpu has higher hand");
					cpu.winningHand = true;
					player.winningHand = false;
				}
				else 
				{
					if(cpu.remainingCards.size()== numCards)
					{
					
					for (int i = 0; i < numCards; i++) 
					{
						if(cpu.remainingCards.get(i).getValue()>player.remainingCards.get(i).getValue())
						{
						System.out.println("cpu has bigger card");
						cpu.winningHand = true;
						player.winningHand = false;
						break;
						}
						else if(cpu.remainingCards.get(i).getValue()<player.remainingCards.get(i).getValue())
						{
						System.out.println("player has bigger card");
						player.winningHand = true;
						cpu.winningHand = false;
						break;
						}
					}
					Collections.sort(cpu.remainingCards);
					Collections.sort(player.remainingCards);
					}
					else if(cpu.remainingCards.size()!=numCards)
					{
						Collections.sort(cpu.getHandValueSpecific());
						Collections.sort(player.getHandValueSpecific());
						for (int i = 0; i < cpu.getHandValueSpecific().size(); i++) 
						{
							if(cpu.getHandValueSpecific().get(i).getValue()>player.getHandValueSpecific().get(i).getValue())
							{
							System.out.println("cpu has bigger card");
							cpu.winningHand = true;
							player.winningHand = false;
							break;
							}
							else if(cpu.getHandValueSpecific().get(i).getValue()<player.getHandValueSpecific().get(i).getValue())
							{
							System.out.println("player has bigger card");
							player.winningHand = true;
							cpu.winningHand = false;
							break;
							}
						}
					}
					if(cpu.handValue == 6 && player.handValue == 6)
					{
						if(cpu.getRemainingCards().get(numCards-2).getValue()>player.getRemainingCards().get(numCards-2).getValue())
						{
						cpu.winningHand = true;
						player.winningHand = false;
						}
						else if(cpu.getRemainingCards().get(numCards-2).getValue()<player.getRemainingCards().get(numCards-2).getValue())
						{
						player.winningHand = true;
						cpu.winningHand = false;
						}
					}
				}
			}
			public void playerDraw(Vector<card> deck, Vector<card> player, Vector<card> cardsDrawn)
			{
				Random randn = new Random();
				Collections.sort(cardsDrawn);
				for (int i = 0; i < cardsDrawn.size(); i++) 
				{
					int  n = randn.nextInt(deck.size()-i) + 0;
					player.remove(cardsDrawn.get(i));
					player.add(deck.get(n));
					deck.remove(deck.get(n));
				}
				Collections.sort(player);
			}
			public void cpuDraw(Vector<card> deck, Vector<card> cpu, dealHand cpuHand, Vector<card> goodcards, Vector<card> cpuHandfinal)
			{
				Random rands = new Random();
				System.out.println(cpuHand.getFlushCards());
				System.out.println(cpuHand.getStraightCards());
				if(cpuHand.getHandValue()== 0&&(flushCards>3))
				{
					
					String starter = cpuHand.getHandDealt().get(0).getName();
					String starterTwo = cpuHand.getHandDealt().get(1).getName();
					String startThree = cpuHand.getHandDealt().get(2).getName();
					String startFour = cpuHand.getHandDealt().get(3).getName();
					String lookFor = "";
					if(starter.equals(starterTwo))
					{
						lookFor = starter;
					}
					if(startThree.equals(startFour))
					{
						lookFor = startThree;
					}
		
					for (int i = 0; i < numCards; i++) 
					{	
						if(cpuHand.getHandDealt().get(i).getName().equals(lookFor))
						{
							cpuHandfinal.add(getHandDealt().get(i));
						}
						else if(!cpuHand.getHandDealt().get(i).getName().equals(lookFor))
						{
							int n = rands.nextInt(deck.size()-i)+0;
							cpuHandfinal.add(deck.get(n));
							deck.remove(deck.get(n));
						}
					}
					
				}
				else if(cpuHand.getHandValue()== 0&&(straightCards<3&&flushCards<4))
				{
					int t = rands.nextInt(2)+1;
					for (int i = 0; i < t; i++) 
					{
						cpuHandfinal.addElement(getHandValueSpecific().get(i));
					}
					for (int i = 0; i < numCards-t; i++) 
					{
						int  n = rands.nextInt(deck.size()-i) + 0;
						cpuHandfinal.add(deck.get(n));
						deck.remove(deck.get(n));
					}
					System.out.println(cpuHandfinal);
					
				}

				else if((((cpuHand.getHandValue() == 1) &&((cpuHand.getFlushCards()!=4)&&cpuHand.getStraightCards()!=4))))
				{
					goodcards.addAll(cpuHand.getHandValueSpecific());
					cpuHandfinal.addAll(goodcards);
					for (int i = 0; i < (numCards-goodcards.size()); i++) 
					{
						int  n = rands.nextInt(deck.size()-i) + 0;
						cpuHandfinal.add(deck.get(n));
						deck.remove(deck.get(n));
					}
					System.out.println(cpuHandfinal);
				}
				else if(((cpuHand.getHandValue() == 1 && cpuHand.getHandValueSpecific().get(0).getValue()<9))&&((cpuHand.getFlushCards()==4||cpuHand.getStraightCards()==4)))
				{
					if(cpuHand.getStraightCards() == 4)
					{
						for (int i = 0; i < numCards-1; i++) 
						{
						 
							if((cpuHand.getHandDealt().get(i).getValue()+1)== cpuHand.getHandDealt().get(i+1).getValue())
							{
								cpuHandfinal.add(cpuHand.getHandDealt().get(i));
							}
						}
						for (int i = 1; i < numCards-1; i++) 
						{

							if(((cpuHand.getHandDealt().get(i).getValue()+1)!= cpuHand.getHandDealt().get(i+1).getValue())&&((cpuHand.getHandDealt().get(i).getValue()-1)!= cpuHand.getHandDealt().get(i-1).getValue()))
							{
								int  n = rands.nextInt(deck.size()-i) + 0;
								cpuHandfinal.add(deck.get(n));
								deck.remove(deck.get(n));
							}
						}
					}
					if(cpuHand.getFlushCards() == 4)
					{
						System.out.println("you are here");
						for (int i = 0; i < numCards-1; i++) 
						{
							if((cpuHand.getHandDealt().get(i).getName().equals(cpuHand.getHandDealt().get(i+1).getName())))
							{
								cpuHandfinal.add(getHandDealt().get(i));
							}
							else {
								int  n = rands.nextInt(deck.size()-i) + 0;
								cpuHandfinal.add(deck.get(n));
								deck.remove(deck.get(n));
							}
						}
					}
				}
				else if(cpuHand.getHandValue()>1&&cpuHand.getHandValueSpecific().size()!=numCards)
				{
					
					goodcards.addAll(cpuHand.getHandValueSpecific());
					cpuHandfinal.addAll(goodcards);
					for (int i = 0; i < (numCards-getHandValueSpecific().size()); i++) 
					{
						int  n = rands.nextInt(deck.size()-i) + 0;
						cpuHandfinal.add(deck.get(n));
						deck.remove(deck.get(n));
					}
					System.out.println(cpuHandfinal);
				}
				else if(cpuHand.getHandValue()>3 && cpuHand.getHandValueSpecific().size() == numCards)
				{
					goodcards.addAll(cpuHand.getHandValueSpecific());
					cpuHandfinal.addAll(goodcards);
					System.out.println(cpuHandfinal);
				}
			}

			
			public Vector<card> getHandDealt() {
				return handDealt;
			}
			public void setHandDealt(Vector<card> handDealt) {
				this.handDealt = handDealt;
			}
			public int getHandValue()
			{
				return handValue;
			}
			public void setHandValue(int handValue) 
			{
				this.handValue = handValue;
			}
			public String getHandName() 
			{
				return handName;
			}
			public void setHandName(String handName) 
			{
				this.handName = handName;
			}
			public boolean isWinningHand() {
				return winningHand;
			}
			public void setWinningHand(boolean winningHand) {
				this.winningHand = winningHand;
			}
			public Vector<card> getRemainingCards() {
				return remainingCards;
			}
			public void setRemainingCards(Vector<card> remainingCards) {
				this.remainingCards = remainingCards;
			}
			public Vector<card> getHandValueSpecific() {
				return handValueSpecific;
			}
			public void setHandValueSpecific(Vector<card> handValueSpecific) {
				this.handValueSpecific = handValueSpecific;
			}
			public Vector<card> getOriginalHand() {
				return OriginalHand;
			}
			public void setOriginalHand(Vector<card> originalHand) {
				OriginalHand = originalHand;
			}
			public int getFlushCards() {
				return flushCards;
			}
			public void setFlushCards(int flushCards) {
				this.flushCards = flushCards;
			}
			public int getStraightCards() {
				return straightCards;
			}
			public void setStraightCards(int straightCards) {
				this.straightCards = straightCards;
			}
}
