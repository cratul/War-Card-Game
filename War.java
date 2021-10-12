/*
Name: Celine Ratulowski
Date: 03/25/2021
Description: Uses the Deck and Card to carry out a game of War between a person and the computer.
Sources Cited: Our class' video lecture
*/

package cardGame;

import java.io.IOException;




public class War {
	
	public static void promptEnterKey(){
		try {
		System.in.read(new byte[2]);
		}
		catch (IOException e) {
		e.printStackTrace();
		}
		}

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int playerPoints = 0;
		int opponentPoints = 0; 
		
		int playerRank1 = 0;
		int opponentRank1 = 0;
		int playerRank2 = 0;
		int opponentRank2 = 0;
		int playerRank3 = 0;
		int opponentRank3 = 0;
		//creates a bunch of variables to keep track of points and rounds
		
		Deck d = new Deck(); //initializes a deck
		System.out.println("The deck is being shuffled...");
		
		d.shuffle(); //shuffles deck
		
		System.out.println("The Deck has been shuffled.");
		
		while(!(d.isEmpty())) { //while the deck is empty, play the game
			System.out.println("Press ENTER to draw a card.");
			promptEnterKey();
			Card a = d.draw(); //draw from deck and makes it a card
			playerRank1 = a.getRank(); //notes the rank of the card
			System.out.println("Here is your card: " + a.getSuit() + ", " + a.getRank());
			
			System.out.println("Your apponent is now drawing a card...");
			Card b = d.draw(); //draws opponent's (computer's) card
			opponentRank1 = b.getRank();
			System.out.println("Your opponents card is: " + b.getSuit() + ", " + b.getRank());
		
			
			//assigns points to whoever wins this round
			if(playerRank1 > opponentRank1) {
				playerPoints++;
				System.out.println("You win this round. The current score is You: " + playerPoints + " Opponent: " + opponentPoints );
			}
			else if(opponentRank1 > playerRank1) {
				opponentPoints++;
				System.out.println("Your opponent wins this round. The current score is You: " + playerPoints + " Opponent: " + opponentPoints);
			}
			//if their first cards have the same rank, they each draw 2 more cards
			else if (opponentRank1 == playerRank1) {
				System.out.println("Your cards tied. Press ENTER to draw another card.");
				promptEnterKey();
				Card c = d.draw();
				playerRank2 = c.getRank();
				System.out.println("Your next card is: " + c.getSuit() + ", " + c.getRank());
				System.out.println("Press ENTER to draw your last card.");
				promptEnterKey();
				Card e = d.draw();
				playerRank3 = e.getRank();
				System.out.println("Your final card is: " + e.getSuit() + ", " + e.getRank());

				System.out.println("Your opponent is now drawing their 2 cards...");
				Card f = d.draw();
				opponentRank2 = f.getRank();
				System.out.println("Your opponent's card is: " + f.getSuit() + ", " + f.getRank());
				Card g = d.draw();
				opponentRank3 = g.getRank();
				System.out.println("Your opponent's last card is: " + g.getSuit() + ", " + g.getRank());
				
				//assigns points to whoever wins 
				if(playerRank2 > opponentRank2) {
					playerPoints = playerPoints + 3;
					System.out.println("You win this round. The current score is You: " + playerPoints + " Opponent: " + opponentPoints);
				}
				else if (playerRank2 < opponentRank2) {
					opponentPoints =opponentPoints + 3;
					System.out.println("Your opponent wins this round. The current score is You: " + playerPoints + " Opponent: " + opponentPoints);
			}
				//if the 2nd cards also tie, the third cards will be compared
				else if (playerRank2 == opponentRank2) {
					System.out.println("Your cards tied. You and the opponent will now compare your third cards.");
					
					//points will be assined
					if (playerRank3 > opponentRank3) {
						playerPoints = playerPoints + 3;
						System.out.println("You win this round. The current score is You: " + playerPoints + " Opponent: " + opponentPoints);
					}
					else if (opponentRank3>playerRank3) {
						opponentPoints = opponentPoints + 3;
						System.out.println("Your opponent wins this round. The current score is You: " + playerPoints + " Opponent: " + opponentPoints);
					}
					//if they tie again, no one gets points and then they continue playing
					else if (opponentRank3 == playerRank3) {
						System.out.println("Stalemate! No one wins this round. The score remains the same. You: " + playerPoints + " Opponent: " + opponentPoints);
					}
				}
					
				
				
				
		}


	}	
		//after the deck runs out, the winner is announced based on how many points they have
		if (playerPoints > opponentPoints)
			System.out.println("You Win!");
		else if (playerPoints < opponentPoints)
			System.out.println("Your Opponent Wins!");
		else if (playerPoints == opponentPoints)
			System.out.println("You And Your Opponent Tie!");
	}
}
 


