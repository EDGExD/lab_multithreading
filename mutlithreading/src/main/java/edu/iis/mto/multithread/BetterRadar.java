package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {
    private int rockets;
    private PatriotBattery patriotBattery;
    private ExecutorService executorService;

    public BetterRadar(int rockets, PatriotBattery patriotBattery, ExecutorService executorService) {
        this.rockets = rockets;
        this.patriotBattery = patriotBattery;
        this.executorService = executorService;
    }
    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, rockets);
    }

    private void launchPatriot(Scud enemyMissle, int rocketCount) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < rocketCount; i++) {
                patriotBattery.launchPatriot(enemyMissle);
            }
        };

        executorService.submit(launchPatriotTask);
    }

}
