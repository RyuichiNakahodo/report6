package jp.ac.uryukyu.ie.e235755;

public class Dealer {
    private Card card;
    private Player player;

    public Dealer(Card card,Player player){
        this.card = card;
        this.player = player;
    }
    //カード引くメソッド
    public void dealerDrawCard(){
        while (card.point(card.getDealerCards()) < 17){
            card.drawCard(card.getDealerCards());
        }
        System.out.println("dealer:"+card.getDealerCards());
        System.out.println(player.getName()+":"+card.getPlayerCards());
        System.out.println();
        System.out.println();
    }
}
