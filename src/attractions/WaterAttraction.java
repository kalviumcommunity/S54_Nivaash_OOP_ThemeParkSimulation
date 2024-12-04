package attractions;

public class WaterAttraction extends ParkAttraction {
    private int waterVolume; // in liters

    public WaterAttraction(String name, int waterVolume) {
        super(name);
        this.waterVolume = waterVolume;
    }

    @Override
    public void operate() {
        if (open) {
            System.out.println("Water attraction " + name + " is operating with " + waterVolume + " liters of water.");
        } else {
            System.out.println("Water attraction " + name + " is closed.");
        }
    }

    @Override
    public String toString() {
        return super.toString() + ", Water Volume: " + waterVolume + " liters";
    }
}
