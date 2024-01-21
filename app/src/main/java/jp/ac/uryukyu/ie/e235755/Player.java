package jp.ac.uryukyu.ie.e235755;
import java.util.Scanner;

public class Player {
    Card card;
    CommandSelector command;
    public int bankroll;
    public int bet;
    private String name;
    Scanner scanner = new Scanner(System.in);

    public Player(int bankroll){
        this.card = new Card();
        this.command = new CommandSelector();
        this.bankroll = bankroll;
    }

    //名前聞くメソッド
    public void playerName(){
        System.out.println("Put your name.");
        for (int i=0;i<4;i++){
            System.out.println();
        }
        System.out.print("> ");
        name = scanner.nextLine();

    }

    //賭けメソッド
    public void bet(){
        System.out.println("----------------------------------");
        System.out.println("Place your bet."+"     "+"Bankroll:"+bankroll+"$");
        for (int i=0;i<4;i++){
            System.out.println();
        }
        System.out.print("> ");
        bet = scanner.nextInt();
        if (bet > bankroll){
            System.out.println("----------------------------------");
            System.out.println("Bet exceeds your bankroll"); 
            bet();
        }
        System.out.println("----------------------------------");
        System.out.println("Good luck!");
        System.out.println("----------------------------------");
    }
    //敗北メソッド
    public void lose(){
        System.out.println("----------------------------------");
        System.out.println("YOU LOSE"+"                    "+"-"+bet+"$");
        System.out.println();
        bankroll -= bet;
        if (bankroll == 0){
            command.noBankrollCommand();
        }
        bet = 0;
    }
    //勝利メソッド
    public void win(){
        System.out.println("----------------------------------");
        System.out.println("YOU WIN!"+"                    "+"+"+bet*2+"$");
        System.out.println();
        bankroll += (bet*2);
        bet = 0;
    }
    //ブラックジャック勝利メソッド                    
    public void winBlackJack(){
        System.out.println("----------------------------------");
        System.out.println("BLACK JACK!!"+"                "+"+"+bet*3+"$");
        System.out.println();
        bankroll += (bet*3);
        bet = 0;
    }
    //引き分けメソッド
    public void push(){
        System.out.println("----------------------------------");
        System.out.println("PUSH"+"                        "+"\u00B1"+"0$");
        bet = 0;
    }

    //カード引くメソッド
    public void playerDrawCard(Card card){
        while (command.hitStandCommand()){
            card.drawCard(card.playerCards);
            System.out.println("player:"+card.playerCards);
        }
        System.out.println("dealer:"+card.dealerCards);
        System.out.println(name+":"+card.playerCards);
        for (int i=0;i<2;i++){
            System.out.println();
        }
        
    }
}
