package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;

public class BetterRadar {
    private final PatriotBattery patriotBattery;
    private final int rocketCount;
    private final ExecutorService executorService;

    public BetterRadar(PatriotBattery patriotBattery, int rocketCount,ExecutorService executorService) {
        this.patriotBattery = patriotBattery;
        this.rocketCount=rocketCount;
        this.executorService=executorService;
    }

    public notice(){

    }
}
