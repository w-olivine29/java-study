package ch12reference;


class BigData {
    Data data; // null 로 자동 초기화
    int count; // 0으로 자동 초기화
}

public class Ref06NullPointerException {
    public static void main(String[] args) {

        BigData bigData = new BigData();
        System.out.println("bigData = " + bigData.count);
        System.out.println("bigData.data = " + bigData.data); // null

        // NullPointerException
        System.out.println("bigData.data.value = " + bigData.data.value); //참조값이 없는데 접근시도한 것


        // 초기화 자체를 하지 않았을 때는 컴파일 에러 발생
        BigData data;

        // Variable 'data' might not have been initialized
        //System.out.println(data);

    }
}
