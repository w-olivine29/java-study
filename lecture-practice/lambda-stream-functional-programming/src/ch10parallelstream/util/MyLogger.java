package ch10parallelstream.util;

import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

// 스레드 학습 시에 사용할 유틸클래스
public abstract class MyLogger {

    // 현재 시간을 원하는 포맷으로 출력하기 위함
    private static final DateTimeFormatter formatter
            = DateTimeFormatter.ofPattern("HH:mm:ss.SSS"); //시, 분, 초 , 미리초

    public static void log(Object obj) {
        String time = LocalTime.now().format(formatter);

        //현재 시간, 현재스레드 이름, 객체
        System.out.printf("%s [%9s] %s\n", time, Thread.currentThread().getName(), obj);
    }
}
