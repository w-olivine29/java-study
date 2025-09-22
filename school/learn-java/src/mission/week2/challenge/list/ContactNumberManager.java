package mission.week2.challenge.list;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static mission.week2.challenge.list.SortField.*;
import static mission.week2.challenge.list.SortOrder.*;


// 41기 유도경
public class ContactNumberManager {

    public static void main(String[] args) {

        // 기존 전화번호부 세팅
        ContactBook existingContactBook = new ContactBook(new ArrayList<>( // 가변 리스트로 세팅
                List.of(new ContactNumber("올리브유", "00-0000-0000"),
                        new ContactNumber("카놀라유", "11-1111-1111"),
                        new ContactNumber("아보카도유", "22-2222-2222"),
                        new ContactNumber("현미유", "33-3333-3333")
                )
        )
        );

        ContactNumberManager contactNumberManager = new ContactNumberManager(existingContactBook);
        contactNumberManager.execute();
    }

    private final Scanner scanner;
    private ContactBook contactBook;


    // 전화번호부 처음 생성
    public ContactNumberManager() {
        this.scanner = new Scanner(System.in);
        this.contactBook = new ContactBook();
    }

    // 기존에 존재하는 전화번호부 가져오기
    public ContactNumberManager(ContactBook contactBook) {
        this.scanner = new Scanner(System.in);
        this.contactBook = contactBook;
    }


    public void execute() {

        String command;
        try (Scanner scanner = new Scanner(System.in)) {
            while (true) {
                System.out.println("\n연락처 관리 시스템 (add, remove, list, search, exit)");
                System.out.print("명령 입력: ");
                command = scanner.nextLine();

                System.out.println();
                switch (command) {
                    case "add" -> {
                        addProcess();
                    }
                    case "remove" -> {
                        removeProcess();
                    }
                    case "list" -> {
                        printListProcess();
                    }

                    case "search" -> {
                        searchProcess();
                    }
                    case "exit" -> {
                        System.out.println("종료합니다.");
                        return;
                    }
                    default -> {
                        System.out.println("명령어를 다시 입력해주세요.");
                    }

                }
            }
        }
    }

    private void addProcess() {

        System.out.print("이름: ");
        String name = scanner.nextLine();

        System.out.print("전화번호: ");
        String number = scanner.nextLine();

        if (contactBook.addNumber(new ContactNumber(name, number))) {
            System.out.println("연락처가 추가되었습니다.");
        } else {
            System.out.println("연락처 추가실패 (이미 존재하는 연락처입니다.)");
        }
    }


    private void removeProcess() {

        System.out.print("삭제할 연락처 이름: ");
        String name = scanner.nextLine();

        System.out.print("삭제할 연락처 번호: ");
        String number = scanner.nextLine();

        if (contactBook.removeNumber(new ContactNumber(name, number))) {
            System.out.println("삭제 완료");
        } else {
            System.out.println("삭제 실패 (존재하지 않는 연락처입니다.)");
        }
    }

    private void searchProcess() {

        System.out.print("검색할 이름: ");
        List<ContactNumber> searchResult = contactBook.searchNumber(scanner.nextLine());

        if (searchResult.isEmpty()) {
            System.out.println("해당 이름의 연락처가 존재하지 않습니다.");
        } else {
            searchResult.forEach(System.out::println);
        }
    }


    private void printListProcess() {

        System.out.println("정렬된 출력을 원하시면 sort, 기본 출력을 원하시면 아무 키나 입력하세요.");
        String input = scanner.nextLine();

        if (input.equals("sort")) {
            SortCriteria sortCriteria = new SortCriteria(inputSortField(), inputSortOrder());
            contactBook.printNumbers(sortCriteria);
        } else {
            contactBook.printNumbers();
        }
    }


    private SortField inputSortField() {

        // 정렬기준 입력
        while (true) {
            System.out.println("정렬기준을 선택해주세요. (이름: name, 생성일자: date");
            System.out.print("명령 입력: ");

            switch (scanner.nextLine()) {
                case "name" -> {
                    return NAME;
                }
                case "date" -> {
                    return CREATED_AT;
                }
                default -> System.out.println("명령어를 다시 입력해주세요.");
            }
        }
    }

    private SortOrder inputSortOrder() {
        while (true) {
            System.out.println("정렬방식을 선택해주세요. (오름차순: asc, 내림차순: desc");
            System.out.print("명령 입력: ");

            switch (scanner.nextLine()) {
                case "asc" -> {
                    return ASC;
                }
                case "desc" -> {
                    return DESC;
                }
                default -> System.out.println("명령어를 다시 입력해주세요.");
            }
        }
    }
}
