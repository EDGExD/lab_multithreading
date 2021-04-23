package edu.iis.mto.multithread;

public class Launcher {

    public Runnable launch(PatriotBattery battery, int rocketCount, Scud scud) {
        return () -> {
            for (int i = 0; i < rocketCount; i++) {
                battery.launchPatriot(scud);
            }
        };
    }
}