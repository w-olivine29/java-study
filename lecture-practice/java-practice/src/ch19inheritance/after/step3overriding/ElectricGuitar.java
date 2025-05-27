package ch19inheritance.after.step3overriding;


public class ElectricGuitar extends Guitar {

    private boolean isConnectedToAmp;


    /*   @Override 재정의
        Guitar의 checkStatus 가 아닌 ElectricGuitar의 checkStatus 가 호출된다.
        @Override 가 없다고 컴파일오류가 뜨진 않는다. (선언한 타입의 인스턴스에서 특정 메서드를 먼저 찾기때문에)
        but 컴파일 오류에서 실수를 잡아내기 위한 용도 + 코드의 명확성

        부모클래스에 없는 메서드에 @Override를 붙이면 컴파일 오류가 뜸
        method does not override or implement a method from a supertype
    */
    @Override
    public void checkStatus() {
        if (!isTuned) {
            System.out.println("튜닝 전 상태");
        }

        if (!isConnectedToAmp) {
            System.out.println("앰프 미연결상태");
        }
    }

    public void connectToAmp() {
        isConnectedToAmp = true;
        System.out.println("앰프 연결완료");
    }

    public void disconnectFromAmp() {
        isConnectedToAmp = false;
        System.out.println("앰프 연결 해제");
    }
}

/* 오버라이딩 조건
- 메서드 이름, 반환타입, 메서드 파라미터정보(타입,순서,개수) -> 같아야함
- 접근 제어자 -> 더 제한적일 수 없음
- 예외 -> 더 많은 체크 예외 throws 불가 (예외 챕터 참조)
- static, final, private -> 불가
- 생성자 -> 불가
* */
