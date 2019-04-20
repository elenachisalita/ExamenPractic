package sample.Service;

import sample.Domain.Car;
import sample.Domain.Rent;
import sample.Repository.IRepository;

import java.util.List;

public class RentService {

    private IRepository<Rent> rentRepository;
    private IRepository<Car> carRepository;

    public RentService(IRepository<Rent> rentRepository, IRepository<Car> carRepository) {
        this.rentRepository = rentRepository;
        this.carRepository = carRepository;
    }

    public Rent addOrUpdate(String id, String idRent, String numberOfDays, String usedKm) {
        Rent existing = rentRepository.findById(id);
        if (existing != null) {
            // keep unchanged fields as they were
            if (idRent.isEmpty()) {
                idRent = existing.getIdRent();
            }

            if (numberOfDays.isEmpty()) {
                numberOfDays = existing.getNumberOfDays();
            }

            if (usedKm.isEmpty()) {
                usedKm = existing.getUsedKm();
            }


        }

        Car carRent = carRepository.findById(id);
        if (carRent == null) {
            throw new RuntimeException("There is no car with the given id!");
        }

        Rent rent = new Rent(id, idRent, numberOfDays,usedKm);
        rentRepository.upsert(rent);
        return rent;
    }

    public void remove(String id) {
        rentRepository.remove(id);
    }

    public List<Rent> getAll() {
        return rentRepository.getAll();
    }
}
