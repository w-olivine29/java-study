package ch17memory.section02static.step01variable.before;


// 객체생성 누적개수를 얻기
// Data1 객체에 counter 라는 필드를 선언한 상태 (인스턴스 변수)
public class DataCountMain1 {
    public static void main(String[] args) {

        // but 인스턴스별로 필드가 새로 만들어지고 카운트
        // 의도한 누적증가는 불가
        Data1 data1 = new Data1("a");
        System.out.println("data1.count = " + data1.count); //1

        Data1 data12 = new Data1("b");
        System.out.println("data2.count = " + data12.count); //1

        Data1 data13 = new Data1("c");
        System.out.println("data3.count = " + data13.count); //1
    }
}
