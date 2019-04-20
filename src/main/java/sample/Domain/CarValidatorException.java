package sample.Domain;

public class CarValidatorException extends RuntimeException {

    CarValidatorException(String message) {

        super("Car Validator Exception ||| " + message);
    }
}
