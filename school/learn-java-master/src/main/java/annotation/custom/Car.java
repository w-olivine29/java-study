package annotation.custom;

import annotation.custom.annotations.ModelDescriptionPrint;
import annotation.custom.annotations.ModelDescriptionPrints;

import java.util.Arrays;

public class Car {

    private final String model;
    private final Integer year;

    public Car(String model, Integer year) {
        this.model = model;
        this.year = year;
    }

    // 애노테이션의 장점: 부가 기능을 추가할 때 기존 코드를 수정할 필요가 없고 재사용 가능

    /* 특정 모델이 들어오면 해당 문구를 출력
    Ionic: new model
    sonata: steady seller
    avante: compact model
    */

    @ModelDescriptionPrints({
            @ModelDescriptionPrint(model = "Ionic", description = "new model"),
            @ModelDescriptionPrint(model = "sonata", description = "steady seller"),
            @ModelDescriptionPrint(model = "avante", description = "compact model")
    })
    public String getModel() {
        try {
            ModelDescriptionPrint[] annotations = this.getClass().getMethod("getModel").getAnnotationsByType(ModelDescriptionPrint.class);

            Arrays.stream(annotations)
                    .filter(a -> a.model().equals(model))
                    .forEach(a -> System.out.println(a.description()));

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return model;
    }


//    public String getModel() {
        // 해당 로직이 만약 다른 여러곳에서도 적용을 하는 상황 -> 수정발생 시 적용 된 모든 코드들을 찾아서 수정 -> 인적실수 발생 가능성 높음
//        if ("Ionic".equalsIgnoreCase(model)) {
//            System.out.println("new model");
//        } else if ("sonata".equalsIgnoreCase(model)) {
//            System.out.println("steady seller");
//        } else if ("avante".equalsIgnoreCase(model)) {
//            System.out.println("compact model");
//        } else {
//            System.out.println("unknown model");
//        }
//        return model;
//    }

    public Integer getYear() {
        return year;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
