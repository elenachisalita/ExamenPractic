package sample.Service;

import sample.Domain.Car;

import sample.Repository.IRepository;

import java.util.List;

public class CarService {

    private IRepository<Car> repository;

    /**
     * Constructs a service.
     * @param repository the backing repository.
     */
    public CarService(IRepository<Car> repository) {
        this.repository = repository;
    }


    public void add(String id, String model, String km,double price) {
        Car car = new Car(id, model, km, price);
        repository.upsert(car);
    }


    /**
     * Gets a list of all cars.
     * @return a list of all cars.
     */
    public List<Car> getAll() {
        return repository.getAll();
    }
}
