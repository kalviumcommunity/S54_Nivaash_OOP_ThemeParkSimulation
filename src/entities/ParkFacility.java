package entities;

public class ParkFacility {
    private String type;
    private String name;

    public ParkFacility(String type, String name) {
        this.type = type;
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public String getFacilityName() {
        return name;
    }

    @Override
    public String toString() {
        return "Facility Type: " + type + ", Name: " + name;
    }
}
