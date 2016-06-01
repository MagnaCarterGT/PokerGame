/**
 * Created by ctemplet on 5/27/2016.
 */
public class PokerHand {

    public Card[] cards;
    public int rating = 0; //default; will remain zero if cards is just high card

    /**
     * TODO: Code Sorting algorithm
     */

    /*
        RATINGS:
        CODED: Royal flush: 9
        CODED: Straight flush: 8
        CODED: 4 of a kind: 7
        CODED: Full house: 6
        CODED: Flush: 5
        CODED: Straight: 4
        CODED: 3 of a kind: 3
        CODED:Two pair: 2
        CODED: One pair: 1
     */

    public PokerHand(Card c1, Card c2, Card c3, Card c4, Card c5){
        cards = new Card[5];
        cards[0] = c1;
        cards[1] = c2;
        cards[2] = c3;
        cards[3] = c4;
        cards[4] = c5;
    }

    public PokerHand(){
        cards = new Card[5];
    }

    /**
     * todo: Sort the cards by value
     */
    public void sortCards(){
        Card tempCard;
        int maxIndex;

        for(int i = 0; i<5; i++){
            maxIndex = i;
            for(int j = i; j<5; j++){
                if(cards[maxIndex].rank.value<cards[j].rank.value) maxIndex = j;
            }
            tempCard = cards[maxIndex];
            cards[maxIndex] = cards[i];
            cards[i] = tempCard;
        }
    }

    public String toString(){
        String handString = "";
        for (int i = 0; i<5; i++){
            handString = handString + cards[i].toString();
        }
        return handString;
    }

    public int pairIndex(){
        for(int i = 0; i<4; i++){
            if(cards[i].rank.value == cards[i+1].rank.value) return i;
        }
        return -1;
    }

    public boolean hasTwoPair(int index){
        if(index<3) {
            for (int i = index + 2; i < 4; i++) {
                if ((cards[i].rank.value == cards[i + 1].rank.value &&
                        cards[index].rank.value != cards[i].rank.value)) return true;
                //we also want to check the two pairs aren't both the same value; that's four of a kind
            }
        }
        return false;
    }

    /**
     * Note: this will evaluate false if the cards are:  a a b b b
     *
     * But that's a full house, which will have already been checked for at this point.
     * So it's fine.
     */
    public boolean threeOfAKind(int index){
        if (index < 3) return cards[index].rank.value == cards[index+2].rank.value;
        else return false;
    }

    /**
     * Full house is called only after we've determined there are two pairs.
     *
     * At that point, the only possible card orders are the following:
     * a a b b x
     * a a x b b
     * x a a b b
     *
     * So all we have to do at this point is make sure the middle card
     * is the same as either the first or the last card.
     */
    public boolean hasFullHouse(){
        return ((cards[2].rank.value == cards[0].rank.value) || (cards[2].rank.value == cards[4].rank.value));
    }

    public boolean fourOfAKind(int index){
        if (index <2) return cards[index].rank.value == cards[index+3].rank.value;
        else return false;
    }

    public boolean isFlush(){
        boolean yesFlush = true;
        char matchCard = cards[0].suit;
        for(int i=1; i<5; i++){
            if(cards[i].suit != matchCard) return false;
        }
        return yesFlush;
    }

    public boolean isStraight(){
        boolean yesStraight = true;
        //first check special case A-2-3-4-5
        if(cards[0].rank.value == 14 && cards[4].rank.value == 2 && cards[3].rank.value == 3
                && cards[2].rank.value == 4 && cards[1].rank.value == 5) return true;
        else{
            for (int i = 0; i<4; i++){
                if (!(cards[i].rank.value == cards[i+1].rank.value+1)) yesStraight = false;
            }
        }
        return yesStraight;
    }

    public boolean isRoyalFlush(){ //the edgiest of edge cases, poker-wise
        return cards[0].rank.value == 14 && cards[1].rank.value == 13;
        //this is all we have to do b/c at this point we've determined hand is a straight flush
    }
}