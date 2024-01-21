package jp.ac.uryukyu.ie.e235755;
import java.util.Scanner;

public class Player {
    private Card card;
    private CommandSelector command;
    private int bankroll;
    private int bet;
    private String name;
    private Scanner scanner = new Scanner(System.in);

    public Player(Card card,int bankroll){
        this.card = card;
        this.command = new CommandSelector(this);
        this.bankroll = bankroll;
    }

    public int getBankroll(){
        return bankroll;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }


    //名前聞くメソッド
    public void playerName(){
        System.out.println("Put your name.");
        for (int i=0;i<4;i++){
            System.out.println();
        }
        System.out.print("> ");
        name = scanner.nextLine();
        setName(name);
    }

    //最初の２枚を表示するメソッド
    public void showHands(){
        System.out.println("----------------------------------");
        System.out.println("dealer:"+"["+card.getDealerCards().get(0)+", ?]");
        System.out.println(getName()+":"+card.getPlayerCards());
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
    public void playerDrawCard(){
        while (command.hitStandCommand()){
            card.drawCard(card.getPlayerCards());
            System.out.println(getName()+":"+card.getPlayerCards());
        }
    }
}
