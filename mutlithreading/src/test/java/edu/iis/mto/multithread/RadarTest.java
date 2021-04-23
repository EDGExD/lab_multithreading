package edu.iis.mto.multithread;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

import java.util.concurrent.ExecutorService;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;
    @Mock
    private ExecutorService executorServiceMock;

    @BeforeEach
    void setUp()
    {
        when(executorServiceMock.submit(any(Runnable.class))).thenAnswer(invocation -> {
            ((Runnable) invocation.getArgument(0)).run();
            return null;
        });
    }

    @RepeatedTest(15)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        int rockets=1;
        BetterRadar radar = new BetterRadar(rockets,batteryMock,executorServiceMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, times(rockets)).launchPatriot(enemyMissle);
    }
    @RepeatedTest(15)
    void launchPatriotFiveTimesWhenNoticesFiveScudMissles() {
        int rockets=5;
        BetterRadar radar = new BetterRadar(rockets,batteryMock,executorServiceMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, times(rockets)).launchPatriot(enemyMissle);

    }

    @RepeatedTest(15)
    void launchPatriotZeroTimes() {
        int rockets=0;
        BetterRadar radar = new BetterRadar(rockets,batteryMock,executorServiceMock);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock, times(rockets)).launchPatriot(enemyMissle);

    }
}
