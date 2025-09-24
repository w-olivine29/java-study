package ch02annotation.custom;

import ch02annotation.custom.validator.Validator;

public class CarFactory {

    public static Car create(String model, int year) {
        CarRequest request = new CarRequest(model, year);
        Validator.validateYear(request);

        return request.toCar();
    }
}
