package ch02annotation.custom;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


class CustomAnnotationMainTest {
    @Test
    public void testValidYearRange() {
        Car car = CarFactory.create("BMW", 2021);
        assertThat(car.getYear()).isEqualTo(2021);
    }

    @Test
    public void testInvalidYearRange() {
        // ThrowingCallable 를 파라미터로 받음
        assertThatThrownBy(()-> CarFactory.create("BMW", 2026))
                .isInstanceOf(IllegalArgumentException.class);

        //java.lang.IllegalArgumentException: Invalid year range: 2026 (valid year: 1980 ~2025)
    }


}
