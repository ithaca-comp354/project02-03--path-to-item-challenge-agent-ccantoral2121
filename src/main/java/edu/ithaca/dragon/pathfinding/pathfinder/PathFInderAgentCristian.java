package edu.ithaca.dragon.pathfinding.pathfinder;

import java.net.SocketImpl;
import java.util.ArrayList;
import java.util.Currency;
import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.Location;

public class PathFInderAgentCristian implements GlobalPathFinder {

    List<Location> locationsToFindItem = new ArrayList<>();
    List<Location> surrondings = new ArrayList<>();
    List<Location> allOpenLocations = new ArrayList<>();
    //Location currentLocation = null;
 

    @Override
    public List<Location> findPath(AreaGrid map, Location start, Location goal) {
        // TODO Auto-generated method stub



            for(int x = 0; x < map.getRowCount();x++){
                for(int y = 0; y < map.getColumnCount(); y++){

                    Location checkLocation = map.gridCopy().get(x).get(y);

                    if(!checkLocation.isWall()){
                        allOpenLocations.add(map.gridCopy().get(x).get(y));
                    }


                }
            }
                    

        return allOpenLocations;
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




