package edu.iis.mto.multithread;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.concurrent.Executor;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(50)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        Executor executor = Runnable::run;
        final int numberOfRockets = 1;
        BetterRadar radar = new BetterRadar(executor,numberOfRockets,batteryMock);
        Scud enemyMissle = new Scud();
        radar.onNotice(enemyMissle);
        verify(batteryMock,times(numberOfRockets)).launchPatriot(enemyMissle);
    }

}
