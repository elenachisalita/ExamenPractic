package sample.Service;

import org.junit.jupiter.api.Test;
import sample.Domain.Car;
import sample.Domain.CarValidator;
import sample.Repository.FileRepository;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CarServiceTest {

    @Test
    void addShoulAddTheGivenCar() {

        CarValidator validator = new CarValidator();
        FileRepository<Car> repository = new FileRepository<>(validator, "test1.json", Car[].class);
        CarService service = new CarService(repository);

        service.add("1", "Porsche", "test", 432423);
        List<Car> all = service.getAll();
        assertEquals(1, all.size());
        assertEquals("Porsche", all.get(0).getModel());
        assertEquals("test", all.get(0).getKm());
        assertEquals(432423, all.get(0).getPrice());

    }
}