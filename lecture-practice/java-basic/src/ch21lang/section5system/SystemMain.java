package ch21lang.section5system;

import java.time.LocalTime;
import java.util.Arrays;
import java.util.Map;
import java.util.Properties;

public class SystemMain {
    public static void main(String[] args) {

        //현재 시간(밀리초)
        long currentTimeMillis = System.currentTimeMillis();
        System.out.println("currentTimeMillis = " + currentTimeMillis);

        //현재 시간 (나노초)
        long currentTimeNano = System.nanoTime();
        System.out.println("currentNanoTime = " + currentTimeNano);


        //환경변수 (운영체제에서 설정한 환경변수 값 얻을 수 있음)
        System.out.println("\n===== System.getenv() =====");

        Map<String, String> environment = System.getenv();
        //System.out.println("environment = " + environment);
        for (String key : environment.keySet()) {
            System.out.printf("key: %s, value: %s\n", key, environment.get(key));
        }


        //시스템 속성 (java)
        System.out.println("\n===== System.getProperties() =====");

        Properties properties = System.getProperties(); //Properties extends Hashtable<Object,Object>
        for (Object key : properties.keySet()) {
            System.out.printf("key: %s, value: %s\n", key, properties.get(key));
        }

        // 특정 속성 가져오기
        System.out.println("java.version: " + properties.get("java.version"));
        System.out.println("java.version: " + System.getProperty("java.version"));


        // 배열 고속복사  (운영체제나 그 밑의 하드웨어 레벨에서 배열을 통째로 복사)
        char[] originalArr = {'A', 'R', 'R', 'A', 'Y', 'F', 'A', 'S', 'T', 'C', 'O', 'P', 'Y'};
        char[] copiedArr = new char[originalArr.length];

        System.arraycopy(originalArr, 0, copiedArr, 0, originalArr.length);
        // Object src,  int  srcPos, Object dest, int destPos, int length
        // src: source, pos: position, dest: destination

        System.out.println(copiedArr); // ARRAYFASTCOPY
        System.out.println("copiedArr: " + Arrays.toString(copiedArr)); // copiedArr: [A, R, R, A, Y, F, A, S, T, C, O, P, Y]

        // 프로그램 종료 (가급적 사용 X)
        System.exit(0);
        // Process finished with exit code 0

        System.out.println("이미 프로그램 종료돼서 출력불가");
    }
}
