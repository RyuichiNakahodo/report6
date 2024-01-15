package jp.ac.uryukyu.ie.e235755;
import java.util.ArrayList;


public class Card {

    String[] suits = {"\u2665","\u2666","\u2663","\u2660"}; //ハート、ダイヤ、クラブ、スペード
    String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
    ArrayList<String> cards = new ArrayList<>();
    ArrayList<String> playerCards = new ArrayList<>();
    ArrayList<String> dealerCards = new ArrayList<>();

    //２枚ずつ配るメソッド
    public void dealCards(){
        for (String suit : suits){
            for (String rank : ranks){
                cards.add(suit+rank);
            }
        }
        ArrayList<Integer> usedIndex = new ArrayList<>();
        for (int i = 0; i < 2; i++){
            int rand = new java.util.Random().nextInt(52);
            if (usedIndex.contains(rand)){                           //要テスト
                i--;
                continue;
            }
            playerCards.add(cards.get(rand));
        }
        for (int i = 0; i < 2; i++){
            int rand = new java.util.Random().nextInt(52);
            if (usedIndex.contains(rand)){
                i--;
                continue;
            }
            dealerCards.add(cards.get(rand));
        }
        System.out.println("dealer:"+playerCards);
        System.out.println("player:"+dealerCards);
    }

    
}
