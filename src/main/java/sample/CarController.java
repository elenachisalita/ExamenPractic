package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import sample.Domain.Car;
import sample.Domain.CarValidatorException;
import sample.Service.CarService;

public class CarController {

    public TableView tableViewCars;
    public TableColumn tableColumnId;
    public TableColumn tableColumnModel;
    public TableColumn tableColumnKm;
    public TableColumn tableColumnPrice;

    public TextField txtId;
    public TextField txtModel;
    public TextField txtKm;
    public TextField txtPrice;


    public Button btnAdd;
    public TextField txtSumDay;
    public TextField txtSumResult;
    public Button btnSumForDay;

    private CarService carService;
    private ObservableList<Car> cars = FXCollections.observableArrayList();

    public void btnAddClick(ActionEvent actionEvent) {
        try {
            String id = txtId.getText();
            String model = txtModel.getText();
            String km = txtKm.getText();
            double price = Double.parseDouble(txtPrice.getText());
            carService.add(id, model, km, price);

            txtId.clear();
            txtModel.clear();
            txtKm.clear();
            txtPrice.clear();

            cars.clear();
            cars.addAll(carService.getAll());

        } catch (CarValidatorException idfe) {
            Common.showValidationError(idfe.getMessage());
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }
    }

    public void setServices(CarService carService) {
        this.carService = carService;
    }

    @FXML
    private void initialize() {

        Platform.runLater(() -> {
            cars.addAll(carService.getAll());
            tableViewCars.setItems(cars);
        });
    }


}
