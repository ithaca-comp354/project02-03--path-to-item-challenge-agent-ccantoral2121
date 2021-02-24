package edu.ithaca.dragon.pathfinding.pathfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.challenge.PathToItemChallenge;

public class BreadthFirstAgent implements GlobalPathFinder {

    private Queue <List<Location>> possPaths;
    private List <Location> vLoc; 
    public List<Location> findPath(AreaGrid map, Location start, Location goal) {

        Scanner scan = new Scanner(System.in);
        Location current = start; 
        while (current != goal){
            LocalSensor localSensor = map.createLocalSensor(start);
            vLoc.add(localSensor.currentLocation());
            for (int i = 0; i < localSensor.surroundingLocations().size(); i++) {
                List<Location> newPath = new ArrayList <>(vLoc);
                newPath.add(localSensor.surroundingLocations().get(i));
                if(localSensor.surroundingLocations().get(i).equals(goal)){
                    possPaths.add(newPath);
                    break;
                }

            }
            int steps = possPaths.peek().size();
            vLoc = possPaths.remove();
            current = vLoc.get(steps - 1);
            
            System.out.println(PathToItemChallenge.createDisplayString(Arrays.asList(vLoc), "x", map, start, goal));
            System.out.println("Enter to continue: ");
            scan.nextLine();
        }
        for (int i = 0; i < possPaths.size(); i++) {
            possPaths.remove();
        }
        
        return possPaths.remove();
    }
}