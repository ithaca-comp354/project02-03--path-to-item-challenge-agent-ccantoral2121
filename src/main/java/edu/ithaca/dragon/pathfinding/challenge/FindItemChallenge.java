package edu.ithaca.dragon.pathfinding.challenge;

import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.pathfinder.LocalPathFinder;

public class FindItemChallenge {

    private AreaGrid grid;
    private Location itemLocation;
    private FindItemParticpant participant;
    private long steps;

    public FindItemChallenge(LocalPathFinder pathFinder){
        this(pathFinder, AreaGridFactory.createPerfectMaze(21, 21));
    }
    
    public FindItemChallenge(LocalPathFinder pathFinder, AreaGrid grid){
        this.grid = new AreaGrid(grid.gridCopy());
        itemLocation = grid.pickRandomOpenLocation();
        participant = new FindItemParticpant(grid.pickRandomOpenLocation(), pathFinder);
        steps=0;
    }
    
    public void challengeStep(){
        Location chosenMove = participant.chooseMove(grid.createLocalSensor(participant.getLocation()));
        if (grid.isOpenNeighbor(participant.getLocation(), chosenMove)){
            participant.setLocation(chosenMove);
        }
        steps++;
    }

    public void completeChallenge(boolean displaySteps){
        while(!challengeCompleted()){
            challengeStep();
            if (displaySteps){
                System.out.println(steps);
                System.out.println(createDisplayString());
            }
        }
    }

    public boolean challengeCompleted(){
        return participant.getLocation().equals(itemLocation);
    }

    public String createDisplayString() {
        String gridDisplay = "";
        for (List<Location> row: grid.gridCopy()){
            for (Location location : row) {
                if (location.equals(participant.getLocation())){
                    gridDisplay += "*";
                }
                else if (location.equals(itemLocation)){
                    gridDisplay += "x";
                }
                else {
                    gridDisplay += location.buildDisplayString();
                }
            }
            gridDisplay += "\n";
        }
        return gridDisplay;
    }

    public long getSteps(){
        return steps;
    }
    
}
