package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.Spinner;
import javafx.scene.control.TextField;
import sample.Service.RentService;
import javafx.stage.Stage;

public class RentController {

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
