package attractions;

public abstract class ParkAttraction {
    protected String name;
    protected boolean open;

    public ParkAttraction(String name) {
        this.name = name;
        this.open = true; // Attractions are open by default
    }

    public String getName() {
        return name;
    }

    public boolean isOpen() {
        return open;
    }

    public void close() {
        this.open = false;
    }

    // Abstract method to be overridden by subclasses
    public abstract void operate();  // Virtual function for operating the attraction

    @Override
    public String toString() {
        return "Attraction Name: " + name + " (Open: " + (open ? "Yes" : "No") + ")";
    }
}
