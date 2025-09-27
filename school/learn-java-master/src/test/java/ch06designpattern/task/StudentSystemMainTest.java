package ch06designpattern.task;

import ch06designpattern.task.dto.ReAdmissionStudentRequest;
import ch06designpattern.task.controller.StudentController;
import ch06designpattern.task.dao.StudentRepository;
import ch06designpattern.task.dto.CreateStudentRequest;
import ch06designpattern.task.dto.StudentSearchRequest;
import ch06designpattern.task.model.Club.DefaultClub;
import ch06designpattern.task.model.Club.NullClub;
import ch06designpattern.task.view.StudentView;
import net.datafaker.Faker;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Year;
import java.util.function.Supplier;


// 컨트롤러의 반환값 없이 View에서 출력하는 방식으로 구현했기 때문에, 출력을 확인하는 정도로 마무리하였음
class StudentSystemMainTest {

    private final StudentController controller = new StudentController(new StudentRepository(), new StudentView());
    private final Faker faker = new Faker();

    private final Supplier<CreateStudentRequest> randomCreateStudentRequest = () -> {
        return new CreateStudentRequest(
                (long) faker.number().numberBetween(100000, 200000),
                faker.name().fullName(),
                faker.number().numberBetween(1, 4),
                faker.educator().course(),
                new NullClub()
        );
    };

    private final Supplier<ReAdmissionStudentRequest> randomReAdmissionStudentRequest = () -> {
        return new ReAdmissionStudentRequest(
                (long) faker.number().numberBetween(100000, 200000),
                faker.name().fullName(),
                faker.number().numberBetween(1, 4),
                faker.educator().course(),
                Year.of(faker.number().numberBetween(1900, LocalDate.now().getYear()))
        );
    };


    @BeforeEach
    void settingStudents() {

//        System.out.println("세팅");
//        // 신입생
//        IntStream.rangeClosed(1, 5)
//                .forEach(num ->
//                        controller.registerNewAdmission(randomCreateStudentRequest.get()));
//
//        IntStream.rangeClosed(1, 5)
//                .forEach(num -> controller.registerReAdmission(randomReAdmissionStudentRequest.get()));
//
//        System.out.println();
    }

    @Test
    void registerNewAdmission_success() {
        CreateStudentRequest request = randomCreateStudentRequest.get();
        controller.registerNewAdmission(request);
    }

    @Test
    void registerNewAdmission_fail() {
        CreateStudentRequest request = randomCreateStudentRequest.get();
        controller.registerNewAdmission(request);
        controller.registerNewAdmission(request);
    }

    @Test
    void registerReAdmission_success() {
        ReAdmissionStudentRequest request = randomReAdmissionStudentRequest.get();
        controller.registerReAdmission(request);
    }

    @Test
    void registerReAdmission_fail() {
        ReAdmissionStudentRequest request = randomReAdmissionStudentRequest.get();
        controller.registerReAdmission(request);
        controller.registerReAdmission(request);
    }

    @Test
    void findStudent_success() {
        CreateStudentRequest request = randomCreateStudentRequest.get();
        controller.registerNewAdmission(request);

        controller.findStudent(request.id());
    }

    @Test
    void findStudent_fail() {
        CreateStudentRequest request = randomCreateStudentRequest.get();
        controller.findStudent(request.id());
    }

    @Test
    void findStudents_success() {
        CreateStudentRequest request = randomCreateStudentRequest.get();
        String clubName = "당나귀";

        controller.registerNewAdmission(request);
        controller.participateClub(request.id(), new DefaultClub(clubName));

        controller.findStudents(new StudentSearchRequest(request.name(), "", ""));
        controller.findStudents(new StudentSearchRequest("", request.department(), ""));
        controller.findStudents(new StudentSearchRequest("", "", clubName));
    }

    @Test
    void findStudents_fail() {
        Assertions.assertThrows(IllegalArgumentException.class,
                ()-> controller.findStudents(new StudentSearchRequest("", "", "")));
    }

    @Test
    void participateClub() {
        CreateStudentRequest request = randomCreateStudentRequest.get();
        String clubName = "고양이";
        
        // 동아리 등록 전
        controller.registerNewAdmission(request);
        controller.findStudent(request.id());

        // 동아리 등록 후
        controller.participateClub(request.id(), new DefaultClub(clubName));
        controller.findStudent(request.id());

    }

}