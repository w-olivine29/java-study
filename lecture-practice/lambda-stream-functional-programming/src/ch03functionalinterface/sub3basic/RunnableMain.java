package ch03functionalinterface.sub3basic;

// 입력값 x, 반환값 x
// 대표 사용 예시: 스레드 실행(멀티 스레드)
public class RunnableMain {
    public static void main(String[] args) {

        // 익명클래스
        Runnable runnableMain1 = new Runnable(){
            @Override
            public void run() {
                System.out.println("RunnableMain.run");
            }
        };
        runnableMain1.run();

        // 람다
        Runnable runnable2 = () -> System.out.println("RunnableMain.run");
        runnable2.run();
    }
}
