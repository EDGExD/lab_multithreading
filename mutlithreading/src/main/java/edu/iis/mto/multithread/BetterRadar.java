/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package edu.iis.mto.multithread;
import java.util.concurrent.ExecutorService;

/**
 *
 * @author Karol
 */
public class BetterRadar {
    
    private int numberOfRockets;
    private PatriotBattery battery;
    private ExecutorService executor;
    


    public BetterRadar(ExecutorService executor, int rocketCount, PatriotBattery battery) {
        this.executor = executor;
        this.numberOfRockets = rocketCount;
        this.battery = battery;
    }

    public void launchPatriot(Scud enemy) {
        Runnable launchRockets = () -> {
            for (int i = 0; i < numberOfRockets; i++) {
                battery.launchPatriot(enemy);
            }
        };
        executor.submit(launchRockets);
    }

    public void notice(Scud enemy) {
        launchPatriot(enemy);
    }
}
