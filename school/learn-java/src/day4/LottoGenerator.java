package day4;

import java.util.Arrays;
import java.util.Random;

// 문제 : 배열과 반복문으로 활용한 간단한 로또 번호 생성기 만들어보기
public class LottoGenerator {

    public static void main(String[] args) {
        LottoGenerator lottoGenerator = new LottoGenerator(4); // 4개 구매
        lottoGenerator.generateNumber();
        lottoGenerator.printNumbers();
    }

    private final Random random = new Random();
    private int[][] lottos;

    // 로또 구매개수
    public LottoGenerator(int lottoCount) {
        lottos = new int[lottoCount][6];
    }

    // 번호 생성
    public void generateNumber() {
        for (int i = 0; i < lottos.length; i++) {
            for (int j = 0; j < 6; j++) {
                int num = random.nextInt(1, 45);

                // 중복검사 실패시 다시 돌리기
                if(checkDuplicate(num, i, j)){
                    lottos[i][j] = num;
                }else {
                    j--;
                }
            }
        }
    }

    // 번호 출력
    public void printNumbers() {
        for (int i = 0; i < lottos.length; i++) {
            System.out.printf("[%d] %s\n", (i+1), Arrays.toString(lottos[i]));
        }
    }

    private boolean checkDuplicate(int currentNum, int currentLottoOrder, int currentIdx) {

        // 배열을 활용했기때문에, 중복검사를 위해서는 순차적으로 검사
        for (int i = 0; i < currentIdx; i++) {
            if (lottos[currentLottoOrder][i] == currentNum) {
                return false;
            }
        }
        return true;
    }

}
