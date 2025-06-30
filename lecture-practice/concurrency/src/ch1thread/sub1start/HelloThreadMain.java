package ch1thread.sub1start;

public class HelloThreadMain {
    
    // 프로세스가 작동하려면 스레드가 최소한 하나는 있어야 코드 실행 가능
    // 자바는 실행시점에 main 이라는 스레드를 만들고 프로그램의 시작점인 main()를 실행
    public static void main(String[] args) {

        //main 메서드가 아닌 main 이라는 스레드를 뜻함 (자바가 만들어주는 기본 스레드)
        System.out.println(Thread.currentThread().getName() + ": main() start"); //main: main() start

        HelloThread helloThread = new HelloThread();
        System.out.println(helloThread.getName() + ": start() 호출 전"); //Thread-0: start() 호출 전


        //helloThread.run(); //Calls to 'run()' should probably be replaced with 'start()'

        // run()이 아닌 start()를 호출해야 "별도의 스레드"에서 run() 실행
        // start()메서드는 스레드에 스택 공간을 할당하면서 스레드를 시작하는 중요한 메서드
        helloThread.start();

        System.out.println(helloThread.getName() + ": start() 호출 후"); //Thread-0: start() 호출 후


        System.out.println(Thread.currentThread().getName() + ": main() end"); //main: main() end



        /* 출력 순서 (실행마다 달라질 수 있음, 스레드 간 실행 순서는 보장 x)
        [main] Thread.currentThread().getName() = main
        [main] main: main() start
        [main] Thread-0: start() 호출 전
        
        // 여기서 helloThread.start(); 가 실행완료되기 까지 기다리지 않음
        
        [main] Thread-0: start() 호출 후
        [main] main: main() end
        [Thread-0] Thread-0: run()

        */
    }
}
