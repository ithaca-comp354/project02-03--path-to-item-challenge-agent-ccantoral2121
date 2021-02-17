package edu.ithaca.dragon.pathfinding.pathfinder;

import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.Location;

public class LocalSensor {
    
    private Location currentLocation;
    private List<Location> surroundingLocations;

    public LocalSensor(Location currentLocation, List<Location> surroundingLocations) {
        this.currentLocation = currentLocation;
        this.surroundingLocations = surroundingLocations;
    }

    public Location currentLocation() {
        return currentLocation;
    }

    public List<Location> surroundingLocations() {
        return surroundingLocations;
    }
}
