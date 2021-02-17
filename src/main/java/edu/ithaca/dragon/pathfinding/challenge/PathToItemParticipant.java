package edu.ithaca.dragon.pathfinding.challenge;

import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.pathfinder.GlobalPathFinder;

public class PathToItemParticipant {
    
    private GlobalPathFinder globalPathFinder;
    private List<Location> pathFound;
    private long nanosForLastFindPath;

    public PathToItemParticipant(GlobalPathFinder globalPathFinder) {
        this.globalPathFinder = globalPathFinder;
        this.nanosForLastFindPath = -1;
        pathFound = null;
    }

    public void findPath(AreaGrid map, Location start, Location goal){
        long startTime = System.nanoTime();
        pathFound = globalPathFinder.findPath(map, start, goal);
        nanosForLastFindPath = System.nanoTime() - startTime;
    }

    public List<Location> getPathFound(){
        if (pathFound == null){
            throw new RuntimeException("Can't check path without calling findPath at least once.");
        }
        else {
            return pathFound;
        }
    }

    public long getNanosForLastFindPath(){
        if (nanosForLastFindPath<0){
            throw new RuntimeException("Can't check the time without calling findPath at least once.");
        }
        else {
            return nanosForLastFindPath;
        }
    }

    public String getName(){
        return globalPathFinder.getClass().getSimpleName();
    }

    
    


}
