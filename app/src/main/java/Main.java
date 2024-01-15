import jp.ac.uryukyu.ie.e235755.*;

public class Main {
    public static void main(String[] args){
        Card card = new Card();
        card.dealCards();
        card.point(card.playerCards);
    }
}
