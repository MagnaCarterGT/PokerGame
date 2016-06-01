/**
 * Created by ctemplet on 5/27/2016.
 */
public class Card {

    public CardValue rank;
    public String suit;

    public Card (CardValue rank, String suit){
        this.rank = rank;
        this.suit = suit;
    }
    
    public String toString(){
        String cardString = "";

        if(rank.value == 14) cardString = cardString + "A";
        else if(rank.value == 13) cardString = cardString + "K";
        else if(rank.value == 12) cardString = cardString + "Q";
        else if(rank.value == 11) cardString = cardString + "J";
        else if(rank.value == 10) cardString = cardString + "T"; //convert "10" to one char for readability
        else cardString = cardString + rank.value;

        cardString = cardString + suit + " ";
        return cardString;
    }

    /**
     * We're sticking the list of dealt cards in a Hash Set because we don't want any duplicates.
     *
     * Because of this we need to override hashCode() and equals().
     */
    public int hashCode(){
        return rank.value + (int)suit.charAt(0);
    }

    public boolean equals(Object o){
        Card compare = (Card)o;
        return rank.equals(compare.rank) && suit.equals(compare.suit);
    }
}