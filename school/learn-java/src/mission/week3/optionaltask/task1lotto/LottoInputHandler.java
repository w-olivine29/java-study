package mission.week3.optionaltask.task1lotto;

import java.util.InputMismatchException;
import java.util.Scanner;

// 41기 유도경
public class LottoInputHandler implements AutoCloseable {

    private final Scanner scanner;

    public LottoInputHandler(Scanner scanner) {
        this.scanner = scanner;
    }

    public int inputPurchaseCount() {

        int count;
        while (true) {
            try {
                System.out.print("로또 개수를 입력해 주세요. (숫자 1~20): ");
                count = scanner.nextInt();

                if (count < 1 || count > 20) {
                    throw new InputMismatchException("1 ~ 20개까지만 구매가능합니다."); //TODO 커스텀 예외로 바꾸기
                }
                return count;
            } catch (InputMismatchException e) {
                System.out.println(e.getMessage());
            } finally {
                scanner.nextLine(); // 버퍼 비우기
            }
        }
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}
