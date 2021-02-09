/**
 *
 */
module hellofx {
    requires javafx.graphics;
    requires javafx.controls;

    requires app.supernaut.fx;
    requires app.supernaut.fx.micronaut;  // Needed (for now) on Maven toolchain but shouldn't be
    requires javax.inject;

    requires io.micronaut.inject;   // Needed for Micronaut-generated classes,
    requires io.micronaut.core;     // This is needed by our Maven toolchain, but not by Gradle

    requires org.slf4j;
    requires java.logging;

    opens app.supernaut.fx.sample.maven to javafx.graphics, java.base;
    exports app.supernaut.fx.sample.maven;
    exports app.supernaut.fx.sample.maven.demo;

    uses app.supernaut.fx.FxLauncher;
}