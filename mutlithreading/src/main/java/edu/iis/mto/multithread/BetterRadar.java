package edu.iis.mto.multithread;

import java.util.concurrent.Executor;

public class BetterRadar {

    private final Executor executor;
    private final int rocketCount;
    private final PatriotBattery battery;

    public BetterRadar(Executor executor, int rocketCount, PatriotBattery battery) {
        this.executor = executor;
        this.rocketCount = rocketCount;
        this.battery = battery;
    }

    public void onNotice(Scud enemyMissile) {
        executor.execute(() -> {
            for (int i = 0; i < rocketCount; ++i)
                this.battery.launchPatriot(enemyMissile);
        });
    }
}

