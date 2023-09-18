package org.example;

import org.example.office_control.*;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        /*
        ● Условие
        На вход подается число n.
        ● Задача
        Написать скрипт в любой парадигме, который выводит на экран таблицу умножения всех чисел от 1 до n.
        Обоснуйте выбор парадигм.
        ● Пример вывода:
        1 * 1 = 1
        1 * 2 = 2
        1 * 3 = 3
        1 * 4 = 4
        1 * 5 = 5
        1 * 6 = 6
        ..
        1 * 9 = 9

        Пишу в процедурной парадигме, что бы переиспользовать этот код много раз.
        */
        multiplicationTable(5);


        /*
        Задача 2
        __
        Допустим, у нас есть задача по обработке данных о студентах в университете. У нас есть следующие данные:
        __
        Список студентов с их именами и оценками.
        Нам нужно найти средний балл по всем студентам и вывести имена студентов, чей балл выше среднего.
        Сделать 2 варианта решения , т е Реализация структурного программирования и процедурного программирования

        Список студентов
        student_data = [
        {'name': 'Alice', 'score': 85},
        {'name': 'Bob', 'score': 92},
        {'name': 'Charlie', 'score': 78},
        {'name': 'David', 'score': 95},
        ]
        __
        print(f"Средний балл: {average}")
        print(f"Студенты с баллом выше среднего: {above_average_students}")
        */

        Student[] studentData = {new Student("Alice", 85),
                                 new Student("Bob", 92),
                                 new Student("Charlie", 78),
                                 new Student("David", 95)};

        //Структурный подход:

        int average;
        int tempSum = 0;
        List<Student> aboveAverageStudents = new ArrayList<>();

        for (Student student : studentData) {
            tempSum += student.score;
        }
        average = tempSum / studentData.length;

        for (Student student : studentData) {
            if (student.score > average) {
                aboveAverageStudents.add(student);
            }
        }

        System.out.println("Средний балл: " +  average);
        System.out.println("Студенты с баллом выше среднего: ");
        for (Student aboveAverageStudent : aboveAverageStudents) {
            System.out.println(aboveAverageStudent);
        }


        //Процедурный подход

        int averageP = getAverage(studentData);
        List<Student> averageStudents = getAverageStudents(studentData, averageP);
        System.out.println("Средний балл: " +  averageP);
        System.out.println("Студенты с баллом выше среднего: ");
        printList(averageStudents);


        /*
        Задача 2
        __
        Мы разрабатываем систему управления ресурсами в офисе.
        У нас есть несколько комнат, в каждой из которых размещены разные устройства
        (компьютеры, принтеры, лампы и т. д.).
        Каждое устройство имеет следующие характеристики:
        тип (компьютер, принтер, лампа и т. д.),
        статус (включено или выключено),
        идентификатор.
        __
        Мы хотим выполнить следующие операции:
        __
        Добавить новое устройство в комнату.
        Включить или выключить устройство в комнате.
        Поиск устройства по типу и статусу.
        Получить список всех устройств в конкретной комнате.
        Подсчитать общее количество устройств каждого типа в офисе.
        */


        Office office = new Office();
        Room room1 = new Room();
        Room room2 = new Room();
        Room room3 = new Room();
        Room room4 = new Room();
        office.getRooms().addAll(List.of(room1, room2, room3, room4));

        Device computerRoom1 = new Computer();
        Device LampRoom1 = new Lamp();
        room1.addDevice(computerRoom1);
        room1.addDevice(LampRoom1);
        Device LampRoom2 = new Lamp();
        Device PrinterRoom2 = new Printer();
        room2.addDevice(LampRoom2);
        room2.addDevice(PrinterRoom2);
        Device computerRoom3 = new Computer();
        Device PrinterRoom3 = new Printer();
        room3.addDevice(computerRoom3);
        room3.addDevice(PrinterRoom3);
        Device computerRoom4 = new Computer();
        Device LampRoom4 = new Lamp();
        Device PrinterRoom4 = new Printer();
        room4.addDevice(computerRoom4);
        room4.addDevice(LampRoom4);
        room4.addDevice(PrinterRoom4);

        computerRoom1.switchDevice();
        LampRoom2.switchDevice();
        computerRoom3.switchDevice();
        computerRoom4.switchDevice();
        PrinterRoom4.switchDevice();

        for (Device device : room1.findDevice("Компьютер")) {
            System.out.println(device);
        }
        for (Device device : room2.findDevice(true)) {
            System.out.println(device);
        }
        for (Device device : room3.findDevice(false)) {
            System.out.println(device);
        }
        for (Device device : room4.findDevice("Компьютер", true)) {
            System.out.println(device);
        }

        System.out.println("Все устройства в 1 комнате:");
        for (Device device : room1.getDevices()) {
            System.out.println(device);
        }
        System.out.println("Все устройства в 2 комнате:");
        for (Device device : room2.getDevices()) {
            System.out.println(device);
        }
        System.out.println("Все устройства в 3 комнате:");
        for (Device device : room3.getDevices()) {
            System.out.println(device);
        }
        System.out.println("Все устройства в 4 комнате:");
        for (Device device : room4.getDevices()) {
            System.out.println(device);
        }

        office.printListAllDevices();
    }

    private static void multiplicationTable(int number) {
        for (int i = 1; i <= number; i++) {
            for (int j = 1; j < 10; j++) {
                System.out.printf("%d * %d = %d%n", i, j, i * j);
            }
            System.out.println("---");
        }
    }

    private static int getAverage(Student[] studentData) {
        int average;
        int tempSum = 0;
        for (Student student : studentData) {
            tempSum += student.score;
        }
        average = tempSum / studentData.length;
        return average;
    }

    private static List<Student> getAverageStudents(Student[] studentData, int average) {
        List<Student> aboveAverageStudents = new ArrayList<>();
        for (Student student : studentData) {
            if (student.score > average) {
                aboveAverageStudents.add(student);
            }
        }
        return aboveAverageStudents;
    }

    private static void printList(List<Student> students) {
        for (Student student : students) {
            System.out.println(student);
        }
    }

}