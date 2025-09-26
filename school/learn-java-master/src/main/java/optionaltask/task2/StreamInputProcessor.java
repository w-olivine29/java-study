package optionaltask.task2;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/* 사용자가 콘솔에서 여러 개의 숫자를 입력한 후 Stream을 활용하여 다음 작업을 수행하는 프로그램 작성

사용자가 숫자를 입력하면 공백 또는 쉼표(,)로 구분하여 여러 개의 정수를 받을 수 있도록 함
Stream을 활용하여 데이터 처리
    모든 숫자의 합계와 평균을 계산
    짝수와 홀수를 분류하여 출력
    가장 큰 값과 작은 값 찾기
    중복을 제거하고 정렬하여 출력
결과를 출력

10, 11, 20, 22, 30, 33, 40 44, 50, 55 60 66, 66, 66 70, 77, 80,  ,88, 90, 99
*/
public class StreamInputProcessor implements AutoCloseable {
    public static void main(String[] args) {

        try (StreamInputProcessor processor = new StreamInputProcessor(new Scanner(System.in))) {
            processor.execute();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private final Scanner scanner;

    public StreamInputProcessor(Scanner scanner) {
        this.scanner = scanner;
    }

    public void execute() {
        List<Integer> values = convertToIntList(inputNumbers());
        StatistResult result = StatistResult.from(values);
        result.printTotalResult();
    }

    private String inputNumbers() {
        System.out.println("숫자를 입력하세요. (공백 또는 쉼표로 구분):");
        return scanner.nextLine();
    }

    /*
    , -> 쉼표
    \\s -> 모든 공백 문자
    + -> 하나 이상의 연속된 공백도 하나로 취급
    split("[,\\s]+") -> 쉼표 또는 공백을 하나 이상 만나면 분리
    */
    private List<Integer> convertToIntList(String input) {
        String[] split = input.split("[,\\s]+");

        List<Integer> result = new ArrayList<>();

        for (String s : split) {
            s = s.strip();

            try {
                result.add(Integer.valueOf(s));
            } catch (NumberFormatException e) {
                continue;
            }
        }
        return result;
    }

    @Override
    public void close() throws Exception {
        scanner.close();
    }
}
