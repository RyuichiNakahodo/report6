package jp.ac.uryukyu.ie.e235755;
import java.util.ArrayList;

/**
 * カードに関連する機能をまとめたクラス
 */
public class Card {
    private ArrayList<String> cards = new ArrayList<>();
    private ArrayList<String> playerCards = new ArrayList<>();
    private ArrayList<String> dealerCards = new ArrayList<>();
    private ArrayList<Integer> usedIndex = new ArrayList<>();
    
    /**
     * プレイヤーの手札のリストを取得するメソッド
     * @return プレイヤーの手札のリスト
     */
    public ArrayList<String> getPlayerCards(){
        return playerCards;
    }

    /**
     * ディーラーの手札のリストを取得するメソッド
     * @return ディーラーの手札のリスト
     */
    public ArrayList<String> getDealerCards(){
        return dealerCards;
    }

    /**
     * 使用済みカードのインデックスのリストを取得するメソッド
     * @return 使用済みカードのインデックスをまとめたリスト
     */
    public ArrayList<Integer> getUsedIndex(){
        return usedIndex;
    }
    
    
    /**
     * プレイヤー、ディーラーそれぞれにカードを２枚ずつ配るメソッド
     */
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
            if (usedIndex.contains(rand)){                           
                i--;
                continue;
            }
            dealerCards.add(cards.get(rand));
            usedIndex.add(rand);
        }
        //playerに2枚配る
        for (int i = 0; i < 2; i++){
            int rand = new java.util.Random().nextInt(52);
            if (usedIndex.contains(rand)){
                i--;
                continue;
            }
            playerCards.add(cards.get(rand));
            usedIndex.add(rand);

        }
        
    }

    /**
     * 手札の合計値を求めるメソッド
     * @param hands 手札
     * @return 手札の合計値
     */
    public int point(ArrayList<String> hands){
        ArrayList<Integer> indexList = new ArrayList<>();
        for (String hand : hands){
            int index = cards.indexOf(hand);  //カードのindexを取得
            indexList.add(index);
        }
        //indexListを使って、カードの合計値を求める
        int sumPoint = 0;
        int cntA = 0; 
        for (int index: indexList){
            int i = index % 13;
            switch (i+1){
              case 1:
                cntA += 1;
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
        //Aが1か11か          
        if (cntA > 0){                       
            int[][] list = {{1,11},{2,12},{3,14},{4,15}};
            if (sumPoint + list[cntA-1][0] > 21){
                sumPoint += list[cntA-1][0];
            }else if (sumPoint + list[cntA-1][0] <= 21 && sumPoint +list[cntA-1][1] > 21){
                sumPoint += list[cntA-1][0];
            }else if (sumPoint + list[cntA-1][1] <= 21){
                sumPoint += list[cntA-1][1];
            }
        }
        return sumPoint;
    }
    /**
     * 1枚のカードを引くメソッド
     * @param someoneCards １枚のカードを引く人の手札
     */
    public void drawCard(ArrayList<String> someoneCards){
        for (int i = 0; i < 1; i++){
            int rand = new java.util.Random().nextInt(52);
            if (usedIndex.contains(rand)){                      
                i--;                                                      
                continue;                                                 
            }                                                             
            someoneCards.add(cards.get(rand));
            usedIndex.add(rand);
        }
    }

    /**
     * 手札、使用済みカードの情報をリセットするメソッド
     */
    public void cleanCards(){
        playerCards.clear();
        dealerCards.clear();
        usedIndex.clear(); 
    }
    
}
