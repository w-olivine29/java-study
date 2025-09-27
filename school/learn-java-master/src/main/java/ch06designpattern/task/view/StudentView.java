package ch06designpattern.task.view;

import ch06designpattern.task.model.student.Student;

import java.util.Collection;

/*
MVC 패턴의 View
*/
public class StudentView implements View<Student> {


    @Override
    public void show(Student student) {
        System.out.println(student.getInfo());
    }

    @Override
    public void show(Collection<Student> students) {
        students.forEach(student -> System.out.println(student.getInfo()));
    }

    @Override
    public void showMessage(String message) {
        System.out.println(message);
    }

}
