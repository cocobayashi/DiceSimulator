import java.util.Scanner;

public class DiceSimulator {
    public static void main(String[] args) {
        System.out.println("ダイスシュミレーター");
        Scanner scan = new Scanner(System.in);
        System.out.println("ダイスの面数を入力して下さい(4以上、偶数)");
        System.out.print("==> ");
        String str1 = scan.nextLine();

        System.out.println("ダイスの個数を入力して下さい(0以上)");
        System.out.print("==> ");
        String str2 = scan.nextLine();

        InOutDice inout = new InOutDice();
        inout.checkArgs(str1, str2);

        System.out.println(String.format("結果\n"));
        inout.disp();
    }
}