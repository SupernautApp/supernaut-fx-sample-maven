package app.supernaut.fx.sample.maven;

import app.supernaut.fx.FxForegroundApp;
import app.supernaut.fx.FxLauncher;
import app.supernaut.services.BrowserService;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import jakarta.inject.Singleton;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.net.URI;
import java.util.Locale;

@Singleton
public class HelloFX implements FxForegroundApp.FxApplicationCompat {
    private static final Logger log = LoggerFactory.getLogger(HelloFX.class);
    private static final URI projectWebSiteUri = URI.create("https://www.supernaut.app");
    private final BrowserService browserService;

    public HelloFX(BrowserService browserService) {
        log.info("Constructing HelloFX");
        this.browserService = browserService;
    }

    @Override
    public void start(Stage stage) {
        log.info("Starting HelloFX");
        stage.setScene(buildScene());
        stage.setTitle("Supernaut.FX: Hello");
        stage.show();
    }

    private Scene buildScene() {
        var label       = new Label(buildHello());
        var hyperlink   = new Hyperlink("Powered by Supernaut.FX");
        // TODO: Add a test that will set the below boolean to true if JavaFX > forthcoming 18-ea+4
        // See WIP in Supernaut.FX main repo
        boolean addHyperlink = isShowDocumentAvailable();
        var vboxNodes = addHyperlink ? new Node[]{label, hyperlink} : new Node[]{label};
        var vbox        = new VBox(vboxNodes);
        vbox.setAlignment(Pos.CENTER);
        hyperlink.setOnAction(e -> browserService.showDocument(projectWebSiteUri));
        return new Scene(vbox, 500, 100);
    }

    // We're working on a more proper version of this is the main Supernaut.FX repository.
    // This will disable hyperlinks on macOS even on JVM when it only fails on GraalVM native-image
    boolean isShowDocumentAvailable() {
        return !isMacOS();
    }

    private boolean isMacOS() {
        boolean isMacOS = System.getProperty("os.name", "").toLowerCase(Locale.US).contains("mac");
        log.info("isMacOS: {}", isMacOS);
        return isMacOS;
    }

    private String buildHello() {
        var javaVersion = System.getProperty("java.version");
        var javafxVersion = System.getProperty("javafx.version");
        var javaFxRuntimeVersion = System.getProperty("javafx.runtime.version");
        log.info("javafx.version: {}", javafxVersion);
        log.info("javafx.runtime.version: {}", javaFxRuntimeVersion);
        return String.format("Hello, JavaFX  %s running on Java %s",
                javaFxRuntimeVersion, javaVersion);
    }

    public static void main(String[] args) {
        FxLauncher.byName("micronaut").launch(args, HelloFX.class);
    }
}
