package org.example.office_control;

public class Printer extends Device {
    private String type;

    public Printer() {
        super();
        this.type = "Принтер";
    }

    @Override
    public void switchDevice() {
        this.status = !status;
        System.out.println((status) ? "Принтер включен" : "Принтер выключен");
    }

    @Override
    public String getType() {
        return type;
    }

    @Override
    public String toString() {
        return  "Тип='" + type + '\'' +
                ", status=" + ((status) ? "Вкл" : "Откл") +
                ", id=" + id;
    }
}
