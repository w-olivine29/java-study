package annotation.custom;

import annotation.custom.validator.Validator;

public class CustomAnnotationMain {
    public static void main(String[] args) {
        CarRequest request = new CarRequest("Kia", 2025);
        Validator.validateYear(request);

        Car car = new Car(request.getModel(), request.getYear());
        System.out.println(car);
    }
}
