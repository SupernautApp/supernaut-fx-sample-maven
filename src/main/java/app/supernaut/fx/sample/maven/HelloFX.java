package app.supernaut.fx.sample.maven;

import app.supernaut.fx.FxForegroundApp;
import app.supernaut.fx.FxLauncher;
import app.supernaut.fx.sample.maven.demo.DataObject;
import app.supernaut.fx.sample.maven.demo.SystemInfo;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.inject.Singleton;

@Singleton
public class HelloFX implements FxForegroundApp.FxApplicationCompat {

    private final DataObject dataObject;
    private final SystemInfo systemInfo;

    public HelloFX(DataObject dataObject, SystemInfo systemInfo) {
        this.dataObject = dataObject;
        this.systemInfo = systemInfo;
    }

    @Override
    public void start(Stage stage) {
        stage.setScene(buildScene());
        stage.setTitle("Supernaut.FX: Hello");
        stage.show();
    }

    private Scene buildScene() {
        var lblJavaVersion = new Label();
        lblJavaVersion.textProperty().bind(dataObject.javaVersion);
        var lblJavaFxVersion = new Label();
        lblJavaFxVersion.textProperty().bind(dataObject.javaFxVersion);
        var lblCounter = new Label();
        lblCounter.textProperty().bind(dataObject.counter.asString());

        var vbox = new VBox(
                new Label("Hello World!"),
                new Label("Running on Java:"),
                lblJavaVersion,
                new Label("With JavaFX:"),
                lblJavaFxVersion,
                new Label("Counter:"),
                lblCounter
        );
        vbox.setAlignment(Pos.CENTER);

        return new Scene(vbox, 350, 400);
    }

    public static void main(String[] args) {
        FxLauncher.byName("micronaut").launch(args, HelloFX.class);
    }
}
