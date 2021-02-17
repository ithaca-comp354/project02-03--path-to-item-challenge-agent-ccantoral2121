package edu.ithaca.dragon.pathfinding.challenge;

import org.junit.jupiter.api.Test;

import edu.ithaca.dragon.pathfinding.pathfinder.RandomPathFinder;

public class FindItemChallengeTest {
    
    @Test
    public void findItemChallengeTest(){
        FindItemChallenge challenge = new FindItemChallenge(new RandomPathFinder());
        challenge.completeChallenge(true);
        
    }
}
