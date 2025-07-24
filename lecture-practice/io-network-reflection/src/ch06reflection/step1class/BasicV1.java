package ch06reflection.step1class;

import ch06reflection.data.BasicData;

public class BasicV1 {
    public static void main(String[] args) throws ClassNotFoundException {
        //클래스 메타데이터 조회 방법 3가지
        // 메타데이터: 데이터에 대한 정보를 담고 있는 데이터 (클래스의 구조, 메서드, 필드 등의 정보)
        // 클래스의 메타데이터는 Class 라는 클래스로 표현된다.
        // Class 라는 클래스 획득 방법

        //1. 클래스에서 찾기
        Class<BasicData> basicDataClass1 = BasicData.class;
        System.out.println("basicDataClass1 = " + basicDataClass1); //class ch06reflection.data.BasicData

        // 2. 인스턴스에서 찾기
        BasicData basicInstance = new BasicData();

        // Parent 타입을 통해 getClass()를 호출한 자식 인스턴스일수도 있기때문에, 제네릭에서 자식 타입도 허용
        Class<? extends BasicData> basicDataClass2 = basicInstance.getClass();
        System.out.println("basicDataClass2 = " + basicDataClass2); //class ch06reflection.data.BasicData


        // 3.문자로 찾기
        String className = "ch06reflection.data.BasicData";
        Class<?> basicDataClass3 = Class.forName(className);
        System.out.println("basicDataClass3 = " + basicDataClass3);//class ch06reflection.data.BasicData

    }
}
