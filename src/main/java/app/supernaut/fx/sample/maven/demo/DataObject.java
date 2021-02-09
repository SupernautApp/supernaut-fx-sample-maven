package app.supernaut.fx.sample.maven.demo;

import javafx.application.Platform;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

import javax.inject.Singleton;

@Singleton
public class DataObject {

    public final StringProperty javaVersion;
    public final StringProperty javaFxVersion;
    public final IntegerProperty counter;

    public DataObject() {
        javaVersion = new SimpleStringProperty();
        javaFxVersion = new SimpleStringProperty();
        counter = new SimpleIntegerProperty(0);
    }

    public synchronized void incrementCounter() {
        Platform.runLater(() -> counter.set(counter.get() + 1));
    }
}
