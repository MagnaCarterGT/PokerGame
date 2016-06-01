import java.util.ArrayList;

/**
 * Created by Carter on 5/31/2016.
 */
public class TestPokerRound {

    public static void main(String[] args){
        //PokerRound testRound = new PokerRound();

        /*Card[] testCards = new Card[5];
        Card cardOne = new Card(CardValue.EIGHT, "Spades");
        Card cardTwo = new Card(CardValue.TWO, "Clubs");
        Card cardThree = new Card(CardValue.KING, "Diamonds");
        Card cardFour = new Card(CardValue.KING, "Spades");
        Card cardFive = new Card(CardValue.FIVE, "Hearts");

        Card six = new Card(CardValue.EIGHT, "Spades");
        Card seven = new Card(CardValue.EIGHT, "Clubs");
        Card eight = new Card(CardValue.KING, "Diamonds");
        Card nine = new Card(CardValue.KING, "Spades");
        Card ten = new Card(CardValue.EIGHT, "Hearts");

        Card eleven = new Card(CardValue.NINE, "Spades");
        Card twelve = new Card(CardValue.NINE, "Clubs");
        Card thirteen = new Card(CardValue.NINE, "Diamonds");
        Card fourteen = new Card(CardValue.KING, "Spades");
        Card fifteen = new Card(CardValue.NINE, "Hearts");

        PokerHand testHand = new PokerHand(cardOne, cardTwo, cardThree, cardFour, cardFive);
        PokerHand handTwo = new PokerHand(six, seven, eight, nine, ten);
        PokerHand handThree = new PokerHand(eleven,twelve,thirteen,fourteen,fifteen);

        Player steve = new Player("Steve", testHand);
        Player dan = new Player("Dan", handTwo);
        Player bob = new Player("Bob", handThree);

        ArrayList<Player> thisList = new ArrayList<Player>();
        thisList.add(steve);
        thisList.add(bob);
        thisList.add(dan);*/

        ArrayList<Player> thisList = new ArrayList<Player>();
        thisList.add(new Player("Steve"));
        thisList.add(new Player("Bob"));
        thisList.add(new Player("Dan"));
        thisList.add(new Player("Mike"));

        PokerRound testRound = new PokerRound(thisList);

        testRound.deal();

        System.out.println(testRound.toString());

        System.out.println(testRound.announceWinner());
    }
}
