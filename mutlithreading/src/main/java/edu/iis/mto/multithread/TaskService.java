package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TaskService {

    ExecutorService executorService = Executors.newFixedThreadPool(1);

    void getTask(Runnable task){
        executorService.submit(task);
    }
}
