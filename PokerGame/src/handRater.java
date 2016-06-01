/**
 * Created by ctemplet on 5/27/2016.
 */
public class handRater {

    public handRater(){}

    public int handRating(PokerHand hand){

        int tiebreaker = 0;
        int rating = 0;

        hand.sortCards(); //to make life way way easier.

        int pairIndex = hand.pairIndex();

        /**
         * first check if the hand has a pair.
         * if it does, check for 2 pair, 3 of a kind, 4 of a kind, full house - since all these require at least a pair.
         * if not, check for straights and flushes - these require the hand to NOT have a pair.
         * the second path will also take you to the worst rated hand - a simple high card.
         */
        if (pairIndex >=0){
            rating = 100;

            tiebreaker = hand.cards[pairIndex].rank.value;
            //in 2, 3, and 4 of a kind, the pair/trips/quads card breaks the tie.
            //in 2 pair, the highest pair breaks, but we'll always reach that one first, so no extra logic is necessary
            if(hand.hasTwoPair(pairIndex)){
                if (hand.hasFullHouse()) return 600 + hand.cards[2].rank.value;
                /* in a Full House, the trips card breaks the tie. since a full house can only be
                    'a a b b b' or 'a a a b b', just check the middle card to find the tiebreaker. */
                else rating = 200;
            }
            else if (hand.threeOfAKind(pairIndex)){
                if(hand.fourOfAKind(pairIndex)) rating = 700;
                else rating = 300;
            }
        }
        else{
            tiebreaker = hand.cards[0].rank.value;
            //in a straight or a flush, the high card breaks the tie
            if (hand.isStraight()) {
                if(hand.isFlush()){
                    if (hand.isRoyalFlush()) return 900;//no tiebreaker; the royal flush is the best possible hand
                    else rating = 800;
                }
                else rating = 400;
            }
            else if (hand.isFlush()) rating = 500;
        }
        return rating + tiebreaker;
    }
}