package ch21lang.section3wrapper.sub2javawapper.step1;

public class WrapperClassMain {
    public static void main(String[] args) {

        // 참고) Integer(int)' is deprecated since version 9 and marked for removal
        // Deprecated된 경우, 일반적으로 대체할 API가 주석이나 문서로 안내됨
        Integer newInteger = new Integer(10);

        //Unnecessary boxing
        Integer intObj = Integer.valueOf(10);
        Long longObj = Long.valueOf(10L);
        Double doubleObj = Double.valueOf(10.0);


        // toString()이 오버라이딩돼있어서 값으로 출력
        System.out.println("intObj = " + intObj);
        System.out.println("longObj = " + longObj);
        System.out.println("doubleObj = " + doubleObj);


        //wrapper 클래스 내부 값
        System.out.println("==== 내부 값 읽기 ====");

        //Unnecessary unboxing
        int intValue = intObj.intValue();
        long longValue = longObj.longValue();
        double doubleValue = doubleObj.doubleValue();

        System.out.println("intValue = " + intValue);
        System.out.println("longValue = " + longValue);
        System.out.println("doubleValue = " + doubleValue);


        System.out.println("=== 비교 ======");

        //객체참조값 비교
        System.out.println("intObj == newInteger -> " + (intObj == newInteger)); //false

        System.out.println("intObj == newInteger -> " + (intObj == Integer.valueOf(intObj.intValue()))); //true (캐싱객체 -> 동일 참조값)
        System.out.println("intObj == newInteger -> " + (intObj == Integer.valueOf(10)));  //true (캐싱객체 -> 동일 참조값)

        //객체내부값 비교
        System.out.println("intObj.equals(newInteger) -> " + (intObj.equals(newInteger))); //true (내부값 비교  equals() 오버라이딩)
    }



    /* valueOf(int) 써야하는 이유

    -128부터 127 사이의 정수는 Integer 객체로 미리 캐싱
    valueOf(int)는 이 범위 안의 숫자일 경우, 기존에 생성된 객체를 재사용
    but, new Integer(10)은 항상 새로운 객체를 생성

    @IntrinsicCandidate
    public static Integer valueOf(int i) {
        if (i >= IntegerCache.low && i <= IntegerCache.high)
            return IntegerCache.cache[i + (-IntegerCache.low)];
        return new Integer(i);
    }
    */
}
