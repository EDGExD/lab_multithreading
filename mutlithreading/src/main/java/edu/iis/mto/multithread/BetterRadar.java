package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private final int ROCKET_COUNT;
    private PatriotBattery battery;
    private Executor rocket_handler;

    public BetterRadar(PatriotBattery battery, int rocket_count, Executor rocket_handler) {
        this.battery = battery;
        this.rocket_handler = rocket_handler;
        this.ROCKET_COUNT = rocket_count;
    }

    public BetterRadar(PatriotBattery battery, int rocket_count) {
        this(battery, rocket_count, Runnable::run);
    }

    public BetterRadar(PatriotBattery battery) {
        this(battery, 1);
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, ROCKET_COUNT);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
        Runnable launchPatriotTask = () -> {
            battery.launchPatriot(enemyMissle);
        };

        for (int i = 0; i < ROCKET_COUNT; i++) {
            rocket_handler.execute(launchPatriotTask);
        }
    }
}
