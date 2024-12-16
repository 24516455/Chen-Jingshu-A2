package org.example;
import java.util.*;

interface RideInterface {
    void addVisitorToQueue(Visitor visitor);
    void removeVisitorFromQueue(Visitor visitor);
    void printQueue();
    void runOneCycle();
    void addVisitorToHistory(Visitor visitor);
    boolean checkVisitorFromHistory(Visitor visitor);
    int numberOfVisitors();
    void printRideHistory();
}

class Ride implements RideInterface {
    private String rideName;
    private Employee rideOperator;
    private Queue<Visitor> queue = new LinkedList<>();

    public List<Visitor> getRideHistory() {
        return rideHistory;
    }

    public void setRideHistory(List<Visitor> rideHistory) {
        this.rideHistory = rideHistory;
    }

    private List<Visitor> rideHistory = new LinkedList<>();
    private int maxRider = 5; // 每次最多接待5个游客
    private int numOfCycles = 0;

    public Ride(String rideName, Employee rideOperator) {
        this.rideName = rideName;
        this.rideOperator = rideOperator;
    }

    public String getRideName() {
        return rideName;
    }

    public Queue<Visitor> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Visitor> queue) {
        this.queue = queue;
    }

    public Employee getRideOperator() {
        return rideOperator;
    }

    @Override
    public void addVisitorToQueue(Visitor visitor) {
        queue.offer(visitor);
        System.out.println(visitor.getName() + " has joined the queue for " + rideName);
    }

    @Override
    public void removeVisitorFromQueue(Visitor visitor) {
        if (queue.remove(visitor)) {
            System.out.println(visitor.getName() + " has been removed from the queue.");
        } else {
            System.out.println("Visitor not found in the queue.");
        }
    }

    @Override
    public void printQueue() {
        System.out.println("Queue for " + rideName + ":");
        for (Visitor visitor : queue) {
            System.out.println(visitor.getName() + " (" + visitor.getTicketType() + ")");
        }
    }

    @Override
    public void runOneCycle() {
        if (rideOperator == null) {
            System.out.println("No ride operator assigned. Cannot run the ride.");
            return;
        }

        if (queue.isEmpty()) {
            System.out.println("No visitors in the queue.");
            return;
        }

        System.out.println("Running one cycle of " + rideName);
        int riders = 0;

        while (!queue.isEmpty() && riders < maxRider) {
            Visitor visitor = queue.poll();
            addVisitorToHistory(visitor);
            riders++;
        }
        numOfCycles++;
    }

    @Override
    public void addVisitorToHistory(Visitor visitor) {
        rideHistory.add(visitor);
        System.out.println(visitor.getName() + " has completed the ride.");
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        return rideHistory.contains(visitor);
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        System.out.println("History for " + rideName + ":");
        for (Visitor visitor : rideHistory) {
            System.out.println(visitor.getName() + " (" + visitor.getTicketType() + ")");
        }
    }
}
