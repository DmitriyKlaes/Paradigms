package org.example.office_control;

public class Lamp extends Device{
    private String type;

    public Lamp() {
        super();
        this.type = "Лампа";
    }

    @Override
    public void switchDevice() {
        this.status = !status;
        System.out.println((status) ? "Лампа включена" : "Лампа выключена");
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
