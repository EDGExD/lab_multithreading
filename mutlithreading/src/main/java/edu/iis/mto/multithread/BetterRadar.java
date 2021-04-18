package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private Launcher launcher;
    private int rocketCount;

    public BetterRadar(PatriotBattery battery, Launcher launcher, int rocketCount) {
        this.battery = battery;
        this.launcher = launcher;
        this.rocketCount = rocketCount;
    }

    public void notice(Scud enemyMissile) {
        launchPatriot(enemyMissile);
    }

    private void launchPatriot(Scud enemyMissile) {
        launcher.launch(battery, rocketCount, enemyMissile);
    }
}