package ch10parallelstream.sub2forkjoinframework.step2commonpool;

import ch10parallelstream.sub2forkjoinframework.SumTask;

import java.util.List;
import java.util.concurrent.ForkJoinPool;
import java.util.stream.IntStream;

import static ch10parallelstream.util.MyLogger.log;

// 버전1이랑 비교하면서 보기
public class ForkJoinMain2 {
    public static void main(String[] args) {

        // 현재 환경의 사용가능한 cpu 코어개수
        int processorsCount = Runtime.getRuntime().availableProcessors();
        ForkJoinPool commonPool = ForkJoinPool.commonPool(); // 해당 코드 없어도 정상작동 (그저 해당 인스턴스 출력용)
        log(String.format("processorCount = %d, commonPool = %s", processorsCount, commonPool.getParallelism()));


        List<Integer> data = IntStream.rangeClosed(1, 8)
                .boxed()
                .toList();

        log("[생성]" + data);

        long startTime = System.currentTimeMillis();
        SumTask task = new SumTask(data);

        // ForkJoinMain1 처럼 별도의 스레드풀을 만들고 지정해서 사용하지 않고,
        // task 에서 직접 invoke 호출 시 공용 풀 사용
        Integer result = task.invoke();// 공용 풀 사용 (현재 코드까지는 main 스레드에서 작동)
        // 호출한 스레드가 작업을 도우면서 블로킹 후 작업결과 반환 받음 (대기하지않고 비동기로 호출하고싶으면, invoke() 대신에 fork() 호출)

        long endTime = System.currentTimeMillis();

        log("time: " + (endTime - startTime) + "ms, sum: " + result); // 총 2초 소요
        log("pool: " + commonPool); //[Terminated, parallelism = 10, size = 0, active = 0, running = 0, steals = 4, tasks = 0, submissions = 0]

    }
}

/*
- 해당 코드에서 사용한 invoke() 는 현재 스레드(main 스레드) 에서 작업을 시작하나,
  fork() 로 작업 분할 후에는 공용 풀의 워커 스레드들이 분할된 작업 처리
    - 메인스레드가 별도의 스레드 풀이 아닌 RecursiveTask 의 invoke() 호출 시 메인 스레드가 task의 compute() 호출
      이 때 내부에서 fork() 호출 시 공용 풀의 워커 스레드로 작업이 분할됨
      
- main 스레드는 최종 결과가 나올 때까지 블로킹해야함 -> 따라서 그냥 대기하는 것보다는 작업을 도와주는 편이 더욱 효율적
  - 실행결과를 보면 main 스레드도 작업처리에 참여하는 것을 볼 수 있음

공용 풀은 JVM이 종료될 때까지 계속 유지되므로, 별도로 풀을 종료하지 않아도 됨 (shutdown())
ForkJoinPool.commonPool 활용 시 별도로 풀 생성 & 관리 하는 코드를 작성하지 않아도 병렬 처리 구현 가능
*/

/* 실행순서 보장x
21:48:15.178 [     main] processorCount = 20, commonPool = 19
21:48:15.180 [     main] [생성][1, 2, 3, 4, 5, 6, 7, 8]
21:48:15.181 [     main] [분할] [1, 2, 3, 4, 5, 6, 7, 8] -> LEFT: [1, 2, 3, 4], RIGHT: [5, 6, 7, 8]
21:48:15.182 [     main] [분할] [5, 6, 7, 8] -> LEFT: [5, 6], RIGHT: [7, 8]
21:48:15.182 [ForkJoinPool.commonPool-worker-1] [분할] [1, 2, 3, 4] -> LEFT: [1, 2], RIGHT: [3, 4]
21:48:15.182 [ForkJoinPool.commonPool-worker-2] [처리 시작][5, 6]
21:48:15.182 [ForkJoinPool.commonPool-worker-1] [처리 시작][3, 4]
21:48:15.182 [     main] [처리 시작][7, 8]
21:48:15.183 [ForkJoinPool.commonPool-worker-3] [처리 시작][1, 2]
21:48:15.185 [ForkJoinPool.commonPool-worker-2] calculate 5 -> 50
21:48:15.185 [     main] calculate 7 -> 70
21:48:15.185 [ForkJoinPool.commonPool-worker-1] calculate 3 -> 30
21:48:15.185 [ForkJoinPool.commonPool-worker-3] calculate 1 -> 10
21:48:16.189 [ForkJoinPool.commonPool-worker-2] calculate 6 -> 60
21:48:16.189 [     main] calculate 8 -> 80
21:48:16.189 [ForkJoinPool.commonPool-worker-1] calculate 4 -> 40
21:48:16.189 [ForkJoinPool.commonPool-worker-3] calculate 2 -> 20
21:48:17.203 [ForkJoinPool.commonPool-worker-1] [처리 완료] [3, 4] -> sum: 70
21:48:17.203 [ForkJoinPool.commonPool-worker-3] [처리 완료] [1, 2] -> sum: 30
21:48:17.203 [ForkJoinPool.commonPool-worker-2] [처리 완료] [5, 6] -> sum: 110
21:48:17.205 [     main] [처리 완료] [7, 8] -> sum: 150
21:48:17.205 [     main] LEFT[110] RIGHT[150] -> sum: 260
21:48:17.205 [ForkJoinPool.commonPool-worker-1] LEFT[30] RIGHT[70] -> sum: 100
21:48:17.205 [     main] LEFT[100] RIGHT[260] -> sum: 360
21:48:17.211 [     main] time: 2024ms, sum: 360
21:48:17.211 [     main] pool: java.util.concurrent.ForkJoinPool@1de0aca6[Running, parallelism = 19, size = 3, active = 0, running = 0, steals = 3, tasks = 0, submissions = 0]
*/



/* 공용 풀 vs 커스텀 풀

- 자원관리
   - 커스텀 풀: 명시적 생성 & 관리
   - 공용 풀: 시스템에서 자동 관리

- 재사용성
   - 공용 풀: 여러 곳에서 공유할 수 있어 자원을 효율적으로 사용 가능

- 설정 제어
   - 커스텀 풀: 병렬 수준(스레드 숫자), 스레드 팩토리 등 세부적 제어 가능
   - 공용 풀: 기본 설정 사용 (시스템 속성으로 변경은 가능하지만 권장 x)

- 라이프사이클
   - 커스텀 풀: 명시적 종료
   - 공용 풀: JVM이 관리 (별도 종료 필요 x)
*/



/* 공용 풀이 스레드를 "CPU 코어수 -1" 만큼 생성하는 이유 (세부내용은 pdf 참고)
- 메인스레드의 참여
- 다른 프로세스와의 자원 경쟁 고려
- 효율적인 자원 활용
*/
