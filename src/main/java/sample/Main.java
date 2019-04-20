package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.Domain.*;
import sample.Repository.FileRepository;
import sample.Repository.IRepository;
import sample.Service.CarService;


import java.util.List;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/sample.fxml"));
        Parent root = fxmlLoader.load();

        CarController controller =  fxmlLoader.getController();

        IValidator<Car> carValidator = new CarValidator();
        IRepository<Car> carIRepository= new FileRepository<>(carValidator, "cars.json", Car[].class);

       CarService carService = new CarService(carIRepository);
        carService.add("1","Skoda","3000",2000);
        carService.add("2","Seat","200",24000);


        controller.setServices(carService);

        primaryStage.setTitle("CARS manager");
        primaryStage.setScene(new Scene(root, 650, 500));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
