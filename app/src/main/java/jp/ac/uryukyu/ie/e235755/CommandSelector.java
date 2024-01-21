package jp.ac.uryukyu.ie.e235755;
import java.util.Scanner;

public class CommandSelector {
    private Scanner scanner = new Scanner(System.in);
    private boolean bool;
    private boolean roop;
    private Player player;

    public CommandSelector(Player player){
        this.player = player;
    }

    public boolean getRoop(){
        return roop;
    }

    //スタートメソッド
    public void startCommand(){
        System.out.println();
        System.out.println("---------"+"\u2660"+"\u2665 "+"BLACK JACK"+" \u2663"+"\u2666"+"---------");
        //"\u2665"ハート,"\u2666"ダイヤ,"\u2663"クローバー,"\u2660"スペード
        for(int i=0;i<3;i++){
            System.out.println();
        }
        System.out.println("0: START");
        System.out.println("1: END");
        System.out.print("> ");
        int num = scanner.nextInt();
        System.out.println("----------------------------------");
        
        if (num == 0){
        }else if (num == 1){
            System.out.println("Bye!");
            System.out.println("----------------------------------");
            System.exit(0);
        }else{
            startCommand();
            System.out.println();
        }
    }

    //ヒットスタンドメソッド
    public boolean hitStandCommand(){
        System.out.println();
        System.out.println("0: HIT");
        System.out.println("1: STAND");
        System.out.print("> ");
        int num = scanner.nextInt();
        System.out.println("----------------------------------");

        if (num == 0){
            bool = true;
        }else if (num == 1){
            bool = false;
        }else{
            System.out.println();
            hitStandCommand();
        }
        return bool;
    }
    //賭け金0$で終了するメソッド
    public void noBankrollCommand(){
        System.out.println("----------------------------------");
        System.out.println("GAME OVER");
        System.out.println("----------------------------------");
        System.exit(0);
    }
    //コンティニューメソッド
    public void continueCommand(){
        System.out.println();
        System.out.println("0: CONTINUE" + "         "+"Bankroll:"+player.getBankroll()+"$");
        System.out.println("1: END");
        System.out.print("> ");
        int num = scanner.nextInt();

        if (num == 0){
            System.out.println("----------------------------------");
            System.out.println("Good luck!");
            roop = true;

        }else if (num == 1){
            System.out.println("----------------------------------");
            System.out.println("See you again!");
            System.out.println("----------------------------------");
            System.exit(0);
        }else{
            System.out.println();
            continueCommand();
        }
        

    }

}
