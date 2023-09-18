package org.example.office_control;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Office {
    private List<Room> rooms = new ArrayList<>();

    public List<Room> getRooms() {
        return rooms;
    }

    private Map<String, Integer> countAllDevices() {
        Map<String, Integer> result = new HashMap<>();
        for (Room room : this.rooms) {
            for (Device device : room.getDevices()) {
                if (result.containsKey(device.getType())) {
                    result.put(device.getType(), result.get(device.getType()) + 1);
                } else {
                    result.put(device.getType(), 1);
                }
            }
        }
        return result;
    }

    public void printListAllDevices() {
        System.out.println("Всего устройств в офисе:");
        Map<String, Integer> countAllDevices = countAllDevices();
        for (Map.Entry<String, Integer> stringIntegerEntry : countAllDevices.entrySet()) {
            System.out.printf("%s: %dшт%n", stringIntegerEntry.getKey(), stringIntegerEntry.getValue());
        }
    }
}
