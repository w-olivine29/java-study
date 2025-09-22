package mission.week2.challenge.list;

import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.Objects;

import static mission.week2.challenge.list.SortOrder.DESC;

// 41기 유도경
public class ContactNumber implements Comparable<ContactNumber> {

    private String name;
    private String number;
    private LocalDateTime createdAt;


    public ContactNumber(String name, String number) {
        this.name = name;
        this.number = number;
    }

    // 기본 정렬 (이름기준 오름차순)
    @Override
    public int compareTo(ContactNumber anotherNumber) {
        int result = this.name.compareTo(anotherNumber.getName()); // 이름기준 오름차순
        if (0 == result) {
            result = this.createdAt.compareTo(anotherNumber.createdAt);
        }

        return result;
    }


    public static Comparator<ContactNumber> getComparator(SortCriteria sortCriteria) {

        Comparator<ContactNumber> comparator;

        comparator = switch (sortCriteria.field) {
            case NAME -> Comparator.comparing(ContactNumber::getName); // ContactNumber number -> return number.getName
            case CREATED_AT -> Comparator.comparing(ContactNumber::getCreatedAt);

            default -> Comparator.comparing(ContactNumber::getName);
        };

        if (DESC.equals(sortCriteria.order)) {
            comparator = comparator.reversed();
        }


        return comparator;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }

    @Override
    public String toString() {
        return name + " - " + number;
    }

    
    // 추가 & 삭제 - 중복 검사용
    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        ContactNumber that = (ContactNumber) o;
        return Objects.equals(name, that.name) && Objects.equals(number, that.number);
    }

}
