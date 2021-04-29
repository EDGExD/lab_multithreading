package edu.iis.mto.multithread;

import java.util.concurrent.ExecutorService;
import org.junit.jupiter.api.RepeatedTest;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.extension.ExtendWith;
import static org.mockito.ArgumentMatchers.any;
import org.mockito.Mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.when;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @Mock
    private ExecutorService executor;
    
    @RepeatedTest(30)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        when(executor.submit(any(Runnable.class))).thenAnswer(invocation -> {((Runnable) invocation.getArgument(0)).run();return null;});
        
        BetterRadar betterRadar = new BetterRadar(executor, 1, batteryMock);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(1)).launchPatriot(enemyMissle);
    }

    @RepeatedTest(30)
    void launchPatriotFiveTimesWhenNoticesAScudMissle() {
        when(executor.submit(any(Runnable.class))).thenAnswer(invocation -> {((Runnable) invocation.getArgument(0)).run();return null;});
        
        BetterRadar betterRadar = new BetterRadar(executor, 5, batteryMock);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(5)).launchPatriot(enemyMissle);
    }
    
    @RepeatedTest(30)
    void noLaunchPatriot() {
        when(executor.submit(any(Runnable.class))).thenAnswer(invocation -> {((Runnable) invocation.getArgument(0)).run();return null;});
        
        BetterRadar betterRadar = new BetterRadar(executor, 0, batteryMock);
        Scud enemyMissle = new Scud();
        betterRadar.notice(enemyMissle);
        verify(batteryMock, times(0)).launchPatriot(enemyMissle);
    }
}
