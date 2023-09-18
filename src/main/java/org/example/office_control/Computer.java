package org.example.office_control;

public class Computer extends Device{

    private String type;

    public Computer() {
        super();
        this.type = "Компьютер";
    }

    @Override
    public void switchDevice() {
        this.status = !status;
        System.out.println((status) ? "Компьютер включен" : "Компьютер выключен");
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
