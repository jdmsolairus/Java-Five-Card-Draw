import java.awt.Image;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import java.awt.Checkbox;
import java.awt.Font;
import java.awt.Color;

import javax.swing.JCheckBox;
import javax.swing.JButton;
import javax.swing.JTextArea;

import org.eclipse.wb.swing.FocusTraversalOnArray;
import org.omg.CORBA.PUBLIC_MEMBER;

import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class gui extends JFrame implements ActionListener{
	private JTextField textField;
	private JTextField txtCpuHand;
	public gui() {
		getContentPane().setFont(new Font("Dialog", Font.BOLD, 14));
		getContentPane().setBackground(new Color(0, 204, 51));
		getContentPane().setForeground(Color.GREEN);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);
		
		Vector<Image> playerimg = new Vector<Image>();

		Vector<JCheckBox> checkboxes = new Vector<JCheckBox>();
		
		
		boolean continueplay = false;
		int drawCards;
		Vector<Integer> cardsDrawn = new Vector<Integer>();
		Vector<JLabel> playerimages = new Vector<JLabel>();
		Vector<JLabel> cpuimages = new Vector<JLabel>();
		Vector<card> playersCards = new Vector<card>();
		Image defaultimage = new ImageIcon(this.getClass().getResource("/default.jpg")).getImage();
		getContentPane().setLayout(null);
		
		
	
		
		
		JLabel pCardOne = new JLabel("");
		pCardOne.setBounds(10, 360, 100, 120);
		getContentPane().add(pCardOne);
		
		JLabel pCardTwo = new JLabel("");
		pCardTwo.setBounds(120, 360, 100, 120);
		getContentPane().add(pCardTwo);
		
		JLabel pCardThree = new JLabel("");
		pCardThree.setBounds(230, 360, 100, 120);
		getContentPane().add(pCardThree);
		
		JLabel pCardFour = new JLabel("");
		pCardFour.setBounds(340, 360, 100, 120);
		getContentPane().add(pCardFour);
		
		JLabel pCardFive = new JLabel("");
		pCardFive.setBounds(450, 360, 100, 120);
		getContentPane().add(pCardFive);
		getContentPane().setLayout(null);
		textField = new JTextField();
		textField.setFont(new Font("Tahoma", Font.BOLD, 15));
		textField.setEditable(false);
		textField.setText("Your Hand:");
		textField.setColumns(10);
		textField.setBounds(230, 312, 90, 20);
		getContentPane().add(textField);
		
		JLabel defaultCard = new JLabel("");
		defaultCard.setBounds(230, 176, 100, 120);
		getContentPane().add(defaultCard);
		
		JLabel cpuCardOne = new JLabel("");
		cpuCardOne.setBounds(230, 12, 100, 120);
		getContentPane().add(cpuCardOne);
		
		txtCpuHand = new JTextField();
		txtCpuHand.setText("CPU Hand:");
		txtCpuHand.setFont(new Font("Tahoma", Font.BOLD, 15));
		txtCpuHand.setEditable(false);
		txtCpuHand.setColumns(10);
		txtCpuHand.setBounds(230, 144, 90, 20);
		getContentPane().add(txtCpuHand);
		
		JLabel cpuCardTwo = new JLabel("");
		cpuCardTwo.setBounds(340, 12, 100, 120);
		getContentPane().add(cpuCardTwo);
		
		JLabel cpuCardThree = new JLabel("");
		cpuCardThree.setBounds(120, 12, 100, 120);
		getContentPane().add(cpuCardThree);
		
		JLabel cpuCardFour = new JLabel("");
		cpuCardFour.setBounds(10, 12, 100, 120);
		getContentPane().add(cpuCardFour);
		
		JLabel cpuCardFive = new JLabel("");
		cpuCardFive.setBounds(450, 12, 100, 120);
		getContentPane().add(cpuCardFive);
		
		JCheckBox checkBox = new JCheckBox("");
		checkBox.setBackground(new Color(0, 204, 51));
		checkBox.setBounds(49, 487, 21, 24);
		getContentPane().add(checkBox);
		
		JCheckBox checkBox_1 = new JCheckBox("");
		checkBox_1.setBackground(new Color(0, 204, 51));
		checkBox_1.setBounds(159, 487, 21, 24);
		getContentPane().add(checkBox_1);
		
		JCheckBox checkBox_2 = new JCheckBox("");
		checkBox_2.setBackground(new Color(0, 204, 51));
		checkBox_2.setBounds(269, 487, 21, 24);
		getContentPane().add(checkBox_2);
		
		JCheckBox checkBox_3 = new JCheckBox("");
		checkBox_3.setBackground(new Color(0, 204, 51));
		checkBox_3.setBounds(379, 487, 21, 24);
		getContentPane().add(checkBox_3);
		
		JCheckBox checkBox_4 = new JCheckBox("");
		checkBox_4.setBackground(new Color(0, 204, 51));
		checkBox_4.setBounds(489, 487, 21, 24);
		getContentPane().add(checkBox_4);
		
		JButton btnDrawCards = new JButton("New Game");
		btnDrawCards.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDrawCards.setBounds(97, 163, 110, 26);
		getContentPane().add(btnDrawCards);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(395, 315, 126, 16);
		getContentPane().add(textArea);
		
		JButton button = new JButton("Draw Cards");
		
		button.setBounds(97, 198, 110, 26);
		getContentPane().add(button);
		
		JTextArea txtrYouWon = new JTextArea();
		txtrYouWon.setForeground(new Color(0, 204, 0));
		txtrYouWon.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtrYouWon.setText("You Won!!!");
		txtrYouWon.setEditable(false);
		txtrYouWon.setBounds(395, 176, 126, 24);
		getContentPane().add(txtrYouWon);
		txtrYouWon.setVisible(false);
		
		JTextArea txtrYouLost = new JTextArea();
		txtrYouLost.setText("You Lost!!!");
		txtrYouLost.setFont(new Font("Tahoma", Font.BOLD, 18));
		txtrYouLost.setForeground(new Color(255, 0, 0));
		txtrYouLost.setEditable(false);
		txtrYouLost.setBounds(395, 221, 126, 24);
		getContentPane().add(txtrYouLost);
		txtrYouLost.setVisible(false);
		
		
		
		
		getContentPane().setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{pCardOne, pCardTwo, pCardThree, pCardFour, pCardFive, textField, defaultCard, cpuCardOne, txtCpuHand, cpuCardTwo, cpuCardThree, cpuCardFour, cpuCardFive, checkBox_2, checkBox, checkBox_1, checkBox_3, checkBox_4, btnDrawCards, textArea}));
		
		{
			do {
			playerimages.addAll(Arrays.asList(pCardOne, pCardTwo, pCardThree, pCardFour, pCardFive));
			cpuimages.addAll(Arrays.asList(cpuCardOne, cpuCardTwo, cpuCardThree, cpuCardFour, cpuCardFive));
			checkboxes.addAll(Arrays.asList(checkBox, checkBox_1, checkBox_2, checkBox_3, checkBox_4));
			defaultCard.setIcon(new ImageIcon(defaultimage));
			
			for (int i = 0; i < cpuimages.size(); i++) {
				cpuimages.get(i).setIcon(new ImageIcon(defaultimage));
				playerimages.get(i).setIcon(new ImageIcon(defaultimage));
			}
			int round = 1;
			btnDrawCards.addActionListener(new ActionListener() {
		            public void actionPerformed(ActionEvent e)
		            {
		            	button.setVisible(true);
		            	txtrYouLost.setVisible(false);
		        		txtrYouWon.setVisible(false);
		            	for (int i = 0; i < cpuimages.size(); i++) {
		    				cpuimages.get(i).setIcon(new ImageIcon(defaultimage));
		    			}
		            	dealHand playerHand = new dealHand();
		        		dealHand playerHandFinal = new dealHand();
		        		Vector<card> cpuHandFinal = new Vector<card>();
		        		Vector<card> fullDeck = new Vector<card>();
		        		
		            	deck theDeck = new deck();
		            
		    			fullDeck = theDeck.generateDeck();
		    			// generate the deck and prepare to deal a hand.
		    			playerHand.dealPlayers(fullDeck);
		    			Collections.sort(playerHand.getHandDealt());
		    			System.out.println("your hand: "+playerHand.getHandDealt());
		    			playerHand.handValue();
		    			
		    			Collections.sort(playerHand.getHandValueSpecific());
		    			
		    			
		    			//System.out.println("\n");
		            	
		    			System.out.println(playerHand.getHandDealt());
		    			for (int i = 0; i < playerimages.size(); i++) {
		    					playerimages.get(i).setIcon(new ImageIcon(playerHand.getHandDealt().get(i).getImg()));
		    				}
		    	
		            	playersCards.addAll(playerHand.getHandDealt());
		            	textArea.setText((playerHand.getHandName()));
		            }
		        }); 
			
			button.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) 
				{
				
					Vector<card> deckremaining = new Vector<card>();
					deck decknew = new deck();
					dealHand playerscardsh = new dealHand();
					dealHand cpuFinalDeal = new dealHand();
					deckremaining = decknew.generateDeck();
					Vector<card> cardstoRemove = new Vector<card>();
					Vector<card> cpuHandFinal = new Vector<card>();
					deckremaining.remove(playersCards);
					for (int i = 0; i < deckremaining.size(); i++) 
					{
						for (int j = 0; j < playersCards.size(); j++) 
						{
							if(playersCards.get(j).getName().equals(deckremaining.get(i).getName()))
							{
								deckremaining.remove(i);
								if(i>0)
								{
								i = i-1;
								}
							}
						}
					}
					for (int i = 0; i < playerimages.size(); i++) 
					{
						
					}
					//your almost ready to get the checkboxes add them to cardxs remaining and plug it into playerdraw
					
					 for (int i = 0; i < checkboxes.size(); i++) 
		        	{
						if(checkboxes.get(i).isSelected())
						{
						cardstoRemove.addElement(playersCards.get(i));
						}
					}
					 for (int i = 0; i < playersCards.size(); i++) {
						 playerscardsh.getHandDealt().add(playersCards.get(i));
					}
					 
					
					 System.out.println(playerscardsh.getHandDealt());
					
					
					playerscardsh.playerDraw(deckremaining, playerscardsh.getHandDealt(), cardstoRemove);
					System.out.println(playerscardsh.getHandDealt());
					
					for (int i = 0; i < playerimages.size(); i++) {
    					playerimages.get(i).setIcon(new ImageIcon(playerscardsh.getHandDealt().get(i).getImg()));
    				}
					
					playerscardsh.handValue();
					
					textArea.setText((playerscardsh.getHandName()));
					dealHand cpuHand = new dealHand();
					
					cpuHand.dealPlayers(deckremaining);
					cpuHand.handValue();
				   
					Collections.sort(cpuHand.getHandValueSpecific());
					System.out.println("this is the players hand value at end: "+ playerscardsh.getHandValue());
					System.out.println("this is cpuhand.gethanddealt before draw "+cpuHand.getHandDealt());
					System.out.println("this is cpuhand's value before drawing"+cpuHand.getHandValue());
					cpuHand.cpuDraw(deckremaining, cpuHand.getHandDealt(), cpuHand, cpuHand.getRemainingCards(), cpuHandFinal);
					if(cpuHandFinal.size()==0)
					{
						cpuHandFinal.addAll(cpuHand.getHandDealt());
					}
					cpuFinalDeal.handUpdate(cpuFinalDeal, cpuHandFinal);
					System.out.println("this is cpuhand.gethanddealt after draw: "+cpuFinalDeal.getHandDealt());
					cpuFinalDeal.handValue();
					System.out.println("this is cpuhand's value after drawing"+cpuFinalDeal.getHandValue());
					
					cpuHand.compare(playerscardsh, cpuFinalDeal);
					System.out.println("this is CPUhandFinal"+ cpuHandFinal);
					for (int i = 0; i < cpuimages.size(); i++) {
						if(cpuHandFinal.size()>0)
						{
							cpuimages.get(i).setIcon(new ImageIcon(cpuFinalDeal.getHandDealt().get(i).getImg()));
						}
						else if(cpuHandFinal.size()==0)
						{
							cpuimages.get(i).setIcon(new ImageIcon(cpuFinalDeal.getHandDealt().get(i).getImg()));
						}
    				}
				
					if(cpuFinalDeal.isWinningHand() == true)
					{
						txtrYouLost.setVisible(true);
						button.setVisible(false);
					}
					else if (cpuFinalDeal.isWinningHand() == false) 
					{
						txtrYouWon.setVisible(true);
						button.setVisible(false);
					}
					deckremaining.removeAllElements();
					playersCards.removeAllElements();
					playerscardsh.getHandDealt().removeAllElements();
					cpuHand.getHandDealt().removeAllElements();
					cpuHandFinal.removeAllElements();
					cardstoRemove.removeAllElements();
				}
					
				
			});
			
//			
			// this is where you compare the two playerHand.compare(playerHand, cpuHand);
			
			
		
			} while (continueplay == true);
			//Collections.sort(cpuHand.getRemainingCards());
			//System.out.println(cpuHand.getRemainingCards());
			// deal in the player and
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}
}
