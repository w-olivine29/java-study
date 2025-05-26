package ch17memory.section02static.step01variable.before;

// 객체생성 누적개수를 얻기
// Counter 라는 별도의 클래스를 만들고 count 라는 필드를 선언 (인스턴스 변수)
public class DataCountMain2 {
    public static void main(String[] args) {

        // 누적개수를 구하는 용도로 공용으로 사용할 객체를 생성
        Counter counter = new Counter();

        // Data2의 인스턴스를 생성할때마다 공용으로 사용하는 객체의 카운터를 증가
        Data2 data1 = new Data2("a", counter);
        System.out.println("data1.count = " + counter.count);

        Data2 data2 = new Data2("b", counter);
        System.out.println("data2.count = " + counter.count);

        Data2 data3 = new Data2("c", counter);
        System.out.println("data3.count = " + counter.count);

        /*
        Data2에 관련한 기능인데, 별도의 클래스를 추가로 사용하는 점이
        Data2 내부에서 관리돼야할 책임을 외부로 분산시키면서 구조가 복잡해짐
        */

    }
}
