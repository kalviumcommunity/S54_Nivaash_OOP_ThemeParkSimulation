package management;

import attractions.ParkAttraction;
import java.util.ArrayList;
import java.util.List;

public class AttractionManager {
    private List<ParkAttraction> attractions;

    public AttractionManager() {
        this.attractions = new ArrayList<>();
    }

    public void addAttraction(ParkAttraction attraction) {
        attractions.add(attraction);
        System.out.println("Attraction added: " + attraction.getName());
    }

    public List<ParkAttraction> getAttractions() {
        return attractions;
    }

    public void displayAttractions() {
        System.out.println("Attractions in the Park:");
        for (ParkAttraction attraction : attractions) {
            System.out.println(attraction);
        }
    }
}


