package ch04network.sub4resourcedisposal.autocloseable;

// 가상의 시나리오
public class ResourceCloseMainV3 {
    public static void main(String[] args) {


        try {
            logic();

        } catch (CallException e) { //5.의도한 대로 CallException를 받아서 처리할 수 있게됨
            System.out.println("CallException 예외 처리");
            throw new RuntimeException(e);
        } catch (CloseException e) {
            System.out.println("CloseException 예외 처리");
            throw new RuntimeException(e);
        }

    }

    private static void logic() throws CallException, CloseException {

        // finally 문에서도 사용되어야하기때문에 더 넓은 스코프에서 선언
        ResourceV1 resource1 = null;
        ResourceV1 resource2 = null;
        try {
            resource1 = new ResourceV1("resource1"); // 1. 만약 여기서 예외가 발생하면?
            resource2 = new ResourceV1("resource2"); // 2. 자원2는 null인 상태로 catch문 돌입

            resource1.call();
            resource2.callEx(); // CallException 발생
        } catch (CallException e) {
            System.out.println("ex: " + e);
            throw e;//3. 해당 예외를 밖으로 던지고, 밖에서 처리하기를 원함

        } finally {
            System.out.println("자원 정리");
            
            //4. V2의 문제를 개선하기 위해 finally문 안에서 try-catch 사용
            if (resource2 != null) {
                try {
                    resource2.closeEx();
                } catch (CloseException e) {

                    // 보통 자원 정리 시점에 발생한 예외는 처리할 수 있는 부분이 없는 경우가 많음
                    // close() 에서 발생한 예외는 버리기 (필요하면 로깅를 남긴다)
                    // 버리지 않으면 logic()호출한 곳에서 핵심예외를 받을 수 없음 (V2 참고)
                    System.out.println("close ex: " + e);
                }
            }
            if (resource1 != null) {
                try {
                    resource1.closeEx();
                } catch (CloseException e) {
                    System.out.println("close ex: " + e);
                }
            }
        }

    }
}
/*
- 자원에 관한 변수를 선언하면서 동시 할당 불가 (try, finally 블록 스코프가 다른 문제)
- catch 이후에 finally에 진입하기때문에, 자원정리가 늦어짐
- 개발자가 코딩 중 실수로 close() 넣지 않거나, 호출 순서를 실수 (보통 자원 생성 순서 역순)

next step)
    try-with-resources
*/