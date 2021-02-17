package edu.ithaca.dragon.pathfinding.io;

import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.Location;

public class AreaGridRecord {
    private List<List<Location>> grid;

    public AreaGridRecord(List<List<Location>> grid){
        this.grid = grid;
    }

    public AreaGridRecord(){
        grid = null;
    }

    public List<List<Location>> getGrid(){
        return grid;
    }

    public void setGrid(List<List<Location>> grid){
        this.grid = grid;
    }
    
}
