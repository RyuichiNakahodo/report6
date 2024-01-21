package jp.ac.uryukyu.ie.e235755;

public class Judge {
    Card card;
    Player player;

    //勝敗判定
    public void judge(Card card,Player player){
        int dealerPoint = card.point(card.dealerCards);
        int playerPoint = card.point(card.playerCards);
        System.out.println("dealerPoint:"+dealerPoint);   //テスト
        System.out.println("playerPoint:"+playerPoint);   //テスト
        if (playerPoint > 21){
            player.lose();
        }else if (playerPoint == 21){
            if (dealerPoint == 21){
                player.push();
            }else{
                if (card.playerCards.size() == 2){
                    player.winBlackJack();
                }else{
                    player.win();
                }
                
            }
        }else{
            if (dealerPoint > 21){
                player.win();
            }else if (21-dealerPoint < 21-playerPoint){
                player.lose();
            }else if (21-dealerPoint == 21-playerPoint){
                player.push();
            }else{
                player.win();
            }      
        } 
    }
}
