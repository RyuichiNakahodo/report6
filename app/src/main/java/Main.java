import jp.ac.uryukyu.ie.e235755.*;


public class Main {
    public static void main(String[] args){
        Card card1 = new Card();
        Player player = new Player(500);
        Judge judge = new Judge(); 
        CommandSelector command = new CommandSelector();

        command.startCommand();
        player.playerName();
        player.bet();
        card1.dealCards();
        player.playerDrawCard(card1);
        
        //System.out.println("usedIndex:"+card1.usedIndex);             //テスト
        judge.judge(card1,player);
        //System.out.println("bankroll:"+player.bankroll);
        command.continueCommand();
    }
}
