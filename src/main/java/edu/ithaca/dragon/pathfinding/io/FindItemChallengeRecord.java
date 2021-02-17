package edu.ithaca.dragon.pathfinding.io;

import edu.ithaca.dragon.pathfinding.areagrid.Location;

public class FindItemChallengeRecord {
    private AreaGridRecord gridRecord;
    private Location itemLocation;
    private Location startingPoint;

    public FindItemChallengeRecord() {
    }

    public AreaGridRecord getGridRecord() {
        return gridRecord;
    }

    public void setGridRecord(AreaGridRecord gridRecord) {
        this.gridRecord = gridRecord;
    }

    public Location getItemLocation() {
        return itemLocation;
    }

    public void setItemLocation(Location itemLocation) {
        this.itemLocation = itemLocation;
    }

    public Location getStartingPoint() {
        return startingPoint;
    }

    public void setStartingPoint(Location startingPoint) {
        this.startingPoint = startingPoint;
    }

}
