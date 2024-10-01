package management;

import entities.Ride;
import java.util.LinkedList;
import java.util.Queue;

public class RideQueue {
    private Ride ride;
    private Queue<String> queue;

    public RideQueue(Ride ride) {
        this.ride = ride;
        this.queue = new LinkedList<>();
    }

    public void addVisitorToQueue(String visitorName) {
        if (queue.size() < ride.getCapacity()) {
            queue.offer(visitorName);
            System.out.println(visitorName + " has been added to the queue for " + ride.getRideName());
        } else {
            System.out.println("The queue for " + ride.getRideName() + " is full.");
        }
    }

    public String serveNextVisitor() {
        return queue.poll();
    }
}
