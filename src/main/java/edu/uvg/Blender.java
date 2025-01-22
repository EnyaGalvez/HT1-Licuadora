package edu.uvg;

public class Blender implements IBlender {
    private boolean powerStatus;
    private String producto;
    private float capacidad;
    private float capacidadMax;
    private byte velocidad;

    public Blender(float capacidadMax) {
        this.powerStatus = false;
        this.producto = "";
        this.capacidad = 0;

        this.capacidadMax = capacidadMax;
        this.velocidad = 0;
    }

    @Override
    public byte checkPowerStatus() {
        return (byte) (powerStatus ? 1 : 0);
    }

    @Override
    public byte switchPowerStatus() {
        powerStatus = !powerStatus;
        velocidad = 0; // Resetea la velocidad al apagar/encender
        return checkPowerStatus();
    }

    @Override
    public void fillBlender(String prod, float ml) {
        if (capacidad + ml <= capacidadMax) {
            producto = prod;
            capacidad += ml;
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

    @Override
    public void increaseSpeed() {
        if (powerStatus && velocidad < 10) {
            velocidad++;
        }
    }

    @Override
    public void decreaseSpeed() {
        if (powerStatus && velocidad > 0) {
            velocidad--;
        }
    }

    @Override
    public byte checkSpeed() {
        return velocidad;
    }

    @Override
    public boolean isFull() {
        return capacidad >= capacidadMax;
    }

    @Override
    public void emptyBlender() {
        producto = "";
        capacidad = 0;
        velocidad = 0;
    }

    @Override
    public void emptyBlender(float ml) {
        if (capacidad >= ml) {
            capacidad -= ml;
        }
    }
}
