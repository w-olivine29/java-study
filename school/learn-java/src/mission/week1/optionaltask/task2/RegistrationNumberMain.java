package mission.week1.optionaltask.task2;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;

// 선택 과제 2번. 주민등록번호 생성 프로그램
public class RegistrationNumberMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int year;
        int month;
        int day;
        String sex;

        System.out.println("[주민등록번호 계산]");

        year = getValidYear(scanner);
        month = getValidMonth(scanner);
        day = getValidDay(scanner);
        sex = getValidSex(scanner);

        System.out.println(getRegistrationNumber(year, month, day, sex));
    }


    private static int getValidYear(Scanner scanner) {

        int input = 0;
        while (true) {
            try {
                System.out.print("출생년도를 입력해 주세요. (yyyy): ");

                input = Integer.parseInt(scanner.nextLine());
                if(input < 1900 || input > LocalDate.now().getYear()){
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) { // NumberFormatException 도 포함됨
                System.out.println("다시 입력해주세요.");
            }
        }
        return input;
    }

    private static int getValidMonth(Scanner scanner) {

        int input = 0;
        while (true) {
            try {
                System.out.print("출생월을 입력해 주세요. (mm): ");
                input = Integer.parseInt(scanner.nextLine());

                if(input < 1 || input > 12){
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) { // NumberFormatException 도 포함됨
                System.out.println("다시 입력해주세요.");
            }
        }
        return input;
    }

    private static int getValidDay(Scanner scanner) {

        int input = 0;
        while (true) {
            try {
                System.out.print("출생일을 입력해 주세요. (dd): ");

                input = Integer.parseInt(scanner.nextLine());
                if(input < 1 || input > 31){
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) { // NumberFormatException 도 포함됨
                System.out.println("다시 입력해주세요.");
            }
        }
        return input;
    }

    private static String getValidSex(Scanner scanner) {

        String input = "";
        while (true) {
            try {
                System.out.print("성별을 입력해 주세요. (m/f): ");
                input = scanner.nextLine().toLowerCase();
                if(!(input.equals("m") || input.equals("f"))){
                    throw new IllegalArgumentException();
                }
                break;

            } catch (IllegalArgumentException e) {
                System.out.println("다시 입력해주세요.");
            }
        }
        return input;
    }


    private static final Random random = new Random();

    // 2000년부터는 3(남자), 4(여자)
    // 2020년 10월부터는 뒷자리의 7자리의 지역 번호 폐지 + 임의 번호로 변경
    private static String getRegistrationNumber(int year, int month, int day, String sex) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%02d", year % 100))
                .append(String.format("%02d", month))
                .append(String.format("%02d", day))
                .append("-");

        if (year < 2000) {
            sb.append((sex.equals("m") ? 1 : 2));
        } else {
            sb.append((sex.equals("m") ? 3 : 4));
        }

        int randomNumber = random.nextInt(1, 999999);
        sb.append(String.format("%06d", randomNumber));

        return sb.toString();
    }
}
