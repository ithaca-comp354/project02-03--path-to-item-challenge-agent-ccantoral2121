package edu.ithaca.dragon.pathfinding.areagrid;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import edu.ithaca.dragon.pathfinding.pathfinder.LocalSensor;

public class AreaGrid {
    private static Random random = new Random();

    private List<List<Location>> grid;

    public AreaGrid(List<List<Location>> grid) {
        if (grid.size()< 5 || grid.get(0).size()<5){
            throw new IllegalArgumentException("Grid must be at least 5 in each direction");
        }
        else {
            this.grid = grid;
            grid.size();
            grid.get(0).size();
        }
    }

    public int getRowCount(){
        return grid.size();
    }

    public int getColumnCount(){
        return grid.get(0).size();
    }

    //@returns copies of the location and its surroundings 
    public LocalSensor createLocalSensor(Location location){
        List<Location> refs = new ArrayList<Location>();
        for (GridMove move : GridMove.MAIN_DIRECTIONS) {
            refs.add( grid.get(location.getY() + move.y).get(location.getX() + move.x));
        }
        //add variety to arbitrary algorithms
        Collections.shuffle(refs);
        List<Location> copies = refs.stream().map((neighbor)-> new Location(neighbor)).collect(Collectors.toList());
        return new LocalSensor(new Location(location), copies);
    }
    
    public String createDisplayString() {
        String gridDisplay = "";
        for (List<Location> row: grid){
            for (Location location : row) {
                gridDisplay += location.buildDisplayString();
            }
            gridDisplay += "\n";
        }
        return gridDisplay;
    }

    //Used to create a copy of an AreaGrid (call the contructor along with this method)
    public List<List<Location>> gridCopy(){
        List<List<Location>> copy = new ArrayList<>();
        for (List<Location> row : grid){
            List<Location> rowCopy = new ArrayList<>();
            for (Location location : row) {
                rowCopy.add(new Location(location));
            }
            copy.add(row);
        }
        return copy;
    }

    public boolean isOpenNeighbor(Location current, Location potential){
        for (Location openNeighbor : GridMove.calcOpenMainNeighbors(grid, current, getRowCount(), getColumnCount())){
            if (openNeighbor.equals(potential)){
                return true;
            }
        }
        return false;
    }

    public Location pickRandomOpenLocation(){
        while(true){
            Location randomSpot = grid.get(random.nextInt(getRowCount())).get(random.nextInt(getColumnCount()));
            if (!randomSpot.isWall()){
                return new Location(randomSpot);
            }
        }
    }

}


