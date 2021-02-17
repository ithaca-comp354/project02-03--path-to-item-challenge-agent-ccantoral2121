package edu.ithaca.dragon.pathfinding;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.pathfinding.areagrid.AreaGridFactory;

public class AreaGridFactoryTest {

    @Test
    public void creatorTest(){
        System.out.println(AreaGridFactory.createPerfectMaze(41, 11).createDisplayString());
        // System.out.println(AreaGridFactory.createPerfectMaze(5, 15).createDisplayString());
        // System.out.println(AreaGridFactory.createPerfectMaze(101, 31).createDisplayString());


        // System.out.println(AreaGridFactory.createLoopyMaze(11, 11, 0.1).createDisplayString());
        // System.out.println(AreaGridFactory.createLoopyMaze(5, 15, 0.1).createDisplayString());

        // System.out.println(AreaGridFactory.createLoopyMaze(11, 11, 0.5).createDisplayString());
        // System.out.println(AreaGridFactory.createLoopyMaze(5, 15, 0.5).createDisplayString());
        
        // System.out.println(AreaGridFactory.createLoopyMaze(101, 31, 0.1).createDisplayString());
        // System.out.println(AreaGridFactory.createLoopyMaze(101, 31, 0.5).createDisplayString());

    }
    
}
