package edu.iis.mto.multithread;

public class BetterRadar {

    private PatriotBattery battery;
    private TaskService taskService;

    public BetterRadar(PatriotBattery battery, TaskService taskService) {
        this.battery = battery;
        this.taskService = taskService;
    }

    public void notice(Scud enemyMissle) {
        launchPatriot(enemyMissle);
    }

    private void launchPatriot(Scud enemyMissle) {
        Runnable launchPatriotTask = () -> {
            for (int i = 0; i < 10; i++) {
                battery.launchPatriot(enemyMissle);
            }
        };
        taskService.getTask(launchPatriotTask);
    }
}
