package ch06designpattern.task.dao;

import ch06designpattern.task.dto.StudentSearchCriteria;
import ch06designpattern.task.model.student.Student;

import java.util.*;
import java.util.stream.Stream;

public class StudentRepository {

    private final Map<Long, Student> studentMap = new HashMap<>();

    public boolean register(Student student) {
        // 저장 여부의 반환값을 받기 위함
        if (!studentMap.containsKey(student.getId())) {
            studentMap.put(student.getId(), student);
            return true;
        }
        return false;
    }


    public Optional<Student> findById(long id) {
        return Optional.ofNullable(studentMap.get(id));
    }


    // 컨트롤러 계층에서 사용하는 dto와 별개의 dto 를 받아옴
    // 받아온 값에 따라 filter를 동적으로 적용
    public List<Student> find(StudentSearchCriteria criteria) {
        Stream<Student> stream = studentMap.values().stream();

        // 검색 조건에 이름이 포함돼있을 때
        if (!criteria.name().isBlank()) {
            stream = stream.filter(student -> Objects.equals(criteria.name(), student.getName()));
        }

        // 검색 조건에 학과가 포함돼있을 때
        if (!criteria.department().isBlank()) {
            stream = stream.filter(student -> Objects.equals(criteria.department(), student.department()));
        }

        // 검색 조건에 동아리가 포함돼있을 때
        if (!criteria.clubName().isBlank()) {
            stream = stream.filter(student ->
                    Objects.equals(criteria.clubName(), student.getClub().getName()));
        }


        // 최종연산 적용
        return stream.toList();
    }
}

