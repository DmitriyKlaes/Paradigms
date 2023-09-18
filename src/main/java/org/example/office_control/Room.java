package org.example.office_control;

import java.util.ArrayList;
import java.util.List;

public class Room {

    private static int counter = 0;
    private int roomNumber;
    private List<Device> devices = new ArrayList<>();

    {
        roomNumber = ++counter;
    }

    public List<Device> getDevices() {
        return devices;
    }

    public void addDevice (Device device) {
        devices.add(device);
        System.out.printf("Устройство \"%s\" добавлено в комнату №%d%n", device.getType(), this.roomNumber);
    }

    public void switchDevice (Device device) {
        for (Device deviceInRoom : devices) {
            if (deviceInRoom.id == device.id) {
                deviceInRoom.switchDevice();
                break;
            }
        }
        System.out.println("Устройство не найдено");
    }

    public List<Device> findDevice (String type) {
        List<Device> result = new ArrayList<>();
        for (Device device : this.devices) {
            if (device.getType().equals(type)) {
                result.add(device);
            }
        }
        if (result.size() == 0) {
            System.out.println("Таких устройств в данной комнате нет!");
            return null;
        }
        return result;
    }

    public List<Device> findDevice (boolean switchStatus) {
        List<Device> result = new ArrayList<>();
        for (Device device : this.devices) {
            if (device.status == switchStatus) {
                result.add(device);
            }
        }
        if (result.size() == 0) {
            System.out.println("Таких устройств в данной комнате нет!");
            return null;
        }
        return result;
    }

    public List<Device> findDevice (String type, boolean switchStatus) {
        List<Device> result = new ArrayList<>();
        for (Device device : this.devices) {
            if (device.getType().equals(type) && device.status == switchStatus) {
                result.add(device);
            }
        }
        if (result.size() == 0) {
            System.out.println("Таких устройств в данной комнате нет!");
            return null;
        }
        return result;
    }
}
