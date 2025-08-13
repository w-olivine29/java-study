package ch08optional.sub4lazyevaluation;

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
}
