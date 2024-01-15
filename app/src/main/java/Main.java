import jp.ac.uryukyu.ie.e235755.*;

public class Main {
    public static void main(String[] args){
        Card card = new Card();
        card.dealCards();
        int i = card.point(card.dealerCards);
        int j = card.point(card.playerCards);
        System.out.println("dealer:"+i+" "+"player:"+j);

        card.judge(i,j);
    }
}
