package edu.iis.mto.multithread;

public class Launcher {

    public void launch(PatriotBattery battery, int rocketCount, Scud scud) {
        Runnable launchPatriotTask = new Runnable() {

            @Override
            public void run() {
                for (int i = 0; i < rocketCount; i++) {
                    battery.launchPatriot(scud);
                }
            }
        };

        Thread launchingThread = new Thread(launchPatriotTask);
        launchingThread.start();
    }
}