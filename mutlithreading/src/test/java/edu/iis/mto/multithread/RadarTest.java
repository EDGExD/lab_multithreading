package edu.iis.mto.multithread;

import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.verify;

@ExtendWith(MockitoExtension.class)
class RadarTest {

    @Mock
    private PatriotBattery batteryMock;

    @RepeatedTest(100)
    void launchPatriotOnceWhenNoticesAScudMissle() {
        Launcher launcher = new Launcher();
        BetterRadar radar = new BetterRadar(batteryMock,launcher,1);
        Scud enemyMissle = new Scud();
        radar.notice(enemyMissle);
        verify(batteryMock).launchPatriot(enemyMissle);
    }

}
