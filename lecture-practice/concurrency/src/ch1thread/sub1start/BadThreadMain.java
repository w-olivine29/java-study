package ch1thread.sub1start;

public class BadThreadMain {
    
    // 프로세스가 작동하려면 스레드가 최소한 하나는 있어야 코드 실행 가능
    // 자바는 실행시점에 main 이라는 스레드를 만들고 프로그램의 시작점인 main()를 실행
    public static void main(String[] args) {

        //main 메서드가 아닌 main 이라는 스레드를 뜻함 (자바가 만들어주는 기본 스레드)
        System.out.println(Thread.currentThread().getName() + ": main() start"); //main: main() start

        HelloThread helloThread = new HelloThread();
        System.out.println(helloThread.getName() + ": start() 호출 전"); //Thread-0: start() 호출 전


        //helloThread.run(); //Calls to 'run()' should probably be replaced with 'start()'

        // start가 아닌 run()을 직접 실행할 경우 새로운 스레드가 아닌 현재 스레드에서 run()실행
        // 새로운 스레드 생성 자체가 되지 않음
        helloThread.run();

        System.out.println(helloThread.getName() + ": start() 호출 후"); //Thread-0: start() 호출 후


        System.out.println(Thread.currentThread().getName() + ": main() end"); //main: main() end


        /* 출력 순서 (실행마다 달라질 수 있음, 스레드 간 실행 순서는 보장 x)
        [main] Thread.currentThread().getName() = main
        [main] main: main() start
        [main] Thread-0: start() 호출 전

        [main] main: run()  같은 main 스레드에서 호출해버리는 상황

        [main] Thread-0: start() 호출 후
        [main] main: main() end


        */

    }
}
