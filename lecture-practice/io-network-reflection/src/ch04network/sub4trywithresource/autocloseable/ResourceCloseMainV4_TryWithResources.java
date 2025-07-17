package ch04network.sub4trywithresource.autocloseable;

// 가상의 시나리오
public class ResourceCloseMainV4_TryWithResources {
    public static void main(String[] args) {


        try {
            logic();

        } catch (CallException e) {
            System.out.println("CallException 예외 처리");

            // 핵심 예외에 같이 들어간 예외를 꺼낼 수 있다. (자원 정리중에 발생한 예외들)
            Throwable[] suppressed = e.getSuppressed();
            for (Throwable throwable : suppressed) {
                System.out.println("suppressedEx = " + throwable);
            }
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }

    }

    private static void logic() throws CallException, CloseException {
        
        // 해당 자원의 close() 를 자동으로 호출해준다
        try (ResourceV2_AutoCloseable resource1 = new ResourceV2_AutoCloseable("resource1");
             ResourceV2_AutoCloseable resource2 = new ResourceV2_AutoCloseable("resource2")) {

            resource1.call();
            resource2.callEx(); // CallException 발생

        } catch(CallException e) {
            System.out.println("ex: " + e);
            throw e;
        }

    }
}
/*
resource1call
resource2callEx

나중에 선언한 것을 먼저 닫는 것을 볼 수 있다!
resource2close
resource1close


ex: ch04network.sub4resource.autocloseable.CallException: resource2ex
CallException 예외 처리

현재 close() 내부에 예외를 던지게끔 구현했는데, 출력되는 예외는 핵심예외인 CallException 이다.
try with resource 는 자원을 해제하는 중에 발생된 예외들은 핵심 예외가 아니라고 생각하고 핵심예외에 같이 넣어준다. (Suppressed)
핵심예외에 들어간 예외들을 꺼낼 수도 있다.

suppressedEx = ch04network.sub4resource.autocloseable.CloseException: resource2ex
suppressedEx = ch04network.sub4resource.autocloseable.CloseException: resource1ex

Exception in thread "main" java.lang.RuntimeException: ch04network.sub4resource.autocloseable.CallException: resource2ex
	at ch04network.sub4resource.autocloseable.ResourceCloseMainV4_TryWithResources.main(ResourceCloseMainV4_TryWithResources.java:13)
Caused by: ch04network.sub4resource.autocloseable.CallException: resource2ex
	at ch04network.sub4resource.autocloseable.ResourceV2_AutoCloseable.callEx(ResourceV2_AutoCloseable.java:21)
	at ch04network.sub4resource.autocloseable.ResourceCloseMainV4_TryWithResources.logic(ResourceCloseMainV4_TryWithResources.java:28)
	at ch04network.sub4resource.autocloseable.ResourceCloseMainV4_TryWithResources.main(ResourceCloseMainV4_TryWithResources.java:9)
	Suppressed: ch04network.sub4resource.autocloseable.CloseException: resource2ex
		at ch04network.sub4resource.autocloseable.ResourceV2_AutoCloseable.close(ResourceV2_AutoCloseable.java:28)
		at ch04network.sub4resource.autocloseable.ResourceCloseMainV4_TryWithResources.logic(ResourceCloseMainV4_TryWithResources.java:24)
		... 1 more
	Suppressed: ch04network.sub4resource.autocloseable.CloseException: resource1ex
		at ch04network.sub4resource.autocloseable.ResourceV2_AutoCloseable.close(ResourceV2_AutoCloseable.java:28)
		at ch04network.sub4resource.autocloseable.ResourceCloseMainV4_TryWithResources.logic(ResourceCloseMainV4_TryWithResources.java:24)
		... 1 more
*/

/* try-with-resources 
단순한게 close() 를 자동호출해준다는 정도가 아니었다.
아래 문제들을 해결해준다.

- finally 블럭 안에서 close() 시점 예외발생 시
    - 다른 자원을 닫을 수 없는 문제
    - catch 문으로 잡은 핵심 예외가 사라지고, finally 에서 잡은 부가예외로 바뀌는 문제

- 자원 변수를 선언하면서 동시에 할당 불가 (try, finally 코드 블록과의 변수 스코프가 다른 문제)

- catch 이후에 finally 호출됨으로, 자원정리가 비교적 늦어지던 문제

- 개발자의 실수
    - close() 문 자체를 넣지 않을 가능성
    - close() 호출 순서 실수 (보통 자원 생성 순서 역순으로 닫아야함)

----
장점)
- 자원 누구 방지
    모든 자원이 제대로 닫히도록 보장

- 코드 간결성 & 가독성 향상

- 스코프 범위 한정
    자원으로 사용되는 변수의 스코프가 try 블럭 안으로 한정되어 코드 유지보수 비교적 쉬워짐
    
- 비교적 더 빠른 자원 해제
    try 블럭이 끝나면 즉시 close() 호출
    
- 자원 정리 순서
    먼저 선언한 자원을 나중에 정리하게끔 구현돼있음

- 부가 예외 포함
    catch 문에서 잡은 핵심 예외 안에 Suppressed 로 담아서 반환
    핵심 예외에서 getSuppressed() 를 통해 꺼내서 활용도 가능

*/
