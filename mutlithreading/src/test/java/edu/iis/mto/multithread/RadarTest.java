package edu.iis.mto.multithread;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.ExecutorService;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;
    @Mock
    private ExecutorService executorService;
    @BeforeEach
    void prepare() {
        when(executorService.submit(any(Runnable.class))).thenAnswer(invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;
        });
    }
    @RepeatedTest(20)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        int rocketCount=1;
        BetterRadar betterRadar = new BetterRadar(batteryMock,rocketCount,executorService);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissle);
    }
    @RepeatedTest(20)
    void launchPatriotMultipleTimesWhenNoticesAScudMissle() {
        int rocketCount=25;
        BetterRadar betterRadar = new BetterRadar(batteryMock,rocketCount,executorService);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissle);
    }
    @RepeatedTest(20)
    void launchPatriotZeroWhenNoScudMissle() {
        int rocketCount=0;
        BetterRadar betterRadar = new BetterRadar(batteryMock,rocketCount,executorService);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(rocketCount)).launchPatriot(enemyMissle);
    }

}
