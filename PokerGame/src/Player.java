/**
 * Created by Carter on 5/30/2016.
 */
public class Player {

    public PokerHand hand;
    public String playerName;

    public Player(String name, PokerHand hand){
        playerName = name;
        this.hand = hand;
    }

    public Player(String name){
        playerName = name;
        hand = new PokerHand();
    }
}