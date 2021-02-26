package edu.ithaca.dragon.pathfinding.pathfinder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.challenge.PathToItemChallenge;

public class DepthFirstAgent implements GlobalPathFinder {

    List<Location> locationsVisited = new ArrayList<Location>();
    Stack<Location> stack = new Stack();
    Location curreLocation = new Location();
    List<Location> surrondings = new ArrayList<Location>();

    @Override
    public List<Location> findPath(AreaGrid map, Location start, Location goal) {
        
        stack.push(start);

        while(!stack.empty()){
            
            curreLocation = stack.pop();
            if(!locationsVisited.contains(curreLocation)){
                
                if(curreLocation.equals(goal)){
                    return locationsVisited;
                }
               
                surrondings = noWalls(map.createLocalSensor(curreLocation).surroundingLocations());
                
                for(int x = 0; x < surrondings.size(); x++){


                    //improvement from stack.push() only 
                    if(!locationsVisited.contains(surrondings.get(x))){
                        stack.push(surrondings.get(x));
                    }
                      
                    //stack.push(surrondings.get(x));
                }

                locationsVisited.add(curreLocation);

            }

          

            surrondings.clear();

            // System.out.println(PathToItemChallenge.createDisplayString(Arrays.asList(locationsVisited), "x", map, start, goal));
            // System.out.print("Enter to continue:");
            // new Scanner(System.in).nextLine();
    



        }

        return locationsVisited;
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