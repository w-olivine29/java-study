# 실습과제 4. Design Patterns

---
## 과제 요구사항
- 강의에서 소개되지 않은 디자인 패턴 중 1개 이상 직접 구현
- 구현한 패턴에 대한 이론 정리 작성

---

## 구현한 패턴

강의에서는 GoF 23가지 디자인 패턴을 모두 소개했기때문에, 다음 디자인 패턴들을 적용하였다.

- ### Null Object Pattern
  - 특정 객체가 존재하지 않는 상황일 때 NullObject를 반환하여 직접적인 Null 체크를 방지함으로써 Null인 상황을 안전하게 다룰 수 있다.
  - **과제에서의 적용**
    - `NullStudent`, `NullClub` 클래스를 두어 null에 대한 상태를 객체화
    - 학생을 찾지 못하였을 때 `NullStudent` 반환
    - 학생 등록 시 학생이 동아리 등록을 하지 않은 경우
      - Student 클래스의 Club 필드를 null 로 두는 것이 아닌 NullClub 으로 초기화
- ### DAO Pattern
  - 데이터베이스나 파일 같은 저장소에 접근하는 로직을 별도의 객체로 분리하는 방식

  - **과제에서의 적용**
    - StudentRepository 를 두어 데이터 접근 로직 분리
    - DB 연결 대신, 애플리케이션 내부의 Map 으로 저장소 구현
- ### MVC Pattern
  - Model: 애플리케이션의 핵심 데이터와 비즈니스 로직 담당
  - View: 클라이언트에게 데이터를 보여주는 표현 계층
  - Controller: 클라이언트의 요청을 받아 Model 조작 후 그에 따른 View 반환
    

  MVC 패턴은 애플리케이션의 역할을 세 부분으로 나누어 관심사의 분리를 통해 코드의 유지보수성과 확장성을 높일 수 있다.
  - **과제에서의 적용**
    - **Model**
      - `Student`, `EnrolledStudent`, `NullStudent`
      - `Club`, `DefaultClub`, `NullClub`
    - **View**
      - `View<T>` 인터페이스와 `StudentView` 구현체
        - 순수 자바 과제이기때문에, 콘솔 출력 전용으로 구현
        - `show()`, `showMessage()` 를 통해 결과를 콘솔에 출력
    - **Controller**
      - `StudentController`
      - 클라이언트의 요청을 받아 `Repository` 와 `View` 연결하는 역할
      - Student에 대한 요청을 받고 Student 조작 -> View 로 연결