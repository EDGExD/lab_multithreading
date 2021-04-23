package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private TaskService taskService;
    private int numberOfMissles;

    public BetterRadar(PatriotBattery battery, TaskService taskService, int numberOfMissles) {
        this.battery = battery;
        this.taskService = taskService;
        this.numberOfMissles = numberOfMissles;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < numberOfMissles; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
        taskService.getTask(launchPatriotTask);
    }
}
