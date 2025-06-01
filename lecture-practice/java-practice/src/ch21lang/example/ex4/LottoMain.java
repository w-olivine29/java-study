package ch21lang.example.ex4;

import java.util.Arrays;
import java.util.Random;

// 로또 번호 자동 생성기 만들기
// 1~45사이 숫자 6개 뽑기
// 각 숫자는 중복되면 안된다
// 실행할 때마다 결과가 달라야함
public class LottoMain {
    public static void main(String[] args) {

        LottoGenerator generator = new LottoGenerator(new Random(), 10); //10장 구매
        generator.generate();
        generator.printLottoTickets();
        
    }
}
