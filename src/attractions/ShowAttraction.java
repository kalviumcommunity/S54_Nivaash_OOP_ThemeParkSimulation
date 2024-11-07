package attractions;

public class ShowAttraction extends ParkAttraction {
    private int duration; // Show duration in minutes
    private int seatingCapacity;
    private double ticketPrice;
    private int showsPerformed;
    private double totalRevenue;

    public ShowAttraction(String name, int duration, int seatingCapacity, double ticketPrice) {
        super(name); // Call to the parent constructor
        this.duration = duration;
        this.seatingCapacity = seatingCapacity;
        this.ticketPrice = ticketPrice;
        this.showsPerformed = 0;
        this.totalRevenue = 0;
    }

    @Override
    public void operate() {
        if (open) {
            int attendees = seatingCapacity; // Assume the show is fully attended
            double showRevenue = attendees * ticketPrice;
            totalRevenue += showRevenue;
            showsPerformed++;
            System.out.println("Show " + name + " performed for " + attendees + " attendees, generating revenue of " + showRevenue);
        } else {
            System.out.println("Show " + name + " is closed.");
        }
    }

    public double getTotalRevenue() {
        return totalRevenue;
    }

    @Override
    public String toString() {
        return super.toString() + ", Duration: " + duration + " mins, Total Revenue: " + totalRevenue;
    }
}
