package jp.ac.uryukyu.ie.e235755;
import java.util.Scanner;

public class CommandSelector {
    private Scanner scanner = new Scanner(System.in);
    private boolean bool;

    
    //スタートメソッド
    public void startCommand(){
        System.out.println();
        System.out.println("---------"+"\u2665"+"\u2666 "+"BLACK JACK"+" \u2663"+"\u2660"+"---------");
        //"\u2665","\u2666","\u2663","\u2660"
        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println("0: START");
        System.out.println("1: END");
        System.out.print(">");
        int num = scanner.nextInt();
        System.out.println("----------------------------------");
        
        if (num == 0){

            //game始めるメソッド

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
        System.out.print(">");
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
        System.out.println("0: CONTINUE");
        System.out.println("1: END");
        System.out.print(">");
        int num = scanner.nextInt();

        if (num == 0){
            System.out.println("----------------------------------");
            System.out.println("Good luck!");
            System.out.println("----------------------------------");
            //ゲーム始めるメソッド(賭けるとこから)
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
