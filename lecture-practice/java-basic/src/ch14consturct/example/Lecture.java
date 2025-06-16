package ch14consturct.example;

/* 생성자 만들기
 * 생성자 코드에 중복이 없도록 한다.
 * */
public class Lecture {

    String title;
    String educator;
    int count;


    // 체이닝형 구조에 중점
//    public Lecture(String title) {
//        this.title = title;
//    }
//
//    public Lecture(String title, String educator) {
//        this(title);
//        this.educator = educator;
//    }
//
//    public Lecture(String title, String educator, int count) {
//        this(title,educator);
//        this.count = count;
//    }


    // 주요 생성자 중심 호출 구조
    public Lecture(String title) {
        this(title, "", 0);
    }

    public Lecture(String title, String educator) {
        this(title, educator, 0);
    }

    public Lecture(String title, String educator, int count) {
        this.title = title;
        this.educator = educator;
        this.count = count;
    }

}
