package annotation.custom;

import annotation.custom.annotations.YearRange;

public class CarRequest { // 이런 DTO 클래스들은 Record(java 14+) 적용 가능 (실습과 무관한 주제이기 때문에 제외)

    private final String model;

    // 1980 ~ 2025년 사이에 제조된 자동차만 허용한다는 비즈니스 로직
    @YearRange(min = 1980, max = 2025)
    private final Integer year;

    public CarRequest(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    public String getModel() {
        return model;
    }

    public Integer getYear() {
        return year;
    }

    public Car toCar() {
        return new Car(model, year);
    }


}
