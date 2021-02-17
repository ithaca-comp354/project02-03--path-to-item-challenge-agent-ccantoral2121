package edu.ithaca.dragon.pathfinding.pathfinder;

import edu.ithaca.dragon.pathfinding.areagrid.Location;

public interface LocalPathFinder {

    Location chooseMove(LocalSensor localSensor);
}
