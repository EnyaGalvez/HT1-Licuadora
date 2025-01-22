package edu.uvg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class AppTest {
    @Test
    void testSwitchPowerStatus() {
        Blender blender = new Blender(2000);
        assertEquals(0, blender.checkPowerStatus());
        blender.switchPowerStatus();
        assertEquals(1, blender.checkPowerStatus());
    }

    @Test
    void testFillBlender() {
        Blender blender = new Blender(2000);
        blender.switchPowerStatus();
        blender.fillBlender("Water", 1500);
        assertEquals(1500, blender.actualCapacity());
        assertTrue(blender.isFull());
    }

    @Test
    void testSpeedControl() {
        Blender blender = new Blender(2000);
        blender.switchPowerStatus();
        blender.increaseSpeed();
        assertEquals(1, blender.checkSpeed());
        blender.decreaseSpeed();
        assertEquals(0, blender.checkSpeed());
    }
}
