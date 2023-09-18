package org.example.office_control;

public abstract class Device {
    private static int counter = 0;
    protected boolean status;
    protected int id;

    public Device() {
        this.status = false;
        this.id = ++counter;
    }

    public boolean isStatus() {
        return status;
    }

    public abstract void switchDevice();

    public abstract String getType();

}
