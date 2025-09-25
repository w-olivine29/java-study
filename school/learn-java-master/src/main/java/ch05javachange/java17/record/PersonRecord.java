package ch05javachange.java17.record;

// 롬복의 @Data 애노테이션 기능과 유사
// 실제 정식기능 확정 버전은 16
public record PersonRecord(String name, int age) {
}
