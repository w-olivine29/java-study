package ch07stream.sub1start;

import java.util.List;
import java.util.stream.Stream;

public class StreamStartMain {
    public static void main(String[] args) {
        List<String> names = List.of("Cheddar","Gouda","Brie","Camembert","Emmental","Gorgonzola");

        // "G" 로 시작하는 이름만 필터 후 대문자로 바꾸기
        Stream<String> stream = names.stream();
        List<String> result = stream
                // 중간연산 (반환타입: Stream<?>)
                .filter(name -> name.startsWith("G"))
                .map(String::toUpperCase) // name -> name.toUpperCase()
                .toList(); // 최종연산 (반환타입: List<?>)

        System.out.println("result = " + result); //result = [GOUDA, GORGONZOLA]


        System.out.println("=== 외부 반복 =========================================");
        for (String s : result) {
            System.out.println(s);
        }


        System.out.println("=== 내부 반복 =========================================");
        names.stream()
                // 중간연산 (반환타입: Stream<?>)
                .filter(name -> name.startsWith("G"))
                .map(String::toUpperCase) // name -> name.toUpperCase()
                
                // 최종연산 (반환타입: void)
                .forEach(System.out::println); //name -> System.out.println(name)
    }
}
/*
스트림(Stream)
데이터의 흐름을 추상화해서 다루는 도구

컬렉션 or 배열 등의 요소들을 연산 파이프라인을 통해 연속적인 형태로 처리
    
파이프라인
   마치 물이 여러 파이프(관)을 타고 이동하면서 정수 시설이나 필터를 거치는 과정과 유사
   어떠한 연산이나 기능의 결과값을 다음 연산 or 기능에서 입력값으로 받아서 수행하는 형태가 반복 (체이닝 구조)


스트림 특징
- 데이터 소스 변경 x
    스트림에서 제공하는 연산들은 원본 컬렉션을 변경하지 않고 결과만 새로 생성
    
- 일회성
    한번 사용된 스트림은 재사용 불가 (필요 시 새로 스트림 생성)

- 파이프라인 구성
    중간연산이 이어지다가, 최종연산 등을 만나면 종료
        중간연산 예시) filter, map ...
        최종연산 예시) toList, forEach, collect, reduce ...

- 지연연산
    중간 연산은 필요할 때까지 실제로 동작 x
    최종 연산이 실행될 떄 한 번에 처리

- 병렬처리
    스트림으로부터 병렬 스트림을 쉽게 만들 수 있어서, 
    멀티코어 환경에서 병렬 연산을 비교적 단순화 코드로 작성가능
*/