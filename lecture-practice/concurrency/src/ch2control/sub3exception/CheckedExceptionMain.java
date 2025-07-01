package ch2control.sub3exception;

import static util.ThreadUtils.sleep;

public class CheckedExceptionMain {
    public static void main(String[] args) throws Exception {
        throw new Exception();
    }

    static class checkedRunnable implements Runnable {
/*        @Override
        public void run() throws Exception { //overridden method does not throw 'java.lang.Exception'
            throw new Exception();
        }*/


        @Override
        public void run() {
            sleep(1000); // 원활한 실습을 위해 전용 유틸 메서드 사용
        }
    }

    /*
     자식 메서드는 부모 메서드가 던진 체크 예외와 그 하위 타입만 던질 수 있다.

     만약 자식 인스턴스가 더 넓은 범위의 체크예외를 던질 수 있는 상황이라면

     자식 인스턴스를 부모타입으로 참조할 때 컴파일러는 부모타입의 메서드 시그니처만 확인 (어떤 클래스의 메서드가 호출될지는 런타임에 결정됨)
     체크 예외는 컴파일 시점에 처리 여부를 검증하는데, 이런 경우 컴파일러가 모든 가능한 예외를 미리 알 수 없게 됨

     실제로는 재정의된 자식 메서드가 실행되어 해결하지 못한 체크 예외 발생 가능
     -> 결국 체크예외로서의 근본 취지가 무너진다
     

     Runnable 의 run() 은 체크예외를 던지지 않기때문에, 재정의한 메서드에서도 체크예외를 던질 수 없다
    */
}
