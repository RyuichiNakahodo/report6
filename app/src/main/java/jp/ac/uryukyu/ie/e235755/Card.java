package jp.ac.uryukyu.ie.e235755;
import java.util.ArrayList;


public class Card {

    ArrayList<String> cards = new ArrayList<>();
    public ArrayList<String> playerCards = new ArrayList<>();
    public ArrayList<String> dealerCards = new ArrayList<>();
    ArrayList<Integer> usedIndex = new ArrayList<>();

    //２枚ずつ配るメソッド
    public void dealCards(){
        String[] suits = {"\u2665","\u2666","\u2663","\u2660"}; //ハート、ダイヤ、クラブ、スペード
        String[] ranks = {"A","2","3","4","5","6","7","8","9","10","J","Q","K"};
        //全種類のカードをcardsに入れる
        for (String suit : suits){
            for (String rank : ranks){
                cards.add(suit+rank);
            }
        }
        //dealerに2枚配る
        for (int i = 0; i < 2; i++){
            int rand = new java.util.Random().nextInt(52);
            if (usedIndex.contains(rand)){                           //要テスト
                i--;
                continue;
            }
            dealerCards.add(cards.get(rand));
        }
        //playerに2枚配る
        for (int i = 0; i < 2; i++){
            int rand = new java.util.Random().nextInt(52);
            if (usedIndex.contains(rand)){
                i--;
                continue;
            }
            playerCards.add(cards.get(rand));
        }
        System.out.println("dealer:"+dealerCards);
        System.out.println("player:"+playerCards);
    }

    //カードの合計値
    public void point(ArrayList<String> hands){
        ArrayList<Integer> indexList = new ArrayList<>();
        for (String hand : hands){
            int index = cards.indexOf(hand);  //カードのindexを取得
            indexList.add(index);
        }
        //indexListを使って、カードの合計値を求める
        int sumPoint = 0;
        for (int index: indexList){
            int i = index % 13;
            switch (i+1){
              case 1:
                System.out.println("1or11");     //後でやる
                break;
              case 11:
              case 12:
              case 13:
                sumPoint += 10;
                break;
              default:
                sumPoint += (i+1);
                break;
            }
        }
        System.out.println(sumPoint);
    }
}
