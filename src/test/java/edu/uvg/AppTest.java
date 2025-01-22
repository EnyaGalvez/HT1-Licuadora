package edu.uvg;

import org.junit.Test;
import static org.junit.Assert.*;

public class AppTest {

    @Test
    public void testSwitchPowerStatus() {
        Blender blender = new Blender(2000);
        assertEquals(0, blender.checkPowerStatus());
        blender.switchPowerStatus();
        assertEquals(1, blender.checkPowerStatus());
    }

    @Test
    public void testFillBlender() {
        Blender blender = new Blender(2000);
        blender.switchPowerStatus();
        blender.fillBlender("Water", 1500);
        assertEquals(1500, blender.actualCapacity());
        assertFalse(blender.isFull());
    }

    @Test
    public void testSpeedControl() {
        Blender blender = new Blender(2000);
        blender.switchPowerStatus();
        blender.increaseSpeed();
        assertEquals(1, blender.checkSpeed());
        blender.decreaseSpeed();
        assertEquals(0, blender.checkSpeed());
    }
}
