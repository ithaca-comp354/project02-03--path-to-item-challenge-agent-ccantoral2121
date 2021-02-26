package edu.ithaca.dragon.pathfinding.pathfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;


import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.challenge.PathToItemChallenge;

public class BreadthFirstAgent implements GlobalPathFinder {

    private Queue <List<Location>> possPaths = new LinkedList<>();
    private List <Location> vLoc = new ArrayList<>(); 
    private List <Location> currentPath = new ArrayList<>();
    private Location current = new Location();
    private List <Location> surrondings = new ArrayList<Location>();

    @Override
    public List<Location> findPath(AreaGrid map, Location start, Location goal) {

        LocalSensor localSensor = map.createLocalSensor(start);
        //adding all possible locations from start to current path list 
        for (int i = 0; i < localSensor.surroundingLocations().size(); i++) { 
            if(!(localSensor.surroundingLocations().get(i).isWall())){
                currentPath.add(localSensor.surroundingLocations().get(i));
            }
        }
        //enqueue current path to possPaths queue
        possPaths.add(currentPath);


        while (!(possPaths.isEmpty())){

            //Dequeue a current path list from the queue, 
            currentPath = possPaths.remove();
            //mark it as visited,
            current = currentPath.get(currentPath.size()-1); //current is a local location variable set to last location in the current path dequeued from possPaths
            //while the location you are currently at has been visited, keep getting a new path from possPaths until you are at a location you never been before  
            while(vLoc.contains(current)){
                currentPath = possPaths.remove();
                current = currentPath.get(currentPath.size()-1);
            }
            vLoc.add(current);
            //System.out.println("current: " + current);
            //System.out.println("goal location: " + goal);
            /* if (current.equals(goal)){
                return currentPath;
            } */
            surrondings = noWalls(map.createLocalSensor(current).surroundingLocations()); // creates list of valid locations to move to 
            //adds all valid locations into a copy path list
            //System.out.println("vLoc: " + vLoc);
            for (int i = 0; i < surrondings.size(); i++) {
                if (!(vLoc.contains(surrondings.get(i)))){
                    if(current.equals(goal)){
                        //System.out.println("current: " + current);
                        return currentPath;
                    }
                    List <Location> copyPath = new ArrayList<>(currentPath);
                    //adding new location to copyPath then enqueuing copyPath to possPaths 
                    current = surrondings.get(i);
                    copyPath.add(current);
                    possPaths.add(copyPath);
                }
            }
            //System.out.println("current Path List:" + currentPath);
            // System.out.println(PathToItemChallenge.createDisplayString(Arrays.asList(vLoc), "x", map, start, goal));
            // System.out.println("Enter to continue: ");
            // new Scanner(System.in).nextLine();

        }

        for (int i = 0; i < possPaths.size(); i++) {
            possPaths.remove();
        }
        
        return possPaths.remove();
    
    }

    public static List<Location> noWalls(List<Location> possibleWays){

        List<Location> noWallsList = new ArrayList<Location>();

        for(int x=0; x < possibleWays.size(); x++){
            if(!possibleWays.get(x).isWall()){
                noWallsList.add(possibleWays.get(x));
            }
        }
        return noWallsList;
    }

}