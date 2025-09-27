package ch06designpattern.task.model.student;

import ch06designpattern.task.model.Club.Club;
import ch06designpattern.task.model.Club.NullClub;

import java.time.Year;

public class EnrolledStudent implements Student {
    private final long id;
    private String name;
    private int grade;
    private String department;
    private Club club; //동아리

    private final Year entrancedYear; //입학년도


    // 신입생 등록용
    public static EnrolledStudent newAdmission(long id, int grade, String name, String className) {
        return new EnrolledStudent(id, grade, name, className, Year.now());
    }

    // 전학생 & 재등록용
    public static EnrolledStudent reAdmission(long id, int grade, String name, String className, Year entrancedYea) {
        return new EnrolledStudent(id, grade, name, className, entrancedYea);
    }


    // 정적 팩토리 메서드를 통해서만 인스턴스 생성하기 위해 private
    private EnrolledStudent(long id, int grade, String name, String department, Year entrancedYear) {
        this.id = id;
        this.grade = grade;
        this.name = name;
        this.department = department;
        this.club = new NullClub();
        this.entrancedYear = entrancedYear;
    }

    @Override
    public String getInfo() {
        return String.format("[재학생] 학번: %d, 이름: %s, 학년: %d, 학과:%s, 소속 동아리: %s\n",
                id, name, grade, department, club.getInfo()
        );
    }

    @Override
    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    @Override
    public String department() {
        return department;
    }

    public int getGrade() {
        return grade;
    }

    public String getDepartment() {
        return department;
    }

    public Club getClub() {
        return club;
    }

    public Year getEntrancedYear() {
        return entrancedYear;
    }

    public void registerClub(Club club) {
        this.club = club; // NullClub 으로 세팅 시 (동아리 탈퇴)
    }
}
