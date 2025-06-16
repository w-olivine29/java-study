package ch14consturct.example;


public class LectureMain {
    public static void main(String[] args) {
        Lecture lecture1 = new Lecture("강의1");
        Lecture lecture2 = new Lecture("강의2", "강의2-강사");
        Lecture lecture3 = new Lecture("강의3", "강의3-강사", 50);

        Lecture[] lectures = {lecture1, lecture2, lecture3};

        for (Lecture lecture : lectures) {
            System.out.printf("강의명: %s, 강사이름: %s, 강의수:%d\n",
                    lecture.title, lecture.educator, lecture.count);
        }
    }
}
