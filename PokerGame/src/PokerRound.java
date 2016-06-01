import java.util.ArrayList;
import java.util.Collections;
import java.util.Set;
import java.util.HashSet;

/**
 * Created by Carter on 5/30/2016.
 */
public class PokerRound {

    public Set<Card> cardsDealt = new HashSet<Card>();
    public ArrayList<Player> players;
    public ArrayList<Integer> results;
    public handEvaluator evaluator;
    public Dealer dealer = new Dealer();

    public PokerRound(ArrayList<Player> list){
        players = list;
        evaluator = new handEvaluator();
    }

    public void deal(){
        for (int i = 0; i<5; i++){
            for (Player p : players){
                Card dealtCard = dealer.dealCard();
                while(cardsDealt.contains(dealtCard)){ //make sure this card hasn't already been dealt
                    System.out.println("MULT! " + dealtCard.toString());
                    dealtCard = dealer.dealCard();
                }
                cardsDealt.add(dealtCard);
                p.hand.cards[i] = dealtCard;
            }
        } //programmatically, this isn't the most efficient, but it's how cards are actually dealt.
    }

    public String toString(){
        String returnString = "The hands in this round are:\n";
        for(Player p: players){
            p.hand.sortCards(); //the hands will be displayed as they were dealt. we can pre-sort them for viewability by uncommenting this
            returnString = returnString + p.playerName + ":\t" + p.hand.toString() + "\n";
        }
        return returnString;
    }

    public String announceWinner(){
        results = new ArrayList<Integer>();
        for (Player p : players){
            results.add(evaluator.handRating(p.hand));
        }
        Integer highestRating = Collections.max(results);
        int winner = results.indexOf(highestRating);
        Player winningPlayer = players.get(winner);

        return "This round's winner is " + winningPlayer.playerName +
                ", who won with " + winningPlayer.hand.toString();
    }
}