package com.example.visualclock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;

import java.io.IOException;
import java.util.Iterator;

public class MainController implements IObserver {

    CollectionClock collClock = BCollectionClock.build();

    public MainController() {
        collClock.sub(this);
    }

    @FXML
    public TextField brand, price, hour, minute, second;

    @FXML
    GridPane allClocks;

    @FXML
    public void addClock(ActionEvent actionEvent) throws IOException, InvalidTime {
        TypeClock typeValue;
        String brandValue;
        double priceValue;
        int hourValue, minuteValue, secondValue;
        if (second.getText().isEmpty()) {
            typeValue = TypeClock.MinuteClock;
            secondValue = 0;
        }
        else {
            typeValue = TypeClock.SecondClock;
            secondValue = Integer.parseInt(second.getText());
        }
        brandValue = brand.getText();
        priceValue = Double.parseDouble(price.getText());
        hourValue = Integer.parseInt(hour.getText());
        minuteValue = Integer.parseInt(minute.getText());
        collClock.add(BClock.build(typeValue, brandValue, priceValue, hourValue, minuteValue, secondValue));
    }

    @Override
    public void event(CollectionClock colClock) {
        allClocks.getChildren().clear();
        for (IClock clock : collClock) {
            try {
                ClockController contr = new ClockController();
                FXMLLoader fxmlLoader = new FXMLLoader(ClockController.class.getResource("clockView.fxml"));
                fxmlLoader.setController(contr);
                Parent root = fxmlLoader.load();
                contr.setClock(clock);
                allClocks.addColumn(0, root);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
