package sample.Domain;

public class Car extends Entity {

    private String model;
    private String km;
    private double price;

    public Car(String id, String model, String km, double price) {
        super(id);
        this.model = model;
        this.km = km;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Car{" +
                "model='" + model + '\'' +
                ", km='" + km + '\'' +
                ", price=" + price +
                '}';
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getKm() {
        return km;
    }

    public void setKm(String km) {
        this.km = km;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
