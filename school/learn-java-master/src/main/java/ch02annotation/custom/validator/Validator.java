package ch02annotation.custom.validator;

import ch02annotation.custom.CarRequest;
import ch02annotation.custom.annotations.YearRange;

import java.lang.reflect.Field;

public class Validator {

    public static void validateYear(CarRequest request) {
        try {
            // 검증하려는 필드 가져오기
            Field yearField = request.getClass().getDeclaredField("year");
            yearField.setAccessible(true); //private 인 year 필드를 접근가능하게 설정

            // 해당 필드에 적용한 애노테이션 가져오기
            YearRange yearRange = yearField.getAnnotation(YearRange.class);
            int year = request.getYear();

            // 검증
            if (year < yearRange.min() || year > yearRange.max()) {
                throw new IllegalArgumentException(
                        String.format("Invalid year range: %d (valid year: %d ~%d)",
                                request.getYear(), yearRange.min(), yearRange.max()));
            }

        } catch (NoSuchFieldException e) {
            throw new RuntimeException(e);
        }
    }
}
