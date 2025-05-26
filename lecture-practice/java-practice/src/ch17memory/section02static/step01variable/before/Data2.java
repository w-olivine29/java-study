package ch17memory.section02static.step01variable.before;

public class Data2 {

    public String name;

    // Data2 객체생성할때마다 counter 라는 객체를 받아서 누적개수를 증가
    public Data2(String name, Counter counter) {
        this.name = name;
        counter.count++;
    }

}
