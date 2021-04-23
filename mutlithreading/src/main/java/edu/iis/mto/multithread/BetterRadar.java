package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {

    private int rocketCount;
    private PatriotBattery battery;
    private ExecutorService executorService;


    public BetterRadar(int rocketCount, PatriotBattery battery, ExecutorService executorService) {
        this.rocketCount = rocketCount;
        this.battery = battery;
        this.executorService = executorService;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle, rocketCount);
    }


        private void launchPatriot(Scud enemyMissle, int rocketCount) {
            Runnable launchPatriotTask = () -> {
                for (int i = 0; i < rocketCount; i++) {
                    battery.launchPatriot(enemyMissle);
                }
            };

            executorService.submit(launchPatriotTask);
        }
}
