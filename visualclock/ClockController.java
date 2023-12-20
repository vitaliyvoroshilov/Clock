package com.example.visualclock;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class ClockController {

    CollectionClock collClock = BCollectionClock.build();
    IClock clock;

    @FXML
    Label brand, price, time;

    public void setClock(IClock clock) {
        this.clock = clock;
        brand.setText(clock.getBrand());
        price.setText(Double.toString(clock.getPrice()));
        if (clock.getType() == TypeClock.MinuteClock)
            time.setText(clock.getTime(TypeTime.Hour) + ":" + clock.getTime(TypeTime.Minute));
        else
            time.setText(clock.getTime(TypeTime.Hour) + ":" + clock.getTime(TypeTime.Minute) + ":" + clock.getTime(TypeTime.Second));
    }




    public void removeClock(ActionEvent actionEvent) {
        collClock.remove(clock);
    }
}
