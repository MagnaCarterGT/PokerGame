import java.util.Random;

/**
 * Created by Carter on 5/31/2016.
 */
public class Dealer {

    Random selectRank;
    Random selectSuit;

    public Dealer(){
        selectRank = new Random();
        selectSuit = new Random();
    }

    public Card dealCard(){
        String suit;
        CardValue cardRank;
        
        int rankInt = selectRank.nextInt(13) + 2;
        int suitInt = selectSuit.nextInt(4);

        switch(suitInt){
            case 0: suit = "S";//"♠";
                break;
            case 1: suit = "H";//"♥";
                break;
            case 2: suit = "D";//"♦";
                break;
            case 3: suit = "C";//"♣";
                break;
            default: suit = "S";//"♠";
                break;
        }

        switch(rankInt){
            case 2: cardRank = CardValue.TWO;
                break;
            case 3: cardRank = CardValue.THREE;
                break;
            case 4: cardRank = CardValue.FOUR;
                break;
            case 5: cardRank = CardValue.FIVE;
                break;
            case 6: cardRank = CardValue.SIX;
                break;
            case 7: cardRank = CardValue.SEVEN;
                break;
            case 8: cardRank = CardValue.EIGHT;
                break;
            case 9: cardRank = CardValue.NINE;
                break;
            case 10: cardRank = CardValue.TEN;
                break;
            case 11: cardRank = CardValue.JACK;
                break;
            case 12: cardRank = CardValue.QUEEN;
                break;
            case 13: cardRank = CardValue.KING;
                break;
            case 14: cardRank = CardValue.ACE;
                break;
            default: cardRank = CardValue.TWO;
                break;
        }

        return new Card(cardRank, suit);
    }
}