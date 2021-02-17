package edu.ithaca.dragon.pathfinding.pathfinder;

import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.Location;

public interface GlobalPathFinder { 
    /**
     * @param map a copy of the AreaGrid on in which to find a path
     * @returns a list of locations that form a valid path from start to goal
     */  
    List<Location> findPath(AreaGrid map, Location start, Location goal);
}
