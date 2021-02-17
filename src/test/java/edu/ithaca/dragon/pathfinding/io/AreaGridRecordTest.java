package edu.ithaca.dragon.pathfinding.io;

import java.io.IOException;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGrid;
import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;
import edu.ithaca.dragon.util.JsonUtil;

public class AreaGridRecordTest {

    @Test
    public void toAndFromJsonTest() throws IOException {
        JsonUtil.toJsonFile("src/test/resources/15x11ExampleGrid.json", new AreaGridRecord(AreaGridFactory.createPerfectMaze(15, 11).gridCopy()));
        System.out.println(new AreaGrid(JsonUtil.fromJsonFile("src/test/resources/15x11ExampleGrid.json", AreaGridRecord.class).getGrid()).createDisplayString());
    }
}
