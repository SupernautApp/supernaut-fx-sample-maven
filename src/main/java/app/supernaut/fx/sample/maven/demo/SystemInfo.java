package app.supernaut.fx.sample.maven.demo;

import javax.inject.Singleton;
import java.util.Timer;
import java.util.TimerTask;

@Singleton
public class SystemInfo {

    private final DataObject dataObject;

    public SystemInfo(DataObject dataObject) {
        this.dataObject = dataObject;

        init();

        Timer timer = new Timer(true);
        timer.scheduleAtFixedRate(new CountIncrementer(), 0, 1000);
    }

    private void init() {
        dataObject.javaVersion.set(System.getProperty("java.version"));
        dataObject.javaFxVersion.set(System.getProperty("javafx.version"));
    }

    private class CountIncrementer extends TimerTask {
        @Override
        public void run() {
            dataObject.incrementCounter();
            System.out.println("Incremented to " + dataObject.counter.get());
        }
    }
}
