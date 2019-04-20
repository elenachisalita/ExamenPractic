package sample.Domain;

public class CarValidator implements IValidator<Car> {


    public void validate(Car car) {

        String errors="";
        if (car.getPrice() <= 0) {

            errors+="the price must be > 0";
        }
    }
}
