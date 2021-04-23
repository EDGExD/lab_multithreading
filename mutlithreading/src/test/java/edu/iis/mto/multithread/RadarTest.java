package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;
    @Mock
    TaskService taskService;

    @BeforeEach
    void init(){
        doAnswer(call -> {
            Runnable runnable = call.getArgument(0);
            runnable.run();
            return null;
        }).when(taskService).getTask(any());
    }

    @RepeatedTest(20)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        BetterRadar radar = new BetterRadar(batteryMock, taskService, 1);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

    @RepeatedTest(20)
    public void launchPatriotFiveTimesWhenNoticesFiveScudMissle() {
        BetterRadar betterRadar = new BetterRadar(batteryMock, taskService, 5);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(5)).launchPatriot(enemyMissle);
    }

}
