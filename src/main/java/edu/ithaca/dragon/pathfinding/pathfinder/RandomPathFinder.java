package edu.ithaca.dragon.pathfinding.pathfinder;

import java.util.Random;

import edu.ithaca.dragon.pathfinding.areagrid.Location;

public class RandomPathFinder implements LocalPathFinder {
    Random random = new Random();

    @Override
    public Location chooseMove(LocalSensor localSensor) {
        return localSensor.surroundingLocations().get(random.nextInt(localSensor.surroundingLocations().size()));
    }
    
}
