package ch08optional.sub4lazyevaluation;

import java.util.function.Supplier;

// 일반적인 상황에서는 로그를 남기지 않다가, 디버깅이 필요한 경우에만 디버깅용 로그 추가
public class Logger {
    private boolean isDebug;

    public boolean isDebug(){
        return isDebug;
    }

    public void setDebug(boolean debug) {
        isDebug = debug;
    }

    // DEBUG로 설정한 경우만 출력 - 데이터를 받음
    public void debug(Object message){
        if(isDebug){
            System.out.println("[DEBUG] " + message);
        }
    }

    // 지연연산용 추가
    // DEBUG로 설정한 경우만 출력 - 데이터를 받음
    public void debug(Supplier<?> supplier){
        if(isDebug){
            System.out.println("[DEBUG] " + supplier.get());
        }
    }

}