package org.example;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.io.*;

public class AssignmentTwo {
    public static void main(String[] args) {
        partThree();
        partFourA();
        partFourB();
        partFive();
        partSix();
        partSeven();
    }

    // Part 3 - Queue Interface
    public static void partThree() {
        Employee operator = new Employee("Jack", 30, "Male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", operator);

        Visitor v1 = new Visitor("Andy", 25, "Female", "V001", "Regular");
        Visitor v2 = new Visitor("Jasson", 30, "Male", "V002", "VIP");
        Visitor v3 = new Visitor("Juliet", 22, "Male", "V003", "Regular");
        Visitor v4 = new Visitor("Chen Jingshu", 27, "Male", "V004", "VIP");
        Visitor v5 = new Visitor("Wang Xuhe", 29, "Female", "V005", "Regular");

        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        rollerCoaster.printQueue();
        rollerCoaster.removeVisitorFromQueue(v3);
        rollerCoaster.printQueue();
    }

    // Part 4A - LinkedList Collection
    public static void partFourA() {
        Employee operator = new Employee("Jack", 30, "Male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", operator);

        Visitor v1 = new Visitor("Andy", 25, "Female", "V001", "Regular");
        Visitor v2 = new Visitor("Jasson", 30, "Male", "V002", "VIP");
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);

        rollerCoaster.runOneCycle();

        rollerCoaster.printRideHistory();
        System.out.println("Number of visitors in history: " + rollerCoaster.numberOfVisitors());
    }

    // Part 4B - 排序集合
    public static void partFourB() {
        Employee operator = new Employee("Jack", 30, "Male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", operator);

        // 创建一些游客
        Visitor v1 = new Visitor("Andy", 25, "Female", "V001", "Regular");
        Visitor v2 = new Visitor("Jasson", 30, "Male", "V002", "VIP");
        Visitor v3 = new Visitor("Juliet", 22, "Male", "V003", "Regular");
        Visitor v4 = new Visitor("Chen Jingshu", 27, "Male", "V004", "VIP");
        Visitor v5 = new Visitor("Wang Xuhe", 29, "Female", "V005", "Regular");

        // 将游客添加到队列中
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 打印排序前的队列
        System.out.println("Queue before sorting:");
        rollerCoaster.printQueue();

        // 按游客姓名排序队列
        List<Visitor> sortedQueue = new ArrayList<>(rollerCoaster.getQueue());
        sortedQueue.sort(Comparator.comparing(Visitor::getName));

        // 打印排序后的队列
        System.out.println("Queue after sorting:");
        for (Visitor visitor : sortedQueue) {
            System.out.println(visitor.getName() + " (" + visitor.getTicketType() + ")");
        }
    }

    // Part 5 - 运行一个游乐设施周期
    public static void partFive() {
        Employee operator = new Employee("Jack", 30, "Male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", operator);

        // 创建一些游客
        Visitor v1 = new Visitor("Andy", 25, "Female", "V001", "Regular");
        Visitor v2 = new Visitor("Jasson", 30, "Male", "V002", "VIP");
        Visitor v3 = new Visitor("Juliet", 22, "Male", "V003", "Regular");
        Visitor v4 = new Visitor("Chen Jingshu", 27, "Male", "V004", "VIP");
        Visitor v5 = new Visitor("Wang Xuhe", 29, "Female", "V005", "Regular");

        // 将游客添加到队列中
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);
        rollerCoaster.addVisitorToQueue(v4);
        rollerCoaster.addVisitorToQueue(v5);

        // 运行第一个周期
        System.out.println("Running cycle 1...");
        rollerCoaster.runOneCycle();
        rollerCoaster.printRideHistory();
        System.out.println("Number of visitors after cycle 1: " + rollerCoaster.numberOfVisitors());

        // 运行第二个周期
        System.out.println("Running cycle 2...");
        rollerCoaster.runOneCycle();
        rollerCoaster.printRideHistory();
        System.out.println("Number of visitors after cycle 2: " + rollerCoaster.numberOfVisitors());
    }

    // Part 6 - 导出数据到文件

    public static void partSix() {
        Employee operator = new Employee("Jack", 30, "Male", "E001", "Operator");
        Ride rollerCoaster = new Ride("Roller Coaster", operator);

        // 创建一些游客
        Visitor v1 = new Visitor("Andy", 25, "Female", "V001", "Regular");
        Visitor v2 = new Visitor("Jasson", 30, "Male", "V002", "VIP");
        Visitor v3 = new Visitor("Juliet", 22, "Male", "V003", "Regular");

        // 将游客添加到队列
        rollerCoaster.addVisitorToQueue(v1);
        rollerCoaster.addVisitorToQueue(v2);
        rollerCoaster.addVisitorToQueue(v3);

        // 运行一个周期并将游客加入历史记录
        rollerCoaster.runOneCycle();

        // 写入数据到文件
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("rideHistory.txt"))) {
            for (Visitor visitor : rollerCoaster.getRideHistory()) {
                writer.write("Visitor: " + visitor.getName() + ", Ticket: " + visitor.getTicketType());
                writer.newLine();
            }
            System.out.println("Data has been written to rideHistory.txt");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }
    }

    // Part 7 - Reading from a file
    public static void partSeven() {
        try (BufferedReader reader = new BufferedReader(new FileReader("rideHistory.txt"))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading from file: " + e.getMessage());
        }
    }
}
