package edu.uvg;

public class Blender {
    private boolean powerStatus;
    private String producto;
    private float capacidad;
    private float capacidadMax;
    private byte velocidad;
    private byte velocidadMin;
    private byte velocidadMax;

    @Override
    public byte checkPowerStatus() {
        return (byte) (powerStatus ? 1 : 0);
    }

    @Override
    public byte switchPowerStatus() {
        powerStatus = !powerStatus;
        velocidad = 0; // Causa que se reinicie a 0 la velocidad de la licuadora cuando esta se encienda
        return checkPowerStatus();
    }

    @Override
    public void fillBlender(String prod, float ml) {
        if (capacidad + ml <= capacidadMax) {
            producto = prod;
            capacidad += ml;
            return "Blender filled with: " + prod + " (" + ml + " ml)";
        } else {
            return "Not enough space to fill the blender with that amount.";
        }
    }

    @Override
    public void fillBlender(String prod) {
        fillBlender(prod, capacidadMax - capacidad);
    }

    @Override
    public int actualCapacity() {
        return (int) capacidad;
    }

    public String increaseSpeed() {
        if (!powerStatus) {
            return "Blender is off. Turn it on to change speed.";
        }
        if (velocidad < 10) {
            velocidad++;
            return "Speed increased to: " + velocidad;
        } else {
            return "Speed is already at maximum.";
        }
    }

    public String decreaseSpeed() {
        if (!powerStatus) {
            return "Blender is off. Turn it on to change speed.";
        }
        if (velocidad > 0) {
            velocidad--;
            return "Speed decreased to: " + velocidad;
        } else {
            return "Speed is already at minimum.";
        }
    }

    public byte checkSpeed() {
        return velocidad;
    }

    public boolean isFull() {
        return capacidad >= capacidadMax;
    }

    public String emptyBlender() {
        producto = "";
        capacidad = 0;
        velocidad = 0;
        return "Blender is now empty.";
    }

    public String emptyBlender(float ml) {
        if (capacidad >= ml) {
            capacidad -= ml;
            return "Removed " + ml + " ml from the blender.";
        } else {
            return "Not enough content to remove " + ml + " ml.";
        }
    }
}
