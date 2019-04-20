package sample.Domain;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CarValidatorTest {

    @Test
    void validateShouldThrowOnlyWhenNecessary() {

        CarValidator validator = new CarValidator();
        Car correctCar = new Car("1", "Seat","200000",500000);
        assertDoesNotThrow(() -> validator.validate(correctCar));

        Car incorrectFormat = new Car("1", "Seat","200000",-500000);
        assertThrows(CarValidatorException.class, () -> validator.validate(incorrectFormat));


    }
}