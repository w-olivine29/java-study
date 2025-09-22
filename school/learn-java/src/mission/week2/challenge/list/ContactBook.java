package mission.week2.challenge.list;

import java.util.ArrayList;
import java.util.List;

// 41기 유도경
public class ContactBook {

    private List<ContactNumber> numbers;

    public ContactBook() {
        this.numbers = new ArrayList<>();
    }

    public ContactBook(List<ContactNumber> numbers) {
        this.numbers = numbers;
    }


    public boolean addNumber(ContactNumber number) {
        if (numbers.contains(number)) {
            return false;
        }
        return numbers.add(number);
    }


    // 동명이인
    public List<ContactNumber> searchNumber(String name) {
        return numbers.stream()
                .filter(number -> name.equals(number.getName()))
                .toList();
    }


    public boolean removeNumber(ContactNumber number) {
        return numbers.remove(number);
    }


    // 기본 출력 (이름 오름차순)
    public void printNumbers() {
        
        // 원본은 보존
        numbers.stream()
                .sorted()
                .forEach(System.out::println);
    }


    public void printNumbers(SortCriteria sortCriteria) {

        // 원본은 보존
        numbers.stream()
                .sorted(ContactNumber.getComparator(sortCriteria))
                .forEach(System.out::println);
    }

}
