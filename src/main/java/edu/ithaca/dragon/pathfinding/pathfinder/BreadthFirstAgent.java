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
    List<Location> surrondings = new ArrayList<Location>();

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
            current = currentPath.get(currentPath.size()-1);
            vLoc.add(current);
            if (current.equals(goal)){
                return currentPath;
            }
            surrondings = noWalls(map.createLocalSensor(current).surroundingLocations());
            //enqueue all its adjacent nodes into a queue
            for (int i = 0; i < surrondings.size(); i++) {
                if (!(vLoc.contains(surrondings.get(i)))){
                    List <Location> copyPath = new ArrayList<>(currentPath);
                    current = surrondings.get(i);
                    copyPath.add(current);
                    possPaths.add(copyPath);
                }
            }
        
            System.out.println(PathToItemChallenge.createDisplayString(Arrays.asList(vLoc), "x", map, start, goal));
            System.out.println("Enter to continue: ");
            new Scanner(System.in).nextLine();

        }

        for (int i = 0; i < possPaths.size(); i++) {
            possPaths.remove();
        }
        
        return possPaths.remove();
    














        /* Location current = start; 
        while (current != goal){
            LocalSensor localSensor = map.createLocalSensor(start);
            vLoc.add(localSensor.currentLocation());
            current = localSensor.currentLocation();
            for (int i = 0; i < localSensor.surroundingLocations().size(); i++) {
                if((!vLoc.contains(current.get(i))) && (!localSensor.surroundingLocations().get(i).isWall())){
                    List <Location> newPath = new ArrayList<>(vLoc);
                    newPath.add(localSensor.surroundingLocations().get(i));
                    if(localSensor.surroundingLocations().get(i).equals(goal)){
                        possPaths.add(newPath);
                        break;
                    }
                    possPaths.add(newPath);
                }
            }

            int steps = possPaths.size();
            vLoc = possPaths.remove();
            current = vLoc.get(steps - 1);
            
            System.out.println(PathToItemChallenge.createDisplayString(Arrays.asList(vLoc), "x", map, start, goal));
            System.out.println("Enter to continue: ");
            new Scanner(System.in).nextLine();

        }

        for (int i = 0; i < possPaths.size(); i++) {
            possPaths.remove();
        }
        
        return possPaths.remove(); */
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