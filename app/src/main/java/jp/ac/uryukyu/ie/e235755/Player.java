package jp.ac.uryukyu.ie.e235755;
import java.util.Scanner;
/**
 * プレイヤーに関連する機能をまとめたクラス
 */
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

    /**
     * プレイヤーの資金を取得するメソッド
     * @return　プレイヤーの資金
     */
    public int getBankroll(){
        return bankroll;
    }
    /**
     * プレイヤーの名前を取得するメソッド
     * @return プレイヤーの名前
     */
    public String getName(){
        return name;
    }
    /**
     * プレイヤーの名前を設定するメソッド
     * @param name プレイヤーの名前
     */
    public void setName(String name){
        this.name = name;
    }


    /**
     * プレイヤーの名前を聞き、設定するメソッド
     */
    public void playerName(){
        System.out.println("Put your name.");
        for (int i=0;i<4;i++){
            System.out.println();
        }
        System.out.print("> ");
        name = scanner.nextLine();
        setName(name);
    }

    /**
     * 最初の手札(2枚)を表示するメソッド
     */
    public void showHands(){
        System.out.println("----------------------------------");
        System.out.println("dealer:"+"["+card.getDealerCards().get(0)+", ?]");
        System.out.println(getName()+":"+card.getPlayerCards());
    }
    
    /**
     * 賭けるメソッド
     */
    public void bet(){
        System.out.println("----------------------------------");
        System.out.println("Place your bet."+"     "+"Bankroll:"+"$"+bankroll);
        for (int i=0;i<4;i++){
            System.out.println();
        }
        System.out.print("> $");
        bet = scanner.nextInt();
        if (bet > bankroll){
            System.out.println("----------------------------------");
            System.out.println("Bet exceeds your bankroll"); 
            bet();
        }
    }

    /**
     * 敗北メソッド
     */
    public void lose(){
        System.out.println("----------------------------------");
        System.out.println("YOU LOSE"+"                    "+"-"+"$"+bet);
        System.out.println();
        bankroll -= bet;
        if (bankroll == 0){
            command.noBankrollCommand();
        }
        bet = 0;
    }
    /**
     * 勝利メソッド
     */
    public void win(){
        System.out.println("----------------------------------");
        System.out.println("YOU WIN!"+"                    "+"+"+"$"+bet);
        System.out.println();
        bankroll += (bet);
        bet = 0;
    }

    /**
     * ブラックジャックでの勝利メソッド
     */                    
    public void winBlackJack(){
        System.out.println("----------------------------------");
        System.out.println("BLACK JACK!!"+"                "+"+"+"$"+bet*2);
        System.out.println();
        bankroll += (bet*2);
        bet = 0;
    }
    /**
     * 引き分けメソッド
     */
    public void push(){
        System.out.println("----------------------------------");
        System.out.println("PUSH"+"                          "+"\u00B1"+"$0");
        bet = 0;
    }

    /**
     * プレイヤーがカードを引くメソッド
     */
    public void playerDrawCard(){
        while (command.hitStandCommand()){
            card.drawCard(card.getPlayerCards());
            System.out.println(getName()+":"+card.getPlayerCards());
            System.out.println();
        }
    }
}
