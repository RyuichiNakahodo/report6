package jp.ac.uryukyu.ie.e235755;
/**
 * 勝敗判定を実装したクラス
 */
public class Judge {
    private Card card;
    private Player player;

    public Judge(Card card,Player player){
        this.card = card;
        this.player = player;
    }

    /**
     * 勝敗判定するメソッド
     */
    public void judge(){
        int dealerPoint = card.point(card.getDealerCards());
        int playerPoint = card.point(card.getPlayerCards());
        System.out.println("dealerPoint:"+dealerPoint);
        System.out.println(player.getName()+"Point:"+playerPoint);

        
        if (playerPoint > 21){
            player.lose();
        }else if (playerPoint == 21){
            if (dealerPoint == 21){
                player.push();
            }else{
                if (card.getPlayerCards().size() == 2){
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
        dealerPoint = 0;
        playerPoint = 0;
    }
}
