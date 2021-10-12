/*
Name: Celine Ratulowski
Date: 03/25/2021
Description: Creates various methods that can be used when playing a card game
Sources Cited: Our class' video lecture
*/


package cardGame;

import java.util.Random;

public class Deck {
	Random r = new Random();
	private Card[] deck = new Card[52]; //creates an array and names it deck
	private int top;
	
	public Deck()
	{
		//Card[] deck = new Card[52];
		int clubRank = 2;
		int diamondRank = 2;
		int spadeRank = 2;
		int heartRank = 2;
		//starts ranks of each suite at 2
		
		for (int x = 0; x < deck.length; x++ ) { //for each card in the array
			
			if(x< 13) {	 //the first quarter of the deck are clubs
				deck[x] = new Card(clubRank, 'C');
				clubRank++; }
			
			else if( x >= 13 && x < 26) { //the second quarter of the deck are diamonds
				deck[x] = new Card(diamondRank, 'D');
				diamondRank++; 
			}
			
			else if(x >= 26 && x < 39) { //the third quarter of the deck are spades
				deck[x] = new Card(spadeRank, 'S');
				spadeRank++; 
			}
			
			else if (x >= 39) { //the last quarter of the deck are hearts
				deck[x] = new Card(heartRank, 'H');
				heartRank++ ;
			}
		}
	}
	
	public void shuffle()
	{
		for(int size = 0; size < 110; size++) {
			int i = r.nextInt(51);
			int j = r.nextInt(51);
			swap(i,j); //uses the swap method to swap all card sin the deck
		}
			
	}
	
	public Card draw()
	{
		Card draw = deck[top];
		top++;   //takes the top card and assigns a new value as top
		return draw;
	}
	
	public boolean isEmpty()
	{
		if (top == 52)
			return true;  //returns true if no more cards in deck 
		else;
			return false;
	}
	
	private void swap(int i, int j) 
	{
		Card holder = deck[i];
		deck[i] = deck[j];
		deck[j] = holder; //swaps 2 cards
	}
	
}