package ch04network.sub4trywithresource.autocloseable;

// 가상의 시나리오
public class ResourceCloseMainV2_Finally {
    public static void main(String[] args) {

        // 8. 내부에서 CallException 이 발생했음에도 불구하고, CloseException 만 잡게됨 (발생했던 CallException 에 대한 처리는 못하고 무시됨)
        // 로직에서 발생한 핵심적인 예외는 CallException 이다. (이 예외가 모든 문제의 원인)
        //그러나 해당 로직에서 받는 예외는  finally에서 발생한 CloseException...
        try {
            logic();
        } catch (CallException e) {
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
            //4. 자원2가 null인 상태에서 메서드 호출하는 상황발생 -> 예외 발생  -> try문 탈출
            //5. 자원2보다 늦게 반납하는 자원1은 자원반납 불가
            //6. 위의 상황을 방지하기 위해 각 자원에 대해 null 체크 조건문을 넣었다
            
            if(resource2 != null){
                resource2.closeEx(); //6. 그러나 조건문 안에서 또 예외가 발생한다면...?
            }
            if(resource1 != null){ //7. 해당 자원 반납 못하고 try문 탈출
                resource1.closeEx();
            }
        }

    }
}
/*
- close() 시점에 예외가 던져지면, 다른 자원을 닫을 수 없는 문제
- finally 블럭 안에서 자원을 close() 할 때 예외 발생 시
    핵심 예외가 finally 에서 발생한 부가 예외로 바뀌어버린다.
*/