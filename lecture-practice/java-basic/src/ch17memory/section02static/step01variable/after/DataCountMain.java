package ch17memory.section02static.step01variable.after;

public class DataCountMain {
    public static void main(String[] args) {
        Data data1 = new Data("Data1");
        Data data2 = new Data("Data2");
        Data data3 = new Data("Data3");
        Data data4 = new Data("Data4");
        Data data5 = new Data("Data5");

        // static 변수는 클래스가 처음 JVM에 로딩되는 순간에 메모리(메서드영역 내의 static 영역)에 올라감
        // static 변수는 인스턴스끼리 공유된다. (개별의 인스턴스 영역에 생성 X)
        System.out.println("data1.count  = " + data1.count); //5
        System.out.println("data2.count  = " + data2.count); //5
        System.out.println("data3.count  = " + data3.count); //5
        System.out.println("data4.count  = " + data4.count); //5
        System.out.println("data5.count  = " + data5.count); //5

        /*
         * 위에서는 인스턴스변수를 통해 count(정적변수, 클래스변수)에 접근했는데, 비권장 (IDE에서도 인스턴스로 접근시 정적요소를 보여주지 않음)
         * - 이론상으론 heap 영역에 갔다가 static 영역에 접근하는 불필요한 과정
         * - 접근은 가능하지만 마치 인스턴스변수인 것처럼 보이는 혼동을 줄 수 있음 (중요)
         */

        // 클래스이름.정적변수명 으로 접근해야한다.
        System.out.println("Data.count = " + Data.count); //5
    }
}
