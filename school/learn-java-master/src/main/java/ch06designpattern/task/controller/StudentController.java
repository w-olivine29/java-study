package ch06designpattern.task.controller;

import ch06designpattern.task.dao.StudentRepository;
import ch06designpattern.task.dto.CreateStudentRequest;
import ch06designpattern.task.dto.ReAdmissionStudentRequest;
import ch06designpattern.task.dto.StudentSearchRequest;
import ch06designpattern.task.model.Club.DefaultClub;
import ch06designpattern.task.model.student.EnrolledStudent;
import ch06designpattern.task.model.student.NullStudent;
import ch06designpattern.task.model.student.Student;
import ch06designpattern.task.view.View;

import java.util.List;

/* MVC 패턴의 Controller
클라이언트의 요청을 받는 계층

순수 자바 실습 과제이기때문에 View를 반환하는 것이 아닌 직접 호출하게끔 하였음 (콘솔 출력)
*/
public class StudentController {

    private final StudentRepository repository;
    private final View<Student> view;


    public StudentController(StudentRepository repository, View<Student> view) {
        this.repository = repository;
        this.view = view;
    }


    public void registerNewAdmission(CreateStudentRequest request) {

        boolean isSaved = repository.register(EnrolledStudent.newAdmission(
                request.id(), request.grade(), request.name(), request.department()));

        view.showMessage(isSaved ? "저장에 성공했습니다." : "저장에 실패했습니다. (이미 등록돼있는 학번입니다.)");
    }

    public void registerReAdmission(ReAdmissionStudentRequest request) {

        boolean isSaved = repository.register(EnrolledStudent.reAdmission(
                request.id(), request.grade(), request.name(), request.department(), request.entrancedYear()));

        view.showMessage(isSaved ? "저장에 성공했습니다." : "저장에 실패했습니다. (이미 등록돼있는 학번입니다.)");
    }

    // 개별 학생 찾기
    public void findStudent(long id) {
            Student student = repository.findById(id)
                    .orElse(new NullStudent());
            view.show(student);
    }


    // 학생 목록 조회
    public void findStudents(StudentSearchRequest request) {
        List<Student> students = repository.find(request.toCriteria());
        view.show(students);
    }

    // 소속 동아리 추가
    public void participateClub(long studentId, DefaultClub club) {
        Student student = repository.findById(studentId)
                .orElse(new NullStudent());

        if(student instanceof EnrolledStudent){
            ((EnrolledStudent) student).registerClub(club);
            view.showMessage("동아리 등록에 성공했습니다.");
        }else {
            view.show(student);
        }
    }

}
