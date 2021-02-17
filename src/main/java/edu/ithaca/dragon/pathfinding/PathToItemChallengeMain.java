package edu.ithaca.dragon.pathfinding;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;
import edu.ithaca.dragon.pathfinding.areagrid.Location;
import edu.ithaca.dragon.pathfinding.challenge.PathToItemChallenge;
import edu.ithaca.dragon.pathfinding.io.AreaGridRecord;
import edu.ithaca.dragon.pathfinding.pathfinder.GlobalPathFinder;
import edu.ithaca.dragon.util.JsonUtil;

public class PathToItemChallengeMain {

    public static void main(String[] args) throws IOException {
        List<GlobalPathFinder> pathFinders = Arrays.asList(new <yourGlobalPathFinder>);
        AreaGrid areaGrid = AreaGridFactory.createPerfectMaze(19, 25);
        JsonUtil.toJsonFile("src/test/resources/PerfectMazeExampleGrid.json", new AreaGridRecord(areaGrid.gridCopy()));
        System.out.println(areaGrid.createDisplayString());
        System.out.println(PathToItemChallenge.pathToItemChallenge(pathFinders, areaGrid));
    }
}
