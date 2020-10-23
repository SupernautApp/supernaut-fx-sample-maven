package app.supernaut.fx.sample.maven;

import app.supernaut.BackgroundApp;
import app.supernaut.fx.FxForegroundApp;
import app.supernaut.fx.FxLauncher;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

import javax.inject.Singleton;

@Singleton
public class HelloFX implements FxForegroundApp.FxApplicationCompat  {

    @Override
    public void start(Stage stage) {
        String javaVersion = System.getProperty("java.version");
        String javafxVersion = System.getProperty("javafx.version");
        Label l = new Label("Hello, JavaFX " + javafxVersion + ", running on Java " + javaVersion + ".");
        Scene scene = new Scene(new StackPane(l), 640, 480);
        stage.setScene(scene);
        stage.show();
    }

    /**
     * Background application that runs without UI (JavaFX)
     */
    @Singleton
    static class MinimalBackgroundApp implements BackgroundApp {
        @Override
        public void start() {
        }
    }


    public static void main(String[] args) {
        FxLauncher.byName("micronaut").launch(args, HelloFX.class, MinimalBackgroundApp.class);
    }

}
