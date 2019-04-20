package sample;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.stage.Stage;
import sample.Domain.Car;
import sample.Domain.CarValidatorException;
import sample.Service.CarService;
import sample.Service.RentService;

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


    public TableView tableViewRents;
    public TableColumn tableColumnIdRent;
    public TableColumn tableColumnNumberOfDays;
    public TableColumn tableColumnKmUsed;

    public Spinner spnId;
    public Spinner spnIdCar;
    public TextField txtNumberOfDays;
    public TextField txtKmUsed;

    public Button btnAddRent;
    public Button btnCancel;
    private RentService service;

    public void setService(RentService service) {
        this.service = service;
    }

    public void btnRentAddClick(ActionEvent actionEvent) {
        try {
            String id = String.valueOf(spnId.getValue());
            String idCar = String.valueOf(spnIdCar.getValue());
            String numberOfDays = txtNumberOfDays.getText();
            String kmUsed = txtKmUsed.getText();
            service.addOrUpdate(id, idCar,numberOfDays,kmUsed);
            btnCancelClick(actionEvent);
        } catch (RuntimeException rex) {
            Common.showValidationError(rex.getMessage());
        }

    }


    public void btnCancelClick(ActionEvent actionEvent) {
        Stage stage = (Stage) btnCancel.getScene().getWindow();
        stage.close();
    }


}
