/**
 *
 */
module hellofx {
    requires javafx.graphics;
    requires javafx.controls;

    requires app.supernaut.fx;
    requires javax.inject;

    /* Not needed see module JavaDoc comment above */
    requires app.supernaut.fx.micronaut;  // Needed (for now) on Maven toolchain but shouldn't be

    /* Needed for Micronaut-generated classes, see JavaDoc comment above */
    requires io.micronaut.inject;
    requires io.micronaut.core;  // This is needed by our Maven toolchain, but not by Gradle

//    requires org.slf4j;
//    requires java.logging;

    opens app.supernaut.fx.sample.maven to javafx.graphics, java.base;
    exports app.supernaut.fx.sample.maven;

    uses app.supernaut.fx.FxLauncher;
}