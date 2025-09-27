package ch06designpattern.task.dto;

public record StudentSearchRequest(
        String name,
        String department,
        String clubName
) {

    // compact constructor (전체 파라미터로 받는 정규 생성자 축약형)
    public StudentSearchRequest {
        if(name.isBlank() & department.isBlank() & clubName.isBlank()){
            throw new IllegalArgumentException("검색 조건은 최소 하나 이상 입력해야합니다.");
        }
    }

    public StudentSearchCriteria toCriteria() {
        return new StudentSearchCriteria(name, department,clubName);
    }
}


