package ch27collection.section7map.example.ex5;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/* 영단어장 만들기

- 영어, 한글 단어 저장
- 단어 검색

*/
public class VocabularyList_MySolution {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        Map<String, String> vocabulary = new HashMap<>();

        boolean isRunning = true;
        while (isRunning) {
            System.out.print("영단어 추가 - '1' | ");
            System.out.print("영단어 검색 - '2' | ");
            System.out.println("나가기 - 'q' ");


            isRunning = switch (scanner.nextLine()) {
                case "1" -> {
                    addWordProcess(scanner, vocabulary);
                    yield true;
                }
                case "2" -> {
                    searchWordProcess(scanner, vocabulary);
                    yield true;
                }
                case "q" -> {
                    System.out.println("프로그램 종료");
                    yield false;
                }
                default -> {
                    System.out.println("잘못된 옵션 - 다시 선택해주십시오.");
                    yield true;
                }
            };
        }

    }

    private static void searchWordProcess(Scanner scanner,
                                          Map<String, String> vocabulary) {
        while (true) {
            System.out.println("검색할 단어를 입력하세요. [나가기] - q");
            String word = scanner.nextLine();
            if (word.equals("q")) {
                return;
            }

            printWord(vocabulary, word);
        }

    }

    private static void printWord(Map<String, String> vocabulary, String word) {
        word = word.strip().toLowerCase();

        if (!vocabulary.containsKey(word)) {
            System.out.println(word + " - 단어장에 없는 단어입니다.");
            return;
        }

        System.out.println(word + ": " + vocabulary.get(word));
    }

    private static void addWordProcess(Scanner scanner, Map<String, String> vocabulary) {

        while (true) {
            System.out.println("추가할 단어를 입력하세요. [나가기] - q");
            String word = scanner.nextLine();
            if (word.equals("q")) {
                return;
            }

            System.out.print(word + "의 뜻을 입력하세요. ");
            String meaning = scanner.nextLine();

            addWord(vocabulary, word, meaning);
        }


    }

    private static void addWord(Map<String, String> vocabulary,
                                String word, String meaning) {
        word = word.strip().toLowerCase();
        vocabulary.put(word, meaning);
    }
}
