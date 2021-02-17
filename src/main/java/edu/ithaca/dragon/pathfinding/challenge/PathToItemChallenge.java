package edu.ithaca.dragon.pathfinding.challenge;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.pathfinder.GlobalPathFinder;

public class PathToItemChallenge {

    public static String pathToItemChallenge(List<GlobalPathFinder> pathFinders){
        return pathToItemChallenge(pathFinders, AreaGridFactory.createPerfectMaze(31, 31));
    }

    public static String pathToItemChallenge(List<GlobalPathFinder> pathFinders, AreaGrid grid){
        return pathToItemChallenge(pathFinders, grid, grid.pickRandomOpenLocation(), grid.pickRandomOpenLocation());
    }
    
    public static String pathToItemChallenge(List<GlobalPathFinder> pathFinders, AreaGrid grid, Location start, Location itemLocation){
        List<PathToItemParticipant> participants = new ArrayList<>();
        for (GlobalPathFinder globalPathFinder : pathFinders){
            try {
                PathToItemParticipant  participant = new PathToItemParticipant(globalPathFinder);
                participant.findPath(new AreaGrid(grid.gridCopy()), new Location(start), new Location(itemLocation));
                participants.add(participant);
            }
            catch (Exception e){
                e.printStackTrace();
            }
        }
        List<List<Location>> paths = new LinkedList<>();
        for(PathToItemParticipant participant : participants){
            paths.add(participant.getPathFound());
        }
        String symbols = "xo#^$%|?";
        return createKey(participants, symbols) + "\n" + createDisplayString(paths, symbols, grid, start, itemLocation);
    }

    public static String createKey(List<PathToItemParticipant> participants, String symbols) {
        if (participants.size() > symbols.length()){
            throw new IllegalArgumentException("Too many participants.");
        }
        else {
            String gridDisplay = "symbol, classname:\t\tpathLen\t\ttime in ms\n";
            for (int i=0; i<participants.size(); i++){
                gridDisplay += symbols.charAt(i) + ", "  + participants.get(i).getName() + ":\t" 
                + participants.get(i).getPathFound().size() +":\t"
                + participants.get(i).getNanosForLastFindPath()/1000 + "\n";
            }
            return gridDisplay;
        }
    }

    public static String createDisplayString(List<List<Location>> paths, String symbols, AreaGrid grid, Location startLocation, Location itemLocation) {
        if (paths.size() > symbols.length()){
            throw new IllegalArgumentException("Too many participants.");
        }
        else {
            String gridDisplay = "";
            for (List<Location> row: grid.gridCopy()){
                for (Location location : row) {
                    boolean noOneHere = true;
                    if (location.equals(itemLocation)){
                        gridDisplay += "*";
                        noOneHere = false;
                    }
                    else if (location.equals(startLocation)){
                        gridDisplay += ".";
                        noOneHere = false;
                    }
                    else {
                        for (int i=0; i<paths.size(); i++){
                            if (paths.get(i).contains(location)){
                                gridDisplay += symbols.charAt(i);
                                noOneHere = false;
                                break;
                            }
                        }
                    }
                    if (noOneHere) {
                        gridDisplay += location.buildDisplayString();
                    }
                }
                gridDisplay += "\n";
            }
            return gridDisplay;
        }
    }
    
}
