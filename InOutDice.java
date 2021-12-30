import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InOutDice {
    //フィールド
    MakeDiceNumber mdn;
    List<Integer> diceList;
    ArrayList<String> errormsgList;
    int diceMask;
    int diceNumber;
    boolean errorflag;

    //コンストラクタ
    public InOutDice() {
        mdn = new MakeDiceNumber();
        diceList = new ArrayList<>();
        errormsgList = new ArrayList<>();
        errorflag = true;
    }

    //フィールド
    protected boolean checkArgs(String str1, String str2) {
        if (checkNumber(str1)) {                                                                     //1つ目の引数チェック
            diceMask = Integer.parseInt(str1);
            if (diceMask < 4) {
                errorflag = false;
                errormsgList.add("ダイスの面数が3以下、不正です。");
            } else if(diceMask % 2 == 1) {
                errorflag = false;
                errormsgList.add("ダイスの面数が奇数、不正です。");
            }
        } else {
            errorflag = false;
            errormsgList.add("ダイスの面数が正規表現（数字）ではありません");
        }

        if (checkNumber(str2)) {                                                                     //2つ目の引数チェック
            diceNumber = Integer.parseInt(str2);
        } else {
            errorflag = false;
            errormsgList.add("ダイスの個数が正規表現（数字）ではありません");
        }
        
        if (errorflag) {
            for (int i = 0; i < diceNumber; i++) {
                diceList.add(mdn.makeNumber(diceMask));
            }
        }
        return errorflag;
    }

    protected void disp() {
        if(errorflag) {
            dispDice();
        } else {
            dispErrormsg();
        }
    }

    private boolean checkNumber(String number) {
        boolean ret = true;
        Pattern pat = Pattern.compile("^[0-9]+$");
        Matcher mat = pat.matcher(number);
        if (!mat.matches()) {
            ret = false;
        }
        return ret;
    }

    private void dispDice() {
        System.out.println("ダイスの面数 " + diceMask);
        System.out.println("ダイスの個数 " + diceNumber);
        System.out.println("");
        int all = 0;
        for(int i = 0; i < diceList.size(); i++) {
            System.out.println(String.format("%2d個目のダイス出目 = %3d\n", i + 1, diceList.get(i)));
            all += diceList.get(i);
        }
        System.out.println("ダイスの出目合計 = " + all);
    }

    private void dispErrormsg() {
        for (int i = 0; i < errormsgList.size(); i++) {
            System.out.println(errormsgList.get(i));
        }
        return;
    }
}