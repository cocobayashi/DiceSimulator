import java.util.Random;

public class MakeDiceNumber {
    //フィールド
    private Random rand = new Random();

    //コンストラクタ
    public void MakeDice() {}

    //メソッド
    protected int makeNumber(int dice) {
        int length = 10;
        int ret[] = new int[length];
        for(int i = 0; i < length; i++) {
            ret[i] = rand.nextInt(dice) + 1;
        }
        int temp = rand.nextInt(length);
        return ret[temp];
    }
}