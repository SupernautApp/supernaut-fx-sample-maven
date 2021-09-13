/**
 * Java Module definitions for HelloFX, the minimal SupernautFX Gradle Sample
 */
module hellofx {
    requires javafx.graphics;
    requires javafx.controls;

    requires app.supernaut.fx;
    requires app.supernaut.fx.micronaut;  // Needed (for now) on Maven toolchain but shouldn't be
    requires jakarta.inject;

    requires io.micronaut.inject;   // Needed for Micronaut-generated classes,
    requires io.micronaut.core;     // This is needed by our Maven toolchain, but not by Gradle

    requires org.slf4j;

    opens app.supernaut.fx.sample.maven to javafx.graphics, java.base;
    exports app.supernaut.fx.sample.maven;

    uses app.supernaut.fx.FxLauncher;
}
