package jp.ac.uryukyu.ie.e235755;

public class GameMaster {
    private Card card;
    private Player player;
    private Dealer dealer;
    private Judge judge;
    private CommandSelector command;

    public void gameMaster(){
        card = new Card();
        player = new Player(card,500);
        command = new CommandSelector(player);
        dealer = new Dealer(card,player);
        judge = new Judge(card,player);
        
        
        command.startCommand();
        player.playerName();
        do{
            card.cleanCards();
            player.bet();
            card.dealCards();
            player.showHands();
            player.playerDrawCard();
            dealer.dealerDrawCard();
            judge.judge();
            command.continueCommand();
        }while (command.getRoop());
        
    }
}
